package hr.com.babic.appexplorer.base;

import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;

import java.lang.ref.WeakReference;

import javax.inject.Inject;
import javax.inject.Named;

import hr.com.babic.appexplorer.cofiguration.ViewActionQueue;
import hr.com.babic.appexplorer.injection.application.module.ThreadingModule;
import hr.com.babic.appexplorer.ui.Router;
import rx.Observable;
import rx.Scheduler;
import rx.Subscription;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.internal.operators.OperatorOnBackpressureBuffer;
import rx.subscriptions.CompositeSubscription;

public abstract class BasePresenter<View extends BaseView> implements ScopedPresenter {

    @Inject
    protected Router router;

    @Inject
    @Named(ThreadingModule.MAIN_SCHEDULER)
    protected Scheduler mainThreadScheduler;

    @Inject
    @Named(ThreadingModule.BACKGROUND_SCHEDULER)
    protected Scheduler backgroundScheduler;

    private final WeakReference<View> viewReference;

    private Subscription viewActionsSubscription;

    protected final ViewActionQueue<View> viewActionQueue = new ViewActionQueue<>();

    private final CompositeSubscription subscriptions = new CompositeSubscription();
    private final CompositeSubscription permissionSubscriptions = new CompositeSubscription();

    public BasePresenter(final View view) {
        viewReference = new WeakReference<>(view);
    }

    @Override
    @CallSuper
    public void start() {

    }

    @Override
    @CallSuper
    public void activate() {
        viewActionsSubscription = viewActionQueue.viewActionsObservable()
                                                 .lift(getViewActionBackPressureStrategy())
                                                 .observeOn(mainThreadScheduler)
                                                 .subscribe(this::onViewAction);
        viewActionQueue.resume();
    }

    protected Observable.Operator<Action1<View>, Action1<View>> getViewActionBackPressureStrategy() {
        return OperatorOnBackpressureBuffer.instance();
    }

    protected void onViewAction(final Action1<View> viewAction) {
        doIfViewNotNull(viewAction);
    }

    @Override
    @CallSuper
    public void deactivate() {
        viewActionQueue.pause();
        viewActionsSubscription.unsubscribe();
        subscriptions.clear();
    }

    @Override
    public void stop() {
        permissionSubscriptions.clear();
    }

    @Override
    @CallSuper
    public void destroy() {
        viewActionQueue.destroy();
        subscriptions.clear();
    }

    @Override
    public void back() {
        router.goBack();
    }

    protected void addSubscription(final Subscription subscription) {
        subscriptions.add(subscription);
    }

    public final void logError(final Throwable throwable) {
        if (!TextUtils.isEmpty(throwable.getMessage())) {
            Log.e(getClass().getSimpleName(), throwable.getMessage(), throwable);
        }
    }

    protected void doIfViewNotNull(final Action1<View> whenViewNotNull) {
        final View view = getNullableView();
        if (view != null) {
            whenViewNotNull.call(view);
        }
    }

    protected <R> R getIfViewNotNull(final Func1<View, R> whenViewNotNull, final R defaultValue) {
        final View view = getNullableView();
        if (view != null) {
            return whenViewNotNull.call(view);
        }
        return defaultValue;
    }

    @Nullable
    protected View getNullableView() {
        return viewReference.get();
    }
}


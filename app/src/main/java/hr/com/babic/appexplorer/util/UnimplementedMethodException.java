package hr.com.babic.appexplorer.util;

public final class UnimplementedMethodException extends RuntimeException {

    public UnimplementedMethodException() {

    }

    public UnimplementedMethodException(final String message) {
        super(message);
    }
}

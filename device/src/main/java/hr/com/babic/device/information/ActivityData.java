package hr.com.babic.device.information;

final class ActivityData {

    public final String activityName;

    public ActivityData(final String activityName) {
        this.activityName = activityName;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ActivityData that = (ActivityData) o;

        return activityName != null ? activityName.equals(that.activityName) : that.activityName == null;

    }

    @Override
    public int hashCode() {
        return activityName != null ? activityName.hashCode() : 0;
    }
}

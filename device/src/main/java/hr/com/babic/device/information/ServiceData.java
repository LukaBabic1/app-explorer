package hr.com.babic.device.information;

final class ServiceData {

    public final String serviceName;

    public ServiceData(final String serviceName) {
        this.serviceName = serviceName;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ServiceData that = (ServiceData) o;

        return serviceName != null ? serviceName.equals(that.serviceName) : that.serviceName == null;
    }

    @Override
    public int hashCode() {
        return serviceName != null ? serviceName.hashCode() : 0;
    }
}

package sb.rxjava.examples.eventdriven.Impl1.dataaccess.server.dto;

public class CustomerRelatedData {

    private long customerId;

    public CustomerRelatedData() {
    }

    public CustomerRelatedData(long customerId) {
        this.customerId = customerId;
    }

    public long getCustomerId() {
        return customerId;
    }
}

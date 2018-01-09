package sb.rxjava.examples.eventdriven.Impl1.dataaccess.server.dto;

public class CustomerZipAccumulator {

    private Customer customer;

    public void addAddress(Address a) {
        customer.addAddress(a);
    }

    public void addOwnedProduct(OwnedProduct p) {
        customer.addOwnedProduct(p);
    }

    public Customer getCustomer() {
        return customer;
    }

    public Customer collapseCustomerEvents(Object[] events) {

        for (Object event : events) {
            if(event instanceof Customer){
                customer = (Customer)event;
            }else if(event instanceof Address){
                customer.addAddress((Address)event);
            }else if(event instanceof OwnedProduct){
                customer.addOwnedProduct((OwnedProduct)event);
            }
        }

        return customer;
    }
}

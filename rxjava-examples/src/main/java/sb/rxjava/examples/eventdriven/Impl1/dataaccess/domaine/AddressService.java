package sb.rxjava.examples.eventdriven.Impl1.dataaccess.domaine;

import rx.Observable;
import sb.rxjava.examples.eventdriven.Impl1.dataaccess.infra.TestDatabaseProcedures;
import sb.rxjava.examples.eventdriven.Impl1.dataaccess.server.dto.Address;

import java.sql.SQLException;

public class AddressService {

    private final TestDatabaseProcedures procedures = new TestDatabaseProcedures();

    public Observable<Address> fetchCustomerAddresses(long customerId) {
        try {
            return procedures.toSelectAddressObservable(customerId);
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        }
    }
}

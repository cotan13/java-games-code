package sb.rxjava.examples.eventdriven.Impl1.dataaccess.domaine;

import rx.Observable;
import sb.rxjava.examples.eventdriven.Impl1.dataaccess.infra.TestDatabaseProcedures;
import sb.rxjava.examples.eventdriven.Impl1.dataaccess.server.dto.OwnedProduct;

import java.sql.SQLException;

public class ProductService {

    private final TestDatabaseProcedures procedures = new TestDatabaseProcedures();

    public Observable<OwnedProduct> fetchOwnedProducts(long customerId) {
        try {
            return procedures.toSelectOwnedProductObservable(customerId);
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        }
    }
}

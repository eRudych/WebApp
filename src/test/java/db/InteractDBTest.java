package db;

import app.entities.Product;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Example of testing class {@link InteractDB}
 */
@RunWith(Arquillian.class)
public class InteractDBTest {
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(InteractDB.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }


    /**
     * test for method {@link InteractDB#addProduct(Product)}  addProduct(Product product)}
     * expected is false, because the value ProductName and ProductCode in the table products must be unique
     * enter the value that is already in products
     */
    @org.junit.Test
    public void addProduct() {
        Product product = new Product("Milk", 5555, 14);
        boolean result = InteractDB.getInstance().addProduct(product);
        assertEquals(false, result);
    }

    /**
     * test for method {@link InteractDB#addProduct(Product)} addProduct(product Product)}
     * expected is true, analogy with {@link #addProduct()}
     */
    @org.junit.Test
    public void addProduct1() {
        Product product = new Product("Test", 0000, 90);
        boolean result = InteractDB.getInstance().addProduct(product);
        assertEquals(true, result);
    }

    /**
     * test for method {@link InteractDB#createCheck(int)} createCheck(int idCashier)}
     * verified by {@link InteractDB#getMaxIdForChecks()}
     */
    @org.junit.Test
    public void createCheck() {
        int expected = InteractDB.getInstance().getMaxIdForChecks() + 1;
        int result = InteractDB.getInstance().createCheck(1);
        assertEquals(expected, result);
    }

    /**
     * test for method {@link InteractDB#getMaxIdForChecks()} getMaxIdForChecks()}
     */
    @org.junit.Test
    public void getMaxIdForChecks() {
        int expected = InteractDB.getInstance().getMaxIdForChecks() + 1;
        createCheck();
        int result = InteractDB.getInstance().getMaxIdForChecks();
        assertEquals(expected, result);
    }

    /**
     * test for method {@link InteractDB#addingToDocumentation(int, Integer, Integer) addingToDocumentation(int numberOperation, Integer idCashier, Integer idCheck)
     * expected is false, because if(numberOperaion>6) return false;
     */
    @org.junit.Test
    public void addingToDocumentation() {
        boolean result = InteractDB.getInstance().addingToDocumentation(7, 1, 1);
        assertEquals(false, result);
    }

    /**
     * test for method {@link InteractDB#removeCheck(int)}  removeCheck(int idCheck)
     * expected is true, because it is expected to work correctly method;
     */
    @org.junit.Test
    public void removeCheck() {
        int idCheck = InteractDB.getInstance().getMaxIdForChecks();
        boolean result = InteractDB.getInstance().removeCheck(idCheck);
        assertEquals(true, result);
    }

}

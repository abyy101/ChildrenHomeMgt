import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ShowProductTest {
    private Connection conn;
    private ShowProduct instance;

    public ShowProductTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        // This method runs once before any test methods
    }

    @AfterClass
    public static void tearDownClass() {
        // This method runs once after all test methods
    }

    @Before
    public void setUp() {
        conn = databaseConnection.connection(); // Establish connection
        instance = new ShowProduct(); // Create instance of showProduct
        instance.conn = conn; // Inject the connection into the instance
    }

    @After
    public void tearDown() {
        try {
            conn.close(); // Close connection after each test
        } catch (SQLException ex) {
            // Handle exception if needed
        }
    }

    /**
     * Test of showRecord method, of class showProduct.
     */
    @Test
    public void testShowRecord() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        System.out.println("showRecord");

        instance.showRecord(); // Call the method to populate jTable1

        // Use reflection to access private jTable1 field
        Field jTable1Field = ShowProduct.class.getDeclaredField("jTable1");
        jTable1Field.setAccessible(true); // Make the field accessible
        JTable jTable1 = (JTable) jTable1Field.get(instance); // Get the jTable1 instance

        // Example assertions:
        assertNotNull("JTable is null", jTable1); // Check if jTable1 is not null
        TableModel model = jTable1.getModel();
        assertNotNull("TableModel is null", model); // Check if jTable1 model is not null

        // Adjust these assertions based on your actual data in the jTable1
        assertEquals("Unexpected row count", 3, model.getRowCount()); // Adjust expected row count as per your actual data
    }
}

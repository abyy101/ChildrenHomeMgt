/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
/**
 *
 * @author wambu
 */
public class ShowCategoryTest {
    private Connection conn;
    private ShowCategory instance;
    public ShowCategoryTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        conn = databaseConnection.connection();
        instance = new ShowCategory();
        instance.conn = conn;
    }
    @After
    public void tearDown() {
        try {
            conn.close();
        } catch (SQLException ex) {
        }
    }
@Test
    public void testShowRecord() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        System.out.println("showRecord");
        instance.showRecord();
        // Use reflection to access private jTable1 field
        Field jTable1Field = ShowCategory.class.getDeclaredField("jTable1");
        jTable1Field.setAccessible(true);
        JTable jTable1 = (JTable) jTable1Field.get(instance);
        // Example assertion: Check if jTable1 model is not null
        assertNotNull(jTable1.getModel());
        // Example assertion: Check if jTable1 contains expected data (adjust as per your actual data)
        // This assumes jTable1 is filled with data correctly from the database
        assertEquals(3, jTable1.getModel().getRowCount()); // Adjust as per your actual expected row count
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}

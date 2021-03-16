package tests;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.math.BigDecimal;
import model.Item;
import org.junit.Before;
import org.junit.Test;

/**
 * Test for the item class.
 * @author Carlos Manrique Ucharico
 * @version Winter 2021
 */
public class ItemTest {
    /**
     * An Item to use in the tests.
     */
    private Item myItem;
    /**
     * A second item to use in the tests.
     */
    private Item myItemtwo;
    /**
     * A third item to use in the tests.
     */
    private Item myItemThree;
    
    /**
     * setUp method for the itemTest.
     * A method to initialize the test fixture before each test.
     * @throws Exception   mmm.
     */
    @Before
    public void setUp() throws Exception {
        myItem = new Item("Macbook Pro", BigDecimal.valueOf(1297.99));
        myItemtwo = new Item("UW Note Pad", BigDecimal.valueOf(4.41) , 
                           6 , BigDecimal.valueOf(10.04));
        myItemThree = new Item("Macbook Pro", BigDecimal.valueOf(1297.99));
    }
    
    /**
     * Test method for {@link Item#getPrice()}.
     * Uses JUnit 5 Syntax.
     */
    @Test
    public void testGetPrice() {
        assertEquals(BigDecimal.valueOf(1297.99) , myItem.getPrice());
    }
    /**
     * Test method for {@link Item#getBulkQuantity()}.
     * Uses JUnit 5 Syntax.
     */
    @Test
    public void testGetBulkQuantity() {
        assertEquals(0 , myItem.getBulkQuantity());
    }
    
    /**
     * Test method for {@link Item#getBulkPrice()}.
     * Uses JUnit 5 Syntax.
     */
    @Test
    public void testGetBulkPrice() {
        assertNull(myItem.getBulkPrice());
    }
    
    /**
     * Test method for {@link Item#toString()}.
     * Uses JUnit 5 Syntax.
     */
    @Test
    public void testToString() {
        assertEquals("Macbook Pro, $1297.99", myItem.toString());
    }
   
    /**
     * Test method for {@link Item#equals(Object)}.
     * Uses JUnit 5 Syntax.
     */
    @Test
    public void testEqualsObject() {
        assertEquals(false , myItem.equals(myItemtwo));
    }
    
    /**
     * Test method for {@link Item#isBulk()}.
     * Uses JUnit 5 Syntax.
     */
    @Test
    public void testIsBulk() {
        assertAll("The item is not Bulk",
            () -> assertEquals(false, myItem.isBulk()),
            () -> assertEquals(true, myItemtwo.isBulk()),
            () -> assertNotEquals(null, myItemtwo.isBulk())
        );
    }                   
}
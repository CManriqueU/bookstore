package tests;
import static org.junit.Assert.*;

import java.math.BigDecimal;
import model.Cart;
import model.Item;
import model.ItemOrder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This is the test for the Cart class.
 * @author Carlos Manrique ucharico
 * @version Winter 2021
 */
class CartTest {
    
    /**
     * A cart to use in the test.
     */
    private Cart myCart;
    
    /**
     * A order to use in the test.
     */
    private ItemOrder myOrder;
 
    
    /**
     * An item to use in the test.
     */
    private Item myItem;
    
    /**
     * A second item to use in the test.
     */
    private Item myItem2;
    
    @BeforeEach
    void setUp() throws Exception {
        myItem = new Item("Ipad" , BigDecimal.valueOf(349.95));
        myItem2 = new Item("UW Note Pad" , BigDecimal.valueOf(4.41),
                              6 , BigDecimal.valueOf(10.04));       
        myCart = new Cart();
        myOrder = new ItemOrder(myItem, 1);
        
        myCart.add(myOrder);
    }

    //@Test (expected = NullPointerException.class)
    final void testCart() {           //  I can add a not null
        new Cart();
    }

    @Test 
    final void testAdd() {
        assertThrows(NullPointerException.class  , () -> myCart.add(null));
    }

    @Test
    final void testSetMembership() {
        //assertEquals( 1, cart.setMembership(true) );
    }

    @Test
    final void testCalculateTotal() {
        
        assertEquals(BigDecimal.valueOf(349.95), myCart.calculateTotal());
        //fail("Not yet implemented");
    }
    
    @Test
    final void testClear() {
        //assertNotNull(cart.clear());
    }
    
    @Test
    final void testGetCartSize() {
        assertEquals(-1 , myCart.getCartSize());
    }
    
    @Test
    final void testToString() {
        final StringBuilder s = new StringBuilder();
        s.append(myCart);
        assertEquals("This method does not print the correct string"
                     , s, myCart.toString());
    }
}

package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import model.Item;
import model.ItemOrder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test for ItemOrder class.
 * @author Carlos Manrique Ucharico
 * @version Winter 2021
 */
class ItemOrderTest {
    /**
     * This is.
     */
    private ItemOrder myOrder;
    /**
     * This is.
     */
    private Item myItem;

    @BeforeEach
    void setUp() {
        myItem = new Item("Ipad" , BigDecimal.valueOf(349.95));
        myOrder = new ItemOrder(myItem , 2);
    }

    @Test
    final void testItemOrder() {
        //assertThrows(NullPointerException.class , ()-> new ItemOrder(null, -1));
    }

    @Test
    final void testTotal() {
        /*BigDecimal value = BigDecimal.valueOf(699.90);
        value.setScale(3, RoundingMode.CEILING);
        assertEquals(  value , order.total() );    */
    }

    @Test
    final void testGetItem() {
        assertEquals(myItem , myOrder.getItem());
    }

    @Test
    final void testGetQuantity() { 
        assertEquals(2 , myOrder.getQuantity());
    }

    @Test
    final void testToString() {
        assertEquals("Item: Ipad, $349.95, quantity of: 2", myOrder.toString());
    }

}

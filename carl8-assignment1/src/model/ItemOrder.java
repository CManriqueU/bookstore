// Finish and comment me!

package model;

import java.math.BigDecimal;

/**
 * This is the ItemOrder class, contains the characteristics of the purchase of certaim items.
 * @author Carlos Manrique Ucharico
 * @version Winter 2021.
 */
public final class ItemOrder {

    /**
     * The Item we are handling.
     */
    private Item myItem;
    /**
     * The quantity of the product.
     */
    private int myQuantity;

    /**
     * Constructor of the ItemOrder class which defines the values for myItem and myQuantity.
     * @param theItem The Product we are assigning to the order.
     * @param theQuantity The amount of products we are assigning to the order.
     */
    public ItemOrder(final Item theItem, final int theQuantity) {
        this.myItem = theItem;
        this.myQuantity = theQuantity;
    }
       
    /**
     * This method returns the total cost for the items.
     * @return The total cost.
     */
    public BigDecimal total() {
        
        BigDecimal thetotal  = BigDecimal.ZERO;
        
        if ((myItem.getBulkQuantity() != 0) && (myItem.getBulkPrice() != null)) {
        
            if (myQuantity < myItem.getBulkQuantity()) {
                thetotal = myItem.getPrice().multiply(new BigDecimal(myQuantity)); 
                
            } else {
                final int extra = myQuantity % myItem.getBulkQuantity();
                final int bulksQty = (int) (myQuantity / myItem.getBulkQuantity());
                
                // if there are extras
                if (extra > 0) {
                    thetotal = new BigDecimal(bulksQty).multiply(
                                                   myItem.getBulkPrice()).add(
                                new BigDecimal(extra).multiply(myItem.getPrice()));
                }
                // if there are no extras, then:
                if (extra == 0) {
                    thetotal = new BigDecimal(bulksQty).multiply(myItem.getBulkPrice());
                }
            }
        }
        thetotal = myItem.getPrice().multiply(new BigDecimal(myQuantity));   
        
        return thetotal;
    }
    
    /**
     * Method to get a reference to the item.
     * @return A reference to the Item in this order.
     */
    public Item getItem() {
        return this.myItem;
    }
    
    /**
     * Method to get a reference to the quantity.
     * @return A reference to the quantity in this order.
     */
    public int getQuantity() {
        return this.myQuantity;
    }
    
    
    @Override
    public String toString() {
        String s = "";
        s = "Item: " + myItem + ", quantity of: " + myQuantity;
        return s;
    }

}

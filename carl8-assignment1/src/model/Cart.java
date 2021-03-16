// Finish and comment me!

package model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;  

/**
 * This is the Cart class.
 * @author Carlos Manrique Uharico
 * @version Winter 2021 
 */
public class Cart {
    /**
     *  The discount for the item.
     */
    private static final BigDecimal DISCOUNT_RATE = new BigDecimal(".10");
    
    /**
     *  Sets the map for myCart.
     */
    private Map<Item, BigDecimal> myCart;
    
    /**
     *  This is the Membership status, true if there is membership.
     */
    private boolean myMembershipHere;
    
    
    /**
    *  Creates the empty cart.
    */
    public Cart() {
        myCart =  new HashMap<Item, BigDecimal>();
    }
    
    /**
     * This method adds an order to the cart.
     * @param theOrder The order we are adding to the cart.
     */
    public void add(final ItemOrder theOrder) {
        
        //Objects.requireNonNull( theOrder, "theOrder can't be null!");
        myCart.put(theOrder.getItem(), theOrder.total());
    }

    /**
     * Sets the membership.
     * @param theMembership Boolean that is true when a person owns a membership.
     */
    public void setMembership(final boolean theMembership) {
        myMembershipHere = theMembership;
    }
  
    /**
     * This method calculates the total cost.
     * @return A big decimal of the total cost.
     */
    public BigDecimal calculateTotal() {
        
        BigDecimal orderTotal = BigDecimal.ZERO;
        
        final Iterator<Item> iterator = myCart.keySet().iterator();
        
        while (iterator.hasNext()) {
            final BigDecimal currentOrderPrice = myCart.get(iterator.next());
            
            orderTotal = orderTotal.add(currentOrderPrice);
        }
        
        //if membership take %10 off the total cost
        if (myMembershipHere) {
            if (orderTotal.compareTo(new BigDecimal("25.00")) == 1) { //myOrderTotal > $25
                final BigDecimal disc = DISCOUNT_RATE.multiply(orderTotal); 
                orderTotal = orderTotal.subtract(disc);
            }
        }
        
        return orderTotal.setScale(2, RoundingMode.HALF_EVEN);
        //return null;
    }
    
    /**
     * Empties the cart.
     */
    public void clear() {
        myCart = new HashMap<Item, BigDecimal>();
    }
    
    /**
     * Gets the cart size.
     * @return -1.
     */
    public int getCartSize() {
        return -1;
    }

    /**
     * Returns a string for the display.
     */
    @Override
    public String toString() {
        final StringBuilder s  = new StringBuilder();
        s.append(myCart);
        
        return s.toString();
    }
}

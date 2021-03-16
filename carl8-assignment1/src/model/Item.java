package model;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * The Item class which has the characteristics of an item from the bookstore.
 * @author Carlos Manrique Ucharico
 * @version Winter 2021
 */
public final class Item {
    /**
     * This is the product name.
     */
    private String myName;
    /**
     * This is the product price.
     */
    private BigDecimal myPrice;
    /**
     * This is the bulk quantity of the product.
     */
    private int myBulkQuantity;
    /**
     * This is the bulk price jof the product.
     */
    private BigDecimal myBulkPrice;

    //  I have to bring it here from the file,
    
    /**
     * Constructor to set myName and myPrice values.
     * @param theName The name we are assigning to this item.
     * @param thePrice The price we are assigning to this item.
     */
    public Item(final String theName, final BigDecimal thePrice) {
       //this.myCampusInventories = null;
        this.myName = theName;
        this.myPrice = thePrice;
    }

    //   I have to bring it here from the file,
    /**
     * Constructor that sets the values for myName, myPrice, myBulkQuantity, myBulkPrice.
     * @param theName The name we are assigning to this item.
     * @param thePrice The price we are assigning to this item.
     * @param theBulkQuantity The Bulk Quantity we are assigning to this item.
     * @param theBulkPrice The Bulk Price we are assigning to this item.
     */
    public Item(final String theName, final BigDecimal thePrice, final int theBulkQuantity,
                final BigDecimal theBulkPrice) {
        //this.myCampusInventories = null;
        this.myName = theName;
        this.myPrice = thePrice;
        this.myBulkQuantity = theBulkQuantity;
        this.myBulkPrice = theBulkPrice;
    }
    
    public BigDecimal getPrice() {
        return myPrice;
    }


    public int getBulkQuantity() {
        return myBulkQuantity;
    }


    public BigDecimal getBulkPrice() {
        return myBulkPrice;
    }

    /**
     * This method returns a boolean, true if it has a bulkQuantity and false otherwise.
     * @return Returns true or false.
     */
    public boolean isBulk() {
        if (myBulkQuantity > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String s = "";
        if (myBulkQuantity > 0) {
            s = myName + ", $" + myPrice + " (" 
                + myBulkQuantity + " for $" + myBulkPrice + ")";
        } else {
            s = myName + ", $" + myPrice;
        }
        return s;
    }

    @Override
    public boolean equals(final Object theOther) {
        //if( theOther.theName == theName )
        boolean boo = false;
        if ((theOther != null) && (theOther.getClass() == this.getClass())) {
            final Item item = (Item) theOther;
            
            if ((myBulkQuantity) != 0 && (myBulkPrice != null)) {
                    
                boo = myName.equals(item.myName)
                    && myPrice.equals(item.myPrice)
                    && myBulkQuantity == item.myBulkQuantity
                    && myBulkPrice.equals(item.myBulkPrice);
     
            } else {
                    //they both have to be true
                boo = myName.equals(item.myName) && myPrice.equals(item.myPrice);
            }
        }
        return boo;
    }

    @Override
    public int hashCode() {
        int hash;
    
        hash = Objects.hash(myName, myPrice);
        
        if ((myBulkQuantity != 0) && (myBulkPrice != null)) {
            hash = Objects.hash(myName, myPrice, myBulkQuantity, myBulkPrice);
        }
        
        return hash;
    }

}

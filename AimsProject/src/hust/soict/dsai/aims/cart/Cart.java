package hust.soict.dsai.aims.cart;
import java.util.UUID;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;
public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered = 0;
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The disc has been added");
        } else {
            System.out.println("The cart is full");
        }
    }
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].equals(disc)) {
                found = true;
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                itemsOrdered[qtyOrdered - 1] = null;
                qtyOrdered--;
                System.out.println("The disk has been removed");
                break;
            }
        }
        if (!found) {
            System.out.println("Disc not found in the cart");
        }
    }
    public float totalCost() {
    	float total = 0.0f;
    	for (int i = 0; i < qtyOrdered; i++) {
    		total += itemsOrdered[i].getCost();
    	}
    	return total;
    }
    public void print() {
    	System.out.println("The DVDs in cart are:");
    	for (int i = 0; i < qtyOrdered; i++) {
    		int j = i+1;
    		System.out.println(j + ". DVD - " + itemsOrdered[i].getTitle() + " - " +itemsOrdered[i].getCategory() + " - " + itemsOrdered[i].getDirector() + " - " + itemsOrdered[i].getLength() + ": " + itemsOrdered[i].getCost());
    	}
    	System.out.println("Total cost: " + this.totalCost());
    }
    public void searchByID(UUID id) {
    	boolean found = false;
    	for (int i = 0; i < qtyOrdered; i++) {
    		if (itemsOrdered[i].getID().equals(id)) {
    			found = true;
    			System.out.println("The disc " + id + " is in the cart.");
    		}
    	}
    	if (!found) {
            System.out.println("The disc " + id + " not found in the cart");
        }
    }
    public void searchByTitle(String title) {
    	boolean found = false;
    	for (int i = 0; i < qtyOrdered; i++) {
    		if (itemsOrdered[i].getTitle().equals(title)) {
    			found = true;
    			System.out.println("The disc " + title + " is in the cart.");
    		}
    	}
    	if (!found) {
            System.out.println("The disc " + title + " not found in the cart");
        }
    }
    			
}


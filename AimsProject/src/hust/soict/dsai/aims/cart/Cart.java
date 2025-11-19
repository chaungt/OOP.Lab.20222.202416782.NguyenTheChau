package hust.soict.dsai.aims.cart;
import java.util.UUID;
import java.util.ArrayList;
import hust.soict.dsai.aims.media.*;
public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
    public void addMedia(Media media) {
    	if(!itemsOrdered.contains(media) && itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
    		itemsOrdered.add(media);
    	} else {
    		System.out.println("Media already in cart");
    	}
    }
    public void removeMedia(Media media) {
    	if(itemsOrdered.contains(media)) {
    		itemsOrdered.remove(media);
    	} else {
    		System.out.println("Media already in cart");
    	}
    }
    public float totalCost() {
		float finalCost = 0.0f;
		for (Media media : itemsOrdered) {
			finalCost += media.getCost();
		}
		return finalCost;
	}
    public void print() {
    	System.out.println("The DVDs in cart are:");
    	for (Media media : itemsOrdered) {
    		System.out.println(j + ". DVD - " + itemsOrdered[i].getTitle() + " - " +itemsOrdered[i].getCategory() + " - " + itemsOrdered[i].getDirector() + " - " + itemsOrdered[i].getLength() + ": " + itemsOrdered[i].getCost());
    	}
    	System.out.println("Total cost: " + this.totalCost());
    }
    public void searchByID(int id) {
    	boolean found = false;
    	for (Media media : itemsOrdered) {
    		if (media.getId() == id) {
    			found = true;
    			System.out.println("The media " + id + " is in the cart.");
    		}
    	}
    	if (!found) {
            System.out.println("The media " + id + " not found in the cart");
        }
    }
    public void searchByTitle(String title) {
    	boolean found = false;
    	for (Media media : itemsOrdered) {
    		if (media.getTitle().equals(title)) {
    			found = true;
    			System.out.println("The media " + title + " is in the cart.");
    		}
    	}
    	if (!found) {
            System.out.println("The disc " + title + " not found in the cart");
        }
    }
    			
}


package hust.soict.dsai.aims.cart;
import java.util.ArrayList;
import hust.soict.dsai.aims.media.*;
public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	public ArrayList<Media> itemsOrdered = new ArrayList<Media>();
    public void addMedia(Media media) {
    	if(!itemsOrdered.contains(media) && itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
    		itemsOrdered.add(media);
    		System.out.println("Media has been added");
    	} else {
    		System.out.println("Media already in cart");
    	}
    }
    public void removeMedia(Media media) {
    	if(itemsOrdered.contains(media)) {
    		itemsOrdered.remove(media);
    		System.out.println("Media has been removed");
    	} else {
    		System.out.println("Media not in cart");
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
    	int j = 0;
    	for (Media media : itemsOrdered) {
    		j++;
    		System.out.println(j + ". Media - " + media.getTitle() + " - " +media.getCategory() + " - "  + media.getCost());
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
 

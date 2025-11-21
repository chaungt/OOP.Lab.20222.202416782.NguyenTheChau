package hust.soict.dsai.aims.store;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;
import hust.soict.dsai.aims.media.*;

public class Store {
	public ArrayList<Media> itemsInStore = new ArrayList<Media>();
	private int medias = 0;
    public void addMedia(Media media) {
    	if(!itemsInStore.contains(media)) {
    		itemsInStore.add(media);
    		medias++;
    	} else {
    		System.out.println("Media already in cart");
    	}
    }
    public void removeMedia(Media media) {
    	if(itemsInStore.contains(media)) {
    		itemsInStore.remove(media);
    		medias--;
    	} else {
    		System.out.println("Media not in cart");
    	}
    }
    public boolean check(String title) {
    	for (Media media : itemsInStore) {
    		if (media.getTitle().equalsIgnoreCase(title)) {
    			return true;
    		}
    	}
    	return false;
    }
   public void print() {
    	System.out.println("The DVDs in the store are:");
    	int j = 0;
    	for (Media media : itemsInStore) {
    		j++;
    		System.out.println(j + ". Media - " + media.getTitle() + " - " +media.getCategory() + " - "  + media.getCost());
    	}
    } 
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
    

}
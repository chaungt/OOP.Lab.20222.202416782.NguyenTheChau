package hust.soict.dsai.aims.store;
import java.util.ArrayList;
import hust.soict.dsai.aims.media.*;

public class Store {
	private ArrayList<Media> itemsInStore = new ArrayList<Media>();
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
    public void print() {
    	System.out.println("The DVDs in the store are:");
    	for (int i = 0; i < medias; i++) {
    		int j = i+1;
    		System.out.println(j + ". DVD - " + itemsInStore[i].getTitle() + " - " +itemsInStore[i].getCategory() + " - " + itemsInStore[i].getDirector() + " - " + itemsInStore[i].getLength() + ": " + itemsInStore[i].getCost());
    	}
    }

}

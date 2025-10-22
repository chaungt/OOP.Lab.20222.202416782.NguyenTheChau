package AimsProject;

public class Store {
	private DigitalVideoDisc itemsInStore[] = new DigitalVideoDisc[1000000];
	private int qtyOrdered = 0;
    public void addDVD(DigitalVideoDisc disc) {
    	itemsInStore[qtyOrdered] = disc;
    	qtyOrdered++;
    	System.out.println("The DVD has been added");
    }
    public void removeDVD(DigitalVideoDisc disc) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsInStore[i].equals(disc)) {
                found = true;
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemsInStore[j] = itemsInStore[j + 1];
                }
                itemsInStore[qtyOrdered - 1] = null;
                qtyOrdered--;
                System.out.println("The DVD has been removed");
                break;
            }
        }
        if (!found) {
            System.out.println("DVD not found in the store");
        }
    }
    public void print() {
    	System.out.println("The DVDs in the store are:");
    	for (int i = 0; i < qtyOrdered; i++) {
    		int j = i+1;
    		System.out.println(j + ". DVD - " + itemsInStore[i].getTitle() + " - " +itemsInStore[i].getCategory() + " - " + itemsInStore[i].getDirector() + " - " + itemsInStore[i].getLength() + ": " + itemsInStore[i].getCost());
    	}
    }

}

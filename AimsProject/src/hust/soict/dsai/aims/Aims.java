package hust.soict.dsai.aims;
import hust.soict.dsai.aims.*;
import hust.soict.dsai.aims.cart.Cart;

import java.util.Collections;
import java.util.Scanner;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;
public class Aims {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Store store = new Store();
        Cart cart = new Cart();

        // Sample media added to store for testing
        store.addMedia(new DigitalVideoDisc(1, "Zoolander", "Action", 19.99f));
        store.addMedia(new DigitalVideoDisc(2, "Courage the Cowardly Dog", "Mystery", 14.99f));
        store.addMedia(new Book(3, "The Dark Crystal", "Fantasy", 29.99f));

        boolean exit = false;
        while (!exit) {
            showMenu();
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1: // View store
                    boolean backStore = false;
                    while (!backStore) {
                        store.print();
                        storeMenu();
                        int storeChoice = sc.nextInt();
                        sc.nextLine();
                        switch (storeChoice) {
                            case 1: // See media details
                                System.out.println("Enter the title of the media: ");
                                String title = sc.nextLine();
                                if (store.check(title)) {
                                    for (Media m : store.itemsInStore) {
                                        if (m.getTitle().equalsIgnoreCase(title)) {
                                            System.out.println("Title: " + m.getTitle());
                                            System.out.println("Category: " + m.getCategory());
                                            System.out.println("Cost: " + m.getCost());
                                            mediaDetailsMenu();
                                            int detailChoice = sc.nextInt();
                                            sc.nextLine();
                                            switch (detailChoice) {
                                                case 1: // Add to cart
                                                    cart.addMedia(m);
                                                    break;
                                                case 2: // Play
                                                    if (m instanceof Playable) {
                                                        ((Playable) m).play();
                                                    } else {
                                                        System.out.println("This media cannot be played.");
                                                    }
                                                    break;
                                                case 0:
                                                    break;
                                            }
                                        }
                                    }
                                } else {
                                    System.out.println("Media not found in store.");
                                }
                                break;

                            case 2: // Add to cart
                                System.out.println("Enter the title of the media to add: ");
                                title = sc.nextLine();
                                boolean found = false;
                                for (Media m : store.itemsInStore) {
                                    if (m.getTitle().equalsIgnoreCase(title)) {
                                        cart.addMedia(m);
                                        found = true;
                                        break;
                                    }
                                }
                                if (!found) System.out.println("Media not found.");
                                break;

                            case 3: // Play a media
                                System.out.println("Enter the title of the media to play: ");
                                title = sc.nextLine();
                                found = false;
                                for (Media m : store.itemsInStore) {
                                    if (m.getTitle().equalsIgnoreCase(title)) {
                                        if (m instanceof Playable) {
                                            ((Playable) m).play();
                                        } else {
                                            System.out.println("This media cannot be played.");
                                        }
                                        found = true;
                                        break;
                                    }
                                }
                                if (!found) System.out.println("Media not found.");
                                break;

                            case 4: // See current cart
                                cart.print();
                                break;

                            case 0:
                                backStore = true;
                                break;
                        }
                    }
                    break;

                case 2: // Update store
                    System.out.println("Enter 1 to add media, 2 to remove media: ");
                    int updateChoice = sc.nextInt();
                    sc.nextLine();
                    if (updateChoice == 1) {
                        System.out.println("Enter title: ");
                        String title = sc.nextLine();
                        System.out.println("Enter category: ");
                        String category = sc.nextLine();
                        System.out.println("Enter cost: ");
                        float cost = sc.nextFloat();
                        sc.nextLine();
                        DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, cost);
                        store.addMedia(dvd);
                    } else if (updateChoice == 2) {
                        System.out.println("Enter title to remove: ");
                        String title = sc.nextLine();
                        Media toRemove = null;
                        for (Media m : store.itemsInStore) {
                            if (m.getTitle().equalsIgnoreCase(title)) {
                                toRemove = m;
                                break;
                            }
                        }
                        if (toRemove != null) store.removeMedia(toRemove);
                        else System.out.println("Media not found in store.");
                    }
                    break;

                case 3: // See current cart
                    boolean backCart = false;
                    while (!backCart) {
                        cart.print();
                        cartMenu();
                        int cartChoice = sc.nextInt();
                        sc.nextLine();
                        switch (cartChoice) {
                            case 1: // Filter
                                System.out.println("Filter by: 1-ID, 2-Title");
                                int filterChoice = sc.nextInt();
                                sc.nextLine();
                                if (filterChoice == 1) {
                                    System.out.println("Enter ID: ");
                                    int id = sc.nextInt();
                                    sc.nextLine();
                                    cart.searchByID(id);
                                } else if (filterChoice == 2) {
                                    System.out.println("Enter Title: ");
                                    String t = sc.nextLine();
                                    cart.searchByTitle(t);
                                }
                                break;

                            case 2: // Sort
                                System.out.println("Sort by: 1-Title, 2-Cost");
                                int sortChoice = sc.nextInt();
                                sc.nextLine();
                                if (sortChoice == 1) {
                                    Collections.sort(cart.itemsOrdered, Media.COMPARE_BY_TITLE_COST);
                                } else if (sortChoice == 2) {
                                    Collections.sort(cart.itemsOrdered, Media.COMPARE_BY_COST_TITLE);
                                }
                                break;

                            case 3: // Remove media
                                System.out.println("Enter title to remove: ");
                                String title = sc.nextLine();
                                Media toRemove = null;
                                for (Media m : cart.itemsOrdered) {
                                    if (m.getTitle().equalsIgnoreCase(title)) {
                                        toRemove = m;
                                        break;
                                    }
                                }
                                if (toRemove != null) cart.removeMedia(toRemove);
                                else System.out.println("Media not found in cart.");
                                break;

                            case 4: // Play media
                                System.out.println("Enter title to play: ");
                                String t = sc.nextLine();
                                boolean found = false;
                                for (Media m : cart.itemsOrdered) {
                                    if (m.getTitle().equalsIgnoreCase(t)) {
                                        if (m instanceof Playable) ((Playable) m).play();
                                        else System.out.println("This media cannot be played.");
                                        found = true;
                                        break;
                                    }
                                }
                                if (!found) System.out.println("Media not found in cart.");
                                break;

                            case 5:
                                System.out.println("Order has been placed. Cart is now empty.");
                                cart.itemsOrdered.clear();
                                break;

                            case 0:
                                backCart = true;
                                break;
                        }
                    }
                    break;

                case 0: // Exit
                    exit = true;
                    System.out.println("Thank you for using AIMS!");
                    break;
            }
        }

        sc.close();
    }
	public static void showMenu() {
		System.out.println("Options:");
		System.out.println("______________________________");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("______________________________");
		System.out.println("Please choose a number 0-1-2-3");
	}
	public static void storeMenu() {
		System.out.println("Options:");
		System.out.println("______________________________");
		System.out.println("1. See a media's details");
		System.out.println("2. Add a media to cart");
		System.out.println("3. Play a media");
		System.out.println("4. See current cart");
		System.out.println("0. Back");
		System.out.println("______________________________");
		System.out.println("Please choose a number 0-1-2-3-4");
	}
	public static void mediaDetailsMenu() {
		System.out.println("Options:");
		System.out.println("______________________________");
		System.out.println("1. Add to cart");
		System.out.println("2. Play");
		System.out.println("0. Back");
		System.out.println("______________________________");
		System.out.println("Please choose a number 0-1-2");
	}
	public static void cartMenu() {
		System.out.println("Options:");
		System.out.println("______________________________");
		System.out.println("1. Filter medias in cart");
		System.out.println("2. Sort medias in cart");
		System.out.println("3. Remove media from cart");
		System.out.println("4. Play a media");
		System.out.println("5. Place order");
		System.out.println("0. back");
		System.out.println("______________________________");
		System.out.println("Please choose a number 0-1-2-3-4-5");
	}
	

}

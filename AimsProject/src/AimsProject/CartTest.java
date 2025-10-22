package AimsProject;

public class CartTest {

	public static void main(String[] args) {
		Cart cart = new Cart();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		cart.addDigitalVideoDisc(dvd1);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science fiction", "Geogre Lucas", 87, 24.95f);
		cart.addDigitalVideoDisc(dvd2);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 19.95f);
		cart.addDigitalVideoDisc(dvd3);
		cart.searchByID(dvd1.getID());
		cart.searchByTitle(dvd1.getTitle());
		cart.print();
		cart.removeDigitalVideoDisc(dvd1);
		cart.searchByID(dvd1.getID());
		cart.searchByTitle(dvd1.getTitle());
		cart.print();
	}

}

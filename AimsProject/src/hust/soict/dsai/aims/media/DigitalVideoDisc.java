package hust.soict.dsai.aims.media;
import java.util.UUID;

public class DigitalVideoDisc extends Disc implements Playable {
	private static int nbDigitalVideoDiscs = 0;
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
		this.id = (int)Math.random()*10000;
		nbDigitalVideoDiscs++;
	}
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.cost = cost;
		this.id = (int)Math.random()*10000;
		nbDigitalVideoDiscs++;
	}
	public DigitalVideoDisc(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
		this.id = (int)Math.random()*10000;
		nbDigitalVideoDiscs++;
	}
	public DigitalVideoDisc(String title) {
		super();
		this.title = title;
		this.id = (int)Math.random()*10000;
		nbDigitalVideoDiscs++;
	}
	public DigitalVideoDisc(DigitalVideoDisc [] dvdlist) {
		for (int i = 0; i < dvdlist.length; i++) {
			new DigitalVideoDisc(dvdlist[i].getTitle(), dvdlist[i].getCategory(), dvdlist[i].getDirector(), dvdlist[i].getLength(), dvdlist[i].getCost());
		}
	}
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}

}

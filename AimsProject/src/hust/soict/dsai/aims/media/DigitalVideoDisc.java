package hust.soict.dsai.aims.media;
import java.util.UUID;

public class DigitalVideoDisc extends Disc implements Playable {
	private static int nbDigitalVideoDiscs = 0;
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super(length, director, director, cost);
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
		this.id = (int)Math.random()*10000;
		nbDigitalVideoDiscs++;
	}
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super(nbDigitalVideoDiscs, director, director, cost);
		this.title = title;
		this.category = category;
		this.director = director;
		this.cost = cost;
		this.id = (int)Math.random()*10000;
		nbDigitalVideoDiscs++;
	}
	public DigitalVideoDisc(String title, String category, float cost) {
		super(nbDigitalVideoDiscs, category, category, cost);
		this.title = title;
		this.category = category;
		this.cost = cost;
		this.id = (int)Math.random()*10000;
		nbDigitalVideoDiscs++;
	}
	public DigitalVideoDisc(String title) {
		super(nbDigitalVideoDiscs, title, title, 0);
		this.title = title;
		this.id = (int)Math.random()*10000;
		nbDigitalVideoDiscs++;
	}
	
	public DigitalVideoDisc(int id, String title, String category, float cost) {
		super(id, title, category, cost);
		this.id = id;
		this.title = title;
		this.category = category;
		this.cost = cost;
	}
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}

}
 
package hust.soict.dsai.aims.media;

public abstract class Disc extends Media {
	protected int length;
	protected String director;
	public int getLength() {
		return length;
	}
	public String getDirector() {
		return director;
	}
	public Disc(int id, String title, String category, float cost) {
		super(id, title, category, cost);
	}
	

}
 
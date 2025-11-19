package hust.soict.dsai.aims.media;

public class Track implements Playable {
	private String title;
	private int lenght;
	public String getTitle() {
		return title;
	}
	public int getLength() {
		return lenght;
	}
	public Track(String title, int lenght) {
		super();
		this.title = title;
		this.lenght = lenght;
	}
	@Override
	public boolean equals(Object obj) {
	    if (this == obj) return true;
	    if (obj == null || getClass() != obj.getClass()) return false;
	    Track other = (Track) obj;
	    return this.getTitle().equals(other.getTitle()) &&
	           this.getLength() == other.getLength();
	}
	public void play() {
		System.out.println("Playing track: " + this.getTitle());
		System.out.println("Track length: " + this.getLength());
	}

}

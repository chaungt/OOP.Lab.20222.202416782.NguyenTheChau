package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
	private List<String> authors = new ArrayList<String>();
	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}
	public void addAuthor(String author) {
		if(!authors.contains(author)) {
			authors.add(author);
		} else {
			System.out.println("The author already in the list");
		}
	}
	public void removeAuthor(String author) {
		if (authors.contains(author)) {
			authors.remove(author);
		} else {
			System.out.println("The author is not in the list");
		}
	}
	public Book(int id, String title, String category, float cost) {
		super(id, title, category, cost);
	}
}
 
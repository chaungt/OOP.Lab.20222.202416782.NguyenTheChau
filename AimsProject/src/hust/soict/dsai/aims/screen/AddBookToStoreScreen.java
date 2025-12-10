package hust.soict.dsai.aims.screen;

import javax.swing.JButton;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.store.Store;

public class AddBookToStoreScreen extends AddItemsToStoreScreen {
	public AddBookToStoreScreen(Store store) {
		super(store, "Add Book");
		JButton btnAdd = new JButton("Add Book");
		btnAdd.addActionListener(e -> handleAdd());
		add(btnAdd);
	}
	@Override
	protected void handleAdd() {
		Book book = new Book(tfTitle.getText(), tfCategory.getText(), parseCost());
		store.addMedia(book);
		dispose();
	}
}

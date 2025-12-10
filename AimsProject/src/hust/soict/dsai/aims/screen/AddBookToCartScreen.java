package hust.soict.dsai.aims.screen;

import javax.naming.LimitExceededException;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;

public class AddBookToCartScreen extends AddItemsToCartScreen{
	public AddBookToCartScreen(Cart cart) {
		super(cart, "Add Book");
		JButton btnAdd = new JButton("Add Book");
		btnAdd.addActionListener(e -> {
			try {
				handleAdd();
			} catch (LimitExceededException ex) {
				JOptionPane.showMessageDialog(null, ex.getMessage(), "Exceed cart limitation", JOptionPane.ERROR_MESSAGE);
			}
		});
		add(btnAdd);
	}
	@Override
	protected void handleAdd() throws LimitExceededException {
		Book book = new Book(tfTitle.getText(), tfCategory.getText(), parseCost());
		cart.addMedia(book);
		dispose();
	}

}

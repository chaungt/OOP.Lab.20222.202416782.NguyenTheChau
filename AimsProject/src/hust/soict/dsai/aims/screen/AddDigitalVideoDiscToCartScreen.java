package hust.soict.dsai.aims.screen;

import javax.naming.LimitExceededException;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.cart.Cart;

public class AddDigitalVideoDiscToCartScreen extends AddItemsToCartScreen {
	public AddDigitalVideoDiscToCartScreen(Cart cart) {
		super(cart, "Add DVD");
		JButton btnAdd = new JButton("Add DVD");
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
		DigitalVideoDisc DVD = new DigitalVideoDisc(tfTitle.getText(), tfCategory.getText(), parseCost());
		cart.addMedia(DVD);
		dispose();
	}

}

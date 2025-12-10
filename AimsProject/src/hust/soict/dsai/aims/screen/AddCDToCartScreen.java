package hust.soict.dsai.aims.screen;

import javax.naming.LimitExceededException;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.CompactDisc;

public class AddCDToCartScreen extends AddItemsToCartScreen {
	public AddCDToCartScreen(Cart cart) {
		super(cart, "Add CD");
		JButton btnAdd = new JButton("Add CD");
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
		CompactDisc CD = new CompactDisc(tfTitle.getText(), tfCategory.getText(), parseCost());
		cart.addMedia(CD);
		dispose();
	}

}

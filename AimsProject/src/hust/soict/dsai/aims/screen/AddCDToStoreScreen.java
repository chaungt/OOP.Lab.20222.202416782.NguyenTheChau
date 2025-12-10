package hust.soict.dsai.aims.screen;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.store.Store;

public class AddCDToStoreScreen extends AddItemsToStoreScreen {
	private JTextField tfArtist = new JTextField();
	public AddCDToStoreScreen(Store store) {
		super(store, "Add CD");
		add(new JLabel("Artist:"));
		add(tfArtist);
		JButton btnAdd = new JButton("Add CD");
		btnAdd.addActionListener(e -> handleAdd());
		add(btnAdd);
	}
	@Override
	protected void handleAdd() {
		CompactDisc CD = new CompactDisc(tfTitle.getText(), tfCategory.getText(), parseCost(), tfArtist.getText());
		store.addMedia(CD);
		dispose();
	}
	

}

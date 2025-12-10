package hust.soict.dsai.aims.screen;

import javax.swing.JButton;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class AddDigitalVideoDiscToStoreScreen extends AddItemsToStoreScreen{
	public AddDigitalVideoDiscToStoreScreen(Store store) {
		super(store, "Add DVD");
		JButton btnAdd = new JButton("Add DVD");
		btnAdd.addActionListener(e -> handleAdd());
		add(btnAdd);
	}
	@Override
	protected void handleAdd() {
		DigitalVideoDisc DVD = new DigitalVideoDisc(tfTitle.getText(), tfCategory.getText(), parseCost());
		store.addMedia(DVD);
		dispose();
	}

}

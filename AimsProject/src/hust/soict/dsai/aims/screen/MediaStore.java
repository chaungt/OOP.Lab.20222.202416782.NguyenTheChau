package hust.soict.dsai.aims.screen;
import java.awt.*;
import javax.swing.*;

import hust.soict.dsai.aims.Aims;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;

public class MediaStore extends JPanel {
	private Media media;
	private Cart cart;
	private Store store;
	public MediaStore(Media media, Cart cart) {
		this.media = media;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		JLabel title = new JLabel(media.getTitle());
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
		title.setAlignmentX(CENTER_ALIGNMENT);
		JLabel cost = new JLabel(""+media.getCost()+" $");
		cost.setAlignmentX(CENTER_ALIGNMENT);
		JPanel container = new JPanel();
		container.setLayout(new FlowLayout(FlowLayout.CENTER));
		JButton btnAddToCart = new JButton("Add to cart");
		btnAddToCart.addActionListener(e -> {
			try {
				cart.addMedia(media);
				JOptionPane.showMessageDialog(null, media.getTitle() + " added to cart.");
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Cannot add item: " + ex.getMessage());
			}
		});
		container.add(btnAddToCart);
		if(media instanceof Playable playable) {
			JButton btnPlay = new JButton("Play");
			btnPlay.addActionListener(e ->{
				try {
					DigitalVideoDisc dvd = (DigitalVideoDisc) media;
					dvd.play();
					JOptionPane.showMessageDialog(null, "Playing: " + media.getTitle());
				} catch (PlayerException ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Play error", JOptionPane.ERROR_MESSAGE);
				}
			});
			container.add(btnPlay);
		}
		this.add(Box.createVerticalGlue());
		this.add(title);
		this.add(cost);
		this.add(Box.createVerticalGlue());
		this.add(container);
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}

}

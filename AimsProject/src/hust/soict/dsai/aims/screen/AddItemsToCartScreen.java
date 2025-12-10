package hust.soict.dsai.aims.screen;

import java.awt.GridLayout;

import javax.naming.LimitExceededException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

import hust.soict.dsai.aims.cart.Cart;

public abstract class AddItemsToCartScreen extends JFrame {
	protected Cart cart;

    protected JTextField tfTitle = new JTextField();
    protected JTextField tfCategory = new JTextField();
    protected JTextField tfCost = new JTextField();

    public AddItemsToCartScreen(Cart cart, String screenTitle) {
        this.cart = cart;
        setTitle(screenTitle);
        setSize(500, 300);
        setLayout(new GridLayout(5, 2, 5, 5));
        add(new JLabel("Title:"));
        add(tfTitle);
        add(new JLabel("Category:"));
        add(tfCategory);
        add(new JLabel("Cost:"));
        add(tfCost);
        addMenuBar();
        setVisible(true);
    }
    private void addMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Options");
        JMenuItem viewStore = new JMenuItem("View Store");
        viewStore.addActionListener(e -> new CartScreen(cart));
        menu.add(viewStore);
        menuBar.add(menu);
        setJMenuBar(menuBar);
    }
    protected float parseCost() {
        try {
            return Float.parseFloat(tfCost.getText());
        } catch (Exception e) {
            return 0f;
        }
    }
    protected abstract void handleAdd() throws LimitExceededException;

}

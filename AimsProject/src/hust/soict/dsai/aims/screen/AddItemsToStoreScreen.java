package hust.soict.dsai.aims.screen;
import java.awt.GridLayout;
import javax.swing.*;
import hust.soict.dsai.aims.store.Store;

public abstract class AddItemsToStoreScreen extends JFrame {

    protected Store store;

    protected JTextField tfTitle = new JTextField();
    protected JTextField tfCategory = new JTextField();
    protected JTextField tfCost = new JTextField();

    public AddItemsToStoreScreen(Store store, String screenTitle) {
        this.store = store;
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
        viewStore.addActionListener(e -> new StoreScreen(store));
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
    protected abstract void handleAdd();

}

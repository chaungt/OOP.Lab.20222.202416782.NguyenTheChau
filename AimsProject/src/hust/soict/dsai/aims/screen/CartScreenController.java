package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
public class CartScreenController {
	private Cart cart;
	@FXML
	private TextField tfFilter;
	@FXML
	private RadioButton radioBtnFilterId;
	@FXML
	private RadioButton radioBtnFilterTitle;
	@FXML
	private Button btnPlay;
	@FXML
	private Button btnRemove;
	@FXML
	private TableView<Media> tblMedia;
	@FXML
	private TableColumn<Media, String> colMediaTitle;
	@FXML
	private TableColumn<Media, String> colMediaCategory;
	@FXML
	private TableColumn<Media, Float> colMediaCost;
	@FXML
	private Label lblTotalCost;
	@FXML
	private void addBook(ActionEvent event) {}

	@FXML
	private void addCD(ActionEvent event) {}

	@FXML
	private void addDVD(ActionEvent event) {}

	@FXML
	private void placeOrderPressed(ActionEvent event) {}
	@FXML
	void btnRemovePressed(ActionEvent event) {
		Media media = tblMedia.getSelectionModel().getSelectedItem();
		cart.removeMedia(media);
	}
	@FXML
	void btnPlayPressed(ActionEvent event) {
		Media media = tblMedia.getSelectionModel().getSelectedItem();
	}
	public CartScreenController(Cart cart) {
		super();
		this.cart = cart;
	}
	@FXML
	private void initialize() {
		colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
		colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
		colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
		tblMedia.setItems(this.cart.getItemsOrdered());
		btnPlay.setVisible(false);
		btnRemove.setVisible(false);
		tblMedia.getSelectionModel().selectedItemProperty().addListener(
				new ChangeListener<Media>() {
					@Override
					public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
						if (newValue!=null) {
							updateButtonBar(newValue);
						}
					}
					void updateButtonBar(Media media) {
						btnRemove.setVisible(true);
						if(media instanceof Playable) {
							btnPlay.setVisible(true);
						} else {
							btnPlay.setVisible(false);
						}
					}
				});
		cart.getItemsOrdered().addListener((ListChangeListener<Media>) c -> {
			lblTotalCost.setText(String.format("%.2f $", cart.totalCost()));
		});
	}

}

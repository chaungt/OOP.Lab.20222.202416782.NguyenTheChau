package hust.soict.dsai.javafx;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.paint.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.shape.Circle;
public class PainterController {
	private boolean inPenMode = true;
	private boolean inEraserMode = false;
	@FXML
	private Pane drawingAreaPane;
	@FXML
	void clearButtonPressed(ActionEvent event) {
		drawingAreaPane.getChildren().clear();
	}
	@FXML
	void drawingAreaMouseDragged(MouseEvent event) {
		Circle newCircle = new Circle(event.getX(),event.getY(),4);
		if (inPenMode) {
			newCircle.setFill(Color.BLACK);
		} else if (inEraserMode) {
			newCircle.setFill(Color.WHITE);
		}
		drawingAreaPane.getChildren().add(newCircle);
	}
	@FXML
	void penModeSelected(ActionEvent event) {
		inPenMode = true;
		inEraserMode = false;
	}
	@FXML
	void eraserModeSelected(ActionEvent event) {
		inPenMode = false;
		inEraserMode = true;
	}

}

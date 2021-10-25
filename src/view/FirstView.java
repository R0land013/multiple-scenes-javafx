package view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import presenter.FirstPresenter;

public class FirstView extends VBox implements PresenterView{
	
	private Scene scene;
	
	
	private FirstPresenter presenter;
	
	@FXML
	private Label label;
	
	@FXML
	private Button nextButton;
	
	@FXML
	private Button exitButton;
	
	
	public FirstView(FirstPresenter presenter) {
		this.presenter = presenter;
		
		Parent root;
		try {
			URL url = FirstView.class.getResource("/first.fxml");
			FXMLLoader loader = new FXMLLoader(url);
			loader.setRoot(this);
			loader.setController(this);
			root = loader.load();
			scene = new Scene(root, 400, 400);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		
		this.setBackground(new Background(new BackgroundFill(
				Color.rgb(252,108,92), null, getInsets())));
		
		nextButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				presenter.goToSecondScene();	
			}
		});
		
		exitButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				presenter.exit();
			}
		});
	}
	
	

	@Override
	public Scene getViewScene() {
		return scene;
	}

	
}

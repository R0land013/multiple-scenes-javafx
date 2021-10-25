package view;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import presenter.SecondPresenter;

public class SecondView extends VBox implements PresenterView{

	private Scene scene;
	private SecondPresenter presenter;
	
	
	@FXML
	private Label label;
	
	@FXML
	private Button nextButton;
	
	@FXML
	private Button returnButton;
	
	public SecondView(SecondPresenter presenter) {
		
		this.presenter = presenter;
		
		
		try {
			FXMLLoader loader = new FXMLLoader(SecondView.class.getResource("/second.fxml"));
			loader.setRoot(this);
			loader.setController(this);
			Parent root = loader.load();
			scene = new Scene(root, 400, 400);
			
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		
		this.setBackground(new Background(new BackgroundFill(
				Color.rgb(120,211,107), null, getInsets())));
		
		nextButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				presenter.goToThirdScene();				
			}
		});
		
		returnButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				presenter.returnToFirstScene();
			}
		});
	}
	
	
	@Override
	public Scene getViewScene() {
		// TODO Auto-generated method stub
		return scene;
	}

}

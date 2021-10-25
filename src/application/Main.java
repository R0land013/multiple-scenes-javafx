package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import presenter.FirstPresenter;
import presenter.PresenterManager;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		
		primaryStage.setTitle("Multiple Scenes JavaFX");
		
		PresenterManager manager = new PresenterManager(primaryStage);
		FirstPresenter firstPresenter = new FirstPresenter(manager);
		
		
		manager.setInitialPresenter(firstPresenter);
		manager.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

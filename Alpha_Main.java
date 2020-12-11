import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Alpha_Main extends Application {

	private Stage primaryStage;
	private Pane mainLayout;

	Scene scene1, scene2;
	public static Stage parentWindow;

	public void start(Stage primaryStage) throws IOException {

		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Database");
		showMainView();

	}

	private void showMainView() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("SceneMain2.fxml"));
		mainLayout = loader.load();
		Scene scene = new Scene(mainLayout);
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
@SuppressWarnings("unused")
public class Alpha_Controller implements Initializable {
	Stage primaryStage;
	Scene scene1, scene2;
	@FXML private PasswordField pfPassword;
	@FXML private TextField tfUsername;
	@FXML private TextArea taInformation;
	@FXML private Label lbPassword;
	@FXML private Button btRegister;
	@FXML private Label lbUsername;
	@FXML private Button Validate;
	@FXML public Label lbIncorrect;
	@FXML private AnchorPane login;
	@FXML private Button logout;
	@FXML private Label u1;
	@FXML private Button cancel;
	@FXML private AnchorPane pane;
	@FXML private TextField tfNewUserName;
	@FXML private TextField tfEmail;
	@FXML private TextField pfNewUserPassword;
	@FXML private TextField tfNewUserConfirmPassword;
	@FXML private Button btCancelSignup;
	@FXML private Button btCreateAccount;
	@FXML private Label lbPasswordMismatch;
	@FXML private TextField tfFirstName;
	@FXML private TextField tfLastName;
	@FXML private CheckBox cbMale;
	@FXML private CheckBox cbFemale;
	@FXML void tfNewUserConfirmPassword(ActionEvent event) {}
	@FXML void tfFirstName(ActionEvent event) {}
	@FXML void tfLastName(ActionEvent event) {}
	@FXML void tfEmail(ActionEvent event) {}
	@FXML void tfNewUserName(ActionEvent event) {}
	@FXML void pfNewUserPassword(ActionEvent event) {}
    @FXML
    private AnchorPane helppane;

//////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@FXML void btRegister(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("SceneCreate.fxml"));
		Pane mainPane = loader.load();
		primaryStage = (Stage) ((Button) (event.getSource())).getScene().getWindow();
		Scene scene1 = new Scene(mainPane);
		primaryStage.setScene(scene1);
		primaryStage.show();}

//////////////////////////////////////////////////////////////////////////////////////////////////////////
	@SuppressWarnings("static-access")
	@FXML void btValidate(ActionEvent event) throws IOException {
		Boolean found = false;
		lbIncorrect.setVisible(false);
		int i = 0;
		Info myInfo = new Info();
		if (myInfo.updateOnce == true) {
			myInfo.updateUsers();
			myInfo.updateOnce = false;
		}
		System.out.println(myInfo.myUsers());
		while (found != true && i != myInfo.myUsers().size()) {
			String[] split = myInfo.myUsers().get(i).split(",");
			for (String a : split) {
				if ((tfUsername.getText() + pfPassword.getText()).equals(split[0] + split[1])) {
					found = true;	}}
			i++;
		}
		if (!found) {
			lbIncorrect.setVisible(true);
		}
		if (found) {
			Stage stage;
			Parent root;
			stage = (Stage) ((Button) (event.getSource())).getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("SceneDatabase.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}

	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////
	@FXML void btCancelSignup(ActionEvent event) throws IOException {
		// Scene 3 -> Scene 1
		FXMLLoader loader = new FXMLLoader(getClass().getResource("SceneMain2.fxml"));
		Pane mainPane = loader.load();
		primaryStage = (Stage) ((Button) (event.getSource())).getScene().getWindow();
		Scene scene1 = new Scene(mainPane);
		primaryStage.setScene(scene1);
		primaryStage.show();

	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////
	@FXML void btCreateAccount(ActionEvent event) throws IOException {

		lbPasswordMismatch.setVisible(false);
		Info myInfo = new Info();
		myInfo.myUsers();

		if (!tfEmail.getText().isEmpty() && !tfNewUserName.getText().isEmpty() && !tfFirstName.getText().isEmpty()
				&& !tfLastName.getText().isEmpty()
				&& pfNewUserPassword.getText().equals(tfNewUserConfirmPassword.getText())) {

			myInfo.myUsers().add(tfNewUserName.getText() + "," + tfNewUserConfirmPassword.getText() + ","
					+ tfEmail.getText() + "," + tfFirstName.getText() + "," + tfLastName.getText());

			System.out.println(myInfo.myUsers());

			myInfo.getNewUser(
					tfNewUserName.getText() + "," + tfNewUserConfirmPassword.getText() + "," + tfEmail.getText());

			FXMLLoader loader = new FXMLLoader(getClass().getResource("SceneMain2.fxml"));
			Pane mainpane = loader.load();
			primaryStage = (Stage) ((Button) (event.getSource())).getScene().getWindow();
			Scene scene1 = new Scene(mainpane);
			primaryStage.setScene(scene1);
			primaryStage.show();

		} else {
			lbPasswordMismatch.setVisible(true);
		}

		System.out.println(myInfo.myUsers());

	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////
	@FXML void btLogout(ActionEvent event) throws IOException {
		// Add shortcut to save for future situations
		FXMLLoader loader = new FXMLLoader(getClass().getResource("SceneMain2.fxml"));
		Pane mainPane = loader.load();
		primaryStage = (Stage) ((Button) (event.getSource())).getScene().getWindow();
		Scene scene1 = new Scene(mainPane);
		primaryStage.setScene(scene1);
		primaryStage.show();
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////
	@FXML void btCancel(ActionEvent event) {
		pfPassword.setText("");
		tfUsername.setText("");
		lbIncorrect.setVisible(false);

	}

    @FXML
    void backback(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("SceneMain2.fxml"));
		Pane mainPane = loader.load();
		primaryStage = (Stage) ((Button) (event.getSource())).getScene().getWindow();
		Scene scene1 = new Scene(mainPane);
		primaryStage.setScene(scene1);
		primaryStage.show();

    }
 @FXML void Help(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("SceneHelp.fxml"));
		Pane mainPane = loader.load();
		primaryStage = (Stage) ((Button) (event.getSource())).getScene().getWindow();
		Scene scene1 = new Scene(mainPane);
		primaryStage.setScene(scene1);
		primaryStage.show();}
	
	


	   
	   		@FXML TableView<Person> table;
	@FXML
	TableColumn<Person, String> col_id = new TableColumn();
	@FXML
	TableColumn<Person, String> col_fname = new TableColumn();
	@FXML
	TableColumn<Person, String> col_lname = new TableColumn();
	@FXML
	TableColumn<Person, String> col_email = new TableColumn();

	ObservableList<Person> list = FXCollections.observableArrayList(

			new Person("Person1 ", "Name1", "Lname1 ", "Email1 "),
			new Person("Person2 ", "Name2", "Lname2 ", "Email2 "),
			new Person("Person3 ", "Name3", "Lname3 ", "Email3 ")

	);

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		col_id.setCellValueFactory(new PropertyValueFactory<Person, String>("id"));
		col_fname.setCellValueFactory(new PropertyValueFactory<Person, String>("fname"));
		col_lname.setCellValueFactory(new PropertyValueFactory<Person, String>("lname"));
		col_email.setCellValueFactory(new PropertyValueFactory<Person, String>("email"));
		//table.setItems(list);

	}
}
	
	



	
	
	
		

	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


package View;
//NAME: Dmitry Gusev
//ID:316923200
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class NewBallot {
private Group root;
private CheckBox cbArmy,cbCorona;
private TextField tfAdress;
private Button submit;	
private Stage stage;
	
	public NewBallot(Stage stage) {
		root = new Group();
		this.stage=stage;
		Text txt1=new Text("Ballor Creator");
		txt1.setFont(new Font(50));
		Text txt2=new Text("Please enter the required information for creating a party at the form below.");
		txt2.setFont(new Font(20));
		Text txt3=new Text("Adress: ");
		txt3.setFont(new Font(20));
		Text txt4=new Text("Please sign if one of the Special requiarements required ");
		txt4.setFont(new Font(20));
	
		tfAdress=new TextField();
		tfAdress.setMaxSize(200, 10);
		HBox hb1=new HBox();
		hb1.setAlignment(Pos.CENTER_LEFT);
		hb1.getChildren().addAll(txt3,tfAdress);
		HBox.setMargin(txt3, new Insets(10,5,10,5));
		HBox.setMargin(tfAdress, new Insets(10,5,10,5));
		
		submit=new Button("Creat Ballot");
		
		
		cbArmy=new CheckBox("Military");
		cbCorona=new CheckBox("Sick");
		HBox hb2=new HBox();
		hb2.setAlignment(Pos.CENTER_LEFT);
		hb2.getChildren().addAll(cbArmy,cbCorona);
		HBox.setMargin(cbArmy, new Insets(20,10,40,100));
		HBox.setMargin(cbCorona, new Insets(20,40,40,10));
		
		VBox vb=new VBox();
		vb.getChildren().addAll(txt1,txt2,hb1,txt4,hb2,submit);
		 VBox.setMargin(txt1, new Insets(10,5,10,100));
		 VBox.setMargin(txt2, new Insets(20,5,20,5));
		 VBox.setMargin(hb1, new Insets(10,5,5,5));
		 VBox.setMargin(hb2, new Insets(5,5,5,5));
		 VBox.setMargin(submit, new Insets(50,50,50,100));
		
		
		root.getChildren().addAll(vb,submit);
		Scene scene=new Scene(root,700,400);
		submit.setLayoutX(scene.getWidth()/2-20);
		submit.setLayoutY(330);
		stage.setScene(scene);
		stage.show();
	}
	
	public String getAdress() {
		return tfAdress.getText();
	}
	
	public boolean getArmy() {
		return cbArmy.isSelected();
	}
	
	public boolean getSick() {
		return cbCorona.isSelected();
	}

	public void addEventHandlerToButton(EventHandler<ActionEvent> event) {
		submit.setOnAction(event);
		
	}

	public void close() {
		stage.close();
		
	}
}

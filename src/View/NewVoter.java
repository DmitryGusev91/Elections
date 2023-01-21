package View;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class NewVoter {
	protected Group root;
	protected TextField tfName, tfId, tfbirthYear, tfballotNum, tfSickDays;
	protected RadioButton rbYes, rbNo;
	protected Button submit;
	protected ToggleGroup tg;
	protected Text txt7;
	protected Stage stage;
	protected VBox vb;


	public NewVoter(Stage stage) {
		root = new Group();
		this.stage=stage;
		Text txt1, txt2, txt3, txt4, txt5, txt6,txt8;
		txt1 = new Text("Voter Creator");
		txt1.setFont(new Font(50));
		txt2 = new Text("Please enter the required information for creating a voter at the form below.");
		txt2.setFont(new Font(20));
		txt3 = new Text("Name: ");
		txt3.setFont(new Font(20));
		txt4 = new Text("ID: ");
		txt4.setFont(new Font(20));
		txt5 = new Text("Birthyear: ");
		txt5.setFont(new Font(20));
		txt6 = new Text("Ballot number: ");
		txt6.setFont(new Font(20));
		txt7 = new Text("Amount of days you were quarantined: \n(if you werent then leave it blacnk)");
		txt7.setFont(new Font(20));
		txt8 = new Text("Where you sick ? ");
		txt8.setFont(new Font(20));

		HBox hb1 = new HBox();
		HBox hb2 = new HBox();
		HBox hb3 = new HBox();
		HBox hb4 = new HBox();
		HBox hb5 = new HBox();
		tfName=new TextField();
		tfballotNum=new TextField();
		tfbirthYear=new TextField();
		tfId=new TextField();
		tfSickDays=new TextField();
		setTextField(tfName, txt3, hb1);
		setTextField(tfId, txt4, hb2);
		setTextField(tfbirthYear, txt5, hb3);
		setTextField(tfballotNum, txt6, hb4);
		setTextField(tfSickDays, txt7, hb5);

		tg = new ToggleGroup();
		rbYes = new RadioButton("Yes");
		rbYes.setToggleGroup(tg);
		rbNo = new RadioButton("No");
		rbNo.setToggleGroup(tg);
		rbNo.setSelected(true);

		HBox yesNo = new HBox();
		yesNo.getChildren().addAll(txt8, rbYes, rbNo);
		HBox.setMargin(rbYes, new Insets(10, 10, 10, 10));
		HBox.setMargin(rbNo, new Insets(10, 10, 10, 10));
		yesNo.setAlignment(Pos.CENTER_LEFT);
		submit = new Button("Creat Voter");
		submit.setLayoutX(300);
		submit.setLayoutY(420);

		vb = new VBox();
		vb.getChildren().addAll(txt1, txt2, hb1, hb2, hb3, hb4, yesNo,hb5);
		
		root.getChildren().addAll(vb, submit);
		Scene scene = new Scene(root, 800, 500);
		stage.setScene(scene);
		stage.show();

	}

	public void setTextField(TextField tf, Text txt, HBox hb) {
		tf.setMaxSize(200, 10);
		hb.setAlignment(Pos.CENTER_LEFT);
		hb.getChildren().addAll(txt, tf);
		HBox.setMargin(txt, new Insets(10, 5, 10, 5));
		HBox.setMargin(tf, new Insets(10, 5, 10, 5));
	}

	public boolean getSick() {
		if (rbYes.isSelected())
			return true;
		else
			return false;

	}

	public String getName() {
		return tfName.getText();
	}

	public String getId() {

		return tfId.getText();
	}

	public int getBirthYear() {

		return Integer.parseInt(tfbirthYear.getText());
	}

	public int getBallotNum() {

		return Integer.parseInt(tfballotNum.getText());
	}

	public int getSickDays() {
		if (tfSickDays.getText()!=""&&getSick()==true)
			return Integer.parseInt(tfSickDays.getText());
		else
			return 0;
	}

	public void addEventHandlerToButton(EventHandler<ActionEvent> creatVoter) {
		submit.setOnAction(creatVoter);

	}

public void close() {
	stage.close();
}


	

	


}

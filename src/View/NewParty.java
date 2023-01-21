package View;
//NAME: Dmitry Gusev
//ID:316923200
import id316923200.Party.Faction;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class NewParty {
	private Group root;
	private RadioButton rbLeft,rbMiddle,rbRight;
	private ToggleGroup tg;
	private TextField tfDay,tfMonth,tfYear,tfName;
	private Button submit;
	private Stage stage;
	
	
public NewParty(Stage stage) {
	root=new Group();
	this.stage=stage;
	Text txt1=new Text("Party Creator");
	txt1.setFont(new Font(50));
	Text txt2=new Text("Please enter the required information for creating a party at the form below.");
	txt2.setFont(new Font(20));
	Text txt3=new Text("Name of Party: ");
	txt3.setFont(new Font(20));
	Text txt4=new Text("Foundation date: ");
	txt4.setFont(new Font(20));
	Text txt5=new Text("Parties wing: ");
	txt5.setFont(new Font(20));
	Text txt6=new Text("\\");
	txt6.setFont(new Font(20));
	Text txt7=new Text("\\");
	txt7.setFont(new Font(20));
		
	tfName=new TextField();
	tfName.setMaxSize(200, 10);
	HBox hb2=new HBox();
	hb2.setAlignment(Pos.CENTER_LEFT);
	hb2.getChildren().addAll(txt3,tfName);
	HBox.setMargin(txt3, new Insets(10,5,10,5));
	HBox.setMargin(tfName, new Insets(10,5,10,5));
	
	tfDay=new TextField();
	tfDay.setMaxSize(30, 10);
	tfMonth=new TextField();
	tfMonth.setMaxSize(30, 10);
	tfYear=new TextField();
	tfYear.setMaxSize(45, 10);
	
	HBox hb3=new HBox();
	hb3.setAlignment(Pos.CENTER_LEFT);
	hb3.getChildren().addAll(txt4,tfDay,txt6,tfMonth,txt7,tfYear);
	HBox.setMargin(txt4, new Insets(10,5,10,5));
	HBox.setMargin(tfDay, new Insets(10,5,10,5));
    HBox.setMargin(txt6, new Insets(10,5,10,5));
	HBox.setMargin(tfMonth, new Insets(10,5,10,5));
	HBox.setMargin(txt7, new Insets(10,5,10,5));
	HBox.setMargin(tfYear, new Insets(10,5,10,5));
	
	tg=new ToggleGroup();
	rbLeft=new RadioButton("Left Wing");
	rbLeft.setToggleGroup(tg);
	rbRight=new RadioButton("Right Wing");
	rbRight.setToggleGroup(tg);
	rbMiddle=new RadioButton("Middle Wing");
	rbMiddle.setToggleGroup(tg);
	
	HBox hb1=new HBox();
	hb1.getChildren().addAll(rbLeft,rbMiddle,rbRight);
	HBox.setMargin(rbLeft, new Insets(10,10,40,10));
	HBox.setMargin(rbRight, new Insets(10,10,40,10));
	HBox.setMargin(rbMiddle, new Insets(10,10,40,10));
	hb1.setAlignment(Pos.CENTER);
	
	submit=new Button("Creat Party");
	submit.setLayoutX(300);
	submit.setLayoutY(400);
	
	VBox vb=new VBox();
	vb.getChildren().addAll(txt1,txt2,hb2,hb3,txt5,hb1);
	 VBox.setMargin(txt1, new Insets(10,5,10,100));
	 VBox.setMargin(txt2, new Insets(20,5,20,5));
	 VBox.setMargin(txt5, new Insets(10,5,5,5));
	 VBox.setMargin(hb2, new Insets(5,5,5,5));
	 
	
	root.getChildren().addAll(vb,submit);
	Scene scene=new Scene(root,700,500);
	stage.setScene(scene);
	stage.show();
	
	
}


public  Faction getKind() {
	if(rbLeft.isSelected())
		return Faction.left;
	else if(rbMiddle.isSelected())
		return Faction.middle;
	else return Faction.right;
}
public int getDay() {
	int d=Integer.parseInt(tfDay.getText());
	return d;
}
public int getMonth() {
	int d=Integer.parseInt(tfMonth.getText());
	return d;
}
public int getYear() {
	int d=Integer.parseInt(tfYear.getText());
	return d;
}
public String getName() {
	return tfName.getText();
}

public  void addEventHandlerToButton(EventHandler<ActionEvent> creatParty) {
	submit.setOnAction(creatParty);
	

}
public void close() {
	stage.close();
}





}

package View;

import id316923200.ListOfParties;
import id316923200.Voter;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class VotingForm {
	private Group root;
	private Text txt1,txt2,txt3,txt4;
	private ComboBox<String>comboParties;
	private Stage stage;
	private ToggleGroup tg;
	private RadioButton rbYes,rbNo;
	private Button submit;
	private int voterNum;
	
public VotingForm(Stage stage,Voter v,ListOfParties l,int voterNum){
	root=new Group();
	this.stage=stage;
	this.voterNum=voterNum;
	txt1 = new Text("Voting Process");
	txt1.setFont(new Font(50));
	txt2=new Text("Voters Information:\n"+v.toString());
	txt2.setFont(new Font(20));
	txt3=new Text("Is he going to vote?");
	txt3.setFont(new Font(20));
	txt4=new Text("WichParty is he voting for ?");
	txt4.setFont(new Font(20));
	
	tg=new ToggleGroup();
	rbYes=new RadioButton("Yes");
	rbYes.setToggleGroup(tg);
	rbNo=new RadioButton("No");
	rbNo.setToggleGroup(tg);
	rbNo.setSelected(true);
	
	
	
	comboParties=new ComboBox<String>();
	for(int i=0;i<l.getSize();i++) {
		comboParties.getItems().add(l.getObject(i).getName());
	}
	HBox hb1=new HBox();
	hb1.getChildren().addAll(txt4,comboParties);
	hb1.setAlignment(Pos.CENTER);
	HBox.setMargin(txt4, new Insets(20,40,20,20));
	
	HBox hb2=new HBox();
	hb2.getChildren().addAll(txt3,rbYes,rbNo);
	HBox.setMargin(rbYes, new Insets(10, 10, 10, 10));
	HBox.setMargin(rbNo, new Insets(10, 10, 10, 10));
	hb2.setAlignment(Pos.CENTER_LEFT);
	
	VBox vb=new VBox();
	vb.getChildren().addAll(txt1,txt2,hb2,hb1);
	submit=new Button("Submit");
	submit.setLayoutX(350);
	submit.setLayoutY(400);
	
	root.getChildren().addAll(vb,submit);
	Scene scene=new Scene(root,800,500);
	stage.setScene(scene);
	stage.show();
}

public String getParty() {
	return comboParties.getValue();
}
public boolean getIfVoting() {
	if(rbYes.isSelected())
		return true;
	else 
		return false;
}
public int getVoterNum() {
	return voterNum;
}

public void close() {
	stage.close();
	
}

public void addEventhandlerToButton(EventHandler<ActionEvent> vote) {
	submit.setOnAction(vote);
	
}
}

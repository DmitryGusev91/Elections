package View;
//NAME: Dmitry Gusev
//ID:316923200
import id316923200.Party.Faction;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class View {
	private Button addBallot,addVoter,addParty,addCandidate,showBallots,showVoters,showParties,startVoting,results,exit;
	
	
	
public View(Stage stage) {
	Text txt=new Text("Pick one of the following options:");
	addBallot=new Button("Add a Ballot");
	addVoter= new Button("Add a Voter");
	addParty=new Button("Add a Party");
	addCandidate=new Button("Add a Candidate for a party");
	showBallots=new Button("Show information about all the Ballots");
	showVoters=new Button("Show information about all the Voters");
	showParties=new Button("Show information about all the parties");
	startVoting=new Button("Start Voting");
	results=new Button("Show voting Results");
	exit=new Button("Exit");
	
	
	
	VBox vb=new VBox();
	vb.getChildren().addAll(txt,addBallot,addVoter,addParty,addCandidate,showBallots,showVoters,showParties,startVoting,results,exit);
	vb.setAlignment(Pos.CENTER_LEFT);
	VBox.setMargin(addBallot, new Insets(5,5,5,5));
	VBox.setMargin(addVoter, new Insets(5,5,5,5));
	VBox.setMargin(addParty, new Insets(5,5,5,5));
	VBox.setMargin(addCandidate, new Insets(5,5,5,5));
	VBox.setMargin(showBallots, new Insets(5,5,5,5));
	VBox.setMargin(showVoters, new Insets(5,5,5,5));
	VBox.setMargin(showParties, new Insets(5,5,5,5));
	VBox.setMargin(startVoting, new Insets(5,5,5,5));
	VBox.setMargin(results, new Insets(5,5,5,5));
	VBox.setMargin(exit, new Insets(5,5,5,5));
	
	exit.setPrefSize(250, 15);
	addBallot.setPrefSize(250, 15);
	addVoter.setPrefSize(250, 15);
	addParty.setPrefSize(250, 15);
	addCandidate.setPrefSize(250, 15);
	showBallots.setPrefSize(250, 15);
	showParties.setPrefSize(250, 15);
	showVoters.setPrefSize(250, 15);
	startVoting.setPrefSize(250, 15);
	results.setPrefSize(250, 15);
	
	
	
	Scene scene=new Scene(vb,500,400);
	stage.setScene(scene);
	stage.show();
	
	
	
}
public String getName() {
	if(addBallot.isArmed()) {
		return "addBallot";}
	if(addCandidate.isArmed()) {
		return "addCandidate";}
	if(addParty.isArmed()) {
		return "addParty";}
	if(addVoter.isArmed()) {
		return "addVoter";}
	if(showVoters.isArmed()) {
		return "showVoters";}
	if(showBallots.isArmed()) {
		return "showBallots";}
	if(showParties.isArmed()) {
		return "showParties";}
	if(results.isArmed()) {
		return "results";}
	if(startVoting.isArmed()) {
		return "startVoting";}
	else return "exit";
}
public void exit() {
	System.exit(0);
	
}
public void addEventHandlerToMainButtons(EventHandler<ActionEvent> event) {
	addBallot.setOnAction(event);
	addCandidate.setOnAction(event);
	addParty.setOnAction(event);
	addVoter.setOnAction(event);
	showBallots.setOnAction(event);
	showParties.setOnAction(event);
	showVoters.setOnAction(event);
	startVoting.setOnAction(event);
	results.setOnAction(event);
	exit.setOnAction(event);
	
}


}

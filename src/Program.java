import Controller.Controller;

import View.View;
import id316923200.Election;
import id316923200.Party.Faction;
import javafx.application.Application;
import javafx.stage.Stage;
//NAME: Dmitry Gusev
//ID:316923200
public class Program extends Application {
	public static void main(String[] args) {
		launch(args);
		
		
		
		
		
		
		
		
		
	}

	@Override
	public void start(Stage stage) throws Exception {
		Election e=new Election();
		
		View v=new View(stage);

		Controller c=new Controller(v,e);
		
		
		
		e.addVoter("Dima", "316834672", 1991, 1, false, 0);

		e.addVoter("Or", "746893457", 2002, 2, false, 0);
		e.addVoter("Shir", "678930460", 1990, 3, true, 20);
		e.addVoter("Moran", "123456789", 1990, 1, false, 0);
		e.addVoter("David", "987654321", 1980, 3, true, 15);

		e.addParty("Lefty", Faction.left, 4, 6, 1960);
		e.addParty("Righty", Faction.right, 15, 1, 1967);
		e.addParty("Middly", Faction.middle, 30, 30, 1981);

		e.addCandidate("Shimona", "678934516", 1999, 2, false, 0, "Lefty");
		e.addCandidate("Shimon", "678934576", 1999, 2, false, 0, "Lefty");
		e.addCandidate("Izhak", "845734870", 1925, 3, true, 17, "Lefty");
		e.addCandidate("Oleg", "466965100", 1980, 1, false, 0, "Righty");
		e.addCandidate("Rivka", "128458568", 1999, 2, false, 0, "Righty");
		e.addCandidate("Gogo", "128569465", 1933, 1, false, 6, "Middly");
		e.addCandidate("Penguin", "123456780", 1976, 1, false, 0, "Middly");

		e.addBallot("Elm st.", 1);
		e.addBallot("Apple st.", 2);// army
		e.addBallot("Peach st.", 3);// sick
		

	}
	
	
}

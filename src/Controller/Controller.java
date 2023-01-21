package Controller;
//NAME: Dmitry Gusev
//ID:316923200

import View.NewBallot;
import View.NewCandidate;
import View.NewParty;
import View.NewVoter;
import View.Results;
import View.Show;
import View.View;
import View.VotingForm;
import id316923200.Election;
import id316923200.Party.Faction;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class Controller {
	private View theView;
	private Election theElection;


	private String name, id, partyName;
	private int birthYear, ballotNum, sickDays;
	private boolean sick;

	public Controller(View v, Election e) {
		theView = v;
		theElection = e;
		

	
		

		// start the needed procedure with a press of a button in the main menu
		EventHandler<ActionEvent> mainButtons = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				String button = theView.getName();

				switch (button) {
				case ("addBallot"):
					NewBallot nb = new NewBallot(new Stage());
					EventHandler<ActionEvent> creatBallot = new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent event) {
							String adress;
							boolean sick, army;
							int kind;
							adress = nb.getAdress();
							sick = nb.getSick();
							army = nb.getArmy();
							if (sick && !army) // sick Ballot
								kind = 2;
							else if (!sick && army)// army ballot
								kind = 3;
							else if (sick && army)// army AND sick ballot
								kind = 4;
							else
								kind = 1;// regular ballot

							theElection.addBallot(adress, kind);
							nb.close();
						}
					};
					nb.addEventHandlerToButton(creatBallot);
					break;
				case ("addCandidate"):
					NewCandidate nc = new NewCandidate(new Stage());
					// start the candidate builder
					EventHandler<ActionEvent> creatCandidate = new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent event) {
							setVoterInfo(nc);
							partyName = nc.getPartyName();
							theElection.addCandidate(name, id, birthYear, ballotNum, sick, sickDays, partyName);
							nc.close();
						}
					};
					nc.addEventHandlerToButton(creatCandidate);

					break;
				case ("addParty"):
					NewParty np = new NewParty(new Stage());
					// start the party builder
					EventHandler<ActionEvent> creatParty = new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent event) {
							Faction wing;
							String name;
							int day, month, year;
							wing = np.getKind();
							name = np.getName();
							day = np.getDay();
							month = np.getMonth();
							year = np.getYear();
							theElection.addParty(name, wing, day, month, year);
							np.close();
						}

					};
					np.addEventHandlerToButton(creatParty);

					break;
				case ("addVoter"):
					NewVoter nv = new NewVoter(new Stage());
					// start voter builder
					EventHandler<ActionEvent> creatVoter = new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent event) {
							setVoterInfo(nv);
							theElection.addVoter(name, id, birthYear, ballotNum, sick, sickDays);
							nv.close();

						}
					};
					nv.addEventHandlerToButton(creatVoter);
					break;
				case ("results"):
					theElection.finalCount();
					System.out.println(theElection.getPartyList().getObject(0).getName());
					Results r = new Results(new Stage(),theElection.getFinalResults(),theElection.getDay(),theElection.getMonth(),theElection.getYear(),theElection.partyList);
					break;
				case ("showBallots"):
					Show sb = new Show(new Stage(), "Ballots");
					sb.updateText(theElection.showBallots());
					break;
				case ("showParties"):
					Show sp = new Show(new Stage(), "Parties");
					sp.updateText(theElection.showParties());
					break;
				case ("showVoters"):
					Show sv = new Show(new Stage(), "Voters");
					sv.updateText(theElection.showVoters());
					break;
				case ("startVoting"):
				
					for (int i = theElection.voterList.getSize() - 1; i >= 0; i--) {
						
						VotingForm vf = new VotingForm(new Stage(), theElection.voterList.getList().getObject(i),
								theElection.partyList,i);
						EventHandler<ActionEvent> vote = new EventHandler<ActionEvent>() {

							@Override
							public void handle(ActionEvent event) {
								boolean isVoting;
								int voterNum;
								String partyName;
								isVoting=vf.getIfVoting();
								voterNum=vf.getVoterNum();
								if(isVoting)
								partyName=vf.getParty();
								else
									partyName="";
								if(isVoting&&partyName=="")
									isVoting=false;
								theElection.setVoterInfo(isVoting, partyName, voterNum);
								vf.close();
							}
						};
						
						vf.addEventhandlerToButton(vote);
					}
				theElection.finalCount();
						System.out.println(theElection.getFinalResults().get(0));
						System.out.println(theElection.getFinalResults().get(1));
						System.out.println(theElection.getFinalResults().get(2));
					break;
				case ("exit"):
					theView.exit();
					break;
				}

			}
		};

		theView.addEventHandlerToMainButtons(mainButtons);

	}

	public void setVoterInfo(NewVoter nv) { // sets information for the given voter to later create the voter
		name = nv.getName();
		id = nv.getId();
		birthYear = nv.getBirthYear();
		ballotNum = nv.getBallotNum();
		sickDays = nv.getSickDays();
		sick = nv.getSick();
	}
}

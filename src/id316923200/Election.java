package id316923200;

//NAME: Dmitry Gusev
//ID:316923200
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import id316923200.Party.Faction;

public class Election implements UI {

	private int day;
	private int month;
	private int year;
	public ListOfVoters voterList;
	public ListOfParties partyList;
	private ListOfBallots ballotList;
	private List<Integer> finalResults;

	public Election(int d, int m, int y) {
		setDay(d);
		setMonth(m);
		setYear(y);
		partyList = new ListOfParties();
		voterList = new ListOfVoters();
		ballotList = new ListOfBallots();
		finalResults = new ArrayList<Integer>();
	}

	public Election() {
		this(1, 1, 2020);
	}

	public String showPartiesNames() {// Strings all the party names
		return partyList.showParties();
	}

	public int partyNum() {// amount of parties
		return partyList.getSize();
	}

	public String showParty(int num) {// shows a specific party at the array at a specific index
		return (partyList.getObject(num - 1)).getName();
	}

	public String showParties() {// Strings all the parties
		return partyList.toString();
	}

	public String showVoters() {// String all the voters on the list
		return voterList.toString();
	}

	public String showBallots() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < ballotList.getSize(); i++) {
			ballotList.getObject(i).countPercentage();
			sb.append(ballotList.getObject(i).toString());
		}
		return sb.toString();
	}

	public boolean addCandidate(String name, String id, int birthYear, int ballotNum, boolean sick, int sickD,
			String pName) {
		if (addVoter(name, id, birthYear, ballotNum, sick, sickD) == true) {
			for (int i = 0; i < voterList.list.getSize(); i++) {
				if (id == (voterList.list.getObject(i)).getID()) {
					(voterList.list.getObject(i)).isACandidate(true);
					(voterList.list.getObject(i)).setPartyName(pName);

					for (int j = 0; j < partyList.getSize(); j++) {
						(partyList.getObject(j)).addToCandidate((voterList.list.getObject(i)));
					}
				}
			}
			return true;
		} else
			return false;
	}

	public boolean addVoter(String name, String id, int birthYear, int ballotNum, boolean sick, int sickD) {
		Voter v;
		try {
			v = new Voter(name, id, birthYear, ballotNum, sick);

		} catch (OutOfRange e) {

			System.out.println(e.getMessage() + "Please try again");
			return false;
		}

		if (voterList.add(v) == false)
			return false;
		v.setSickDays(sickD);
		ballotList.fillBallots(voterList);// Automatically fills the ballot
		return true;
	}

	public void addBallot(String adress, int kind) {// Divided by 3(army , corona or normal ballots)
		if (kind == 1) {
			GenericBallot<String, Boolean, Boolean> b = new GenericBallot<>(adress, false, false);
			b.fillList(voterList);
			ballotList.add(b);
		}
		if (kind == 2) {
			GenericBallot<String, Boolean, Boolean> b = new GenericBallot<>(adress, true, false);
			b.fillList(voterList);
			ballotList.add(b);
		}
		if (kind == 3) {
			GenericBallot<String, Boolean, Boolean> b = new GenericBallot<>(adress, false, true);
			b.fillList(voterList);
			ballotList.add(b);
		}
		if (kind == 4) {
			GenericBallot<String, Boolean, Boolean> b = new GenericBallot<>(adress, true, true);
			b.fillList(voterList);
			ballotList.add(b);
		}
	}

	public void addParty(String name, Faction wing, int day, int month, int year) {
		Party p = new Party(name, wing, day, month, year);
		partyList.add(p);
		ballotList.fillBallots(voterList);// adds the ballots with the new list of parties
	}

	public int getDay() {
		return day;
	}

	public int getMonth() {
		return month;
	}

	public int getYear() {
		return year;
	}

	public boolean setDay(int d) {
		if (day == d)
			return false;
		else {
			if (d > 30 || d < 1)
				day = 1;
			else
				day = d;
		}
		return true;
	}

	public boolean setMonth(int m) {
		if (month == m)
			return false;
		else {
			if (m > 12 || m < 1)
				month = 1;
			else
				month = m;
		}
		return true;
	}

	public boolean setYear(int y) {
		if (year == y)
			return false;
		else {
			if (y > 2030 || y < 2000)
				year = 2020;
			else
				year = y;
		}
		return true;
	}

	public String getNameByNum(int num) {
		return (voterList.list.getObject(num)).getName();
	}

	public void setVoterInfo(boolean vote, String pName, int vNum) {
		(voterList.list.getObject(vNum)).goingToVote(vote);
		(voterList.list.getObject(vNum)).setPartyName(pName);
	}

	public int ballotNum() {
		return ballotList.getSize();
	}

	public boolean chooseBallot(int num, boolean sick, boolean soldier) {// checks that the ballots that you choose are
																			// sinhronized with the voter (sick one to a
																			// corona ballot)
		for (int i = 0; i < ballotList.getSize(); i++) {
			if (num == (ballotList.getObject(i)).getBallotNum()) {// if the voters ballot number equal the given
																	// ballot
				if (sick == true && (ballotList.getObject(i)).getSick() == true)// if he is sick and the ballot is
																				// for sick
					return true;
				else if (soldier == true && (ballotList.getObject(i)).getArmy() == true)// if he is a soldier and it
																						// is and army ballot
					return true;
				else if (soldier == true && sick == true && (ballotList.getObject(i)).getSick() == true
						&& (ballotList.getObject(i)).getArmy() == true)

					return true;
				else if (sick == false && soldier == false && (ballotList.getObject(i)).getSick() == false
						&& (ballotList.getObject(i)).getArmy() == false)
					// if the numbers of the ballots match but
					// you are not sick or a soldier
					return true;
			}
		}
		return false;
	}

	public void finalCount() {
		Integer num;
		for (int i = 0; i < partyList.getSize(); i++) {// goes through the parties
			finalResults.add(0);// initialize every party to 0 voices
		}
		for (int i = 0; i < partyList.getSize(); i++) {// goes through the parties
			num = 0;
			for (int j = 0; j < partyList.getSize(); j++) {// goes through all the ballots
				(ballotList.getObject(j)).voteCounting(partyList);// the ballot should make a counting of their
																	// voices
				num += ballotList.getObject(j).getVoice(i);// count all the voices of all the ballots to a
															// Specific party

			}
			finalResults.set(i, num);// add the total voices to the parties index ,that way the party and her voices
										// are at the same index
		}
	}

	public void finalCount1() {
		
		for (int i = 0; i < partyList.getSize(); i++) {// goes through all parties
			int count = 0;
			for (int j = 0; j < ballotList.getSize();j++) {// goes through all ballots
				for (int k = 0; k < ballotList.getObject(j).getVoterList().getSize(); k++) {// goes through all voters
					System.out.println(partyList.getSize());
					System.out.println(ballotList.getObject(j).getVoterList().getList().getObject(k).getPartyName());
					System.out.println(partyList.getObject(i).getName());															// in a certain ballot
					if (ballotList.getObject(j).getVoterList().getList().getObject(k).getIfVoting() == true
							&& ballotList.getObject(j).getVoterList().getList().getObject(k).getPartyName() == partyList
									.getObject(i).getName())
						
						count++;

				}
			}
			finalResults.add(count);
		}
		
	}

	public String toStringEachPartyVote() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < ballotList.getSize(); i++) {
			sb.append(ballotList.getObject(i).voteResults(partyList));
		}
		return sb.toString();
	}

	public String toStringFinalResults() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < partyList.getSize(); i++) {
			sb.append(((Party) partyList.getObject(i)).getName() + "-----" + finalResults.get(i) + "\n");// party and
																											// her
																											// voices
																											// are at
																											// same
																											// index
		}
		sb.append("____________________");
		return sb.toString();
	}

	public boolean equals(Election other) {
		return (this.day == other.day && this.month == other.month && this.year == other.year
				&& this.voterList.equals(other.voterList) && this.partyList.equals(other.partyList)
				&& this.ballotList.equals(other.ballotList) && this.finalResults.equals(other.finalResults));

	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("ELECTIONS HELD ON " + getDay() + "." + getMonth() + "." + getYear() + "\n");
		sb.append(voterList.toString() + "\n");
		sb.append(partyList.toString() + "\n");
		sb.append(ballotList.toString() + "\n");
		sb.append(finalResults.toString());
		return sb.toString();

	}

	public List<Integer> getFinalResults() {
		return finalResults;
	}

	public ListOfParties getPartyList() {
		return partyList;
	}
}

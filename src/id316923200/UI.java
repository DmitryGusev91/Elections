package id316923200;
//NAME: Dmitry Gusev
//ID:316923200
import id316923200.Party.Faction;

public interface UI {

	String showParties();

	String showVoters();

	String showBallots();

	boolean addCandidate(String name, String id, int birthYear, int ballotNum, boolean sick, int sickD, String pName);

	boolean addVoter(String name, String id, int birthYear, int ballotNum, boolean sick, int sickD);

	void addBallot(String adress, int kind);

	void addParty(String name, Faction wing, int day, int month, int year);

	void setVoterInfo(boolean vote, String pName, int vNum);

	String toStringEachPartyVote();

	String toStringFinalResults();

}

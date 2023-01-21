package id316923200;
//NAME: Dmitry Gusev
//ID:316923200
import java.util.ArrayList;
import java.util.List;

public class GenericBallot<T, A, C> {

	public static int serialNum = 0;

	private int ballotNum;
	private String adress;
	public BallotVoterList list;
	private double voterPercentage;
	private List<Integer> voices;
	private boolean corona;
	private boolean army;

	public GenericBallot(T adress, A army, C corona) {
		++serialNum;
		ballotNum = serialNum;
		setAdress(adress);
		setArmy(army);
		setCorona(corona);
		list = new BallotVoterList(serialNum);
		countPercentage();
		voices = new ArrayList<>();

	}
	public int getVoice(int i) {
		return voices.get(i);
	}
	public double getVoterPercentage() {
		return voterPercentage;
	}

	public int getBallotNum() {
		return ballotNum;
	}

	public boolean getSick() {
		return corona;
	}

	public boolean getArmy() {
		return army;
	}
	public String getAdress() {
		return adress;
	}
	public BallotVoterList getList() {
		return list;
	}

	public boolean setArmy(A army) {
		if (this.army == (boolean) army)
			return false;
		else
			this.army = (boolean) army;
		return true;
	}

	public boolean setCorona(C corona) {
		if (this.corona == (boolean) corona)
			return false;
		else
			this.corona = (boolean) corona;
		return true;
	}

	public boolean setAdress(T adress) {
		if (this.adress != null && this.adress.equals(adress))
			return false;
		else
			this.adress = (String) adress;
		return true;
	}

	public double countPercentage() {
		int count = 0;
		for (int i = 0; i < list.list.getSize(); i++) {
			if (list.getObject(i) != null && (list.getObject(i)).getIfVoting())// counts how many are voting
				count++;
		}
		if (list.list.getSize() != 0)
			voterPercentage = (count * 100) / list.list.getSize();// counts the percentage
		return voterPercentage;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("\nBallot number " + ballotNum + " , adress: " + adress + " , have a " + voterPercentage
				+ "% voting .\n");
		for (int i = 0; i < list.list.getSize(); i++) {
			if (list.getObject(i) != null)
				sb.append(list.getObject(i).toString() + "\n");
		}
		return sb.toString();
	}

	public void fillList(ListOfVoters l) {// fills THIS particular ballot from the voter list
		list.fillList(l, corona, army);// sick and soldier have to be false
		countPercentage();
		if(corona==true)
			wearSuits();
	}

	public boolean equals(Object other) {
		if (this.ballotNum == ((GenericBallot<T, A, C>) other).getBallotNum() && this.adress == ((GenericBallot<T, A, C>) other).getAdress() && this.list.equals(((GenericBallot<T, A, C>) other).getList())
				&& this.voterPercentage == ((GenericBallot<T, A, C>) other).getVoterPercentage())
			return true;
		else
			return false;
	}

	public void voteCounting(ListOfParties p) {// counts and fills the result list of this ballot
		for (int i = 0; i < p.getSize(); i++) {// goes through all the parties
			int count = 0;
			for (int j = 0; j < list.getSize(); j++) {// goes through this ballot voter list

				if (( list.getObject(j)).getIfVoting() == true// if the voter is voting
						&& ( p.getObject(i)).getName().equals((list.getObject(j)).getPartyName()))// and
																												// the
																												// name
																												// of
					// the party equals
					// the name that you
					// are voting for
					count++; // then count every time a voter is voting for this party
			}
			voices.add(i, count);// place the votes at the same index in the array as the party is ,this way you
									// can add them up later
		}
	}

	public String voteResults(ListOfParties p) {// prints the name of a party and the amount of votes from the vote list
		StringBuffer sb = new StringBuffer();
		sb.append("Ballot No. " + ballotNum + ":\n");
		for (int i = 0; i < p.getSize(); i++) {
			sb.append( p.getObject(i).getName() + "-----" + voices.get(i) + "\n");
		}
		return sb.toString();
	}


public void wearSuits() {
	for (int i = 0; i < list.getSize(); i++) {
		if (list.getObject(i) != null)
			( list.getObject(i)).setChemSuit(true);
	}
}
public BallotVoterList getVoterList() {
	return list;
}
}
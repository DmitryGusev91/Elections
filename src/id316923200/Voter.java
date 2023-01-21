package id316923200;

//NAME: Dmitry Gusev
//ID:316923200
public class Voter implements Virusable, Candidatable, Votable {
	public static int CURENT_YEAR = 2020;
	private String name;
	private String id;
	private int birthYear;
	private int ballotNum;
	private boolean isQuarantine;
	private boolean goingToVote;
	private boolean isACandidate;
	private String partyName;
	private boolean wearingChemSuit;
	private boolean soldier;
	private boolean carryWeapon;
	private int sickDays;

	public Voter(String name, String id, int birthYear, int ballotNum, boolean sick) throws OutOfRange {
		setName(name);
		if (id.length() == 9)// checks that the id is 9 digits
			this.id = id;
		else
			throw new OutOfRange("You have entered invalid ID number!!!\n");
		if (CURENT_YEAR - birthYear >= 18 && CURENT_YEAR - birthYear <= 100)
			this.birthYear = birthYear;
		else
			throw new OutOfRange("You have entered invalid birth year!!!\n");

		setBallotNum(ballotNum);
		isQuarantined(sick);
		goingToVote(false);
		partyName = "";
		isACandidate(false);
		setChemSuit(false);
		setIsSoldier();
		if (getIsSoldier())
			carryWeapon = true;
		else
			carryWeapon = false;
		setSickDays(0);
	}

	public Voter() throws OutOfRange {
		this("", "000000000", 2000, 0, false);
	}

	public Voter(String name, String id, int birthYear) throws OutOfRange {
		this(name, id, birthYear, 0, false);
	}

	public Voter(String id) throws OutOfRange {
		this("Blanc", id, 2000, 0, false);
	}

	public Voter(String name, String id) throws OutOfRange {
		this(name, id, 2000, 0, false);
	}

	public boolean setName(String name) {
		if (this.name != null && this.name.equals(name))
			return false;
		else {
			this.name = name;
			return true;
		}
	}

	public boolean setBallotNum(int num) {
		if (ballotNum == num)
			return false;
		else {
			ballotNum = num;
			return true;
		}
	}

	public String toString() {
		return "Name: " + name + "		ID: " + id + "	BirthYear: " + birthYear + "	Number of Ballot branch: "
				+ ballotNum;
	}

	public boolean isQuarantined(boolean sick) {
		if (isQuarantine = sick)
			return false;
		else
			isQuarantine = sick;
		return true;
	}

	public int getBallotNum() {
		return ballotNum;
	}

	public boolean setSickDays(int d) {
		if (sickDays == d || getIsQuarantin() == false)
			return false;
		else {
			sickDays = d;
			return true;
		}
	}


	public boolean equals(Object other) {
		if (this.name.equals(((Voter) other).getName()) && this.id.equals( ((Voter) other).getID()) && this.birthYear == ((Voter) other).getBirthYear()
				&& this.ballotNum == ((Voter) other).getBallotNum() && this.isQuarantine == ((Voter)other).isQuarantine)
			return true;
		return false;
	}

	@Override
	public boolean goingToVote(boolean vote) {
		if (goingToVote == vote)
			return false;
		else
			goingToVote = vote;
		return vote;
	}

	public String getName() {
		return name;
	}

	public boolean getIfVoting() {
		return goingToVote;
	}

	@Override
	public boolean isACandidate(boolean running) {
		if (isACandidate)
			return false;
		else
			isACandidate = running;
		return true;

	}

	public boolean getIsACandidate() {
		return isACandidate;
	}

	@Override
	public boolean setPartyName(String n) {
		if (partyName == n || partyName != "")
			return false;
		else
			partyName = n;
		return true;
	}

	public String getPartyName() {
		return partyName;
	}

	public boolean setChemSuit(boolean wear) {
		if (wearingChemSuit == wear)
			return false;
		else
			wearingChemSuit = wear;
		return true;
	}

	public boolean getChemSuit() {
		return wearingChemSuit;
	}

	public boolean setIsSoldier() {
		if (CURENT_YEAR - birthYear <= 21 && CURENT_YEAR - birthYear >= 18) {
			soldier = true;
			return true;
		} else
			return false;
	}

	public boolean getIsSoldier() {
		return soldier;
	}

	public boolean getIsQuarantin() {
		return isQuarantine;
	}

	public String getID() {
		return id;
	}
	public int getBirthYear() {
		return birthYear;
	}
}

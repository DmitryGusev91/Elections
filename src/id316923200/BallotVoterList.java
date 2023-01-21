package id316923200;
//NAME: Dmitry Gusev
//ID:316923200
public class BallotVoterList extends ListOfVoters {
	private int ballotNum;

	public BallotVoterList(int ballotNum) {
		super();
		this.ballotNum = ballotNum;
	}

	public BallotVoterList() {
		this(0);
	}

	public void fillList(ListOfVoters vList, boolean sick, boolean soldier) {

		for (int i = 0; i < vList.getVoterNum(); i++) {
			if (( vList.list.getObject(i)).getBallotNum() == ballotNum
					&& ( vList.list.getObject(i)).getIsQuarantin() == sick
					&& ( vList.list.getObject(i)).getIsSoldier() == soldier)
				add(vList.list.getObject(i));
		}

	}

	public boolean equals(BallotVoterList other) {
		return super.equals(other) && this.ballotNum == other.ballotNum;
	}
	
	public String toString() {
		return super.toString();
	}
	public Voter getObject(int i) {
		return list.getObject(i);
	}
}

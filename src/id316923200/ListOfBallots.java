package id316923200;

//NAME: Dmitry Gusev
//ID:316923200
public class ListOfBallots {// is the list of all the ballots
	private Set<GenericBallot> list;

	public ListOfBallots() {
		list = new Set<GenericBallot>();
	}

	public boolean add(GenericBallot g) {
		try {
			list.add(g);
			return true;
			}catch (ExistingObject e) {
			System.out.println(e.getMessage()+"Please try again");
			return false;
			}
	}

	public boolean remove(GenericBallot g) {
		if (list.remove(g))
			return true;
		else
			return false;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < list.getSize(); i++) {
			sb.append(list.getObject(i) + "\n");
		}
		return sb.toString();
	}

	public boolean equals(ListOfBallots other) {
		if(list.equals(other.list))
			return true;
		else return false;
	}

	public void fillBallots(ListOfVoters l) {// goes through each ballot and with the voter list fills the ballots with
												// the voters that are supposed to be there(by their health status,age
												// status and ballot number)

		for (int i = 0; i < list.getSize(); i++) {
			((GenericBallot) list.getObject(i)).fillList(l);// each ballot fills
		}
	}
	public int getSize() {
		return list.getSize();
	}
	public GenericBallot getObject(int i) {
		return list.getObject(i);
	}
}

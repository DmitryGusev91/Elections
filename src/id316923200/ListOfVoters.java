package id316923200;
//NAME: Dmitry Gusev
//ID:316923200
public class ListOfVoters  {
	protected Set<Voter> list;

public ListOfVoters() {
	list=new Set<Voter>();
}
	
	public boolean add(Voter v) {
		try {
		list.add(v);
		return true;
		}catch (ExistingObject e) {
		System.out.println(e.getMessage()+"Please try again");
		return false;
		}
	}	

	public boolean remove(Voter v) {
		if(list.remove(v))
			return true;
		else
			return false;
	}
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < list.getSize(); i++) {
			sb.append("#"+(i+1)+" "+list.getObject(i) + "\n");
		}
		return sb.toString();
	}
	
	public boolean equals(ListOfVoters other) {
		if(this.list.equals(other.list))
			return true;
		else 
			return false;
	}

	public int getVoterNum() {
		return list.getSize();
		
	}
		
	public int getSize() {
		return list.getSize();
	}
	public Set<Voter> getList() {
		return list;
	}
}

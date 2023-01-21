package id316923200;
//NAME: Dmitry Gusev
//ID:316923200
public class ListOfParties {
	private Set<Party> list;

public ListOfParties() {
	list=new Set<Party>();
}
	
	public boolean add(Party p) {
		try {
			list.add(p);
			return true;
			}catch (ExistingObject e) {
			System.out.println(e.getMessage()+"Please try again");
			return false;
			}
	}	

	public boolean remove(Party p) {
		if(list.remove(p))
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
	
	
	public boolean equals(ListOfParties other) {
		if(list.equals(other.list))
			return true;
		else return false;
	}
	public String showParties() {
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<list.getSize();i++) {//goes through all the parties and Strings their names
		sb.append((i+1)+"  "+((Party) list.getObject(i)).getName()+"\n");
	}
		sb.append("\n");
		return sb.toString();
	}
public int getSize() {
	return list.getSize();
}
public Party getObject(int i) {
	return list.getObject(i);
}
}

package id316923200;
//NAME: Dmitry Gusev
//ID:316923200
import java.util.ArrayList;
import java.util.List;

public class Set<T> {
	private List<T> list;

	public Set() {
		list = new ArrayList<T>();

	}

	public boolean add(T t) throws ExistingObject{
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) != null && list.get(i).equals(t)) {
				throw new ExistingObject("This object already exists\n");
				}
			if(list.get(i) instanceof Voter&& t instanceof Voter&&((Voter) t).getID().equals(((Voter) list.get(i)).getID())){
				throw new ExistingObject("Voter with this ID already exists\n");
			}
				
		}
		list.add(t);
		return true;
	}

	public boolean remove(T t) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) == null)
				return false;
		}
		list.remove(t);
		return true;
	}

	public int getSize() {
		return list.size();
	}

	public T getObject(int i) {
		return list.get(i);
	}


	public boolean equals(Set<T> other) {
		if (list.equals(other.list))
			return true;
		else
			return false;
	}




}

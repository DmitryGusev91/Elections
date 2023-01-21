package id316923200;

import java.util.ArrayList;
import java.util.List;

//NAME: Dmitry Gusev
//ID:316923200
public class Party {
	public enum Faction {
		left, right, middle
	}

	private String name;
	private Faction wing;
	private int day;
	private int month;
	private int year;
	private List candidates;

	public Party(String name, Faction wing, int day, int month, int year) {
		setName(name);
		this.wing = wing;
		setDay(day);
		setMonth(month);
		setYear(year);
		candidates = new ArrayList();
	}

	public Party(String name, Faction wing) {
		this(name, wing, 1, 1, 2020);
	}

	public Party(String name) {
		this(name, Faction.middle, 1, 1, 2020);
	}

	public Party() {
		this("blanc", Faction.middle, 1, 1, 2020);
	}

	public boolean setName(String name) {
		if (this.name != null && this.name.equals(name))
			return false;
		else
			this.name = name;
		return true;
	}

	public boolean setDay(int day) {
		if (this.day != day) {
			if (day <= 30 && day > 0)
				this.day = day;
			else
				this.day = 1;
			return true;
		}
		return false;
	}

	public boolean setMonth(int month) {
		if (this.month != month) {
			if (month <= 12 && month > 0)
				this.month = month;
			else
				this.month = 1;
			return true;
		}
		return false;
	}

	public boolean setYear(int year) {
		if (this.year != year) {
			if (year <= 2020 && year > 1948)
				this.year = year;
			else
				this.year = 2020;
			return true;
		}
		return false;
	}

	public boolean addToCandidate(Voter v) {
		if (v.getIsACandidate() && v.getPartyName().equals(name))	{			
					candidates.add(v);
					return true;}
				
			
		return false;
	}

	public boolean equals(Object other) {
		if (this.name.equals(((Party) other).getName()) && this.wing == ((Party) other).getWing() && this.day == ((Party) other).getDay()
				&& this.month == ((Party) other).getMonth() && this.year == ((Party) other).getYear()) {		
					return true;
			
		}
		return false;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Party name: " + name + ", " + wing + " wing , formation date: " + day + "." + month + "." + year
				+ "\nCandidate list:\n");
		for (int i = 0; i < candidates.size(); i++) {
			if (candidates.get(i) != null)
				sb.append(candidates.get(i).toString() + "\n");
		}
		return sb.toString();
	}

	public String getName() {
		return name;
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
	public Faction getWing() {
		return wing;
	}
}

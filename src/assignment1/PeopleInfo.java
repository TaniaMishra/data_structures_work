package assignment1;

public class PeopleInfo {

	private String name;
	private String age;
	private String gender;
	private int repeats;		//number of times the same name is repeated
	
	public PeopleInfo() {
		name = "NOT ENTERED";
		age = "NOT ENTERED";
		gender = "NOT ENTERED";
		repeats = 0;
	}
	public PeopleInfo(String n, String a, String g) {
		name = n;
		age = a;
		gender = g;
		repeats = 0;
	}
	
	public String getName() {
		return name;
	}
	public String getAge() {
		return age;
	}
	public String getGender() {
		return gender;
	}
	public int getRepeats() {
		return repeats;
	}
	public void addRepeat() {
		repeats++;
	}
}

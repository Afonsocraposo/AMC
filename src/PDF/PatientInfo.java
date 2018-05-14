package PDF;

import java.util.ArrayList;

public class PatientInfo {
	
	public String name;
	public String gender;
	public int birth_day;
	public int birth_month;
	public int birth_year;
	public String doctor;
	public String exam;
	public String result;
	public ArrayList<Integer> signs;
	public String comments;
	
	public PatientInfo( ) {
		name = "John Doe";
		gender = "M";
		birth_day = 1;
		birth_month = 1;
		birth_year = 1997;
		doctor = "Unknown";
		exam = "EXAM";
		result = "INCONCLUSIVE";
		signs = new ArrayList<Integer>();
	}
	
	

}

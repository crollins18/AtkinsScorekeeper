import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Scorekeeper {
	
	private ArrayList<Team> teams = new ArrayList<Team>();
	private Team t1;
	private Team t2;
	private String scoreName;
	
	public Scorekeeper() {
		Scanner f = null;
		try {
			 f = new Scanner(new File("Prefs.dat"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		f.nextLine();
		
		while(f.hasNextLine()) {
			String tempName = f.nextLine();
			String[] temp = tempName.split("\t\t\t");
			teams.add(new Team(temp[0], temp[1]));			
		}
	
		
	}
	
	public ArrayList<Team> getAllTeams() {
		return teams;
	}
	
	public void printSetTeams() {
		System.out.println(t1);
		System.out.println(t2);
	}

	public void setTeams(Team t1t, Team t2t) {
		t1 = t1t;
		t2 = t2t;
	}
	
	public Team getSetTeam1() {
		return t1;
	}
	
	public Team getSetTeam2() {
		return t2;
	}
	
	public void setNameScoreName(String inStr) {
		scoreName = inStr;
	}
	
	public String getNameScoreName() {
		return scoreName;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scorekeeper main = new Scorekeeper();
		
		for(Team t: main.getAllTeams()) {
			System.out.println(t.getTeamName() + "\t" + t.getTeamImage());
		}

	}

}

import java.io.File;

public class Team {
	
	private String teamName;
	private String teamImage;
	private int score;
	
	public Team(String teamName, String teamImage) {
		this.teamName = teamName;
		this.teamImage = teamImage;
		score = 0;
	}
	
	public String getTeamName() {
		return teamName;
	}
	
	public String getTeamImage() {
		return teamImage;
	}
	
	public String toString() {
		return teamName;
	}
	
	public int getScore() {
		return score;
	}

}

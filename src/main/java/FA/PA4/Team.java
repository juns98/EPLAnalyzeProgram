package FA.PA4;

public class Team {
	int teamnum;

	String getTeamname(int teamnum) {
		switch (teamnum) {
		case 1:
			return "Arsenal";
		case 2:
			return "Aston Villa";
		case 3:
			return "Brighton";
		case 4:
			return "Burnley";
		case 5:
			return "Chelsea";
		case 6:
			return "Crystal Palace";
		case 7:
			return "Everton";
		case 8:
			return "Fulham";
		case 9:
			return "Leeds United";
		case 10:
			return "Leicester City";
		case 11:
			return "Liverpool";
		case 12:
			return "Manchester City";
		case 13:
			return "Manchester United";
		case 14:
			return "Newcastle United";
		case 15:
			return "Sheffield United";
		case 16:
			return "Southampton";
		case 17:
			return "Tottenham Hotspur";
		case 18:
			return "West Bromwich";
		case 19:
			return "West Ham United";
		case 20:
			return "Wolverhampton Wanderers";
		default:
			return "Error";
		}

	}

}
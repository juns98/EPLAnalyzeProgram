package FA.PA4;

import java.util.*;
import java.util.Map.Entry;

class getTopPlayers {
	HashMap<Integer, Player> playerlist;

	getTopPlayers(HashMap<Integer, Player> playerlist) {
		this.playerlist = playerlist;
	}

	List<Map.Entry<String, Integer>> Sort(String category) {
		int value = 0;

		Map<String, Integer> all = new HashMap<>();
		Map<String, Integer> sorted = new HashMap<>();
		for (int i = 0; i < playerlist.size(); i++) {
			if (category.equals("goals")) {
				value = playerlist.get(i).getGoals();
			} else if (category.equals("assists")) {
				value = playerlist.get(i).getAssists();
			} else if (category.equals("saves")) {
				value = playerlist.get(i).getSaves();
			} else if (category.equals("cleansheets")) {
				value = playerlist.get(i).getCsheets();
			} else if (category.equals("own_goal")) {
				value = playerlist.get(i).getOg();
			} else if (category.equals("penalty_saved")) {
				value = playerlist.get(i).getPksaved();
			} else if (category.equals("yc")) {
				value = playerlist.get(i).getYc();
			} else if (category.equals("rc")) {
				value = playerlist.get(i).getRc();
			} else if (category.equals("minutes")) {
				value = playerlist.get(i).getMins();
			} else if (category.equals("goals_conceded")) {
				value = playerlist.get(i).getGoalscnd();
			} else if (category.equals("penalty_missed")) {
				value = playerlist.get(i).getPkmissed();
			} else if (category.equals("points_contribution")) {
				value = playerlist.get(i).getPts();
			}

			all.put(playerlist.get(i).getName(), value);
		}

		List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(all.entrySet());
		Collections.sort(list, new Comparator<Entry<String, Integer>>() {
			public int compare(Entry<String, Integer> obj1, Entry<String, Integer> obj2) {

				return obj2.getValue().compareTo(obj1.getValue());
			}
		});

		for (Entry<String, Integer> entry : list) {
			sorted.put(entry.getKey(), entry.getValue());
		}
		return list;
	}

	Map<String, Integer> getTops(String category, List<Map.Entry<String, Integer>> sortedlist, int numOfPlayers) {
		Map<String, Integer> tops = new HashMap<>();
		int i = 0;
		System.out.println("Top ten");
		for (Entry<String, Integer> entry : sortedlist) {
			i++;
			tops.put(entry.getKey(), entry.getValue());
			System.out.println(entry.getKey() + " : " + entry.getValue());
			if (i == numOfPlayers) {
				break;
			}
		}
		return tops;
	}
}

package com.term.termproject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class dataSort {
      HashMap<Integer, Player> playerlist;
       getTopPlayers top = new getTopPlayers(playerlist);
       List<Map.Entry<String, Integer>> sortedMins;
       List<Map.Entry<String, Integer>> sortedGoals;
       List<Map.Entry<String, Integer>> sortedAssists;
       List<Map.Entry<String, Integer>> sortedCsheets;
       List<Map.Entry<String, Integer>> sortedGoalscnd;
       List<Map.Entry<String, Integer>> sortedOgs;
       List<Map.Entry<String, Integer>> sortedPksaved;
       List<Map.Entry<String, Integer>> sortedPkmissed;
       List<Map.Entry<String, Integer>> sortedYc;
       List<Map.Entry<String, Integer>> sortedRc;
       List<Map.Entry<String, Integer>> sortedSaves;
       List<Map.Entry<String, Integer>> sortedInflrank;
       List<Map.Entry<String, Integer>> sortedCretrank;
       List<Map.Entry<String, Integer>> sortedThrtrank;
       List<Map.Entry<String, Integer>> sortedIctrank;
       List<Map.Entry<String, Integer>> sortedPts;
    
    dataSort(HashMap<Integer, Player> playerlist) {
        this.playerlist = playerlist;
        this.top = new getTopPlayers(playerlist);
     }
    
    public void makeSort() {
       this.sortedMins = top.Sort("minutes");
        this.sortedGoals = top.Sort("goals");
        this.sortedAssists = top.Sort("assists");
        this.sortedCsheets = top.Sort("cleansheets");
        this.sortedGoalscnd = top.Sort("goals_conceded");
        this.sortedOgs = top.Sort("own_goal");
        this.sortedPksaved = top.Sort("penalty_saved");
        this.sortedPkmissed = top.Sort("penalty_missed");
        this.sortedYc = top.Sort("yc");
        this.sortedRc = top.Sort("rc");
        this.sortedSaves = top.Sort("saves");
        this.sortedInflrank = top.Sort("influence_rank");
        this.sortedCretrank = top.Sort("creativity_rank");
        this.sortedThrtrank = top.Sort("threat_rank");
        this.sortedIctrank = top.Sort("ict_index_rank");
        this.sortedPts = top.Sort("points_contribution");
    }
    
    Map<String, Integer> getSorted(String input, int num) {
        Map<String, Integer> tops = new HashMap<>();
        if (input.equals("minutes")) {
           tops = top.getTops(input, this.sortedMins, num);
        }
        else if (input.equals("goals")) {
           tops = top.getTops(input, this.sortedGoals, num);
        }
        else if (input.equals("assists")) {
           tops = top.getTops(input, this.sortedAssists, num);
        }
        else if (input.equals("cleansheets")) {
           tops = top.getTops(input, this.sortedCsheets, num);
        }
        else if (input.equals("goals_conceded")) {
           tops = top.getTops(input, this.sortedGoalscnd, num);
        }
        else if (input.equals("own_goal")) {
           tops = top.getTops(input, this.sortedOgs, num);
        }
        else if (input.equals("penalty_saved")) {
           tops = top.getTops(input, this.sortedPksaved, num);
        }
        else if (input.equals("penalty_missed")) {
           tops = top.getTops(input, this.sortedPkmissed, num);
        }
        else if (input.equals("yc")) {
           tops = top.getTops(input, this.sortedYc, num);
        }
        else if (input.equals("rc")) {
           tops = top.getTops(input, this.sortedRc, num);
        }
        else if (input.equals("saves")) {
           tops = top.getTops(input, this.sortedSaves, num);
        }
        else if (input.equals("influence_rank")) {
           tops = top.getTops(input, this.sortedInflrank, num);
        }
        else if (input.equals("creativity_rank")) {
           tops = top.getTops(input, this.sortedCretrank, num);
        }
        else if (input.equals("threat_rank")) {
           tops = top.getTops(input, this.sortedThrtrank, num);
        }
        else if (input.equals("ict_index_rank")) {
           tops = top.getTops(input, this.sortedIctrank, num);
        }
        else if (input.equals("points_contribution")) {
           tops = top.getTops(input, this.sortedPts, num);
        }
        
        return tops;
    }
}
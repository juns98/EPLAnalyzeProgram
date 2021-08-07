package com.term.termproject;

import java.util.*;
import java.util.Map.Entry;

import org.json.JSONArray;
import org.json.JSONObject;

class computeData {
   HashMap<Integer, Player> playerlist;
   int[] max = new int[16];

   computeData(HashMap<Integer, Player> playerlist) {
      this.playerlist = playerlist;
      dataSort sort = new dataSort(playerlist);
      sort.makeSort();
      max[0] = sort.sortedMins.get(0).getValue();
      max[1] = sort.sortedGoals.get(0).getValue();
      max[2] = sort.sortedAssists.get(0).getValue();
      max[3] = sort.sortedCsheets.get(0).getValue();
      max[4] = sort.sortedGoalscnd.get(0).getValue();
      max[5] = sort.sortedOgs.get(0).getValue();
      max[6] = sort.sortedPksaved.get(0).getValue();
      max[7] = sort.sortedPkmissed.get(0).getValue();
      max[8] = sort.sortedYc.get(0).getValue();
      max[9] = sort.sortedRc.get(0).getValue();
      max[10] = sort.sortedSaves.get(0).getValue();
      max[11] = sort.sortedInflrank.get(0).getValue();
      max[12] = sort.sortedCretrank.get(0).getValue();
      max[13] = sort.sortedThrtrank.get(0).getValue();
      max[14] = sort.sortedIctrank.get(0).getValue();
      max[15] = sort.sortedPts.get(0).getValue();
   }

   double getSum(double[] data, int id) {
      double sum = 0;
      for (int i = 0; i < 16; i++) {
         if (data[i] != 0) {
            sum += (addData(i, id) * data[i]);
         }
      }
      return sum;
   }

   double addData(int i, int id) {
      double val = 0.0;
      double factor;
      
      if (i > 10 && i < 15)
         factor = 10000 / playerlist.size();
      else
         factor = 10000 / max[i];

      if (i == 0) {
         val = playerlist.get(id).getMins() * factor;
      } else if (i == 1) {
         val = playerlist.get(id).getGoals() * factor;
      } else if (i == 2) {
         val = playerlist.get(id).getAssists() * factor;
      } else if (i == 3) {
         val = playerlist.get(id).getCsheets() * factor;
      } else if (i == 4) {
         val = playerlist.get(id).getGoalscnd() * factor;
      } else if (i == 5) {
         val = playerlist.get(id).getOg() * factor;
      } else if (i == 6) {
         val = playerlist.get(id).getPksaved() * factor;
      } else if (i == 7) {
         val = playerlist.get(id).getPkmissed() * factor;
      } else if (i == 8) {
         val = playerlist.get(id).getYc() * factor;
      } else if (i == 9) {
         val = playerlist.get(id).getRc() * factor;
      } else if (i == 10) {
         val = playerlist.get(id).getSaves() * factor;
      } else if (i == 11) {
         val = (10000 - (playerlist.get(id).getInflrank() * factor));
      } else if (i == 12) {
         val = (10000 - (playerlist.get(id).getCretrank() * factor));
      } else if (i == 13) {
         val = (10000 - (playerlist.get(id).getThrtrank() * factor));
      } else if (i == 14) {
         val = (10000 - (playerlist.get(id).getIctrank() * factor));
      } else if (i == 15) {
         val = playerlist.get(id).getPts() * factor;
      }
      return val;
   }

   List<Map.Entry<String, Double>> getYourOwnRank(double[] data) {
      Map<String, Double> all = new HashMap<>();
      Map<String, Double> sorted = new HashMap<>();
      for (int i = 0; i < playerlist.size(); i++) {
         all.put(playerlist.get(i).getName(), getSum(data, playerlist.get(i).getId()));
         // System.out.println("player: " + playerlist.get(i).getName());
      }

      List<Entry<String, Double>> list = new ArrayList<Entry<String, Double>>(all.entrySet());

      Collections.sort(list, new Comparator<Entry<String, Double>>() {
         public int compare(Entry<String, Double> obj1, Entry<String, Double> obj2) {
            return obj2.getValue().compareTo(obj1.getValue());
         }
      });

      for (Entry<String, Double> entry : list) {
         sorted.put(entry.getKey(), entry.getValue());
         // System.out.println(entry.getKey() + " : " + entry.getValue());
      }

      return list;
   }

   Map<String, Double> getTops(double[] data, List<Map.Entry<String, Double>> sortedlist, int numOfPlayers) {
      Map<String, Double> tops = new HashMap<>();
      int i = 0;
      for (Entry<String, Double> entry : sortedlist) {
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
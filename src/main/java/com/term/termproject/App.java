package com.term.termproject;

import java.util.*;
import java.util.Map.Entry;

import org.json.JSONArray;
import org.json.JSONObject;

public class App {
   public static void main(String[] args) throws Exception {
      getApi api = new getApi();
      String json = api.bringApi();
      parseJson pjson = new parseJson(json);
      HashMap<Integer, Player> playerlist;
      playerlist = pjson.getPlayerInfo();
      getTopPlayers top = new getTopPlayers(playerlist);
      List<Map.Entry<String, Integer>> sorted;
      Map<String, Integer> tops = new HashMap<>();
      String input;
      computeData c = new computeData(playerlist);
      Scanner sc = new Scanner(System.in);

      while (true) {
         PrintMainScreen();
         int choice = sc.nextInt();
         if (choice == 1) {
            ViewPlayerInfo(playerlist);
         } else if (choice == 2) {
            ViewRank(playerlist);
         } else if (choice == 3) {
            getOwnRank(playerlist);
         } else if (choice == 4) {
            gameSimulation game = new gameSimulation(playerlist);
            game.selectPlayers(game.selectTeam());
            game.viewEachTeam();
            game.Simulation();
         } else if (choice == 5) {
            System.out.println("Quitting Program");
            return;
         } else {
            System.out.println("Wrong Input. Try Again");
         }
      }
   }

   static void PrintMainScreen() {
      System.out.println("--------------------------------------------------------------------------------");
      System.out.println("|                               Epl Analyzer                                   |");
      for (int i = 0; i < 5; i++) {
         System.out.println("|                                                                              |");
      }
      System.out.println("|                               Select Menu                                    |");

      System.out.println("|                           1. View Player Information                         |");
      System.out.println("|                           2. Show Rank                                       |");
      System.out.println("|                           3. Customize your own Rank                         |");
      System.out.println("|                           4. Match Simulation                                |");
      for (int i = 0; i < 5; i++) {
         System.out.println("|                                                                              |");
      }
      System.out.println("|                                 Quit: 5                                      |");
      System.out.println("|                                                                              |");
      System.out.println("--------------------------------------------------------------------------------");
      System.out.print("        Select:");
   }

   static void ViewPlayerInfo(HashMap<Integer, Player> playerlist) {
      Scanner sc = new Scanner(System.in);
      while (true) {
         System.out.println("--------------------------Select Category--------------------------");
         System.out.println("1. I know Player's name");
         System.out.println("2. If you don't know, Search Team name");
         System.out.println("3. Go Back\n");
         System.out.print("        Select:");
         int input = sc.nextInt();
         System.out.println(input);
         if (input == 1) {
            System.out.print("--------------------------Type Player's name: ");
            String player = sc.next();
            int invalidcnt = 0;
            for (int i = 0; i < playerlist.size(); i++) {
               if (playerlist.get(i).getName().equals(player)) {
                  invalidcnt--;
                  Player p = playerlist.get(i);
                  p.printPlayerInfo2(playerlist.get(i));
                  continue;
               }
               invalidcnt++;
            }
            if (invalidcnt == playerlist.size())
               System.out.println("Invalid Name");
         } else if (input == 2) {
            Team team = new Team();
            System.out.println("Team Lists:\n 1: Arsenal / 2: Aston Villa / 3: Brighton / 4: Burnley / 5: Chelsea\n"
                  + "6: Crystal Palace / 7: Everton / 8: Fulham / 9: Leeds United / 10: Leicester City\n"
                  + "11: Liverpool / 12: Manchester City / 13: Manchester United / 14: Newcastle United / 15: Sheffield United\n"
                  + "16: Southampton / 17: Tottenham Hotspur / 18: West Bromwich / 19: West Ham United / 20: Wolverhampton Wanderers");
            System.out.print("--------------------------Type Team number: ");
            int num = sc.nextInt();
            System.out.println("--------------------------Team " + team.getTeamname(num) + " players list");
            for (int i = 0; i < playerlist.size(); i++) {
               if (playerlist.get(i).getTeam() == num) {
                  System.out.println("----------" + playerlist.get(i).getName());
               }
            }
            System.out.print("Type Player's name: ");
            String player = sc.next();
            int invalidcnt = 0;
            for (int i = 0; i < playerlist.size(); i++) {
               if (playerlist.get(i).getName().equals(player)) {
                  invalidcnt--;
                  Player p = playerlist.get(i);
                  p.printPlayerInfo2(playerlist.get(i));
                  continue;
               }
               invalidcnt++;
            }
            if (invalidcnt == playerlist.size())
               System.out.println("Invalid Name");
         } else if (input == 3) {
            return;
         } else {
            System.out.println("----------Wrong Input. Try Again");
         }
      }
   }

   static void ViewRank(HashMap<Integer, Player> playerlist) {
      Scanner sc = new Scanner(System.in);
      while (true) {
         System.out.println("--------------------------Select Category--------------------------");
         System.out.println(
               "1. goals / 2. assists / 3. saves / 4. cleansheets / 5. own_goal\n6. penalty_saved / 7. yc / 8. rc /"
                     + "9. minutes / 10. goals_conceded / 11. penalty_missed\n");
         System.out.println("12. Go Back\n");
         System.out.print("        Select:");
         int input = sc.nextInt();
         getTopPlayers top = new getTopPlayers(playerlist);
         List<Map.Entry<String, Integer>> sorted;
         Map<String, Integer> tops = new HashMap<>();
         switch (input) {
         case 1:
            sorted = top.Sort("goals");
            tops = top.getTops("goals", sorted, 10);
            break;
         case 2:
            sorted = top.Sort("assists");
            tops = top.getTops("assists", sorted, 10);
            break;
         case 3:
            sorted = top.Sort("saves");
            tops = top.getTops("saves", sorted, 10);
            break;
         case 4:
            sorted = top.Sort("cleansheets");
            tops = top.getTops("cleansheets", sorted, 10);
            break;
         case 5:
            sorted = top.Sort("own_goal");
            tops = top.getTops("own_goal", sorted, 10);
            break;
         case 6:
            sorted = top.Sort("penalty_saved");
            tops = top.getTops("penalty_saved", sorted, 10);
            break;
         case 7:
            sorted = top.Sort("yc");
            tops = top.getTops("yc", sorted, 10);
            break;
         case 8:
            sorted = top.Sort("rc");
            tops = top.getTops("rc", sorted, 10);
            break;
         case 9:
            sorted = top.Sort("minutes");
            tops = top.getTops("minutes", sorted, 10);
            break;
         case 10:
            sorted = top.Sort("goals_conceded");
            tops = top.getTops("goals_conceded", sorted, 10);
            break;
         case 11:
            sorted = top.Sort("penalty_missed");
            tops = top.getTops("penalty_missed", sorted, 10);
            break;
         case 12:
            return;
         default:
            System.out.println("Wrong input");
            break;
         }
      }
   }

   static void getOwnRank(HashMap<Integer, Player> playerlist) {
      Scanner sc = new Scanner(System.in);
      int init = 0;
      int op;
      while (true) {
         if (init != 0) {
            System.out.println("Continue : 1, Go back : 2");
            op = sc.nextInt();
            if (op == 2)
               return;
            else if (op != 1) {
               System.out.println("invalid input");
               continue;
            }
         }
         System.out.println("\nIn this Section you will be customizing you're own player rank");
         System.out
               .println("For these categories, pick a number from 0 to 10. Big numbers are given more priority.");
         System.out.println("If you choose 0, that category won't effect your rank");
         System.out.println(
               "0. minutes played   1. goals          2. assists          3. clean_sheets    4. goals_conceded    5. own_goals");
         System.out.println("6. PK saved       7. Pk missed       8. Yellow cards    9. Red cards       10. Saves");
         System.out.println(
               "11. Influence rank 12. Creativity rank 13. Threat rank       14. ICT rank       15. Team points");
         double[] data = new double[16];
         for (int i = 0; i < 16; i++) {
            System.out.print(i + ": ");
            double num = sc.nextDouble();
            data[i] = num;
         }
         computeData c = new computeData(playerlist);
         Map<String, Double> map = c.getTops(data, c.getYourOwnRank(data), 10);
         init++;
      }
   }
}
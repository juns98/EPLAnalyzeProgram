package com.term.termproject;

import java.util.*;

import org.json.JSONArray;
import org.json.JSONObject;

public class parseJson {
   String json;

   public parseJson(String json) {
      this.json = json;
   }

   HashMap<Integer, Player> getPlayerInfo() {
      HashMap<Integer, Player> playerlists = new HashMap<Integer, Player>();
      JSONObject jobject = new JSONObject(json);
      JSONArray jarray = jobject.getJSONArray("elements");
      
      int j = 0;
      for (int i = 0; i < jarray.length(); i++) {
         JSONObject obj = jarray.getJSONObject(i);
         if (obj.getString("status").equals("u")) {
             continue;
          }

         int team = obj.getInt("team");
         String name = obj.getString("web_name");
         String status = obj.getString("status");
         int pos = obj.getInt("element_type");
         int mins = obj.getInt("minutes");
         int goals = obj.getInt("goals_scored");
         int assists = obj.getInt("assists");
         int csheets = obj.getInt("clean_sheets");
         int goalscnd = obj.getInt("goals_conceded");
         int og = obj.getInt("own_goals");
         int pksaved = obj.getInt("penalties_saved");
         int pkmissed = obj.getInt("penalties_missed");
         int yc = obj.getInt("yellow_cards");
         int rc = obj.getInt("red_cards");
         int saves = obj.getInt("saves");
         int bps = obj.getInt("bps");
         // int chance = obj.getInt("chance_of_playing_next_round");
         int dtcnt = obj.getInt("dreamteam_count");
         String form = obj.getString("value_form");
         String selected = obj.getString("selected_by_percent");
         String influence = obj.getString("influence");
         String creativity = obj.getString("creativity");
         String threat = obj.getString("threat");
         String ict = obj.getString("ict_index");
         int inflrank = obj.getInt("influence_rank");
         int cretrank = obj.getInt("creativity_rank");
         int thrtrank = obj.getInt("threat_rank");
         int ictrank = obj.getInt("ict_index_rank");
         
         int pts = 0;
         if (team == 1) {
            pts = 61;
         }
         else if (team == 2) {
            pts = 55;
         }
         else if (team == 3) {
            pts = 41;
         }
         else if (team == 4) {
            pts = 39;
         }
         else if (team == 5) {
            pts = 67;
         }
         else if (team == 6) {
            pts = 44;
         }
         else if (team == 7) {
            pts = 59;
         }
         else if (team == 8) {
            pts = 28;
         }
         else if (team == 9) {
            pts = 59;
         }
         else if (team == 10) {
            pts = 66;
         }
         else if (team == 11) {
            pts = 69;
         }
         else if (team == 12) {
            pts = 86;
         }
         else if (team == 13) {
            pts = 74;
         }
         else if (team == 14) {
            pts = 45;
         }
         else if (team == 15) {
            pts = 23;
         }
         else if (team == 16) {
            pts = 43;
         }
         else if (team == 17) {
            pts = 62;
         }
         else if (team == 18) {
            pts = 26;
         }
         else if (team == 19) {
            pts = 65;
         }
         else if (team == 20) {
            pts = 45;
         }
         pts = pts * mins / 90;

         
         int id = j;
         Player player = new Player(id);
         
         player.setTeam(team);
         player.setName(name);
         player.setStatus(status);
         player.setPos(pos);
         if (pos == 4) {
            player.setPosition("Attacker");
         }
         else if (pos == 3) {
            player.setPosition("Midfielder");
         }
         else if (pos == 2) {
            player.setPosition("Defender");
         }
         else if (pos == 1) {
            player.setPosition("Goalkeeper");
         }
         player.setMins(mins);
         player.setGoals(goals);
         player.setAssists(assists);
         player.setCsheets(csheets);
         player.setGoalscnd(goalscnd);
         player.setOg(og);
         player.setPksaved(pksaved);
         player.setPkmissed(pkmissed);
         player.setYc(yc);
         player.setRc(rc);
         player.setSaves(saves);
         player.setPts(pts);
         player.setAttack();
         player.setDefense();
         /*
          * if (obj.has("corners_and_indirect_freekicks_order")) { int ck =
          * obj.getInt("corners_and_indirect_freekicks_order"); player.setCk(ck); } int
          * fk = obj.getInt("direct_freekicks_order"); int pk =
          * obj.getInt("penalties_order");
          * 
          * player.setFk(fk); player.setPk(pk);
          */
         player.setBps(bps);
         // player.setChance(chance);
         player.setDtcnt(dtcnt);
         player.setForm(form);
         player.setSelected(selected);
         player.setInfluence(influence);
         player.setCreativity(creativity);
         player.setThreat(threat);
         player.setIct(ict);
         player.setInflrank(inflrank);
         player.setCretrank(cretrank);
         player.setThrtrank(thrtrank);
         player.setIctrank(ictrank);

      //   System.out.print(name + " ");
      //   System.out.println(player.getid() + " " + player.getGoals() + " " + player.getAssists());
         playerlists.put(id, player);
         j++;
      }
      return playerlists;
   }
}
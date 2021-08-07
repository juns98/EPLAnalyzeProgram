package com.term.termproject;

import java.net.HttpURLConnection;
import java.net.URL;

import java.io.*;

public class getApi {
    public String bringApi() throws Exception {
      URL url = new URL("https://fantasy.premierleague.com/api/bootstrap-static/");
      HttpURLConnection con = (HttpURLConnection) url.openConnection();
      con.setRequestMethod("GET");
      BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream())); 
      String inputLine; 
      StringBuffer response = new StringBuffer(); 
      while ((inputLine = in.readLine()) != null) { 
         response.append(inputLine);
      } 
      in.close(); 
      return response.toString();
    }
}

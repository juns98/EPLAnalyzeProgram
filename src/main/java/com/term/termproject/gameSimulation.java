package com.term.termproject;

import java.util.*;

public class gameSimulation {
	HashMap<Integer, Player> playerlist;
	ArrayList<Player> firstTeam = new ArrayList<Player>();
	int[] firstFormation = new int[3];
	ArrayList<Player> secondTeam = new ArrayList<Player>();
	int[] secondFormation = new int[3];
	int homescore = 0;
	int awayscore = 0;

	gameSimulation(HashMap<Integer, Player> playerlist) {
		this.playerlist = playerlist;
	}

	int[] selectTeam() {
		int[] teams = { 0, 0 };
		Scanner sc = new Scanner(System.in);
		int input;
		System.out.println("\n\n--Team Lists--\n\n");
		System.out.println("1: Arsenal / 2: Aston Villa / 3: Brighton / 4: Burnley / 5: Chelsea\n "
				+ "6: Crystal Palace / 7: Everton / 8: Fulham / 9: Leicester City / 10: Leeds United\n"
				+ "11: Liverpool / 12: Manchester City / 13: Manchester United / 14: Newcastle United / 15: Sheffield United\n"
				+ "16: Southampton / 17: Tottenham Hotspur / 18: West Bromwich / 19: West Ham United / 20: Wolverhampton Wanderers\n");
		System.out.println("Select first team(number(1~20)): ");
		input = sc.nextInt();
		teams[0] = input;
		System.out.println("Select second team(number(1~20)): ");
		input = sc.nextInt();
		teams[1] = input;
		return teams;
	}

	void selectPlayers(int[] teamnums) {
		Scanner sc = new Scanner(System.in);
		int num, check;
		String name;
		System.out.println("\nFirst team player list\n");
		for (int i = 0; i < playerlist.size(); i++) {
			if (playerlist.get(i).getTeam() == teamnums[0]) {
				playerlist.get(i).printPlayerInfo(playerlist.get(i));
			}
		}

		System.out.println("\nChoose a formation\n");
		System.out.print("1. num of attackers: ");
		num = sc.nextInt();
		firstFormation[0] = num;
		System.out.print("2. num of midfielders: ");
		num = sc.nextInt();
		firstFormation[1] = num;
		System.out.print("3. num of defenders: ");
		num = sc.nextInt();
		firstFormation[2] = num;

		System.out.println("\nChoose Players");
		System.out.println("Pick " + firstFormation[0] + " Attackers");
		for (int i = 0; i < firstFormation[0]; i++) {
			if (i != 0)
				System.out.print("Player name: ");
			name = sc.nextLine();
			check = 0;
			for (int j = 0; j < playerlist.size(); j++) {
				if (playerlist.get(j).getName().equals(name)) {
					firstTeam.add(playerlist.get(j));
					check += 1;
					break;
				}
			}
			if (check == 0 && i != 0) {
				System.out.println("wrong name");
				i--;
			}
		}
		System.out.println("Pick " + firstFormation[1] + " Midfielders");
		for (int i = 0; i < firstFormation[1]; i++) {
			System.out.print("Player name: ");
			name = sc.nextLine();
			check = 0;
			for (int j = 0; j < playerlist.size(); j++) {
				if (playerlist.get(j).getName().equals(name)) {
					firstTeam.add(playerlist.get(j));
					check += 1;
					break;
				}
			}
			if (check == 0) {
				System.out.println("wrong name");
				i--;
			}
		}
		System.out.println("Pick " + firstFormation[2] + " Defenders");
		for (int i = 0; i < firstFormation[2]; i++) {
			System.out.print("Player name: ");
			name = sc.nextLine();
			check = 0;
			for (int j = 0; j < playerlist.size(); j++) {
				if (playerlist.get(j).getName().equals(name)) {
					firstTeam.add(playerlist.get(j));
					check += 1;
					break;
				}
			}
			if (check == 0) {
				System.out.println("wrong name");
				i--;
			}
		}
		System.out.println("Pick Goalkeeper");
		for (int i = 0; i < 1; i++) {
			System.out.print("Player name: ");
			name = sc.nextLine();
			check = 0;
			for (int j = 0; j < playerlist.size(); j++) {
				if (playerlist.get(j).getName().equals(name)) {
					firstTeam.add(playerlist.get(j));
					check += 1;
					break;
				}
			}
			if (check == 0) {
				System.out.println("wrong name");
				i--;
			}
		}

		System.out.println("\nSecond team player list\n");
		for (int i = 0; i < playerlist.size(); i++) {
			if (playerlist.get(i).getTeam() == teamnums[1]) {
				playerlist.get(i).printPlayerInfo(playerlist.get(i));
			}
		}

		System.out.println("\nChoose a formation\n");
		System.out.print("1. num of attackers: ");
		num = sc.nextInt();
		firstFormation[0] = num;
		System.out.print("2. num of midfielders: ");
		num = sc.nextInt();
		firstFormation[1] = num;
		System.out.print("3. num of defenders: ");
		num = sc.nextInt();
		firstFormation[2] = num;

		System.out.println("\nChoose Players\n");
		System.out.println("Pick " + firstFormation[0] + " Attackers");
		for (int i = 0; i < firstFormation[0]; i++) {
			System.out.print("Player name: ");
			name = sc.nextLine();
			check = 0;
			for (int j = 0; j < playerlist.size(); j++) {
				if (playerlist.get(j).getName().equals(name)) {
					secondTeam.add(playerlist.get(j));
					check += 1;
					break;
				}
			}
			if (check == 0) {
				System.out.println("wrong name");
				i--;
			}

		}
		System.out.println("Pick " + firstFormation[1] + " Midfielders");
		for (int i = 0; i < firstFormation[1]; i++) {
			System.out.print("Player name: ");
			name = sc.nextLine();
			check = 0;
			for (int j = 0; j < playerlist.size(); j++) {
				if (playerlist.get(j).getName().equals(name)) {
					secondTeam.add(playerlist.get(j));
					check += 1;
					break;
				}
			}
			if (check == 0) {
				System.out.println("wrong name");
				i--;
			}
		}
		System.out.println("Pick " + firstFormation[2] + " Defenders");
		for (int i = 0; i < firstFormation[2]; i++) {
			System.out.print("Player name: ");
			name = sc.nextLine();
			check = 0;
			for (int j = 0; j < playerlist.size(); j++) {
				if (playerlist.get(j).getName().equals(name)) {
					secondTeam.add(playerlist.get(j));
					check += 1;
					break;
				}
			}
			if (check == 0) {
				System.out.println("wrong name");
				i--;
			}
		}
		System.out.println("Pick Goalkeeper");
		for (int i = 0; i < 1; i++) {
			System.out.print("Player name: ");
			name = sc.nextLine();
			check = 0;
			for (int j = 0; j < playerlist.size(); j++) {
				if (playerlist.get(j).getName().equals(name)) {
					secondTeam.add(playerlist.get(j));
					check += 1;
					break;
				}
			}
			if (check == 0) {
				System.out.println("wrong name");
				i--;
			}
		}
	}

	void viewEachTeam() {
		System.out.println("First team lineup");
		for (int i = 0; i < firstTeam.size(); i++) {
			firstTeam.get(i).printPlayerInfo(firstTeam.get(i));
		}
		System.out.println("Second team lineup");
		for (int i = 0; i < secondTeam.size(); i++) {
			secondTeam.get(i).printPlayerInfo(secondTeam.get(i));
		}
	}

	void TemporaryTeam() {
		for (int i = 0; i < playerlist.size(); i++) {
			if (playerlist.get(i).getTeam() == 1) {
				firstTeam.add(playerlist.get(i));
			}
			else if (playerlist.get(i).getTeam() == 5) {
				secondTeam.add(playerlist.get(i));
			}
		}
	}

	void Simulation() {
		String team1, team2;
		int temp = firstTeam.get(1).getTeam();
		Team team = new Team();
		team1 = team.getTeamname(temp);
		temp = secondTeam.get(1).getTeam();
		team2 = team.getTeamname(temp);
		homescore = 0;
		awayscore = 0;
		Scoreboard scb = new Scoreboard(homescore, awayscore, team1, team2);
		Thread t0 = new Clock(team1, team2);
		Thread t1 = new Event(firstTeam, secondTeam, team1, team2, this.homescore, this.awayscore, scb);

		try {
			t0.start();
			t1.start();
			t0.join();
			((Event) t1).stopThread();
			t1.join();
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("MATCH ENDED");
		scb.print();
	}
}

class Clock extends Thread {
	String team1;
	String team2;

	Clock(String team1, String team2) {
		this.team1 = team1;
		this.team2 = team2;
	}

	public void run() {
		try {
			System.out.println("Match begin. Home Team: " + team1 + " Away Team: " + team2);
			Random rand = new Random();
			int extra = rand.nextInt(3);
			for (int i = 0; i < 91; i++) {
				Thread.sleep(500);
				System.out.println("Current Minute: " + i);

				if (i == 45) {
					System.out.println("Extra minute: " + extra);
					for (int j = 0; j < extra; j++) {
						Thread.sleep(1000);
						System.out.println("Current Minute: " + (i + j + 1));
					}
				}

				if (i == 90) {
					System.out.println("Extra minute: " + extra);
					for (int j = 0; j < extra; j++) {
						Thread.sleep(1000);
						System.out.println("Current Minute: " + (i + j + 1));
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class Event extends Thread {
	ArrayList<Player> firstTeam;
	ArrayList<Player> secondTeam;
	String team1;
	String team2;
	int homescore, awayscore;
	Scoreboard scb;
	boolean terminationFlag = true;

	public Event(ArrayList<Player> firstTeam, ArrayList<Player> secondTeam, String team1, String team2, int homescore, int awayscore, Scoreboard scb) {
		this.firstTeam = firstTeam;
		this.secondTeam = secondTeam;
		this.team1 = team1;
		this.team2 = team2;
		this.homescore = homescore;
		this.awayscore = awayscore;
		this.scb = scb;
	}

	public void run() {
		int first, second, temp, turn, action, attack, defense;
		Random rand = new Random();
		try {
			while (terminationFlag) {
				// turn = 0 -> home attacking / turn = 1 -> away attacking
				turn = rand.nextInt(2);
				action = rand.nextInt(2);
				Thread.sleep(rand.nextInt(5000));
				try {
					Thread.sleep(500);
				} catch (Exception e) {
					e.printStackTrace();
				}
				if (action == 0) {
					Thread t = new pass(firstTeam, secondTeam, team1, team2, homescore, awayscore, turn, scb);
					t.start();
					t.join();
					t.interrupt();
				}
				else {
					Thread t = new dribble(firstTeam, secondTeam, team1, team2, homescore, awayscore, turn, scb);
					t.start();
					t.join();
					t.interrupt();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void stopThread() {
		terminationFlag = false;
	}
}

class pass extends Thread {
	ArrayList<Player> firstTeam;
	ArrayList<Player> secondTeam;
	String team1;
	String team2;
	int homescore, awayscore, turn;
	Scoreboard scb;

	public pass(ArrayList<Player> firstTeam, ArrayList<Player> secondTeam, String team1, String team2, int homescore, int awayscore, int turn, Scoreboard scb) {
		this.firstTeam = firstTeam;
		this.secondTeam = secondTeam;
		this.team1 = team1;
		this.team2 = team2;
		this.homescore = homescore;
		this.awayscore = awayscore;
		this.turn = turn;
		this.scb = scb;
	}

	public void run() {
		Random rand = new Random();
		int temp1, temp2, ran1, ran2, action;
		try {
			Thread.sleep(500);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (turn == 0) {
			temp1 = rand.nextInt(8) + 1;
			temp2 = rand.nextInt(8) + 1;
			ran1 = rand.nextInt(30);
			ran2 = rand.nextInt(30);
			System.out.println(firstTeam.get(temp1).getName() + " possess the ball");
			action = rand.nextInt(4);
			if (firstTeam.get(temp1).getAttack() + ran1 > secondTeam.get(temp2).getDefense() + ran2) {
				try {
					Thread.sleep(500);
				} catch (Exception e) {
					e.printStackTrace();
				}
				temp1 = rand.nextInt(6);
				while (temp1 != (temp2 = rand.nextInt(6))) {
					System.out.println(
							firstTeam.get(temp1).getName() + " passes the ball to " + firstTeam.get(temp2).getName());
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
						e.printStackTrace();
					}
					temp1 = temp2;
				}
				System.out.println(firstTeam.get(temp1).getName() + " finds the way");
				if (action < 2) {
					if (action == 0)
						System.out.println("and he tries to pick up his teammate");
					else
						System.out.println("and he sends it towards his teammate");
					while ((temp2 = rand.nextInt(6)) == temp1)
						;
					try {
						Thread t = new cross(firstTeam, secondTeam, team1, team2, homescore, awayscore, turn, temp2,
								scb);
						t.start();
						t.join();
						t.interrupt();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else {
					try {
						Thread.sleep(500);
					} catch (Exception e) {
						e.printStackTrace();
					}
					if (action == 2)
						System.out.println("and he tries to take a shot");
					else
						System.out.println("and he takes a long-range shot");
					try {
						Thread t = new shot(firstTeam, secondTeam, team1, team2, homescore, awayscore, turn, temp1,
								scb);
						t.start();
						t.join();
						t.interrupt();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			else {
				try {
					Thread.sleep(500);
				} catch (Exception e) {
					e.printStackTrace();
				}
				if (action < 2)
					System.out.println("and it is nicely defended by " + secondTeam.get(temp2).getName());
				else
					System.out.println("and it is an outstanding tackle by " + secondTeam.get(temp2).getName());
			}
		} else if (turn == 1) {
			temp1 = rand.nextInt(8) + 1;
			temp2 = rand.nextInt(8) + 1;
			ran1 = rand.nextInt(30);
			ran2 = rand.nextInt(30);
			System.out.println("Now it is " + secondTeam.get(temp1).getName() + " who has the ball");
			action = rand.nextInt(4);
			if (secondTeam.get(temp1).getAttack() + ran1 > firstTeam.get(temp2).getDefense() + ran2) {
				try {
					Thread.sleep(500);
				} catch (Exception e) {
					e.printStackTrace();
				}
				temp1 = rand.nextInt(6);
				while (temp1 != (temp2 = rand.nextInt(6))) {
					System.out.println(secondTeam.get(temp1).getName() + " passes the ball to " + secondTeam.get(temp2).getName());
					temp1 = temp2;
				}
				System.out.println(secondTeam.get(temp1).getName() + " finds the way");
				if (action < 2) {
					if (action == 0)
						System.out.println("and he tries to pick up his teammate");
					else
						System.out.println("and he sends it towards his teammate");
					while ((temp2 = rand.nextInt(6)) == temp1)
						;
					try {
						Thread t = new cross(firstTeam, secondTeam, team1, team2, homescore, awayscore, turn, temp2, scb);
						t.start();
						t.join();
						t.interrupt();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				else {
					if (action == 2)
						System.out.println(" tries to take a shot");
					else
						System.out.println(" takes a long-range shot");
					try {
						Thread t = new shot(firstTeam, secondTeam, team1, team2, homescore, awayscore, turn, temp1, scb);
						t.start();
						t.join();
						t.interrupt();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			else {
				try {
					Thread.sleep(500);
				} catch (Exception e) {
					e.printStackTrace();
				}
				if (action < 2)
					System.out.println("and it is nicely defended by " + firstTeam.get(temp2).getName());
				else
					System.out.println("and it is an outstanding tackle by " + firstTeam.get(temp2).getName());
			}
		}
	}
}

class dribble extends Thread {
	ArrayList<Player> firstTeam;
	ArrayList<Player> secondTeam;
	String team1;
	String team2;
	int homescore, awayscore, turn;
	Scoreboard scb;

	public dribble(ArrayList<Player> firstTeam, ArrayList<Player> secondTeam, String team1, String team2, int homescore, int awayscore, int turn, Scoreboard scb) {
		this.firstTeam = firstTeam;
		this.secondTeam = secondTeam;
		this.team1 = team1;
		this.team2 = team2;
		this.homescore = homescore;
		this.awayscore = awayscore;
		this.turn = turn;
		this.scb = scb;
	}

	public void run() {
		Random rand = new Random();
		int temp1, temp2, ran1, ran2, action;

		if (turn == 0) {
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				e.printStackTrace();
			}
			temp1 = rand.nextInt(4) + 1;
			temp2 = rand.nextInt(4) + 1;
			ran1 = rand.nextInt(30);
			ran2 = rand.nextInt(30);
			System.out.println("Now it is " + firstTeam.get(temp1).getName() + " who has the ball");
			action = rand.nextInt(4);
			if (firstTeam.get(temp1).getAttack() + ran1 > secondTeam.get(temp2).getDefense() + ran2) {
				try {
					Thread.sleep(500);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				if (action % 2 == 0)
					System.out.println("He dribbles past " + secondTeam.get(temp2).getName());
				else
					System.out.println("What a lovely skill by " + firstTeam.get(temp1).getName());
				
				if (action < 2) {
					System.out.println("And he crosses the ball");
					try {
						Thread t = new cross(firstTeam, secondTeam, team1, team2, homescore, awayscore, turn, temp1,
								scb);
						t.start();
						t.join();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					System.out.println("And he takes a long range shot");
					try {
						Thread t = new shot(firstTeam, secondTeam, team1, team2, homescore, awayscore, turn, temp1,
								scb);
						t.start();
						t.join();
						t.interrupt();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} else {
				if (action < 2)
					System.out.println("It's a great tackle by " + secondTeam.get(temp2).getName());
				else
					System.out.println(secondTeam.get(temp2).getName() + "easily steals the ball from "
							+ firstTeam.get(temp1).getName());
			}
		} else if (turn == 1) {
			temp1 = rand.nextInt(4) + 1;
			temp2 = rand.nextInt(4) + 1;
			ran1 = rand.nextInt(30);
			ran2 = rand.nextInt(30);
			System.out.println("Now it is " + secondTeam.get(temp1).getName() + " who has the ball");
			action = rand.nextInt(4);
			if (secondTeam.get(temp1).getAttack() + ran1 > firstTeam.get(temp2).getDefense() + ran2) {
				try {
					Thread.sleep(500);
				} catch (Exception e) {
					e.printStackTrace();
				}
				if (action % 2 == 0)
					System.out.println("He dribbles past " + firstTeam.get(temp2).getName());
				else
					System.out.println("What a lovely skill by " + secondTeam.get(temp1).getName());
				
				if (action < 2) {
					try {
						System.out.println("And he crosses the ball");
						Thread t = new cross(firstTeam, secondTeam, team1, team2, homescore, awayscore, turn, temp1,
								scb);
						t.start();
						t.join();
						t.interrupt();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} else {
					System.out.println("And he takes a long range shot");
					try {
						Thread t = new shot(firstTeam, secondTeam, team1, team2, homescore, awayscore, turn, temp1,
								scb);
						t.start();
						t.join();
						t.interrupt();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			} else {
				try {
					Thread.sleep(500);
				} catch (Exception e) {
					e.printStackTrace();
				}
				if (action < 2)
					System.out.println("It's a great tackle by " + firstTeam.get(temp2).getName());
				else
					System.out.println(firstTeam.get(temp2).getName() + "easily steals the ball from "
							+ secondTeam.get(temp1).getName());
			}
		}
	}
}

class cross extends Thread {
	ArrayList<Player> firstTeam;
	ArrayList<Player> secondTeam;
	String team1;
	String team2;
	int homescore, awayscore, turn, who;
	Scoreboard scb;

	public cross(ArrayList<Player> firstTeam, ArrayList<Player> secondTeam, String team1, String team2, int homescore,
			int awayscore, int turn, int who, Scoreboard scb) {
		this.firstTeam = firstTeam;
		this.secondTeam = secondTeam;
		this.team1 = team1;
		this.team2 = team2;
		this.homescore = homescore;
		this.awayscore = awayscore;
		this.turn = turn;
		this.who = who;
		this.scb = scb;
	}

	public void run() {
		Random rand = new Random();
		int temp1, temp2, ran1, ran2, action;
		try {
			Thread.sleep(500);
		} catch (Exception e) {
			e.printStackTrace();
		}

		action = rand.nextInt(2);
		if (turn == 0) {
			temp1 = who;
			temp2 = rand.nextInt(4) + 6;
			ran1 = rand.nextInt(30);
			ran2 = rand.nextInt(30);
			if (firstTeam.get(temp1).getAttack() + ran1 > secondTeam.get(temp2).getDefense() + ran2) {
				try {
					Thread.sleep(500);
				} catch (Exception e) {
					e.printStackTrace();
				}
				if (action == 0)
					System.out.println(firstTeam.get(temp1).getName() + " takes it to a volley");
				else
					System.out.println(firstTeam.get(temp1).getName() + " with a free header");
				try {
					Thread t = new shot(firstTeam, secondTeam, team1, team2, homescore, awayscore, turn, temp1, scb);
					t.start();
					t.join();
					t.interrupt();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			else {
				if (action == 0)
					System.out.println("Great clearance by " + secondTeam.get(temp2).getName());
				else
					System.out.println("Well defended by " + secondTeam.get(temp2).getName());
			}
		}

		else if (turn == 1) {
			temp1 = who;
			temp2 = rand.nextInt(4) + 6;
			ran1 = rand.nextInt(30);
			ran2 = rand.nextInt(30);
			if (secondTeam.get(temp1).getAttack() + ran1 > firstTeam.get(temp2).getDefense() + ran2) {
				try {
					Thread.sleep(500);
				} catch (Exception e) {
					e.printStackTrace();
				}
				if (action == 0)
					System.out.println(secondTeam.get(temp1).getName() + " takes it to a volley");
				else
					System.out.println(secondTeam.get(temp1).getName() + " with a free header");
				try {
					Thread t = new shot(firstTeam, secondTeam, team1, team2, homescore, awayscore, turn, temp1, scb);
					t.start();
					t.join();
					t.interrupt();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			else {
				if (action == 0)
					System.out.println("Great clearance by " + firstTeam.get(temp2).getName());
				else
					System.out.println("Well defended by " + firstTeam.get(temp2).getName());
			}
		}
	}

}

class shot extends Thread {
	ArrayList<Player> firstTeam;
	ArrayList<Player> secondTeam;
	String team1;
	String team2;
	int homescore, awayscore, turn, who;
	Scoreboard scb;

	public shot(ArrayList<Player> firstTeam, ArrayList<Player> secondTeam, String team1, String team2, int homescore,
			int awayscore, int turn, int who, Scoreboard scb) {
		this.firstTeam = firstTeam;
		this.secondTeam = secondTeam;
		this.team1 = team1;
		this.team2 = team2;
		this.homescore = homescore;
		this.awayscore = awayscore;
		this.turn = turn;
		this.who = who;
		this.scb = scb;
	}

	public void run() {
		Random rand = new Random();
		int temp1, temp2, ran1, ran2, action;
		try {
			Thread.sleep(500);
		} catch (Exception e) {
			e.printStackTrace();
		}

		action = rand.nextInt(2);
		if (turn == 0) {
			temp1 = who;
			temp2 = 10;
			ran1 = rand.nextInt(30);
			ran2 = rand.nextInt(30) + 30;
			if (firstTeam.get(temp1).getAttack() + ran1 > secondTeam.get(temp2).getDefense() + ran2) {
				try {
					Thread.sleep(500);
				} catch (Exception e) {
					e.printStackTrace();
				}
				if (action == 0)
					System.out.println("And he scores! " + firstTeam.get(temp1).getName() + " made a fantastic finish!");
				else
					System.out.println("What a sensational goal by " + firstTeam.get(temp1).getName() + "!");
				scb.homescore++;
				scb.print();
			}
			else {
				try {
					Thread.sleep(500);
				} catch (Exception e) {
					e.printStackTrace();
				}
				if (action == 0)
					System.out.println(secondTeam.get(temp2).getName() + " made a terrific save!");
				else
					System.out.println("Just wide of the post");

			}
		}
		else if (turn == 1) {
			temp1 = who;
			temp2 = 10;
			ran1 = rand.nextInt(30);
			ran2 = rand.nextInt(30) + 30;
			if (secondTeam.get(temp1).getAttack() + ran1 > firstTeam.get(temp2).getDefense() + ran2) {
				try {
					Thread.sleep(500);
				} catch (Exception e) {
					e.printStackTrace();
				}
				if (action == 0) {
					System.out.println("And he scores! " + secondTeam.get(temp1).getName() + " made a fantastic finish!");
				}
				else {
					System.out.println("What a sensational goal by " + secondTeam.get(temp1).getName() + "!");
				}
				scb.awayscore++;
				scb.print();
			}
			else {
				try {
					Thread.sleep(500);
				} catch (Exception e) {
					e.printStackTrace();
				}
				if (action == 0)
					System.out.println(firstTeam.get(temp2).getName() + " made a terrific save!");
				else
					System.out.println("Just wide of the post");

			}
		}
	}
}

class Scoreboard {
	int homescore;
	int awayscore;
	String team1;
	String team2;

	Scoreboard(int homescore, int awayscore, String team1, String team2) {
		this.homescore = homescore;
		this.awayscore = awayscore;
		this.team1 = team1;
		this.team2 = team2;
	}

	void print() {
		System.out.println("-------Score: " + team1 + " " + homescore + " - " + awayscore + " " + team2 + "-------");
	}
}
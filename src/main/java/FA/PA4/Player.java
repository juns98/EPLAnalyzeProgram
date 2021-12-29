package FA.PA4;

class Player {
	private String name;
	private String status; // (un)available
	private String position;
	private int team;
	private int pos; // 포지션
	private int mins; // 출전 시간
	private int goals; // 득점
	private int assists; // 도움
	private int csheets; // 클린 시트
	private int goalscnd; // 실점
	private int og; // 자책골
	private int pksaved; // PK 선방
	private int pkmissed; // PK 실축
	private int yc; // 경고
	private int rc; // 퇴장
	private int saves; // 선방
	private int ck; // 코너킥 전담 번호
	private int fk; // 프리킥 전담 번호
	private int pk; // 페널티킥 전담 번호
	private int bps; // bps (종합 스탯 평가)
	private int chance; // 경기 출전 확률
	private int dtcnt; // 드림 팀 카운트
	private String form; // 최근 30일간 폼
	private String selected; // 사용자로부터 선택받은 비율
	private String influence; // 영향력
	private String creativity; // 창의성
	private String threat; // 위협
	private String ict; // ICT(위의 세개 도합)
	private int inflrank; // 영향력 순위
	private int cretrank; // 창의성 순위
	private int thrtrank; // 위협 순위
	private int ictrank; // ICT 순위
	private int id; // 고유 번호
	private int pts; // 승점 기여도

	// 종합 지표
	private double attack;
	private double defense;

	Player(int id) {
		this.id = id;
	}

	public int getId() {
		return this.id;
	}

	public void setAttack() {
		this.attack = goals * 10 + assists * 5;
	}

	public void setDefense() {
		this.defense = (-10) * goalscnd + (-50) * og + 10 * csheets;
	}

	public double getAttack() {
		return this.attack;
	}

	public double getDefense() {
		return this.defense;
	}

	public void printPlayerInfo(Player p) {
		System.out.println("-Name: " + p.getName() + " -Position: " + p.getPosition() + " -Goals: " + p.getGoals()
				+ " -Assists: " + p.getAssists() + " -saves: " + p.getSaves() + " -Minutes Played: " + p.getMins());
	}

	public void printPlayerInfo2(Player p) {
		System.out.println("-Name: " + p.getName() + "\n-Position: " + p.getPosition() + "\n-Goals: " + p.getGoals()
				+ "\n-Assists: " + p.getAssists() + "\n-saves: " + p.getSaves() + "\n-Minutes Played: " + p.getMins()
				+ "\n-Yellow Cards: " + p.getYc() + "\n-Red Cards: " + p.getRc() + "\n-Own goals: " + p.getOg()
				+ "\nICT: " + p.getIct() + "\nInfluence: " + p.getInfluence() + "\nChance of playing: " + p.getChance()
				+ "\nBPS(overall stat): " + p.getBps() + "\nClean Sheets: " + p.getCsheets() + "\nCreativity: "
				+ p.getCreativity() + "\nPoints Contributed: " + p.getPts() + "\nPk saved: " + p.getPksaved());
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getTeam() {
		return team;
	}

	public void setTeam(int team) {
		this.team = team;
	}

	public int getid() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getPos() {
		return pos;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}

	public int getMins() {
		return mins;
	}

	public void setMins(int mins) {
		this.mins = mins;
	}

	public int getGoals() {
		return goals;
	}

	public void setGoals(int goals) {
		this.goals = goals;
	}

	public int getAssists() {
		return assists;
	}

	public void setAssists(int assists) {
		this.assists = assists;
	}

	public int getCsheets() {
		return csheets;
	}

	public void setCsheets(int csheets) {
		this.csheets = csheets;
	}

	public int getGoalscnd() {
		return goalscnd;
	}

	public void setGoalscnd(int goalscnd) {
		this.goalscnd = goalscnd;
	}

	public int getOg() {
		return og;
	}

	public void setOg(int og) {
		this.og = og;
	}

	public int getPksaved() {
		return pksaved;
	}

	public void setPksaved(int pksaved) {
		this.pksaved = pksaved;
	}

	public int getPkmissed() {
		return pkmissed;
	}

	public void setPkmissed(int pkmissed) {
		this.pkmissed = pkmissed;
	}

	public int getYc() {
		return yc;
	}

	public void setYc(int yc) {
		this.yc = yc;
	}

	public int getRc() {
		return rc;
	}

	public void setRc(int rc) {
		this.rc = rc;
	}

	public int getSaves() {
		return saves;
	}

	public void setSaves(int saves) {
		this.saves = saves;
	}

	public int getCk() {
		return ck;
	}

	public void setCk(int ck) {
		this.ck = ck;
	}

	public int getFk() {
		return fk;
	}

	public void setFk(int fk) {
		this.fk = fk;
	}

	public int getPk() {
		return pk;
	}

	public void setPk(int pk) {
		this.pk = pk;
	}

	public int getBps() {
		return bps;
	}

	public void setBps(int bps) {
		this.bps = bps;
	}

	public int getChance() {
		return chance;
	}

	public void setChance(int chance) {
		this.chance = chance;
	}

	public int getDtcnt() {
		return dtcnt;
	}

	public void setDtcnt(int dtcnt) {
		this.dtcnt = dtcnt;
	}

	public String getForm() {
		return form;
	}

	public void setForm(String form) {
		this.form = form;
	}

	public String getSelected() {
		return selected;
	}

	public void setSelected(String selected) {
		this.selected = selected;
	}

	public String getInfluence() {
		return influence;
	}

	public void setInfluence(String influence) {
		this.influence = influence;
	}

	public String getCreativity() {
		return creativity;
	}

	public void setCreativity(String creativity) {
		this.creativity = creativity;
	}

	public String getThreat() {
		return threat;
	}

	public void setThreat(String threat) {
		this.threat = threat;
	}

	public String getIct() {
		return ict;
	}

	public void setIct(String ict) {
		this.ict = ict;
	}

	public int getInflrank() {
		return inflrank;
	}

	public void setInflrank(int inflrank) {
		this.inflrank = inflrank;
	}

	public int getCretrank() {
		return cretrank;
	}

	public void setCretrank(int cretrank) {
		this.cretrank = cretrank;
	}

	public int getThrtrank() {
		return thrtrank;
	}

	public void setThrtrank(int thrtrank) {
		this.thrtrank = thrtrank;
	}

	public int getIctrank() {
		return ictrank;
	}

	public void setIctrank(int ictrank) {
		this.ictrank = ictrank;
	}

	public int getPts() {
		return pts;
	}

	public void setPts(int pts) {
		this.pts = pts;
	}
}
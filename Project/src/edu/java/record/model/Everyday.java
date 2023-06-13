package edu.java.record.model;


public class Everyday{
	public interface Entity{
		String TBL_ENAME = "EVERYDAY";
		String COL_EID = "EID";
		String COL_ECORE = "CORE";
		String COL_ECRETIME = "CREATED_TIME";
		String COL_EMODTIME = "MODIFIED_TIME";
		String COL_ECONTENT = "CONTENT";
		String COL_EMOOD = "MOOD";
		String COL_EWORKOUT = "WORKOUT";
	}
	
	//field
	private int eid;
	private int core;
	private String createdTime;
	private String modifiedTime;
	private String content;
	private String mood;
	private String workout; 

	
	//Constructor
	public Everyday() {}

	public Everyday(int cid, int core, String createdTime, String modifiedTime, String content, 
			String todaysMood, String workout) {
		this.eid = cid;
		this.core = core;
		this.createdTime = createdTime;
		this.modifiedTime = modifiedTime;
		this.content = content;
		this.mood = todaysMood;
		this.workout = workout;
	}
	

	//getters&setters
	public String getModifiedTime() {
		return modifiedTime;
	}
	public void setModifiedTime(String modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTodaysMood() {
		return mood;
	}
	public void setTodaysMood(String todaysMood) {
		this.mood = todaysMood;
	}
	public String getWorkout() {
		return workout;
	}
	public void setWorkout(String workout) {
		this.workout = workout;
	}
	public int getEid() {
		return eid;
	}
	public String getCreatedTime() {
		return createdTime;
	}
	public void setCore(int core) {
		this.core = core;
	}
	public int getCore() {
		return core;
	}

	@Override
	public String toString() {
		return "EverydayLife (eid=" + eid 
				+ ", core=" + core
				+ ", createdTime=" + createdTime 
				+ ", modifiedTime=" + modifiedTime
				+ ", content=" + content
				+ ", todaysMood=" + mood 
				+ ", workout=" + workout 
				+ ")";
	}

	
	
}
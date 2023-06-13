package edu.java.record.model;


public class MonthlyGoal{
	public interface Entity{
		String TBL_MNAME = "MONGOAL";
		String COL_MID = "MID";
		String COL_MGOAL = "GOAL";
	}
	
	private int mid;
	private String goal;
	
	public MonthlyGoal() {}
	public MonthlyGoal(int mid, String goal) {
		this.mid = mid;
		this.goal = goal;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getGoal() {
		return goal;
	}
	public void setGoal(String goal) {
		this.goal = goal;
	}
	@Override
	public String toString() {
		return "MonthlyGoal (mid=" + mid + ", goal=" + goal + ")";
	}
	
	

}

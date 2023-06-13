package edu.java.record.model;

public class Dday{
	public interface Entity{
		String TBL_DNAME = "DDAY";
		String COL_DID = "DID";
		String COL_DTITLE = "DTITLE";
		String COL_DCOUNT = "DCOUNT";
	}
	
	private int did;
	private String dtitle;
	private String dcount;
	public Dday() {
	}
	public Dday(int did, String dtitle, String dcount) {
		this.did = did;
		this.dtitle = dtitle;
		this.dcount = dcount;
	}
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public String getDtitle() {
		return dtitle;
	}
	public void setDtitle(String dtitle) {
		this.dtitle = dtitle;
	}
	public String getDcount() {
		return dcount;
	}
	public void setDcount(String dcount) {
		this.dcount = dcount;
	}
	@Override
	public String toString() {
		return "Dday (did=" + did + ", dtitle=" + dtitle + ", dcount=" + dcount + ")";
	}
	

}

package edu.java.record.model;

public class Culture{
	public interface Entity{
		String TBL_CNAME = "CULTURE";
		String COL_CID = "CID";
		String COL_CCORE = "CORE";
		String COL_CCRETIME = "CREATED_TIME";
		String COL_CMODTIME = "MODIFIED_TIME";
		String COL_CATE = "CATEGORY";
		String COL_CSTARDATE = "START_DATE";
		String COL_CVISITDATE = "VISITED_DATE";
		String COL_CLOCA = "LOCATION";
		String COL_CTITLE = "TITLE";
		String COL_CGENRE = "GENRE";
		String COL_CPRODNAME = "PRO_NM";
		String COL_CCASTNAME = "CAST_NAME";
		String COL_CCONTENT = "CONTENT";

	}
	
	// field 
	private int pid;
	private int core;
	private String createdTime;
	private String modifiedTime;
	private String category;
	private String startDate;
	private String visitedDate;
	private String location;
	private String title;
	private String genre;
	private String producerName;
	private String castName;
	private String content;
	public Culture() {
	}
	public Culture(int pid, int core, String createdTime, String modifiedTime, String category, String startDate,
			String visitedDate, String location, String title, String genre, String producerName, String castName,
			String content) {
		this.pid = pid;
		this.core = core;
		this.createdTime = createdTime;
		this.modifiedTime = modifiedTime;
		this.category = category;
		this.startDate = startDate;
		this.visitedDate = visitedDate;
		this.location = location;
		this.title = title;
		this.genre = genre;
		this.producerName = producerName;
		this.castName = castName;
		this.content = content;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getCore() {
		return core;
	}
	public void setCore(int core) {
		this.core = core;
	}
	public String getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}
	public String getModifiedTime() {
		return modifiedTime;
	}
	public void setModifiedTime(String modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getVisitedDate() {
		return visitedDate;
	}
	public void setVisitedDate(String visitedDate) {
		this.visitedDate = visitedDate;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getProducerName() {
		return producerName;
	}
	public void setProducerName(String producerName) {
		this.producerName = producerName;
	}
	public String getCastName() {
		return castName;
	}
	public void setCastName(String castName) {
		this.castName = castName;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "Culture [pid=" + pid + ", core=" + core + ", createdTime=" + createdTime + ", modifiedTime="
				+ modifiedTime + ", category=" + category + ", startDate=" + startDate + ", visitedDate=" + visitedDate
				+ ", location=" + location + ", title=" + title + ", genre=" + genre + ", producerName=" + producerName
				+ ", castName=" + castName + ", content=" + content + "]";
	}
	
	
	}
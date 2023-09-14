package entity;

public class Bug {
	private int uniqueID;
	private String title,description;
	
	public Bug() {
		super();
	}

	public Bug(int uniqueID, String title, String description) {
		super();
		this.uniqueID = uniqueID;
		this.title = title;
		this.description = description;
	}

	public int getUniqueID() {
		return uniqueID;
	}

	public void setUniqueID(int uniqueID) {
		this.uniqueID = uniqueID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Bug [uniqueID=" + uniqueID + ", title=" + title + ", description=" + description + "]";
	}
	
}

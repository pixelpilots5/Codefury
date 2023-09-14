package entity;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

public class Project {
	private int projectId;
	private String projectName;
	private String description;
	private LocalDate startDate;
	private String status;
	private int teamMembers[];
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int[] getTeamMembers() {
		return teamMembers;
	}
	public void setTeamMembers(int[] teamMembers) {
		this.teamMembers = teamMembers;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(teamMembers);
		result = prime * result + Objects.hash(description, projectId, projectName, startDate, status);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Project other = (Project) obj;
		return Objects.equals(description, other.description) && projectId == other.projectId
				&& Objects.equals(projectName, other.projectName) && Objects.equals(startDate, other.startDate)
				&& Objects.equals(status, other.status) && Arrays.equals(teamMembers, other.teamMembers);
	}
	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", projectName=" + projectName + ", description=" + description
				+ ", startDate=" + startDate + ", status=" + status + ", teamMembers=" + Arrays.toString(teamMembers)
				+ "]";
	}
	public Project(int projectId, String projectName, String description, LocalDate startDate, String status,
			int[] teamMembers) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.description = description;
		this.startDate = startDate;
		this.status = status;
		this.teamMembers = teamMembers;
	}
	public Project(int projectId) {
		super();
		this.projectId = projectId;
	}
	public Project() {
		super();
	}
	
}

package storage;

import java.util.List;

import entity.Project;

public interface ProjectStorage {

	void createProject(Project p);
	Project getProjectById(int projectId);
	List<Project> displayAllProjects();
	void changeStatus(Project p);
}

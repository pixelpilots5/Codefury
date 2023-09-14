package service;

import java.util.List;

import entity.Project;
import exception.NoProjectException;
import exception.ProjectAlreadyExistsException;

public interface ProjectService {
	void createProject(Project p) throws ProjectAlreadyExistsException;
	Project getProjectById(int projectId) throws NoProjectException;
	List<Project> displayAllProjects() throws NoProjectException;
	void changeStatus(Project p) throws NoProjectException;

}

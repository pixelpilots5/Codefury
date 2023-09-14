package service;

import java.util.List;

import entity.Project;
import exception.NoProjectException;
import exception.ProjectAlreadyExistsException;
import storage.ProjectStorage;
import storage.ProjectStorageImpl;

public class ProjectServiceImpl implements ProjectService{
	ProjectStorage storage=new ProjectStorageImpl();

	@Override
	public void createProject(Project p) throws ProjectAlreadyExistsException {
		storage.createProject(p);
		
	}

	@Override
	public Project getProjectById(int projectId) throws NoProjectException {
		Project p=storage.getProjectById(projectId);
		if(p==null) {
			throw new NoProjectException();
			}
		return p;
	}

	@Override
	public List<Project> displayAllProjects() throws NoProjectException {
		List<Project> list=storage.displayAllProjects();
		if(list.isEmpty()) {
			throw new NoProjectException("No projects in the list");
		}
		return list;
	}

	@Override
	public void changeStatus(Project p) throws NoProjectException {
		Project p1=storage.getProjectById(p.getProjectId());
		if(p1==null) {
			throw new NoProjectException("No project exists with that id");
		}
		storage.changeStatus(p1);
		
	}
	

}

package storage;

import java.sql.Array;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import entity.Project;

public class ProjectStorageImpl implements ProjectStorage{
	String url="jdbc:mysql://localhost:3306/project";//project database has project table
	String username="root";
	String password="0405";

	@Override
	public void createProject(Project p) {
		try(Connection connection=DriverManager.getConnection(url, username, password)){
			Object[] array=Arrays.stream(p.getTeamMembers()).mapToObj(i->Integer.valueOf(i)).toArray();
			Array array1=connection.createArrayOf("int", array);
			String sql="INSERT INTO Project (project_id, project_name, project_details, start_date, status, team) VALUES (?, ?, ?, ?, ?, ?)";
			try(PreparedStatement ps=connection.prepareCall(sql)){
				ps.setInt(1, p.getProjectId());
				ps.setString(2, p.getProjectName());
				ps.setString(3, p.getDescription());
				ps.setDate(4, Date.valueOf(p.getStartDate()));
				ps.setString(5, p.getStatus());
				ps.setArray(6, array1);
				ps.executeUpdate();
			}
		}
		catch(SQLException s) {
			s.printStackTrace();
		}
		
	}

	@Override
	public Project getProjectById(int projectId) {
		try(Connection connection=DriverManager.getConnection(url, username, password)){
			String sql="SELECT * FROM Project WHERE project_id= ?";
			try(PreparedStatement ps=connection.prepareCall(sql)){
				ps.setInt(1, projectId);
				ResultSet rs=ps.executeQuery();
				if(rs.next()) {
					return getProjectFromResultSet(rs);
				}
			}
		}
		catch(SQLException s) {
			s.printStackTrace();
		}
		return null;
	}

	private Project getProjectFromResultSet(ResultSet rs) throws SQLException {
		Project p=new Project();
		p.setProjectId(rs.getInt(1));
		p.setProjectName(rs.getString(2));
		p.setDescription(rs.getString(3));
		p.setStartDate(rs.getDate(4).toLocalDate());
		p.setStatus(rs.getString(5));
		Array a=rs.getArray(6);
		p.setTeamMembers((int [])a.getArray());
		return null;
	}

	@Override
	public List<Project> displayAllProjects() {
		List<Project> list=new ArrayList<>();
		try(Connection connection=DriverManager.getConnection(url, username, password)){
			String sql="SELECT * FROM Project";
			try(PreparedStatement ps=connection.prepareCall(sql)){
				ResultSet rs=ps.executeQuery();
				if(rs.next()) {
					list.add(getProjectFromResultSet(rs));
				}
			}		
		}
		catch(SQLException s) {
			s.printStackTrace();
		}	
		return list;
	}

	@Override
	public void changeStatus(Project p) {
		try(Connection connection=DriverManager.getConnection(url, username, password)){
			String sql="UPDATE Project SET status= ? WHERE project_id= ?";
			try(PreparedStatement ps=connection.prepareCall(sql)){
				ps.setString(1, p.getStatus());
				ps.setInt(2, p.getProjectId());
				ps.executeUpdate();
			}
		}
		catch(SQLException s) {
			s.printStackTrace();
		}
	}

}

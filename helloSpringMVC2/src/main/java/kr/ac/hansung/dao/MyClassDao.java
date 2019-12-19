package kr.ac.hansung.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.model.MyClass;
import kr.ac.hansung.model.Semester;

@Repository
public class MyClassDao {

private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<Semester> getSemesters() {
		
		String sqlStatement = "select class_year, class_semester, sum(class_grade) as sum_grade from homework2.class where class_year < 2020 group by class_year, class_semester;";
		
		// 익명 클래스, RowMapper
		return jdbcTemplate.query(sqlStatement,  new RowMapper<Semester>() {

			@Override
			public Semester mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Semester semester = new Semester();
				
				semester.setClass_year(rs.getInt("class_year"));
				semester.setClass_semester(rs.getInt("class_semester"));
				semester.setClass_grade(rs.getInt("sum_grade"));
				
				return semester;
			}
		});
	}
	
	public List<MyClass> getSemestersList(int year, int semester) {
		
		String sqlStatement = "select class_year, class_semester, class_code, class_name, class_category, class_grade from homework2.class where class_year=? and class_semester=?;";
		
		// 익명 클래스, RowMapper
		return jdbcTemplate.query(sqlStatement, new Object [] {year, semester},  new RowMapper<MyClass>() {

			@Override
			public MyClass mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				MyClass myClass = new MyClass();
				
				myClass.setClass_year(rs.getInt("class_year"));
				myClass.setClass_semester(rs.getInt("class_semester"));
				myClass.setClass_code(rs.getString("class_code"));
				myClass.setClass_name(rs.getString("class_name"));
				myClass.setClass_category(rs.getString("class_category"));
				myClass.setClass_grade(rs.getInt("class_grade"));
				
				return myClass;
			}
		});
	}
	
	public boolean insert(MyClass myClass) {
		
		int year = myClass.getClass_year();
		int semester = myClass.getClass_semester();
		String code = myClass.getClass_code();
		String name = myClass.getClass_name();
		String category = myClass.getClass_category();
		int grade = myClass.getClass_grade();
		

		
		String sqlStatement = "insert into homework2.class(  class_year, class_semester, class_code, class_name, class_category, class_grade) values (?, ?, ?, ?, ?, ?);";
		return jdbcTemplate.update(sqlStatement, new Object[] {year, semester, code, name, category, grade}) == 1 ? true : false;
	}
	
	
	public List<MyClass> getSemestersFutureList() {
		
		String sqlStatement = "select class_year, class_semester, class_code, class_name, class_category, class_grade from homework2.class where class_year=2020 and class_semester=1;";
		
		// 익명 클래스, RowMapper
		return jdbcTemplate.query(sqlStatement,  new RowMapper<MyClass>() {

			@Override
			public MyClass mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				MyClass myClass = new MyClass();
				
				myClass.setClass_year(rs.getInt("class_year"));
				myClass.setClass_semester(rs.getInt("class_semester"));
				myClass.setClass_code(rs.getString("class_code"));
				myClass.setClass_name(rs.getString("class_name"));
				myClass.setClass_category(rs.getString("class_category"));
				myClass.setClass_grade(rs.getInt("class_grade"));
				
				return myClass;
			}
		});
	}
}

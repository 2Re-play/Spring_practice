package kr.ac.hansung.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import kr.ac.hansung.model.MyClass;
import kr.ac.hansung.model.MySemester;


public class MyClassDao {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<MySemester> getClassSemester() {
		
		String sqlStatement = "select class_year, class_semester, sum(class_grade) as sum_grade from homework2.class group by class_year, class_semester;";
		
		// 익명 클래스, RowMapper
		return jdbcTemplate.query(sqlStatement,  new RowMapper<MySemester>() {

			@Override
			public MySemester mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				MySemester mySemester = new MySemester();
				
				mySemester.setClass_year(rs.getInt("class_year"));
				mySemester.setCalss_semester(rs.getInt("class_semester"));
				mySemester.setSum_grade(rs.getInt("sum_grade"));
				
				return mySemester;
			}
		});
	}
	
}

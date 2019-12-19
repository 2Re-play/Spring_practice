package kr.ac.hansung.csemall;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component("offerDao")
public class OfferDao {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public int getRowCount() {
		String sqlStatement = "select count(*) from user";
		return jdbcTemplate.queryForObject(sqlStatement, Integer.class);
	}
	
	//query and return a single object
	public Offer getOffer(String name) {
		
		String sqlStatement = "select * from user where name = ?";
		
		// 익명 클래스, RowMapper
		return jdbcTemplate.queryForObject(sqlStatement, new Object [] {name}, new RowMapper<Offer>() {

			@Override
			public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Offer offer = new Offer();
				
				offer.setId(rs.getString("id"));
				offer.setEmail(rs.getString("email"));
				offer.setName(rs.getString("name"));
				offer.setText(rs.getString("phone"));
				
				return offer;
			}
		});
	}
	
	public List<Offer> getOffers() {
		
		String sqlStatement = "select * from user";
		
		// 익명 클래스, RowMapper
		return jdbcTemplate.query(sqlStatement,  new RowMapper<Offer>() {

			@Override
			public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Offer offer = new Offer();
				
				offer.setId(rs.getString("id"));
				offer.setEmail(rs.getString("email"));
				offer.setName(rs.getString("name"));
				offer.setText(rs.getString("phone"));
				
				return offer;
			}
		});
	}
	
	public boolean insert(Offer offer) {
		
		String name = offer.getName();
		String email = offer.getEmail();
		String id = offer.getId();
		String text = offer.getText();
		
		String sqlStatement = "insert into user (name, id, email, phone) values (?,?,?,?)";
		return jdbcTemplate.update(sqlStatement, new Object[] {name, id, email, text}) == 1 ? true : false;
	}
	
	public boolean update(Offer offer) {
		
		String name = offer.getName();
		String email = offer.getEmail();
		String id = offer.getId();
		String text = offer.getText();
		
		String sqlStatement = "update user set name = ?, email = ?, phone = ? where id = ?";
		return jdbcTemplate.update(sqlStatement, new Object[] {name, email, text, id}) == 1 ? true : false;
	}
	
	public boolean delete(String id) {
		
		String sqlStatement = "delete from user where id = ?";
		return jdbcTemplate.update(sqlStatement, new Object[] {id}) == 1 ? true : false;
	}
}

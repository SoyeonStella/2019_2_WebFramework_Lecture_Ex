package kr.ac.hansung.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.model.AttLecture;

@Repository
//스프링에서 스캔하다가(단, 어느 패키지를 스캔할지를 지정해 줘야한다.) @Component가 있으면 해당되 class를 바탕으로 하여 빈으로 등록해준다.
//@Component() 안의 문자열은 빈에 대한 id이다. 
//bean으로 등록해주면 스프링 컨테이너에 의해 라이프사이클을 관리해줄수있다.
public class AttLectureDao {

	// JDBC Template을 활용함
	private JdbcTemplate jdbcTemplate;

	@Autowired
	// dataSource가 싱글톤이므로 자료형으로 알아서 찾아서 주입해준다.
	// setter method. 이 메서드 호출시 DataSource를 의존성 주입을 통해서 주입해 준다.
	public void setDataSource(DataSource dataSource) {

		// DataSource를 활용해 jdbcTemplate 인스턴스 생성
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

//	// 레코드의 수를 세는 메서드
//	public int getRowCount() {
//		String sqlStatment = "select count(*) from lectures";
//		return jdbcTemplate.queryForObject(sqlStatment, Integer.class);
//	}
//
//	// query and return a single object
//	// 실제로 DB를 조회해서 해당되는 레코드를 객체로 매핑해서 리턴한다.
//	public AttLecture getLecture(String sub_code) {
//
//		String sqlStatment = "select * from lectures where sub_code = ?";// ?는 placeholder
//
//		// 아래 두 줄 모두 가능. 배열로 넘겨주느냐 아니냐의 차이임.
//		// return jdbcTemplate.queryForObject(sqlStatment, name, rowMapper);
//		return jdbcTemplate.queryForObject(sqlStatment, new Object[] { sub_code }/* sql문의 placeholder에 들어갈 값 */,
//				new RowMapper<AttLecture>() {
//
//					@Override
//					public AttLecture mapRow(ResultSet rs, int rowNum) throws SQLException {
//
//						AttLecture lecture = new AttLecture();
//
//						lecture.setAtt_year(rs.getInt("att_year"));
//						lecture.setAtt_term(rs.getInt("att_term"));
//						lecture.setSub_code(rs.getString("sub_code"));
//						lecture.setSub_title(rs.getString("sub_title"));
//						lecture.setSub_part(rs.getString("sub_part"));
//						lecture.setSub_credit(rs.getInt("sub_credit"));
//
//						return lecture;
//					}
//
//				}/* 레코드를 객체로 매핑시켜줄 인자. RowMapper는 interface임. 익명클래스임. */ );
//	}

//	// query and return multiple objects
//	public List<AttLecture> getLectures() {
//
//		String sqlStatment = "select * from lectures";
//
//		// 아래 두 줄 모두 가능. 배열로 넘겨주느냐 아니냐의 차이임.
//		// return jdbcTemplate.queryForObject(sqlStatment, name, rowMapper);
//		return jdbcTemplate.query(sqlStatment, new RowMapper<AttLecture>() { /* 레코드 개수만큼 호출된다 */
//
//			@Override
//			public AttLecture mapRow(ResultSet rs, int rowNum) throws SQLException {
//
//				AttLecture lecture = new AttLecture();
//
//				lecture.setAtt_year(rs.getInt("att_year"));
//				lecture.setAtt_term(rs.getInt("att_term"));
//				lecture.setSub_code(rs.getString("sub_code"));
//				lecture.setSub_title(rs.getString("sub_title"));
//				lecture.setSub_part(rs.getString("sub_part"));
//				lecture.setSub_credit(rs.getInt("sub_credit"));
//
//				return lecture;
//			}
//
//		}/* 레코드를 객체로 매핑시켜줄 인자. RowMapper는 interface임. 익명클래스임. */ );
//	}

	
	// 수강 학기별 데이터베이스를 보기 위한 수강 학기 목록과 학기별 수강한 학점의 합
	public List<AttLecture> getLecture() {
		String sqlStatement = "select distinct att_year, att_term, sum(sub_credit) from lectures "
				+ "group by att_year, att_term order by att_year asc;";
		return jdbcTemplate.query(sqlStatement, new RowMapper<AttLecture>() {

			@Override
			public AttLecture mapRow(ResultSet rs, int rowNum) throws SQLException {

				AttLecture lecture = new AttLecture();

				lecture.setAtt_year(rs.getInt("att_year"));
				lecture.setAtt_term(rs.getInt("att_term"));
				lecture.setSub_credit(rs.getInt(3));

				return lecture;

			}

		});

	}

	// 년도/학기를 인자로 받아 해당 년도/학기에 따른 데이터 리턴
	public List<AttLecture> getLectureByYearTerm(int att_year, int att_term) {

		String sqlStatment = "select * from lectures where att_year=? and att_term=?";

		return jdbcTemplate.query(sqlStatment, new Object[] { att_year, att_term }, new RowMapper<AttLecture>() {

			@Override
			public AttLecture mapRow(ResultSet rs, int rowNum) throws SQLException {

				AttLecture lecture = new AttLecture();

				lecture.setAtt_year(rs.getInt("att_year"));
				lecture.setAtt_term(rs.getInt("att_term"));
				lecture.setSub_code(rs.getString("sub_code"));
				lecture.setSub_title(rs.getString("sub_title"));
				lecture.setSub_part(rs.getString("sub_part"));
				lecture.setSub_credit(rs.getInt("sub_credit"));

				return lecture;
			}

		});
	}

//	// 학점 총 합
//	public int getCreditTotal(int att_year, int att_term) {
//		// 각 학기별 수강 총 학점을 조회하는 sql
//		String sql = "select sum(sub_credit) from lectures where att_year=? and att_term=?";
//
//		int sum = jdbcTemplate.queryForObject(sql, new Object[] { att_year, att_term }, Integer.class);
//
//		return sum;
//	}

	// 객체를 받아 DB에 insert하는 method
	public boolean insert(AttLecture lecture) {
		int att_year = lecture.getAtt_year();
		int att_term = lecture.getAtt_term();
		String sub_code = lecture.getSub_code();
		String sub_title = lecture.getSub_title();
		String sub_part = lecture.getSub_part();
		int sub_credit = lecture.getSub_credit();

		String sqlStatment = "insert into lectures (att_year, att_term, sub_code, sub_title, sub_part, sub_credit) values (?, ?, ?, ?, ?, ?)";

		return (jdbcTemplate.update(sqlStatment,
				new Object[] { att_year, att_term, sub_code, sub_title, sub_part, sub_credit }) == 1);
	}

	// DB를 update하는 method
	public boolean update(AttLecture lecture) {

		int att_year = lecture.getAtt_year();
		int att_term = lecture.getAtt_term();
		String sub_code = lecture.getSub_code();
		String sub_title = lecture.getSub_title();
		String sub_part = lecture.getSub_part();
		int sub_credit = lecture.getSub_credit();

		String sqlStatment = "update lectures set att_year=?, att_term=?, sub_code=?, sub_title=?, sub_part=?, sub_credit=?";

		return (jdbcTemplate.update(sqlStatment,
				new Object[] { att_year, att_term, sub_code, sub_title, sub_part, sub_credit }) == 1);
	}

	// delete method
	public boolean delete(int sub_code) {

		String sqlStatment = "delete from lectures where sub_code=?";

		return (jdbcTemplate.update(sqlStatment, new Object[] { sub_code }) == 1);

	}

}

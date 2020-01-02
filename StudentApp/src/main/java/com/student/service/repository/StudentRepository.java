package com.student.service.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.student.service.model.Address;
import com.student.service.model.Student;

@Repository
public class StudentRepository {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	class StudentRowMapper implements RowMapper<Student> {
		@Override
		public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
			Student student = new Student();
			student.setFirstName(rs.getString("firstName"));
			student.setLastName(rs.getString("lastName"));
			student.setClazz(rs.getString("clazz"));
			student.setFatherName(rs.getString("fatherName"));
			student.setMotherName(rs.getString("motherName"));
			return student;
		}

	}
	
	public Address findById(long id) {
		return jdbcTemplate.queryForObject("select * from Address where id=?", new Object[] { id },
				new BeanPropertyRowMapper<Address>(Address.class));
	}
	
	public Student findAll() {
		Student student = jdbcTemplate.query("select * from Student", new StudentRowMapper()).get(0);
		Address address = this.findById(10002);
		student.setAddress_1(address.getAddress_1());
		student.setAddress_2(address.getAddress_2());
		student.setAddress_3(address.getAddress_3());
		
		return student;
	}

	
}

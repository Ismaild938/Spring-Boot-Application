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

	final String queryForFindById = "select * from Address where id=?";
	final static String queryForFindAll = "select * from Student";
	final String INSERT_QUERY = "insert into student (firstName, lastName,fatherName,motherName) values (?, ?,?,?)";
	final String UPDATE_QUERY = "update student set fathername = ? where mothername = ?";
	final String DELETE_QUERY = "delete from student where  firstname= ?";

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

	/**
	 * Insert the data into datbase
	 * 
	 * @param student
	 * @return
	 */
	public int saveStudent(Student student) {
		return jdbcTemplate.update(INSERT_QUERY, student.getFirstName(), student.getLastName(), student.getFatherName(),
				student.getMotherName());
	}

	/**
	 * To perform Update on student table 
	 * @param student
	 * @throws Exception 
	 */
	public void update(Student student) throws Exception {
		int status = jdbcTemplate.update(UPDATE_QUERY, student.getFatherName(), student.getMotherName());
		if (status != 0) {
			System.out.println("Student data has updated for this student " + student.getFirstName());
		} else {
			//we can implement our own custome exception class here
			throw new Exception("NO data has found for this Student");
		}

	}

	/**
	 * To perfrom delete on student table
	 * @param studentName
	 * @throws Exception 
	 */
	public void deleteEmpById(String studentFirstName) throws Exception {
		int status = jdbcTemplate.update(DELETE_QUERY, studentFirstName);
		if (status != 0) {
			System.out.println("Student info deleted for this student " + studentFirstName);
		} else {
			//we can implement our own custome exception class here
			throw new Exception("No student found for this student name");
		}
	}

	/**
	 * To pull record based on Id
	 * @param id
	 * @return
	 */
	public Address findById(long id) {
		return jdbcTemplate.queryForObject(queryForFindById, new Object[] { id },
				new BeanPropertyRowMapper<Address>(Address.class));
	}

	/**
	 * To pull whole records for specific table
	 * @return
	 */
	public Student findAll() {
		Student student = jdbcTemplate.query(queryForFindAll, new StudentRowMapper()).get(0);
		Address address = this.findById(10002);
		student.setAddress_1(address.getAddress_1());
		student.setAddress_2(address.getAddress_2());
		student.setAddress_3(address.getAddress_3());

		return student;
	}

}

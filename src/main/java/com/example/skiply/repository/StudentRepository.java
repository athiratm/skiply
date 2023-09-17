package com.example.skiply.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.skiply.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

//	@Query("from Student where flightNumber=:flightNumber")
//	Optional<Student> findByStudentId(@Param("flightNumber")String flightNumber);
//	
}

package com.example.skiply.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.skiply.entity.Receipt;

@Repository
public interface ReceiptRepository extends JpaRepository<Receipt, Long> {

	@Query("SELECT r FROM Receipt r WHERE r.studentId=?1")
	Receipt findByStudentId(Long studentId);
}

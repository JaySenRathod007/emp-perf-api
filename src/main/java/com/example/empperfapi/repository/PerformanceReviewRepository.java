package com.example.empperfapi.repository;

import com.example.empperfapi.model.PerformanceReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PerformanceReviewRepository extends JpaRepository<PerformanceReview, Long> {

    List<PerformanceReview> findTop3ByEmployeeIdOrderByReviewDateDesc(Long employeeId);
}


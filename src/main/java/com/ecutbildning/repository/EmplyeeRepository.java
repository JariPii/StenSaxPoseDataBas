package com.ecutbildning.repository;

import com.ecutbildning.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmplyeeRepository extends JpaRepository <EmployeeEntity, Integer> {

}

package com.spring.study.demo.repository;

import com.spring.study.demo.entity.PersonEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends CrudRepository<PersonEntity, Long> {
    @Query("from PersonEntity")
    List<PersonEntity> getAllPersons();
    @Query("from PersonEntity p where p.dept=:dept and p.empId=:employeeId")
    PersonEntity getByDeptAndEmpId(String dept, Integer employeeId);

    @Query("from PersonEntity p where p.empId=:employeeId")
    PersonEntity getByEmployeeId(Integer employeeId);



}


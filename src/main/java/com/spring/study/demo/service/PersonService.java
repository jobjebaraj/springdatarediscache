package com.spring.study.demo.service;


import com.spring.study.demo.PersonInterface.PersonInterface;
import com.spring.study.demo.entity.PersonEntity;
import com.spring.study.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@CacheConfig(cacheNames={"persons"})
public class PersonService implements PersonInterface {


    @Value("${study.name.demo}")
    private String appname;

    @Autowired
    private PersonRepository personRepository;

    @Cacheable(key="#empId")
    public CompletableFuture<List<PersonEntity>> getListOfPersons(String dept, Integer empId) {
            return CompletableFuture.completedFuture(personRepository.getAllPersons());
    }

    /// @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    @Override
    public void save(PersonEntity person) {
        PersonEntity response = personRepository.save(person);
    }

    @Override
    public PersonEntity updatePerson(PersonEntity person) {

      PersonEntity toBeUpdated =   personRepository.getByDeptAndEmpId(person.getDept(), person.getEmpId());
      toBeUpdated.setName(person.getName());
      toBeUpdated.setDept(person.getDept());
      toBeUpdated.setAge(person.getAge());
      toBeUpdated.setDesign(person.getDesign());
      personRepository.save(toBeUpdated);
      return toBeUpdated;
    }

    @Override
    public PersonEntity deletePerson(Integer employeeId) {
        PersonEntity deletePerson =   personRepository.getByEmployeeId(employeeId);
        ///Valdations
        personRepository.delete(deletePerson);
        return deletePerson;
    }


}


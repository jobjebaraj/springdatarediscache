package com.spring.study.demo.PersonInterface;



import com.spring.study.demo.entity.PersonEntity;

import java.util.List;
import java.util.concurrent.CompletableFuture;


public interface PersonInterface {

    public CompletableFuture<List<PersonEntity>> getListOfPersons(String input, Integer empId);
    public void save(PersonEntity person) ;

    public PersonEntity updatePerson(PersonEntity person);

    public PersonEntity deletePerson(Integer employeeId);
}

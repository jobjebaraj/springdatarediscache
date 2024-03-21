package com.spring.study.demo.entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="Person" ,schema="demo_schema")
public class PersonEntity implements java.io.Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_generator")
    @SequenceGenerator(name = "person_generator", sequenceName = "demo_schema.person_seq", allocationSize = 1)
    @Column(name="id")
    private Long Id;

//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "emp_id_generator")
//    @SequenceGenerator(name = "emp_id_generator", sequenceName = "demo_schema.employee_id_seq", allocationSize = 10)
    @Column(name="employee_id")
    private Integer empId;

    @Column(name="NAME")
    private String name;

    @Column(name="age")
    private int age;

    @Column(name="DEPT")
    private String dept;

    @Column(name="DESIGN")
    private String design;


}

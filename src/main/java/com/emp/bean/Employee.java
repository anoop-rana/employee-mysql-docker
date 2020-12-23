package com.emp.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name = "Employee")
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer eid;

    private String ename;
    private String email;
    private Double salary;

    private Integer phone;

    @NotNull
    @Column(name = "roles")
    private String role;

    @NotNull
    private String dept;

    public Employee() {
    }

    public Employee(String ename, String email, Double salary, Integer phone, String role, String dept) {
        this.ename = ename;
        this.email = email;
        this.salary = salary;
        this.phone = phone;
        this.role = role;
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "{" + " eid='" + getEid() + "'" + ", ename='" + getEname() + "'" + ", email='" + getEmail() + "'"
                + ", salary='" + getSalary() + "'" + ", phone='" + getPhone() + "'" + ", role='" + getRole() + "'"
                + ", dept='" + getDept() + "'" + "}";
    }

}

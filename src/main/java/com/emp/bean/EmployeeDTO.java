package com.emp.bean;

import lombok.Data;

@Data
public class EmployeeDTO {
    private Integer eid;
    private String ename;
    private String email;
    private Double salary;
    private Integer phone;
    private String role;
    private String dept;

    public EmployeeDTO() {
    }

    public EmployeeDTO(Integer eid, String ename, String email, Double salary, Integer phone, String role,
            String dept) {
        this.eid = eid;
        this.ename = ename;
        this.email = email;
        this.salary = salary;
        this.phone = phone;
        this.role = role;
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "{" + ", ename='" + getEname() + "'" + ", email='" + getEmail() + "'" + ", salary='" + getSalary() + "'"
                + ", phone='" + getPhone() + "'" + ", role='" + getRole() + "'" + ", dept='" + getDept() + "'" + "}";
    }

}

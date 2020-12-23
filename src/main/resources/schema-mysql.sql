CREATE TABLE IF NOT EXISTS employee (
  eid int NOT NULL AUTO_INCREMENT,
  ename VARCHAR(100) NOT NULL,
  email VARCHAR(20),
  salary double(8,2),
  phone int,
  roles VARCHAR(20),
  dept VARCHAR(20),
  Primary key(eid)
);


insert into employee values(1,"Emp001","emp001@gmail.com","1000","1234567890","DEVOPS","IT");

insert into employee values(2,"Emp002","emp002@gmail.com","2000","1234567890","DEVOPS","IT");

insert into employee values(3,"Emp003","emp003@gmail.com","3000","1234567890","DEVOPS","IT");

insert into employee values(4,"Emp004","emp004@gmail.com","4000","1234567890","DEVOPS","IT");
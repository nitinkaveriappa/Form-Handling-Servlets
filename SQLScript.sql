drop table student cascade constraints;


create table student
(
  studentid integer not null,
  name varchar2(50) not null, 
  streetaddress varchar2(50) not null, 
  city varchar2(50) not null, 
  states varchar2(50) not null, 
  zip integer not null, 
  telephonenumber varchar2(50) not null, 
  email varchar2(50) not null, 
  url varchar2(50) not null, 
  dateofsurvey varchar2(50) not null, 
  likes varchar2(50), 
  interest varchar2(50), 
  comments varchar2(50), 
  months varchar2(50), 
  years varchar2(50), 
  recommend varchar2(50),
  primary key (studentid)
);
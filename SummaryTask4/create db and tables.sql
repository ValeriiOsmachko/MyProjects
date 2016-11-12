DROP database IF EXISTS st4db;
CREATE database if not exists st4db default CHARACTER set utf8 ;
use st4db;

DROP TABLE IF exists Users;
CREATE TABLE If not exists Users(
id int not null AUTO_INCREMENT, 
first_name varchar(45) not null,
last_name varchar(45) not null,
email varchar(255) not null,
password varchar (32) not null,
role enum('client','admin'),
primary key (id),
unique index id_unique (id asc),
unique index email_unique (email asc));

DROP TABLE IF exists Enrollee;
CREATE TABLE IF NOT exists Enrollee(
id int not null AUTO_INCREMENT,
city varchar(45) not null,
region varchar(45) not null,
User_idUser int not null,
isBlocked boolean not null default false,
primary key (id),
unique index id_unique(id asc),
foreign key (User_idUser) references Users(id)
on delete no action
on update no action	);



DROP TABLE if exists Faculty;
CREATE TABLE IF not exists Faculty(
id int not null AUTO_INCREMENT,
total_seats int not null,
budget_seats int not null,
primary key (id))
engine = InnoDB;




DROP TABLE if exists Subject; 
Create table if not exists Subject(
id int not null AUTO_INCREMENT,
nameOfSubject varchar(45) not null,
primary key (id))
engine = InnoDB;


DROP TABLE If exists Faculty_Subjects;
create table if not exists Faculty_Subjects(
id int not null AUTO_INCREMENT,
Faculty_idFaculty INT NOT NULL,
Subject_idSubject INT NOT NULL,
primary key(id,Faculty_idFaculty,Subject_idSubject),
unique index idFacultySubjects_UNIQUE (id asc),
foreign key (Faculty_idFaculty) references Faculty(id)
on delete no action
on update no action,
foreign key(Subject_idSubject) references Subject(id)
on delete no action
on update no action)
engine = InnoDB;


DROP TABLE IF exists Faculty_Enrollees;
CREATE TABLE IF not exists Faculty_Enrollees(
id int not null AUTO_INCREMENT,
Faculty_idFaculty int not null,
Enrollee_idEnrollee int not null,
primary key(id,Faculty_idFaculty,Enrollee_idEnrollee),
unique index idFacultyEnrollees_UNIQUE (id asc),
foreign key (Faculty_idFaculty) references Faculty(id)
on delete no action
on update no action,
foreign key (Enrollee_idEnrollee) references Enrollee(id)
on delete no action
on update no action)
engine = InnoDB;

DROP TABLE IF exists Mark;
create table if not exists Mark(
id int not null AUTO_INCREMENT,
mark int not null,
Subject_idSubject int not null,
Enrollee_idEnrollee int not null,
primary key (id,Subject_idSubject,Enrollee_idEnrollee),
unique index idMark_UNIQUE (id asc),
foreign key (Subject_idSubject) references Subject(id),
foreign key (Enrollee_idEnrollee) references Enrollee(id));
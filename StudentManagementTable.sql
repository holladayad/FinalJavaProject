-- Authors: Amber Holladay, Paige Kowahl, Zach Melusen, Emma Morell, Gonzo Ocampo
-- Date: Apr 28, 2020
-- Assignment: Group Project Part 2
-- Purpose: create and drop the tables to refresh


drop table StudentEnrollment;
drop table student;
drop table course;
drop table instructor;

create table course (
	CourseID		INTEGER primary key,
	CourseName		VARCHAR2(10),
	CourseBLDG		VARCHAR2(15),
	CourseRoom		VARCHAR2(10),
	CourseCapacity	INTEGER
);

create table instructor (
	InstrID			INTEGER primary key,
	InstrName		VARCHAR2(20),
	InstrPrefix		VARCHAR2(10),
	InstrOffice		VARCHAR2(10),
	InstrDept		VARCHAR2(15),
	InstrEmail		VARCHAR2(25)
);

create table student (
	StudentID		INTEGER primary key,
	StudentName		VARCHAR2(20),
	StudentYear		VARCHAR2(10),
	StudentMajor	VARCHAR2(15),
	StudentGPA		FLOAT(3),
	StudentEmail	VARCHAR2(25)
);

create table studentEnrollment (
	CourseID		INTEGER
		references course(CourseID),
	StudentID		INTEGER
		references student(StudentID),
	primary key(CourseID, StudentID)
);
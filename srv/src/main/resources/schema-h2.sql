
DROP VIEW IF EXISTS CourseService_Prerequisites;
DROP VIEW IF EXISTS CourseService_Enrollments;
DROP VIEW IF EXISTS CourseService_Courses;
DROP VIEW IF EXISTS CourseService_User;
DROP TABLE IF EXISTS cds_outbox_Messages;
DROP TABLE IF EXISTS onlinecourses_Prerequisites;
DROP TABLE IF EXISTS onlinecourses_Enrollments;
DROP TABLE IF EXISTS onlinecourses_Courses;
DROP TABLE IF EXISTS onlinecourses_User;

CREATE TABLE onlinecourses_User (
  email NVARCHAR(255) NOT NULL,
  role NVARCHAR(255),
  password NVARCHAR(255),
  PRIMARY KEY(email)
);


CREATE TABLE onlinecourses_Courses (
  ID NVARCHAR(36) NOT NULL,
  title NVARCHAR(100),
  description NVARCHAR(500),
  capacity INTEGER,
  instructor_email NVARCHAR(255),
  PRIMARY KEY(ID)
);


CREATE TABLE onlinecourses_Enrollments (
  ID NVARCHAR(36) NOT NULL,
  student_email NVARCHAR(255),
  course_ID NVARCHAR(36),
  status NVARCHAR(20),
  registeredAt TIMESTAMP(7),
  PRIMARY KEY(ID)
);


CREATE TABLE onlinecourses_Prerequisites (
  ID NVARCHAR(36) NOT NULL,
  course_ID NVARCHAR(36),
  prerequisite_ID NVARCHAR(36),
  PRIMARY KEY(ID)
);


CREATE TABLE cds_outbox_Messages (
  ID NVARCHAR(36) NOT NULL,
  timestamp TIMESTAMP(7),
  target NVARCHAR(255),
  msg NCLOB,
  attempts INTEGER DEFAULT 0,
  "PARTITION" INTEGER DEFAULT 0,
  lastError NCLOB,
  lastAttemptTimestamp TIMESTAMP(7),
  status NVARCHAR(23),
  PRIMARY KEY(ID)
);


CREATE VIEW CourseService_User AS SELECT
  User_0.email,
  User_0.role,
  User_0.password
FROM onlinecourses_User AS User_0;


CREATE VIEW CourseService_Courses AS SELECT
  Courses_0.ID,
  Courses_0.title,
  Courses_0.description,
  Courses_0.capacity,
  Courses_0.instructor_email
FROM onlinecourses_Courses AS Courses_0;


CREATE VIEW CourseService_Enrollments AS SELECT
  Enrollments_0.ID,
  Enrollments_0.student_email,
  Enrollments_0.course_ID,
  Enrollments_0.status,
  Enrollments_0.registeredAt
FROM onlinecourses_Enrollments AS Enrollments_0;


CREATE VIEW CourseService_Prerequisites AS SELECT
  Prerequisites_0.ID,
  Prerequisites_0.course_ID,
  Prerequisites_0.prerequisite_ID
FROM onlinecourses_Prerequisites AS Prerequisites_0;


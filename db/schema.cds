namespace onlinecourses;

using {
    cuid,
    managed
} from '@sap/cds/common';

entity User {
    key email : String @mandatory;
        role  : String;
        password : String;
}


entity Courses: cuid {
  title        : String(100);
  description  : String(500);
  capacity     : Integer;
  instructor   : Association to User @mandatory @assert.target;
}

entity Enrollments: cuid {
  student      : Association to User @mandatory @assert.target;
  course       : Association to Courses @mandatory @assert.target;
  status       : String(20); // registered, waitlisted, dropped
  registeredAt : Timestamp;
}

entity Prerequisites: cuid {
  course       : Association to Courses @mandatory @assert.target;
  prerequisite : Association to Courses @mandatory @assert.target;
}


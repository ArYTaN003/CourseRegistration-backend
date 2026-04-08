using onlinecourses as c from '../db/schema';

@path: '/service'

service CourseService {
   entity User          as projection on c.User;
  action ValidateUser(email : String, password : String, role : String) returns Boolean;
    action CheckUser()                                                 returns CheckUserResult;
    action Logout()                                                    returns Boolean;
  entity Courses as projection on c.Courses;
  entity Enrollments as projection on c.Enrollments;
  @readonly
  entity Prerequisites as projection on c.Prerequisites;
}
type CheckUserResult {
  value : Boolean;
  email : String;
  role  : String;
}


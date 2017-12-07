export class CourseComponent
{
  title = "List of courses";
  courses;
  constructor()
  {
    let service = new CoursesService();
    this.courses = service.getCourses();
  }
}


public class Main {

	public static void main(String[] args) {
		
		Instructor instructor1 = new Instructor(1, "Engin","Demirog");
		
		InstructorManager instructorManager = new InstructorManager();
		
		instructorManager.Add(instructor1);
		
		User user = new User(1,"Enes Celik","test@test.com","1234567");
		
		UserManager userManager = new UserManager();
		
		userManager.Add(user);
		
		
		Course course1 = new Course(1,"Java","Nitelikli Yazilimci "+instructor1.firstName + " "+ instructor1.lastName,0);
		Course course2 = new Course(2,"C#","Nitelikli Yazilimci "+instructor1.firstName + " "+ instructor1.lastName,0);
		Course course3 = new Course(3,"Hazirlik","Nitelikli Yazilimci "+instructor1.firstName + " "+ instructor1.lastName,0);
		
		Course[] courses = {course1,course2,course3};
		
		CourseManager courseManager = new CourseManager();
		
		courseManager.Add(course1);
		courseManager.Delete(course3);
	}

}

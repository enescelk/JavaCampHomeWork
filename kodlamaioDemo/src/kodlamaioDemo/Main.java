package kodlamaioDemo;

public class Main {

	public static void main(String[] args) {
		
		User user1 = new User();
		user1.setId(1);
		user1.setFirstName("Enes");
		user1.setLastName("Celik");
		user1.setEmail("test@gmail.com");
		user1.setPassword("12345");
		
		Instructor instructor1 = new Instructor();
		instructor1.setId(1);
		instructor1.setFirstName("Engin");
		instructor1.setLastName("Demirog");
		instructor1.setTrainingBranch("Java & React");
		instructor1.setPassword("12345");
		instructor1.setEmail("test1@gmail.com");
		
		Student student1 = new Student();
		student1.setId(1);
		student1.setFirstName("Ahmet");
		student1.setLastName("Mehmet");
		student1.setStudentNumber(2);
		student1.setPassword("12345");
		
		UserManager userManager = new UserManager();
		userManager.add(user1);
		
		InstructorManager instructorManager = new InstructorManager();
		instructorManager.add(instructor1);
		
		StudentManager studentManager = new StudentManager();
		studentManager.add(student1);
		
		
	}

}


public class InstructorManager {
	
	public void Add(Instructor instructor) {
		System.out.println("Egitmen Eklendi "+instructor.firstName + " "+ instructor.lastName);
	}
	
	public void Delete(Instructor instructor) {
		System.out.println("Egitmen Silindi "+instructor.firstName + " "+ instructor.lastName);
	}
}

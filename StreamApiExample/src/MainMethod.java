import java.util.ArrayList;
import java.util.List;

public class MainMethod {

	public static void main(String[] args) {
		List<Student> list = new ArrayList<>();
		Student s1 = new Student();
		s1.setId(1);
		s1.setAge(13);
		s1.setName("ABC");
		s1.setStatus("ACTIVE");

		list.add(s1);
		list.add(new Student(2, "XYZ", 20, "ACTIVE"));
		list.add(new Student(3, "PQR", 21, "InACTIVE"));
		list.add(new Student(4, "JKL", 15, "InACTIVE"));
		list.add(new Student(5, "DSD", 10, "ACTIVE"));
		list.add(new Student(6, "ACB", 10, "ACTIVE"));

		// List<Student> list1 = Arrays.asList(new Student(2, "XYZ", 20, "ACTIVE"), new
		// Student(2, "XYZ", 20, "ACTIVE"),new Student(2, "XYZ", 20, "ACTIVE"));
		// List<Student> list2 = List.of(new Student(2, "XYZ", 20, "ACTIVE"), new
		// Student(2, "XYZ", 20, "ACTIVE"),new Student(2, "XYZ", 20, "ACTIVE"));

		Example ex = new Example();
		ex.displayActiveStudents(list);
		ex.displayStudents(list);
		ex.displayStudents1(list);
		System.out.println("........Sorting...........");
		ex.displayStudentSortOnAge(list);
		System.out.println("........Sorting...1........");
		ex.displayStudentSortOnAge1(list);
		System.out.println("........Nth highest age student..........");
		ex.displayStudentsNthHighestAge(list);
		System.out.println("........foreach..........");

		ex.displayStudentsNthHighestAge1(list);

	}
}

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Example {

	public void displayActiveStudents(List<Student> students) {

		List<Student> lists = students.stream().filter(x -> x.getStatus().equals("ACTIVE"))
				.collect(Collectors.toList());
		System.out.println(lists);

		List<String> list3 = students.stream().filter(x -> x.getStatus().equals("ACTIVE")).map(y -> y.getName())
				.collect(Collectors.toList());
		System.out.println(list3);

		Stream<Student> lists1 = students.stream().filter(x -> x.getStatus().equals("ACTIVE"));
		List<Student> lists2 = lists1.collect(Collectors.toList());
		System.out.println(lists2);
		// lists1.distinct().count();
	}

	public void displayStudents(List<Student> students) {

		List<Student> lists = students.stream().map(x -> {
			if ("XYZ".equals(x.getName())) {
				x.setName("GHJK");
			}
			return x;
		}).collect(Collectors.toList());
		System.out.println(lists);
	}

	public void displayStudents1(List<Student> students) {

		List<Integer> lists = students.stream().map(x -> x.getAge() + 5).collect(Collectors.toList());
		System.out.println(lists);
	}

	public void displayStudentSortOnAge(List<Student> students) {
		List<Student> lists = students.stream().sorted((s1, s2) -> s1.getAge() - s2.getAge())
				.collect(Collectors.toList());
		System.out.println(lists);

		List<Student> reverse = students.stream().sorted((s1, s2) -> s2.getAge() - s1.getAge())
				.collect(Collectors.toList());
		System.out.println(reverse);

	}

	public void displayStudentSortOnAge1(List<Student> students) {
		List<Student> lists = students.stream().sorted(Comparator.comparing(Student::getAge))
				.collect(Collectors.toList());
		System.out.println(lists);

		List<Student> reverse = students.stream().sorted(Comparator.comparing(Student::getAge).reversed())
				.collect(Collectors.toList());
		System.out.println(reverse);

		List<Student> list1 = students.stream()
				.sorted(Comparator.comparing(Student::getAge).thenComparing(Student::getName))
				.collect(Collectors.toList());
		System.out.println(list1);

		// students.entrySet().stream().sorted(Map.comparingByKey(Comparator.comparing(STudent::getAge())))
	}

	public void displayStudentsNthHighestAge(List<Student> students) {

		List<Student> reverse = students.stream().sorted(Comparator.comparing(Student::getAge).reversed())
				.collect(Collectors.toList());
		System.out.println(reverse);

		Optional<Student> s1 = students.stream().sorted(Comparator.comparing(Student::getAge).reversed()).skip(1)
				.findFirst();
		System.out.println(s1.get());

		List<Student> limit = students.stream().sorted(Comparator.comparing(Student::getAge).reversed()).limit(3)
				.collect(Collectors.toList());
		System.out.println(limit);
	}

	public void displayStudentsNthHighestAge1(List<Student> students) {

		students.stream().sorted(Comparator.comparing(Student::getAge).reversed()).forEach(x -> {
			// logic
		});

		students.stream().sorted(Comparator.comparing(Student::getAge).reversed()).forEach(x -> System.out.println(x));
	}

	// [1,2,3,4,] ==> [[2,3],[2,3],[5,3]] => [2,3,2,3,5,3]
	// AllMatch, ANyMAtch, GroupingBy, Max,Min,FlatMap,
}

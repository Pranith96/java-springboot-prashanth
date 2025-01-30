import java.util.List;
import java.util.Optional;

public class Example {

	public void display(String str) {
		if (str != null && !str.isEmpty()) {
			str = str.toUpperCase();
			System.out.println(str);
		}
	}

	public void display1(String str) {
		Optional<String> op = Optional.ofNullable(str);
		op.ifPresent(s -> System.out.println(s.toUpperCase()));

		Optional.ofNullable(str).ifPresent(s -> System.out.println(s.toUpperCase()));
	}

//	public void display2(Student str) {
//		Optional<Student> op = Optional.ofNullable(str);
//		if(!op.isPresent()) {
//			
//		}
//	}
}

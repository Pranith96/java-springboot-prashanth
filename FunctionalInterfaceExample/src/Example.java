import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Example {

	public static void main(String[] args) {
		Predicate<Integer> p = (x) -> {
			if (x % 2 == 0) {
				return true;
			}
			return false;
		};
		boolean result = p.test(2);
		System.out.println(result);
		
		Predicate<Integer> p1 = x -> x % 2 == 0;
		boolean result1 = p1.test(2);
		System.out.println(result1);
		
		Consumer<String> cn = x -> {
			x = x.toUpperCase();
			System.out.println(x);
		};
		cn.accept("Hello world");
		
		Supplier<Integer> sp = () -> {
			Random r = new Random();
			int num = r.nextInt();
			return num;
		};
		
		int result3 = sp.get();
		System.out.println(result3);
	}
	
}

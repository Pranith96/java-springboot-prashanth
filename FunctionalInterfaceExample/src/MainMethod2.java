
public class MainMethod2 {

	public static void main(String[] args) {
		Summation sm = (x, y) -> {
			int z = x + y;
			return z;
		};
		int result = sm.sum(10, 10);
		System.out.println(result);

		Summation sm1 = (x, y) -> {
			return x + y;
		};
		int result1 = sm1.sum(10, 10);
		System.out.println(result1);

		Summation sm2 = (x, y) -> x + y;

		int result2 = sm2.sum(10, 10);
		System.out.println(result2);
	}
}

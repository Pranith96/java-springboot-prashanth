
public class MainMethod {

	public static void main(String[] args) {
//		AdditionImpl ad = new AdditionImpl();
//		ad.add(10, 20);

		Addition ad1 = new AdditionImpl();
		ad1.add(20, 20);

		Addition ad = (int x, int y) -> {
			int z = x + y;
			System.out.println(z);
		};
		ad.add(50, 40);

		Addition ad2 = (x, y) -> {
			System.out.println(x + y);
		};
		ad2.add(50, 40);

		Addition ad3 = (x, y) -> System.out.println(x + y);
		ad3.add(50, 40);
	}
}

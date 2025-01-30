@FunctionalInterface
public interface Addition {
	public void add(int a, int b);

	default void hello() {
		System.out.println("hi");
		hello2();
	}

	static void hello1() {
		System.out.println("hi");
	}

	private void hello2() {
		System.out.println("hi");
	}
}

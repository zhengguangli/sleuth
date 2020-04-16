package ink.icopy.base.single;

public class Singleton1_2 {
	private static Singleton1_2 singleton1_2 = null;

	public Singleton1_2() {
	}

	/**
	 * 双重检查-Double check Lock
	 *
	 * @return
	 */
	public static Singleton1_2 getInstance() {
		if (singleton1_2 == null)
			synchronized (Singleton1_2.class) {
				if (singleton1_2 == null)
					singleton1_2 = new Singleton1_2();
			}
		return singleton1_2;
	}
}

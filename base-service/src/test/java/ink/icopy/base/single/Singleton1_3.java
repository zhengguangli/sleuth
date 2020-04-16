package ink.icopy.base.single;

public class Singleton1_3 {
	private static volatile Singleton1_3 singleton1_3 = null;

	public Singleton1_3() {
	}

	/**
	 * volatile 内存可见性
	 *
	 * @return
	 */
	public static Singleton1_3 getInstance() {
		if (singleton1_3 == null)
			synchronized (Singleton1_3.class) {
				if (singleton1_3 == null)
					singleton1_3 = new Singleton1_3();
			}
		return singleton1_3;
	}
}

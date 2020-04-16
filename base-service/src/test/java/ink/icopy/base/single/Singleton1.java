package ink.icopy.base.single;

public class Singleton1 {
	private static Singleton1 singleton1 = null;

	public Singleton1() {
	}

	/**
	 * 基础饱汉模式
	 * 饱汉，即已经吃饱，不着急再吃，饿的时候再吃。等第一次使用的时候再初始化，即"懒加载"
	 * 饱汉模式的核心是懒加载，好处是启动快，节省资源，一直到实例被第一次访问，才需要初始化单例；
	 * 坏处。写起来麻烦，线程不安全，if语句存在竟态条件。
	 *
	 * @return
	 */
	public static Singleton1 getInstance() {
		if (singleton1 == null)
			singleton1 = new Singleton1();
		return singleton1;
	}
}

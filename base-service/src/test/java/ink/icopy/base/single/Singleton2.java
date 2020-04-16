package ink.icopy.base.single;

public class Singleton2 {
	private static final Singleton2 singleton2 = new Singleton2();

	public Singleton2() {
	}

	/**
	 * 饿汉模式，饿汉很饿，只想着早点吃。即类加载时初始化单例，以后访问时直接返回
	 * 饿汉的好处天生的线程安全(得益于类加载机制)，写起来超级简单，使用时没有延迟，坏处是可能造成资源浪费
	 * 单线程环境下，饿汉和饱汉在性能上没有什么差别；多线程环境下，由于饱汉需要加锁，饿汉模式性能更优
	 *
	 * @return
	 */
	public static Singleton2 getInstance() {
		return singleton2;
	}
}

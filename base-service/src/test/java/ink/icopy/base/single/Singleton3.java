package ink.icopy.base.single;

public class Singleton3 {
	private static class SingletonHolder {
		private static final Singleton3 singleton = new Singleton3();

		public SingletonHolder() {
		}
	}

	public Singleton3() {
	}

	/**
	 * Holder模式，
	 * 希望饿汉模式中静态变量的方便和线程安全；有希望使用懒加载的方式规避资源浪费。
	 * Holder模式满足了这亮点要求：
	 * 核心仍然是静态变量，足够方便和线程安全；通过静态的Holder类持有真正实例，间接实现了懒加载
	 *
	 * @return
	 */
	public static Singleton3 getInstance() {
		return SingletonHolder.singleton;
	}
}

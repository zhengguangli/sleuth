package ink.icopy.base.redison;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.util.concurrent.TimeUnit;

public class LockTest {
	public static void main(String[] args) {
		Config config = new Config();
		config.useSingleServer().setAddress("redis://127.0.0.1:6379").setDatabase(0);
		RedissonClient redissonClient = Redisson.create(config);
		RLock lock = redissonClient.getLock("lockKey");
		long leaseTime = 10;
		long waitTimeOut = 30;
		try {
			boolean tryLock = lock.tryLock(waitTimeOut, leaseTime, TimeUnit.SECONDS);
			if (tryLock) {
				// 获取到锁
				System.out.println("lock success!");
			}
		} catch (InterruptedException e) {
			throw new RuntimeException("aquire lock fail");
		} finally {
			//无论如何解锁
			lock.unlock();
		}
	}
}

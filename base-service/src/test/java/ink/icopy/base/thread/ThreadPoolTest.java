package ink.icopy.base.thread;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 线程池的优势：
 * 1.重用存在的线程，减少对象的创建，消亡的内存开销，性能佳
 * 2.可有效控制最大并发线程数，提高系统资源使用率，同时避免过多资源竞争，避免阻塞
 * 3.提供定时执行，定期执行，单线程，并发数控制
 *
 *
 * <p>
 * 线程池的作用：
 * 线程池是为了限制系统中执行线程的数量
 * 根据系统环境情况，可以自动或手动设置线程数量，达到运行的最佳效果；少了浪费系统资源，多了
 * 造成系统拥挤效率不高。用线程池控制线程数量，其它线程排队等候。一个任务执行完毕，再从队列中取得最前面的任务开始执行；
 * 若队列中没有等待进程，线程池的资源处于等待。当一个新任务需要运行时，如果线程池中有等待的工作线程，就可以开始运行了；否则进入等待队列
 * 为什么要用线程池：
 * 1.减少了创建和销毁线程的次数，每个工作线程都可以被重复利用，可以执行多个任务
 * 2.可以根据系统的承受能力，调整线程池中工作线程的数目，防止因为过度消耗内存，增加服务器压力(每个线程大约需要1MB的内存，线程开的越多，消耗
 * 内存越大，最后导致宕机)
 * <p>
 *
 *
 * <p>
 * Java里面线程池的顶级接口是Executor，但严格意义上来讲，Executor并不是一个先吃池，而是一个执行线程的工具。真正的线程接口是
 * ExecutorService比较重要的几个类：
 * Executor：真正的线程池接口
 * ScheduledExecutorService：能和Timer/TimerTask类似，解决那些需要任务重复执行的问题
 * ThreadPoolService：ExecutorService默认的实现类
 * ScheduledExecutorPoolExecutor：继承ThreadPoolExecutor的ScheduledExecutorService接口实现，周期性任务调用的类实现
 * <p>
 * <p>
 * 处理优先级：
 * 核心线程corePoolSize，任务队列workQueue，最大线程maximumPoolSize，如果三者都满了，使用handler处理被拒绝的任务
 */
public class ThreadPoolTest {

    /**
     * newCachedThreadPoolTest：创建一个可缓存线程池，如果线程池长度超过处理需求，
     * 可灵活回收线程 若无可回收线程，则新建线程
     * <p>
     * 线程池为无限大，当执行第二个任务时第一个任务已经完成，会复用执行第一个任务的线程，
     * 而不是每次新增线程
     */
    @Test
    public void newCachedThreadPoolTest() {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            final int index = 1;
            try {
                Thread.sleep(index * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cachedThreadPool.execute(() -> {
                System.out.println(index);
            });
        }
        cachedThreadPool.shutdown();// 立即终止线程池
    }

    @Test
    public void fixedThreadPoolTest() {
        /**
         * newFixedThreadPool：创建一个定长线程池，可控制线程最大兵法数量，超出的线程会在队列中等待
         */
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            final int index = 1;
            fixedThreadPool.execute(() -> {
                System.out.println(index);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        fixedThreadPool.shutdown();
    }

    /**
     * 创建一个定长线程池，支持定时及周期性执行
     *
     * @throws InterruptedException
     */
    @Test
    public void scheduledThreadPoolTest() throws InterruptedException {
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        scheduledThreadPool.schedule(() -> System.out.println("这是一个延迟线程"), 3, TimeUnit.SECONDS);// 延迟3秒执行
        scheduledThreadPool.scheduleAtFixedRate(() -> System.out.println("delay 1 seconds, and excute every 3 seconds"), 1, 2, TimeUnit.SECONDS);
        scheduledThreadPool.awaitTermination(10, TimeUnit.SECONDS);// 等待线程执行完，test会直接结束
        scheduledThreadPool.shutdown();
    }


    /**
     * newSingleThreadPool：创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定的顺序执行
     * (FIFO,LIFO)
     *
     * @throws InterruptedException
     */
    @Test
    public void singleThreadExecutor() throws InterruptedException {
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            final int index = 1;
            singleThreadExecutor.execute(() -> {
                System.out.println(index);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        singleThreadExecutor.awaitTermination(10, TimeUnit.SECONDS);// 等待线程执行完，test会直接结束
        singleThreadExecutor.shutdown();
    }
}

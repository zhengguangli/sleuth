package ink.icopy.base;

import java.util.UUID;

public class UUIDTest {
	public static void main(String[] args) {
		/**
		 * UUID本地生成，不需要基于数据库；
		 * 缺点：
		 * 32固定长度太长，占用空间大，作为主键性能差；
		 * UUID不具有序性，会导致B+树索引在写的时候有过多的随机操作；
		 */
		String uuid = UUID.randomUUID().toString().replace("-", "");
		System.out.println(uuid + " : " + uuid.length());
	}
}

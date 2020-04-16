package ink.icopy.base.treemap;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class MapTest {
	public static void main(String[] args) {

		//初始化自定义比较器
		MyComparator myComparator = new MyComparator();
		//初始化一个map集合
		Map<String, String> treeMap = new TreeMap<>(myComparator);
		treeMap.put("a", "a");
		treeMap.put("e", "e");
		treeMap.put("b", "b");
		treeMap.put("d", "d");
		treeMap.put("c", "c");
		treeMap.put("g", "g");
		treeMap.put("f", "f");

		//使用iterator遍历map
		Iterator<Map.Entry<String, String>> iterator = treeMap.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<String, String> next = iterator.next();
			System.out.println(next.getKey());
		}
	}

}

class MyComparator implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		String param1 = (String) o1;
		String param2 = (String) o2;
		return -param1.compareTo(param2);
	}
}

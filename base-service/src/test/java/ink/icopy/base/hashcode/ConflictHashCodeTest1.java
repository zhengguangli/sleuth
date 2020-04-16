package ink.icopy.base.hashcode;

import java.util.HashSet;
import java.util.Objects;

public class ConflictHashCodeTest1 {
	public static void main(String[] args) {
// 新建Person对象，
		Person p1 = new Person("eee", 100);
		Person p2 = new Person("eee", 100);
		Person p3 = new Person("aaa", 200);

		// 新建HashSet对象
		HashSet set = new HashSet();
		set.add(p1);
		set.add(p2);
		set.add(p3);

		// 比较p1 和 p2， 并打印它们的hashCode()
		System.out.printf("p1.equals(p2) : %s; p1(%d) p2(%d)\n", p1.equals(p2), p1.hashCode(), p2.hashCode());
		// 打印set
		System.out.printf("set:%s\n", set);
	}

	private static class Person {
		int age;
		String name;

		public Person(String name, int age) {
			this.age = age;
			this.name = name;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			Person person = (Person) o;
			return age == person.age &&
							Objects.equals(name, person.name);
		}

		@Override
		public int hashCode() {
			return Objects.hash(age, name);
		}
	}
}

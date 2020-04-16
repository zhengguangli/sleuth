package ink.icopy.base.hashcode;

public class NormalHashCodeTest {
	public static void main(String[] args) {
		Person p1 = new Person(100, "eee");
		Person p2 = new Person(100, "eee");
		Person p3 = new Person(200, "aaa");
		System.out.printf("p1.equals(p2):%s; p1(%d) p2(%d)\n", p1.equals(p2), p1.hashCode(), p2.hashCode());
		System.out.printf("p1.equals(p2):%s; p1(%d) p3(%d)\n", p1.equals(p3), p1.hashCode(), p3.hashCode());
	}

	private static class Person {
		int age;
		String name;

		public Person(int age, String name) {
			this.age = age;
			this.name = name;
		}

		@Override
		public String toString() {
			return "Person{" +
							"age=" + age +
							", name='" + name + '\'' +
							'}';
		}

		/**
		 * 重写equals方法
		 *
		 * @param o
		 * @return
		 */
		@Override
		public boolean equals(Object o) {
			if (o == null)
				return false;
			if (this == o)
				return true;

			if (this.getClass() != o.getClass())
				return false;

			Person person = (Person) o;
			return name.equals(person.name) && age == person.age;
		}

		/**
		 * 重写hashcode方法
		 *
		 * @return
		 */
//		@Override
//		public int hashCode() {
//			return Objects.hash(age, name);
//		}
	}
}



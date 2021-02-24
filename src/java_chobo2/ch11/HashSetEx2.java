package java_chobo2.ch11;

import java.util.HashSet;

class Person {
	String name;
	int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public int hashCode() {
		return (name + age).hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Person) {
			Person object = (Person) obj;
			if(this.name.equals(object.name) && this.age == object.age) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return String.format("Person [name=%s, age=%s]", name, age);
	}

}

public class HashSetEx2 {

	public static void main(String[] args) {
//		hashCodeAndEquals();
		Person p1 = new Person("전수린", 40);
		Person p2 = new Person("전수린", 40);
		Person p3 = new Person("우정아", 40);
		Person p4 = new Person("정민강", 30);
		
		HashSet<Person> ban = new HashSet<Person>(); //HashSet을 제대로 사용하려면 해쉬코드,이퀄스 오버라이딩 사용
		ban.add(p1);
		System.out.println("size " + ban.size());
		ban.add(p2);
		System.out.println("size " + ban.size());
		ban.add(p3);
		System.out.println("size " + ban.size());
		ban.add(p4);
		System.out.println("size " + ban.size());
	}

	public static void hashCodeAndEquals() {
		Person p1 = new Person("전수린", 40);

		int hashCode1 = p1.hashCode();
		int hashCode2 = p1.hashCode();

		System.out.printf("%d = %d%n", hashCode1, hashCode2);
//		p1.age = 30;
		
		int hashCode3 = p1.hashCode();
		System.out.println("hashCode3 " + hashCode3);
		
		Person p2 = new Person("전수린", 40);
		
		int hashCode4 = p2.hashCode();
		System.out.println("hashCode4 " + hashCode4);
		
		boolean isEquals = p1.equals(p2);
		System.out.println("p1 == p2 " + isEquals);
	}

}

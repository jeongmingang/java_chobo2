package java_chobo2.ch11.exam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

class Student2 {
	String name;
	int ban;
	int no;
	int kor, eng, math;
	
	Student2(String name, int ban, int no, int kor, int eng, int math) {
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	int getTotal() {
		return kor + eng + math;
	}

	float getAvg() {
		return (int) ((getTotal() / 3f) * 10 + 0.5)/10f;
	}

	@Override
	public String toString() {
		return name + "," + ban + "," + no + "," + kor + "," + eng + "," + 
									math + "," +  getTotal() + "," + getAvg();
	}
} // class Student

class BanNoAscending implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		if(o1 instanceof Student2 && o2 instanceof Student2) {
			Student2 std1 = (Student2)o1;
			Student2 std2 = (Student2)o2;
			
			int result = std1.ban - std2.ban;
			
			if (result==0) {
				return std1.no - std2.no;
			}
			return result;
		}	
		return -1;
	}
}

	
public class Excercise11_4 {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(new Student2("이자바", 2, 1, 70, 90, 70));
		list.add(new Student2("안자바", 2, 2, 60, 100, 80));
		list.add(new Student2("홍길동", 1, 3, 100, 100, 100));
		list.add(new Student2("남궁성", 1, 1, 90, 70, 80));
		list.add(new Student2("김자바", 1, 2, 80, 80, 90));
		
		Collections.sort(list, new BanNoAscending());
		Iterator it = list.iterator();
		
		while (it.hasNext())
			System.out.println(it.next());
	}
}



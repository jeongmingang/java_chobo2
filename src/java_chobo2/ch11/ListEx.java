package java_chobo2.ch11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class ListEx {

	public static void main(String[] args) {
//		extracted();
		
		HashMap<Integer, Department> deptHash = new HashMap<>();
		deptHash.put(1, new Department(1, "기획", 20));
		deptHash.put(2, new Department(2, "개발", 21));
		deptHash.put(3, new Department(3, "인사", 22));
		deptHash.put(4, new Department(4, "총무", 23));
		System.out.println(deptHash);
		
		Iterator<Entry<Integer, Department>> i = deptHash.entrySet().iterator();
		while(i.hasNext()) {
			Entry<Integer, Department> e = i.next();
			System.out.print(e.getKey() + " ");
//			System.out.print(e.getValue());
			System.out.println(deptHash.get(e.getKey()));
		}
	}

	public static void extracted() {
		ArrayList dbjList = new ArrayList();
		dbjList.add("aa");
		dbjList.add(1);
		dbjList.add(new Department(1, "최순실", 10));

		Iterator i = dbjList.iterator();
		while(i.hasNext()) {
			Object obj = i.next();
				System.out.println(obj);
			}
		
		ArrayList<Department> deptList = new ArrayList<>();
		deptList.add(new Department(1, "기획1", 10));
		deptList.add(new Department(2, "기획2", 20));
		deptList.add(new Department(3, "기획2", 30));
		
		Iterator<Department> iDept = deptList.iterator();
		while(iDept.hasNext()) {
			System.out.println(iDept.next());
		}
	}
	}



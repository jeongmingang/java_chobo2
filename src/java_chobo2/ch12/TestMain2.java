package java_chobo2.ch12;

import java.util.ArrayList;
import java.util.Iterator;

class Product{}

class Tv extends Product{}

class Audio extends Product{}

public class TestMain2 {

	public static void main(String[] args) {
		ArrayList<Tv> listTv = new ArrayList<Tv>();			// 별개의 관계, Tv타입만 가능
//		ArrayList<Product> listProduct = new ArrayList<Tv>(); // 에러 불일치로 상속관계와 별개로 동작, product 타입만 인식됨
		ArrayList<Product> listProduct = new ArrayList<>();   // Tv, Audio, Product다 가능
		
		listTv.add(new Tv());
		
		listProduct.add(new Product());
		listProduct.add(new Tv());
		listProduct.add(new Audio());
		
		Iterator<Product> it = listProduct.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
}

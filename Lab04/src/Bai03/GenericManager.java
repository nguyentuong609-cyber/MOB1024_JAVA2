package Bai03;

import java.util.ArrayList;

public class GenericManager<T> {
	private ArrayList<T> list = new ArrayList<>();
	
	public void addItem(T item) {
		list.add(item);
	}
	
	public void displayItem() {
		list.forEach(System.out :: println);
	}
	
	public ArrayList<T> getAll(){
		return list;
	}
}
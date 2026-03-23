package Bai01;
import java.util.ArrayList;

public class Bai01_main {
	public static void main(String[] args) {
		SinhVien svtest = new SinhVien("SV000", "Tuong", SinhVien.StudentType.REGULAR);
		svtest.printSV();
		
		
		ArrayList<SinhVien> list = new ArrayList<SinhVien>();
		list.add(new SinhVien("SV001", "Tuong", SinhVien.StudentType.REGULAR));
		list.add(new SinhVien("SV002", "Linh", SinhVien.StudentType.PART_TIME));
		list.add(new SinhVien("SV003", "An", SinhVien.StudentType.INTERNATIONAL));
		list.add(new SinhVien("SV004", "Minh", SinhVien.StudentType.REGULAR));
		list.add(new SinhVien("SV005", "Huy", SinhVien.StudentType.PART_TIME));
		list.add(new SinhVien("SV006", "Trang", SinhVien.StudentType.INTERNATIONAL));
		
		for(SinhVien x: list) {
			x.printSV();
			System.out.println("");
		}
		
		System.out.println("Danh Sach SV theo tung loai: ");
		System.out.println("REGULAR: ");
		for(SinhVien x : list) {
			if(x.getType().equals(SinhVien.StudentType.REGULAR)) {
				x.printSV();
			}
		}
		System.out.println("");
		
		System.out.println("PART_TIME: ");
		for(SinhVien x : list) {
			if(x.getType().equals(SinhVien.StudentType.PART_TIME)) {
				x.printSV();
			}
		}
		System.out.println("");
		
		System.out.println("INTERNATIONAL: ");
		for(SinhVien x : list) {
			if(x.getType().equals(SinhVien.StudentType.INTERNATIONAL)) {
				x.printSV();
			}
		}
		System.out.println("");
		
		System.out.println("Dem so luong sinh vien: ");
		int regcount = 0;
		int ptcount = 0;
		int intercount = 0;
		
		for(SinhVien x : list) {
			if(x.getType().equals(SinhVien.StudentType.REGULAR)) {
				regcount ++;
			}
		}
		System.out.println("Regular :" + regcount);
		
		for(SinhVien x : list) {
			if(x.getType().equals(SinhVien.StudentType.PART_TIME)) {
				ptcount ++;
			}
		}
		System.out.println("Part time :" + ptcount);
		
		for(SinhVien x : list) {
			if(x.getType().equals(SinhVien.StudentType.INTERNATIONAL)) {
				intercount ++;
			}
		}
		System.out.println("Part time :" + intercount);
	}
}

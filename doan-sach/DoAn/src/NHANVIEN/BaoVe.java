package NHANVIEN;

import java.util.Scanner;

class BAOVE extends NHANVIEN{
	Scanner sc=new Scanner(System.in);
	String catruc;
	public BAOVE() {
		catruc="";
	}
	public void nhap() {
		super.nhap();
		System.out.println("Ca truc: ");
		catruc=sc.nextLine();
	}
	public void xuat() {
		super.xuat();
		System.out.println("Cong viec: Bao ve.");
		System.out.println("Ca truc: "+catruc);
	}
}
package NHANVIEN;

import java.util.Scanner;

public class THUNGAN extends NHANVIEN{
	Scanner sc=new Scanner(System.in);
	String ngaybanhang;
	public THUNGAN() {
		ngaybanhang="";
	}
	public void nhap() {
		super.nhap();
		System.out.println("Ngay ban hang: ");
		ngaybanhang=sc.nextLine();
	}
	public void xuat() {
		super.xuat();
		System.out.println("Cong viec: Thu ngan");
		System.out.println("Ngay ban hang: "+ngaybanhang);
	}
			
}
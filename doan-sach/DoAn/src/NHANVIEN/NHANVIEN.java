package NHANVIEN;

import java.util.Scanner;
import abstr_interf.*;


public class NHANVIEN implements INhap,IXuat{
	Scanner sc=new Scanner(System.in);

	public String manv;
	public String tennv;
	public String ngaysinhnv;
	public String sdtnv;
	public String diachinv;
	public String luong;
	public NHANVIEN() {
		manv="";
		tennv="";
		ngaysinhnv="";
		sdtnv="";
		diachinv="";
	}
	public void nhap() {
        System.out.println("Nhap thong tin nhan vien: ");
        System.out.print("Ma nhan vien: "); manv=sc.nextLine();
        System.out.print("Ten nhan vien: "); tennv=sc.nextLine();
        System.out.print("Ngay sinh nhan vien: "); ngaysinhnv=sc.nextLine();
        System.out.print("SDT nhan vien: "); sdtnv=sc.nextLine();
        System.out.print("Dia chi nhan vien: "); diachinv=sc.nextLine();
        System.out.print("Luong: "); luong=sc.nextLine();

	}
	public void xuat() {
		System.out.println("Ma nhan vien: "+manv);
		System.out.println("Ten nhan vien: "+tennv);
		System.out.println("Ngay sinh nhan vien: "+ngaysinhnv);
		System.out.println("SDT nhan vien: "+sdtnv);
		System.out.println("Dia chi nhan vien: "+diachinv);
		System.out.println("Luong: "+luong);
		
	}
}
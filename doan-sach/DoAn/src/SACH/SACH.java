package SACH;

import java.util.Scanner;

import abstr_interf.*;

public class SACH implements INhap,IXuat{
    Scanner sc = new Scanner(System.in);
    
    public String MaSach;
    public String TenSach;
    public String NXB;
    public String TacGia;
    public int SoTrang;
    public int SoLuong;
    public int GiaTien;

    private static int KhoSach;
    public static int getKhoSach(){
        return KhoSach;
    }
    public static void updateKhoSach(int n){//n la so luong sach muon them hoac giam 
        KhoSach+=n;
    }
    public SACH(){
        MaSach=NXB=TacGia="";
        SoLuong=SoTrang=GiaTien=0;
    }
    public SACH(String MaSach,String TenSach,String NXB,String TacGia,int SoTrang,int SoLuong,int GiaTien){
        this.MaSach = MaSach;
        this.TenSach = TenSach;
        this.NXB = NXB;
        this.TacGia = TacGia;
        this.SoTrang = SoTrang;
        this.SoLuong = SoLuong; 
        KhoSach+=SoLuong;
        this.GiaTien = GiaTien;
    }
    public void xuat(){
        System.out.print("Ma sach: "+MaSach+", Ten sach: "+TenSach+", Nha xuat ban: "+NXB+", Tac gia: "+TacGia+", So Trang: "+SoTrang+", So luong:"+SoLuong+", Gia Tien: "+GiaTien);
    }
    public void nhap(){
        System.out.println("Nhap cac thong tin cua sach: ");
        System.out.print("Ma sach: "); MaSach=sc.nextLine();
        System.out.print("Ten sach: "); TenSach=sc.nextLine();
        System.out.print("Nha xuat ban: "); NXB=sc.nextLine();
        System.out.print("Tac gia: "); TacGia=sc.nextLine();
        System.out.print("So trang: "); SoTrang=sc.nextInt();
        System.out.print("So luong: "); SoLuong=sc.nextInt(); 
        KhoSach+=SoLuong;
        System.out.print("Gia tien: "); GiaTien=sc.nextInt();
    }

    @Override
    public String toString() {
        return MaSach + "|" + TenSach + "|" + NXB+ "|" + TacGia + "|" + SoTrang+ "|" + SoLuong + "|" + GiaTien;
    }
}


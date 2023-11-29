package HOADON;
import java.util.ArrayList;
import java.util.Scanner;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import NHANVIEN.*;
import SACH.*;
import KHACHHANG.*;

public class DSHoaDon {
    public static ArrayList <HOADON> DanhSachHoaDon;

    public DSHoaDon (){
        DanhSachHoaDon = new ArrayList<HOADON>(0);
    }
    //Scanner sc = new Scanner(System.in);
    private void nhapMaHoaDon(HOADON HoaDonMoi){
        Scanner sc = new Scanner(System.in);
        boolean flag;
        do{
            flag = false;
            System.out.print("Nhap ma hoa don: ");
            HoaDonMoi.MaHoaDon=sc.nextLine();
            for (HOADON hoadon : DanhSachHoaDon) {
                if (HoaDonMoi.MaHoaDon.equals(hoadon.MaHoaDon) || HoaDonMoi.MaHoaDon.isBlank()){
                    flag=true;
                    System.out.println("Da ton tai ma hoa don hoac ma hoa don trong !");
                    break;
                }
            }
        }while (flag);
    }
    private void nhapMaNhanVien(HOADON HoaDonMoi){
        Scanner sc = new Scanner(System.in);
        boolean flag;
        boolean found;
        do{
            flag = false;
            found = false;
            System.out.print("Nhap ma nhan vien: ");
            HoaDonMoi.ChiTietHoaDon.MaNV=sc.nextLine();
            for (NHANVIEN nv : DSNhanVien.DanhSachNhanVien) {
                if (!(nv instanceof THUNGAN)) continue;
                if (HoaDonMoi.ChiTietHoaDon.MaNV.equals(nv.manv)){
                    HoaDonMoi.ChiTietHoaDon.TenNV=nv.tennv;
                    found = true;
                    break;       
                } 
            }
            if (!found){
                System.out.println("Khong tim thay ma nhan vien hoac khong phai nhan vien thu ngan !");
                flag = true;
            }
        } while (flag);
    }
    private void nhapSanPham(HOADON HoaDonMoi){
        Scanner sc = new Scanner(System.in);
        //Neu hoa don da co san pham thi clear va them lai so luong cho sach va kho sach
        if (!HoaDonMoi.ChiTietHoaDon.DanhSachSanPham.isEmpty()){
            //Them lai so luong cho sach va kho sach, xoa san pham
            for (int i=0; i<HoaDonMoi.ChiTietHoaDon.getSL(); i++)
            for (SACH sach : DSSach.DanhSachSach)
                if (sach.MaSach.equals(HoaDonMoi.ChiTietHoaDon.DanhSachMaSanPham.get(i))){
                    sach.SoLuong+=HoaDonMoi.ChiTietHoaDon.SoLuongMoiSP.get(i);
                    SACH.updateKhoSach(HoaDonMoi.ChiTietHoaDon.SoLuongMoiSP.get(i));
                }
            HoaDonMoi.ChiTietHoaDon.DanhSachSanPham.removeAll(HoaDonMoi.ChiTietHoaDon.DanhSachSanPham);
            HoaDonMoi.ChiTietHoaDon.DanhSachMaSanPham.removeAll(HoaDonMoi.ChiTietHoaDon.DanhSachMaSanPham);
            HoaDonMoi.ChiTietHoaDon.SoLuongMoiSP.removeAll(HoaDonMoi.ChiTietHoaDon.SoLuongMoiSP);
        }
        //Them san pham
        int i=1;
        String MaSP;
        int soluong;
        boolean found;
        while(true){   
            found =false;
            System.out.print("Nhap ma san pham "+i+": "); MaSP=sc.nextLine();
            if (MaSP.isEmpty()) break;
            for (SACH sach : DSSach.DanhSachSach) {
                if(sach.MaSach.equals(MaSP)){
                    found=true;
                    System.out.print("Nhap so luong: "); soluong=sc.nextInt(); sc.nextLine();
                    if (soluong > sach.SoLuong) {
                        System.out.println("So luong vuot qua so luong cua sach nay co !");
                        break;
                    }
                    HoaDonMoi.ChiTietHoaDon.DanhSachSanPham.add(sach.TenSach);
                    HoaDonMoi.ChiTietHoaDon.DanhSachMaSanPham.add(sach.MaSach);
                    HoaDonMoi.ChiTietHoaDon.DonGiaMoiSP.add(sach.GiaTien);
                    HoaDonMoi.ChiTietHoaDon.SoLuongMoiSP.add(soluong);
                    sach.SoLuong-=soluong;
                    SACH.updateKhoSach(-soluong);
                    i++;
                }
            }
            if (!found)
                System.out.println("Khong tim thay ma sach !");
        }
    }
    private void nhapMaKhachHang(HOADON HoaDonMoi){
        Scanner sc = new Scanner(System.in);
        boolean flag;
        boolean found;
        do{
            flag = false;
            found = false;
            System.out.print("Nhap ma khach hang: ");
            HoaDonMoi.ChiTietHoaDon.MaKH=sc.nextLine();
            for (KHACHHANG kh : DSKHACHHANG.DSKH) {
                if (HoaDonMoi.ChiTietHoaDon.MaKH.equals(kh.Id)){
                    HoaDonMoi.ChiTietHoaDon.TenKH=kh.Name;
                    if (kh instanceof KHACHHANGTX)
                        ((KHACHHANGTX)kh).setDiemtichluy(((KHACHHANGTX)kh).getDiemtichluy()+1);
                    found = true;
                    break;       
                } 
            }
            if (!found){
                System.out.println("Khong tim thay ma khach hang !");
                flag = true;
            }
        } while (flag);        
    }
    private String getTime(){
        //khai báo đối tượng current thuộc class LocalDateTime
        LocalDateTime current = LocalDateTime.now();
        //sử dụng class DateTimeFormatter để định dạng ngày giờ theo kiểu pattern
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        //sử dụng phương thức format() để định dạng ngày giờ hiện tại rồi gán
        
        return current.format(formatter);
    }
    
    public void them(){
        Scanner sc = new Scanner(System.in);
        HOADON HoaDonMoi = new HOADON();
        boolean sua_lai_toan_bo;
        
        do {
            sua_lai_toan_bo = false;
            nhapMaHoaDon(HoaDonMoi);
            nhapMaNhanVien(HoaDonMoi);
            nhapMaKhachHang(HoaDonMoi);
            nhapSanPham(HoaDonMoi);
            boolean sua_lai;
            do{
                HoaDonMoi.Date=getTime();
                HoaDonMoi.xuat();                
                System.out.print(" 1)Luu hoa don\n 2)Sua lai\n");
                System.out.print("Lua chon: ");
                int lua_chon=sc.nextInt();
                switch (lua_chon) {
                    case 1:
                        sua_lai=false;
                        break;
                    case 2:
                        sua_lai = true;
                        boolean valid_chose_case_sua=true;
                        do{
                            valid_chose_case_sua=true;
                            System.out.println("Chon thong tin muon sua:");
                            System.out.print(" 1)Sua lai toan bo\n 2)Ma hoa don\n 3)Ma nhan vien\n 4)Ma khach hang\n 5)San pham\n");
                            System.out.print("Lua chon: ");
                            lua_chon=sc.nextInt(); sc.nextLine();
                            switch (lua_chon) {
                                case 1:
                                    sua_lai_toan_bo = true;
                                    sua_lai = false;
                                    break;
                                case 2: 
                                    nhapMaHoaDon(HoaDonMoi);
                                    break;
                                case 3: 
                                    nhapMaNhanVien(HoaDonMoi);
                                    break;
                                case 4: 
                                    nhapMaKhachHang(HoaDonMoi);
                                    break;
                                case 5: 
                                    nhapSanPham(HoaDonMoi);
                                    break;
                                default:
                                    System.out.println("Lua chon khong hop le !");
                                    valid_chose_case_sua = false;
                                    break;
                            }                               
                        } while(!valid_chose_case_sua);
                        break;   // break case sua lai
                    default:
                        System.out.println("Lua chon khong hop le !");
                        sua_lai=true;
                        break;
                    }
            } while(sua_lai);
        } while (sua_lai_toan_bo);
        DanhSachHoaDon.add(HoaDonMoi);
        DSSach.luu();
        DSKHACHHANG.luu();
    }
    public void timkiem(){
        Scanner sc = new Scanner(System.in);
        String MaHoaDonTimKiem;
        boolean found = false;
        System.out.print("Nhap ma hoa don can tim: ");
        MaHoaDonTimKiem=sc.nextLine();
        for (HOADON hoadon : DanhSachHoaDon) {
            if (MaHoaDonTimKiem.equals(hoadon.MaHoaDon)){
                found = true;
                hoadon.xuat();
                break;
            }
        }
        if (!found)
            System.out.println("Khong tim thay ma hoa don !");
    }
    
    public void xoa(){
        Scanner sc = new Scanner(System.in);
        String MaHoaDonXoa;
        boolean found = false;
        System.out.print("Nhap ma hoa don muon xoa: ");
        MaHoaDonXoa=sc.nextLine();
        for (HOADON hoadon : DanhSachHoaDon) {
            if (MaHoaDonXoa.equals(hoadon.MaHoaDon)){
                found = true;
                DanhSachHoaDon.remove(hoadon);
                break;
            }
        }
        if (found)
            System.out.println("Da xoa hoa don !");
        else System.out.println("Khong tim thay ma hoa don !");
    }
    public void danhsach(){
        int tong=0;
        //System.out.println("Danh sach co "+DanhSachHoaDon.size()+" hoa don:");
        int i=1;
        for (HOADON hoadon : DanhSachHoaDon) {
            tong+=hoadon.TongTien();
            System.out.println("---Hoa don "+i+":");
            hoadon.xuat();
            i++;
        }
        System.out.println("\n***Danh sach co "+DanhSachHoaDon.size()+" hoa don");
        System.out.println("***Tong doanh thu: "+tong+"\n");
    }
    public static void WriteFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("datahoadon.txt"))) {
            for (HOADON hoadon : DanhSachHoaDon) {
                writer.write(hoadon.MaHoaDon+",");
                writer.write(hoadon.ChiTietHoaDon.MaNV+",");
                writer.write(hoadon.ChiTietHoaDon.TenNV+",");
                writer.write(hoadon.ChiTietHoaDon.MaKH+",");
                writer.write(hoadon.ChiTietHoaDon.TenKH+",");
                writer.write(hoadon.Date+"\n");
                int i=1;
                for (String masach : hoadon.ChiTietHoaDon.DanhSachMaSanPham) {
                    if (hoadon.ChiTietHoaDon.getSL()!=i)
                        writer.write(masach+",");
                    else writer.write(masach+"\n"); 
                    i++;
                }
                i=1;
                for (String tensach : hoadon.ChiTietHoaDon.DanhSachSanPham) {
                    if (hoadon.ChiTietHoaDon.getSL()!=i)
                        writer.write(tensach+",");
                    else writer.write(tensach+"\n"); 
                    i++;
                }

                i=1;
                for (Integer dongia : hoadon.ChiTietHoaDon.DonGiaMoiSP) {
                    String num = dongia.toString();
                    if ((hoadon.ChiTietHoaDon.DonGiaMoiSP.size())!=i)
                        writer.write(num+",");
                    else writer.write(num+"\n");
                    i++;
                }

                i=1;
                for (Integer soluong : hoadon.ChiTietHoaDon.SoLuongMoiSP) {
                    String num = soluong.toString();
                    if ((hoadon.ChiTietHoaDon.SoLuongMoiSP.size())!=i)
                        writer.write(num+",");
                    else writer.write(num+"\n");
                    i++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void ReadFile(){
        try (BufferedReader reader = new BufferedReader(new FileReader("datahoadon.txt"))) {
            String buff;
            String line1[],line2[],line3[],line4[],line5[];
            while ((buff = reader.readLine()) != null){
                HOADON hoadon = new HOADON();

                line1 = buff.split(",");
                hoadon.MaHoaDon=line1[0];
                hoadon.ChiTietHoaDon.MaNV=line1[1];
                hoadon.ChiTietHoaDon.TenNV=line1[2];
                hoadon.ChiTietHoaDon.MaKH=line1[3];
                hoadon.ChiTietHoaDon.TenKH=line1[4];
                hoadon.Date=line1[5];

                buff = reader.readLine();
                line2 = buff.split(",");
                for (String masach : line2) {
                    hoadon.ChiTietHoaDon.DanhSachMaSanPham.add(masach);
                }
            
                buff = reader.readLine();
                line3 = buff.split(",");
                for (String tensach : line3) {
                    hoadon.ChiTietHoaDon.DanhSachSanPham.add(tensach);
                }

                buff = reader.readLine();
                line4 = buff.split(",");
                for (String dongia : line4){
                    int num = Integer.parseInt(dongia);
                    hoadon.ChiTietHoaDon.DonGiaMoiSP.add(num);
                }

                buff = reader.readLine();
                line5 = buff.split(",");
                for (String soluong : line5){
                    int num = Integer.parseInt(soluong);
                    hoadon.ChiTietHoaDon.SoLuongMoiSP.add(num);
                }

                DanhSachHoaDon.add(hoadon);
            }

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

}

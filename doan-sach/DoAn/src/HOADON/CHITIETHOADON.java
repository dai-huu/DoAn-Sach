package HOADON;

import java.util.ArrayList;

public class CHITIETHOADON {

    String MaNV;
    String TenNV;
    String TenKH;
    String MaKH;
    ArrayList <Integer> SoLuongMoiSP;
    ArrayList <String> DanhSachSanPham;
    ArrayList <String> DanhSachMaSanPham;
    ArrayList <Integer> DonGiaMoiSP;

    CHITIETHOADON(){
        TenKH=MaKH=TenNV=MaNV="";
        SoLuongMoiSP = new ArrayList<Integer>(0);
        DanhSachSanPham = new ArrayList <String>(0);
        DanhSachMaSanPham = new ArrayList <String>(0);
        DonGiaMoiSP = new ArrayList<Integer>(0);
    }

    int getSL(){
        return DanhSachSanPham.size();
    }
}

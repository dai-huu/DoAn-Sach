import java.util.Scanner;

import HOADON.*;
import KHACHHANG.*;
import SACH.*;
import NHANVIEN.*;

public class Main {
    public static void main(String[] args) {
        QuanLyDSHoaDon qlHoaDon = new QuanLyDSHoaDon();
        QuanLyDSSach qlSach =new QuanLyDSSach();
        QuanLyDSNhanVien qlNhanVien = new QuanLyDSNhanVien();
        QL_DSKHACHHANG qlKhachHang = new QL_DSKHACHHANG();

        DSHoaDon.ReadFile();
        DSKHACHHANG.doc();
        DSSach.doc();
        DSNhanVien.ReadFile();

        boolean flag = true;
        while (flag) {
            System.out.print(" 1)Quan ly sach\n 2)Quan ly nhan vien\n 3)Quan ly hoa don\n 4)Quan ly khach hang\n 5)Thoat\n");
            System.out.print("Lua chon: ");
            Scanner sc = new Scanner(System.in);
            int lua_chon=sc.nextInt();
            switch (lua_chon) {
                case 1:
                    qlSach.Menu();
                    break;
                case 2:
                    qlNhanVien.Menu();
                    break;
                case 3:
                    qlHoaDon.Menu();
                    break;
                case 4:
                    qlKhachHang.Menu();
                    break;
                case 5:
                    flag=false;
                    break;
            }
        }
    }
}


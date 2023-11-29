package HOADON;


import java.util.Scanner;

//import NHANVIEN.*;
//import SACH.*;

public class QuanLyDSHoaDon{
    public DSHoaDon dsHoaDon;

    public QuanLyDSHoaDon (){
        dsHoaDon = new DSHoaDon();
    }
    Scanner sc =new Scanner(System.in);
    public void Menu(){
        
        int lua_chon=0;
        boolean flag = true;
        while(flag){ 
            System.out.println(" 1)Them hoa don\n 2)Tim kiem hoa don\n 3)Xoa hoa don\n 4)Xuat danh sach hoa don\n 5)Quay lai\n 6)Thoat");
            System.out.print("Lua chon: "); 
            lua_chon=sc.nextInt();
            switch (lua_chon) {
                case 1:
                    dsHoaDon.them();
                    break;
                case 2:
                    dsHoaDon.timkiem();
                    break;
                case 3:
                    dsHoaDon.xoa();
                    break;
                case 4:
                    dsHoaDon.danhsach();
                    break;
                case 5:
                    flag = false;
                    DSHoaDon.WriteFile();
                    break;
                case 6:
                    DSHoaDon.WriteFile();//dsHoaDon.WriteFile();
                    System.exit(0);
            }
        }
    }
}


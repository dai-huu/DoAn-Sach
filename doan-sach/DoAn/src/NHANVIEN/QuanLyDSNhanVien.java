package NHANVIEN;

import java.util.Scanner;


public class QuanLyDSNhanVien {
    public DSNhanVien dsNhanVien;
            Scanner sc = new Scanner(System.in);

    public QuanLyDSNhanVien(){
    	dsNhanVien = new DSNhanVien();
    }
    public void Menu(){
        int lua_chon;
       	boolean flag=true;
        while(flag){
            System.out.println(" 1/Them nhan vien.\n 2/Xoa nhan vien.\n 3/Sua nhan vien.\n 4/Xuat danh sach nhan vien.\n 5/Tim kiem nhan vien.\n 6.Quay lai.\n 7.Thoat\n");
            lua_chon=sc.nextInt();
            switch(lua_chon){
                case 1:
					dsNhanVien.them();
                    break;
                case 2:
                    dsNhanVien.xoa();
                    break;
                case 3:
                    dsNhanVien.sua();
                    break;
                case 4:
                    dsNhanVien.danhsach();
                    break;
                case 5:
                    dsNhanVien.timkiem();
                    break;
                case 6:
                    flag=false;
                    DSNhanVien.WriteFile();
                    break;
                case 7:
                    DSNhanVien.WriteFile();
                    System.exit(0);
           }
        }
    }

}
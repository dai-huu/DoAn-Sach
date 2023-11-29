package SACH;

import java.util.Scanner;

public class QuanLyDSSach{
    public DSSach dsSach = new DSSach();
    Scanner sc=new Scanner(System.in);

    public void Menu(){
        int lua_chon=0;
        boolean flag = true;
        while(flag){
            System.out.print(" 1)Them sach\n 2)Xoa sach\n 3)Sua sach\n 4)Xuat danh sach sach\n 5)Tim kiem sach\n 6)Kho sach\n 7)Quay lai\n 8)Thoat\n");
            System.out.print("Lua chon: ");
            lua_chon=sc.nextInt();
            switch(lua_chon){
                case 1:
                    dsSach.them();
                    break;
                case 2:
                    dsSach.xoa();
                    break;
                case 3:
                    dsSach.sua();
                    break;
                case 4:
                    dsSach.danhsach();
                    break;
                case 5:
                    dsSach.timkiem();
                    break;
                case 6:
                    System.out.println("So luong sach co trong kho: "+SACH.getKhoSach());
                    break;
                case 7:
                    flag = false;
                    DSSach.luu();
                    break;
                case 8:
                    DSSach.luu();
                    System.exit(0);

            }
        }
    }
}
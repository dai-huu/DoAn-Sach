package KHACHHANG;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import abstr_interf.*;
public class DSKHACHHANG extends MENU{
    public static ArrayList<KHACHHANG> DSKH;//danh sách mảng
    public DSKHACHHANG(){//khởi tạo
        DSKH= new ArrayList<KHACHHANG>();
    }
    Scanner sc=new Scanner(System.in);
   
    public void them(){//thêm khách hàng vào list
        int choose=0;
        boolean flag=true;//biến cờ để lặp lại cho đến khi nhận biến choose là kiểu int
        System.out.println("Vui long lua chon hinh thuc mua hang\n1:Mua truc tiep=>Khach hang thuong xuyen\n2:Mua Online=>Khach hang online");
        
        while(flag){
            if(sc.hasNextInt()){//dòng tiếp theo nhập vào là 1 số nguyên
               choose=sc.nextInt();
               if(choose==1 || choose==2)
                    flag=false;
                else{
                    System.out.println("nhap sai thong tin");
                    System.out.println("Vui long lua chon hinh thuc mua hang\n1:Mua truc tiep=>Khach hang thuong xuyen\n2:Mua Online=>Khach hang online");
                }
            }
            else{
                System.out.println("vui long nhap so nguyen");
                sc.next();//không phải số nguyên nên đẩy đi tiếp vòng while luôn,loại dữ liệu nhập vào ra khỏi scanner
            }
        }
        sc.nextLine();
        if(choose==1){
            KHACHHANG x= new KHACHHANGTX();
            x.nhap();
            DSKH.add(x);
            System.out.printf("------------------\n|Da them vao data|\n------------------\n");
        }
        else if(choose==2){
            KHACHHANG x= new KHACHHANGONLINE();
            x.nhap();
            DSKH.add(x);
            System.out.printf("------------------\n|Da them vao data|\n------------------\n");
        }
    }

    public void sua(){//chỉnh sửa theo thong tin
        int choose=0;//chú ý khởi tạo trước khi sử dụng để check ở dưới
        String S_MA;
        System.out.println("\nNhap Ma Khach Hang can sua");
        S_MA=sc.nextLine();
        String s;
        boolean flag=true;
        for(KHACHHANG x :DSKH){

            if(x.Id.equals(S_MA)){
                if(x instanceof KHACHHANGTX){//x là khách hàng thường xuyên
                    System.out.print("\nChon muc can sua thong tin:\n1:Ma Khach Hang\n2:Ho ten\n3:Dia chi\n4:So dien thoai\n5:Diem tich luy\n");
                while(flag){
                    if(sc.hasNextInt()){
                        choose=sc.nextInt();
                    if(choose<=5 && choose>0)
                            flag=false;
                    else{
                        System.out.println("!!! Nhap sai thong tin");
                        System.out.print("\nChon muc can sua thong tin:\n1:Ma Khach Hang\n2:Ho ten\n3:Dia chi\n4:So dien thoai\n5:Diem tich luy\n");
                    }
                        }
                    else{
                        System.out.println("~ Vui long nhap so nguyen ~");
                        sc.next();
                    }
                }
                sc.nextLine();

                    if(choose==1){//cập nhật mã khách hàng
                        String k;
                        while(true){
                            System.out.println("Nhap MA KH cap nhat");
                            k=sc.nextLine();
                            int flag1=DSKHACHHANG.check_id_trung_lap(k);
                            if(flag1==-1)
                                System.out.println("!!! Ma khach hang da ton tai");
                            else if(flag1==0) {
                                x.Id=k;
                                break;
                            }
                        } 
                    }
                    else if(choose==2){//cập nhật họ tên
                        System.out.println("Nhap HO TEN cap nhat");
                        s=sc.nextLine();
                        x.Name=s;
                    }
                    else if(choose==3){//cập nhật địa chỉ
                        System.out.println("Nhap DIA CHI cap nhat");
                        s=sc.nextLine();
                        x.Address=s;
                    }
                    else if(choose==4){//cập nhật số điện thoại
                        String k;
                        while(true){//nhập số điện thoại khách hàng
                            System.out.println("Nhap SO DIEN THOAI cap nhat");
                            k=sc.nextLine();
                            int flag2=DSKHACHHANG.check_phone_trung_lap(k);
                            if(flag2==-1)
                                System.out.println("!!! SDT khach hang da ton tai");
                            else if(flag2==0) {
                                x.Phone=k;
                                break;
                            }
                        } 
                    }
                    else if(choose==5){//cập nhật điểm tích lũy
                        System.out.println("Nhap DIEM TICH LUY cap nhat");
                        int k=0;
                        while(flag){
                            if(sc.hasNextInt()){
                                k=sc.nextInt();
                               if(k>0)
                                    flag=false;
                                else
                                    System.out.println("~ Vui long nhap diem tich luy > 0 ~");
                                }
                            else{
                                System.out.println("~ Vui long nhap so nguyen ~");
                                sc.next();
                            }
                        }
                        sc.nextLine();
                        ((KHACHHANGTX)x).setDiemtichluy(k);
                    }
                }
                else if(x instanceof KHACHHANGONLINE){//x là khách hàng online
                    System.out.print("\nChon muc can sua thong tin:\n1:Ma Khach Hang\n2:Ho ten\n3:Dia chi\n4:So dien thoai\n5:Ma don hang\n6:Gmail\n");
                    while(flag){
                        if(sc.hasNextInt()){
                            choose=sc.nextInt();
                                if(choose<=6 && choose>0)
                                    flag=false;
                                else{
                                    System.out.println("!!! Nhap sai thong tin");
                                    System.out.print("\nChon muc can sua thong tin: \n1:Ma Khach Hang\n2:Ho ten\n3:Dia chi\n4:So dien thoai\n5:Ma don hang\n6:Gmail\n");
                                }
                        }
                        else{
                            System.out.println("~ Vui long nhap so nguyen ~");
                            sc.next();
                        }
                    }
                    sc.nextLine();
                    if(choose==1){//cập nhật mã khách hàng
                        String k;
                        while(true){
                            System.out.println("Nhap MA KH cap nhat");
                            k=sc.nextLine();
                            int flag1=DSKHACHHANG.check_id_trung_lap(k);
                            if(flag1==-1)
                                System.out.println("!!! Ma khach hang da ton tai");
                            else if(flag1==0) {
                                x.Id=k;
                                break;
                            }
                        } 
                    }
                    else if(choose==2){//cập nhật họ tên khách hàng
                        System.out.println("Nhap HO TEN cap nhat");
                        s=sc.nextLine();
                        x.Name=s;
                    }
                    else if(choose==3){//cập nhật địa chỉ 
                        System.out.println("Nhap DIA CHI cap nhat");
                        s=sc.nextLine();
                        x.Address=s;
                    }
                    else if(choose==4){//cập nhật số điện thoại
                        String k;
                        while(true){//nhập số điện thoại khách hàng
                            System.out.println("Nhap SO DIEN THOAI cap nhat");
                            k=sc.nextLine();
                            int flag2=DSKHACHHANG.check_phone_trung_lap(k);
                            if(flag2==-1)
                                System.out.println("!!! SDT khach hang da ton tai");
                            else if(flag2==0) {
                                x.Phone=k;
                                break;
                            }
                        } 
                    }
                    else if(choose==5){//cập nhật mã đơn hàng
                        String m;
                        while(true){//nhập mã đơn hàng
                            System.out.println("Nhap MA DON HANG cap nhat ");
                             m=sc.nextLine();
                            int flag1=DSKHACHHANG.check_madonhang_trung_lap(m);
                            if(flag1==-1)
                                 System.out.println("!!! Ma khach hang da ton tai");
                            else if(flag1==0) {
                                ((KHACHHANGONLINE)x).setMadonhang(m);
                                break;
                            }
                        }    
                    }
                    else if(choose==6){//cập nhật gmail
                        String n;
                        do{//nhập gmail
                                System.out.println("Nhap GMAIL cap nhat");
                                n=sc.nextLine();
                            if (!KHACHHANGONLINE.checkmail(n)) {// Kiểm tra định dạng email
                                System.out.println("!!! Sai dinh dang email");
                                continue;
                            }
                            int flag2 = DSKHACHHANG.check_gmail_trung_lap(n);
                            if (flag2 == -1) {
                                System.out.println("!!! Gmail da ton tai");
                            }else if (flag2 == 0) {
                                ((KHACHHANGONLINE)x).setGmail(n);
                                break;
                            }
                        } while (true);
                    }
                }
            }
            else if(!(x.Id.equals(S_MA))  && DSKH.get(DSKH.size() - 1).Id==x.Id)//khác mã và cuối của array list
                System.out.println("! Khong tim thay khach hang de sua thong tin");
        }
    }

    public void xoa(){//xóa theo id khách hàng
        System.out.println("Nhap ID KHACH HANG can xoa");
        String S_MA=sc.nextLine();
        for(KHACHHANG x:DSKH){
            if(S_MA.equals(x.Id)){
                DSKH.remove(x);
                System.out.println("DA XOA");
                break;
            }
        }
    }

    public void timkiem(){//tìm kiếm theo ten khach hang
        System.out.println("Nhap TEN KHACH HANG muon tim");
            String S_NAME=sc.nextLine();
            String tmp;
            boolean flag=false;
            for(KHACHHANG x:DSKH){//format về hết chữ thường cho dễ tìm thấy
                tmp=x.Name;//biến tạm để ép thường đi so sánh
                 if(S_NAME.toLowerCase().equals(tmp.toLowerCase())==true){
                    x.xuat();
                    flag=true;
                    break;
                }    
            }  
            if(flag)
                System.out.println("CO tim thay!!");
            else    
               System.out.println("KHONG tim thay!!");
    }

    public void danhsach() {//xuất danh sách lưu trong list
        for(KHACHHANG x : DSKH){
            x.xuat();
        }
    }

    public static void luu() {//chia truong hop viet vao
        try {
            FileWriter fw = new FileWriter("DS-KH.txt");
            for (KHACHHANG x : DSKH) {
                if(x instanceof KHACHHANGTX)//READ AGAIN
                    fw.write(x.Id +"|"+x.Name+"|"+x.Address+"|"+x.Phone+"|"+((KHACHHANGTX)x).getDiemtichluy()+"\n");
                else if(x instanceof KHACHHANGONLINE)
                    fw.write(x.Id +"|"+x.Name+"|"+x.Address+"|"+x.Phone+"|"+((KHACHHANGONLINE)x).getMadonhang()+"|"+((KHACHHANGONLINE)x).getGmail()+"\n");
            }
            fw.close();
            System.out.println("Data saved to file.");
            }
             catch (Exception e) {
                System.out.println(e);
            }
    }

    public static void doc() {
        try (BufferedReader input = new BufferedReader(new FileReader("DS-KH.txt"))) {
            String line = input.readLine();
            while (line != null) {
                String[] parts = line.split("\\|");
                KHACHHANG y=new KHACHHANG();

                if (parts.length == 5) {
                    y = new KHACHHANGTX();
                    ((KHACHHANGTX) y).setDiemtichluy(Integer.parseInt(parts[4]));
                }
                else if(parts.length==6){
                   y =new KHACHHANGONLINE();
                    ((KHACHHANGONLINE) y).setMadonhang(parts[4]);
                    ((KHACHHANGONLINE) y).setGmail(parts[5]);  
                }
                y.Id=parts[0];
                y.Name=parts[1];
                y.Address=parts[2];
                y.Phone=parts[3];
                DSKH.add(y);

                line = input.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int check_id_trung_lap(String y){
         for(KHACHHANG x : DSKH){
            if(x.Id.equals(y))//tìm thấy id đã đc ghi vào trc nên trùng rồi
                return -1;
        }
        return 0;
    }
    public static int check_phone_trung_lap(String y){
         for(KHACHHANG x : DSKH){
            if(x.Phone.equals(y))
                return -1;
        }
        return 0;
    }
    public static int check_madonhang_trung_lap(String y){
         for(KHACHHANG x : DSKH){
            if(x instanceof KHACHHANGONLINE)
                if(((KHACHHANGONLINE) x).getMadonhang().equals(y))
                    return -1;
        }
        return 0;
    }
    public static int check_gmail_trung_lap(String y){
         for(KHACHHANG x : DSKH){
            if(x instanceof KHACHHANGONLINE)
                if(((KHACHHANGONLINE) x).getGmail().equals(y))
                    return -1;
        }
        return 0;
    }

}


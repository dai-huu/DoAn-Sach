package KHACHHANG;
import java.util.Scanner;
import abstr_interf.*;
public class KHACHHANG implements INhap,IXuat{
    public String Id;
    public String Name;
    public String Address;
    public String Phone;
    Scanner sc=new Scanner(System.in);
  
    public KHACHHANG() {//khởi tạo
        Id = ""; Name = "";
        Address = "";Phone = "";
    }
    
    public void nhap(){
        String x,y;//2 biến để làm biến tạm kiểm tra xem có trùng lặp data không
        while(true){//nhập mã khách hàng
            System.out.println("Nhap MA khach hang");
            x=sc.nextLine();
            int flag1=DSKHACHHANG.check_id_trung_lap(x);
            if(flag1==-1)
                System.out.println("!!! Ma khach hang da ton tai");
            else if(flag1==0) {
                Id=x;
                break;
            }
        } 
        System.out.println("Nhap TEN khach hang ");
            Name=sc.nextLine();
        System.out.println("Nhap DIA CHI khach hang ");
            Address=sc.nextLine();
       
        while(true){//nhập số điện thoại khách hàng
            System.out.println("Nhap SO DIEN THOAI khach hang ");
            y=sc.nextLine();
        int flag2=DSKHACHHANG.check_phone_trung_lap(y);
            if(flag2==-1)
                System.out.println("!!! SDT khach hang da ton tai");
            else if(flag2==0) {
                Phone=y;
                break;
            }
        } 
    }
    public void xuat(){
        System.out.printf("\n");
        System.out.println("Thong tin khach hang:");
        System.out.println("ID: " + Id);
        System.out.println("TEN: " + Name);
        System.out.println("DIA CHI: " + Address);
        System.out.println("SO DIEN THOAI: " + Phone);
    }
}

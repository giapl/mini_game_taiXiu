package main;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

/*
  * một người chơi se có tai khoản. người chơi có quyền đặt cược số tiền ít hơn hoặc số tiền họ đang có
  * luật chơi
  * 3 viên xúc sắc.mỗi viên có 6 mặt có giá trị từ 1 đến 6.
  * kết quả mỗi luần xúc : viên 1+viên 2+viên 3
  * 1. nếu tống=3 hoặc 18 => nhà cái ăn hết
  * 2 nếu tổng (4-10) xỉu =>nếu đặt xỉu thảng và tài thua
  * 3. nếu tổng (11-17) tài => nếu đặt tài thắng và xỉu thua
 */
public class taixiu {
    public static void main(String[] args) {
        double taiKhoanNguoiChoi = 5000000;
        Scanner sc = new Scanner(System.in);
        // ham local so theo quoc gia
        Locale lc = new Locale("vi", "VN");
        // ham numberformat dien so de doc hon
        NumberFormat num = NumberFormat.getInstance();
        int luaChon = 1;
        do {
            System.out.println("---------- moi ban lua chon ------------");
            System.out.println(" chon (1) de tiep tuc choi.");
            System.out.println(" chon (2) rut tien ");
            System.out.println(" chon (phim bat ki) de thoat.");
            luaChon = sc.nextInt();
            if (luaChon == 1) {
                System.out.println("---------- Bat Dau Choi ------------");
                // dat cuoc
                System.out.println("***** tai khoan cua ban: " + num.format(taiKhoanNguoiChoi) + " ban muon cuoc bao nhieu ");
                double datCuoc;
                do {
                    System.out.println("***** dat cuoc 0<so tien cuoc <=" + num.format(taiKhoanNguoiChoi));
                    System.out.print(" Moi ban dat cuoc: ");
                    datCuoc = sc.nextDouble();
                } while (datCuoc <= 0 || datCuoc > taiKhoanNguoiChoi);
                // chon tai hoac xiu
                int luaChonTaiXiu;
                do {
                    System.out.println("***** chon: 1 <-> xiu hoac 2 <-> tai ");
                    System.out.print(" Moi ban chon cau :");
                    luaChonTaiXiu = sc.nextInt();
                    if (luaChonTaiXiu == 1) {
                        System.out.println("ban da chon xiu");
                    } else {
                        System.out.println("ban da chon tai");
                    }
                } while (luaChonTaiXiu != 1 && luaChonTaiXiu != 2);
                // tung xuc xac
                Random xucXac1 = new Random();
                Random xucXac2 = new Random();
                Random xucXac3 = new Random();
                int giaTri1 = xucXac1.nextInt(1, 6);
                int giaTri2 = xucXac2.nextInt(1, 6);
                int giaTri3 = xucXac3.nextInt(1, 6);
                int tong = giaTri1 + giaTri2 + giaTri3;
                // tinh toan ket qua
                System.out.println("**** ket qua dat cuoc: " + giaTri1 + "-" + giaTri2 + "-" + giaTri3);
                if (tong == 3 || tong == 18) {
                    taiKhoanNguoiChoi = taiKhoanNguoiChoi - datCuoc;
                    System.out.println("ket qua :" + tong + "nha cai an het ban da thua ");
                    System.out.println("tai khoan cua ban la:" + num.format(taiKhoanNguoiChoi));
                } else if (tong >= 4 && tong <= 10) {
                    System.out.println("ket qua la:" + tong + " => xiu");
                    if (luaChonTaiXiu == 1) {
                        System.out.println("xin chuc mung ban da thang dc so tien:" + datCuoc);
                        taiKhoanNguoiChoi = taiKhoanNguoiChoi + datCuoc;
                        System.out.println("tai khoan cua ban la:" + num.format(taiKhoanNguoiChoi));
                    } else {
                        System.out.println("ban da thua cuoc:" + datCuoc);
                        taiKhoanNguoiChoi = taiKhoanNguoiChoi - datCuoc;
                        System.out.println("tai khoan cua ban la:" + num.format(taiKhoanNguoiChoi));
                    }
                } else {
                    System.out.println("ket qua la :" + tong + " => tai ");
                    if (luaChonTaiXiu == 2) {
                        System.out.println("xin chuc mung ban da thang dc so tien:" + datCuoc);
                        taiKhoanNguoiChoi = taiKhoanNguoiChoi + datCuoc;
                        System.out.println("tai khoan cua ban la:" + num.format(taiKhoanNguoiChoi));
                    } else {
                        System.out.println("ban da thua cuoc:" + datCuoc);
                        taiKhoanNguoiChoi = taiKhoanNguoiChoi - datCuoc;
                        System.out.println("tai khoan cua ban la:" + num.format(taiKhoanNguoiChoi));
                    }
                }
                sc.nextLine();
            } else if (luaChon == 2) {
                    do {
                        System.out.println("so tien hien co cua ban:" + taiKhoanNguoiChoi);
                        System.out.println("xin moi ban nhap ten ngan hang:");
                        sc.nextLine();
                        String nganHang = sc.nextLine();
                        System.out.println("moi ban nhap so tai khoan");
                        String sotaikhoan = sc.nextLine();
                        System.out.println("nhap so tien can rut:");
                        double sotiencanrut = sc.nextDouble();
                        if (sotiencanrut <= taiKhoanNguoiChoi) {
                            System.out.println("ban da rut thanh cong so tien:" + sotiencanrut);
                            taiKhoanNguoiChoi = taiKhoanNguoiChoi - sotiencanrut;
                            System.out.println("so tien con lai cua ban:" + taiKhoanNguoiChoi);

                        } else {
                            System.out.println("ban rut khong thanh cong");
                        }
                    } while (taiKhoanNguoiChoi != 0 && taiKhoanNguoiChoi == 0);
                }
        } while (luaChon == 1 || luaChon == 2) ;
    }
}

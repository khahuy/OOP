import java.util.Scanner;

public class MAIN {
    private static QUANLYNHANSU qlns = new QUANLYNHANSU();
    private static Scanner sc = new Scanner(System.in);

    // Menu chính
    public static void main(String[] args) {
        int luaChon;

        System.out.println("╔═══════════════════════════════════════════════╗");
        System.out.println("║   CHAO MUNG DEN HE THONG QUAN LY NHAN SU      ║");
        System.out.println("╚═══════════════════════════════════════════════╝\n");

        do {
            System.out.println("╔════════════════════════════════════════════╗");
            System.out.println("║        HE THONG QUAN LY NHAN SU            ║");
            System.out.println("╠════════════════════════════════════════════╣");
            System.out.println("║  1. Nhan su                                ║");
            System.out.println("║  2. Hop dong                               ║");
            System.out.println("║  3. Bang luong                             ║");
            System.out.println("║  4. Du an                                  ║");
            System.out.println("║  5. Thong ke                               ║");
            System.out.println("║  6. Ghi danh sach ra file                  ║");
            System.out.println("║  7. Doc file danh sach                     ║");
            System.out.println("║  0. Thoat chuong trinh                     ║");
            System.out.println("╚════════════════════════════════════════════╝");
            System.out.print("Nhap lua chon cua ban: ");

            try {
                luaChon = sc.nextInt();
                sc.nextLine(); // Clear buffer
            } catch (Exception e) {
                System.out.println("Loi: Vui long nhap so!");
                sc.nextLine(); // Clear invalid input
                luaChon = -1;
                continue;
            }

            switch (luaChon) {
                case 1:
                    menuNhanSu();
                    break;
                case 2:
                    menuHopDong();
                    break;
                case 3:
                    menuBangLuong();
                    break;
                case 4:
                    menuDuAn();
                    break;
                case 5:
                    menuThongKe();
                    break;
                case 6:
                    qlns.ghiFile();
                    break;
                case 7:
                    qlns.docFile();
                    break;
                case 0:
                    System.out.println("╔═══════════════════════════════════════════════╗");
                    System.out.println("║  CAM ON BAN DA SU DUNG CHUONG TRINH!          ║");
                    System.out.println("║           HEN GAP LAI!                        ║");
                    System.out.println("╚═══════════════════════════════════════════════╝");
                    break;
                default:
                    System.out.println("Lua chon khong hop le! Vui long chon tu 0-7.");
            }

            // Tạm dừng để người dùng đọc kết quả
            if (luaChon != 0 && luaChon >= 1 && luaChon <= 7) {
                System.out.println("\nNhan Enter de tiep tuc...");
                try {
                    sc.nextLine();
                } catch (Exception e) {
                    // Ignore
                }
            }

        } while (luaChon != 0);

        sc.close();
    }

    // Menu con cho quản lý nhân sự
    private static void menuNhanSu() {
        int luaChon;

        do {
            System.out.println("\n╔════════════════════════════════════════════╗");
            System.out.println("║           QUAN LY NHAN SU                  ║");
            System.out.println("╠════════════════════════════════════════════╣");
            System.out.println("║  1. Them nhan su moi                       ║");
            System.out.println("║  2. Sua thong tin nhan su                  ║");
            System.out.println("║  3. Xoa nhan su                            ║");
            System.out.println("║  4. Hien thi danh sach nhan su             ║");
            System.out.println("║  5. Tim kiem nhan su                       ║");
            System.out.println("║  6. Sap xep theo luong                     ║");
            System.out.println("║  0. Quay lai menu chinh                    ║");
            System.out.println("╚════════════════════════════════════════════╝");
            System.out.print("Nhap lua chon cua ban: ");

            try {
                luaChon = sc.nextInt();
                sc.nextLine(); // Clear buffer
            } catch (Exception e) {
                System.out.println("Loi: Vui long nhap so!");
                sc.nextLine(); // Clear invalid input
                luaChon = -1;
                continue;
            }

            switch (luaChon) {
                case 1:
                    qlns.themNhieu();
                    break;
                case 2:
                    qlns.sua();
                    break;
                case 3:
                    qlns.xoa();
                    break;
                case 4:
                    qlns.hienThi();
                    break;
                case 5:
                    qlns.timKiem();
                    break;
                case 6:
                    qlns.sapXepTheoLuong();
                    System.out.println("\nHien thi danh sach sau khi sap xep:");
                    qlns.hienThi();
                    break;
                case 0:
                    System.out.println("Quay lai menu chinh...");
                    break;
                default:
                    System.out.println("Lua chon khong hop le! Vui long chon tu 0-6.");
            }

            // Tạm dừng để người dùng đọc kết quả
            if (luaChon != 0 && luaChon >= 1 && luaChon <= 6) {
                System.out.println("\nNhan Enter de tiep tuc...");
                try {
                    sc.nextLine();
                } catch (Exception e) {
                    // Ignore
                }
            }

        } while (luaChon != 0);
    }

    // Menu con cho quản lý hợp đồng
    private static void menuHopDong() {
        int luaChon;

        do {
            System.out.println("\n╔════════════════════════════════════════════╗");
            System.out.println("║           QUAN LY HOP DONG                 ║");
            System.out.println("╠════════════════════════════════════════════╣");
            System.out.println("║  1. Them hop dong cho nhan su              ║");
            System.out.println("║  2. Sua hop dong                           ║");
            System.out.println("║  3. Xoa hop dong                           ║");
            System.out.println("║  4. Hien thi hop dong cua nhan su          ║");
            System.out.println("║  5. Hien thi tat ca hop dong               ║");
            System.out.println("║  6. Tim kiem hop dong                      ║");
            System.out.println("║  0. Quay lai menu chinh                    ║");
            System.out.println("╚════════════════════════════════════════════╝");
            System.out.print("Nhap lua chon cua ban: ");

            try {
                luaChon = sc.nextInt();
                sc.nextLine(); // Clear buffer
            } catch (Exception e) {
                System.out.println("Loi: Vui long nhap so!");
                sc.nextLine(); // Clear invalid input
                luaChon = -1;
                continue;
            }

            switch (luaChon) {
                case 1:
                    qlns.themHopDong();
                    break;
                case 2:
                    qlns.suaHopDong();
                    break;
                case 3:
                    qlns.xoaHopDong();
                    break;
                case 4:
                    qlns.hienThiHopDongCuaNhanSu();
                    break;
                case 5:
                    qlns.hienThiTatCaHopDong();
                    break;
                case 6:
                    qlns.timKiemHopDong();
                    break;
                case 0:
                    System.out.println("Quay lai menu chinh...");
                    break;
                default:
                    System.out.println("Lua chon khong hop le! Vui long chon tu 0-6.");
            }

            // Tạm dừng để người dùng đọc kết quả
            if (luaChon != 0 && luaChon >= 1 && luaChon <= 6) {
                System.out.println("\nNhan Enter de tiep tuc...");
                try {
                    sc.nextLine();
                } catch (Exception e) {
                    // Ignore
                }
            }

        } while (luaChon != 0);
    }

    // Menu con cho quản lý bảng lương
    private static void menuBangLuong() {
        int luaChon;

        do {
            System.out.println("\n╔════════════════════════════════════════════╗");
            System.out.println("║          QUAN LY BANG LUONG                ║");
            System.out.println("╠════════════════════════════════════════════╣");
            System.out.println("║  1. Them bang luong                        ║");
            System.out.println("║  2. Hien thi bang luong cua nhan su        ║");
            System.out.println("║  3. Hien thi tat ca bang luong             ║");
            System.out.println("║  4. Tim kiem bang luong                    ║");
            System.out.println("║  5. Xoa bang luong                         ║");
            System.out.println("║  0. Quay lai menu chinh                    ║");
            System.out.println("╚════════════════════════════════════════════╝");
            System.out.print("Nhap lua chon cua ban: ");

            try {
                luaChon = sc.nextInt();
                sc.nextLine(); // Clear buffer
            } catch (Exception e) {
                System.out.println("Loi: Vui long nhap so!");
                sc.nextLine(); // Clear invalid input
                luaChon = -1;
                continue;
            }

            switch (luaChon) {
                case 1:
                    qlns.themBangLuong();
                    break;
                case 2:
                    qlns.hienThiBangLuongCuaNhanSu();
                    break;
                case 3:
                    qlns.hienThiTatCaBangLuong();
                    break;
                case 4:
                    qlns.timKiemBangLuong();
                    break;
                case 5:
                    qlns.xoaBangLuong();
                    break;
                case 0:
                    System.out.println("Quay lai menu chinh...");
                    break;
                default:
                    System.out.println("Lua chon khong hop le! Vui long chon tu 0-5.");
            }

            // Tạm dừng để người dùng đọc kết quả
            if (luaChon != 0 && luaChon >= 1 && luaChon <= 5) {
                System.out.println("\nNhan Enter de tiep tuc...");
                try {
                    sc.nextLine();
                } catch (Exception e) {
                    // Ignore
                }
            }

        } while (luaChon != 0);
    }

    // Menu con cho thống kê
    private static void menuThongKe() {
        int luaChon;

        do {
            System.out.println("\n╔════════════════════════════════════════════╗");
            System.out.println("║              THONG KE                      ║");
            System.out.println("╠════════════════════════════════════════════╣");
            System.out.println("║  1. Thong ke nhan su                       ║");
            System.out.println("║  2. Thong ke hop dong                      ║");
            System.out.println("║  3. Thong ke bang luong                    ║");
            System.out.println("║  4. Thong ke du an                         ║");
            System.out.println("║  0. Quay lai menu chinh                    ║");
            System.out.println("╚════════════════════════════════════════════╝");
            System.out.print("Nhap lua chon cua ban: ");

            try {
                luaChon = sc.nextInt();
                sc.nextLine(); // Clear buffer
            } catch (Exception e) {
                System.out.println("Loi: Vui long nhap so!");
                sc.nextLine(); // Clear invalid input
                luaChon = -1;
                continue;
            }

            switch (luaChon) {
                case 1:
                    qlns.thongKe();
                    break;
                case 2:
                    qlns.thongKeHopDong();
                    break;
                case 3:
                    qlns.thongKeBangLuong();
                    break;
                case 4:
                    qlns.thongKeDuAn();
                    break;
                case 0:
                    System.out.println("Quay lai menu chinh...");
                    break;
                default:
                    System.out.println("Lua chon khong hop le! Vui long chon tu 0-4.");
            }

            // Tạm dừng để người dùng đọc kết quả
            if (luaChon != 0 && luaChon >= 1 && luaChon <= 4) {
                System.out.println("\nNhan Enter de tiep tuc...");
                try {
                    sc.nextLine();
                } catch (Exception e) {
                    // Ignore
                }
            }

        } while (luaChon != 0);
    }

    // Menu con cho quản lý dự án
    private static void menuDuAn() {
        int luaChon;

        do {
            System.out.println("\n╔════════════════════════════════════════════╗");
            System.out.println("║            QUAN LY DU AN                   ║");
            System.out.println("╠════════════════════════════════════════════╣");
            System.out.println("║  1. Them du an                             ║");
            System.out.println("║  2. Sua du an                              ║");
            System.out.println("║  3. Xoa du an                              ║");
            System.out.println("║  4. Hien thi du an cua nhan su             ║");
            System.out.println("║  5. Hien thi tat ca du an                  ║");
            System.out.println("║  6. Tim kiem du an                         ║");
            System.out.println("║  0. Quay lai menu chinh                    ║");
            System.out.println("╚════════════════════════════════════════════╝");
            System.out.print("Nhap lua chon cua ban: ");

            try {
                luaChon = sc.nextInt();
                sc.nextLine(); // Clear buffer
            } catch (Exception e) {
                System.out.println("Loi: Vui long nhap so!");
                sc.nextLine(); // Clear invalid input
                luaChon = -1;
                continue;
            }

            switch (luaChon) {
                case 1:
                    qlns.themDuAn();
                    break;
                case 2:
                    qlns.suaDuAn();
                    break;
                case 3:
                    qlns.xoaDuAn();
                    break;
                case 4:
                    qlns.hienThiDuAnCuaNhanSu();
                    break;
                case 5:
                    qlns.hienThiTatCaDuAn();
                    break;
                case 6:
                    qlns.timKiemDuAn();
                    break;
                case 0:
                    System.out.println("Quay lai menu chinh...");
                    break;
                default:
                    System.out.println("Lua chon khong hop le! Vui long chon tu 0-6.");
            }

            // Tạm dừng để người dùng đọc kết quả
            if (luaChon != 0 && luaChon >= 1 && luaChon <= 6) {
                System.out.println("\nNhan Enter de tiep tuc...");
                try {
                    sc.nextLine();
                } catch (Exception e) {
                    // Ignore
                }
            }

        } while (luaChon != 0);
    }
}

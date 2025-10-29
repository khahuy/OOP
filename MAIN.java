import java.util.Scanner;

public class MAIN {
    // Hàm main để chạy chương trình
    public static void main(String[] args) {
        QUANLYNHANSU qlns = new QUANLYNHANSU();
        Scanner sc = new Scanner(System.in);
        int luaChon;

        System.out.println("╔═══════════════════════════════════════════════╗");
        System.out.println("║   CHAO MUNG DEN HE THONG QUAN LY NHAN SU    ║");
        System.out.println("╚═══════════════════════════════════════════════╝\n");

        do {
            System.out.println("\n╔════════════════════════════════════════════╗");
            System.out.println("║        HE THONG QUAN LY NHAN SU           ║");
            System.out.println("╠════════════════════════════════════════════╣");
            System.out.println("║  1. Them nhan su moi                       ║");
            System.out.println("║  2. Sua thong tin nhan su                  ║");
            System.out.println("║  3. Xoa nhan su                            ║");
            System.out.println("║  4. Hien thi danh sach nhan su             ║");
            System.out.println("║  5. Tim kiem nhan su                       ║");
            System.out.println("║  6. Thong ke nhan su                       ║");
            System.out.println("║  7. Sap xep theo luong                     ║");
            System.out.println("║  8. Ghi danh sach ra file                  ║");
            System.out.println("║  9. Doc file danh sach                     ║");
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
                    qlns.them();
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
                    qlns.thongKe();
                    break;
                case 7:
                    qlns.sapXepTheoLuong();
                    System.out.println("\nHien thi danh sach sau khi sap xep:");
                    qlns.hienThi();
                    break;
                case 8:
                    qlns.ghiFile();
                    break;
                case 9:
                    qlns.docFile();
                    break;
                case 0:
                    System.out.println("\n╔═══════════════════════════════════════════════╗");
                    System.out.println("║  CAM ON BAN DA SU DUNG CHUONG TRINH!        ║");
                    System.out.println("║           HẸN GẶP LẠI!                        ║");
                    System.out.println("╚═══════════════════════════════════════════════╝");
                    break;
                default:
                    System.out.println("Lua chon khong hop le! Vui long chon tu 0-9.");
            }

            // Tạm dừng để người dùng đọc kết quả
            if (luaChon != 0 && luaChon >= 1 && luaChon <= 9) {
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
}

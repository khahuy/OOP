import java.util.Scanner;

public class MAIN {
    // Hàm main để chạy chương trình
    public static void main(String[] args) {
        QUANLYNHANSU qlns = new QUANLYNHANSU();
        Scanner sc = new Scanner(System.in);
        int luaChon;

        System.out.println("╔═══════════════════════════════════════════════╗");
        System.out.println("║   CHÀO MỪNG ĐÉN HỆ THỐNG QUẢN LÝ NHÂN SỰ    ║");
        System.out.println("╚═══════════════════════════════════════════════╝\n");

        do {
            System.out.println("\n╔════════════════════════════════════════════╗");
            System.out.println("║        HỆ THỐNG QUẢN LÝ NHÂN SỰ           ║");
            System.out.println("╠════════════════════════════════════════════╣");
            System.out.println("║  1. Thêm nhân sự mới                       ║");
            System.out.println("║  2. Sửa thông tin nhân sự                  ║");
            System.out.println("║  3. Xóa nhân sự                            ║");
            System.out.println("║  4. Hiển thị danh sách nhân sự             ║");
            System.out.println("║  5. Tìm kiếm nhân sự                       ║");
            System.out.println("║  6. Thống kê nhân sự                       ║");
            System.out.println("║  7. Sắp xếp theo lương                     ║");
            System.out.println("║  8. Ghi danh sách ra file                  ║");
            System.out.println("║  9. Đọc file danh sách                     ║");
            System.out.println("║  0. Thoát chương trình                     ║");
            System.out.println("╚════════════════════════════════════════════╝");
            System.out.print("👉 Nhập lựa chọn của bạn: ");

            try {
                luaChon = sc.nextInt();
                sc.nextLine(); // Clear buffer
            } catch (Exception e) {
                System.out.println("❌ Lỗi: Vui lòng nhập số!");
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
                    System.out.println("\n📊 Hiển thị danh sách sau khi sắp xếp:");
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
                    System.out.println("║  CảM ƠN BẠN ĐÃ SỬ DỤNG CHƯƠNG TRÌNH!        ║");
                    System.out.println("║           HẸN GẶP LẠI!                        ║");
                    System.out.println("╚═══════════════════════════════════════════════╝");
                    break;
                default:
                    System.out.println("❌ Lựa chọn không hợp lệ! Vui lòng chọn từ 0-9.");
            }

            // Tạm dừng để người dùng đọc kết quả
            if (luaChon != 0 && luaChon >= 1 && luaChon <= 9) {
                System.out.println("\n⏸️  Nhấn Enter để tiếp tục...");
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

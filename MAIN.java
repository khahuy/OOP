import java.util.Scanner;

public class MAIN {
    public static void main(String[] args) {
        QUANLYNHANSU ql = new QUANLYNHANSU();
        Scanner sc = new Scanner(System.in);
        int chon;

        do {
            System.out.println("\n=== MENU QUẢN LÝ NHÂN SỰ ===");
            System.out.println("1. Thêm nhân sự");
            System.out.println("2. Hiển thị danh sách");
            System.out.println("3. Xóa nhân sự");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");
            chon = Integer.parseInt(sc.nextLine());

            switch (chon) {
                case 1 -> ql.them();
                case 2 -> ql.hienThi();
                case 3 -> ql.xoa();
                case 0 -> System.out.println("Kết thúc chương trình.");
                default -> System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (chon != 0);
    }
}

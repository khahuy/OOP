import java.io.*;
import java.util.Scanner;

public class QUANLYNHANSU implements ICHUCNANG, IFILE {
    private NHANSU[] danhSachNhanSu;
    private int soLuongNhanSu;
    private static final int MAX_NHANSU = 100;
    private Scanner sc;

    // Constructor
    public QUANLYNHANSU() {
        danhSachNhanSu = new NHANSU[MAX_NHANSU];
        soLuongNhanSu = 0;
        sc = new Scanner(System.in);
    }

    // Getter cho danh sách nhân sự
    public NHANSU[] getDanhSachNhanSu() {
        return danhSachNhanSu;
    }

    // Getter cho số lượng nhân sự1
    public int getSoLuongNhanSu() {
        return soLuongNhanSu;
    }

    @Override
    public void them() {
        if (soLuongNhanSu >= MAX_NHANSU) {
            System.out.println("Danh sách nhân sự đã đầy!");
            return;
        }

        System.out.println("\n=== THÊM NHÂN SỰ MỚI ===");
        System.out.println("Chọn loại nhân sự:");
        System.out.println("1. Nhân viên kỹ thuật");
        System.out.println("2. Nhân viên hành chính");
        System.out.println("3. Nhân viên quản lý");
        System.out.print("Lựa chọn: ");

        int loai;
        try {
            loai = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("❌ Lỗi: Vui lòng nhập số!");
            return;
        }

        System.out.print("Mã nhân sự: ");
        String maNhanSu = sc.nextLine();

        // Kiểm tra trùng mã
        if (timKiemTheoMa(maNhanSu) != null) {
            System.out.println("Mã nhân sự đã tồn tại!");
            return;
        }

        System.out.print("Họ tên: ");
        String hoTen = sc.nextLine();
        System.out.print("Giới tính: ");
        String gioiTinh = sc.nextLine();
        System.out.print("Địa chỉ: ");
        String diaChi = sc.nextLine();
        System.out.print("Số điện thoại: ");
        String soDienThoai = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();

        double luongCoBan, heSoLuong;
        try {
            System.out.print("Lương cơ bản: ");
            luongCoBan = Double.parseDouble(sc.nextLine());
            System.out.print("Hệ số lương: ");
            heSoLuong = Double.parseDouble(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("❌ Lỗi: Lương và hệ số phải là số!");
            return;
        }

        NHANSU nhanSu = null;

        try {
            switch (loai) {
                case 1:
                    System.out.print("Số giờ làm thêm: ");
                    double soGioLamThem = Double.parseDouble(sc.nextLine());
                    System.out.print("Đơn giá giờ làm thêm: ");
                    double donGiaGioLamThem = Double.parseDouble(sc.nextLine());
                    nhanSu = new NHANVIENKYTHUAT(maNhanSu, hoTen, gioiTinh, diaChi, soDienThoai, email, luongCoBan,
                            heSoLuong, soGioLamThem, donGiaGioLamThem);
                    break;
                case 2:
                    nhanSu = new NHANVIENHANHCHINH(maNhanSu, hoTen, gioiTinh, diaChi, soDienThoai, email, luongCoBan,
                            heSoLuong);
                    break;
                case 3:
                    System.out.print("Phụ cấp: ");
                    double phuCap = Double.parseDouble(sc.nextLine());
                    System.out.print("Số lượng nhân viên quản lý: ");
                    int soQuanLy = Integer.parseInt(sc.nextLine());
                    nhanSu = new NHANVIENQUANLY(maNhanSu, hoTen, gioiTinh, diaChi, soDienThoai, email, luongCoBan,
                            heSoLuong, phuCap, soQuanLy);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
                    return;
            }
        } catch (NumberFormatException e) {
            System.out.println("❌ Lỗi: Giá trị nhập vào không hợp lệ!");
            return;
        }

        danhSachNhanSu[soLuongNhanSu] = nhanSu;
        soLuongNhanSu++;
        System.out.println("✅ Thêm nhân sự thành công!");
    }

    @Override
    public void sua() {
        System.out.print("\nNhập mã nhân sú cần sửa: ");
        String maNhanSu = sc.nextLine();

        NHANSU nhanSu = timKiemTheoMa(maNhanSu);
        if (nhanSu == null) {
            System.out.println("Không tìm thấy nhân sự!");
            return;
        }

        System.out.println("\n=== SỬA THÔNG TIN NHÂN SỰ ===");
        System.out.print("Họ tên mới (Enter để giữ nguyên): ");
        String hoTen = sc.nextLine();
        if (!hoTen.isEmpty()) {
            nhanSu.setHoTen(hoTen);
        }

        System.out.print("Giới tính mới (Enter để giữ nguyên): ");
        String gioiTinh = sc.nextLine();
        if (!gioiTinh.isEmpty()) {
            nhanSu.setGioiTinh(gioiTinh);
        }

        System.out.print("Địa chỉ mới (Enter để giữ nguyên): ");
        String diaChi = sc.nextLine();
        if (!diaChi.isEmpty()) {
            nhanSu.setDiaChi(diaChi);
        }

        System.out.print("Số điện thoại mới (Enter để giữ nguyên): ");
        String soDienThoai = sc.nextLine();
        if (!soDienThoai.isEmpty()) {
            nhanSu.setSoDienThoai(soDienThoai);
        }

        System.out.print("Email mới (Enter để giữ nguyên): ");
        String email = sc.nextLine();
        if (!email.isEmpty()) {
            nhanSu.setEmail(email);
        }

        try {
            System.out.print("Lương cơ bản mới (Enter để giữ nguyên): ");
            String luongStr = sc.nextLine();
            if (!luongStr.isEmpty()) {
                double luongCoBan = Double.parseDouble(luongStr);
                nhanSu.setLuongCoBan(luongCoBan);
            }

            System.out.print("Hệ số lương mới (Enter để giữ nguyên): ");
            String heSoStr = sc.nextLine();
            if (!heSoStr.isEmpty()) {
                double heSoLuong = Double.parseDouble(heSoStr);
                nhanSu.setHeSoLuong(heSoLuong);
            }
        } catch (NumberFormatException e) {
            System.out.println("❌ Lỗi: Giá trị không hợp lệ!");
            return;
        }

        System.out.println("✅ Cập nhật thông tin thành công!");
    }

    @Override
    public void xoa() {
        System.out.print("\nNhập mã nhân sự cần xóa: ");
        String maNhanSu = sc.nextLine();

        int viTri = -1;
        for (int i = 0; i < soLuongNhanSu; i++) {
            if (danhSachNhanSu[i].getMaNhanSu().equalsIgnoreCase(maNhanSu)) {
                viTri = i;
                break;
            }
        }

        if (viTri == -1) {
            System.out.println("Không tìm thấy nhân sự!");
            return;
        }

        System.out.print("Bạn có chắc chắn muốn xóa? (Y/N): ");
        String xacNhan = sc.nextLine();
        if (!xacNhan.equalsIgnoreCase("Y")) {
            System.out.println("Đã hủy thao tác xóa!");
            return;
        }

        // Dịch chuyển các phần tử về trước
        for (int i = viTri; i < soLuongNhanSu - 1; i++) {
            danhSachNhanSu[i] = danhSachNhanSu[i + 1];
        }
        danhSachNhanSu[soLuongNhanSu - 1] = null;
        soLuongNhanSu--;

        System.out.println("Xóa nhân sự thành công!");
    }

    @Override
    public void hienThi() {
        if (soLuongNhanSu == 0) {
            System.out.println("\nDanh sách nhân sự trống!");
            return;
        }

        System.out.println("\n=== DANH SÁCH NHÂN SỰ ===");
        System.out.println("Tổng số: " + soLuongNhanSu + " nhân sự");
        System.out.println("----------------------------------------");

        for (int i = 0; i < soLuongNhanSu; i++) {
            System.out.println("\nNhân sự " + (i + 1) + ":");
            danhSachNhanSu[i].hienThiThongTin();
            System.out.println("Loại nhân sự: " + danhSachNhanSu[i].getLoaiNhanSu());
            System.out.println("Lương: " + danhSachNhanSu[i].tinhLuong());
            System.out.println("----------------------------------------");
        }
    }

    @Override
    public void timKiem() {
        System.out.println("\n=== TÌM KIẾM NHÂN SỰ ===");
        System.out.println("1. Tìm theo mã nhân sự");
        System.out.println("2. Tìm theo tên");
        System.out.println("3. Tìm theo loại nhân sự");
        System.out.print("Lựa chọn: ");

        int luaChon;
        try {
            luaChon = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("❌ Lỗi: Vui lòng nhập số!");
            return;
        }

        switch (luaChon) {
            case 1:
                timKiemTheoMaNS();
                break;
            case 2:
                timKiemTheoTen();
                break;
            case 3:
                timKiemTheoLoai();
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ!");
        }
    }

    // Tìm kiếm theo mã (trả về đối tượng)
    private NHANSU timKiemTheoMa(String maNhanSu) {
        for (int i = 0; i < soLuongNhanSu; i++) {
            if (danhSachNhanSu[i].getMaNhanSu().equalsIgnoreCase(maNhanSu)) {
                return danhSachNhanSu[i];
            }
        }
        return null;
    }

    // Tìm kiếm theo mã nhân sự (hiển thị)
    private void timKiemTheoMaNS() {
        System.out.print("Nhập mã nhân sự: ");
        String maNhanSu = sc.nextLine();

        NHANSU nhanSu = timKiemTheoMa(maNhanSu);
        if (nhanSu != null) {
            System.out.println("\nThông tin nhân sự:");
            nhanSu.hienThiThongTin();
            System.out.println("Loại nhân sự: " + nhanSu.getLoaiNhanSu());
            System.out.println("Lương: " + nhanSu.tinhLuong());
        } else {
            System.out.println("Không tìm thấy nhân sự!");
        }
    }

    // Tìm kiếm theo tên
    private void timKiemTheoTen() {
        System.out.print("Nhập tên cần tìm: ");
        String ten = sc.nextLine();

        boolean timThay = false;
        System.out.println("\nKết quả tìm kiếm:");

        for (int i = 0; i < soLuongNhanSu; i++) {
            if (danhSachNhanSu[i].getHoTen().toLowerCase().contains(ten.toLowerCase())) {
                System.out.println("\nNhân sự " + (i + 1) + ":");
                danhSachNhanSu[i].hienThiThongTin();
                System.out.println("Loại nhân sự: " + danhSachNhanSu[i].getLoaiNhanSu());
                timThay = true;
            }
        }

        if (!timThay) {
            System.out.println("Không tìm thấy nhân sự nào!");
        }
    }

    // Tìm kiếm theo loại nhân sự
    private void timKiemTheoLoai() {
        System.out.println("Chọn loại nhân sự:");
        System.out.println("1. Nhân viên kỹ thuật");
        System.out.println("2. Nhân viên hành chính");
        System.out.println("3. Nhân viên quản lý");
        System.out.print("Lựa chọn: ");

        int loai;
        try {
            loai = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("❌ Lỗi: Vui lòng nhập số!");
            return;
        }

        String loaiNhanSu = "";
        switch (loai) {
            case 1:
                loaiNhanSu = "Kỹ Thuật";
                break;
            case 2:
                loaiNhanSu = "Hành Chính";
                break;
            case 3:
                loaiNhanSu = "Quản Lý";
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ!");
                return;
        }

        boolean timThay = false;
        System.out.println("\nDanh sách " + loaiNhanSu + ":");

        for (int i = 0; i < soLuongNhanSu; i++) {
            if (danhSachNhanSu[i].getLoaiNhanSu().equals(loaiNhanSu)) {
                System.out.println("\nNhân sự " + (i + 1) + ":");
                danhSachNhanSu[i].hienThiThongTin();
                timThay = true;
            }
        }

        if (!timThay) {
            System.out.println("Không tìm thấy nhân sự nào!");
        }
    }

    @Override
    public void ghiFile() {
        try {
            FileWriter fw = new FileWriter("danhsachnhansu.txt");
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write("Tổng số nhân sự: " + soLuongNhanSu + "\n");
            bw.write("========================================\n");

            for (int i = 0; i < soLuongNhanSu; i++) {
                NHANSU ns = danhSachNhanSu[i];
                bw.write("Mã: " + ns.getMaNhanSu() + "\n");
                bw.write("Họ tên: " + ns.getHoTen() + "\n");
                bw.write("Giới tính: " + ns.getGioiTinh() + "\n");
                bw.write("Địa chỉ: " + ns.getDiaChi() + "\n");
                bw.write("SĐT: " + ns.getSoDienThoai() + "\n");
                bw.write("Email: " + ns.getEmail() + "\n");
                bw.write("Lương cơ bản: " + ns.getLuongCoBan() + "\n");
                bw.write("Hệ số lương: " + ns.getHeSoLuong() + "\n");
                bw.write("Loại: " + ns.getLoaiNhanSu() + "\n");
                bw.write("Lương: " + ns.tinhLuong() + "\n");
                bw.write("----------------------------------------\n");
            }

            bw.close();
            fw.close();
            System.out.println("Ghi file thành công!");
        } catch (IOException e) {
            System.out.println("Lỗi ghi file: " + e.getMessage());
        }
    }

    @Override
    public void docFile() {
        try {
            FileReader fr = new FileReader("danhsachnhansu.txt");
            BufferedReader br = new BufferedReader(fr);

            String line;
            System.out.println("\n=== NỘI DUNG FILE ===");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
            System.out.println("Không tìm thấy file!");
        } catch (IOException e) {
            System.out.println("Lỗi đọc file: " + e.getMessage());
        }
    }

    // Thống kê số lượng nhân sự theo loại
    public void thongKe() {
        int soKyThuat = 0, soHanhChinh = 0, soQuanLy = 0;

        for (int i = 0; i < soLuongNhanSu; i++) {
            String loai = danhSachNhanSu[i].getLoaiNhanSu();
            if (loai.equals("Nhân viên kỹ thuật")) {
                soKyThuat++;
            } else if (loai.equals("Nhân viên hành chính")) {
                soHanhChinh++;
            } else if (loai.equals("Nhân viên quản lý")) {
                soQuanLy++;
            }
        }

        System.out.println("\n=== THỐNG KÊ NHÂN SỰ ===");
        System.out.println("Tổng số nhân sự: " + soLuongNhanSu);
        System.out.println("Nhân viên kỹ thuật: " + soKyThuat);
        System.out.println("Nhân viên hành chính: " + soHanhChinh);
        System.out.println("Nhân viên quản lý: " + soQuanLy);
    }

    // Sắp xếp theo lương
    public void sapXepTheoLuong() {
        for (int i = 0; i < soLuongNhanSu - 1; i++) {
            for (int j = i + 1; j < soLuongNhanSu; j++) {
                if (danhSachNhanSu[i].tinhLuong() > danhSachNhanSu[j].tinhLuong()) {
                    NHANSU temp = danhSachNhanSu[i];
                    danhSachNhanSu[i] = danhSachNhanSu[j];
                    danhSachNhanSu[j] = temp;
                }
            }
        }
        System.out.println("Đã sắp xếp theo lương tăng dần!");
    }

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

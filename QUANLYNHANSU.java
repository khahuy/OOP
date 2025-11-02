import java.io.*;
import java.util.Scanner;

public class QUANLYNHANSU implements ICHUCNANG, IFILE {
    private NHANSU[] danhSachNhanSu;
    private int soLuongNhanSu;
    private static final int MAX_NHANSU = 100;
    private BANGLUONG[] danhSachBangLuong;
    private int soLuongBangLuong;
    private static final int MAX_BANGLUONG = 100;
    private DUAN[] danhSachDuAn;
    private int soLuongDuAn;
    private static final int MAX_DUAN = 100;
    private Scanner sc;

    // Constructor
    public QUANLYNHANSU() {
        danhSachNhanSu = new NHANSU[MAX_NHANSU];
        soLuongNhanSu = 0;
        danhSachBangLuong = new BANGLUONG[MAX_BANGLUONG];
        soLuongBangLuong = 0;
        danhSachDuAn = new DUAN[MAX_DUAN];
        soLuongDuAn = 0;
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

    public BANGLUONG[] getDanhSachBangLuong() {
        return danhSachBangLuong;
    }

    public int getSoLuongBangLuong() {
        return soLuongBangLuong;
    }

    // Phương thức helper để nhập giới tính hợp lệ
    private String nhapGioiTinh(boolean choPhepBoQua) {
        while (true) {
            String prompt = choPhepBoQua ? "Gioi tinh moi (Nam/Nu, Enter de giu nguyen): " : "Gioi tinh (Nam/Nu): ";
            System.out.print(prompt);
            String gioiTinh = sc.nextLine().trim();

            if (choPhepBoQua && gioiTinh.isEmpty()) {
                return null; // Giữ nguyên
            }

            if (gioiTinh.equalsIgnoreCase("Nam") || gioiTinh.equalsIgnoreCase("Nu")) {
                return gioiTinh.substring(0, 1).toUpperCase() + gioiTinh.substring(1).toLowerCase();
            }

            System.out.println("Loi: Gioi tinh chi duoc nhap 'Nam' hoac 'Nu'!");
        }
    }

    // Helper method để cắt chuỗi nếu quá dài
    private String truncate(String str, int maxLength) {
        if (str == null) {
            return "";
        }
        if (str.length() <= maxLength) {
            return str;
        }
        return str.substring(0, maxLength - 3) + "...";
    }

    @Override
    public void them() {
        if (soLuongNhanSu >= MAX_NHANSU) {
            System.out.println("Danh sach nhan su da day!");
            return;
        }

        System.out.println("\n=== THEM NHAN SU MOI ===");
        System.out.println("Chon loai nhan su:");
        System.out.println("1. Nhan vien ky thuat");
        System.out.println("2. Nhan vien hanh chinh");
        System.out.println("3. Nhan vien quan ly");
        System.out.print("Lua chon: ");

        int loai;
        try {
            loai = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println(" Loi: Vui long nhap so!");
            return;
        }

        System.out.print("Ma nhan su: ");
        String maNhanSu = sc.nextLine();

        // Kiểm tra trùng mã
        if (timKiemTheoMa(maNhanSu) != null) {
            System.out.println("Ma nhan su đa ton tai!");
            return;
        }

        System.out.print("Ho ten: ");
        String hoTen = sc.nextLine();
        String gioiTinh;
        do {
            System.out.print("Gioi tinh (Nam/Nu):");
            gioiTinh = sc.nextLine().trim().toLowerCase();
            if (!gioiTinh.equals("nam") && !gioiTinh.equals("nu")) {
                System.out.println(" Loi: Vui long nhap gioi tinh hop le (Nam/Nu)!");
            }
        } while (!gioiTinh.equals("nam") && !gioiTinh.equals("nu"));

        System.out.print("Dia chi: ");
        String diaChi = sc.nextLine();
        String soDienThoai;
        do {
            System.out.print("Nhap so dien thoai:");
            soDienThoai = sc.nextLine();
            if (!soDienThoai.matches("0\\d{9}")) {
                System.out.println(" Vui long nhap so dien thoai hop le (10 chu so)!");
            }
        } while (!soDienThoai.matches("0\\d{9}"));

        System.out.print("Email: ");
        String email = sc.nextLine();

        System.out.println("\nChon phong ban:");
        System.out.println("1. IT");
        System.out.println("2. Marketing");
        System.out.println("3. Kinh doanh");
        System.out.println("4. Phan mem");
        System.out.println("5. Ke toan");

        int loaiPhongBan = 0;
        String tenPhongBan = "";
        String maPhongBan = "";

        // Bắt buộc phải chọn phòng ban hợp lệ (1-5)
        do {
            System.out.print("Lua chon phong ban (1-5): ");
            try {
                loaiPhongBan = Integer.parseInt(sc.nextLine());
                if (loaiPhongBan < 1 || loaiPhongBan > 5) {
                    System.out.println("Loi: Vui long chon tu 1 den 5!");
                    loaiPhongBan = 0; // Reset để lặp lại
                    continue;
                }

                // Gán mã và tên phòng ban
                switch (loaiPhongBan) {
                    case 1:
                        maPhongBan = "PB01";
                        tenPhongBan = "IT";
                        break;
                    case 2:
                        maPhongBan = "PB02";
                        tenPhongBan = "Marketing";
                        break;
                    case 3:
                        maPhongBan = "PB03";
                        tenPhongBan = "Kinh doanh";
                        break;
                    case 4:
                        maPhongBan = "PB04";
                        tenPhongBan = "Phan mem";
                        break;
                    case 5:
                        maPhongBan = "PB05";
                        tenPhongBan = "Ke toan";
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Loi: Vui long nhap so!");
                loaiPhongBan = 0; // Reset để lặp lại
            }
        } while (loaiPhongBan == 0);

        double luongCoBan, heSoLuong;
        do {
            System.out.print("luong co ban:");
            String luongStr = sc.nextLine();
            try {
                luongCoBan = Double.parseDouble(luongStr);
                if (luongCoBan <= 0) {
                    System.out.println(" Luong co ban phai lon hon 0!");
                } else {
                    break;

                }
            } catch (NumberFormatException e) {
                System.out.println(" Loi: Vui long nhap so hop le!");
                luongCoBan = -1; // Đặt giá trị không hợp lệ để lặp lại
            }
        } while (true);

        do {
            System.out.print("he so luong:");
            String heSoStr = sc.nextLine();
            try {
                heSoLuong = Double.parseDouble(heSoStr);
                if (heSoLuong <= 0) {
                    System.out.println(" He so luong phai lon hon 0!");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println(" Loi: Vui long nhap so hop le!");
                heSoLuong = -1; // Đặt giá trị không hợp lệ để lặp lại
            }
        } while (true);

        NHANSU nhanSu = null;

        switch (loai) {
            case 1:
                double soGioLamThem;
                do {
                    System.out.print("So gio lam them: ");
                    try {
                        soGioLamThem = Double.parseDouble(sc.nextLine());
                        if (soGioLamThem < 0) {
                            System.out.println("Loi: So gio lam them khong duoc am!");
                        } else {
                            break;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Loi: Vui long nhap so hop le!");
                        soGioLamThem = -1;
                    }
                } while (true);

                double donGiaGioLamThem;
                do {
                    System.out.print("Don gia gio lam them: ");
                    try {
                        donGiaGioLamThem = Double.parseDouble(sc.nextLine());
                        if (donGiaGioLamThem < 0) {
                            System.out.println("Loi: Don gia khong duoc am!");
                        } else {
                            break;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Loi: Vui long nhap so hop le!");
                        donGiaGioLamThem = -1;
                    }
                } while (true);

                nhanSu = new NHANVIENKYTHUAT(maNhanSu, hoTen, gioiTinh, diaChi, soDienThoai, email, luongCoBan,
                        heSoLuong, soGioLamThem, donGiaGioLamThem);
                break;
            case 2:
                nhanSu = new NHANVIENHANHCHINH(maNhanSu, hoTen, gioiTinh, diaChi, soDienThoai, email, luongCoBan,
                        heSoLuong);
                break;
            case 3:
                double phuCap;
                do {
                    System.out.print("Phu cap: ");
                    try {
                        phuCap = Double.parseDouble(sc.nextLine());
                        if (phuCap < 0) {
                            System.out.println("Loi: Phu cap khong duoc am!");
                        } else {
                            break;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Loi: Vui long nhap so hop le!");
                        phuCap = -1;
                    }
                } while (true);

                nhanSu = new NHANVIENQUANLY(maNhanSu, hoTen, gioiTinh, diaChi, soDienThoai, email, luongCoBan,
                        heSoLuong, phuCap);
                break;
            default:
                System.out.println("Lua chon khong hop le!");
                return;
        }

        // set phong ban cho nhan su (bắt buộc vì đã chọn phòng ban)
        if (nhanSu != null) {
            PHONGBAN pb = new PHONGBAN();
            pb.setMaPhongBan(maPhongBan);
            pb.setTenPhongBan(tenPhongBan);
            nhanSu.setPhongBan(pb);
        }

        danhSachNhanSu[soLuongNhanSu] = nhanSu;
        soLuongNhanSu++;
        System.out.println("Them nhan su thanh cong!");
    }

    @Override
    public void sua() {
        System.out.print("\nNhap ma nhan su can sua: ");
        String maNhanSu = sc.nextLine();

        NHANSU nhanSu = timKiemTheoMa(maNhanSu);
        if (nhanSu == null) {
            System.out.println("Khong tim thay nhan su!");
            return;
        }

        System.out.println("\n=== SUA THONG TIN NHAN SU ===");
        System.out.print("Ho ten moi (Enter de giu nguyen): ");
        String hoTen = sc.nextLine();
        if (!hoTen.isEmpty()) {
            nhanSu.setHoTen(hoTen);
        }

        String gioiTinh = nhapGioiTinh(true);
        if (gioiTinh != null) {
            nhanSu.setGioiTinh(gioiTinh);
        }

        System.out.print("Dia chi moi (Enter de giu nguyen): ");
        String diaChi = sc.nextLine();
        if (!diaChi.isEmpty()) {
            nhanSu.setDiaChi(diaChi);
        }

        // Sửa số điện thoại với validation
        String soDienThoai;
        do {
            System.out.print("So dien thoai moi (Enter de giu nguyen): ");
            soDienThoai = sc.nextLine();

            if (soDienThoai.isEmpty()) {
                break; // Giữ nguyên
            }

            if (soDienThoai.matches("0\\d{9}")) {
                nhanSu.setSoDienThoai(soDienThoai);
                break;
            } else {
                System.out.println("Loi: So dien thoai phai bat dau bang 0 va co 10 chu so!");
            }
        } while (true);

        System.out.print("Email moi (Enter de giu nguyen): ");
        String email = sc.nextLine();
        if (!email.isEmpty()) {
            nhanSu.setEmail(email);
        }

        // Sửa phòng ban
        System.out.print("\nBan co muon thay doi phong ban? (y/n): ");
        String thayDoiPB = sc.nextLine();
        if (thayDoiPB.equalsIgnoreCase("y")) {
            System.out.println("\nChon phong ban moi:");
            System.out.println("1. IT");
            System.out.println("2. Marketing");
            System.out.println("3. Kinh doanh");
            System.out.println("4. Phan mem");
            System.out.println("5. Ke toan");

            int loaiPhongBan = 0;
            String tenPhongBan = "";
            String maPhongBan = "";

            do {
                System.out.print("Lua chon phong ban (1-5): ");
                try {
                    loaiPhongBan = Integer.parseInt(sc.nextLine());
                    if (loaiPhongBan < 1 || loaiPhongBan > 5) {
                        System.out.println("Loi: Vui long chon tu 1 den 5!");
                        loaiPhongBan = 0;
                        continue;
                    }

                    switch (loaiPhongBan) {
                        case 1:
                            maPhongBan = "PB01";
                            tenPhongBan = "IT";
                            break;
                        case 2:
                            maPhongBan = "PB02";
                            tenPhongBan = "Marketing";
                            break;
                        case 3:
                            maPhongBan = "PB03";
                            tenPhongBan = "Kinh doanh";
                            break;
                        case 4:
                            maPhongBan = "PB04";
                            tenPhongBan = "Phan mem";
                            break;
                        case 5:
                            maPhongBan = "PB05";
                            tenPhongBan = "Ke toan";
                            break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Loi: Vui long nhap so!");
                    loaiPhongBan = 0;
                }
            } while (loaiPhongBan == 0);

            // Cập nhật phòng ban mới
            PHONGBAN pb = new PHONGBAN();
            pb.setMaPhongBan(maPhongBan);
            pb.setTenPhongBan(tenPhongBan);
            nhanSu.setPhongBan(pb);
            System.out.println("Da cap nhat phong ban thanh cong!");
        }

        do {
            System.out.print("luong co ban moi (Enter de giu nguyen): ");
            String luongStr = sc.nextLine();
            if (luongStr.isEmpty()) {
                break; // Giữ nguyên
            }
            try {
                double luongCoBan = Double.parseDouble(luongStr);
                if (luongCoBan <= 0) {
                    System.out.println(" Luong co ban phai lon hon 0!");
                } else {
                    nhanSu.setLuongCoBan(luongCoBan);
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println(" Loi: Vui long nhap so hop le!");
            }
        } while (true);

        do {
            System.out.print("he so luong moi (Enter de giu nguyen): ");
            String heSoStr = sc.nextLine();
            if (heSoStr.isEmpty()) {
                break; // Giữ nguyên
            }
            try {
                double heSoLuong = Double.parseDouble(heSoStr);
                if (heSoLuong <= 0) {
                    System.out.println(" He so luong phai lon hon 0!");
                } else {
                    nhanSu.setHeSoLuong(heSoLuong);
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println(" Loi: Vui long nhap so hop le!");
            }
        } while (true);

        System.out.println("Cap nhat thong tin thanh cong!");
    }

    @Override
    public void xoa() {
        System.out.print("\nNhap ma nhan su can xoa: ");
        String maNhanSu = sc.nextLine();

        int viTri = -1;
        for (int i = 0; i < soLuongNhanSu; i++) {
            if (danhSachNhanSu[i].getMaNhanSu().equalsIgnoreCase(maNhanSu)) {
                viTri = i;
                break;
            }
        }

        if (viTri == -1) {
            System.out.println("Khong tim thay nhan su!");
            return;
        }

        System.out.print("Ban co chac chan muon xoa? (Y/N): ");
        String xacNhan = sc.nextLine();
        if (!xacNhan.equalsIgnoreCase("Y")) {
            System.out.println("Da huy thao tac xoa!");
            return;
        }

        // Dịch chuyển các phần tử về trước
        for (int i = viTri; i < soLuongNhanSu - 1; i++) {
            danhSachNhanSu[i] = danhSachNhanSu[i + 1];
        }
        danhSachNhanSu[soLuongNhanSu - 1] = null;
        soLuongNhanSu--;

        System.out.println("Xoa nhan su thanh cong!");
    }

    @Override
    public void hienThi() {
        if (soLuongNhanSu == 0) {
            System.out.println("\nDanh sach nhan su trong!");
            return;
        }

        System.out.println("\n=== DANH SACH NHAN SU ===");
        System.out.println("Tong so: " + soLuongNhanSu + " nhan su");
        System.out.printf("%-5s %-15s %-20s %-10s %-15s %-12s %-15s\n",
                "STT", "Ma", "Ho Ten", "Gioi Tinh", "Loai NS", "Luong", "Phong Ban");
        System.out.println(
                "---------------------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < soLuongNhanSu; i++) {
            NHANSU ns = danhSachNhanSu[i];
            System.out.printf("%-5d %-15s %-20s %-10s %-15s %-12.2f %-15s\n",
                    (i + 1), ns.getMaNhanSu(), ns.getHoTen(), ns.getGioiTinh(),
                    ns.getLoaiNhanSu(), ns.tinhLuong(),
                    ns.getPhongBan() != null ? ns.getPhongBan().getTenPhongBan() : "Chua xac dinh");
        }
        System.out.println(
                "---------------------------------------------------------------------------------------------------------------------------");
    }

    @Override
    public void timKiem() {
        System.out.println("\n=== TIM KIEM NHAN SU ===");
        System.out.println("1. Tim theo ma nhan su");
        System.out.println("2. Tim theo ten");
        System.out.println("3. Tim theo loai nhan su");
        System.out.print("Lua chon: ");

        int luaChon;
        try {
            luaChon = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println(" Loi: Vui long nhap so!");
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
                System.out.println("Lua chon khong hop le!");
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
        System.out.print("Nhap ma nhan su: ");
        String maNhanSu = sc.nextLine();

        NHANSU nhanSu = timKiemTheoMa(maNhanSu);
        if (nhanSu != null) {
            System.out.println("\n=== KET QUA TIM KIEM ===");
            System.out.printf("%-5s %-15s %-20s %-10s %-15s %-12s %-15s\n",
                    "STT", "Ma", "Ho Ten", "Gioi Tinh", "Loai NS", "Luong", "Phong Ban");
            System.out.println(
                    "---------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("%-5d %-15s %-20s %-10s %-15s %-12.2f %-15s\n",
                    1,
                    nhanSu.getMaNhanSu(),
                    nhanSu.getHoTen(),
                    nhanSu.getGioiTinh(),
                    nhanSu.getLoaiNhanSu(),
                    nhanSu.tinhLuong(),
                    nhanSu.getPhongBan() != null ? nhanSu.getPhongBan().getTenPhongBan() : "Chua xac dinh");
            System.out.println(
                    "---------------------------------------------------------------------------------------------------------------------------");
        } else {
            System.out.println("Khong tim thay nhan su!");
        }
    }

    // Tìm kiếm theo tên
    private void timKiemTheoTen() {
        System.out.print("Nhap ten can tim: ");
        String ten = sc.nextLine();

        // Đếm số lượng kết quả
        int soKetQua = 0;
        for (int i = 0; i < soLuongNhanSu; i++) {
            if (danhSachNhanSu[i].getHoTen().toLowerCase().contains(ten.toLowerCase())) {
                soKetQua++;
            }
        }

        if (soKetQua == 0) {
            System.out.println("\nKhong tim thay nhan su nao!");
            return;
        }

        // Hiển thị kết quả dưới dạng bảng
        System.out.println("\n=== KET QUA TIM KIEM ===");
        System.out.println("Tim thay " + soKetQua + " nhan su");
        System.out.printf("%-5s %-15s %-20s %-10s %-15s %-12s %-15s\n",
                "STT", "Ma", "Ho Ten", "Gioi Tinh", "Loai NS", "Luong", "Phong Ban");
        System.out.println(
                "---------------------------------------------------------------------------------------------------------------------------");

        int stt = 0;
        for (int i = 0; i < soLuongNhanSu; i++) {
            if (danhSachNhanSu[i].getHoTen().toLowerCase().contains(ten.toLowerCase())) {
                stt++;
                NHANSU ns = danhSachNhanSu[i];
                System.out.printf("%-5d %-15s %-20s %-10s %-15s %-12.2f %-15s\n",
                        stt,
                        ns.getMaNhanSu(),
                        ns.getHoTen(),
                        ns.getGioiTinh(),
                        ns.getLoaiNhanSu(),
                        ns.tinhLuong(),
                        ns.getPhongBan() != null ? ns.getPhongBan().getTenPhongBan() : "Chua xac dinh");
            }
        }

        System.out.println(
                "---------------------------------------------------------------------------------------------------------------------------");
    }

    // Tìm kiếm theo loại nhân sự
    private void timKiemTheoLoai() {
        System.out.println("Chon loai nhan su:");
        System.out.println("1. Nhan vien ky thuat");
        System.out.println("2. Nhan vien hanh chinh");
        System.out.println("3. Nhan vien quan ly");
        System.out.print("Lua chon: ");

        int loai;
        try {
            loai = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println(" Loi: Vui long nhap so!");
            return;
        }

        String loaiNhanSu = "";
        switch (loai) {
            case 1:
                loaiNhanSu = "Ky Thuat";
                break;
            case 2:
                loaiNhanSu = "Hanh Chinh";
                break;
            case 3:
                loaiNhanSu = "Quan Ly";
                break;
            default:
                System.out.println("Lua chon khong hop le!");
                return;
        }

        // Đếm số lượng kết quả
        int soKetQua = 0;
        for (int i = 0; i < soLuongNhanSu; i++) {
            if (danhSachNhanSu[i].getLoaiNhanSu().equals(loaiNhanSu)) {
                soKetQua++;
            }
        }

        if (soKetQua == 0) {
            System.out.println("\nKhong tim thay nhan su nao!");
            return;
        }

        // Hiển thị kết quả dưới dạng bảng
        System.out.println("\n=== DANH SACH " + loaiNhanSu.toUpperCase() + " ===");
        System.out.println("Tim thay " + soKetQua + " nhan su");
        System.out.printf("%-5s %-15s %-20s %-10s %-15s %-12s %-15s\n",
                "STT", "Ma", "Ho Ten", "Gioi Tinh", "Loai NS", "Luong", "Phong Ban");
        System.out.println(
                "---------------------------------------------------------------------------------------------------------------------------");

        int stt = 0;
        for (int i = 0; i < soLuongNhanSu; i++) {
            if (danhSachNhanSu[i].getLoaiNhanSu().equals(loaiNhanSu)) {
                stt++;
                NHANSU ns = danhSachNhanSu[i];
                System.out.printf("%-5d %-15s %-20s %-10s %-15s %-12.2f %-15s\n",
                        stt,
                        ns.getMaNhanSu(),
                        ns.getHoTen(),
                        ns.getGioiTinh(),
                        ns.getLoaiNhanSu(),
                        ns.tinhLuong(),
                        ns.getPhongBan() != null ? ns.getPhongBan().getTenPhongBan() : "Chua xac dinh");
            }
        }

        System.out.println(
                "---------------------------------------------------------------------------------------------------------------------------");
    }

    @Override
    public void ghiFile() {
        try {
            FileWriter fw = new FileWriter("danhsachnhansuu.txt");
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write("Tong so nhan su: " + soLuongNhanSu + "\n");
            bw.write("========================================\n");

            for (int i = 0; i < soLuongNhanSu; i++) {
                NHANSU ns = danhSachNhanSu[i];
                bw.write("Ma: " + ns.getMaNhanSu() + "\n");
                bw.write("Ho ten: " + ns.getHoTen() + "\n");
                bw.write("Gioi tinh: " + ns.getGioiTinh() + "\n");
                bw.write("Dia chi: " + ns.getDiaChi() + "\n");
                bw.write("SDT: " + ns.getSoDienThoai() + "\n");
                bw.write("Email: " + ns.getEmail() + "\n");
                bw.write("Luong co ban: " + ns.getLuongCoBan() + "\n");
                bw.write("He so luong: " + ns.getHeSoLuong() + "\n");
                bw.write("Loai: " + ns.getLoaiNhanSu() + "\n");
                bw.write("Luong: " + ns.tinhLuong() + "\n");
                bw.write("----------------------------------------\n");
            }

            bw.close();
            fw.close();
            System.out.println("Ghi file thanh cong!");
        } catch (IOException e) {
            System.out.println("Loi ghi file: " + e.getMessage());
        }
    }

    @Override
    public void docFile() {
        try {
            FileReader fr = new FileReader("danhsachnhansu.txt");
            BufferedReader br = new BufferedReader(fr);

            String line;
            System.out.println("\n=== NOI DUNG FILE ===");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
            System.out.println("Khong tim thay file!");
        } catch (IOException e) {
            System.out.println("Loi doc file: " + e.getMessage());
        }
    }

    // Thong ke so luong nhan su theo loai
    public void thongKe() {
        int soKyThuat = 0, soHanhChinh = 0, soQuanLy = 0;

        for (int i = 0; i < soLuongNhanSu; i++) {
            String loai = danhSachNhanSu[i].getLoaiNhanSu();
            if (loai.equals("Ky Thuat")) {
                soKyThuat++;
            } else if (loai.equals("Hanh Chinh")) {
                soHanhChinh++;
            } else if (loai.equals("Quan Ly")) {
                soQuanLy++;
            }
        }

        System.out.println("\n=== THONG KE NHAN SU ===");
        System.out.println("Tong so nhan su: " + soLuongNhanSu);
        System.out.println("Nhan vien ky thuat: " + soKyThuat);
        System.out.println("Nhan vien hanh chinh: " + soHanhChinh);
        System.out.println("Nhan vien quan ly: " + soQuanLy);
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
        System.out.println("Da sap xep theo luong tang dan!");
    }

    // Nhập nhiều nhân sự cùng lúc
    public void themNhieu() {
        System.out.print("\nNhap so luong nhan su can them: ");
        int n;
        try {
            n = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println(" Loi: Vui long nhap so nguyen!");
            return;
        }

        if (n <= 0) {
            System.out.println("So luong phai lon hon 0.");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (soLuongNhanSu >= MAX_NHANSU) {
                System.out.println("Danh sach da day, khong the them nua.");
                break;
            }
            System.out.println("\n--- Nhap nhan su thu " + (i + 1) + " ---");
            them();
        }
        System.out.println("Hoan tat nhap " + n + " nhan su\n");
    }

    // ===== QUAN LY BANG LUONG =====

    // Thêm bảng lương cho nhân sự
    public void themBangLuong() {
        if (soLuongBangLuong >= MAX_BANGLUONG) {
            System.out.println("Danh sach bang luong da day!");
            return;
        }

        System.out.print("\nNhap ma nhan su: ");
        String maNhanSu = sc.nextLine();

        NHANSU nhanSu = timKiemTheoMa(maNhanSu);
        if (nhanSu == null) {
            System.out.println("Khong tim thay nhan su!");
            return;
        }

        System.out.println("\n=== TAO BANG LUONG CHO NHAN SU: " + nhanSu.getHoTen() + " ===");

        System.out.print("Ma bang luong: ");
        String maBangLuong = sc.nextLine();

        // Kiểm tra trùng mã bảng lương
        for (int i = 0; i < soLuongBangLuong; i++) {
            if (danhSachBangLuong[i].getMaBangLuong().equalsIgnoreCase(maBangLuong)) {
                System.out.println("Ma bang luong da ton tai!");
                return;
            }
        }

        // Nhập thông tin chấm công
        System.out.println("\n--- THONG TIN CHAM CONG ---");
        System.out.print("Ma cham cong: ");
        String maChamCong = sc.nextLine();

        int soNgayLamViec;
        do {
            System.out.print("So ngay lam viec (1-26): ");
            try {
                soNgayLamViec = Integer.parseInt(sc.nextLine());
                if (soNgayLamViec < 0 || soNgayLamViec > 26) {
                    System.out.println("So ngay lam viec phai tu 0 den 26!");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Loi: Vui long nhap so nguyen!");
                soNgayLamViec = -1;
            }
        } while (true);

        int soNgayNghi;
        do {
            System.out.print("So ngay nghi: ");
            try {
                soNgayNghi = Integer.parseInt(sc.nextLine());
                if (soNgayNghi < 0) {
                    System.out.println("So ngay nghi khong duoc am!");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Loi: Vui long nhap so nguyen!");
                soNgayNghi = -1;
            }
        } while (true);

        CHAMCONG chamCong = new CHAMCONG(maChamCong, soNgayLamViec, soNgayNghi);

        // Nhập thông tin thưởng
        System.out.println("\n--- THONG TIN THUONG ---");
        String coThuong;
        do {
            System.out.print("Co thuong khong? (Y/N): ");
            coThuong = sc.nextLine().trim().toUpperCase();
            if (!coThuong.equals("Y") && !coThuong.equals("N")) {
                System.out.println("Loi: Vui long chi nhap Y hoac N!");
            }
        } while (!coThuong.equals("Y") && !coThuong.equals("N"));

        THUONG thuong = null;
        if (coThuong.equals("Y")) {
            System.out.print("Loai thuong: ");
            String loaiThuong = sc.nextLine();

            double soTienThuong;
            do {
                System.out.print("So tien thuong: ");
                try {
                    soTienThuong = Double.parseDouble(sc.nextLine());
                    if (soTienThuong < 0) {
                        System.out.println("So tien thuong khong duoc am!");
                    } else {
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Loi: Vui long nhap so hop le!");
                    soTienThuong = -1;
                }
            } while (true);

            System.out.print("Ly do thuong: ");
            String lyDo = sc.nextLine();

            thuong = new THUONG(loaiThuong, soTienThuong, lyDo);
        } else {
            thuong = new THUONG("Khong co", 0, "Khong co");
        }

        // Nhập thông tin bảo hiểm
        System.out.println("\n--- THONG TIN BAO HIEM ---");
        System.out.print("Ma bao hiem: ");
        String maBaoHiem = sc.nextLine();

        System.out.println("Chon loai bao hiem:");
        System.out.println("1. Bao hiem Xa hoi (XH)");
        System.out.println("2. Bao hiem Y te (YT)");
        System.out.println("3. Bao hiem That nghiep (TN)");

        int loaiBH;
        String loaiBaoHiem;
        do {
            System.out.print("Lua chon (1-3): ");
            try {
                loaiBH = Integer.parseInt(sc.nextLine());
                switch (loaiBH) {
                    case 1:
                        loaiBaoHiem = "XH";
                        break;
                    case 2:
                        loaiBaoHiem = "YT";
                        break;
                    case 3:
                        loaiBaoHiem = "TN";
                        break;
                    default:
                        System.out.println("Loi: Vui long chon tu 1 den 3!");
                        loaiBaoHiem = null;
                }
                if (loaiBaoHiem != null) {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Loi: Vui long nhap so!");
            }
        } while (true);

        double phiBaoHiem;
        do {
            System.out.print("Phi bao hiem: ");
            try {
                phiBaoHiem = Double.parseDouble(sc.nextLine());
                if (phiBaoHiem < 0) {
                    System.out.println("Phi bao hiem khong duoc am!");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Loi: Vui long nhap so hop le!");
                phiBaoHiem = -1;
            }
        } while (true);

        BAOHIEM baoHiem = new BAOHIEM(maBaoHiem, loaiBaoHiem, phiBaoHiem);

        // Tạo bảng lương
        BANGLUONG bangLuong = new BANGLUONG(nhanSu, maBangLuong, thuong, 0, baoHiem, chamCong);

        // Tính lương thực nhận
        double luongThucNhan = bangLuong.tinhLuongThucNhan();
        bangLuong.setLuongThucNhan(luongThucNhan);

        danhSachBangLuong[soLuongBangLuong] = bangLuong;
        soLuongBangLuong++;

        System.out.println("\n=== TAO BANG LUONG THANH CONG ===");
        System.out.printf("Luong thuc nhan: %.2f VND\n", luongThucNhan);
    }

    // Hiển thị bảng lương của một nhân sự
    public void hienThiBangLuongCuaNhanSu() {
        System.out.print("\nNhap ma nhan su: ");
        String maNhanSu = sc.nextLine();

        NHANSU nhanSu = timKiemTheoMa(maNhanSu);
        if (nhanSu == null) {
            System.out.println("Khong tim thay nhan su!");
            return;
        }

        System.out.println("\n=== BANG LUONG CUA NHAN SU: " + nhanSu.getHoTen() + " ===");
        boolean timThay = false;
        int stt = 0;

        System.out.printf("%-5s %-12s %-12s %-20s %-15s %-12s %-12s %-12s %-15s\n",
                "STT", "Ma BL", "Ma NS", "Ho Ten", "Loai NS", "Ngay Lam", "Thuong", "Bao Hiem", "Luong Thuc Nhan");
        System.out.println(
                "-------------------------------------------------------------------------------------------------------------------------");

        for (int i = 0; i < soLuongBangLuong; i++) {
            BANGLUONG bl = danhSachBangLuong[i];
            // Chỉ hiển thị bảng lương của nhân sự được tìm kiếm
            if (bl.getNhanSu().getMaNhanSu().equalsIgnoreCase(maNhanSu)) {
                stt++;
                timThay = true;
                System.out.printf("%-5d %-12s %-12s %-20s %-15s %-12d %-12.2f %-12.2f %-15.2f\n",
                        stt,
                        bl.getMaBangLuong(),
                        bl.getNhanSu().getMaNhanSu(),
                        bl.getNhanSu().getHoTen(),
                        bl.getNhanSu().getLoaiNhanSu(),
                        bl.getChamCong().getSoNgayLamViec(),
                        bl.getThuong(),
                        bl.getBaoHiem(),
                        bl.getLuongThucNhan());
            }
        }

        System.out.println(
                "-------------------------------------------------------------------------------------------------------------------------");

        if (!timThay) {
            System.out.println("Nhan su nay chua co bang luong nao!");
        }
    }

    // Hiển thị tất cả bảng lương
    public void hienThiTatCaBangLuong() {
        if (soLuongBangLuong == 0) {
            System.out.println("\nChua co bang luong nao trong he thong!");
            return;
        }

        System.out.println("\n=== DANH SACH BANG LUONG ===");
        System.out.printf("%-5s %-12s %-12s %-20s %-15s %-12s %-12s %-12s %-15s\n",
                "STT", "Ma BL", "Ma NS", "Ho Ten", "Loai NS", "Ngay Lam", "Thuong", "Bao Hiem", "Luong Thuc Nhan");
        System.out.println(
                "-------------------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < soLuongBangLuong; i++) {
            BANGLUONG bl = danhSachBangLuong[i];

            System.out.printf("%-5d %-12s %-12s %-20s %-15s %-12d %-12.2f %-12.2f %-15.2f\n",
                    (i + 1),
                    bl.getMaBangLuong(),
                    bl.getNhanSu().getMaNhanSu(),
                    bl.getNhanSu().getHoTen(),
                    bl.getNhanSu().getLoaiNhanSu(),
                    bl.getChamCong().getSoNgayLamViec(),
                    bl.getThuong(),
                    bl.getBaoHiem(),
                    bl.getLuongThucNhan());

        }
        System.out.println(
                "-------------------------------------------------------------------------------------------------------------------------");

    }

    // Tìm kiếm bảng lương
    public void timKiemBangLuong() {
        System.out.println("\n=== TIM KIEM BANG LUONG ===");
        System.out.println("1. Tim theo ma bang luong");
        System.out.println("2. Tim theo ma nhan su");
        System.out.print("Lua chon: ");

        int luaChon;
        try {
            luaChon = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Loi: Vui long nhap so!");
            return;
        }

        switch (luaChon) {
            case 1:
                timKiemBangLuongTheoMa();
                break;
            case 2:
                hienThiBangLuongCuaNhanSu();
                break;
            default:
                System.out.println("Lua chon khong hop le!");
        }
    }

    private void timKiemBangLuongTheoMa() {
        System.out.print("Nhap ma bang luong: ");
        String maBangLuong = sc.nextLine();

        boolean timThay = false;
        for (int i = 0; i < soLuongBangLuong; i++) {
            if (danhSachBangLuong[i].getMaBangLuong().equalsIgnoreCase(maBangLuong)) {
                BANGLUONG bl = danhSachBangLuong[i];

                System.out.println("\n=== KET QUA TIM KIEM ===");
                System.out.printf("%-5s %-12s %-12s %-20s %-15s %-12s %-12s %-12s %-15s\n",
                        "STT", "Ma BL", "Ma NS", "Ho Ten", "Loai NS", "Ngay Lam", "Thuong", "Bao Hiem",
                        "Luong Thuc Nhan");
                System.out.println(
                        "-------------------------------------------------------------------------------------------------------------------------");
                System.out.printf("%-5d %-12s %-12s %-20s %-15s %-12d %-12.2f %-12.2f %-15.2f\n",
                        1,
                        bl.getMaBangLuong(),
                        bl.getNhanSu().getMaNhanSu(),
                        bl.getNhanSu().getHoTen(),
                        bl.getNhanSu().getLoaiNhanSu(),
                        bl.getChamCong().getSoNgayLamViec(),
                        bl.getThuong(),
                        bl.getBaoHiem(),
                        bl.getLuongThucNhan());
                System.out.println(
                        "-------------------------------------------------------------------------------------------------------------------------");
                timThay = true;
                return;
            }
        }

        if (!timThay) {
            System.out.println("Khong tim thay bang luong!");
        }
    }

    // Xóa bảng lương
    public void xoaBangLuong() {
        System.out.print("\nNhap ma bang luong can xoa: ");
        String maBangLuong = sc.nextLine();

        int viTri = -1;
        for (int i = 0; i < soLuongBangLuong; i++) {
            if (danhSachBangLuong[i].getMaBangLuong().equalsIgnoreCase(maBangLuong)) {
                viTri = i;
                break;
            }
        }

        if (viTri == -1) {
            System.out.println("Khong tim thay bang luong!");
            return;
        }

        System.out.print("Ban co chac chan muon xoa? (Y/N): ");
        String xacNhan = sc.nextLine();
        if (!xacNhan.equalsIgnoreCase("Y")) {
            System.out.println("Da huy thao tac xoa!");
            return;
        }

        // Dịch chuyển các phần tử về trước
        for (int i = viTri; i < soLuongBangLuong - 1; i++) {
            danhSachBangLuong[i] = danhSachBangLuong[i + 1];
        }
        danhSachBangLuong[soLuongBangLuong - 1] = null;
        soLuongBangLuong--;

        System.out.println("Xoa bang luong thanh cong!");
    }

    // Thống kê bảng lương
    public void thongKeBangLuong() {
        if (soLuongBangLuong == 0) {
            System.out.println("\nChua co bang luong nao trong he thong!");
            return;
        }

        double tongLuong = 0;
        double luongCaoNhat = 0;
        double luongThapNhat = Double.MAX_VALUE;
        BANGLUONG blCaoNhat = null;
        BANGLUONG blThapNhat = null;

        for (int i = 0; i < soLuongBangLuong; i++) {
            double luong = danhSachBangLuong[i].getLuongThucNhan();
            tongLuong += luong;

            if (luong > luongCaoNhat) {
                luongCaoNhat = luong;
                blCaoNhat = danhSachBangLuong[i];
            }

            if (luong < luongThapNhat) {
                luongThapNhat = luong;
                blThapNhat = danhSachBangLuong[i];
            }
        }

        double luongTrungBinh = tongLuong / soLuongBangLuong;

        System.out.println("\n=== THONG KE BANG LUONG ===");
        System.out.println("Tong so bang luong: " + soLuongBangLuong);
        System.out.printf("Tong luong chi tra: %,.0f VND\n", tongLuong);
        System.out.printf("Luong trung binh: %,.0f VND\n", luongTrungBinh);

        if (blCaoNhat != null) {
            System.out.println("\nLuong cao nhat:");
            System.out.println("  Nhan su: " + blCaoNhat.getNhanSu().getHoTen());
            System.out.printf("  Luong: %,.0f VND\n", luongCaoNhat);
        }

        if (blThapNhat != null) {
            System.out.println("\nLuong thap nhat:");
            System.out.println("  Nhan su: " + blThapNhat.getNhanSu().getHoTen());
            System.out.printf("  Luong: %,.0f VND\n", luongThapNhat);
        }
    }

    // ==================== QUAN LY HOP DONG ====================

    // Thêm hợp đồng cho nhân sự
    public void themHopDong() {
        System.out.print("\nNhap ma nhan su can them hop dong: ");
        String maNhanSu = sc.nextLine();

        NHANSU nhanSu = timKiemTheoMa(maNhanSu);
        if (nhanSu == null) {
            System.out.println("Khong tim thay nhan su!");
            return;
        }

        // Kiểm tra nhân sự đã có hợp đồng chưa
        HOPDONG hopDongHienTai = null;
        if (nhanSu instanceof NHANVIENHANHCHINH) {
            hopDongHienTai = ((NHANVIENHANHCHINH) nhanSu).getHopDong();
        } else if (nhanSu instanceof NHANVIENKYTHUAT) {
            hopDongHienTai = ((NHANVIENKYTHUAT) nhanSu).getHopDong();
        } else if (nhanSu instanceof NHANVIENQUANLY) {
            hopDongHienTai = ((NHANVIENQUANLY) nhanSu).getHopDong();
        }

        if (hopDongHienTai != null) {
            System.out.println("Nhan su nay da co hop dong!");
            System.out.println("Ban co muon thay the hop dong cu? (Y/N): ");
            String xacNhan = sc.nextLine();
            if (!xacNhan.equalsIgnoreCase("Y")) {
                System.out.println("Huy them hop dong.");
                return;
            }
        }

        System.out.println("\n=== THEM HOP DONG CHO NHAN SU: " + nhanSu.getHoTen() + " ===");

        System.out.print("Ma hop dong: ");
        String maHopDong = sc.nextLine();

        System.out.println("Chon loai hop dong:");
        System.out.println("1. Fulltime");
        System.out.println("2. Partime");
        System.out.print("Lua chon (1-2): ");

        int loaiHD;
        String loaiHopDong;
        try {
            loaiHD = Integer.parseInt(sc.nextLine());
            switch (loaiHD) {
                case 1:
                    loaiHopDong = "Fulltime";
                    break;
                case 2:
                    loaiHopDong = "Partime";
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
                    return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Loi: Vui long nhap so!");
            return;
        }

        // Nhập ngày bắt đầu với validation
        String ngayBatDau;
        do {
            System.out.print("Ngay bat dau (dd/MM/yyyy): ");
            ngayBatDau = sc.nextLine();

            if (ngayBatDau.matches("\\d{2}/\\d{2}/\\d{4}")) {
                break;
            } else {
                System.out.println("Loi: Ngay bat dau phai co dinh dang dd/MM/yyyy!");
            }
        } while (true);

        // Nhập ngày kết thúc với validation
        String ngayKetThuc;
        do {
            System.out.print("Ngay ket thuc (dd/MM/yyyy): ");
            ngayKetThuc = sc.nextLine();

            if (ngayKetThuc.matches("\\d{2}/\\d{2}/\\d{4}")) {
                break;
            } else {
                System.out.println("Loi: Ngay ket thuc phai co dinh dang dd/MM/yyyy!");
            }
        } while (true);

        // Tạo hợp đồng mới
        HOPDONG hopDong = new HOPDONG(maHopDong, loaiHopDong, ngayBatDau, ngayKetThuc);

        // Gán hợp đồng cho nhân sự tương ứng (chỉ set từ phía nhân viên)
        if (nhanSu instanceof NHANVIENHANHCHINH) {
            ((NHANVIENHANHCHINH) nhanSu).setHopDong(hopDong);
        } else if (nhanSu instanceof NHANVIENKYTHUAT) {
            ((NHANVIENKYTHUAT) nhanSu).setHopDong(hopDong);
        } else if (nhanSu instanceof NHANVIENQUANLY) {
            ((NHANVIENQUANLY) nhanSu).setHopDong(hopDong);
        }

        System.out.println("Them hop dong thanh cong!");
    }

    // Hiển thị hợp đồng của một nhân sự
    public void hienThiHopDongCuaNhanSu() {
        System.out.print("\nNhap ma nhan su: ");
        String maNhanSu = sc.nextLine();

        NHANSU nhanSu = timKiemTheoMa(maNhanSu);
        if (nhanSu == null) {
            System.out.println("Khong tim thay nhan su!");
            return;
        }

        HOPDONG hopDong = null;
        if (nhanSu instanceof NHANVIENHANHCHINH) {
            hopDong = ((NHANVIENHANHCHINH) nhanSu).getHopDong();
        } else if (nhanSu instanceof NHANVIENKYTHUAT) {
            hopDong = ((NHANVIENKYTHUAT) nhanSu).getHopDong();
        } else if (nhanSu instanceof NHANVIENQUANLY) {
            hopDong = ((NHANVIENQUANLY) nhanSu).getHopDong();
        }

        System.out.println("\n=== HOP DONG CUA NHAN SU: " + nhanSu.getHoTen() + " ===");
        if (hopDong != null) {
            System.out.printf("%-5s %-12s %-12s %-25s %-15s %-35s %-15s %-15s\n",
                    "STT", "Ma HD", "Ma NS", "Ho Ten", "Loai NS", "Loai HD", "Ngay BD", "Ngay KT");
            System.out.println(
                    "---------------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("%-5d %-12s %-12s %-25s %-15s %-35s %-15s %-15s\n",
                    1,
                    hopDong.getMaHopDong(),
                    nhanSu.getMaNhanSu(),
                    truncate(nhanSu.getHoTen(), 25),
                    nhanSu.getLoaiNhanSu(),
                    truncate(hopDong.getLoaiHopDong(), 35),
                    hopDong.getNgayBatDau(),
                    hopDong.getNgayKetThuc());
            System.out.println(
                    "---------------------------------------------------------------------------------------------------------------------------------------");
        } else {
            System.out.println("Nhan su nay chua co hop dong!");
        }
    }

    // Hiển thị tất cả hợp đồng
    public void hienThiTatCaHopDong() {
        if (soLuongNhanSu == 0) {
            System.out.println("\nChua co nhan su nao trong he thong!");
            return;
        }

        System.out.println("\n=== DANH SACH HOP DONG ===");
        System.out.printf("%-5s %-12s %-12s %-25s %-15s %-35s %-15s %-15s\n",
                "STT", "Ma HD", "Ma NS", "Ho Ten", "Loai NS", "Loai HD", "Ngay BD", "Ngay KT");
        System.out.println(
                "---------------------------------------------------------------------------------------------------------------------------------------");

        int stt = 0;
        for (int i = 0; i < soLuongNhanSu; i++) {
            NHANSU ns = danhSachNhanSu[i];
            HOPDONG hopDong = null;

            if (ns instanceof NHANVIENHANHCHINH) {
                hopDong = ((NHANVIENHANHCHINH) ns).getHopDong();
            } else if (ns instanceof NHANVIENKYTHUAT) {
                hopDong = ((NHANVIENKYTHUAT) ns).getHopDong();
            } else if (ns instanceof NHANVIENQUANLY) {
                hopDong = ((NHANVIENQUANLY) ns).getHopDong();
            }

            if (hopDong != null) {
                stt++;
                System.out.printf("%-5d %-12s %-12s %-25s %-15s %-35s %-15s %-15s\n",
                        stt,
                        hopDong.getMaHopDong(),
                        ns.getMaNhanSu(),
                        truncate(ns.getHoTen(), 25),
                        ns.getLoaiNhanSu(),
                        truncate(hopDong.getLoaiHopDong(), 35),
                        hopDong.getNgayBatDau(),
                        hopDong.getNgayKetThuc());
            }
        }

        System.out.println(
                "---------------------------------------------------------------------------------------------------------------------------------------");

        if (stt == 0) {
            System.out.println("Chua co hop dong nao trong he thong!");
        }
    }

    // Sửa hợp đồng
    public void suaHopDong() {
        System.out.print("\nNhap ma nhan su can sua hop dong: ");
        String maNhanSu = sc.nextLine();

        NHANSU nhanSu = timKiemTheoMa(maNhanSu);
        if (nhanSu == null) {
            System.out.println("Khong tim thay nhan su!");
            return;
        }

        HOPDONG hopDong = null;
        if (nhanSu instanceof NHANVIENHANHCHINH) {
            hopDong = ((NHANVIENHANHCHINH) nhanSu).getHopDong();
        } else if (nhanSu instanceof NHANVIENKYTHUAT) {
            hopDong = ((NHANVIENKYTHUAT) nhanSu).getHopDong();
        } else if (nhanSu instanceof NHANVIENQUANLY) {
            hopDong = ((NHANVIENQUANLY) nhanSu).getHopDong();
        }

        if (hopDong == null) {
            System.out.println("Nhan su nay chua co hop dong!");
            return;
        }

        System.out.println("\n=== SUA HOP DONG CUA NHAN SU: " + nhanSu.getHoTen() + " ===");
        System.out.println("Thong tin hien tai:");
        System.out.printf("%-5s %-12s %-12s %-25s %-15s %-35s %-15s %-15s\n",
                "STT", "Ma HD", "Ma NS", "Ho Ten", "Loai NS", "Loai HD", "Ngay BD", "Ngay KT");
        System.out.println(
                "---------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-5d %-12s %-12s %-25s %-15s %-35s %-15s %-15s\n",
                1,
                hopDong.getMaHopDong(),
                nhanSu.getMaNhanSu(),
                truncate(nhanSu.getHoTen(), 25),
                nhanSu.getLoaiNhanSu(),
                truncate(hopDong.getLoaiHopDong(), 35),
                hopDong.getNgayBatDau(),
                hopDong.getNgayKetThuc());
        System.out.println(
                "---------------------------------------------------------------------------------------------------------------------------------------");

        System.out.println("\nNhap thong tin moi (Enter de giu nguyen):");

        System.out.print("Ma hop dong moi: ");
        String maHopDong = sc.nextLine();
        if (!maHopDong.isEmpty()) {
            hopDong.setMaHopDong(maHopDong);
        }

        System.out.println("Chon loai hop dong moi:");
        System.out.println("1. Fulltime");
        System.out.println("2. Partime");
        System.out.print("Lua chon (1-2, Enter de giu nguyen): ");
        String loaiHDStr = sc.nextLine();

        if (!loaiHDStr.isEmpty()) {
            try {
                int loaiHD = Integer.parseInt(loaiHDStr);
                String loaiHopDong;
                switch (loaiHD) {
                    case 1:
                        loaiHopDong = "Fulltime";
                        break;
                    case 2:
                        loaiHopDong = "Partime";
                        break;
                    default:
                        System.out.println("Lua chon khong hop le! Giu nguyen loai hop dong cu.");
                        loaiHopDong = null;
                }
                if (loaiHopDong != null) {
                    hopDong.setLoaiHopDong(loaiHopDong);
                }
            } catch (NumberFormatException e) {
                System.out.println("Loi: Vui long nhap so! Giu nguyen loai hop dong cu.");
            }
        }

        // Nhập ngày bắt đầu mới với validation
        String ngayBatDau;
        do {
            System.out.print("Ngay bat dau moi (dd/MM/yyyy, Enter de giu nguyen): ");
            ngayBatDau = sc.nextLine();

            if (ngayBatDau.isEmpty()) {
                break; // Giữ nguyên
            }

            if (ngayBatDau.matches("\\d{2}/\\d{2}/\\d{4}")) {
                hopDong.setNgayBatDau(ngayBatDau);
                break;
            } else {
                System.out.println("Loi: Ngay bat dau phai co dinh dang dd/MM/yyyy!");
            }
        } while (true);

        // Nhập ngày kết thúc mới với validation
        String ngayKetThuc;
        do {
            System.out.print("Ngay ket thuc moi (dd/MM/yyyy, Enter de giu nguyen): ");
            ngayKetThuc = sc.nextLine();

            if (ngayKetThuc.isEmpty()) {
                break; // Giữ nguyên
            }

            if (ngayKetThuc.matches("\\d{2}/\\d{2}/\\d{4}")) {
                hopDong.setNgayKetThuc(ngayKetThuc);
                break;
            } else {
                System.out.println("Loi: Ngay ket thuc phai co dinh dang dd/MM/yyyy!");
            }
        } while (true);

        System.out.println("Cap nhat hop dong thanh cong!");
    }

    // Xóa hợp đồng
    public void xoaHopDong() {
        System.out.print("\nNhap ma nhan su can xoa hop dong: ");
        String maNhanSu = sc.nextLine();

        NHANSU nhanSu = timKiemTheoMa(maNhanSu);
        if (nhanSu == null) {
            System.out.println("Khong tim thay nhan su!");
            return;
        }

        HOPDONG hopDong = null;
        if (nhanSu instanceof NHANVIENHANHCHINH) {
            hopDong = ((NHANVIENHANHCHINH) nhanSu).getHopDong();
        } else if (nhanSu instanceof NHANVIENKYTHUAT) {
            hopDong = ((NHANVIENKYTHUAT) nhanSu).getHopDong();
        } else if (nhanSu instanceof NHANVIENQUANLY) {
            hopDong = ((NHANVIENQUANLY) nhanSu).getHopDong();
        }

        if (hopDong == null) {
            System.out.println("Nhan su nay chua co hop dong!");
            return;
        }

        System.out.println("\n=== XOA HOP DONG CUA NHAN SU: " + nhanSu.getHoTen() + " ===");
        System.out.printf("%-5s %-12s %-12s %-25s %-15s %-35s %-15s %-15s\n",
                "STT", "Ma HD", "Ma NS", "Ho Ten", "Loai NS", "Loai HD", "Ngay BD", "Ngay KT");
        System.out.println(
                "---------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-5d %-12s %-12s %-25s %-15s %-35s %-15s %-15s\n",
                1,
                hopDong.getMaHopDong(),
                nhanSu.getMaNhanSu(),
                truncate(nhanSu.getHoTen(), 25),
                nhanSu.getLoaiNhanSu(),
                truncate(hopDong.getLoaiHopDong(), 35),
                hopDong.getNgayBatDau(),
                hopDong.getNgayKetThuc());
        System.out.println(
                "---------------------------------------------------------------------------------------------------------------------------------------");

        System.out.print("\nBan co chac chan muon xoa hop dong nay? (Y/N): ");
        String xacNhan = sc.nextLine();

        if (xacNhan.equalsIgnoreCase("Y")) {
            // Xóa hợp đồng bằng cách set null
            if (nhanSu instanceof NHANVIENHANHCHINH) {
                ((NHANVIENHANHCHINH) nhanSu).setHopDong(null);
            } else if (nhanSu instanceof NHANVIENKYTHUAT) {
                ((NHANVIENKYTHUAT) nhanSu).setHopDong(null);
            } else if (nhanSu instanceof NHANVIENQUANLY) {
                ((NHANVIENQUANLY) nhanSu).setHopDong(null);
            }
            System.out.println("Xoa hop dong thanh cong!");
        } else {
            System.out.println("Huy xoa hop dong.");
        }
    }

    // Tìm kiếm hợp đồng
    public void timKiemHopDong() {
        System.out.println("\n=== TIM KIEM HOP DONG ===");
        System.out.println("1. Tim theo ma hop dong");
        System.out.println("2. Tim theo ma nhan su");
        System.out.println("3. Tim theo loai hop dong");
        System.out.print("Lua chon: ");

        int luaChon;
        try {
            luaChon = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Loi: Vui long nhap so!");
            return;
        }

        switch (luaChon) {
            case 1:
                timKiemHopDongTheoMa();
                break;
            case 2:
                hienThiHopDongCuaNhanSu();
                break;
            case 3:
                timKiemHopDongTheoLoai();
                break;
            default:
                System.out.println("Lua chon khong hop le!");
        }
    }

    private void timKiemHopDongTheoMa() {
        System.out.print("Nhap ma hop dong: ");
        String maHopDong = sc.nextLine();

        System.out.println("\n=== KET QUA TIM KIEM ===");
        boolean timThay = false;

        for (int i = 0; i < soLuongNhanSu; i++) {
            NHANSU ns = danhSachNhanSu[i];
            HOPDONG hopDong = null;

            if (ns instanceof NHANVIENHANHCHINH) {
                hopDong = ((NHANVIENHANHCHINH) ns).getHopDong();
            } else if (ns instanceof NHANVIENKYTHUAT) {
                hopDong = ((NHANVIENKYTHUAT) ns).getHopDong();
            } else if (ns instanceof NHANVIENQUANLY) {
                hopDong = ((NHANVIENQUANLY) ns).getHopDong();
            }

            if (hopDong != null && hopDong.getMaHopDong().equalsIgnoreCase(maHopDong)) {
                System.out.printf("%-5s %-12s %-12s %-25s %-15s %-35s %-15s %-15s\n",
                        "STT", "Ma HD", "Ma NS", "Ho Ten", "Loai NS", "Loai HD", "Ngay BD", "Ngay KT");
                System.out.println(
                        "---------------------------------------------------------------------------------------------------------------------------------------");
                System.out.printf("%-5d %-12s %-12s %-25s %-15s %-35s %-15s %-15s\n",
                        1,
                        hopDong.getMaHopDong(),
                        ns.getMaNhanSu(),
                        truncate(ns.getHoTen(), 25),
                        ns.getLoaiNhanSu(),
                        truncate(hopDong.getLoaiHopDong(), 35),
                        hopDong.getNgayBatDau(),
                        hopDong.getNgayKetThuc());
                System.out.println(
                        "---------------------------------------------------------------------------------------------------------------------------------------");
                timThay = true;
                break;
            }
        }

        if (!timThay) {
            System.out.println("Khong tim thay hop dong!");
        }
    }

    private void timKiemHopDongTheoLoai() {
        System.out.println("Chon loai hop dong:");
        System.out.println("1. Fulltime");
        System.out.println("2. Partime");
        System.out.print("Lua chon: ");

        int loaiHD;
        String loaiHopDong;
        try {
            loaiHD = Integer.parseInt(sc.nextLine());
            switch (loaiHD) {
                case 1:
                    loaiHopDong = "Fulltime";
                    break;
                case 2:
                    loaiHopDong = "Partime";
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
                    return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Loi: Vui long nhap so!");
            return;
        }

        System.out.println("\n=== KET QUA TIM KIEM: " + loaiHopDong + " ===");
        System.out.printf("%-5s %-12s %-12s %-25s %-15s %-15s %-15s\n",
                "STT", "Ma HD", "Ma NS", "Ho Ten", "Loai NS", "Ngay BD", "Ngay KT");
        System.out.println(
                "-------------------------------------------------------------------------------------------------------------------------------");

        int stt = 0;
        for (int i = 0; i < soLuongNhanSu; i++) {
            NHANSU ns = danhSachNhanSu[i];
            HOPDONG hopDong = null;

            if (ns instanceof NHANVIENHANHCHINH) {
                hopDong = ((NHANVIENHANHCHINH) ns).getHopDong();
            } else if (ns instanceof NHANVIENKYTHUAT) {
                hopDong = ((NHANVIENKYTHUAT) ns).getHopDong();
            } else if (ns instanceof NHANVIENQUANLY) {
                hopDong = ((NHANVIENQUANLY) ns).getHopDong();
            }

            if (hopDong != null && hopDong.getLoaiHopDong().equalsIgnoreCase(loaiHopDong)) {
                stt++;
                System.out.printf("%-5d %-12s %-12s %-25s %-15s %-15s %-15s\n",
                        stt,
                        hopDong.getMaHopDong(),
                        ns.getMaNhanSu(),
                        truncate(ns.getHoTen(), 25),
                        ns.getLoaiNhanSu(),
                        hopDong.getNgayBatDau(),
                        hopDong.getNgayKetThuc());
            }
        }

        System.out.println(
                "-------------------------------------------------------------------------------------------------------------------------------");

        if (stt == 0) {
            System.out.println("Khong tim thay hop dong nao!");
        }
    }

    // Thống kê hợp đồng
    public void thongKeHopDong() {
        if (soLuongNhanSu == 0) {
            System.out.println("\nChua co nhan su nao trong he thong!");
            return;
        }

        int tongHopDong = 0;
        int hdFulltime = 0;
        int hdParttime = 0;

        for (int i = 0; i < soLuongNhanSu; i++) {
            NHANSU ns = danhSachNhanSu[i];
            HOPDONG hopDong = null;

            if (ns instanceof NHANVIENHANHCHINH) {
                hopDong = ((NHANVIENHANHCHINH) ns).getHopDong();
            } else if (ns instanceof NHANVIENKYTHUAT) {
                hopDong = ((NHANVIENKYTHUAT) ns).getHopDong();
            } else if (ns instanceof NHANVIENQUANLY) {
                hopDong = ((NHANVIENQUANLY) ns).getHopDong();
            }

            if (hopDong != null) {
                tongHopDong++;
                String loai = hopDong.getLoaiHopDong();
                if (loai.contains("Fulltime")) {
                    hdFulltime++;
                } else if (loai.contains("Parttime")) {
                    hdParttime++;
                }
            }
        }

        System.out.println("\n=== THONG KE HOP DONG ===");
        System.out.println("Tong so hop dong: " + tongHopDong);
        System.out.println("  - Hop dong fulltime: " + hdFulltime);
        System.out.println("  - Hop dong parttime: " + hdParttime);
        System.out.println("So nhan su chua co hop dong: " + (soLuongNhanSu - tongHopDong));
    }

    // ==================== QUAN LY DU AN ====================

    // Thêm dự án
    public void themDuAn() {
        if (soLuongDuAn >= MAX_DUAN) {
            System.out.println("\nDanh sach du an da day!");
            return;
        }

        System.out.println("\n=== THEM DU AN MOI ===");

        System.out.print("Ma du an: ");
        String maDuAn = sc.nextLine();

        // Kiểm tra trùng mã
        for (int i = 0; i < soLuongDuAn; i++) {
            if (danhSachDuAn[i].getMaDuAn().equalsIgnoreCase(maDuAn)) {
                System.out.println("Ma du an da ton tai!");
                return;
            }
        }

        System.out.print("Ten du an: ");
        String tenDuAn = sc.nextLine();

        // Nhập ngày bắt đầu với validation
        String ngayBatDau;
        do {
            System.out.print("Ngay bat dau (dd/MM/yyyy): ");
            ngayBatDau = sc.nextLine();

            if (ngayBatDau.matches("\\d{2}/\\d{2}/\\d{4}")) {
                break;
            } else {
                System.out.println("Loi: Ngay bat dau phai co dinh dang dd/MM/yyyy!");
            }
        } while (true);

        // Nhập ngày kết thúc với validation
        String ngayKetThuc;
        do {
            System.out.print("Ngay ket thuc (dd/MM/yyyy): ");
            ngayKetThuc = sc.nextLine();

            if (ngayKetThuc.matches("\\d{2}/\\d{2}/\\d{4}")) {
                break;
            } else {
                System.out.println("Loi: Ngay ket thuc phai co dinh dang dd/MM/yyyy!");
            }
        } while (true);

        System.out.print("Ma nhan su phu trach: ");
        String maNhanSu = sc.nextLine();

        NHANSU nhanSu = timKiemTheoMa(maNhanSu);
        if (nhanSu == null) {
            System.out.println("Khong tim thay nhan su! Tao du an khong co nguoi phu trach.");
        }

        DUAN duAn = new DUAN(nhanSu, maDuAn, tenDuAn, ngayBatDau, ngayKetThuc);
        danhSachDuAn[soLuongDuAn++] = duAn;

        System.out.println("Them du an thanh cong!");
    }

    // Hiển thị dự án của một nhân sự
    public void hienThiDuAnCuaNhanSu() {
        System.out.print("\nNhap ma nhan su: ");
        String maNhanSu = sc.nextLine();

        NHANSU nhanSu = timKiemTheoMa(maNhanSu);
        if (nhanSu == null) {
            System.out.println("Khong tim thay nhan su!");
            return;
        }

        System.out.println("\n=== DU AN CUA NHAN SU: " + nhanSu.getHoTen() + " ===");
        boolean timThay = false;
        int stt = 0;

        // In header bảng
        System.out.printf("%-5s %-12s %-30s %-15s %-15s\n",
                "STT", "Ma DA", "Ten Du An", "Ngay BD", "Ngay KT");
        System.out.println(
                "--------------------------------------------------------------------------------");

        for (int i = 0; i < soLuongDuAn; i++) {
            if (danhSachDuAn[i].getNhanSu() != null
                    && danhSachDuAn[i].getNhanSu().getMaNhanSu().equalsIgnoreCase(maNhanSu)) {
                DUAN da = danhSachDuAn[i];
                stt++;
                System.out.printf("%-5d %-12s %-30s %-15s %-15s\n",
                        stt,
                        da.getMaDuAn(),
                        truncate(da.getTenDuAn(), 30),
                        da.getNgayBatDau(),
                        da.getNgayKetThuc());
                timThay = true;
            }
        }

        System.out.println(
                "--------------------------------------------------------------------------------");

        if (!timThay) {
            System.out.println("Nhan su nay chua tham gia du an nao!");
        }
    }

    // Hiển thị tất cả dự án
    public void hienThiTatCaDuAn() {
        if (soLuongDuAn == 0) {
            System.out.println("\nChua co du an nao trong he thong!");
            return;
        }

        System.out.println("\n=== DANH SACH DU AN ===");
        System.out.printf("%-5s %-12s %-30s %-12s %-20s %-15s %-15s\n",
                "STT", "Ma DA", "Ten Du An", "Ma NS", "Nhan Su", "Ngay BD", "Ngay KT");
        System.out.println(
                "--------------------------------------------------------------------------------------------------------------------");

        for (int i = 0; i < soLuongDuAn; i++) {
            DUAN da = danhSachDuAn[i];
            String maNS = da.getNhanSu() != null ? da.getNhanSu().getMaNhanSu() : "Chua co";
            String tenNS = da.getNhanSu() != null ? da.getNhanSu().getHoTen() : "Chua co";

            System.out.printf("%-5d %-12s %-30s %-12s %-20s %-15s %-15s\n",
                    (i + 1),
                    da.getMaDuAn(),
                    truncate(da.getTenDuAn(), 30),
                    maNS,
                    truncate(tenNS, 20),
                    da.getNgayBatDau(),
                    da.getNgayKetThuc());
        }

        System.out.println(
                "--------------------------------------------------------------------------------------------------------------------");
    }

    // Sửa dự án
    public void suaDuAn() {
        System.out.print("\nNhap ma du an can sua: ");
        String maDuAn = sc.nextLine();

        DUAN duAn = null;
        for (int i = 0; i < soLuongDuAn; i++) {
            if (danhSachDuAn[i].getMaDuAn().equalsIgnoreCase(maDuAn)) {
                duAn = danhSachDuAn[i];
                break;
            }
        }

        if (duAn == null) {
            System.out.println("Khong tim thay du an!");
            return;
        }

        System.out.println("\n=== SUA THONG TIN DU AN ===");
        System.out.println("Thong tin hien tai:");
        System.out.printf("%-5s %-12s %-30s %-12s %-20s %-15s %-15s\n",
                "STT", "Ma DA", "Ten Du An", "Ma NS", "Nhan Su", "Ngay BD", "Ngay KT");
        System.out.println(
                "--------------------------------------------------------------------------------------------------------------------");
        String maNS = duAn.getNhanSu() != null ? duAn.getNhanSu().getMaNhanSu() : "Chua co";
        String tenNS = duAn.getNhanSu() != null ? duAn.getNhanSu().getHoTen() : "Chua co";
        System.out.printf("%-5d %-12s %-30s %-12s %-20s %-15s %-15s\n",
                1,
                duAn.getMaDuAn(),
                truncate(duAn.getTenDuAn(), 30),
                maNS,
                truncate(tenNS, 20),
                duAn.getNgayBatDau(),
                duAn.getNgayKetThuc());
        System.out.println(
                "--------------------------------------------------------------------------------------------------------------------");

        System.out.println("\nNhap thong tin moi (Enter de giu nguyen):");

        System.out.print("Ten du an moi: ");
        String tenDuAn = sc.nextLine();
        if (!tenDuAn.isEmpty()) {
            duAn.setTenDuAn(tenDuAn);
        }

        // Nhập ngày bắt đầu mới với validation
        String ngayBatDau;
        do {
            System.out.print("Ngay bat dau moi (dd/MM/yyyy, Enter de giu nguyen): ");
            ngayBatDau = sc.nextLine();

            if (ngayBatDau.isEmpty()) {
                break; // Giữ nguyên
            }

            if (ngayBatDau.matches("\\d{2}/\\d{2}/\\d{4}")) {
                duAn.setNgayBatDau(ngayBatDau);
                break;
            } else {
                System.out.println("Loi: Ngay bat dau phai co dinh dang dd/MM/yyyy!");
            }
        } while (true);

        // Nhập ngày kết thúc mới với validation
        String ngayKetThuc;
        do {
            System.out.print("Ngay ket thuc moi (dd/MM/yyyy, Enter de giu nguyen): ");
            ngayKetThuc = sc.nextLine();

            if (ngayKetThuc.isEmpty()) {
                break; // Giữ nguyên
            }

            if (ngayKetThuc.matches("\\d{2}/\\d{2}/\\d{4}")) {
                duAn.setNgayKetThuc(ngayKetThuc);
                break;
            } else {
                System.out.println("Loi: Ngay ket thuc phai co dinh dang dd/MM/yyyy!");
            }
        } while (true);

        System.out.print("Ma nhan su phu trach moi: ");
        String maNhanSu = sc.nextLine();
        if (!maNhanSu.isEmpty()) {
            NHANSU nhanSu = timKiemTheoMa(maNhanSu);
            if (nhanSu != null) {
                duAn.setNhanSu(nhanSu);
            } else {
                System.out.println("Khong tim thay nhan su! Giu nguyen nhan su cu.");
            }
        }

        System.out.println("Cap nhat du an thanh cong!");
    }

    // Xóa dự án
    public void xoaDuAn() {
        System.out.print("\nNhap ma du an can xoa: ");
        String maDuAn = sc.nextLine();

        int viTri = -1;
        for (int i = 0; i < soLuongDuAn; i++) {
            if (danhSachDuAn[i].getMaDuAn().equalsIgnoreCase(maDuAn)) {
                viTri = i;
                break;
            }
        }

        if (viTri == -1) {
            System.out.println("Khong tim thay du an!");
            return;
        }

        System.out.println("\n=== XOA DU AN ===");
        DUAN da = danhSachDuAn[viTri];
        System.out.printf("%-5s %-12s %-30s %-12s %-20s %-15s %-15s\n",
                "STT", "Ma DA", "Ten Du An", "Ma NS", "Nhan Su", "Ngay BD", "Ngay KT");
        System.out.println(
                "--------------------------------------------------------------------------------------------------------------------");
        String maNS = da.getNhanSu() != null ? da.getNhanSu().getMaNhanSu() : "Chua co";
        String tenNS = da.getNhanSu() != null ? da.getNhanSu().getHoTen() : "Chua co";
        System.out.printf("%-5d %-12s %-30s %-12s %-20s %-15s %-15s\n",
                1,
                da.getMaDuAn(),
                truncate(da.getTenDuAn(), 30),
                maNS,
                truncate(tenNS, 20),
                da.getNgayBatDau(),
                da.getNgayKetThuc());
        System.out.println(
                "--------------------------------------------------------------------------------------------------------------------");

        System.out.print("\nBan co chac chan muon xoa du an nay? (Y/N): ");
        String xacNhan = sc.nextLine();

        if (xacNhan.equalsIgnoreCase("Y")) {
            // Dịch các phần tử về trước
            for (int i = viTri; i < soLuongDuAn - 1; i++) {
                danhSachDuAn[i] = danhSachDuAn[i + 1];
            }
            danhSachDuAn[soLuongDuAn - 1] = null;
            soLuongDuAn--;
            System.out.println("Xoa du an thanh cong!");
        } else {
            System.out.println("Huy xoa du an.");
        }
    }

    // Tìm kiếm dự án
    public void timKiemDuAn() {
        System.out.println("\n=== TIM KIEM DU AN ===");
        System.out.println("1. Tim theo ma du an");
        System.out.println("2. Tim theo ten du an");
        System.out.println("3. Tim theo ma nhan su");
        System.out.print("Lua chon: ");

        int luaChon;
        try {
            luaChon = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Loi: Vui long nhap so!");
            return;
        }

        switch (luaChon) {
            case 1:
                timKiemDuAnTheoMa();
                break;
            case 2:
                timKiemDuAnTheoTen();
                break;
            case 3:
                hienThiDuAnCuaNhanSu();
                break;
            default:
                System.out.println("Lua chon khong hop le!");
        }
    }

    private void timKiemDuAnTheoMa() {
        System.out.print("Nhap ma du an: ");
        String maDuAn = sc.nextLine();

        for (int i = 0; i < soLuongDuAn; i++) {
            if (danhSachDuAn[i].getMaDuAn().equalsIgnoreCase(maDuAn)) {
                DUAN da = danhSachDuAn[i];
                System.out.println("\n=== THONG TIN DU AN ===");
                System.out.printf("%-5s %-12s %-30s %-12s %-20s %-15s %-15s\n",
                        "STT", "Ma DA", "Ten Du An", "Ma NS", "Nhan Su", "Ngay BD", "Ngay KT");
                System.out.println(
                        "--------------------------------------------------------------------------------------------------------------------");
                String maNS = da.getNhanSu() != null ? da.getNhanSu().getMaNhanSu() : "Chua co";
                String tenNS = da.getNhanSu() != null ? da.getNhanSu().getHoTen() : "Chua co";
                System.out.printf("%-5d %-12s %-30s %-12s %-20s %-15s %-15s\n",
                        1,
                        da.getMaDuAn(),
                        truncate(da.getTenDuAn(), 30),
                        maNS,
                        truncate(tenNS, 20),
                        da.getNgayBatDau(),
                        da.getNgayKetThuc());
                System.out.println(
                        "--------------------------------------------------------------------------------------------------------------------");
                return;
            }
        }
        System.out.println("Khong tim thay du an!");
    }

    private void timKiemDuAnTheoTen() {
        System.out.print("Nhap ten du an: ");
        String tenDuAn = sc.nextLine();

        System.out.println("\n=== KET QUA TIM KIEM ===");
        System.out.printf("%-5s %-12s %-30s %-12s %-20s %-15s %-15s\n",
                "STT", "Ma DA", "Ten Du An", "Ma NS", "Nhan Su", "Ngay BD", "Ngay KT");
        System.out.println(
                "--------------------------------------------------------------------------------------------------------------------");

        int stt = 0;
        for (int i = 0; i < soLuongDuAn; i++) {
            if (danhSachDuAn[i].getTenDuAn().toLowerCase().contains(tenDuAn.toLowerCase())) {
                DUAN da = danhSachDuAn[i];
                String maNS = da.getNhanSu() != null ? da.getNhanSu().getMaNhanSu() : "Chua co";
                String tenNS = da.getNhanSu() != null ? da.getNhanSu().getHoTen() : "Chua co";

                stt++;
                System.out.printf("%-5d %-12s %-30s %-12s %-20s %-15s %-15s\n",
                        stt,
                        da.getMaDuAn(),
                        truncate(da.getTenDuAn(), 30),
                        maNS,
                        truncate(tenNS, 20),
                        da.getNgayBatDau(),
                        da.getNgayKetThuc());
            }
        }

        System.out.println(
                "--------------------------------------------------------------------------------------------------------------------");

        if (stt == 0) {
            System.out.println("Khong tim thay du an nao!");
        }
    }

    // Thống kê dự án
    public void thongKeDuAn() {
        if (soLuongDuAn == 0) {
            System.out.println("\nChua co du an nao trong he thong!");
            return;
        }

        int daDuAnCoNguoi = 0;
        int duAnChuaCoNguoi = 0;

        for (int i = 0; i < soLuongDuAn; i++) {
            if (danhSachDuAn[i].getNhanSu() != null) {
                daDuAnCoNguoi++;
            } else {
                duAnChuaCoNguoi++;
            }
        }

        System.out.println("\n=== THONG KE DU AN ===");
        System.out.println("Tong so du an: " + soLuongDuAn);
        System.out.println("  - Du an da co nguoi phu trach: " + daDuAnCoNguoi);
        System.out.println("  - Du an chua co nguoi phu trach: " + duAnChuaCoNguoi);

        // Thống kê theo nhân sự
        System.out.println("\nThong ke theo nhan su:");
        for (int i = 0; i < soLuongNhanSu; i++) {
            int count = 0;
            for (int j = 0; j < soLuongDuAn; j++) {
                if (danhSachDuAn[j].getNhanSu() != null
                        && danhSachDuAn[j].getNhanSu().getMaNhanSu()
                                .equals(danhSachNhanSu[i].getMaNhanSu())) {
                    count++;
                }
            }
            if (count > 0) {
                System.out.println("  - " + danhSachNhanSu[i].getHoTen() + ": " + count + " du an");
            }
        }
    }

}
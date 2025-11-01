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

        System.out.print("Phong ban: ");
        String phongBan = sc.nextLine();

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

        try {
            switch (loai) {
                case 1:
                    System.out.print("So gio lam them: ");
                    double soGioLamThem = Double.parseDouble(sc.nextLine());
                    System.out.print("Don gia gio lam them: ");
                    double donGiaGioLamThem = Double.parseDouble(sc.nextLine());
                    nhanSu = new NHANVIENKYTHUAT(maNhanSu, hoTen, gioiTinh, diaChi, soDienThoai, email, luongCoBan,
                            heSoLuong, soGioLamThem, donGiaGioLamThem);
                    break;
                case 2:
                    nhanSu = new NHANVIENHANHCHINH(maNhanSu, hoTen, gioiTinh, diaChi, soDienThoai, email, luongCoBan,
                            heSoLuong);
                    break;
                case 3:
                    System.out.print("Phu cap: ");
                    double phuCap = Double.parseDouble(sc.nextLine());
                    nhanSu = new NHANVIENQUANLY(maNhanSu, hoTen, gioiTinh, diaChi, soDienThoai, email, luongCoBan,
                            heSoLuong, phuCap);
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
                    return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Loi: Gia tri nhap vao khong hop le!");
            return;
        }

        // set phong ban cho nhan su neu da nhap
        if (nhanSu != null) {
            PHONGBAN pb = new PHONGBAN();
            pb.setTenPhongBan(phongBan);
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

        System.out.print("So dien thoai moi (Enter de giu nguyen): ");
        String soDienThoai = sc.nextLine();
        if (!soDienThoai.isEmpty()) {
            nhanSu.setSoDienThoai(soDienThoai);
        }

        System.out.print("Email moi (Enter de giu nguyen): ");
        String email = sc.nextLine();
        if (!email.isEmpty()) {
            nhanSu.setEmail(email);
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
        System.out.printf("%-5s %-15s %-20s %-10s %-15s %-12s\n",
                "STT", "Ma", "Ho Ten", "Gioi Tinh", "Loai NS", "Luong", "Phong Ban");
        System.out.println(
                "-----------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < soLuongNhanSu; i++) {
            NHANSU ns = danhSachNhanSu[i];
            System.out.printf("%-5d %-15s %-20s %-10s %-15s %-12.2f %-15s\n",
                    (i + 1), ns.getMaNhanSu(), ns.getHoTen(), ns.getGioiTinh(),
                    ns.getLoaiNhanSu(), ns.tinhLuong(),
                    ns.getPhongBan() != null ? ns.getPhongBan().getTenPhongBan() : "Chua xac dinh");
        }
        System.out.println(
                "-------------------------------------------------------------------------------------------------------------------");
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
            System.out.println("\nThong tin nhan su:");
            nhanSu.hienThiThongTin();
            System.out.println("Loai nhan su: " + nhanSu.getLoaiNhanSu());
            System.out.println("Luong: " + nhanSu.tinhLuong());
        } else {
            System.out.println("Khong tim thay nhan su!");
        }
    }

    // Tìm kiếm theo tên
    private void timKiemTheoTen() {
        System.out.print("Nhap ten can tim: ");
        String ten = sc.nextLine();

        boolean timThay = false;
        System.out.println("\nKet qua tim kiem:");

        for (int i = 0; i < soLuongNhanSu; i++) {
            if (danhSachNhanSu[i].getHoTen().toLowerCase().contains(ten.toLowerCase())) {
                System.out.println("\nNhan su " + (i + 1) + ":");
                danhSachNhanSu[i].hienThiThongTin();
                System.out.println("Loai nhan su: " + danhSachNhanSu[i].getLoaiNhanSu());
                timThay = true;
            }
        }

        if (!timThay) {
            System.out.println("Khong tim thay nhan su nao!");
        }
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

        boolean timThay = false;
        System.out.println("\nDanh sach " + loaiNhanSu + ":");

        for (int i = 0; i < soLuongNhanSu; i++) {
            if (danhSachNhanSu[i].getLoaiNhanSu().equals(loaiNhanSu)) {
                System.out.println("\nNhan su " + (i + 1) + ":");
                danhSachNhanSu[i].hienThiThongTin();
                timThay = true;
            }
        }

        if (!timThay) {
            System.out.println("Khong tim thay nhan su nao!");
        }
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

}
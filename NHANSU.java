public abstract class NHANSU implements ITINHLUONG {
    private String maNhanSu;
    private String hoTen;
    private String gioiTinh;
    private String diaChi;
    private String soDienThoai;
    private String email;
    private String phongBan;
    private double luongCoBan;
    private double heSoLuong;

    public NHANSU() {

    }

    public NHANSU(String maNhanSu, String hoTen, String gioiTinh, String diaChi, String soDienThoai, String email,
            double heSoLuong) {
        this.maNhanSu = maNhanSu;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
        this.email = email;
    }

    public String getMaNhanSu() {
        return maNhanSu;
    }

    public void setMaNhanSu(String maNhanSu) {
        this.maNhanSu = maNhanSu;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhongBan() {
        return phongBan;
    }

    public void setPhongBan(String phongBan) {
        this.phongBan = phongBan;
    }

    public double getLuongCoBan() {
        return luongCoBan;
    }

    public void setLuongCoBan(double luongCoBan) {
        this.luongCoBan = luongCoBan;
    }

    public double getHeSoLuong() {
        return heSoLuong;
    }

    public void setHeSoLuong(double heSoLuong) {
        this.heSoLuong = heSoLuong;
    }

    public abstract double tinhLuong();

    public double tinhLuongThucNhan(int soNgayLam, double thuong) {
        double luongThang = (luongCoBan / 26) * soNgayLam;
        double luongThucNhan = luongThang + thuong;
        // danhSachLuongThang.add(luongThucNhan);
        return luongThucNhan;
    }

    public abstract String getLoaiNhanSu();

    public void hienThiThongTin() {
        System.out.println("Mã nhân sự: " + maNhanSu);
        System.out.println("Họ tên: " + hoTen);
        System.out.println("Giới tính: " + gioiTinh);
        System.out.println("Địa chỉ: " + diaChi);
        System.out.println("Số điện thoại: " + soDienThoai);
        System.out.println("Email: " + email);
        System.out.println("Phòng ban: " + phongBan);
        System.out.println("Lương cơ bản: " + luongCoBan);
    }
}
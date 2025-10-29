public abstract class NHANSU {
    private String maNhanSu;
    private String hoTen;
    private String gioiTinh;
    private String diaChi;
    private String soDienThoai;
    private String email;
    private PHONGBAN phongBan;
    private double luongCoBan;
    private double heSoLuong;

    public NHANSU() {

    }

    public NHANSU(String maNhanSu, String hoTen, String gioiTinh, String diaChi, String soDienThoai, String email,
            double luongCoBan, double heSoLuong) {
        this.maNhanSu = maNhanSu;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.luongCoBan = luongCoBan;
        this.heSoLuong = heSoLuong;
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

    public PHONGBAN getPhongBan() {
        return phongBan;
    }

    public void setPhongBan(PHONGBAN phongBan) {
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

    public abstract String getLoaiNhanSu();

    public void hienThiThongTin() {
        System.out.println("Ma nhan su: " + maNhanSu);
        System.out.println("Ho ten: " + hoTen);
        System.out.println("Gioi tinh: " + gioiTinh);
        System.out.println("Dia chi: " + diaChi);
        System.out.println("So dien thoai: " + soDienThoai);
        System.out.println("Email: " + email);
        System.out.println("Phong ban: " + (phongBan != null ? phongBan.getTenPhongBan() : "Chua phan cong"));
        System.out.printf("Luong co ban: %.2f\n", luongCoBan);
    }
}
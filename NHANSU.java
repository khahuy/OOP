public abstract class NHANSU {
    private String maNhanSu;
    private String hoTen;
    private String gioiTinh;
    private String diaChi;
    private String soDienThoai;
    private String email;
    private PhongBan phongBan;

    public NHANSU() {

    }

    public NHANSU(String maNhanSu, String hoTen, String gioiTinh, String diaChi, String soDienThoai, String email) {
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

    public PhongBan getPhongBan() {
        return phongBan;
    }

    public void setPhongBan(PhongBan phongBan) {
        this.phongBan = phongBan;
    }

    public abstract double tinhLuong();

    public abstract getLoaiNhanSu();

    public void hienThiThongTin() {
        System.out.println("Mã nhân sự: " + maNhanSu);
        System.out.println("Họ tên: " + hoTen);
        System.out.println("Giới tính: " + gioiTinh);
        System.out.println("Địa chỉ: " + diaChi);
        System.out.println("Số điện thoại: " + soDienThoai);
        System.out.println("Email: " + email);
        if (phongBan != null) {
            System.out.println("Phòng ban: " + phongBan.getTenPhongBan());
        } else {
            System.out.println("Phòng ban: Chưa được phân công");
        }
    }
}

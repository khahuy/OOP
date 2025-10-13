public class NHANVIENKYTHUAT extends NHANSU {
    private double luongCoBan;
    private double soGioLamThem;
    private double donGiaGioLamThem;

    public NHANVIENKYTHUAT() {

    }

    public NHANVIENKYTHUAT(String maNhanSu, String hoTen, String gioiTinh, String diaChi, String soDienThoai,
            String email, double luongCoBan, double soGioLamThem, double donGiaGioLamThem) {
        super(maNhanSu, hoTen, gioiTinh, diaChi, soDienThoai, email);
        this.luongCoBan = luongCoBan;
        this.soGioLamThem = soGioLamThem;
        this.donGiaGioLamThem = donGiaGioLamThem;
    }

    public double getLuongCoBan() {
        return luongCoBan;
    }

    public void setLuongCoBan(double luongCoBan) {
        this.luongCoBan = luongCoBan;
    }

    public double getSoGioLamThem() {
        return soGioLamThem;
    }

    public void setSoGioLamThem(double soGioLamThem) {
        this.soGioLamThem = soGioLamThem;
    }

    public double getDonGiaGioLamThem() {
        return donGiaGioLamThem;
    }

    public void setDonGiaGioLamThem(double donGiaGioLamThem) {
        this.donGiaGioLamThem = donGiaGioLamThem;
    }

    @Override
    public double tinhLuong() {
        return luongCoBan + (soGioLamThem * donGiaGioLamThem);
    }

    @Override
    public String getLoaiNhanSu() {
        return "Kỹ Thuật";
    }

}

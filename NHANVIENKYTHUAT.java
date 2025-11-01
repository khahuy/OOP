public class NHANVIENKYTHUAT extends NHANSU {
    private double soGioLamThem;
    private double donGiaGioLamThem;
    private HOPDONG hopDong;

    public NHANVIENKYTHUAT() {

    }

    public NHANVIENKYTHUAT(String maNhanSu, String hoTen, String gioiTinh, String diaChi, String soDienThoai,
            String email, double luongCoBan, double heSoLuong, double soGioLamThem, double donGiaGioLamThem) {
        super(maNhanSu, hoTen, gioiTinh, diaChi, soDienThoai, email, luongCoBan, heSoLuong);
        this.soGioLamThem = soGioLamThem;
        this.donGiaGioLamThem = donGiaGioLamThem;
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

    public HOPDONG getHopDong() {
        return hopDong;
    }

    public void setHopDong(HOPDONG hopDong) {
        this.hopDong = hopDong;
    }

    @Override
    public double tinhLuong() {
        return getLuongCoBan() * getHeSoLuong() + (soGioLamThem * donGiaGioLamThem);
    }

    @Override
    public String getLoaiNhanSu() {
        return "Ky Thuat";
    }

}

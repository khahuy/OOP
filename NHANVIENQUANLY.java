public class NHANVIENQUANLY extends NHANSU {
    private double phuCap;

    public NHANVIENQUANLY() {

    }

    public NHANVIENQUANLY(String maNhanSu, String hoTen, String gioiTinh, String diaChi, String soDienThoai,
            String email, double luongCoBan, double heSoLuong, double phuCap) {
        super(maNhanSu, hoTen, gioiTinh, diaChi, soDienThoai, email, luongCoBan, heSoLuong);
        this.phuCap = phuCap;
    }

    public double getPhuCap() {
        return phuCap;
    }

    public void setPhuCap(double phuCap) {
        this.phuCap = phuCap;
    }

    @Override
    public double tinhLuong() {
        return getLuongCoBan() * getHeSoLuong() + this.phuCap;
    }

    @Override
    public String getLoaiNhanSu() {
        return "Quan Ly";
    }
}
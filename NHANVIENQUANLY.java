public class NHANVIENQUANLY extends NHANSU {
    private double phuCap;
    private int soQuanLy;

    public NHANVIENQUANLY() {

    }

    public NHANVIENQUANLY(String maNhanSu, String hoTen, String gioiTinh, String diaChi, String soDienThoai,
            String email, double luongCoBan, double heSoLuong, double phuCap, int soQuanLy) {
        super(maNhanSu, hoTen, gioiTinh, diaChi, soDienThoai, email, luongCoBan, heSoLuong);
        this.phuCap = phuCap;
        this.soQuanLy = soQuanLy;
    }

    public double getPhuCap() {
        return phuCap;
    }

    public void setPhuCap(double phuCap) {
        this.phuCap = phuCap;
    }

    public int getSoQuanLy() {
        return soQuanLy;
    }

    public void setSoQuanLy(int soQuanLy) {
        this.soQuanLy = soQuanLy;
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
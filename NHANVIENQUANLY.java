public class NHANVIENQUANLY extends NHANSU {
    private double luongCoBan;
    private double phuCap;
    private int soQuanLy;

    public NHANVIENQUANLY() {

    }

    public NHANVIENQUANLY(String maNhanSu, String hoTen, String gioiTinh, String diaChi, String soDienThoai,
            String email, double luongCoBan, double heSoLuong, double phuCap, int soQuanLy) {
        super(maNhanSu, hoTen, gioiTinh, diaChi, soDienThoai, email, heSoLuong);
        this.luongCoBan = luongCoBan;
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

    public double getLuongCoBan() {
        return luongCoBan;
    }

    public void setLuongCoBan(double luongCoBan) {
        this.luongCoBan = luongCoBan;
    }

    @Override
    public double tinhLuong() {
        double phuCap = 5000000;
        return getLuongCoBan() * getHeSoLuong() + phuCap;
    }

    @Override
    public double tinhLuongThucNhan() {
        return tinhLuong();
    }

    @Override
    public String getLoaiNhanSu() {
        return "Quản Lý";
    }
}
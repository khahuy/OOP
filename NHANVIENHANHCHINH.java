public class NHANVIENHANHCHINH extends NHANSU {
    public NHANVIENHANHCHINH() {

    }

    public NHANVIENHANHCHINH(String maNhanSu, String hoTen, String gioiTinh, String diaChi, String soDienThoai,
            String email, double luongCoBan, double heSoLuong) {
        super(maNhanSu, hoTen, gioiTinh, diaChi, soDienThoai, email, luongCoBan, heSoLuong);
    }

    @Override
    public double tinhLuong() {
        return getLuongCoBan() * getHeSoLuong();
    }

    @Override
    public String getLoaiNhanSu() {
        return "Hanh Chinh";
    }
}

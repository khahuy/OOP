public class PHONGBAN {
    private String maPhongBan;
    private String tenPhongBan;
    private int soNhanVien;

    public PHONGBAN() {

    }

    public PHONGBAN(String maPhongBan, String tenPhongBan, int soNhanVien) {
        this.maPhongBan = maPhongBan;
        this.tenPhongBan = tenPhongBan;
        this.soNhanVien = soNhanVien;
    }

    public String getMaPhongBan() {
        return maPhongBan;
    }

    public void setMaPhongBan(String maPhongBan) {
        this.maPhongBan = maPhongBan;
    }

    public String getTenPhongBan() {
        return tenPhongBan;
    }

    public void setTenPhongBan(String tenPhongBan) {
        this.tenPhongBan = tenPhongBan;
    }

    public int getSoNhanVien() {
        return soNhanVien;
    }

    public void setSoNhanVien(int soNhanVien) {
        this.soNhanVien = soNhanVien;
    }

    public void hienThiThongTinPhongBan() {
        System.out.println("Ma phong ban: " + maPhongBan);
        System.out.println("Ten phong ban: " + tenPhongBan);
        System.out.println("So nhan vien: " + soNhanVien);
    }

}

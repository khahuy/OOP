public class HOPDONG {
    private String maHopDong;
    private String loaiHopDong;
    private String ngayBatDau;
    private String ngayKetThuc;
    private double mucLuong;

    public HOPDONG() {

    }

    public HOPDONG(String maHopDong, String loaiHopDong, String ngayBatDau, String ngayKetThuc, double mucLuong) {
        this.maHopDong = maHopDong;
        this.loaiHopDong = loaiHopDong;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.mucLuong = mucLuong;
    }

    public String getMaHopDong() {
        return maHopDong;
    }

    public void setMaHopDong(String maHopDong) {
        this.maHopDong = maHopDong;
    }

    public String getLoaiHopDong() {
        return loaiHopDong;
    }

    public void setLoaiHopDong(String loaiHopDong) {
        this.loaiHopDong = loaiHopDong;
    }

    public String getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(String ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public String getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(String ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public double getMucLuong() {
        return mucLuong;
    }

    public void setMucLuong(double mucLuong) {
        this.mucLuong = mucLuong;
    }

    public void hienThiThongTin() {
        System.out.println("Mã hợp đồng: " + maHopDong);
        System.out.println("Loại hợp đồng: " + loaiHopDong);
        System.out.println("Ngày bắt đầu: " + ngayBatDau);
        System.out.println("Ngày kết thúc: " + ngayKetThuc);
        System.out.println("Mức lương: " + mucLuong);
    }

}

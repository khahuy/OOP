public class HOPDONG {
    private String maHopDong;
    private String loaiHopDong;
    private String ngayBatDau;
    private String ngayKetThuc;

    public HOPDONG() {

    }

    public HOPDONG(String maHopDong, String loaiHopDong, String ngayBatDau, String ngayKetThuc) {
        this.maHopDong = maHopDong;
        this.loaiHopDong = loaiHopDong;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
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

    public void hienThiThongTin() {
        System.out.println("Ma hop dong: " + maHopDong);
        System.out.println("Loai hop dong: " + loaiHopDong);
        System.out.println("Ngay bat dau: " + ngayBatDau);
        System.out.println("Ngay ket thuc: " + ngayKetThuc);
    }

}

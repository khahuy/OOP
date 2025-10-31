public class HOPDONG {
    private String maHopDong;
    private String loaiHopDong;
    private String ngayBatDau;
    private String ngayKetThuc;
    private NHANVIENHANHCHINH nhanvienhanhchinh;
    private NHANVIENKYTHUAT nhanvienkythuat;
    private NHANVIENQUANLY nhanvienquanly;

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

    public NHANVIENHANHCHINH getNhanvienhanhchinh() {
        return nhanvienhanhchinh;
    }

    public void setNhanvienhanhchinh(NHANVIENHANHCHINH nhanvienhanhchinh) {
        this.nhanvienhanhchinh = nhanvienhanhchinh;
        this.nhanvienkythuat = null;
        this.nhanvienquanly = null;
    }

    public NHANVIENKYTHUAT getNhanvienkythuat() {
        return nhanvienkythuat;
    }

    public void setNhanvienkythuat(NHANVIENKYTHUAT nhanvienkythuat) {
        this.nhanvienkythuat = nhanvienkythuat;
        this.nhanvienhanhchinh = null;
        this.nhanvienquanly = null;
    }

    public NHANVIENQUANLY getNhanvienquanly() {
        return nhanvienquanly;
    }

    public void setNhanvienquanly(NHANVIENQUANLY nhanvienquanly) {
        this.nhanvienquanly = nhanvienquanly;
        this.nhanvienhanhchinh = null;
        this.nhanvienkythuat = null;
    }

    public NHANSU getNhanVien() {
        if (nhanvienhanhchinh != null)
            return nhanvienhanhchinh;
        if (nhanvienkythuat != null)
            return nhanvienkythuat;
        if (nhanvienquanly != null)
            return nhanvienquanly;
        return null;
    }

    public void hienThiThongTin() {
        System.out.println("Ma hop dong: " + maHopDong);
        System.out.println("Loai hop dong: " + loaiHopDong);
        System.out.println("Ngay bat dau: " + ngayBatDau);
        System.out.println("Ngay ket thuc: " + ngayKetThuc);

        NHANSU nv = getNhanVien();
        if (nv != null) {
            System.out.println("Nhan vien: " + nv.getHoTen() + " (" + nv.getLoaiNhanSu() + ")");
        } else {
            System.out.println("Nhan vien: Chua co");
        }
    }

}

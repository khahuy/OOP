public class DUAN {
    public String maDuAn;
    public String tenDuAn;
    public String ngayBatDau;
    public String ngayKetThuc;

    public DUAN() {

    }

    public DUAN(String maDuAn, String tenDuAn, String ngayBatDau, String ngayKetThuc) {
        this.maDuAn = maDuAn;
        this.tenDuAn = tenDuAn;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
    }

    public String getMaDuAn() {
        return maDuAn;
    }

    public void setMaDuAn(String maDuAn) {
        this.maDuAn = maDuAn;
    }

    public String getTenDuAn() {
        return tenDuAn;
    }

    public void setTenDuAn(String tenDuAn) {
        this.tenDuAn = tenDuAn;
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
        System.out.println("Mã Dự Án: " + maDuAn);
        System.out.println("Tên Dự Án: " + tenDuAn);
        System.out.println("Ngày Bắt Đầu: " + ngayBatDau);
        System.out.println("Ngày Kết Thúc: " + ngayKetThuc);
    }
}

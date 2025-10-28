public class LICHLAMVIEC {
    private String maLich;
    private String ngayLamViec;
    private String caLamViec;
    private DUAN duAn; // Liên kết với DUAN

    public LICHLAMVIEC() {

    }

    public LICHLAMVIEC(String maLich, String ngayLamViec, String caLamViec, DUAN duAn) {
        this.maLich = maLich;
        this.ngayLamViec = ngayLamViec;
        this.caLamViec = caLamViec;
        this.duAn = duAn;
    }

    public String getMaLich() {
        return maLich;
    }

    public void setMaLich(String maLich) {
        this.maLich = maLich;
    }

    public String getNgayLamViec() {
        return ngayLamViec;
    }

    public void setNgayLamViec(String ngayLamViec) {
        this.ngayLamViec = ngayLamViec;
    }

    public String getCaLamViec() {
        return caLamViec;
    }

    public void setCaLamViec(String caLamViec) {
        this.caLamViec = caLamViec;
    }

    public DUAN getDuAn() {
        return duAn;
    }

    public void setDuAn(DUAN duAn) {
        this.duAn = duAn;
    }

    public void hienThiThongTin() {
        System.out.println("Mã lịch: " + maLich);
        System.out.println("Ngày làm việc: " + ngayLamViec);
        System.out.println("Ca làm việc: " + caLamViec);
        if (duAn != null) {
            System.out.println("Dự án: " + duAn.getTenDuAn());
        }
    }

}

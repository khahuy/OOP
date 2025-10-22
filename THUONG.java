public class THUONG {
    private String loaiThuong;
    private double soTien;
    private String lyDo;

    public THUONG() {

    }

    public THUONG(String loaiThuong, double soTien, String lyDo) {
        this.loaiThuong = loaiThuong;
        this.soTien = soTien;
        this.lyDo = lyDo;
    }

    public String getLoaiThuong() {
        return loaiThuong;
    }

    public void setLoaiThuong(String loaiThuong) {
        this.loaiThuong = loaiThuong;
    }

    public double getSoTien() {
        return soTien;
    }

    public void setSoTien(double soTien) {
        this.soTien = soTien;
    }

    public String getLyDo() {
        return lyDo;
    }

    public void setLyDo(String LyDo) {
        this.lyDo = lyDo;
    }

}

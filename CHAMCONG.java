public class CHAMCONG {
    private String maChamCong;
    private int soNgayLamViec;
    private int soNgayNghi;

    public CHAMCONG() {

    }

    public CHAMCONG(String maChamCong, int soNgayLamViec, int soNgayNghi) {
        this.maChamCong = maChamCong;
        this.soNgayLamViec = soNgayLamViec;
        this.soNgayNghi = soNgayNghi;
    }

    public String getMaChamCong() {
        return maChamCong;
    }

    public void setMaChamCong(String maChamCong) {
        this.maChamCong = maChamCong;
    }

    public int getSoNgayLamViec() {
        return soNgayLamViec;
    }

    public void setSoNgayLamViec(int soNgayLamViec) {
        this.soNgayLamViec = soNgayLamViec;
    }

    public int getSoNgayNghi() {
        return soNgayNghi;
    }

    public void setSoNgayNghi(int soNgayNghi) {
        this.soNgayNghi = soNgayNghi;
    }

}

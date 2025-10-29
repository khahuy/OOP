public class BANGLUONG implements ITINHLUONG {
    private NHANSU nhanSu;
    private String maBangLuong;
    private THUONG thuong;
    private double luongThucNhan;
    private BAOHIEM baoHiem;
    private CHAMCONG chamCong;

    public BANGLUONG() {

    }

    public BANGLUONG(NHANSU nhanSu, String maBangLuong, THUONG thuong, double luongThucNhan,
            BAOHIEM baoHiem, CHAMCONG chamCong) {
        this.nhanSu = nhanSu;
        this.maBangLuong = maBangLuong;
        this.thuong = thuong;
        this.luongThucNhan = luongThucNhan;
        this.baoHiem = baoHiem;
        this.chamCong = chamCong;
    }

    public NHANSU getNhanSu() {
        return nhanSu;
    }

    public void setNhanSu(NHANSU nhanSu) {
        this.nhanSu = nhanSu;
    }

    public String getMaBangLuong() {
        return maBangLuong;
    }

    public void setMaBangLuong(String maBangLuong) {
        this.maBangLuong = maBangLuong;
    }

    public double getThuong() {
        return thuong.getSoTien();
    }

    public void setThuong(THUONG thuong) {
        this.thuong = thuong;
    }

    public double getLuongThucNhan() {
        return luongThucNhan;
    }

    public void setLuongThucNhan(double luongThucNhan) {
        this.luongThucNhan = luongThucNhan;
    }

    public double getBaoHiem() {
        return baoHiem.getPhiBaoHiem();
    }

    public void setBaoHiem(BAOHIEM baoHiem) {
        this.baoHiem = baoHiem;
    }

    public CHAMCONG getChamCong() {
        return chamCong;
    }

    public void setChamCong(CHAMCONG chamCong) {
        this.chamCong = chamCong;
    }

    @Override
    public double tinhLuongThucNhan() {
        double luongCoBan = (nhanSu != null) ? nhanSu.tinhLuong() : 0.0;
        double phiBaoHiem = (baoHiem != null) ? baoHiem.getPhiBaoHiem() : 0.0;
        int soNgayLam = (chamCong != null) ? chamCong.getSoNgayLamViec() : 0;
        double soTienThuong = (thuong != null) ? thuong.tinhThuong() : 0.0;
        double luongThang = (luongCoBan / 26) * soNgayLam;
        luongThucNhan = luongThang + soTienThuong - phiBaoHiem;
        return luongThucNhan;
    }

    public void hienThiThongTin() {
        System.out.println("Ma bang luong: " + maBangLuong);
        System.out.println("Nhan su: " + nhanSu.getMaNhanSu());
        System.out.println("Luong co ban: " + nhanSu.getLuongCoBan());
        System.out.println("Thuong: " + (thuong != null ? thuong.getSoTien() : 0.0));
        System.out.println("Bao hiem: " + baoHiem.getPhiBaoHiem());
        System.out.println("Luong thuc nhan: " + luongThucNhan);
    }
}

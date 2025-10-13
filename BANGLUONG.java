public class BANGLUONG {
    private NHANSU nhanSu;
    private String maBangLuong;
    private double luongCoBan;
    private double thuong;
    private double luongThucNhan;
    private double baoHiem;

    public BANGLUONG() {

    }

    public BANGLUONG(NHANSU nhanSu, String maBangLuong, double luongCoBan, double thuong, double luongThucNhan,
            double baoHiem) {
        this.nhanSu = nhanSu;
        this.maBangLuong = maBangLuong;
        this.luongCoBan = luongCoBan;
        this.thuong = thuong;
        this.luongThucNhan = luongThucNhan;
        this.baoHiem = baoHiem;
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

    public double getLuongCoBan() {
        return luongCoBan;
    }

    public void setLuongCoBan(double luongCoBan) {
        this.luongCoBan = luongCoBan;
    }

    public double getThuong() {
        return thuong;
    }

    public void setThuong(double thuong) {
        this.thuong = thuong;
    }

    public double getLuongThucNhan() {
        return luongThucNhan;
    }

    public void setLuongThucNhan(double luongThucNhan) {
        this.luongThucNhan = luongThucNhan;
    }

    public double getBaoHiem() {
        return baoHiem;
    }

    public void setBaoHiem(double baoHiem) {
        this.baoHiem = baoHiem;
    }

    public void tinhLuongThucNhan() {
        luongThucNhan = luongCoBan + thuong - baoHiem;
    }

    public void hienThiThongTin() {
        System.out.println("Mã bảng lương: " + maBangLuong);
        if (nhanSu != null) {
            System.out.println("Thông tin nhân sự:");
            nhanSu.hienThiThongTin();
        } else {
            System.out.println("Nhân sự: null");
        }
        System.out.println("Lương cơ bản: " + luongCoBan);
        System.out.println("Thưởng: " + thuong);
        System.out.println("Bảo hiểm: " + baoHiem);
        System.out.println("Lương thực nhận: " + luongThucNhan);
    }
}

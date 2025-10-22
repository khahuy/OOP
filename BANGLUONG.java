public class BANGLUONG implements ITINHLUONG {
    private String manhanSu;
    private String maBangLuong;
    private double luongCoBan;
    private double thuong;
    private double luongThucNhan;
    private double baoHiem;

    public BANGLUONG() {

    }

    public BANGLUONG(String manhanSu, String maBangLuong, double luongCoBan, double thuong, double luongThucNhan,
            double baoHiem) {
        this.manhanSu = manhanSu;
        this.maBangLuong = maBangLuong;
        this.luongCoBan = luongCoBan;
        this.thuong = thuong;
        this.luongThucNhan = luongThucNhan;
        this.baoHiem = baoHiem;
    }

    public String getManhanSu() {
        return manhanSu;
    }

    public void setManhanSu(String manhanSu) {
        this.manhanSu = manhanSu;
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

    @Override
    public double tinhLuongThucNhan() {
        return luongThucNhan;
    }

    public void tinhLuongThucNhan(int soNgayLam) {
        double luongThang = (luongCoBan / 26) * soNgayLam;
        luongThucNhan = luongThang + thuong - baoHiem;
    }

    public void hienThiThongTin() {
        System.out.println("Mã bảng lương: " + maBangLuong);
        // if (nhanSu != null) {
        // System.out.println("Thông tin nhân sự:");
        // nhanSu.hienThiThongTin();
        // } else {
        // System.out.println("Nhân sự: null");
        // }
        System.out.println("Nhân sự: " + manhanSu);
        System.out.println("Lương cơ bản: " + luongCoBan);
        System.out.println("Thưởng: " + thuong);
        System.out.println("Bảo hiểm: " + baoHiem);
        System.out.println("Lương thực nhận: " + luongThucNhan);
    }
}

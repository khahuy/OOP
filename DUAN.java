public class DUAN {
    private NHANSU nhanSu;
    private String maDuAn;
    private String tenDuAn;
    private String ngayBatDau;
    private String ngayKetThuc;
    private LICHLAMVIEC lichLamViec; // Liên kết 2 chiều với LICHLAMVIEC

    public DUAN() {

    }

    public DUAN(NHANSU nhanSu, String maDuAn, String tenDuAn, String ngayBatDau, String ngayKetThuc) {
        this.nhanSu = nhanSu;
        this.maDuAn = maDuAn;
        this.tenDuAn = tenDuAn;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
    }

    public NHANSU getNhanSu() {
        return nhanSu;
    }

    public void setNhanSu(NHANSU nhanSu) {
        this.nhanSu = nhanSu;
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

    public LICHLAMVIEC getLichLamViec() {
        return lichLamViec;
    }

    public void setLichLamViec(LICHLAMVIEC lichLamViec) {
        this.lichLamViec = lichLamViec;
    }

    public void hienThiThongTin() {
        if (nhanSu != null) {
            System.out.println("Ma Nhan Su: " + nhanSu.getMaNhanSu());
            System.out.println("Ten Nhan Su: " + nhanSu.getHoTen());
        } else {
            System.out.println("Chua co nhan vien");
        }
        System.out.println("Ma Du An: " + maDuAn);
        System.out.println("Ten Du An: " + tenDuAn);
        System.out.println("Ngay Bat Dau: " + ngayBatDau);
        System.out.println("Ngay Ket Thuc: " + ngayKetThuc);
        if (lichLamViec != null) {
            System.out.println("Lich lam viec: " + lichLamViec.getNgayLamViec() + " - " + lichLamViec.getCaLamViec());
        }
    }
}

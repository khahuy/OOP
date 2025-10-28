public class BAOCAO {
    private String maBaoCao;
    private String loaiBaoCao;
    private String noiDung;
    private String ngayLap;
    private NHANVIENQUANLY nhanVienQuanLy; // Liên kết với NHANVIENQUANLY
    private KYLUAT kyLuat; // Liên kết 2 chiều với KYLUAT

    public BAOCAO() {

    }

    public BAOCAO(String maBaoCao, String loaiBaoCao, String noiDung, String ngayLap, NHANVIENQUANLY nhanVienQuanLy) {
        this.maBaoCao = maBaoCao;
        this.loaiBaoCao = loaiBaoCao;
        this.noiDung = noiDung;
        this.ngayLap = ngayLap;
        this.nhanVienQuanLy = nhanVienQuanLy;
    }

    public String getMaBaoCao() {
        return maBaoCao;
    }

    public void setMaBaoCao(String maBaoCao) {
        this.maBaoCao = maBaoCao;
    }

    public String getLoaiBaoCao() {
        return loaiBaoCao;
    }

    public void setLoaiBaoCao(String loaiBaoCao) {
        this.loaiBaoCao = loaiBaoCao;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(String ngayLap) {
        this.ngayLap = ngayLap;
    }

    public NHANVIENQUANLY getNhanVienQuanLy() {
        return nhanVienQuanLy;
    }

    public void setNhanVienQuanLy(NHANVIENQUANLY nhanVienQuanLy) {
        this.nhanVienQuanLy = nhanVienQuanLy;
    }

    public KYLUAT getKyLuat() {
        return kyLuat;
    }

    public void setKyLuat(KYLUAT kyLuat) {
        this.kyLuat = kyLuat;
    }

    // Lập báo cáo từ thông tin kỷ luật
    public void lapBaoCaoKyLuat(KYLUAT kyLuat) {
        this.kyLuat = kyLuat;
        if (kyLuat != null) {
            NHANSU nv = kyLuat.getNhanVienBiKyLuat();
            this.noiDung = "Báo cáo kỷ luật nhân viên\n" +
                    "Nhân viên: " + (nv != null ? nv.getHoTen() : "N/A") + "\n" +
                    "Hình thức: " + kyLuat.getHinhThuc() + "\n" +
                    "Lý do: " + kyLuat.getLyDo() + "\n" +
                    "Ngày kỷ luật: " + kyLuat.getNgayKyLuat();
        }
    }

    public void hienThiThongTin() {
        System.out.println("Mã báo cáo: " + maBaoCao);
        System.out.println("Loại báo cáo: " + loaiBaoCao);
        System.out.println("Nội dung: " + noiDung);
        System.out.println("Ngày lập: " + ngayLap);
        if (nhanVienQuanLy != null) {
            System.out.println("Người lập: " + nhanVienQuanLy.getHoTen() + " (Quản lý)");
        }
        if (kyLuat != null) {
            System.out.println("Liên quan kỷ luật: " + kyLuat.getHinhThuc());
        }
    }

}

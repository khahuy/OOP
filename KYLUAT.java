public class KYLUAT {
    private String hinhThuc;
    private String lyDo;
    private String ngayKyLuat;
    private BAOCAO baoCao; // Liên kết với BAOCAO
    private NHANSU nhanSu; // Nhân viên bị kỷ luật (quan hệ Association)

    public KYLUAT() {

    }

    public KYLUAT(String hinhThuc, String lyDo, String ngayKyLuat, BAOCAO baoCao, NHANSU nhanSu) {
        this.hinhThuc = hinhThuc;
        this.lyDo = lyDo;
        this.ngayKyLuat = ngayKyLuat;
        this.baoCao = baoCao;
        this.nhanSu = nhanSu;
    }

    public String getHinhThuc() {
        return hinhThuc;
    }

    public void setHinhThuc(String hinhThuc) {
        this.hinhThuc = hinhThuc;
    }

    public String getLyDo() {
        return lyDo;
    }

    public void setLyDo(String lyDo) {
        this.lyDo = lyDo;
    }

    public String getNgayKyLuat() {
        return ngayKyLuat;
    }

    public void setNgayKyLuat(String ngayKyLuat) {
        this.ngayKyLuat = ngayKyLuat;
    }

    public BAOCAO getBaoCao() {
        return baoCao;
    }

    public void setBaoCao(BAOCAO baoCao) {
        this.baoCao = baoCao;
    }

    public NHANSU getNhanSu() {
        return nhanSu;
    }

    public void setNhanSu(NHANSU nhanSu) {
        this.nhanSu = nhanSu;
    }

    // Lấy nhân viên bị kỷ luật
    public NHANSU getNhanVienBiKyLuat() {
        return nhanSu;
    }

    public void hienThiThongTin() {
        System.out.println("Hình thức kỷ luật: " + hinhThuc);
        System.out.println("Lý do: " + lyDo);
        System.out.println("Ngày kỷ luật: " + ngayKyLuat);

        // Hiển thị nhân viên bị kỷ luật
        if (nhanSu != null) {
            System.out.println("Nhân viên bị kỷ luật: " + nhanSu.getHoTen() + " (" + nhanSu.getLoaiNhanSu() + ")");
        }

        if (baoCao != null) {
            System.out.println("Liên quan báo cáo: " + baoCao.getMaBaoCao());
            System.out.println("Người lập báo cáo: " + baoCao.getNhanVienQuanLy().getHoTen());
        }
    }

}

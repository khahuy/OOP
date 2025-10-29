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
        System.out.println("Hinh thuc ky luat: " + hinhThuc);
        System.out.println("Ly do: " + lyDo);
        System.out.println("Ngay ky luat: " + ngayKyLuat);

        // Hiển thị nhân viên bị kỷ luật
        if (nhanSu != null) {
            System.out.println("Nhan vien bi ky luat: " + nhanSu.getHoTen() + " (" + nhanSu.getLoaiNhanSu() + ")");
        }

        if (baoCao != null) {
            System.out.println("Lien quan bao cao: " + baoCao.getMaBaoCao());
            System.out.println("Nguoi lap bao cao: " + baoCao.getNhanVienQuanLy().getHoTen());
        }
    }

}

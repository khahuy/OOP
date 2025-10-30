public class VAITRO {
    private String tenVaiTro;
    private String moTa;
    private DUAN duAn; // Liên kết với DUAN

    public VAITRO() {

    }

    public VAITRO(String tenVaiTro, String moTa, DUAN duAn) {
        this.tenVaiTro = tenVaiTro;
        this.moTa = moTa;
        this.duAn = duAn;
    }

    public String getTenVaiTro() {
        return tenVaiTro;
    }

    public void setTenVaiTro(String tenVaiTro) {
        this.tenVaiTro = tenVaiTro;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public DUAN getDuAn() {
        return duAn;
    }

    public void setDuAn(DUAN duAn) {
        this.duAn = duAn;
    }

    public void hienThiThongTin() {
        System.out.println("Tên vai trò: " + tenVaiTro);
        System.out.println("Mô tả: " + moTa);
        if (duAn != null) {
            System.out.println("Dự án: " + duAn.getTenDuAn());
        }
    }
}

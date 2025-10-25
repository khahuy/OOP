public class BAOHIEM {
    private String maBaoHiem;
    private String loaiBaoHiem;
    private double phiBaoHiem;

    public BAOHIEM() {

    }

    public BAOHIEM(String maBaoHiem, String loaiBaoHiem, double phiBaoHiem) {
        this.maBaoHiem = maBaoHiem;
        this.loaiBaoHiem = loaiBaoHiem;
        this.phiBaoHiem = phiBaoHiem;
    }

    public String getMaBaoHiem() {
        return maBaoHiem;
    }

    public void setMaBaoHiem(String maBaoHiem) {
        this.maBaoHiem = maBaoHiem;
    }

    public String getLoaiBaoHiem() {
        return loaiBaoHiem;
    }

    public void setLoaiBaoHiem(String loaiBaoHiem) {
        this.loaiBaoHiem = loaiBaoHiem;
    }

    public double getPhiBaoHiem() {
        return phiBaoHiem;
    }

    public void setPhiBaoHiem(double phiBaoHiem) {
        this.phiBaoHiem = phiBaoHiem;
    }

    public double tinhPhiBaoHiem() {
        return phiBaoHiem;
    }
}

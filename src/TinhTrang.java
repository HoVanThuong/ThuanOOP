public enum TinhTrang {
    CONBENH("Con Benh"),   HETBENH("Het Benh"), CHUARO("Chua Ro");
    private String tinhTrang;
    TinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }
    public String getTinhTrang() {
        return tinhTrang;
    }
}

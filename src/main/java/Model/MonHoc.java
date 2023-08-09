package Model;

public class MonHoc {
    private String TiengAnh;
    private String NguVan;
    private String ToanHoc;
    private String LichSu;
    public MonHoc(){
        super();
    }
    public MonHoc(String TiengAnh,String NguVan,String ToanHoc,String LichSu){
        super();
        this.TiengAnh=TiengAnh;
        this.NguVan=NguVan;
        this.ToanHoc=ToanHoc;
        this.LichSu=LichSu;
    }

    public String getTiengAnh() {
        return TiengAnh;
    }

    public void setTiengAnh(String tiengAnh) {
        TiengAnh = tiengAnh;
    }

    public String getNguVan() {
        return NguVan;
    }

    public void setNguVan(String nguVan) {
        NguVan = nguVan;
    }

    public String getToanHoc() {
        return ToanHoc;
    }

    public void setToanHoc(String toanHoc) {
        ToanHoc = toanHoc;
    }

    public String getLichSu() {
        return LichSu;
    }

    public void setLichSu(String lichSu) {
        LichSu = lichSu;
    }

    @Override
    public String toString() {
        return "MonHoc{" +
                "TiengAnh='" + TiengAnh + '\'' +
                ", NguVan='" + NguVan + '\'' +
                ", ToanHoc='" + ToanHoc + '\'' +
                ", LichSu='" + LichSu + '\'' +
                '}';
    }
}

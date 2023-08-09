package Model;

public class DanhSachSinhVien {
    private String Ten;
    private int Tuoi;
    private String DiaChi;
    private String HanhKiem;
    private int Diem;
    public DanhSachSinhVien  ( ){
        super();
    }
    public DanhSachSinhVien (String Ten,int Tuoi,String DiaChi,String HanhKiem,int Diem ){
        super();
        this.Ten=Ten;
        this.Tuoi=Tuoi;
        this.DiaChi=DiaChi;
        this.HanhKiem=HanhKiem;
        this.Diem=Diem;

    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        this.Ten=ten;
    }

    public int getTuoi() {
        return Tuoi;
    }

    public void setTuoi(int tuoi) {
        this.Tuoi = tuoi;
    }

    public String getDiachi() {
        return DiaChi;
    }

    public void setDiachi(String diachi) {
        this.DiaChi = diachi;
    }

    public String getHanhkiem() {
        return HanhKiem;
    }

    public void setHanhkiem(String hanhkiem) {
        this.HanhKiem = hanhkiem;
    }

    public int getDiem() {
        return Diem;
    }

    public void setDiem(int diem) {
        this.Diem = diem;
    }

    @Override
    public String toString() {
        return "danhsachsv{" +
                "ten='" + Ten + '\'' +
                ", tuoi=" + Tuoi +
                ", diachi='" + DiaChi + '\'' +
                ", hanhkiem='" + HanhKiem + '\'' +
                ", diem=" + Diem +
                '}';
    }
}

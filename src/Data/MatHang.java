/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

/**
 *
 * @author Lenovo
 */
public class MatHang {
    public String MaMH;
    public String TenMH;
    public int GiaBan;
    public String DVT;
    public String MaLoai;
    public String MoTa;
    public boolean VoHieuHoa;

    public MatHang(String MaMH, String TenMH, int GiaBan, String DVT, String MaLoai, String MoTa, boolean VoHieuHoa) {
        this.MaMH = MaMH;
        this.TenMH = TenMH;
        this.GiaBan = GiaBan;
        this.DVT = DVT;
        this.MaLoai = MaLoai;
        this.MoTa = MoTa;
        this.VoHieuHoa = VoHieuHoa;
    }

    public String getMaMH() {
        return MaMH;
    }

    public void setMaMH(String MaMH) {
        this.MaMH = MaMH;
    }

    public String getTenMH() {
        return TenMH;
    }

    public void setTenMH(String TenMH) {
        this.TenMH = TenMH;
    }

    public int getGiaBan() {
        return GiaBan;
    }

    public void setGiaBan(int GiaBan) {
        this.GiaBan = GiaBan;
    }

    public String getDVT() {
        return DVT;
    }

    public void setDVT(String DVT) {
        this.DVT = DVT;
    }

    public String getMaLoai() {
        return MaLoai;
    }

    public void setMaLoai(String MaLoai) {
        this.MaLoai = MaLoai;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }

    public boolean isVoHieuHoa() {
        return VoHieuHoa;
    }

    public void setVoHieuHoa(boolean VoHieuHoa) {
        this.VoHieuHoa = VoHieuHoa;
    }
}

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
public class UserAccount {
    public String MaNhanVien;
    public String TenDangNhap;
    public String MatKhau;
    public boolean LaQuanLy;

    
    public UserAccount(String MaNhanVien, String TenDangNhap, String MatKhau, boolean LaQuanLy) {
        this.MaNhanVien = MaNhanVien;
        this.TenDangNhap = TenDangNhap;
        this.MatKhau = MatKhau;
        this.LaQuanLy = LaQuanLy;
    }
    
    public String getMaNhanVien() {
        return MaNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.MaNhanVien = maNhanVien;
    }

    public String getTenDangNhap() {
        return TenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.TenDangNhap = tenDangNhap;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String matKhau) {
        this.MatKhau = matKhau;
    }

    public boolean isLaQuanLy() {
        return LaQuanLy;
    }

    public void setLaQuanLy(boolean laQuanLy) {
        this.LaQuanLy = laQuanLy;
    }
}
    
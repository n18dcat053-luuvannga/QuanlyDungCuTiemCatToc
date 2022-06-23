/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mathang;

import java.util.Date;

/**
 *
 * @author DELL
 */
public class LichSuHu {
    private Date ngayHu;
    private int soLuongHu;
    private String idMatHang;
    
    public LichSuHu(){}
    public LichSuHu(String id, int soLuong, Date ngay){
        this.idMatHang = id;
        this.soLuongHu = soLuong;
        this.ngayHu = ngay;
    }

    public Date getNgayHu() {
        return ngayHu;
    }

    public void setNgayHu(Date ngayHu) {
        this.ngayHu = ngayHu;
    }

    public int getSoLuongHu() {
        return soLuongHu;
    }

    public void setSoLuongHu(int soLuongHu) {
        this.soLuongHu = soLuongHu;
    }

    public String getIdMatHang() {
        return idMatHang;
    }

    public void setIdMatHang(String idMatHang) {
        this.idMatHang = idMatHang;
    }        
}

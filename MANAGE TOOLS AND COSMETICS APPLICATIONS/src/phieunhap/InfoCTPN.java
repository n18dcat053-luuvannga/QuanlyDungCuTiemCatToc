/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phieunhap;

import java.math.BigDecimal;

/**
 *
 * @author DELL
 */
public class InfoCTPN {
    private String idmathang;
    private String tenmathang;
    private int soLuong;
    private BigDecimal gia;

    public InfoCTPN() {
    }

    public String getIdmathang() {
        return idmathang;
    }

    public void setIdmathang(String idmathang) {
        this.idmathang = idmathang;
    }

    public String getTenmathang() {
        return tenmathang;
    }

    public void setTenmathang(String tenmathang) {
        this.tenmathang = tenmathang;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public BigDecimal getGia() {
        return gia;
    }

    public void setGia(BigDecimal gia) {
        this.gia = gia;
    }
    
}

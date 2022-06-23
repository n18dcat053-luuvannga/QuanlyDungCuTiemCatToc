/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ctphieunhap;

import java.math.BigDecimal;

/**
 *
 * @author DELL
 */
public class CTPhieuNhap {
    private String idPN;
    private String idMH;
    private int soLuong;
    private BigDecimal gia;

    public CTPhieuNhap(String idPN, String idMH, int soLuong, BigDecimal gia) {
        this.idPN = idPN;
        this.idMH = idMH;
        this.soLuong = soLuong;
        this.gia = gia;
    }

   
    public CTPhieuNhap() {
    }

    public String getIdPN() {
        return idPN;
    }

    public void setIdPN(String idPN) {
        this.idPN = idPN;
    }

    public String getIdMH() {
        return idMH;
    }

    public void setIdMH(String idMH) {
        this.idMH = idMH;
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

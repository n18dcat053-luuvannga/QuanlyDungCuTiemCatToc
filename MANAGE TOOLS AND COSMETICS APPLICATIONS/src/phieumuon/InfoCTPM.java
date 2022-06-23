/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phieumuon;

import phieunhap.*;
import java.math.BigDecimal;

/**
 *
 * @author DELL
 */
public class InfoCTPM {
    private String idmathang;
    private String tenmathang;
    private int soLuong;

    public InfoCTPM() {
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
}

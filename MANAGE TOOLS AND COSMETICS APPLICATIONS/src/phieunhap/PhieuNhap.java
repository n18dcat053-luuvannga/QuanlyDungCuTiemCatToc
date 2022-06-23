/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phieunhap;

import java.util.Date;

/**
 *
 * @author DELL
 */
public class PhieuNhap {
    private String idPN;
    private Date ngayNhap;
    private String idNV;
    private String idNCC;

    //constructor
    public PhieuNhap() {
    }

    public PhieuNhap(String idPN, Date ngayNhap, String idNV, String idNCC) {
        this.idPN = idPN;
        this.ngayNhap = ngayNhap;
        this.idNV = idNV;
        this.idNCC = idNCC;
    }

    //getter and setter
    public String getIdPN() {
        return idPN;
    }

    public void setIdPN(String idPN) {
        this.idPN = idPN;
    }

    public Date getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(Date ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public String getIdNV() {
        return idNV;
    }

    public void setIdNV(String idNV) {
        this.idNV = idNV;
    }

    public String getIdNCC() {
        return idNCC;
    }

    public void setIdNCC(String idNCC) {
        this.idNCC = idNCC;
    } 
}

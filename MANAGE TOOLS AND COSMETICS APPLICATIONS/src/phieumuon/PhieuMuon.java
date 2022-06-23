/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phieumuon;

import java.util.Date;

/**
 *
 * @author DELL
 */
public class PhieuMuon {
    private String idPM;
    private Date ngayMuon;
    private String idNV;
    private boolean daTra;

    public boolean isDaTra() {
        return daTra;
    }

    public void setDaTra(boolean daTra) {
        this.daTra = daTra;
    }

    public PhieuMuon(String idPM, Date ngayMuon, String idNV) {
        this.idPM = idPM;
        this.ngayMuon = ngayMuon;
        this.idNV = idNV;
    }

    public PhieuMuon() {
    }

    public String getIdPM() {
        return idPM;
    }

    public void setIdPM(String idPM) {
        this.idPM = idPM;
    }

    public Date getNgayMuon() {
        return ngayMuon;
    }

    public void setNgayMuon(Date ngayMuon) {
        this.ngayMuon = ngayMuon;
    }

    public String getIdNV() {
        return idNV;
    }

    public void setIdNV(String idNV) {
        this.idNV = idNV;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ctphieumuon;

/**
 *
 * @author DELL
 */
public class CTPhieuMuon {
    private String idPM;
    private String idMH;
    private int soLuong;

    public CTPhieuMuon() {}

    public CTPhieuMuon(String idPM, String idMH, int soLuong) {
        this.idPM = idPM;
        this.idMH = idMH;
        this.soLuong = soLuong;
    }

    public String getIdPM() {
        return idPM;
    }

    public void setIdPM(String idPM) {
        this.idPM = idPM;
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
}

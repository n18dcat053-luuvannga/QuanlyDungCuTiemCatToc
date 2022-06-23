/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mathang;

import java.awt.Component;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class MatHang {
    private String idMatHang;
    private String tenMatHang;
    private Date NSX;
    private Date HSD;

    // constructor
    public MatHang() {
    }

    public MatHang(String idMatHang, String tenMatHang, Date NSX, Date HSD) {
        this.idMatHang = idMatHang;
        this.tenMatHang = tenMatHang;
        this.NSX = NSX;
        this.HSD = HSD;
    }

    //setter and getter
    public String getIdMatHang() {
        return idMatHang;
    }

    public void setIdMatHang(String idMatHang) {
        this.idMatHang = idMatHang;
    }

    public String getTenMatHang() {
        return tenMatHang;
    }

    public void setTenMatHang(String tenMatHang) {
        this.tenMatHang = tenMatHang;
    }

    public Date getNSX() {
        return NSX;
    }

    public void setNSX(Date NSX) {
        this.NSX = NSX;
    }

    public Date getHSD() {
        return HSD;
    }

    public void setHSD(Date HSD) {
        this.HSD = HSD;
    }
    
    //goi form thong ke mat hang con dung duoc yyyy-mm-dd
    public void thongKeMHConDungDuocTrongNgay(String strDate){
        ConnectionSQL sql = new ConnectionSQL();
        ArrayList<MatHang> list = new ArrayList<>();
        ArrayList<Integer> listSL = new ArrayList<>();
        list = sql.getListMHConDungDuoc(strDate);
        listSL = sql.getListSLConDungDuoc(strDate);
        if(list.isEmpty()){
            Component panel = null;
            JOptionPane.showMessageDialog(panel, "Hiện tại không còn mặt hàng nào sử dụng được", "Notifications", 
                              JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            ThongKeMHConDungDuocTrongNgay tk = new ThongKeMHConDungDuocTrongNgay(list,listSL,strDate);
            tk.setVisible(true);
        }
    }
    
    //goi form thong ke mat hang con dung duoc
    public void thongKeMHConDungDuoc(){
        ConnectionSQL sql = new ConnectionSQL();
        ArrayList<MatHang> list = new ArrayList<>();
        ArrayList<Integer> listSL = new ArrayList<>();
        list = sql.getListMHConDungDuoc();
        listSL = sql.getListSLConDungDuoc();
        if(list.isEmpty()){
            Component panel = null;
            JOptionPane.showMessageDialog(panel, "Hiện tại không còn mặt hàng nào sử dụng được", "Notifications", 
                              JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            ThongKeMHConDungDuoc tk = new ThongKeMHConDungDuoc(list,listSL);
            tk.setVisible(true);
        }
    }
    
    //goi form thong ke mat hang bi hu
    public void thongKeMHBiHu(){
        ConnectionSQL sql = new ConnectionSQL();
        ArrayList<MatHang> listMH = new ArrayList<>();
        ArrayList<LichSuHu> listLS = new ArrayList<>();
        listMH = sql.getListMHHu();
        listLS = sql.getListMHHuSoLuong();
        if(listMH.isEmpty()){
            Component panel = null;
            JOptionPane.showMessageDialog(panel, "Hiện tại không có mặt hàng nào bị hư hoặc đã hết hạn", "Notifications", 
                              JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            ThongKeMHHu tk = new ThongKeMHHu(listMH,listLS);
            tk.setVisible(true);
        }
    }
    
    //neu soluonghu == soluongnhap thi ko cho muon return false
    public boolean ktChoMuonTB(String id){
        ConnectionSQL sql = new ConnectionSQL();
        String selectSLNhap = "SELECT SUM(SOLUONG) AS soluong FROM CTPHIEUNHAP WHERE IDMATHANG = '"+id+"'";
        String selectSLHu = "SELECT SUM(SOLUONGHU) AS soluong FROM lichsuhu WHERE IDMATHANG = '"+id+"'";
        int soLuongNhap = sql.selectSL(selectSLNhap);
        int soLuongHu = sql.selectSL(selectSLHu);
        return soLuongHu != soLuongNhap;
    }
    
    //neu (soLuongNhap - soLuongHu - soLuongMuon) > 0 thi return true, la cho muon trong 1 ngay 
    public boolean ktChoMuonTB(String id,String strDate){
        ConnectionSQL sql = new ConnectionSQL();
        int soLuongConDungDuoc = sql.getSLConDungDuoc(id, strDate);
        return soLuongConDungDuoc > 0;
    }
    
    public boolean ktChoMuonTB(String id,String strDate,int soLuongNhap){
        ConnectionSQL sql = new ConnectionSQL();
        int soLuongConDungDuoc = sql.getSLConDungDuoc(id, strDate);
        soLuongConDungDuoc = soLuongConDungDuoc - soLuongNhap;
        return soLuongConDungDuoc >= 0;
    }
    
    //convert date to string
    public void dateToString(String day,String month,String year,Date date){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
        String strDate = dateFormat.format(date);  
        day = strDate.split("-")[2];
        month = strDate.split("-")[1];
        year = strDate.split("-")[0];
    }
    
    //convert sql.date to string yyyy-MM-dd
    public String dateToString(Date date){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
        String strDate = dateFormat.format(date);  
        return strDate;
    }
    
    public static void main(String[] args) {
       MatHang mh = new MatHang();
//       mh.thongKeMHBiHu();
        String d = null,m = null,y = null;
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse("2000-02-02");
        } catch (ParseException ex) {
            Logger.getLogger(MatHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        mh.dateToString(d, m, y, date);
    }
    
}

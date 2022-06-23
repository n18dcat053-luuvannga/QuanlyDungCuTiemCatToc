/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ctphieunhap;


import java.math.BigDecimal;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import phieunhap.InfoCTPN;


/**
 *
 * @author DELL
 */
public class ConnectionSQL {
    public ConnectionSQL(){}

    //them 1 phieu nhap vao database
    public boolean insertSQL(CTPhieuNhap ctpn){
        try {
            String dbURL = "jdbc:sqlserver://localhost;databaseName=QL_DCMPTCT;user=sa;password=123";
            java.sql.Connection conn = DriverManager.getConnection(dbURL);
            String insert = "INSERT INTO ctphieunhap(idpn,idmathang,soluong,gia)" 
                                + "VALUES(?,?,?,?)";
            try{
                PreparedStatement ps = conn.prepareStatement(insert);
                ps.setString(1, ctpn.getIdPN());
                ps.setString(2,ctpn.getIdMH());
                ps.setInt(3, ctpn.getSoLuong());
                ps.setBigDecimal(4, ctpn.getGia());
                return ps.executeUpdate() > 0;
            }
            catch(SQLException ex){
                System.err.println("Cannot connect insert, " + ex);
            }
        }
        catch (SQLException ex) {
            System.err.println("Cannot connect database, " + ex);
        }
        
        return false;
    }
    
    //thuc hien cau lenh update
    public void updateSQL(String update){
        try {
            String dbURL = "jdbc:sqlserver://localhost;databaseName=QL_DCMPTCT;user=sa;password=123";
            java.sql.Connection conn = DriverManager.getConnection(dbURL);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(update);
        } catch (SQLException ex) {
            System.err.println("Cannot connect database, " + ex);
          }
    }
    
    //thuc hien cau lenh delete database
    public void deleteSQL(String idPN,String idMH){
        try {
            String dbURL = "jdbc:sqlserver://localhost;databaseName=QL_DCMPTCT;user=sa;password=123";
            java.sql.Connection conn = DriverManager.getConnection(dbURL);
            String delete = "delete from ctphieunhap where idpn = '"+idPN+"' and idmathang = '"+idMH+"'";
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(delete);
        } catch (SQLException ex) {
            System.err.println("Cannot connect database, " + ex);
          }
    }
    
    public void deleteSQL(String idPN){
        try {
            String dbURL = "jdbc:sqlserver://localhost;databaseName=QL_DCMPTCT;user=sa;password=123";
            java.sql.Connection conn = DriverManager.getConnection(dbURL);
            String delete = "delete from ctphieunhap where idpn = '"+idPN+"'";
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(delete);
        } catch (SQLException ex) {
            System.err.println("Cannot connect database, " + ex);
          }
    }
    
    //thuc hien lay danh sach phieu nhap
    public ArrayList<CTPhieuNhap> getListCTPN(){
        ArrayList<CTPhieuNhap> list = new ArrayList<>();
         try {
            String dbURL = "jdbc:sqlserver://localhost;databaseName=QL_DCMPTCT;user=sa;password=123";
            java.sql.Connection conn = DriverManager.getConnection(dbURL);
            Statement stmt = conn.createStatement();
            String select = "select * from ctphieunhap";
            ResultSet rs = stmt.executeQuery(select);
            while(rs.next()){
                CTPhieuNhap ctpn = new CTPhieuNhap();
                ctpn.setIdPN(rs.getString("idpn"));
                ctpn.setIdMH(rs.getString("idmathang"));
                ctpn.setSoLuong(rs.getInt("soluong"));
                ctpn.setGia(rs.getBigDecimal("gia"));
                list.add(ctpn);
            }   
        } catch (SQLException ex) {
            System.err.println("Cannot connect database, " + ex);
          }
        return list;
    }
    
    //lay danh sach infoCTPN voi ma phieu nhap
    public ArrayList<InfoCTPN> getListCTPN(String idPN){
        ArrayList<InfoCTPN> list = new ArrayList<>();
         try {
            String dbURL = "jdbc:sqlserver://localhost;databaseName=QL_DCMPTCT;user=sa;password=123";
            java.sql.Connection conn = DriverManager.getConnection(dbURL);
            Statement stmt = conn.createStatement();
            String select = "select ct.idmathang,mh.tenmathang,soluong,gia " +
                            "from ctphieunhap ct,mathang mh " +
                            "where idpn = '" + idPN +"' and ct.idmathang = mh.idmathang";
            ResultSet rs = stmt.executeQuery(select);
            while(rs.next()){
                InfoCTPN ctpn = new InfoCTPN();
                ctpn.setIdmathang(rs.getString("idmathang"));
                ctpn.setTenmathang(rs.getString("tenmathang"));
                ctpn.setSoLuong(rs.getInt("soluong"));
                ctpn.setGia(rs.getBigDecimal("gia"));
                list.add(ctpn);
            }   
        } catch (SQLException ex) {
            System.err.println("Cannot connect database, " + ex);
          }
        return list;
    }
    
    //show thong tin 1 phieu nhap    
    public void showPN(CTPhieuNhap ctpn){
        System.out.println(ctpn.getIdPN());
        System.out.println(ctpn.getIdMH());
        System.out.println(ctpn.getSoLuong());
        System.out.println(ctpn.getGia());
    }
    
    //show thong tin danh sach mat hang
    public void showListPN(ArrayList<CTPhieuNhap> list){
        for(CTPhieuNhap ctpn:list){
            this.showPN(ctpn);
        }
    }
    
    public static void main(String[] args){
        try {
            CTPhieuNhap ctpn = new CTPhieuNhap("PN2", "MH1", 5,BigDecimal.valueOf(100000));
            ArrayList<CTPhieuNhap> list = new ArrayList<>();
            ConnectionSQL sql = new ConnectionSQL();
//            list = sql.getListCTPN();
//            sql.showListPN(list);
//            sql.insertSQL(ctpn);
//            sql.deleteSQL("PN2", "MH1");
//            sql.updateSQL("update ctphieunhap set gia = '10' where idpn = 'PN2' and idmathang = 'MH6'");            
        } catch (Exception ex) {
            Logger.getLogger(phieunhap.ConnectionSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

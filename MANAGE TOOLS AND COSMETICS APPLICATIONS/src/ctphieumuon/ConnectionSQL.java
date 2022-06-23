/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ctphieumuon;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import phieumuon.InfoCTPM;


/**
 *
 * @author DELL
 */
public class ConnectionSQL {
    public ConnectionSQL(){}

    //them 1 phieu nhap vao database
    public boolean insertSQL(CTPhieuMuon ctpm){
        try {
            String dbURL = "jdbc:sqlserver://localhost;databaseName=QL_DCMPTCT;user=sa;password=123";
            java.sql.Connection conn = DriverManager.getConnection(dbURL);
            String insert = "INSERT INTO ctphieumuon(idpm,idmathang,soluong)" 
                                + "VALUES(?,?,?)";
            try{
                PreparedStatement ps = conn.prepareStatement(insert);
                ps.setString(1, ctpm.getIdPM());
                ps.setString(2,ctpm.getIdMH());
                ps.setInt(3, ctpm.getSoLuong());
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
    public void deleteSQL(String idPM,String idMH){
        try {
            String dbURL = "jdbc:sqlserver://localhost;databaseName=QL_DCMPTCT;user=sa;password=123";
            java.sql.Connection conn = DriverManager.getConnection(dbURL);
            String delete = "delete from ctphieumuon where idpm = '"+idPM+"' and idmathang = '"+idMH+"'";
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(delete);
        } catch (SQLException ex) {
            System.err.println("Cannot connect database, " + ex);
          }
    }
    
    //thuc hien cau lenh delete database
    public void deleteSQL(String idPM){
        try {
            String dbURL = "jdbc:sqlserver://localhost;databaseName=QL_DCMPTCT;user=sa;password=123";
            java.sql.Connection conn = DriverManager.getConnection(dbURL);
            String delete = "delete from ctphieumuon where idpm = '"+idPM+"'";
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(delete);
        } catch (SQLException ex) {
            System.err.println("Cannot connect database, " + ex);
          }
    }
    
    //thuc hien lay danh sach phieu nhap
    public ArrayList<CTPhieuMuon> getListCTPM(){
        ArrayList<CTPhieuMuon> list = new ArrayList<>();
         try {
            String dbURL = "jdbc:sqlserver://localhost;databaseName=QL_DCMPTCT;user=sa;password=123";
            java.sql.Connection conn = DriverManager.getConnection(dbURL);
            Statement stmt = conn.createStatement();
            String select = "select * from ctphieumuon";
            ResultSet rs = stmt.executeQuery(select);
            while(rs.next()){
                CTPhieuMuon ctpm = new CTPhieuMuon();
                ctpm.setIdPM(rs.getString("idpm"));
                ctpm.setIdMH(rs.getString("idmathang"));
                ctpm.setSoLuong(rs.getInt("soluong"));
                list.add(ctpm);
            }   
        } catch (SQLException ex) {
            System.err.println("Cannot connect database, " + ex);
          }
        return list;
    }
    
    //lay danh sach infoCTPN voi ma phieu nhap
    public ArrayList<InfoCTPM> getListCTPM(String idPM){
        ArrayList<InfoCTPM> list = new ArrayList<>();
         try {
            String dbURL = "jdbc:sqlserver://localhost;databaseName=QL_DCMPTCT;user=sa;password=123";
            java.sql.Connection conn = DriverManager.getConnection(dbURL);
            Statement stmt = conn.createStatement();
            String select = "select ct.idmathang,mh.tenmathang,soluong " +
                            "from ctphieumuon ct,mathang mh " +
                            "where idpm = '" + idPM +"' and ct.idmathang = mh.idmathang";
            ResultSet rs = stmt.executeQuery(select);
            while(rs.next()){
                InfoCTPM ctpm = new InfoCTPM();
                ctpm.setIdmathang(rs.getString("idmathang"));
                ctpm.setTenmathang(rs.getString("tenmathang"));
                ctpm.setSoLuong(rs.getInt("soluong"));
                list.add(ctpm);
            }   
        } catch (SQLException ex) {
            System.err.println("Cannot connect database, " + ex);
          }
        return list;
    }
    
    //show thong tin 1 phieu nhap    
    public void showPM(CTPhieuMuon ctpm){
        System.out.println(ctpm.getIdPM());
        System.out.println(ctpm.getIdMH());
        System.out.println(ctpm.getSoLuong());
    }
    
    //show thong tin danh sach mat hang
    public void showListPM(ArrayList<CTPhieuMuon> list){
        for(CTPhieuMuon ctpm:list){
            this.showPM(ctpm);
        }
    }
    
    public static void main(String[] args){
        try {
            CTPhieuMuon ctpm = new CTPhieuMuon("PM3", "MH1", 1);
            ArrayList<CTPhieuMuon> list = new ArrayList<>();
            ConnectionSQL sql = new ConnectionSQL();
//            list = sql.getListCTPM();
//            sql.showListPM(list);
//            sql.insertSQL(ctpm);
            sql.deleteSQL("PM3", "MH1");
//            sql.updateSQL("update ctphieumuon set soluong = '2' where idpm = 'PM3' and idmathang = 'MH1'");            
        } catch (Exception ex) {
            Logger.getLogger(phieunhap.ConnectionSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

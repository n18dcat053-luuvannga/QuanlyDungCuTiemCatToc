/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phieunhap;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class ConnectionSQL {
    public ConnectionSQL(){}

    //them 1 phieu nhap vao database
    public boolean insertSQL(PhieuNhap pn){
        try {
            String dbURL = "jdbc:sqlserver://localhost;databaseName=QL_DCMPTCT;user=sa;password=123";
            java.sql.Connection conn = DriverManager.getConnection(dbURL);
            String insert = "INSERT INTO phieunhap(idpn,ngaynhap,idnv,idncc)" 
                                + "VALUES(?,?,?,?)";
            try{
                PreparedStatement ps = conn.prepareStatement(insert);
                ps.setString(1, pn.getIdPN());
                ps.setDate(2, new Date(pn.getNgayNhap().getTime()));
                ps.setString(3, pn.getIdNV());
                ps.setString(4, pn.getIdNCC());
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
    public void deleteSQL(String id){
        try {
            String dbURL = "jdbc:sqlserver://localhost;databaseName=QL_DCMPTCT;user=sa;password=123";
            java.sql.Connection conn = DriverManager.getConnection(dbURL);
            String delete = "delete from phieunhap where idpn = '"+id+"'";
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(delete);
        } catch (SQLException ex) {
            System.err.println("Cannot connect database, " + ex);
          }
    }
    
    //thuc hien lay danh sach phieu nhap
    public ArrayList<PhieuNhap> getListPN(){
        ArrayList<PhieuNhap> list = new ArrayList<>();
         try {
            String dbURL = "jdbc:sqlserver://localhost;databaseName=QL_DCMPTCT;user=sa;password=123";
            java.sql.Connection conn = DriverManager.getConnection(dbURL);
            Statement stmt = conn.createStatement();
            String select = "select * from phieunhap";
            ResultSet rs = stmt.executeQuery(select);
            while(rs.next()){
                PhieuNhap pn = new PhieuNhap();
                pn.setIdPN(rs.getString("idpn"));
                pn.setNgayNhap(rs.getDate("ngaynhap"));
                pn.setIdNV(rs.getString("idnv"));
                pn.setIdNCC(rs.getString("idncc"));
                list.add(pn);
            }   
        } catch (SQLException ex) {
            System.err.println("Cannot connect database, " + ex);
          }
        return list;
    }
    
    //show thong tin 1 phieu nhap    
    public void showPN(PhieuNhap pn){
        System.out.println(pn.getIdPN());
        System.out.println(pn.getNgayNhap());
        System.out.println(pn.getIdNV());
        System.out.println(pn.getIdNCC());
    }
    
    //show thong tin danh sach mat hang
    public void showListPN(ArrayList<PhieuNhap> list){
        for(PhieuNhap pn:list){
            this.showPN(pn);
        }
    }
    
    //lay ma Phieu nhap cuoi cung trong database
    public String getLastIDPN(){
        ArrayList<String> list = new ArrayList<>();
        String lastID = null;
         try {
            String dbURL = "jdbc:sqlserver://localhost;databaseName=QL_DCMPTCT;user=sa;password=123";
            java.sql.Connection conn = DriverManager.getConnection(dbURL);
            Statement stmt = conn.createStatement();
            String select = "select idpn from phieunhap";
            ResultSet rs = stmt.executeQuery(select);
            while(rs.next()){
                lastID = rs.getString("idpn");
            }   
        } catch (SQLException ex) {
            System.err.println("Cannot connect database, " + ex);
          }
        return lastID;
    }
    
    public static void main(String[] args){
//        try {
//            SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
//            java.util.Date ngayNhap = sd.parse("2001-2-2");
//            PhieuNhap pn = new PhieuNhap("PN3",ngayNhap , "NV1", "NCC1");
//            ArrayList<PhieuNhap> list = new ArrayList<>();
//            ConnectionSQL sql = new ConnectionSQL();
//            sql.insertSQL(pn);
//            sql.updateSQL("update phieunhap set idncc = 'NCC1' where idpn = 'PN2'");
//            sql.showListPN(list);
//        } catch (ParseException ex) {
//            Logger.getLogger(ConnectionSQL.class.getName()).log(Level.SEVERE, null, ex);
//        }
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);   
        System.out.println(date);
    }
}

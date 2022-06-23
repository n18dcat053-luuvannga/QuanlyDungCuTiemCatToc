/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mathang;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class ConnectionSQL {
    public ConnectionSQL(){}
    
    //lay danh sach mat hang bang 1 cau lenh select
    public ArrayList<MatHang> getListMH(String select){
        ArrayList<MatHang> list = new ArrayList<>();
         try {
            String dbURL = "jdbc:sqlserver://localhost;databaseName=QL_DCMPTCT;user=sa;password=123";
            java.sql.Connection conn = DriverManager.getConnection(dbURL);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(select);
            while(rs.next()){
                MatHang mh = new MatHang();
                mh.setIdMatHang(rs.getString("idmathang"));
                mh.setTenMatHang(rs.getString("tenmathang"));
                mh.setNSX(rs.getDate("ngaysanxuat"));
                mh.setHSD(rs.getDate("hansudung"));
                list.add(mh);
            }   
        } catch (SQLException ex) {
            System.err.println("Cannot connect database, " + ex);
          }
        return list;
    }    
        
    //lay danh sach mat hang bi hu
    public ArrayList<MatHang> getListMHHu(){
        ArrayList<MatHang> list = new ArrayList<>();        
         try {
            String dbURL = "jdbc:sqlserver://localhost;databaseName=QL_DCMPTCT;user=sa;password=123";
            java.sql.Connection conn = DriverManager.getConnection(dbURL);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select lichsuhu.idmathang,mathang.tenmathang " +
                                                "from lichsuhu,mathang " +
                                                "where  lichsuhu.idmathang = mathang.idmathang");
            while(rs.next()){
                MatHang mh = new MatHang();
                mh.setIdMatHang(rs.getString("idmathang"));
                mh.setTenMatHang(rs.getString("tenmathang"));
                list.add(mh);
            }   
        } catch (SQLException ex) {
            System.err.println("Cannot connect database, " + ex);
          }
        return list;
    }
    
    //lay danh sach so luong mat hang bi hu va ngay hu
    public ArrayList<LichSuHu> getListMHHuSoLuong(){
        ArrayList<LichSuHu> list = new ArrayList<>();        
         try {
            String dbURL = "jdbc:sqlserver://localhost;databaseName=QL_DCMPTCT;user=sa;password=123";
            java.sql.Connection conn = DriverManager.getConnection(dbURL);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select soluonghu,ngayhu " +
                                                "from lichsuhu,mathang " +
                                                "where  lichsuhu.idmathang = mathang.idmathang");
            while(rs.next()){
                LichSuHu ls = new LichSuHu();
                ls.setSoLuongHu(rs.getInt("soluonghu"));
                ls.setNgayHu(rs.getDate("ngayhu"));
                list.add(ls);
            }   
        } catch (SQLException ex) {
            System.err.println("Cannot connect database, " + ex);
          }
        return list;
    }
    
        //lay so luong muon trong ngay yyyy-mm-dd cua 1 mh co id
    public int getSLMuon(String id,String strDate){
        int soluong=0;
        String idpm;
        try {
            String dbURL = "jdbc:sqlserver://localhost;databaseName=QL_DCMPTCT;user=sa;password=123";
            java.sql.Connection conn = DriverManager.getConnection(dbURL);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select pm.idpm as idpm,sum(soluong) as soluong from ctphieumuon ctpm,phieumuon pm " +
                        "where pm.ngaymuon = '" + strDate + "' and pm.idpm = ctpm.idpm and ctpm.idmathang = '" + id + "' " +
                        "group by pm.idpm");
            while(rs.next()){
                idpm = rs.getString("idpm");
                soluong = soluong + rs.getInt("soluong");
            }
        } catch (SQLException ex) {
            System.err.println("Cannot connect database, " + ex);
          }
        return soluong;
    }
    
    //lay so luong nhap truoc ngay yyyy-mm-dd cua 1 mh co id
    public  int getSLNhap(String id,String strDate){
        int soLuong=0;
        try {
            String dbURL = "jdbc:sqlserver://localhost;databaseName=QL_DCMPTCT;user=sa;password=123";
            java.sql.Connection conn = DriverManager.getConnection(dbURL);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT sum(ct.soluong) AS soluong  FROM CTPHIEUNHAP ct,phieunhap pn " +
                        "WHERE pn.ngaynhap <= '" + strDate + "' and pn.idpn = ct.idpn and ct.idmathang = '" + id + "' ");
            while(rs.next()){
                soLuong = soLuong + rs.getInt("soluong");
            }
        } catch (SQLException ex) {
            System.err.println("Cannot connect database, " + ex);
          }
        return soLuong;
    }
    
    //lay so luong hu truoc ngay yyyy-mm-dd cua 1 mh co id
    public  int getSLHu(String id,String strDate){
        int soLuong=0;
        try {
            String dbURL = "jdbc:sqlserver://localhost;databaseName=QL_DCMPTCT;user=sa;password=123";
            java.sql.Connection conn = DriverManager.getConnection(dbURL);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT sum(lsh.soluonghu) AS soluong"
                    + "  FROM lichsuhu lsh " +
                    "WHERE lsh.ngayhu = '" + strDate + "' and lsh.idmathang = '" + id + "'");
            while(rs.next()){
                soLuong = soLuong + rs.getInt("soluong");
            }
        } catch (SQLException ex) {
            System.err.println("Cannot connect database, " + ex);
          }
        return soLuong;
    }
    
    //lay so luong mat hang con dung duoc cua 1 ma truyen vao cua 1 ngay
    public  int getSLConDungDuoc(String id,String strDate){
        int soluong=0;
        int soLuongNhap = this.getSLNhap(id,strDate);
        int soLuongHu = this.getSLHu(id,strDate);
        int soLuongMuon = this.getSLMuon(id,strDate);
        soluong = soLuongNhap - soLuongHu - soLuongMuon;
        return soluong;
    }
    
    // lay so luong con dung duoc cua ma mat hang truyen vao ko co thoi gian
    public int getSLConDungDuoc(String id){
        int soluong=0;
        String selectSLNhap = "SELECT SUM(SOLUONG) AS soluong FROM CTPHIEUNHAP WHERE IDMATHANG = '" + id + "'";
        String selectSLHu = "SELECT SUM(SOLUONGHU) AS soluong FROM lichsuhu  WHERE IDMATHANG = '" + id + "'";
        int soLuongNhap = this.selectSL(selectSLNhap);
        int soLuongHu = this.selectSL(selectSLHu);
        soluong = soLuongNhap - soLuongHu;
        return soluong;
    }
    
    //lay danh sach so luong con dung duoc CO TIME yyyy-mm-dd
    public ArrayList<Integer> getListSLConDungDuoc(String strDate){
        ConnectionSQL sql = new ConnectionSQL();
        ArrayList<MatHang> listMH;
        ArrayList<Integer> list = new ArrayList<>();
        String select = "SELECT * FROM MATHANG";
        listMH = sql.getListMH(select);
        String id = "MH";
        int soluong;
        for(MatHang mh:listMH){
            if(mh.ktChoMuonTB(mh.getIdMatHang(),strDate)){
                soluong = this.getSLConDungDuoc(mh.getIdMatHang(),strDate);
                list.add(soluong);             
            }
        }         
        return list;
    }
    //lay danh sach so luong con dung duoc CO TIME yyyy-mm-dd(sau khi them vao phieu muon)
    public ArrayList<Integer> getListSLConDungDuocAfter(String strDate,ArrayList<MatHang> listMHDaThem,ArrayList<Integer> listSL){
        ConnectionSQL sql = new ConnectionSQL();
        ArrayList<MatHang> listMH;
        ArrayList<Integer> list = new ArrayList<>();
        String select = "SELECT * FROM MATHANG";
        listMH = sql.getListMH(select);
        String id = "MH";
        int soluong,j;
        for(MatHang mh:listMH){
            if(mh.ktChoMuonTB(mh.getIdMatHang(),strDate)){
                soluong = this.getSLConDungDuoc(mh.getIdMatHang(),strDate);
                list.add(soluong);             
            }
        }         
        return list;
    }
    
    //lay danh sach so luong con dung duoc KO CO TIME
    public ArrayList<Integer> getListSLConDungDuoc(){
        ConnectionSQL sql = new ConnectionSQL();
        ArrayList<MatHang> listMH;
        ArrayList<Integer> list = new ArrayList<>();
        String select = "SELECT * FROM MATHANG";
        listMH = sql.getListMH(select);
        String id = "MH";
        int i = 1,soluong;
        for(MatHang mh:listMH){
            if(mh.ktChoMuonTB(id+String.valueOf(i))){
                soluong = this.getSLConDungDuoc(id+String.valueOf(i));
                list.add(soluong);             
            }
            i++;
        }         
        return list;
    }
    
    //lay danh sach mat hang con dung duoc CO TIME yyyy-mm-dd
    public ArrayList<MatHang> getListMHConDungDuoc(String strDate){
        ConnectionSQL sql = new ConnectionSQL();
        ArrayList<MatHang> listMH,list = new ArrayList<>();
        String select = "SELECT * FROM MATHANG";
        listMH = sql.getListMH(select);
        String id = "MH";
        int i = 1;
        for(MatHang mh:listMH){
            if(mh.ktChoMuonTB(id+String.valueOf(i),strDate)){
                try {
                    String dbURL = "jdbc:sqlserver://localhost;databaseName=QL_DCMPTCT;user=sa;password=123";
                    java.sql.Connection conn = DriverManager.getConnection(dbURL);
                    Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery("DECLARE @ID NVARCHAR(10) Set @ID = '"+id+String.valueOf(i)+"'"
                            + "SELECT tenmathang FROM MATHANG WHERE IDMATHANG = @ID");
                    while(rs.next()){
                        mh.setIdMatHang(id + String.valueOf(i));
                        mh.setTenMatHang(rs.getString("tenmathang"));
                        list.add(mh);
                    }   
                } catch (SQLException ex) {
                    System.err.println("Cannot connect database, " + ex);
                  }
            }
            i++;
        }         
        return list;
    }
    
    //lay danh sach mat hang con dung duoc KO CO TIME
    public ArrayList<MatHang> getListMHConDungDuoc(){
        ConnectionSQL sql = new ConnectionSQL();
        ArrayList<MatHang> listMH,list = new ArrayList<>();
        String select = "SELECT * FROM MATHANG";
        listMH = sql.getListMH(select);
        String id = "MH";
        int i = 1;
        for(MatHang mh:listMH){
            if(mh.ktChoMuonTB(id+String.valueOf(i))){
                try {
                    String dbURL = "jdbc:sqlserver://localhost;databaseName=QL_DCMPTCT;user=sa;password=123";
                    java.sql.Connection conn = DriverManager.getConnection(dbURL);
                    Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery("DECLARE @ID NVARCHAR(10) Set @ID = '"+id+String.valueOf(i)+"'"
                            + "SELECT tenmathang FROM MATHANG WHERE IDMATHANG = @ID");
                    while(rs.next()){
                        mh.setIdMatHang(id + String.valueOf(i));
                        mh.setTenMatHang(rs.getString("tenmathang"));
                        list.add(mh);
                    }   
                } catch (SQLException ex) {
                    System.err.println("Cannot connect database, " + ex);
                  }
            }
            i++;
        }         
        return list;
    }
    
    //lay ma mat hang cuoi cung trong database
    public String getLastIDMH(){
        ArrayList<String> list = new ArrayList<>();
        String lastID = "MH0";
         try {
            String dbURL = "jdbc:sqlserver://localhost;databaseName=QL_DCMPTCT;user=sa;password=123";
            java.sql.Connection conn = DriverManager.getConnection(dbURL);
            Statement stmt = conn.createStatement();
            String select = "select idmathang from mathang";
            ResultSet rs = stmt.executeQuery(select);
            while(rs.next()){
                String tempID = rs.getString("idmathang");
                int cmp = this.stringCompare(tempID, lastID);
                if(cmp > 0){
                    lastID = tempID;
                }
            }   
        } catch (SQLException ex) {
            System.err.println("Cannot connect database, " + ex);
          }
        return lastID;
    }
    
    //compare 2 string voi nhau str1>str2 => soduong, nguoc lai soam, bang thi => 0
    public int stringCompare(String str1, String str2) {
        int l1 = str1.length();
        int l2 = str2.length();
        int lmin = Math.min(l1, l2);
        if(l1 < l2){
            return -1;
        }
        for (int i = 0; i < lmin; i++) {
            int str1_ch = (int) str1.charAt(i);
            int str2_ch = (int) str2.charAt(i);
            if (str1_ch != str2_ch) {
                return str1_ch - str2_ch;
            }
        }
        if (l1 != l2) {
            return l1 - l2;
        }
        else {
            return 0;
        }
    }
    
    //them 1 mat hang vao database
    public boolean insertSQL(MatHang mh){
        try {
            String dbURL = "jdbc:sqlserver://localhost;databaseName=QL_DCMPTCT;user=sa;password=123";
            java.sql.Connection conn = DriverManager.getConnection(dbURL);
            String insert = "INSERT INTO mathang(idmathang,tenmathang,ngaysanxuat,hansudung)" 
                                + "VALUES(?,?,?,?)";
            try{
                PreparedStatement ps = conn.prepareStatement(insert );
                ps.setString(1, mh.getIdMatHang());
                ps.setString(2, mh.getTenMatHang());
                ps.setDate(3, new Date(mh.getNSX().getTime()));
                ps.setDate(4, new Date(mh.getHSD().getTime()));
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
    
    //thuc hien cau lenh delete database tinh nang nay van sai(tinh nang se gay ra su co ve du lieu)
    public void deleteSQL(String id){
        try {
            String dbURL = "jdbc:sqlserver://localhost;databaseName=QL_DCMPTCT;user=sa;password=123";
            java.sql.Connection conn = DriverManager.getConnection(dbURL);
            String delete = "delete from lichsuhu where idmathang = '"+id+"' "
                    +"delete from mathang where idmathang = '"+id+"'";
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(delete);
        } catch (SQLException ex) {
            System.err.println("Cannot connect database, " + ex);
          }
    }
    
    //thuc hien select de lay so luong
    public int selectSL(String select){
        int soluong=0;
        try {
            String dbURL = "jdbc:sqlserver://localhost;databaseName=QL_DCMPTCT;user=sa;password=123";
            java.sql.Connection conn = DriverManager.getConnection(dbURL);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(select);
            while(rs.next()){
                soluong = rs.getInt("soluong");
            }
        } catch (SQLException ex) {
            System.err.println("Cannot connect database, " + ex);
          }
        return soluong;
    }
    
    //show thong tin 1 mat hang    
    public void showMH(MatHang mh){
        System.out.println(mh.getIdMatHang());
        System.out.println(mh.getTenMatHang());
        System.out.println(mh.getNSX());
        System.out.println(mh.getHSD());
    }
    
    //show thong tin danh sach mat hang
    public void showListMH(ArrayList<MatHang> list){
        for(MatHang mh:list){
            this.showMH(mh);
        }
    }
    
    //show thong tin 1 lich su hu 
    public void showLS(LichSuHu ls){
        System.out.println(ls.getIdMatHang());
        System.out.println(ls.getSoLuongHu());
        System.out.println(ls.getNgayHu());
    }
    
    //show danh sach lich su hu
    public void showListLS(ArrayList<LichSuHu> list){
        for(LichSuHu ls:list){
            this.showLS(ls);
        }
    }
    
    public static void main(String[] args) throws ParseException {
        ConnectionSQL sql = new ConnectionSQL(); 
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date NSX = sd.parse("2001-2-2");
        java.util.Date HSD = sd.parse("2001-3-2");
        MatHang mh = new MatHang("MH9", "test", NSX, HSD);
        sql.insertSQL(mh);
//        ArrayList<MatHang> list = sql.getListMHConDungDuoc("2021-2-1");
//        sql.showListMH(list);        
//        ArrayList<LichSuHu> list1 = sql.getListMHHuSoLuong();
//        sql.showListLS(list1);
//        String update = "UPDATE MATHANG SET tenmathang = "+"'kéo' WHERE IDMATHANG = 'MH1'";
//        sql.updateSLHu(update);
    }
}
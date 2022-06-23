/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NhanVienTCT;
// khai bao ten cho Nhan Vien vi k ke thua ten tu userCH

public class nhanvien {
    protected String idnv;
    protected String ho;
    protected String ten;
    protected String gioitinh;
    protected String diachi;
    
    
    public nhanvien() {
        
    }
    
    public nhanvien(String idnv, String ho, String ten, String gioitinh, String diachi){
        
     this.idnv=idnv;
     this.ten=ten;
     this.ho=ho;
     this.gioitinh=gioitinh;
     this.diachi=diachi;
    }
    
    
    public nhanvien(nhanvien nv){
        this.idnv=nv.idnv;
        this.ten=nv.ten;
        this.ho=nv.ho;
        this.diachi=nv.diachi;
        this.gioitinh=nv.gioitinh;
                
    }

    public String getIdnv() {
        return idnv;
    }

    public void setIdnv(String idnv) {
        this.idnv = idnv;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getDiachi() {
        return diachi;
    }
// trim() de xoa khoang trang tu dau chuoi cuoii chuoi
    public void setDiachi(String diachi) {
        this.diachi = diachi.trim();
    }
}

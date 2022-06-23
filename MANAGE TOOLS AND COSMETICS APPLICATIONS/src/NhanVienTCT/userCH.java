
package NhanVienTCT;

//import com.sun.xml.internal.bind.annotation.OverrideAnnotationOf;

public class userCH {
    protected String username;
    protected String password;  
    protected String idpq;
    
    
    public userCH(){
        
    }
    
    public userCH(String username, String password, boolean isAdmin){
        this.username=username;
        this.password= password;
        this.idpq=idpq;
    }

    public userCH(userCH us){
        this.username=us.username;
        this.password=us.password;
        this.idpq=us.idpq;
        
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password.trim();
    }

    public String idpq() {
        return idpq;
    }

    public void setIdpq(boolean isAdmin) {
        this.idpq = this.idpq;
    }
    
//    equals so sanh 2chuoi cos bang nhau k
    public boolean soSanh(String username, String password ){
        return this.username.equals(username) && this.password.equals(password);
    }
    
    public static void doiMatKhau(userCH us, String username, String newpassword){
        if(us.username.equals(username)){
            us.setPassword(newpassword);
        }
    }
}

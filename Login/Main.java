package Login;

public class Main {
    
    public static void main(String[] args){
        IDAndPasswords idAndPasswords = new IDAndPasswords();
        Login login = new Login(idAndPasswords.getLoginInfo());
    }

}

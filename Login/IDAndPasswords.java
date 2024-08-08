package Login;

import java.util.HashMap;

public class IDAndPasswords {
    
    HashMap<String, String> loginInfo  = new HashMap<String, String>();

    public IDAndPasswords(){
        
        loginInfo.put("imran1", "1234");
        loginInfo.put("imran2", "1234");
        loginInfo.put("imran3", "1234");

    }

    protected HashMap getLoginInfo(){
        return loginInfo;
    }

}

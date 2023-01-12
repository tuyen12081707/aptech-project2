package aptech.project2;

import aptech.project2.common.ValidateCommon;

public class test {

    public static void main(String[] args) {
        String e = "username@domain.com";
        
        System.out.println("valid email: " + ValidateCommon.isValidEmail(e));
        
        
        String phone = "0342162155";
        
        System.out.println("valid phone: " + ValidateCommon.isValidVietnamesePhoneNumber(phone));
        
        int code = (int) Math.floor(((Math.random() * 89999999) + 10000000));
        System.out.println("MA_NO_" + code);
    }

}


package aptech.project2.common;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;


public class ValidateCommon {

    public static void validateNullObject(Object object, String objectName) {
        if (object instanceof String) {
            if (StringCommon.isNullOrBlank(String.valueOf(object))) {
                throw new CommonException(MessageCommon.getMessage(MessageContent.MISSING_PARAM, objectName));
            }
        } else if (Objects.isNull(object)) {
            throw new CommonException(MessageCommon.getMessage(MessageContent.MISSING_PARAM, objectName));
        }
    }

    public static boolean isValidUsername(String name) throws PatternSyntaxException {
        validateNullObject(name, "Username");
        String regex = "^[a-z][a-z0-9_.]{3,29}$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(name);
        return m.matches();
    }

    public static boolean isValidPassword(String password) throws PatternSyntaxException {
        validateNullObject(password, "Password");
        String regex = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{6,}$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(password);
        return m.matches();
    }

    public static boolean isValidVietnamesePhoneNumber(String phone) {
        validateNullObject(phone, "Phone");
        String regex = "^(03|05|07|08|09|01[2|6|8|9])+([0-9]{8})$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(phone);
        return m.matches();
    }

    public static boolean isValidCharacter(String name) throws PatternSyntaxException {
        String regex = "^[A-Za-z0-9\\s\\-_,\\.:;()''\"\"]+$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(name);
        return m.matches();
    }

    public static boolean isInvalidStringLength(String str, int min, int max) {
        return str.length() < min || str.length() > max;
    }
}

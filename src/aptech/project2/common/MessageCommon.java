
package aptech.project2.common;

import java.text.MessageFormat;


public class MessageCommon {
    public static String getMessage(String msgPattern, String param) {
        if (!StringCommon.isNullOrBlank(msgPattern) && !StringCommon.isNullOrBlank(param)) {
            Object[] a = {param};
            msgPattern = MessageFormat.format(msgPattern, a);
        }
        return msgPattern;
    }
}

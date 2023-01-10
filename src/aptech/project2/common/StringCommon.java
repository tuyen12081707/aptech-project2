package aptech.project2.common;

public class StringCommon {
    public static boolean isNullOrBlank(String str) {
        return str == null || str.trim().equals("");
    }
}

package common;

public class StringUtil {

    /**
     * ctor
     */
    private StringUtil() {
        // no instances of this type
    }

    public static String unwrap(String wrapped) {
        return wrapped.substring(1, wrapped.length() - 1);
    }

}

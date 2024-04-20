package common;

import org.apache.commons.lang3.StringUtils;

public class IntegerParserUtil {

    /**
     * ctor
     */
    private IntegerParserUtil() {
        // no instances of this type
    }

    public static int parseInt(final String expression) {

        if (StringUtils.isBlank(expression)) {
            throw new RuntimeException("Input data is blank!");
        }

        String temp = StringUtils.trim(expression);

        if (temp.startsWith("0x")) {
            return Integer.parseInt(expression.substring(2), 16);
        } else if (temp.startsWith("0b")) {
            // TODO binary
            throw new RuntimeException("Not implemented yet!");
        } else if (temp.length() > 1 && temp.startsWith("0")) {
            // TODO: octal
            throw new RuntimeException("Not implemented yet!");
        }

        return Integer.parseInt(expression);
    }

    public static String hex(int n) {
        // call toUpperCase() if that's required
        return String.format("0x%8s", Integer.toHexString(n)).replace(' ', '0');
    }

    public static String hex(float f) {
        // change the float to raw integer bits(according to the OP's requirement)
        return hex(Float.floatToRawIntBits(f));
    }

    public static void insert(byte[] buffer, int bufferIdx, int encoded) {
        buffer[bufferIdx + 0] = (byte) ((encoded >> 24) & 0xFF);
        buffer[bufferIdx + 1] = (byte) ((encoded >> 16) & 0xFF);
        buffer[bufferIdx + 2] = (byte) ((encoded >> 8) & 0xFF);
        buffer[bufferIdx + 3] = (byte) ((encoded >> 0) & 0xFF);
    }

    public static int retrieveIntegerFromBuffer(byte[] buffer, int bufferIdx) {
        return ((buffer[bufferIdx + 0] & 0xFF) << 24) 
        + ((buffer[bufferIdx + 1] & 0xFF) << 16) 
        + ((buffer[bufferIdx + 2] & 0xFF) << 8) 
        + ((buffer[bufferIdx + 3] & 0xFF) << 0);
    }

}

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

            return Integer.parseInt(expression.substring(2));

        } else if (temp.startsWith("b")) {
            // TODO: octal
        }

        throw new RuntimeException("Input data has unknown format!");

    }
    
}

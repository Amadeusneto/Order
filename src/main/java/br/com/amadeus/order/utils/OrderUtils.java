package br.com.amadeus.order.utils;

import org.apache.commons.validator.routines.EmailValidator;

import java.util.regex.Pattern;

public class OrderUtils {

    public static boolean isValidMobileNumber(String valueMobilePhone) {
        Pattern p = Pattern.compile("^\\(?[1-9]{2}\\)? ?(?:[2-8]|9[1-9])[0-9]{3}\\-?[0-9]{4}$");
        return p.matcher(valueMobilePhone).matches();
    }

    public static boolean isValidEmail(String email) {
        return EmailValidator.getInstance().isValid(email);
    }
}

/**
 * 10 Apr 2020
 */
package za.co.iqbusiness.online.application.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author luckyboyrapudi
 *
 */
public class Validation {

	public static boolean fullNameValidation(String value) {

	    String regularEx ="^([A-Z][a-z]*((\\s)))+[A-Z][a-z]*$";
	    		
	    Pattern pattern = Pattern.compile(regularEx,Pattern.CASE_INSENSITIVE);
	    Matcher matcher = pattern.matcher(value);
	    return matcher.find();

	}
	
	public static boolean idValidationSA(String value) {

	    String regularEx ="(((\\d{2}((0[13578]|1[02])(0[1-9]|[12]\\d|3[01])|(0[13456789]|1[012])(0[1-9]|[12]\\d|30)|02(0[1-9]|1\\d|2[0-8])))|([02468][048]|[13579][26])0229))(( |-)(\\d{4})( |-)([01]8((( |-)\\d{1})|\\d{1}))|(\\d{4}[01]8\\d{1}))";
	    		
	    Pattern pattern = Pattern.compile(regularEx,Pattern.CASE_INSENSITIVE);
	    Matcher matcher = pattern.matcher(value);
	    return matcher.find();

	}
	
	
	
}

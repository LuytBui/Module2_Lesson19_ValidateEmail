import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidater {
    public static final String EMAIL_REGEX = "^[A-Za-z]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9])$";
    static Pattern pattern = Pattern.compile(EMAIL_REGEX);
    public boolean validate(String email){
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}

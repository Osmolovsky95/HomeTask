package homeTaskSix.messenger;



import homeTaskSix.Messenger;
import javafx.css.Match;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateUser {

    static Pattern pattern = Pattern.compile("^[A-Za-z]+\\d*[^#^!^\\\\]{4,}");

    public static boolean checkUser(User user) {
        Matcher matcher = pattern.matcher(user.getLogin());
        boolean flag;
        if (matcher.find()) {
        flag=true;
        }
        else {
            flag=false;
        }
        return flag;

    }
        }


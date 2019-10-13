package homeTaskFour;

import java.io.FileInputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Searcher implements IRobot {

    @Override
    public void search(String link) throws  Exception {
        FileInputStream input = new FileInputStream(link);
        byte[] massiv = new byte[input.available()];
        input.read(massiv);
        String warAndWorld = new String(massiv);
        //Ищем без учета регистра
        Pattern pattern1 = Pattern.compile("война",Pattern.CASE_INSENSITIVE);
        Matcher matcher1 = pattern1.matcher(warAndWorld);//
        Pattern pattern2 = Pattern.compile(" +и +",Pattern.CASE_INSENSITIVE);
        Matcher matcher2 = pattern2.matcher(warAndWorld);
        Pattern pattern3 = Pattern.compile("мир",Pattern.CASE_INSENSITIVE);
        Matcher matcher3 = pattern3.matcher(warAndWorld);
        int i = 0;
        int a=0;
        int b=0;
        while (matcher1.find()) {
            i++;
        }
        System.out.println("Слово \"Война\" без учета регистра  встречается " + i + " раз");

        while (matcher2.find()) {
            a++;
        }
        System.out.println("Слово \"и\" без учета регистра как предлог встречается " + a + " раз");
        while (matcher3.find()) {
            b++;
        }
        System.out.println("Слово \"мир\" без учета регистра как предлог встречается " + b + " раз");
    }

    }


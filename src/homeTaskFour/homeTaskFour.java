package homeTaskFour;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class homeTaskFour {
    public static void main(String[] args) throws Exception {
          oneOne();
          oneTwo();
          oneThree();
          oneFourV1("012312");
          oneFourV2("012312");
          oneFourV3("012312");
          twoOne();
          String link ="";
     for (int i=0;i<args.length;i++){
         link=args[i];
     }
        twoTwo(link);
        SimpleSearch simpleSearch=new SimpleSearch();
     simpleSearch.search(link);
                                           //China        Belarus          Russia
        String  phoneNumber=" вот мой+8615026861779 absf+3752944-520-00  +79587568549 +375(25)5277438 +375 25 527 74 38" +
                  "+375- 25- 527- 74 -38  ";
          phoneNumbers(phoneNumber);

    }

    private static void oneOne() {
        System.out.println("Задание 1.1");
        String str1 = "Мама мыла раму";
        String str2 = "Мама" + " мыла" + " раму";
        System.out.println(str1 == str2);
    }

    private static void oneTwo() {
        System.out.println("Задание 1.2");
        String str1 = "Hello world";
        char[] massiv = new char[str1.length()];
        massiv = str1.toCharArray();
        for (char s : massiv) {
            System.out.println(s);
        }
    }


    private static void oneThree() {
        System.out.println("Задание 1.3");
        System.out.println("Вводите строки,для ввыхода и просмотра нажмите 1");
        ArrayList<String> list = new ArrayList<>(0);
        String one = "1";
        for (int i = 0; ; i++) {
            Scanner scan1 = new Scanner(System.in);
            String str = scan1.nextLine();
            if ((str.equals(one))) {
                scan1.close();
                break;
            } else {
                list.add(str);
            }
        }
        for (String s : list) {
            System.out.print(s + " ");
        }
    }


    private static long oneFourV1(String i) {
        System.out.println("\nЗадание 1.4 Вариант 1");
        long h = Long.parseLong(i);
        System.out.println(h);
        return h;
    }

    private static long oneFourV2(String i) {
        System.out.println("Задание 1.4 Вариант 2");
        long h = Long.valueOf(i);
        System.out.println(h);
        return h;
    }

    private static long oneFourV3(String i) {
        System.out.println("Задание 1.4 Вариант 3");
        long h = new Long(i);
        System.out.println(h);
        return h;
    }

    private static void twoOne() {
        System.out.println("Задание 2.1");
        // Все верно ,после занятия стало понятно,"*"-ноль или больше поэтому здесь true
        Pattern pattern = Pattern.compile("h*");// скомпилировали регулярное выражение h*
        Pattern pattern1 = Pattern.compile("h+");
        Pattern pattern2 = Pattern.compile("h?");
        Matcher matcher = pattern.matcher("Я люблю Java");
        Matcher matcher1 = pattern1.matcher("Я люблю Java");
        Matcher matcher2 = pattern2.matcher("Я люблю Java");
        System.out.println(matcher.find());
        System.out.println(matcher1.find());//"+" - один или больше т.к в строке не одного h соответственно false
        System.out.println(matcher2.find());//"?"-ноль или один т.к у нас ноль значит true
    }

    private static void twoTwo(String link) throws Exception {
        System.out.println("Задание 2.2");
        Searcher searcher=new Searcher();
        searcher.search(link);
    }

    private static void phoneNumbers(String number){
        //+7 8 10 17754894  +375255277438 +375 25 527 74 38
        System.out.println("Поиск номера телефона");
        System.out.println(number.indexOf("+8615026861779"));
        Pattern pattern1 = Pattern.compile("\\+\\d+\\-?\\s?\\(?\\d+\\-?\\s?\\)?\\-?\\d+\\-?\\s?\\-?\\d+\\-?\\s?\\d+");
        Matcher matcher1 = pattern1.matcher(number);//
        while (matcher1.find()) {
            System.out.println(matcher1.group());
        }

    }
}















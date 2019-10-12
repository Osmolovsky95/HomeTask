package homeTaskFive;

import java.util.Calendar;
import java.util.Date;

public class HomeTaskFive {
    public static void main(String[] args) {
        oneOne();
        oneTwo();
        oneThree();
        two();

    }

    public static void oneOne() {
        System.out.println("Задание 1.2");
        Date date = new Date();
        Date date2 = new Date();
        System.out.println(date2 == date);
        System.out.println(date2.equals(date));
    }

    public static void oneTwo() {
        System.out.println("Задание 1.2");
        Date date = new Date();
        System.out.println(date.toString());
        int days = 5;
        int month = 1;
        long twentyFourHours = 86_400_000;
        long fiveDayOneMonth = (days * twentyFourHours) + (month * 31 * twentyFourHours);
        date.setTime(date.getTime()+fiveDayOneMonth);
        System.out.println(date.toString());
    }

    public static void oneThree() {
        System.out.println("Задание 1.3");
        Calendar calendar=Calendar.getInstance();
        calendar.set(2020,1,29);
        System.out.println(calendar.getTime());
        long twentyFourHours = 86_400_000;
        long year=twentyFourHours*365;
        calendar.setTimeInMillis(calendar.getTimeInMillis()+year);
        System.out.println(calendar.getTime());

    }

    public static void two() {
        System.out.println("Задание 2");
   Countries.Belarus.setArea(207595);
   Countries.Belarus.setPopulation(9_500_000);
   Countries.Russia.setArea(17_100_000);
   Countries.Russia.setPopulation(144_500_000);
        System.out.println("Площадь Беларуси составляет:"+Countries.valueOf("Belarus").getArea());
        System.out.println("Население России составляет:"+Countries.valueOf("Russia").getPopulation());
        System.out.println(Countries.valueOf("Belarus")==Countries.Belarus);
     //   System.out.println(Countries.valueOf("Java"));   ошибка
    }

}


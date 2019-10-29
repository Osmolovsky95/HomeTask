package homeTaskEight;

import java.util.*;

public class Main {
    public static void main(String[] args) throws SecondException, FirstException {
       // taskOneOne(6,0);
       // taskOneTwo(6,0);
       // taskOneThree(6,0);
        taskThree();

        House houseOne=new House();
        try {
            houseOne.setRooms(0);
        }
         catch (FirstException e){
            houseOne.setRooms(1);
        }

        Flat flatOne=new Flat();
        try {
            flatOne.setRooms(6);
        }
        catch (SecondException e){
            flatOne.setRooms(5);
       }
        System.out.println("В квартире установлено: "+flatOne.getRooms()+" комнат");
    }


    public static void taskOneOne(int a,int b){
        System.out.println("Task 1.1");
        try {
            int result = a / b;
            System.out.println(result);
        }
        catch (ArithmeticException e){
            System.out.println("Нельзя делить на 0");
        }
    }

    public static void taskOneTwo(int a,int b){
        System.out.println("Task 1.2");
        try {
            int result = a / b;
            System.out.println(result);
        }
        finally {
            System.out.println("Нельзя делить на 0");
        }
    }

    public static void taskOneThree(int a,int b){
        System.out.println("Task 1.3");
        try {
            int result = a / b;
            System.out.println(result);
        }
        catch (ArithmeticException e){
            System.out.println("Нельзя делить на 0");
        }
        finally {
            System.out.println("Блок finally независимо от результата");
        }
    }

    public static void taskThree(){
        System.out.println("Task 3");
        System.out.println("Введите 5 чисел");
       int [] array=new int[5];
        int error=0;
        ArrayList<Integer> arrayList=new ArrayList();
        if (error <=2){
        for (int i=0;i<array.length;i++) {
                try {
                    array[i] = Integer.parseInt(new Scanner(System.in).nextLine());
                } catch (NumberFormatException e) {
                    if(error<3) {
                        System.out.println("Invalid input");
                        error++;
                        i--;
                    }
                    else {
                        System.out.println("Больше 3 ошибок");
                        break;
                    }
                }
            }
        }
        else System.out.println("Больше 3");

        for (int i=0;i<array.length;i++){
        arrayList.add(i,array[i]);
         }
        Collections.sort(arrayList);
        System.out.println(arrayList.toString());
    }
}



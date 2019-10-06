package homeTaskThree;

import java.sql.SQLOutput;

public class HomeTaskThree {
    public static void main(String[] args) {
      //oneOne();
     //oneTwo(7);
     //   twoOne();
      //  twoTwo();
        //  twoThree();
        three();
    }
    //Задание 1.1
    public static void oneOne(){
        int [] array=new int[10];
        for (int i=1;i<array.length;i++){
            for (int j=1;j<=array.length;j++){
                System.out.println(i+" * "+j+" = "+i*j);
            }
        }

    }
    //Задание 1.2
    public static void oneTwo(int number){
        for (int i=1;i<=number;i++){
            for (int j=1;j<=number;j++){
                System.out.println(i+" * "+j+" = "+i*j);
            }
        }
    }

    //Задание 1.3

    //Задание 2.1
    public static void twoOne(){
        int [] array={5,2,3,45,67,7,8,8,312,99,100};
        int i=0;
        //do-while
        do {

            System.out.println(array[i]);
            i++;
        }
        while (i<array.length);
       //while
       i=0;
       while (i<array.length){
           System.out.println(array[i]);
           i++;
       }
       //for
       for (i=0;i<array.length;i++){
           System.out.println(array[i]);
       }
       //foreach
       for(int s:array){
           System.out.println(s);
       }
    }

    //Задание 2.2
    public static void twoTwo(){
        int [] array=new int[70];
        for (int i=0;i<array.length;i++){
            array[i]=(int)(Math.random()*40);
            if(i%2==0){
                System.out.println(i+" : "+array[i]);
            }
        }
    }

    public static void twoThree(){
        Test [] array=new Test[10];
        int i=0;
        int a=2;
        for (i=0;i<array.length;i++){
            array[i]=new Test();
        }
        array[4]=null;
        for (i=0;i<array.length;i++){
            if(i%2==0){
                System.out.println(i+" : "+array[i]);
                if(array[i]==null){
                    break;
                }
            }
        }
    }

    //Задание 3

    public static void three(){
       Car[]cars = new Car[30];
       for (int i=0;i<cars.length;i++){
          if (i%2!=0){
              cars[i]=new Bmw("X5",2010);
          }
          else {
              cars[i]=new Audi("A6",2015);
          }
           System.out.println(cars[i]);
       }
    }





}

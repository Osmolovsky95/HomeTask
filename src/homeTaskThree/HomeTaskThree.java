package homeTaskThree;




public class HomeTaskThree {
    public static void main(String[] args) {
      oneOne();
      int [] j = new int [args.length];
        for (int i = 0; i < args.length; i++) {
            j[i] = Integer.parseInt(args[i]);
        }
      oneTwo(j[0]);
      oneThree(j[0]);
      twoOne();
      twoTwo();
      twoThree();
      three();

    }
    //Задание 1.1
    public static void oneOne(){
        System.out.println();
        System.out.println("ЗАДАНИЕ 1.1");
        int [] array=new int[10];
        for (int i=1;i<array.length;i++){
            for (int j=1;j<=array.length;j++){
                System.out.println(i+" * "+j+" = "+i*j);
            }
        }

    }
    //Задание 1.2
    public static void oneTwo(int number){
        System.out.println();
        System.out.println("ЗАДАНИЕ 1.2");
        for (int i=1;i<=number;i++){
            for (int j=1;j<=number;j++){
                System.out.println(i+" * "+j+" = "+i*j);
            }
        }
    }

    //Задание 1.3
    public static void oneThree(int number){
        System.out.println();
        System.out.println("ЗАДАНИЕ 1.3");
        System.out.println("Получено число: "+number);
        String lenght=""+number;
        int sum=1;
       int massiv[]=new int[lenght.length()];
       for (int i=0;i<massiv.length;i++){
           massiv[i]=number%10;
           number=number/10;
           if(i!=0){
           System.out.print("Умножаю:" +sum);
           System.out.println(" и "+massiv[i]);}
           sum=sum*massiv[i];
       }
        System.out.println("Произведение равно:  "+sum);
    }

    //Задание 2.1
    public static void twoOne(){
        System.out.println();
        System.out.println("ЗАДАНИЕ 2.1");
        int [] array={5,2,3,45,67,7,8,8,312,99,100};
        int i=0;
        System.out.println("Цикл do");
        //do-while
        do {

            System.out.println(array[i]);
            i++;
        }
        while (i<array.length);
       //while
        System.out.println("Цикл while");
       i=0;
       while (i<array.length){
           System.out.println(array[i]);
           i++;
       }
       //for
        System.out.println("Цикл for");
       for (i=0;i<array.length;i++){
           System.out.println(array[i]);
       }
       //foreach
        System.out.println("Цикл foreach");
       for(int s:array){
           System.out.println(s);
       }
    }

    //Задание 2.2
    public static void twoTwo(){
        System.out.println();
        System.out.println("ЗАДАНИЕ 2.2");
        int [] array=new int[70];
        for (int i=0;i<array.length;i++){
            array[i]=(int)(Math.random()*40);
            if(i%2==0){
                System.out.println(i+" : "+array[i]);
            }
        }
    }
  //Задание 2.3
    public static void twoThree(){
        System.out.println();
        System.out.println("ЗАДАНИЕ 2.3");
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
        System.out.println();
        System.out.println("ЗАДАНИЕ 3");
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

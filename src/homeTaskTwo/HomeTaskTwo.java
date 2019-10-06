package homeTaskTwo;

public class HomeTaskTwo {
    public static void main(String[] args) {
        fiveOne();
        fiveThree();
        fiveFour();
        fiveFive();
        fiveSix();
        fiveEight();
        fiveNine();

        //Задание 1.1
        int a = 2; //0000 0010
        int b = 15;//0000 1111
        int c = 3;
        System.out.println(b >> a);// 0000 0011

        //Задание 1.2
        //  double c=155.5; Так делать нельзя))и не получится
        // double d=c>>2;
        //System.out.println(c>>);

        //Задание 1.3
        int s = -55;
        System.out.println(s >> 3);

        /*Задание 2
        Разница между &,| и &&,|| в том что вторая версия это укороченные операторы,и при операции ||
        если первый операнд равен true все выражение будет true,второй операнд не рассматривается.
        В случае && если первый операнд false то все выражение false,второй операнд не рассматривается.
        Операция XOR^ Если операнды одинаковые то равно 0,если разыне то 1.
        */

        //Задание 3
        if (a + c > b) {
            System.out.println("Утверждение верно");
        } else {
            System.out.println("Утверждение не верно");
        }
        String print = a + c > b ? "Утверждение верно" : "Утверждение  не верно";
        System.out.println(print);

        //Задание 4
        // IComputer c2 = new AsusComputer(10, 1008); Создаем ссылку Icomp ,которая ссылается на объект AsusCom.
        //  IComputer c3 = new AcerComputer(10, 4608);
        // System.out.println(c2 instanceof AsusComputer); будет true Проверяем c2 является AsusComp.
        // System.out.println(c2 instanceof IComputer); будет true Проверяем c2 является Icomp.
        // System.out.println(c3 instanceof IComputer); будет true Проверяем c3 является Icomp.
        // System.out.println(c2 instanceof AcerComputer); будет false Проверяем c3 является AcerComp.

        //Задание 4.1
        //Воспроизводим ClassCastException
        //  IComputer c2 = new AsusComputer(10, 1008); Создаем 2 ссылки на разные объекты
        //  IComputer c3 = new AcerComputer(10, 4608); Приводим один тип к другому,т.к они оба в разных ветках наследования
        //AcerComputer acerComputer=(AcerComputer)c2; не получится Asus сделать Acer

        //Теперь избегаем  ClassCastException
        // AcerComputer acerComputer=new AsusComputer(10, 1008);
        // if (c2 instanceof AcerComputer){ Чтобы не получить classCastEx. проверяем является ли с2 Acer,если да приводим.
        //AcerComputer acerComputer=(AcerComputer)c2; Если нет ничего не делаем
        //  }
    }

        private static void fiveOne() {
            int v = 5 + 2 / 8;
            System.out.println("5.1" + v);// т.к 2/8=0 если есть int, 5+0=5;
            int y = (5 + 2) / 8;// равно 0, т.к 7/8=0;
            System.out.println("5.2 " + y);
        }

        //5.3Пример ниже все понятно т.к 2++ значит 2 инкременирует после извлечения выражения,следовательно 9/8
        // записывает 1, т.к int
        private static void fiveThree() {
            int two = 2;
            int u = (5 + 2 + two++) / 8;
            System.out.println("5.3 " + u);
        }


        private static void fiveFour() { //результат 1 т.к 9/7 = 1 int. Переменная two инкременируется после извлечения
            int two = 2; // выражения ,а переменная eight до. Поэтому на момент извлечения two=2,eight=7;
            int eight = 8;
            int result = (5 + 2 + two++) / --eight;
            System.out.println("5.4 " + result);
        }

        private static void fiveFive() { // результат 0,т.к 5*2=10 = 0000 1010;
            int two = 2; // сдвигаем 2 бита вправо получаем 2 или 0000 0010
            int eight = 8; // 2/7=0.
            int resultt = (5 * 2 >> two++) / --eight;
            System.out.println("5.5 " + resultt);
        }

        private static void fiveSix() { //результат 1 ,т.к 5+7 не больше 20
            int two = 2;                // переходим к блоку false 22*2=44 или 0010 1100
            int eight = 8;              //Сдвигаем 2 бита вправо получаем      0000 1011  =11
            int five = 5;               // 11/7=1
            int seven = 7;
            int twenty = 20;
            int sixEight = 68;
            int twentytwo = 22;
            int result1 = (five + seven > twenty ? sixEight : twentytwo * 2 >> two++) / --eight;
            System.out.println("Шестое: "+result1);
        }

        //Задание 5.7 не скомпилируется нет такого оператора "=>"

        private static void fiveEight() { // будет false т.к 12*12>119
            int six = 6;                 // получаем  true && false == false
            int two = 2;
            int three = 3;
            int twelve = 12;
            boolean yes;
            yes = six - two > 3 && twelve * twelve <= 119;
            System.out.println(yes);

        }

        private static void fiveNine() { // То же самое что и прошлое задание
            boolean yes=true;
            boolean no=false;
            boolean result;
            result=true&&false;
            System.out.println(result);

        }

       /* Задание 6
        Код выдаст ошибку nullPointerException,т.к Integer -объект который создается операцией new,
        ему в конструктор передается значение. Т.к все поля этого класса не проинициализированы то переменные
        примитивных типов будут равны 0,а переменная k=null,т.к эта оболочка является объектом.
        Поэтому возникает ошибка.Если проинициализировать эту переменную ошибки не будет)
        */






}

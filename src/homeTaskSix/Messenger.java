package homeTaskSix;

import homeTaskSix.messenger.*;

import java.util.Date;
import java.util.Scanner;

public class Messenger {

    /**Мессенджер
     * 1. Вводить ник:
     *  1.1 Должен быть только латинскими буквами
     *  1.2 Должен быть не меньше 5 символов
     *  1.3 Не должен начинаться с цифры
     *  1.4 Не должен содержать #,!,\
     * 2. Сообщения вводятся через консоль
     * 3. Сообщения хранятся в массиве
     * 4. Можно отредактировать своё сообщение если оно не старше минуты
     * 5. Можно писать отложенные сообщения
    **/
    public static User getValidUser(){
        User user = null;
        boolean flag = false;
        do{
            System.out.println("Введите имя пользователя:");
            Scanner scanner=new Scanner(System.in);
            String nameUser=scanner.nextLine();
            System.out.println("Введите пароль пользователя");
            String passwordUser=scanner.nextLine();
            user = new User (nameUser, passwordUser);
            flag = ValidateUser.checkUser(user);
            if (!flag) {
                System.out.println("Invalid user");
            }
        } while (!flag);
        return user;
    }

    public static void main(String[] args) {

        User user1 = (getValidUser());
        User user2 = getValidUser();
        Dialogs dialogs = new Dialogs();
        dialogs.addUser(user1);
        dialogs.addUser(user2);

        System.out.println("Введите сообщение для начала переговоров,для выхода введите 1");
      boolean dialogTrue=true;
      String close="1";
      int chat=2;
      for(int i=0;i<chat;i++) {
          while (dialogTrue) {
              Scanner scaner=new Scanner(System.in);
              String inputFirstUser;
              String inputSecondUser;
              System.out.print(user1.getLogin()+" :");
              dialogs.addMessages(new Message(inputFirstUser=scaner.nextLine(), user1, new Date()));
              //Ввод отложенного сообщения
              dialogs.addDelayMessages(new Message(inputFirstUser=scaner.nextLine(), user1, new Date()));
              System.out.print(user2.getLogin()+" :");
              dialogs.addMessages(new Message(inputSecondUser=scaner.nextLine(), user2, new Date()));
              if (inputFirstUser.equals(close)||inputSecondUser.equals(close)) {
                  dialogTrue = false;

              } else {
                  chat++;
                  break;
              }
          }
      }
        System.out.println("Какое сообщение в диалоге хотите отредактировать(индекс элемента массива)?");
      dialogs.editMessage(dialogs.getMessages()[Integer.parseInt(new Scanner(System.in).nextLine())]);

        System.out.println("Какое сообщение хотите удалить(индекс элемента массива)?");
        dialogs.deleteMessage(dialogs.getMessages(),new Scanner(System.in).nextInt());


        for(Message mes:dialogs.getDelayMessages()){
            System.out.println("отложенное сообщение");
            System.out.println(mes);
        }
        dialogs.history(new ConsoleSaver(System.out));
        dialogs.history(new FileSaver(null));

        dialogs.userHistory(user1);
    }
}

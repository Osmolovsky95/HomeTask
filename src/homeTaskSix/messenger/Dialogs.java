package homeTaskSix.messenger;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Dialogs {
    private Message[] messages = new Message[0];

    public void addMessages(Message message){
        this.addMessages(new Message[]{message});
    }

    public void addMessages(Message [] messages){
        if (messages != null && messages.length != 0) {
            this.messages = Arrays.copyOf(this.messages, this.messages.length + messages.length);
            int messagesLength = messages.length;
            for (Message mes : messages) {
                this.messages[this.messages.length - messagesLength--] = mes;
            }
        }
    }

    public void editMessage(Message message) {
        System.out.println("Введите пароль пользователя для редактирования");
        if(message.getUser().getPassword().equals(new Scanner(System.in).nextLine())) {
            Date date = new Date();
            System.out.println("Редактируем сообщение :\"" + message.getMessage() + "\"");
            if (message.getDate().getTime() >= new Date().getTime() - 60000) {
                message.setDate(new Date());
                message.setMessage(new Scanner(System.in).nextLine());
            } else {
                System.out.println("Сообщение старше минуты");
            }
        }
        else System.out.println("Нет доступа!");
    }

           public void delayMessage(Message message,int min) {
           long dateMessage=message.getDate().getTime();
           message.getDate().setTime(dateMessage+60000*min);
           addMessages(message);
           }
//    public Message[] getMessages() {
//        return messages;
//    }

    public Message[] getMessages() {
        return messages;
    }

    public void history(IHistorySaver saver){
        for (Message message : this.messages) {
            saver.println(message.toString());
        }

    }


}

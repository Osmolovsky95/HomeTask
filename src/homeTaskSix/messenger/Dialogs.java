package homeTaskSix.messenger;

import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Dialogs {
    private Message[] messages = new Message[0];
    private User[]users=new User[0];
    private Message[] delayMessages=new Message[0];

   public void addUser(User user) {
       System.out.println("Добавление пользователя: " + user.getLogin());
       for (User userFor : this.users) {
           if (userFor == null) {
               userFor = user;
           } else {
               User[] users = Arrays.copyOf(this.users, this.users.length + 1);
               users[users.length - 1] = user;
           }
       }
   }

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

    public void addDelayMessages(Message message){
        addDelayMessages(new Message[]{message});
    }

    public void addDelayMessages(Message [] messages){
        if (messages != null && messages.length != 0) {
             this.delayMessages =Arrays.copyOf(this.delayMessages,this.delayMessages.length+messages.length);
            int messagesLength = messages.length;
            for (Message mes : messages) {
                mes.getDate().setTime(mes.getDate().getTime()+120000);
                this.delayMessages[this.delayMessages.length-messagesLength--]=mes;
            }
        }
    }

    public Message[] getDelayMessages() {
        return delayMessages;
    }


    public Message[] getMessages() {
        return messages;
    }

    public void userHistory(User user){
        System.out.println("Сообщения пользователя: "+user.getLogin());
        for (Message message:this.messages){
            if (message.getUser().equals(user)){
                System.out.println(message.toString());
            }
        }
    }



   public  void deleteMessage(Message[] messages, int index){
        Message [] copyMessage=new Message[messages.length-1] ;
        int delete=index;
        for(int i=0;i<copyMessage.length;i++) {
            if (i != delete) {
                copyMessage[i] = messages[i];}
            if (i>=delete){copyMessage[i] = messages[i+1];}
        }
        this.messages=copyMessage;
    }

    public void history(IHistorySaver saver){
        Message[] messages = Arrays.copyOf(this.messages, this.messages.length + this.delayMessages.length);
        System.arraycopy(this.delayMessages, 0, messages, this.messages.length, this.delayMessages.length);
        this.messages=messages;
        for (Message message : this.messages) {
            saver.println(message.toString());
        }

    }


}

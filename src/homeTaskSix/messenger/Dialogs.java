package homeTaskSix.messenger;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Dialogs {
    private Message[] messages = new Message[0];
    private User[]users;
    private Message[] delayMessages=new Message[0];


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

    public void delayMessages(Message message){
        delayMessages(new Message[]{message});
    }

    public void delayMessages(Message [] messages){
        if (messages != null && messages.length != 0) {
            this.delayMessages = Arrays.copyOf(messages, delayMessages.length + messages.length);
            int messagesLength = messages.length;
            for (int i=0;i<delayMessages.length;i++) {
                delayMessages[i] = messages[i];
            }
        }
    }

    public Message[] getDelayMessages() {
        return delayMessages;
    }
//    public Message[] getMessages() {
//        return messages;
//    }

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
        Message [] messages=Arrays.copyOf(this.messages,this.messages.length+this.delayMessages.length);
        for (int i=this.messages.length;i<messages.length;i++){
            for (int j=0;j<this.delayMessages.length;j++){
                messages[i]=this.delayMessages[j];
            }
        }
        for (Message message : messages) {
            saver.println(message.toString());
        }

    }


}

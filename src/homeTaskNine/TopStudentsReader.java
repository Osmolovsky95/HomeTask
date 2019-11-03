package homeTaskNine;

import java.io.*;

public class TopStudentsReader {

    public static void topStudentsReader(String topStudentsFile,int countPerson,int amount) {
        int counter = countPerson - amount;
        if (counter>=0) {
            try {
                FileInputStream fileInputStream = new FileInputStream(topStudentsFile);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                while (countPerson != counter) {
                    System.out.println((Person) objectInputStream.readObject());
                    countPerson--;
                }
                objectInputStream.close();
            } catch (
                    EOFException | FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        else System.out.println("Error");

        }
}
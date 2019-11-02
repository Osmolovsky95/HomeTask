package homeTaskNine;

import java.io.*;

public class TopStudentsReader {

    public static void topStudentsReader(String topStudentsFile,int countPerson) {
        try {
            FileInputStream fileInputStream = new FileInputStream(topStudentsFile);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            int counter = countPerson - 34;
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
}
package homeTaskFour;

import java.io.FileInputStream;
import java.io.IOException;

public class SimpleSearch implements IRobot {
    public void search(String link) throws IOException {
        FileInputStream input = new FileInputStream(link);
        byte[] massiv = new byte[input.available()];
        input.read(massiv);
        String warAndWorld = new String(massiv);
        int index;
        index=warAndWorld.indexOf("война");
        System.out.println("Первое слово\"война\" начинается с индекса "+index);


    }
}

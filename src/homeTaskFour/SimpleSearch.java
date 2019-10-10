package homeTaskFour;

import java.io.FileInputStream;
import java.io.IOException;

public class SimpleSearch implements IRobot {
    public  void search(String link) throws IOException {
        FileInputStream input = new FileInputStream(link);
        byte[] massiv = new byte[input.available()];
        input.read(massiv);
        String warAndWorld = new String(massiv);
        int index = 0;
        index = warAndWorld.indexOf("война");
        String[] massiv2 = warAndWorld.split(" +");
        String str = "война война белеберда саша война война";
        String[] massiv3 = str.split(" +");
        int j=0;
        for (int i = 0; i < massiv2.length; i++) {
            if (massiv2[i].equals("война")) {
                           j++;
            }
        }
        System.out.println("Слово \"война\" встречается " + j + " раз");
    }
}


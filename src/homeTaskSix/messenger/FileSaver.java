package homeTaskSix.messenger;

import java.io.*;


public class FileSaver  {

    private final File stream;

    public FileSaver(File stream) {
        this.stream = stream;
    }


    public void saveToFile(Dialogs dialogs) throws IOException {
        FileOutputStream fileOutputStream=new FileOutputStream(stream);
        ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(dialogs);
    }

}


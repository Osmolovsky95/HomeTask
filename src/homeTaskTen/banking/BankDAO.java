package homeTaskTen.banking;

import java.io.*;

public class BankDAO {

    public BankDAO(DataBaseBanks dataBaseBanks) throws IOException {
        outputToFile(dataBaseBanks);
    }
    private void outputToFile(DataBaseBanks dataBaseBanks) throws IOException {
       File banks=new File ("banks.txt");
        FileOutputStream fileOutputStream=new FileOutputStream(banks);
        ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(dataBaseBanks);
        objectOutputStream.close();
        fileOutputStream.close();
    }
}

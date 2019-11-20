package homeTaskTen.banking;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DataBaseBanks implements Serializable {
   private List<Bank> banks=new ArrayList<>();

    public List<Bank> getBanks() {
        return banks;
    }
}

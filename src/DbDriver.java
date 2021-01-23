import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DbDriver {
    Map<Integer, Driver> dbDriver =new  HashMap<>();
    private int driverCounter=0;
    List<Integer> listId = new ArrayList<>();

    public int getDriverCounter() {
        if (driverCounter == 0){
            return 0;
        }
        return driverCounter;
    }

    public List<Integer> getId() {
        return listId;
    }

    public void setDriver(Driver driver){
        setDriverCounter();
        dbDriver.put(driverCounter, driver);
        listId.add(driverCounter);

    }

    private void setDriverCounter() {
        driverCounter = driverCounter+1;
    }

    public Driver getDriver(int id){

        return dbDriver.get(id);
    }



    public void del(int id, int listKey){
        driverCounter=driverCounter-1;
        dbDriver.remove(id);
        listId.remove(listKey);
    }
}

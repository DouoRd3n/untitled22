import java.util.LinkedList;
import java.util.Queue;

public class BusStorage {
    Queue <Bus> busList = new LinkedList<>();



    public synchronized Bus getBus() throws InterruptedException {

         while (busList.isEmpty()){
            Thread.sleep(5000);
         }
         return busList.poll();
     }
     public synchronized void setBusList(Bus bus){

        busList.offer(bus);
     }
}


public class MyCustomThread2 implements Runnable{
    private Driver driver;


    public MyCustomThread2(Driver driver) {
        this.driver = driver;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Водій " + driver.getClass().getName() + " виїхав на маршрут на автобусі " + driver.getBus().getBusNumber());
    }
    }


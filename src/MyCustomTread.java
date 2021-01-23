public class MyCustomTread implements Runnable {
    private Driver driver;

    public MyCustomTread(Driver driver) {
        this.driver = driver;
    }

    @Override
    public void run() {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Водій " + driver.getClass().getName() + " прибув на місце призначення");
    }
}

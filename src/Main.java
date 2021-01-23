import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class Main {
    private static BusStorage  busStorage = new BusStorage();
    public static void main(String[] args) {

        printMenu();
        setBus();
        doAction();
    }

    private static void setBus() {
        for (int i = 0; i < 5 ; i++) {
            busStorage.setBusList(new Bus(i+1));
        }

    }

    private static void doAction() {
        DbDriver dbDriver = new DbDriver();
        int key;
        while (true) {
            key = getAction();

            if (key == 1) {
                addDriver(dbDriver);
            } else if (key == 2) {
                sendOnRoad(dbDriver);

            } else if (key == 3) {
                break;
            }
        }
    }

    private static void sendOnRoad(DbDriver dbDriver) {
        int drivers = dbDriver.getDriverCounter();
        ArrayList<Integer> listId = (ArrayList<Integer>) dbDriver.getId();
        if (drivers != 0) {
            int someKey = (int) (Math.random() * (listId.size()));
                int id = listId.get(someKey);
                Driver driver = dbDriver.getDriver(id);
                System.out.println("Водій " + dbDriver.getDriver(id).getClass().getName() + id + "  вирушив в гараж");
                threadBusRun(driver);
                threadRun(dbDriver.getDriver(id));
                returnBusOfGarage(driver);
                dbDriver.del(id, someKey);


        } else if (drivers == 0) {
            System.out.println("Водіїв більше немає");
        }
    }

    private static void returnBusOfGarage(Driver driver) {
        busStorage.setBusList(driver.getBus());

    }

    private static void threadBusRun(Driver driver)  {
        Thread thread = new Thread(new MyCustomThread2(driver));

        try {
            driver.setBus(busStorage.getBus());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.run();
    }

    private static void threadRun(Driver driver) {
        Thread thread = new Thread(new MyCustomTread(driver));
        thread.run();

    }


    private static void addDriver(DbDriver dbDriver) {
        putDriver(dbDriver);
        while (true) {
            printElseMenu();
            int keySmal = getAction();
            if (keySmal == 1) {
                putDriver(dbDriver);
            } else if (keySmal == 2) {
                printMenu();
                break;
            }
        }
    }

    private static void putDriver(DbDriver dbDriver) {

        dbDriver.setDriver(new Driver());
    }

    private static String getName() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = "";
        try {
            name = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return name;
    }

    private static void printElseMenu() {
        System.out.println(" smal Menu");
        System.out.println("1) додати ще");
        System.out.println("2) Повернутися до попереднього меню");
    }

    private static int getAction() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int key = 0;
        try {
            key = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return key;
    }

    private static void printMenu() {
        System.out.println("        МЕНЮ");
        System.out.println("1) Додати водія");
        System.out.println("2) Відправити на маршрут");
        System.out.println("3) Вийти");
    }
}

package parkingPack;

import java.util.ArrayList;
import java.util.List;

public class Parking {
    private String type;
    private int capacity;
    private List<Car> data;

    public Parking(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }



    public void add(Car car) {
        if (this.capacity > data.size()) {
            data.add(car);
        }
    }

    public boolean remove(String manufacturer, String model)  {
        return data.removeIf(obj -> obj.getManufacturer().equals(manufacturer)&&obj.getModel().equals(model));

    }

    public Car getLatestCar() {
        int max = 0;
        Car latestCar = null;

        for (Car car : data) {
            if (car.getYear() > max) {
                max = car.getYear();
                latestCar = car;
            }

        }

        return latestCar;
    }

    public Car getCar(String manufacturer, String model)  {
        for (Car car : data) {
            if (car.getManufacturer().equals(manufacturer)&&car.getModel().equals(model)) {
                return car;
            }

        }

        return null;
    }

    public int getCount() {
        return data.size();
    }
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("The cars are parked in %s:%n",this.type));
        for (Car car : data) {
            sb.append(car);
            sb.append(System.lineSeparator());

        }

        return sb.toString();
    }

}
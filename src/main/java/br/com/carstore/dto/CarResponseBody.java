package br.com.carstore.dto;

import java.util.List;

public class CarResponseBody {

    private List<CarDTO> cars;

    public CarResponseBody(List<CarDTO> allCars) {
        this.cars = allCars;
    }

    public List<CarDTO> getCars() {
        return cars;
    }

    public void setCars(List<CarDTO> cars) {
        this.cars = cars;
    }

}

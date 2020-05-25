package simsona.springcarscemo.services.services;

import simsona.springcarscemo.services.models.CarServiceModel;

import java.util.List;

public interface CarService {
    CarServiceModel save(CarServiceModel model);

    List<CarServiceModel> getCars();
}

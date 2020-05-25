package simsona.springcarscemo.services.services.implement;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import simsona.springcarscemo.date.models.Car;
import simsona.springcarscemo.date.repositories.CarRepository;
import simsona.springcarscemo.services.models.CarServiceModel;
import simsona.springcarscemo.services.services.CarService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {
    private final ModelMapper modelMapper;
    private final CarRepository carRepository;

    public CarServiceImpl(ModelMapper modelMapper, CarRepository carRepository) {
        this.modelMapper = modelMapper;
        this.carRepository = carRepository;
    }

    @Override
    public CarServiceModel save(CarServiceModel model) {
        this.carRepository.saveAndFlush(this.modelMapper.map(model, Car.class));
        return model;
    }

    @Override
    public List<CarServiceModel> getCars() {
        return this.carRepository
                .findAll()
                .stream()
                .map(car -> this.modelMapper.map(car, CarServiceModel.class))
                .collect(Collectors.toList());
    }
}

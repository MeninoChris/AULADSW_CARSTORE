package br.com.carstore.service;

import br.com.carstore.dao.CarDao;
import br.com.carstore.dto.CarDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CarServiceImpl implements CarService {

    private CarDao dao;

    public CarServiceImpl(CarDao dao) {
         this.dao = dao;
    }

    @Override
    public List<CarDTO> findAll() {
        return dao.findAll();
    }

    @Override
    public void save(CarDTO carDTO) {
        dao.save(carDTO);
    }

    @Override
    public void deleteById(String id) {
        dao.deleteById(id);
    }

    @Override
    public void update(String id, CarDTO carDTO) {
        dao.update(id, carDTO);
    }

}

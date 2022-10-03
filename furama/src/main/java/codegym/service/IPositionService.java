package codegym.service;

import  codegym.model.employee.Position;

import java.util.List;

public interface IPositionService {

    List<Position> findAll();
}

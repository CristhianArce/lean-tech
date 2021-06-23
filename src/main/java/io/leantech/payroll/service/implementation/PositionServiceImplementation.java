package io.leantech.payroll.service.implementation;

import io.leantech.payroll.model.Employee;
import io.leantech.payroll.model.Position;
import io.leantech.payroll.repository.PositionRepository;
import io.leantech.payroll.service.contract.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PositionServiceImplementation implements PositionService {

    @Autowired
    PositionRepository positionRepository;

    @Override
    public List<Position> getAllPositions() {
        return  positionRepository.findAllPositions()
                .stream()
                .map(position -> {
                    position.setEmployees(position.getEmployees()
                            .stream()
                            .sorted(Comparator.comparing(Employee::getSalary).reversed())
                            .collect(Collectors.toList()));
                    return position;
                })
                .collect(Collectors.toList());
    }
}

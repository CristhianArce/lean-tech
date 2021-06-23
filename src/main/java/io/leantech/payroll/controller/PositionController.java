package io.leantech.payroll.controller;

import io.leantech.payroll.model.Employee;
import io.leantech.payroll.model.Position;
import io.leantech.payroll.service.contract.PositionService;
import io.leantech.payroll.service.implementation.PositionServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/position")
public class PositionController {

    @Autowired
    PositionService positionService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Position> getAllEmployees(){
        return positionService.getAllPositions();
    }

}

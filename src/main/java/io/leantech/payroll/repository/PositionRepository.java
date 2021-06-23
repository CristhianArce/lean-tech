package io.leantech.payroll.repository;

import io.leantech.payroll.model.Position;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PositionRepository extends CrudRepository<Position, Long> {

    @Query("SELECT e FROM Position e WHERE e.name = :positionName")
    Optional<Position> findPositionByName(String positionName);

    @Query("SELECT e FROM Position e")
    List<Position> findAllPositions();
}

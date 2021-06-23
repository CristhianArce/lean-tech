package io.leantech.payroll.repository;

import io.leantech.payroll.model.Candidate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CandidateRepository extends CrudRepository<Candidate, Long> {
}

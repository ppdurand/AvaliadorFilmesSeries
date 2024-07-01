package edu.AvaliadorFilmesSeries.domain.repository;

import edu.AvaliadorFilmesSeries.domain.model.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends JpaRepository<Log, Integer> {
}

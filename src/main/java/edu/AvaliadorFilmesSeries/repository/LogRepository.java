package edu.AvaliadorFilmesSeries.repository;

import edu.AvaliadorFilmesSeries.model.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends JpaRepository<Log, Integer> {
}

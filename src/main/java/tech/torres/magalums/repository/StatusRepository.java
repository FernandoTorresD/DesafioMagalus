package tech.torres.magalums.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.torres.magalums.entity.Status;

public interface StatusRepository extends JpaRepository<Status, Long> {
}

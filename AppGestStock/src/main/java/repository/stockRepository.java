package repository;


import entity.stock;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface stockRepository extends JpaRepository<stock, Long> {
}

package repository;

import entity.fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface fournisseurRepository extends JpaRepository<fournisseur, Long> {
}

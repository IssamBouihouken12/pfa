package repository;

import entity.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface userRepository extends JpaRepository<user, Long> {
}

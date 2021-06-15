package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.core.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {
    User getByEmail(String email);
}

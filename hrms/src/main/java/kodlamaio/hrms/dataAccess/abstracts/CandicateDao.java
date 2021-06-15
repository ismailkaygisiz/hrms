package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.Candicate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandicateDao extends JpaRepository<Candicate, Integer> {
    Candicate getByIdentityNumber(String identityNumber);
}

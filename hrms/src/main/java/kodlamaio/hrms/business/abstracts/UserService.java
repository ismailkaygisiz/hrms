package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.entities.concretes.User;
import kodlamaio.hrms.core.utilities.results.DataResult;

import java.util.List;

public interface UserService {
    DataResult<List<User>> getAll();

    DataResult<User> getByEmail(String email);
}

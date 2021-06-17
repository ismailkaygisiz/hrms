package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Candicate;

import java.util.List;

public interface CandicateService {
    DataResult<List<Candicate>> getAll();

    DataResult<Candicate> getByIdentityNumber(String identityNumber);

    Result add(Candicate candicate) throws Exception;
}

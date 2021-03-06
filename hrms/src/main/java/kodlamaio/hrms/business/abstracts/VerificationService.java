package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.entities.concretes.Verification;
import kodlamaio.hrms.core.utilities.results.DataResult;

import java.util.List;

public interface VerificationService {
    DataResult<List<Verification>> getAll();
}

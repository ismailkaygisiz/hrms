package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.VerificationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.VerificationDao;
import kodlamaio.hrms.entities.concretes.Verification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VerificationManager implements VerificationService {
    VerificationDao verificationDao;

    @Autowired
    public VerificationManager(VerificationDao verificationDao) {
        this.verificationDao = verificationDao;
    }

    @Override
    public DataResult<List<Verification>> getAll() {
        return new SuccessDataResult<List<Verification>>(verificationDao.findAll());
    }
}

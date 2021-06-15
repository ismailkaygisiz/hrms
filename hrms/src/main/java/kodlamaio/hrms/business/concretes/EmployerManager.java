package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.business.BusinessRules;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerManager implements EmployerService {
    private EmployerDao employerDao;
    private UserService userService;

    @Autowired
    public EmployerManager(EmployerDao employerDao, UserService userService) {
        this.employerDao = employerDao;
        this.userService = userService;
    }

    @Override
    public DataResult<List<Employer>> getAll() {
        return new SuccessDataResult<List<Employer>>(employerDao.findAll());
    }

    @Override
    public Result add(Employer employer) {
        Result result = BusinessRules.run(
                checkWebSiteForEmail(employer),
                checkIfUserIsAlreadyExists(employer.getEmail())
        );

        if(result != null){
            return result;
        }

        employer.setConfirmed(false);
        employerDao.save(employer);
        return new SuccessResult();
    }

    private Result checkIfUserIsAlreadyExists(String email){
        var result = userService.getByEmail(email).getData();

        if(result != null){
            return new ErrorResult("User already exists");
        }

        return new SuccessResult();
    }

    private Result checkWebSiteForEmail(Employer employer){
        return new SuccessResult();
    }
}

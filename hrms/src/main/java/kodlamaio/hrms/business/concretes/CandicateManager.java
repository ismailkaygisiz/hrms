package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.CandicateService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.business.BusinessRules;
import kodlamaio.hrms.core.entities.concretes.User;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.CandicateDao;
import kodlamaio.hrms.entities.concretes.Candicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandicateManager implements CandicateService {
    private CandicateDao candicateDao;
    private UserService userService;

    @Autowired
    public CandicateManager(CandicateDao candicateDao, UserService userService) {
        this.candicateDao = candicateDao;
        this.userService = userService;
    }

    @Override
    public DataResult<List<Candicate>> getAll() {
        return new SuccessDataResult<List<Candicate>>(candicateDao.findAll());
    }

    @Override
    public DataResult<Candicate> getByIdentityNumber(String identityNumber) {
        return new SuccessDataResult<Candicate>(candicateDao.getByIdentityNumber(identityNumber));
    }

    @Override
    public Result add(Candicate candicate) {
        Result result = BusinessRules.run(
                checkIfUserIsAlreadyExists(candicate)
        );

        if (result != null) {
            return result;
        }

        candicate.setConfirmed(false);
        candicateDao.save(candicate);
        return new SuccessResult();
    }

    private Result checkIfUserIsAlreadyExists(Candicate candicate) {
        User user = userService.getByEmail(candicate.getEmail()).getData();
        if (user != null) {
            return new ErrorResult("User already exists");
        }

        var _candicate = getByIdentityNumber(candicate.getIdentityNumber()).getData();
        if (_candicate != null) {
            return new ErrorResult("Identity number already exists");
        }

        return new SuccessResult();
    }
}

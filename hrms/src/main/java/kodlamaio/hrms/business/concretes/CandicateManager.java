package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.CandicateService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.business.adapters.MernisServiceAdapter;
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
    private MernisServiceAdapter mernisServiceAdapter;

    @Autowired
    public CandicateManager(CandicateDao candicateDao, UserService userService, MernisServiceAdapter mernisServiceAdapter) {
        this.candicateDao = candicateDao;
        this.userService = userService;
        this.mernisServiceAdapter = mernisServiceAdapter;
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
    public Result add(Candicate candicate) throws Exception {
        Result result = BusinessRules.run(
                checkIfUserIsAlreadyExists(candicate),
                checkIfUserIsNotRealPerson(candicate)
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

    private Result checkIfUserIsNotRealPerson(Candicate candicate) throws Exception {
        var result = this.mernisServiceAdapter.verifyUser(candicate.getIdentityNumber(), candicate.getFirstName(), candicate.getLastName(), candicate.getDateOfBirth().getYear());

        if (!result) {
            return new ErrorResult("Kullanıcı gerçek bir kullanıcı değil");
        }

        return new SuccessResult();
    }
}

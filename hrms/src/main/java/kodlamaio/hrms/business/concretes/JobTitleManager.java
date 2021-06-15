package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.JobTitleService;
import kodlamaio.hrms.core.business.BusinessRules;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.JobTitleDao;
import kodlamaio.hrms.entities.concretes.JobTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobTitleManager implements JobTitleService {
    private JobTitleDao jobTitleDao;

    @Autowired
    public JobTitleManager(JobTitleDao jobTitleDao) {
        this.jobTitleDao = jobTitleDao;
    }

    @Override
    public DataResult<List<JobTitle>> getAll() {
        return new SuccessDataResult<List<JobTitle>>(jobTitleDao.findAll());
    }

    @Override
    public DataResult<JobTitle> getByName(String name) {
        return new SuccessDataResult<JobTitle>(jobTitleDao.getByName(name));
    }

    @Override
    public Result add(JobTitle jobTitle) {
        Result result = BusinessRules.run(
                checkIfJobTitleNameAlreadyExists(jobTitle.getName())
        );

        if(result != null){
            return result;
        }

        jobTitleDao.save(jobTitle);
        return new SuccessResult();
    }

    private Result checkIfJobTitleNameAlreadyExists(String name){
        var result = getByName(name).getData();

        if(result != null){
            return new ErrorResult("Job name already exsits");
        }

        return new SuccessResult();
    }
}

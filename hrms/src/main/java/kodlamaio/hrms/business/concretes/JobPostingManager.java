package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.JobPostingService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobPostingDao;
import kodlamaio.hrms.entities.concretes.JobPosting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class JobPostingManager implements JobPostingService {
    private JobPostingDao jobPostingDao;

    @Autowired
    public JobPostingManager(JobPostingDao jobPostingDao) {
        this.jobPostingDao = jobPostingDao;
    }

    @Override
    public Result add(JobPosting jobPosting) {
        jobPosting.setCreatedDate(LocalDate.now());
        jobPostingDao.save(jobPosting);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<JobPosting>> getAll() {
        return new SuccessDataResult<List<JobPosting>>(jobPostingDao.findAll());
    }

    @Override
    public DataResult<List<JobPosting>> getByEmployerId(int employerId, boolean isActive) {
        return new SuccessDataResult<List<JobPosting>>(jobPostingDao.getByEmployer_IdAndIsActive(employerId, isActive));
    }

    @Override
    public DataResult<List<JobPosting>> getByActive(boolean isActive) {
        return new SuccessDataResult<List<JobPosting>>(jobPostingDao.getByIsActive(isActive));
    }

    @Override
    public DataResult<List<JobPosting>> getByIsActiveTrueOrderByCreatedDate() {
        return new SuccessDataResult<List<JobPosting>>(jobPostingDao.getByIsActiveTrueOrderByCreatedDateDesc());
    }
}

package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPosting;

import java.util.List;

public interface JobPostingService {
    Result add(JobPosting jobPosting);

    DataResult<List<JobPosting>> getAll();

    DataResult<List<JobPosting>> getByEmployerId(int employerId, boolean isActive);

    DataResult<List<JobPosting>> getByActive(boolean isActive);

    DataResult<List<JobPosting>> getByIsActiveTrueOrderByCreatedDate();

}

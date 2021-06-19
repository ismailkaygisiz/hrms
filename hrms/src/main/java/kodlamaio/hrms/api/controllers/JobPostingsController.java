package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.JobPostingService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPosting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobpostings/")
public class JobPostingsController {
    private JobPostingService jobPostingService;

    @Autowired
    public JobPostingsController(JobPostingService jobPostingService) {
        this.jobPostingService = jobPostingService;
    }

    @GetMapping("getall")
    public DataResult<List<JobPosting>> getAll(){
        return jobPostingService.getAll();
    }

    @GetMapping("getbyemployerid")
    public DataResult<List<JobPosting>> getByEmployerId(@RequestParam int employerId){
        return jobPostingService.getByEmployerId(employerId);
    }

    @GetMapping("getbyactive")
    public DataResult<List<JobPosting>> getByActive(@RequestParam boolean isActive){
        return jobPostingService.getByActive(isActive);
    }

    @PostMapping("add")
    public Result add(@RequestBody JobPosting jobPosting){
        return jobPostingService.add(jobPosting);
    }
}

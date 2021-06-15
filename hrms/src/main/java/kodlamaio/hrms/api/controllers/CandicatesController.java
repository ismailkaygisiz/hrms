package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.CandicateService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Candicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/candicates/")
public class CandicatesController {
    private CandicateService candicateService;

    @Autowired
    public CandicatesController(CandicateService candicateService) {
        this.candicateService = candicateService;
    }

    @GetMapping("getall")
    public DataResult<List<Candicate>> getAll(){
        return candicateService.getAll();
    }

    @PostMapping("add")
    public Result add(@RequestBody Candicate candicate){
        return candicateService.add(candicate);
    }
}

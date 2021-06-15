package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.VerificationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.Verification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/verifications/")
public class VerificationsController {
    private VerificationService verificationService;

    @Autowired
    public VerificationsController(VerificationService verificationService) {
        this.verificationService = verificationService;
    }

    @GetMapping("getall")
    public DataResult<List<Verification>> getAll(){
        return verificationService.getAll();
    }
}

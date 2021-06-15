package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.Employee;

import java.util.List;

public interface EmployeeService {
    DataResult<List<Employee>> getAll();
}

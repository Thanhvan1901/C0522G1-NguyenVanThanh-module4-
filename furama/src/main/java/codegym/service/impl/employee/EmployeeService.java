package codegym.service.impl.employee;

import  codegym.model.employee.Employee;
import  codegym.repository.employee.IEmployeeRepository;
import  codegym.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private IEmployeeRepository iEmployeeRepository;

    @Override
    public Page<Employee> findAllByNameContaining(String nameEmployee, Pageable pageable) {
        return this.iEmployeeRepository.findAllByNameContaining(nameEmployee, pageable);
    }

    @Override
    public void save(Employee employee) {
        this.iEmployeeRepository.save(employee);
    }
}

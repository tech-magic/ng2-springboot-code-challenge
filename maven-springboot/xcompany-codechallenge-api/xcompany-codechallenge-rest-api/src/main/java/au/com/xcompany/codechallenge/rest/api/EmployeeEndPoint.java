package au.com.xcompany.codechallenge.rest.api;

import au.com.xcompany.codechallenge.service.CodeChallengeServiceException;
import au.com.xcompany.codechallenge.service.employee.EmployeeService;
import au.com.xcompany.codechallenge.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by WPerera on 9/23/2017.
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/codechallenge/employees")
public class EmployeeEndPoint {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/list/hierarchy", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity listHierarchy() {
        ResponseEntity responseEntity = null;
        try {
            List<Employee> employeeHierarchy = employeeService.getEmployeeHierarchy();
            responseEntity = new ResponseEntity(employeeHierarchy, HttpStatus.OK);
        } catch (CodeChallengeServiceException ex)  {
            responseEntity = new ResponseEntity(ex, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
}

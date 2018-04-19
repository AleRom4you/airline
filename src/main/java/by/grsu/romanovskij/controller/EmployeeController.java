package by.grsu.romanovskij.controller;

import by.grsu.romanovskij.DataTransferObject.EmployeeDto;
import by.grsu.romanovskij.model.Brigade;
import by.grsu.romanovskij.model.Employee;
import by.grsu.romanovskij.repository.BrigadeRepository;
import by.grsu.romanovskij.repository.EmployeeRepository;
import by.grsu.romanovskij.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    BrigadeRepository brigadeRepository;

    @RequestMapping(value = "/brigade-list/{brigadeId}/employees", method = RequestMethod.GET)
    public String employeesList(Model model, @PathVariable("brigadeId") Integer brigadeId) {
        Brigade brigade = brigadeRepository.findBrigadeByBrigadeId(brigadeId);
        model.addAttribute("title", "Employee list :: " + brigade.getBrigadeNumber() + " :: AirLine");
        model.addAttribute("count", employeeRepository.countAllByBrigade(brigade));
        model.addAttribute("brigade", brigade);
        model.addAttribute("employees",
                employeeRepository.findEmployeesByBrigade(brigade));
        return "brigade-list-employees-list";
    }

    @RequestMapping(value = "/brigade-list/{brigadeId}/employee/{employeeId}/kick", method = RequestMethod.GET)
    public String kickFromBrigade(Model model, @PathVariable("brigadeId") Integer brigadeId, @PathVariable("employeeId") Integer employeeId) {
        employeeService.kickFromBrigade(employeeId);
        return "redirect:/brigade-list/" + brigadeId + "/employees";
    }

    @RequestMapping(value = "/brigade-list/{brigadeId}/employee/add", method = RequestMethod.GET)
    public String addEmployeeToBrigade(Model model, @PathVariable("brigadeId") Integer brigadeId) {
        Brigade brigade = brigadeRepository.findBrigadeByBrigadeId(brigadeId);
        model.addAttribute("title", "Add :: Employee :: " + brigade.getBrigadeNumber() + " :: AirLine");
        model.addAttribute("brigade", brigade);
        model.addAttribute("employees",
                employeeRepository.findEmployeesByBrigade(
                        brigadeRepository.findBrigadeByBrigadeNumber("Without Brigade")
                ));
        return "brigade-list-employee-add";
    }

    @RequestMapping(value = "/brigade-list/{brigadeId}/employee/add", method = RequestMethod.POST)
    public String addEmployeeToBrigade(Model model, @PathVariable("brigadeId") Integer brigadeId,
                                       @ModelAttribute("employee") Employee employee, BindingResult result) {
        Brigade brigade = brigadeRepository.findBrigadeByBrigadeId(brigadeId);
        model.addAttribute("title", "Add :: Employee :: " + brigade.getBrigadeNumber() + " :: AirLine");

        if (result.hasErrors()) {
            model.addAttribute("error", "Oops, error!");
            return "brigade-list-employee-add";
        }

        employeeService.addToBrigade(employee.getEmployeeId(), brigadeId);
        model.addAttribute("success", "Employee successfully added!");
        return "redirect:/brigade-list/" + brigadeId + "/employees";
    }
}

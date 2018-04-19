package by.grsu.romanovskij.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/AJAX/subjects")
public class AjaxSubjectsController {
//	@Autowired
//	private FacultyRepository facultyRepository;
//
//	@GetMapping
//	@ResponseBody
//	public String subjects(@RequestParam(value = "id", required = false) Integer id) {
//		StringBuilder response = new StringBuilder();
//
//		for (Faculty faculty : facultyRepository.findAll()) {
//			if (faculty.getId().equals(id)) {
//				response.append(faculty.getSubject1());
//				response.append("\n");
//				response.append(faculty.getSubject2());
//				response.append("\n");
//				response.append(faculty.getSubject3());
//			}
//		}
//
//		return response.toString();
//	}
}

/**
 * 10 Apr 2020
 */
package za.co.iqbusiness.online.application.controller;

import java.io.FileNotFoundException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import za.co.iqbusiness.online.application.data.Person;
import za.co.iqbusiness.online.application.service.PersonService;
import za.co.iqbusiness.online.application.utils.Validation;

/**
 * @author luckyboyrapudi
 *
 */
@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonService personService;

	private String message;
	private boolean idValid = false;
	private boolean fullNameValid = false;

	@RequestMapping(value = "/doregister", method = RequestMethod.POST, produces = MediaType.TEXT_PLAIN_VALUE)
	public String doRegister(Person person) {
		System.out.println(person.getFullName() +" "+ person.getIdNumber());
		if (Validation.fullNameValidation(person.getFullName())) {
			fullNameValid = true;
		} else {
			fullNameValid = false;
			message = "Please enter valid full name eg Lucky Jons";
		}

		if (Validation.idValidationSA(person.getIdNumber())) {
			idValid = true;
		} else {
			idValid = false;
			message = "Please enter valid id number e.g 8905055117083";
		}
		if (fullNameValid && idValid) {
			personService.doRegister(person);
			message = "Developer successfully registered";
			System.out.println(message);
		} else {
			System.out.println(message);
		}
		return message;
	}

	@RequestMapping(value = "/getallpeople", method = RequestMethod.GET, produces = { "application/json" })
	public List<Person> getAllRegisteredPeople() {
		List<Person> people = personService.getAllRegisteredPeople();
		System.out.println("successful");
		return people;
	}
	
	@GetMapping("/devreport")
	public ResponseEntity<byte[]> generateReport() throws FileNotFoundException {
		String name= "person-rpt";
		byte[] bytes = personService.generateReport();
	    return ResponseEntity
	      .ok()
	      .header("Content-Type", "application/pdf; charset=UTF-8")
	      .header("Content-Disposition", "inline; filename=\"" + name + ".pdf\"")
	      .body(bytes);
		
	}

}

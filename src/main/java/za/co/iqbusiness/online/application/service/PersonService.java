/**
 * 10 Apr 2020
 */
package za.co.iqbusiness.online.application.service;

import java.io.FileNotFoundException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import za.co.iqbusiness.online.application.data.Person;

/**
 * @author luckyboyrapudi
 *
 */
public interface PersonService {
	
	public void doRegister(Person person);
	public List<Person> getAllRegisteredPeople();
	public byte[] generateReport() throws FileNotFoundException;

}

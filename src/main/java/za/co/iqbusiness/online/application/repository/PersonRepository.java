/**
 * 10 Apr 2020
 */
package za.co.iqbusiness.online.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import za.co.iqbusiness.online.application.data.Person;

/**
 * @author luckyboyrapudi
 *
 */
public interface PersonRepository extends JpaRepository<Person, Long> {

}

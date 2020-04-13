/**
 * 10 Apr 2020
 */
package za.co.iqbusiness.online.application.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author luckyboyrapudi
 *
 */
@Entity
@Table(name="PERSON")
public class Person {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	@Column(name="NAME")
	private String fullName;
	@Column(name="ID_NUMBER")
	private String idNumber;

	public Person() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the id
	 *	10 Apr 2020
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the fullName
	 *	10 Apr 2020
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * @param fullName the fullName to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * @return the idNumber
	 *	10 Apr 2020
	 */
	public String getIdNumber() {
		return idNumber;
	}

	/**
	 * @param idNumber the idNumber to set
	 */
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	

}

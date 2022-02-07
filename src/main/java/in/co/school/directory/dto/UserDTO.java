package in.co.school.directory.dto;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "USER")
@Getter
@Setter
public class UserDTO extends BaseDTO {

	@Column(name = "NAME", length = 225)
	private String name;

	@Column(name = "LOGIN_ID",length = 225)
	private String loginId;

	@Column(name = "PASSWORD", length = 225)
	private String password;

	private String confirmPassword;

	@Column(name = "ROLE_ID", length = 225)
	private long roleId;

	@Column(name = "EMAIL_ID", length = 225)
	private String emailId;
	
	@Column(name = "CONTACT_NO", length = 225)
	private String contactNo;
	
	@Column(name = "GENDER", length = 225)
	private String gender;
	
	
	@Transient
	private String distance;
	@Transient
	private String affiliation;
	@Transient
	private String fee;
	
	
	
	
	
	
	public String getKey() {
		return id + "";
	}

	public String getValue() {
		return name;
	}

}

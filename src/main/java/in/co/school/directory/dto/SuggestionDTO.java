package in.co.school.directory.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="SUGGESTION")
@Setter
@Getter
public class SuggestionDTO extends BaseDTO {

	@Column(name="NAME",length = 755)
	private String name;
	@Column(name="EMAIL",length = 755)
	private String email;
	@Column(name="SCHOOL_NAME",length = 755)
	private String schoolName;
	@Column(name="SCHOOL_ADDRESS",length = 755)
	private String schoolAddress;
	@Column(name="CONTACT_NO",length = 755)
	private String contactNo;
	@Column(name="SCHOOL_EMAIL_ID",length = 755)
	private String schoolEmailId;
	@Column(name="AFFLIATION",length = 755)
	private String affliation;
	@Column(name="ABOUT_SCHOOL",length = 1500)
	private String about;
	
	@Override
	public String getKey() {
		return String.valueOf("id");
	}
	@Override
	public String getValue() {
		return name;
	}

}

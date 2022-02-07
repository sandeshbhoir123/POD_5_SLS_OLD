package in.co.school.directory.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="SCHOOL")
@Setter
@Getter
public class SchoolDTO extends BaseDTO {
	
	@Column(name="NAME",length = 755)
	private String name;
	@Column(name="ABOUT",length = 1500)
	private String about;
	@Column(name="LOCATION",length = 755)
	private String location;
	@Column(name="CONTACT_NO",length = 755)
	private String contactNo;
	@Column(name="EMAIL_ID",length = 755)
	private String emailId;
	@Column(name="AFFILIATION",length = 755)
	private String affiliation;
	@Column(name="RATING",length = 755)
	private String rating;
	@Column(name="WEBSITE",length = 755)
	private String website;
	@Column(name="DISTANCE",length = 755)
	private String distance;
	@Column(name="FREE",length = 755)
	private String free;
	
	@Column(name = "IMAGE",columnDefinition ="LONGBLOB")
	private byte[] image;
	
	@Column(name = "LOGO",columnDefinition ="LONGBLOB")
	private byte[] logo;

	@Override
	public String getKey() {
		return String.valueOf(id);
	}

	@Override
	public String getValue() {
		return null;
	}

}

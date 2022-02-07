package in.co.school.directory.form;

import javax.validation.constraints.NotEmpty;

import in.co.school.directory.dto.BaseDTO;
import in.co.school.directory.dto.SuggestionDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SuggestionForm extends BaseForm {

	@NotEmpty(message = "Name is required")
	private String name;
	@NotEmpty(message = "Email is required")
	private String email;
	@NotEmpty(message = "School Name is required")
	private String schoolName;
	@NotEmpty(message = "School Address is required")
	private String schoolAddress;
	@NotEmpty(message = "Contact No is required")
	private String contactNo;
	@NotEmpty(message = "School Email Id is required")
	private String schoolEmailId;
	@NotEmpty(message = "Affliation is required")
	private String affliation;
	@NotEmpty(message = "About is required")
	private String about;
	
	
	@Override
	public BaseDTO getDTO() {
		SuggestionDTO bean=new SuggestionDTO();
		bean.setId(id);
		bean.setName(name);
		bean.setEmail(email);
		bean.setSchoolName(schoolName);
		bean.setSchoolAddress(schoolAddress);
		bean.setContactNo(contactNo);
		bean.setSchoolEmailId(schoolEmailId);
		bean.setAffliation(affliation);
		bean.setAbout(about);
		bean.setCreatedBy(createdBy);
		bean.setModifiedBy(modifiedBy);
		bean.setCreatedDatetime(createdDateTime);
		bean.setModifiedDatetime(modifiedDateTime);
		return bean;
	}

	@Override
	public void populate(BaseDTO bDto) {
		SuggestionDTO bean=(SuggestionDTO)bDto;
		id=bean.getId();
		name=bean.getName();
		email=bean.getEmail();
		schoolName=bean.getSchoolName();
		schoolAddress=bean.getSchoolAddress();
		contactNo=bean.getContactNo();
		schoolEmailId=bean.getSchoolEmailId();
		affliation=bean.getAffliation();
		about=bean.getAbout();
		createdBy=bean.getCreatedBy();
		modifiedBy=bean.getModifiedBy();
		createdDateTime=bean.getCreatedDatetime();
		modifiedDateTime=bean.getModifiedDatetime();
	}	
}

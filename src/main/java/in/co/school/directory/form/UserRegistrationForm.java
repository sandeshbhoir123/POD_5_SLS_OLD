package in.co.school.directory.form;


import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;

import in.co.school.directory.dto.BaseDTO;
import in.co.school.directory.dto.UserDTO;
import in.co.school.directory.util.DataUtility;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegistrationForm extends BaseForm {

	@NotEmpty(message = "Name is required")
	private String name;
	private String loginId;
	private String password;
	private String confirmPassword;
	@NotEmpty(message = "Email is required")
	private String email;
	@NotEmpty(message = "Contact No is required")
	private String contactNo;
	@NotEmpty(message = "Gender is required")
	private String gender;
	
	private String distance;
	private String affiliation;
	private String fee;
	

	@Override
	public BaseDTO getDTO() {
		UserDTO bean=new UserDTO();
		bean.setId(id);
		bean.setName(name);
		bean.setLoginId(loginId);
		bean.setEmailId(email);
		bean.setDistance(distance);
		bean.setAffiliation(affiliation);
		bean.setFee(fee);
		bean.setPassword(password);
		bean.setContactNo(contactNo);
		bean.setGender(gender);
		bean.setCreatedBy(createdBy);
		bean.setModifiedBy(modifiedBy);
		bean.setCreatedDatetime(createdDateTime);
		bean.setModifiedDatetime(modifiedDateTime);
		return bean;
	}
	@Override
	public void populate(BaseDTO baseBean) {
		UserDTO bean=(UserDTO)baseBean;
		id=bean.getId();
		distance=bean.getDistance();
		affiliation=bean.getAffiliation();
		fee=bean.getAffiliation();
		name=bean.getName();
		email=bean.getEmailId();
		password=bean.getPassword();
		contactNo=bean.getContactNo();
		gender=bean.getGender();
		loginId=bean.getLoginId();
		createdBy=bean.getCreatedBy();
		modifiedBy=bean.getModifiedBy();
		createdDateTime=bean.getCreatedDatetime();
		modifiedDateTime=bean.getModifiedDatetime();
	}
}

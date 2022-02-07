package in.co.school.directory.form;

import javax.validation.constraints.NotEmpty;

import org.springframework.web.multipart.MultipartFile;

import in.co.school.directory.dto.BaseDTO;
import in.co.school.directory.dto.SchoolDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SchoolForm extends BaseForm {

	@NotEmpty(message = "Name is required")
	private String name;
	@NotEmpty(message = "About is required")
	private String about;
	@NotEmpty(message = "Location is required")
	private String location;
	@NotEmpty(message = "Contact No is required")
	private String contactNo;
	@NotEmpty(message = "Email Id is required")
	private String emailId;
	@NotEmpty(message = "Affiliation is required")
	private String affiliation;
	@NotEmpty(message = "Rating is required")
	private String rating;
	@NotEmpty(message = "Website is required")
	private String website;
	@NotEmpty(message = "Distance is required")
	private String distance;
	@NotEmpty(message = "Fee is required")
	private String free;
	private MultipartFile image;
	private MultipartFile logo;
	
	@Override
	public BaseDTO getDTO() {
		SchoolDTO bean=new SchoolDTO();
		bean.setId(id);
		bean.setName(name);
		bean.setAbout(about);
		bean.setLocation(location);
		bean.setContactNo(contactNo);
		bean.setEmailId(emailId);
		bean.setAffiliation(affiliation);
		bean.setRating(rating);
		bean.setWebsite(website);
		bean.setDistance(distance);
		bean.setFree(free);
		bean.setCreatedBy(createdBy);
		bean.setModifiedBy(modifiedBy);
		bean.setModifiedDatetime(modifiedDateTime);
		bean.setCreatedDatetime(createdDateTime);
		return bean;
	}

	@Override
	public void populate(BaseDTO bDto) {
		SchoolDTO bean=(SchoolDTO)bDto;
		id=bean.getId();
		name=bean.getName();
		about=bean.getAbout();
		location=bean.getLocation();
		contactNo=bean.getContactNo();
		emailId=bean.getEmailId();
		affiliation=bean.getAffiliation();
		rating=bean.getRating();
		website=bean.getWebsite();
		distance=bean.getDistance();
		free=bean.getFree();
		createdBy=bean.getCreatedBy();
		modifiedBy=bean.getModifiedBy();
		createdDateTime=bean.getCreatedDatetime();
		modifiedDateTime=bean.getModifiedDatetime();
	}

}

package in.co.school.directory.form;


import javax.validation.constraints.NotEmpty;

import in.co.school.directory.dto.BaseDTO;
import in.co.school.directory.dto.UserDTO;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ForgetPasswordForm extends BaseForm {

	@NotEmpty(message = "Login is required")
	private String login;

	@Override
	public BaseDTO getDTO() {
		UserDTO dto = new UserDTO();
		dto.setLoginId(login);
		return dto;
	}

	@Override
	public void populate(BaseDTO bDto) {
		
	}

}

package in.co.school.directory.form;

import javax.validation.constraints.NotEmpty;

import in.co.school.directory.dto.BaseDTO;
import in.co.school.directory.dto.UserDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginForm extends BaseForm {

	@NotEmpty(message = "Login Id is required")
	private String login;
	@NotEmpty(message = "Password is required")
	private String password;
	

	@Override
	public BaseDTO getDTO() {
		UserDTO bean=new UserDTO();
		bean.setLoginId(login);
		bean.setPassword(password);
		return bean;
	}

	@Override
	public void populate(BaseDTO bdto) {
		UserDTO entity=(UserDTO) bdto;
		login=entity.getLoginId();
		password=entity.getPassword();
	}

}

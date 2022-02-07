package in.co.school.directory.ctl;

import java.util.HashMap;
import java.util.logging.Logger;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import in.co.school.directory.dto.UserDTO;
import in.co.school.directory.exception.DuplicateRecordException;
import in.co.school.directory.form.ForgetPasswordForm;
import in.co.school.directory.form.LoginForm;
import in.co.school.directory.form.UserRegistrationForm;
import in.co.school.directory.service.UserServiceInt;
import in.co.school.directory.util.DataUtility;

@Controller
@RequestMapping
public class LoginCtl extends BaseCtl {

	private Logger log = Logger.getLogger(LoginCtl.class.getName());

	protected static final String OP_SIGNIN = "SignIn";
	protected static final String OP_SIGNUP = "SignUp";
	protected static final String OP_LOGOUT = "Logout";

	@Autowired
	private UserServiceInt service;

	@GetMapping("/login")
	public String display(@ModelAttribute("form") LoginForm form, @RequestParam(required = false) Long iId,
			HttpSession session, Model model) {
		log.info("LoginCtl login display method start");
		if (session.getAttribute("user") != null) {
			session.invalidate();
			model.addAttribute("success", "You have logout Successfully!!!");
		}
		if (DataUtility.getLong(String.valueOf(iId)) > 0) {
			session.setAttribute("iId", iId);
		}
		log.info("LoginCtl login display method End");
		return "login";
	}

	@ModelAttribute
	public void preload(Model model) {

		HashMap<String, String> map2 = new HashMap<String, String>();
		map2.put("Male", "Male");
		map2.put("Female", "Female");
		model.addAttribute("gender", map2);

	}

	@PostMapping("/login")
	public String submit(@RequestParam String operation, HttpSession session,
			@Valid @ModelAttribute("form") LoginForm form, BindingResult result, Model model) {
		log.info("LoginCtl login submit method start");
		System.out.println("In dopost  LoginCtl");

		if (OP_SIGNUP.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/user/us-signUp";
		}

		if (result.hasErrors()) {
			System.out.println(result);
			return "login";
		}

		UserDTO bean = service.authenticate((UserDTO) form.getDTO());

		if (bean != null) {
			System.out.println(bean.toString());
			session.setAttribute("user", bean);
			return "redirect:/dashbord";
		}
		model.addAttribute("error", "Login Id Password Invalid");
		log.info("LoginCtl login submit method End");
		return "login";
	}

	@GetMapping("/signUp")
	public String display(@ModelAttribute("form") UserRegistrationForm form, Model model) {
		log.info("LoginCtl signUp display method start");
		log.info("LoginCtl signUp display method End");
		return "signUp";
	}

	@PostMapping("/signUp")
	public String submit(@RequestParam String operation, @Valid @ModelAttribute("form") UserRegistrationForm form,
			BindingResult bindingResult, Model model) {

		log.info("LoginCtl signUp submit method start");

		if (OP_CANCEL.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/welcome";
		}

		if (bindingResult.hasErrors()) {
			System.out.println(bindingResult);
			return "signUp";
		}

		try {
			if (OP_SEARCH.equalsIgnoreCase(form.getOperation())) {
				UserDTO entity = (UserDTO) form.getDTO();
				System.out.println(entity.toString());
				entity.setRoleId(2L);
				service.registerUser(entity);
				return "redirect:/school/search?fee=" + entity.getFee() + "&distance=" + entity.getDistance()
						+ "&affiliation=" + entity.getAffiliation();
			}
		} catch (DuplicateRecordException e) {
			model.addAttribute("error", e.getMessage());
			return "signUp";
		}

		log.info("LoginCtl signUp submit method end");
		return "signUp";
	}

	

	@RequestMapping(value = "/forgetPassword", method = RequestMethod.GET)
	public String display(@ModelAttribute("form") ForgetPasswordForm form, HttpSession session, Model model) {
		System.out.println("In doget LoginCtl forgetpassword");
		return "forgetPassword";

	}

	@RequestMapping(value = "/forgetPassword", method = RequestMethod.POST)
	public String display(@ModelAttribute("form") @Valid ForgetPasswordForm form, BindingResult bindingResult,
			Model model) {
		if (bindingResult.hasErrors()) {
			return "forgetPassword";
		}
		UserDTO dto = service.findByLogin(form.getLogin());
		if (dto == null) {
			model.addAttribute("error", "Login Id does not exist");
		}
		if (dto != null) {
			service.forgetPassword(form.getLogin());
			model.addAttribute("success", "Password has been sent to your registered Email ID!!");
		}
		return "forgetPassword";
	}

}

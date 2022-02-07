package in.co.school.directory.ctl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import in.co.school.directory.dto.SchoolDTO;
import in.co.school.directory.exception.DuplicateRecordException;
import in.co.school.directory.form.SchoolForm;
import in.co.school.directory.service.SchoolServiceInt;


@Controller
@RequestMapping("/school")
public class SchoolCtl extends BaseCtl {

	@Autowired
	private SchoolServiceInt service;
	
	@GetMapping
	public String display(@RequestParam(required = false) Long id,@ModelAttribute("form") SchoolForm form, Model model) {
		if (form.getId() > 0) {
			SchoolDTO bean=service.findByPk(id);
			form.populate(bean);
		}
		return "school";
	}
	
	@GetMapping("/detail")
	public String displayDetail(@RequestParam(required = false) Long id,@ModelAttribute("form") SchoolForm form, Model model) {
		if (form.getId() > 0) {
			SchoolDTO bean=service.findByPk(id);
			form.populate(bean);
		}
		return "schoolDetail";
	}
	
	
	
	@PostMapping
	public String submit(@RequestParam("image") MultipartFile file,@RequestParam("logo") MultipartFile file1,@Valid @ModelAttribute("form")  SchoolForm form, BindingResult bindingResult,
			Model model) {
		if (OP_RESET.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/school";
		}
		try {
			if (OP_SAVE.equalsIgnoreCase(form.getOperation())) {
			
				if (bindingResult.hasErrors()) {
					return "school";
				}
				SchoolDTO bean = (SchoolDTO) form.getDTO();
				bean.setImage(file.getBytes());
				bean.setLogo(file1.getBytes());
				if(bean.getId()>0) {
					service.update(bean);
					model.addAttribute("success", "School update Successfully!!!!");
				}else {
				service.add(bean);
				model.addAttribute("success", "School Added Successfully!!!!");
				}
				return "school";
			}
		} catch (DuplicateRecordException e) {
			model.addAttribute("error", e.getMessage());
			return "school";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	
	@RequestMapping(value = "/search", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchList(@ModelAttribute("form") SchoolForm form,
			@RequestParam(required = false) String operation,Long idd,HttpSession session, Model model) {

		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/school/search";
		}

		int pageNo = form.getPageNo();
		int pageSize = form.getPageSize();

		if (OP_NEXT.equals(operation)) {
			pageNo++;
		} else if (OP_PREVIOUS.equals(operation)) {
			pageNo--;
		}else if (OP_NEW.equals(operation)) {
			return "redirect:/school";
		}

		pageNo = (pageNo < 1) ? 1 : pageNo;
		pageSize = (pageSize < 1) ? 10 : pageSize;

		if (OP_DELETE.equals(operation)) {
			SchoolDTO pdEnt=new SchoolDTO();
			pdEnt.setId(idd);
			System.out.println(pdEnt.getId());
			service.delete(pdEnt);
			model.addAttribute("success", "Data Deleted Successfully!!!");
		}
		
		SchoolDTO bean=(SchoolDTO)form.getDTO();
		List<SchoolDTO> list =service.search(bean);
		List<SchoolDTO> totallist =service.search(bean);
		model.addAttribute("list", list);
		if (list.size() == 0 && !OP_DELETE.equalsIgnoreCase(operation)) {
			model.addAttribute("error","Record not found");
		}

		int listsize = list.size();
		int total = totallist.size();
		int pageNoPageSize = pageNo * pageSize;

		form.setPageNo(pageNo);
		form.setPageSize(pageSize);
		model.addAttribute("pageNo", pageNo);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("listsize", listsize);
		model.addAttribute("total", total);
		model.addAttribute("pagenosize", pageNoPageSize);
		model.addAttribute("form", form);
		return "schoolList";
	}
	
	@GetMapping("/getImage/{id}")
	public void getStudentPhoto(HttpServletResponse response, @PathVariable("id") long id) throws Exception {
		response.setContentType("image/jpeg");

		Blob blb=service.getImageById(id);
		
		byte[] bytes = blb.getBytes(1, (int) blb.length());
		InputStream inputStream = new ByteArrayInputStream(bytes);
		IOUtils.copy(inputStream, response.getOutputStream());
	}
	
	@GetMapping("/getLogo/{id}")
	public void getLogo(HttpServletResponse response, @PathVariable("id") long id) throws Exception {
		response.setContentType("image/jpeg");

		Blob blb=service.getLogoById(id);
		
		byte[] bytes = blb.getBytes(1, (int) blb.length());
		InputStream inputStream = new ByteArrayInputStream(bytes);
		IOUtils.copy(inputStream, response.getOutputStream());
	}
	
	@GetMapping("/findById/{id}")
	public String getfindById(HttpServletResponse response, @PathVariable("id") long id) throws Exception {
		return service.findByPk(id).getName();
	}
	
}

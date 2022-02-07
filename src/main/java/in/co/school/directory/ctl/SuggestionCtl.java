package in.co.school.directory.ctl;

import java.io.IOException;
import java.util.List;

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

import in.co.school.directory.dto.SuggestionDTO;
import in.co.school.directory.exception.DuplicateRecordException;
import in.co.school.directory.form.SuggestionForm;
import in.co.school.directory.service.SuggestionServiceInt;

@Controller
@RequestMapping("/suggestion")
public class SuggestionCtl extends BaseCtl {

	@Autowired
	private SuggestionServiceInt service;
	
	@GetMapping
	public String display(@RequestParam(required = false) Long id,@ModelAttribute("form") SuggestionForm form, Model model) {
		if (form.getId() > 0) {
			SuggestionDTO bean=service.findByPk(id);
			form.populate(bean);
		}
		return "suggestion";
	}
	
	@GetMapping("/detail")
	public String displayDetail(@RequestParam(required = false) Long id,@ModelAttribute("form") SuggestionForm form, Model model) {
		if (form.getId() > 0) {
			SuggestionDTO bean=service.findByPk(id);
			form.populate(bean);
		}
		return "suggestionDetail";
	}
	
	
	
	@PostMapping
	public String submit(@Valid @ModelAttribute("form")  SuggestionForm form, BindingResult bindingResult,
			Model model) {
		if (OP_RESET.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/suggestion";
		}
		try {
			if (OP_SAVE.equalsIgnoreCase(form.getOperation())) {
			
				if (bindingResult.hasErrors()) {
					return "suggestion";
				}
				SuggestionDTO bean = (SuggestionDTO) form.getDTO();
				if(bean.getId()>0) {
					service.update(bean);
					model.addAttribute("success", "Suggestion update Successfully!!!!");
				}else {
				service.add(bean);
				model.addAttribute("success", "Suggestion Added Successfully!!!!");
				}
				return "suggestion";
			}
		} catch (DuplicateRecordException e) {
			model.addAttribute("error", e.getMessage());
			return "suggestion";
		} 
		return "";
	}
	
	@RequestMapping(value = "/search", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchList(@ModelAttribute("form") SuggestionForm form,
			@RequestParam(required = false) String operation,Long idd,HttpSession session, Model model) {

		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/suggestion/search";
		}

		int pageNo = form.getPageNo();
		int pageSize = form.getPageSize();

		if (OP_NEXT.equals(operation)) {
			pageNo++;
		} else if (OP_PREVIOUS.equals(operation)) {
			pageNo--;
		}else if (OP_NEW.equals(operation)) {
			return "redirect:/suggestion";
		}

		pageNo = (pageNo < 1) ? 1 : pageNo;
		pageSize = (pageSize < 1) ? 10 : pageSize;

		if (OP_DELETE.equals(operation)) {
			SuggestionDTO pdEnt=new SuggestionDTO();
			pdEnt.setId(idd);
			System.out.println(pdEnt.getId());
			service.delete(pdEnt);
			model.addAttribute("success", "Data Deleted Successfully!!!");
		}
		
		SuggestionDTO bean=(SuggestionDTO)form.getDTO();
		List<SuggestionDTO> list =service.search(bean);
		List<SuggestionDTO> totallist =service.search(bean);
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
		return "suggestionList";
	}
	
}

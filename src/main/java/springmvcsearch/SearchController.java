package springmvcsearch;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class SearchController {
	@RequestMapping("/home/{id}")
	public String home(@PathVariable("id")int id) {
		
//		byte b = Byte.parseByte("id");
//		System.out.println(b);
		return "home";
	}
	@RequestMapping("/complexeform")
	public String cform() {
//		String s = null;
//		int a = s.length();
//		System.out.println(a);
		return "complexeform";
	}
	@RequestMapping("/search")
	public RedirectView search(@RequestParam("queryBox") String query) {
	    if(query == null || query.isEmpty()) {
	        throw new IllegalArgumentException("Query must not be empty");
	    }

	    RedirectView redirectView = new RedirectView();
	    String url = "https://www.google.com/search?q=" + query;
	    redirectView.setUrl(url);

	    return redirectView;
	}
//	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
//	@ExceptionHandler(value=NullPointerException.class)
//	public String nullHandler(Model m) {
//		m.addAttribute("msg","Null Pointer Exception!");
//		return "null";
//	}
//	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
//	@ExceptionHandler(value=NumberFormatException.class)
//	public String numberHandler(Model m) {
//		m.addAttribute("msg","Number Format Exception!");
//		return "null";
//	}
//	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
//	@ExceptionHandler(value=Exception.class)
//	public String genericHandler(Model m) {
//		m.addAttribute("msg","Exception occured!");
//		return "null";
//	}

}

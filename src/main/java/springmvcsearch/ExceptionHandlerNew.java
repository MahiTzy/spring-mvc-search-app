package springmvcsearch;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
@ControllerAdvice
public class ExceptionHandlerNew {
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value=NullPointerException.class)
	public String nullHandler(Model m) {
		m.addAttribute("msg","Null Pointer Exception!");
		return "null";
	}
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value=NumberFormatException.class)
	public String numberHandler(Model m) {
		m.addAttribute("msg","Number Format Exception!");
		return "null";
	}
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value=Exception.class)
	public String genericHandler(Model m) {
		m.addAttribute("msg","Exception occured!");
		return "null";
	}

}

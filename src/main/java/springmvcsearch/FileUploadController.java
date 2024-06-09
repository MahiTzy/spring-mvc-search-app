package springmvcsearch;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
public class FileUploadController {
	@RequestMapping("/fileform")
	public String showUploadForm() {
//		String s = null;
//		int a = s.length();
//		System.out.println(a);
		return "fileform";
	}
	@RequestMapping(value="/uploadimage",method=RequestMethod.POST)
	public String fileUpload(@RequestParam("profile")CommonsMultipartFile file,HttpSession httpSession,Model m) throws IOException {
//		System.out.println(file.getSize());
//		System.out.println(file.getContentType());
//		System.out.println(file.getName());
//		System.out.println(file.getOriginalFilename());
//		System.out.println(file.getStorageDescription());
		byte[] data = file.getBytes();
		String path = httpSession.getServletContext().getRealPath("/")+"WEB-INF"+File.separator+"resources"+File.separator+"images"+File.separator+file.getOriginalFilename();
		FileOutputStream fos = new FileOutputStream(path);
		fos.write(data);
		fos.close();
		System.out.println("Uploaded");
		m.addAttribute("msg","Uploaded Succesfully");
		m.addAttribute("filename",file.getOriginalFilename());
		return "filesuccess";
	}
}

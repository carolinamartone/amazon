package it.csttech.admin.controllers;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UploadController {
	@RequestMapping(value = "/admin/upload", method = RequestMethod.GET)
	public String index() {
		return "/admin/upload";
	}

	@RequestMapping(value = "/admin/upload", method = RequestMethod.POST)
	// @PostMapping("/admin/upload") // //new annotation since 4.3
	public String singleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {

		if (file.isEmpty()) {
			redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
			return "redirect:/admin/uploadStatus";
		}

		redirectAttributes.addFlashAttribute("message",
				"You successfully uploaded '" + file.getOriginalFilename() + "' with size " + file.getSize() +" byte."); 
		File dest = new File("C:\\Users\\Carolina.Martone\\workspace\\Amazon");
		try{
		file.transferTo(dest);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return "redirect:/admin/uploadStatus";
	}

	@RequestMapping(value = "/admin/uploadStatus", method = RequestMethod.GET)
	public String uploadStatus() {
		return "/admin/uploadStatus";
	}

}

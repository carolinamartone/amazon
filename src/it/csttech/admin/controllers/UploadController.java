package it.csttech.admin.controllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import it.csttech.manager.ArticoloManager;
import it.csttech.model.Articolo;

@Controller
public class UploadController {
	private static Logger log = LogManager.getLogger(UploadController.class);

	@Autowired
	public ArticoloManager articoloManager;

	@RequestMapping(value = "/admin/upload", method = RequestMethod.GET)
	public String index() {
		return "/admin/upload";
	}

	@RequestMapping(value = "/admin/upload", method = RequestMethod.POST)
	// @PostMapping("/admin/upload") // //new annotation since 4.3
	public String singleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
		log.info("sto");

		if (file.isEmpty()) {
			redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
			return "redirect:/admin/uploadStatus";
		}

		redirectAttributes.addFlashAttribute("message", "You successfully uploaded '" + file.getOriginalFilename()
				+ "' with size " + file.getSize() + " byte.");
		File dest = new File("C:\\Users\\Carolina.Martone\\workspace\\Amazon\\upload\\" + file.getOriginalFilename());
		try {
			file.transferTo(dest);
			createArticoloFromRead(dest);
			log.info("I'm creating a new Articolo");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/admin/uploadStatus";
	}

	@RequestMapping(value = "/admin/uploadStatus", method = RequestMethod.GET)
	public String uploadStatus() {
		return "/admin/uploadStatus";
	}

	private void createArticoloFromRead(File fileCsv) {

		try {
			InputStream ips = new FileInputStream(fileCsv);
			InputStreamReader ipsr = new InputStreamReader(ips);
			BufferedReader br = new BufferedReader(ipsr);
			String line;
			while ((line = br.readLine()) != null) {
				String[] s = line.split(";");
				Articolo articolo = new Articolo();
				articolo.setCategoryId(Integer.parseInt(s[0]));
				articolo.setImmagineUrl(s[1]);
				articolo.setName(s[2]);
				articolo.setPrezzo(Double.parseDouble(s[4]));
				articolo.setQuantita(Integer.parseInt(s[3]));
				log.info("sto aggiungendo l'articolo" + articolo);
				articoloManager.save(articolo);
			}
			br.close();
		} catch (IOException io) {
			io.printStackTrace();
		}

	}
	/*
	 * log.info("Enter"+fileCsv); Scanner inputStream = new Scanner(fileCsv);
	 * inputStream.useDelimiter(";"); while (inputStream.hasNextLine()) { String
	 * line =inputStream.nextLine(); log.info( line+ ","); }
	 * inputStream.close();
	 * 
	 * }
	 */

}

package hello;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.io.File;
import java.io.*;
import net.sourceforge.tess4j.*;

@RestController
public class HelloController {

    @RequestMapping("/")
    public String index() {
		//Creates file instance and references the file in its location
		//WHere get image from camera??
		//File imageFile = new File("C:\\Users\\images\\blah.tif");
		File imageFile = new File("C:\\Users\\HCREAL\\git\\DHW\\images\\Southern_Life_in_Southern_Literature_text_page_322.jpg");
		
		//Creating a new tesseract instance and setting the data path with the trained data
		ITesseract instance = new Tesseract();
		instance.setDatapath("C:\\Users\\HCREAL\\git\\DHW\\tessdata"); //<-tessdata data path
		String result ="";
		//Try catch that runs the OCR on the file/document/camera
		try {
			 result = instance.doOCR(imageFile);
			//System.out.println(result);
			
			//Catch if the OCR fails
		} catch(TesseractException e) {
			System.err.println(e.getMessage());
		}
		return result;
	}
 }

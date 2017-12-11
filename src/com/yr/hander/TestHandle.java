package com.yr.hander;

import java.io.InputStream;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.yr.service.BookServiceImpl;
import com.yr.service.PoiServiceImpl;

@Controller
public class TestHandle {

	@Autowired
	private BookServiceImpl bookServiceImpl;

	@Autowired
	private PoiServiceImpl poiServiceImpl;

	@ResponseBody
	@RequestMapping(value = "/test", method = RequestMethod.POST)
	public String test(@RequestBody String str) {
		System.out.println(str);
		return "test";
	}

	@RequestMapping(value = "/testFileUpload")
	public void testFileUpload(@RequestParam("text") String desc, @RequestParam("file") MultipartFile file)
			throws Exception {
		System.out.println("text:" + desc);
		System.out.println("fileName:" + file.getOriginalFilename());
		System.out.println(file.getInputStream());
	}

	@RequestMapping(value = "/testResponseEntity")
	public ResponseEntity<byte[]> testResponseEntity(HttpSession session, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String path = request.getSession().getServletContext().getRealPath("file");  
        String url = path+"/User.xlsx";
        poiServiceImpl.testWrite(url);
        
        byte[] b = null;
		ServletContext servletContext = session.getServletContext();
		InputStream inputStream = servletContext.getResourceAsStream("/file/User.xlsx");
		b = new byte[inputStream.available()];
		inputStream.read(b);

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Content-Disposition", "attachment;filename=User.xlsx");

		HttpStatus status = HttpStatus.OK;

		ResponseEntity<byte[]> entity = new ResponseEntity<byte[]>(b, httpHeaders, status);
		return entity;
	}

	@RequestMapping(value = "/i18n")
	public String Internationalization(Locale locale, Map<String, Object> map) {
		System.out.println(locale);
		map.put("language", locale);
		return "login";
	}

	@RequestMapping("/testTransactional")
	public String testTransactional(@RequestParam("userId") int id, @RequestParam("bookId") String isbn) {
		bookServiceImpl.testTransactional(id, isbn);
		return "test";
	}

	@RequestMapping("/testPoi")
	public String testPoi(@RequestParam("file") MultipartFile file,HttpServletRequest request) throws Exception {
		poiServiceImpl.testPoi(file.getInputStream());
		return "test";
	}
}

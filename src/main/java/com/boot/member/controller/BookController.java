package com.boot.member.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.boot.member.dto.BookDto;
import com.boot.member.dto.Criteria;
import com.boot.member.dto.PageDTO;
import com.boot.member.service.BookService;

import lombok.extern.slf4j.Slf4j;
@Controller
@Slf4j
public class BookController {

	@Autowired
	private BookService service;
	
	@RequestMapping("/mainpage")
	public String mainpage(Model model, HttpSession session){
		log.info("@# mainpage");
		
		String user_id = (String) session.getAttribute("user_id"); // 세션 받아서 변수화
		if (user_id != null) { // id 있으면 -> 로그인 상태
			model.addAttribute("user_id", user_id); // 세션 넘겨줌
			log.info("@# success ,  session user_id : " + user_id);
		};
		ArrayList<BookDto> book_list = service.mainpage();
		ArrayList<BookDto> bookcat4_list = service.bookcat4image();
		
		model.addAttribute("list", book_list);
		model.addAttribute("bookcat4_list", bookcat4_list);
		
		return "mainpage";
	}
	@RequestMapping("/footer2")
	public String footer(){
		log.info("@# footer2");
		
		return "footer2";
	}
	
//	@RequestMapping("/bookcat_list")
//	public String bookcat_list(){
//		log.info("@# bookcat_list");
//		ArrayList<BookDto> bookcat_list = service.bookcat_list();
//		for (BookDto dto : bookcat_list) {
//            System.out.println("Book Category: " + dto.getBook_cat() + ", Count: " + dto.getCount());
//        }
//		return "mainpage";
//	}
	@RequestMapping("/bookcat_list")
	@ResponseBody // JSON 형태의 데이터를 반환하는 어노테이션
	public List<BookDto> bookcat_list(){
	    log.info("@# bookcat_list");
	    
	    return service.bookcat_list();
	}
	
	
	
	@RequestMapping("/book_Write")
	public String book_Write() {
		log.info("@@@###  book_Write()");
		
		return "book_Write";
	}
	
	@RequestMapping("/book_writeOk")
	public String book_writeOk(@RequestParam HashMap<String, String> param,
			@RequestParam("uploadFile") MultipartFile[] uploadFiles){
		log.info("@@@### Bookcontroller book_write()");
		book_uploadFile(param, uploadFiles);
		service.book_write(param);

		return "redirect:book_Write";
	}
	
	
	public void book_uploadFile(@RequestParam HashMap<String, String> param,
			@RequestParam("uploadFile") MultipartFile[] uploadFiles) {
		log.info("@@@### Bookcontroller book_uploadFile()");
		
//		학원
		String uploadFolder = "D:\\dev\\green";
//		집
//		String uploadFolder = "C:\\dev\\green";
		
		File uploadDir = new File(uploadFolder);
		if (!uploadDir.exists()) {
			uploadDir.mkdirs();
		}
		
		List<String> save_bookimage = new ArrayList<>(); // 파일명 목록을 저장할 리스트
		
		for (MultipartFile uploadFile : uploadFiles) {
			if (!uploadFile.isEmpty()) {
				log.info("-----------------------------------------------");
				log.info("파일 이름 : " + uploadFile.getOriginalFilename());
				log.info("파일 타입 : " + uploadFile.getContentType());
				log.info("파일 크기 : " + uploadFile.getSize());
				
				// UUID 생성
				String uuid = UUID.randomUUID().toString().replace("-", "");
				
				String originalFileName = uploadFile.getOriginalFilename();
				String extension = originalFileName.substring(originalFileName.lastIndexOf("."));
				
				String saveFileName = uuid + extension;
				File saveFile = new File(uploadFolder, saveFileName);
				
				try {
					uploadFile.transferTo(saveFile);
					save_bookimage.add(saveFileName); // 파일명을 리스트에 추가
//																								
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		}
		
		if (save_bookimage != null) {
			// 파일명 리스트를 param 매개변수에 추가
			param.put("save_bookimage", save_bookimage.toString().replace("[", "").replace("]", ""));
		}
	}
	
	
	@RequestMapping("/book_list")
	public String book_list(Criteria cri, Model model) {
		log.info("@@@### prodcontroller book_list");
		log.info("@@@### prodcontroller book_list cri ===>" + cri);

		ArrayList<BookDto> book_list = service.book_list(cri);
		

		log.info(""+book_list);
		model.addAttribute("list", book_list);
		int total = service.book_getTotalCount(cri);

		log.info("@# prodcontroller book_list total ===>" + total);

		model.addAttribute("pageMaker", new PageDTO(total, cri));

		return "book_list";
	}

	@RequestMapping("/search_list")
	public String search_list(@RequestParam HashMap<String, String> param, Model model) {
		log.info("@#  search_list() ======");

		log.info("@#  search_list() ======"+param);
		
		ArrayList<BookDto> search_list = service.search_list(param);
		
		model.addAttribute("book_catcount", service.book_catcount(param));
		model.addAttribute("searchmanager",search_list);
		
		return "searchlist";
	}
	@RequestMapping("/book_catlist")
	public String book_catlist(@RequestParam HashMap<String, String> param, Model model) {
		log.info("@#  book_catlist() ======");
		
		log.info("@#  book_catlist() ======"+param);
		
		ArrayList<BookDto> book_catlist = service.book_catlist(param);
		
		model.addAttribute("book_catcount", service.book_catcount(param));
		model.addAttribute("book_catlist",book_catlist);
		model.addAttribute("book_cat",param.get("book_cat"));
		
		return "book_catlist";
	}
	@RequestMapping("/book_search")
	public String book_search(@RequestParam HashMap<String, String> param, Model model) {
		log.info("@#  book_search() ======");

		log.info("@#  book_search() ======"+param);
		
		ArrayList<BookDto> book_search = service.book_search(param);
		
		model.addAttribute("book_search",book_search);
		
		return "book_search";
	}
	
	@RequestMapping("/book_content_view")
	public String book_content_view(@RequestParam HashMap<String, String> param, Model model) {
		log.info("@@@### bookcontroller book_content_view() ");

		BookDto dto = service.book_contentView(param);

		model.addAttribute("book_content_view", dto);
		
		return "book_content_view";
	}

	
	@RequestMapping("book_modify")
	public String book_modify(@RequestParam HashMap<String, String> param) {
		log.info("@# book_modify");

		log.info(""+param);
		service.book_modify(param);

		return "redirect:book_list";
	}


	@RequestMapping("/book_delete")
	public String book_delete(@RequestParam HashMap<String, String> param) {
		log.info("@@@### bookcontroller book_delete()");

		// 파일 삭제 로직 추가
		log.info(param.get("book_image"));
	    String book_image = param.get("book_image");
	    if (book_image != null && !book_image.isEmpty()) {
	        String[] filesToDelete = book_image.split(", ");
	        String uploadFolder = "D:\\dev\\green"; // 파일이 저장된 폴더 경로 (학원)
//	         String uploadFolder = "C:\\dev\\green"; // 파일이 저장된 폴더 경로 (집)

	        for (String fileName : filesToDelete) {
	            File fileToDelete = new File(uploadFolder, fileName);
	            if (fileToDelete.exists()) {
	                fileToDelete.delete();
	                log.info("File deleted: " + fileToDelete.getAbsolutePath());
	            }
	        }
	    }
		
		service.book_delete(param);

		return "redirect:book_list";
	}
	
	@RequestMapping("/book_user_view")
	public String book_user_view(@RequestParam HashMap<String, String> param, Model model, HttpSession session) {
		log.info("@@@### bookcontroller book_user_view() ");

		String user_id = (String) session.getAttribute("user_id"); // 세션 받아서 변수화
		if (user_id != null) { // id 있으면 -> 로그인 상태
			model.addAttribute("user_id", user_id); // 세션 넘겨줌
			log.info("@# success ,  session user_id : " + user_id);
		}
		
		BookDto dto = service.book_user_view(param);

		model.addAttribute("book_user_view", dto);

		return "book_user_view";
	}

	
}

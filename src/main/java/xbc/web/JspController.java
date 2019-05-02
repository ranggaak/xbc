package xbc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JspController {
	
	

	@RequestMapping("/secure/test-type")
	public String testType(){
		return "test-type";
	}
	
	@RequestMapping("/secure/bootcamp-test-type")
	public String bootcampTestType(){
		return "bootcamp-test-type";
	}
	
	@RequestMapping("/secure/assignment")
	public String assignment(){
		return "assignment";
	}
	
	@RequestMapping("/secure/idle-news")
	public String idleNews(){
		return "idle-news";
	}
	
	// Punya orang lain
	
	@RequestMapping("/secure/category")
	public String category() {
		return "category";
	}
	
	@RequestMapping("/secure/biodata")
	public String biodata(){
		return "biodata";
	}
	
	@RequestMapping("login")
	public String login(){
		return "login";
	}
	
	@RequestMapping("/secure/home")
	public String home(){
		return "home";
	}
}

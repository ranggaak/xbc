package xbc.web;

import java.util.Collection;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import xbc.model.Category;
import xbc.service.CategoryService;

@RestController
@RequestMapping("secure/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public ResponseEntity<Collection<Category>> findAll() {
		Collection<Category> list = categoryService.findAll();
		
		ResponseEntity<Collection<Category>> result = new ResponseEntity<>(list, HttpStatus.OK);
		return result;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<Collection<Category>> search(@RequestParam(value = "codeOrName") String codeOrName) {
		Collection<Category> list = categoryService.search(codeOrName);

		ResponseEntity<Collection<Category>> result = new ResponseEntity<>(list, HttpStatus.OK);
		return result;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Category> findOne(@PathVariable("id") Integer id) {
		Category category = categoryService.findOne(id);

		ResponseEntity<Category> result = new ResponseEntity<>(category, HttpStatus.OK);
		return result;
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<Category> save(@RequestBody Category category, HttpSession session) {
		categoryService.save(category, (Integer) session.getAttribute("sessionId"));

		ResponseEntity<Category> result = new ResponseEntity<>(HttpStatus.OK);
		return result;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Category> softDeleteById(@PathVariable("id") Integer id, HttpSession session) {
		categoryService.softDeleteById(id, (Integer) session.getAttribute("sessionId"));

		ResponseEntity<Category> result = new ResponseEntity<>(HttpStatus.OK);
		return result;
	}

	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public ResponseEntity<Category> update(@RequestBody Category category, HttpSession session) {
		categoryService.update(category, (Integer) session.getAttribute("sessionId"));

		ResponseEntity<Category> result = new ResponseEntity<>(HttpStatus.OK);
		return result;
	}
	

}
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

import xbc.model.TestType;
import xbc.service.TestTypeService;

@RestController
@RequestMapping("secure/test-type")
public class TestTypeController {

	@Autowired
	private TestTypeService testTypeService;
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public ResponseEntity<Collection<TestType>> search(@RequestParam(value = "name") String name) {
		Collection<TestType> list = testTypeService.search(name);
		
		ResponseEntity<Collection<TestType>> result = new ResponseEntity<>(list, HttpStatus.OK);
//		session.setsession("id")=1;
		return result;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<TestType> findOne(@PathVariable("id") Integer id) {
	    TestType testType = testTypeService.findOne(id);
		
		ResponseEntity<TestType> result = new ResponseEntity<>(testType, HttpStatus.OK);
		return result;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<String> save(@RequestBody TestType testType, HttpSession session) {
		if (testTypeService.checkDuplicate(testType.getName(), testType.getId())) {
			ResponseEntity<String> result = new ResponseEntity<>("Test Type yang sama sudah terdaftar", HttpStatus.CONFLICT);
			return result;
		} else {
			testTypeService.save(testType, (Integer) session.getAttribute("sessionId"));
			ResponseEntity<String> result = new ResponseEntity<>("OK", HttpStatus.OK);
		return result;
		}
	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<TestType> softDeleteById(@PathVariable("id") Integer id, HttpSession session) {
        testTypeService.softDeleteById(id, (Integer) session.getAttribute("sessionId"));
		
		ResponseEntity<TestType> result = new ResponseEntity<>(HttpStatus.OK);
		return result;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public ResponseEntity<String> update(@RequestBody TestType testType, HttpSession session) {
		if (testTypeService.checkDuplicate(testType.getName(), testType.getId())) {
			ResponseEntity<String> result = new ResponseEntity<>("Test Type yang sama sudah terdaftar", HttpStatus.CONFLICT);
			return result;
		} else {
			testTypeService.update(testType, (Integer) session.getAttribute("sessionId"));
			ResponseEntity<String> result = new ResponseEntity<>("OK", HttpStatus.OK);
		return result;
		}
	}
}

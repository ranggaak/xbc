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

import xbc.model.BootcampTestType;
import xbc.service.BootcampTestTypeService;

@RestController
@RequestMapping("secure/bootcamp-test-type")
public class BootcampTestTypeController {

	@Autowired
	private BootcampTestTypeService bootcampTestTypeService;
	
	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public ResponseEntity<Collection<BootcampTestType>> findAll() {
		Collection<BootcampTestType> list = bootcampTestTypeService.findAll();
		
		ResponseEntity<Collection<BootcampTestType>> result = new ResponseEntity<>(list, HttpStatus.OK);
		return result;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<Collection<BootcampTestType>> search(@RequestParam(value = "name") String name) {
		Collection<BootcampTestType> list = bootcampTestTypeService.search(name);

		ResponseEntity<Collection<BootcampTestType>> result = new ResponseEntity<>(list, HttpStatus.OK);
		return result;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<BootcampTestType> findOne(@PathVariable("id") Integer id) {
		BootcampTestType bootcampTestType = bootcampTestTypeService.findOne(id);

		ResponseEntity<BootcampTestType> result = new ResponseEntity<>(bootcampTestType, HttpStatus.OK);
		return result;
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public Integer save(@RequestBody BootcampTestType bootcampTestType, HttpSession session) {
		//bootcampTestTypeService.save(bootcampTestType, (Integer) session.getAttribute("sessionId"));
		Integer result = bootcampTestTypeService.save(bootcampTestType, (Integer) session.getAttribute("sessionId"));
		//ResponseEntity<BootcampTestType> result = new ResponseEntity<>(HttpStatus.OK);
		return result;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<BootcampTestType> softDeleteById(@PathVariable("id") Integer id, HttpSession session) {
		bootcampTestTypeService.softDeleteById(id, (Integer) session.getAttribute("sessionId"));

		ResponseEntity<BootcampTestType> result = new ResponseEntity<>(HttpStatus.OK);
		return result;
	}

	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public ResponseEntity<BootcampTestType> update(@RequestBody BootcampTestType bootcampTestType, HttpSession session) {
		bootcampTestTypeService.update(bootcampTestType, (Integer) session.getAttribute("sessionId"));

		ResponseEntity<BootcampTestType> result = new ResponseEntity<>(HttpStatus.OK);
		return result;
	}
}

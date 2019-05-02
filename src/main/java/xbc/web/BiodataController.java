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

import xbc.model.Biodata;
import xbc.service.BiodataService;

@RestController
@RequestMapping("secure/biodata")
public class BiodataController {
	
	@Autowired
	private BiodataService biodataService;
	
	@RequestMapping(value="/findAll", method=RequestMethod.GET)
	public ResponseEntity<Collection<Biodata>> findAll() {
		Collection<Biodata> list = biodataService.findAll();
		ResponseEntity<Collection<Biodata>> result = new ResponseEntity<>(list, HttpStatus.OK);
		return result;
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ResponseEntity<Collection<Biodata>> search(@RequestParam(value = "nameOrMajors") String nameOrMajors) {
		Collection<Biodata> list = biodataService.search(nameOrMajors);
		ResponseEntity<Collection<Biodata>> result = new ResponseEntity<>(list, HttpStatus.OK);
		return result;
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Biodata> findOne(@PathVariable("id") Integer id) {
		Biodata biodata = biodataService.findOne(id);
		ResponseEntity<Biodata> result = new ResponseEntity<>(biodata, HttpStatus.OK);
		return result;
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public ResponseEntity<Biodata> save(@RequestBody Biodata biodata, HttpSession session) {
//		biodata.setCreateBy(session.getSession('id"));
		biodataService.save(biodata, (Integer) session.getAttribute("sessionId"));
		
		ResponseEntity<Biodata> result = new ResponseEntity<> (HttpStatus.OK);
		return result;
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Biodata> softDeleteById(@PathVariable("id") Integer id, HttpSession session) {
		biodataService.softDeleteById(id, (Integer) session.getAttribute("sessionId"));
		ResponseEntity<Biodata> result = new ResponseEntity<>(HttpStatus.OK);
		return result;
	}
	
	@RequestMapping(value="/", method=RequestMethod.PUT)
	public ResponseEntity<Biodata> update(@RequestBody Biodata biodata, HttpSession session) {
		biodataService.update(biodata, (Integer) session.getAttribute("sessionId"));
		ResponseEntity<Biodata> result = new ResponseEntity<>(HttpStatus.OK);
		return result;
	}	
}

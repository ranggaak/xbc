package xbc.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

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

import xbc.model.Assignment;
import xbc.service.AssignmentService;

@RestController
@RequestMapping("secure/assignment")
public class AssignmentController {

	@Autowired
	private AssignmentService assignmentService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<Collection<Assignment>> search(@RequestParam(value = "title") String title) {
		Collection<Assignment> list = assignmentService.search(title);

		ResponseEntity<Collection<Assignment>> result = new ResponseEntity<>(list, HttpStatus.OK);
		return result;
	}
	
	@RequestMapping(value = "/searchByDate", method = RequestMethod.GET)
	public ResponseEntity<Collection<Assignment>> searchByDate(@RequestParam(value = "strStartDate") String strStartDate) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date startDate = null;
		
		if (strStartDate !=""){
			startDate = format.parse(strStartDate);
			Collection<Assignment> list = assignmentService.searchByDate(startDate);
			ResponseEntity<Collection<Assignment>> result = new ResponseEntity<>(list, HttpStatus.OK);
			return result;
		}else{
			Collection<Assignment> list2 = assignmentService.findAllMenu();
			ResponseEntity<Collection<Assignment>> result2 = new ResponseEntity<>(list2, HttpStatus.OK);
			return result2;
		}

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Assignment> findOne(@PathVariable("id") Integer id) {
		Assignment assignment = assignmentService.findOne(id);

		ResponseEntity<Assignment> result = new ResponseEntity<>(assignment, HttpStatus.OK);
		return result;
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<Assignment> save(@RequestBody Assignment assignment, HttpSession session) {
		assignmentService.save(assignment, (Integer) session.getAttribute("sessionId"));

		ResponseEntity<Assignment> result = new ResponseEntity<>(HttpStatus.OK);
		return result;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Assignment> softDeleteById(@PathVariable("id") Integer id, HttpSession session) {
		assignmentService.softDeleteById(id, (Integer) session.getAttribute("sessionId"));

		ResponseEntity<Assignment> result = new ResponseEntity<>(HttpStatus.OK);
		return result;
	}

	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public ResponseEntity<Assignment> update(@RequestBody Assignment assignment, HttpSession session) {
		assignmentService.update(assignment, (Integer) session.getAttribute("sessionId"));

		ResponseEntity<Assignment> result = new ResponseEntity<>(HttpStatus.OK);
		return result;
	}
	
	@RequestMapping(value = "/hold/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Assignment> holdById(@PathVariable("id") Integer id, HttpSession session) {
		assignmentService.holdById(id, (Integer) session.getAttribute("sessionId"));

		ResponseEntity<Assignment> result = new ResponseEntity<>(HttpStatus.OK);
		return result;
	}
	
	@RequestMapping(value = "/done/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Assignment> doneById(@RequestBody Assignment assignment, HttpSession session) {
		assignmentService.doneById(assignment, (Integer) session.getAttribute("sessionId"));

		ResponseEntity<Assignment> result = new ResponseEntity<>(HttpStatus.OK);
		return result;
	}
}
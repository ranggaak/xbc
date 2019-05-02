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

import xbc.model.IdleNews;
import xbc.service.IdleNewsService;

@RestController
@RequestMapping("secure/idle-news")
public class IdleNewsController {

	@Autowired
	private IdleNewsService idleNewsService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<Collection<IdleNews>> search(@RequestParam(value = "title") String title) {
		Collection<IdleNews> list = idleNewsService.search(title);

		ResponseEntity<Collection<IdleNews>> result = new ResponseEntity<>(list, HttpStatus.OK);
		return result;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<IdleNews> findOne(@PathVariable("id") Integer id) {
		IdleNews idleNews = idleNewsService.findOne(id);

		ResponseEntity<IdleNews> result = new ResponseEntity<>(idleNews, HttpStatus.OK);
		return result;
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<IdleNews> save(@RequestBody IdleNews idleNews, HttpSession session) {
		idleNewsService.save(idleNews, (Integer) session.getAttribute("sessionId"));

		ResponseEntity<IdleNews> result = new ResponseEntity<>(HttpStatus.OK);
		return result;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<IdleNews> softDeleteById(@PathVariable("id") Integer id, HttpSession session) {
		idleNewsService.softDeleteById(id, (Integer) session.getAttribute("sessionId"));

		ResponseEntity<IdleNews> result = new ResponseEntity<>(HttpStatus.OK);
		return result;
	}

	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public ResponseEntity<IdleNews> update(@RequestBody IdleNews idleNews, HttpSession session) {
		idleNewsService.update(idleNews, (Integer) session.getAttribute("sessionId"));

		ResponseEntity<IdleNews> result = new ResponseEntity<>(HttpStatus.OK);
		return result;
	}
	
	@RequestMapping(value = "/publish/{id}", method = RequestMethod.PUT)
	public ResponseEntity<IdleNews> publishById(@PathVariable("id") Integer id, HttpSession session) {
		idleNewsService.publishById(id, (Integer) session.getAttribute("sessionId"));

		ResponseEntity<IdleNews> result = new ResponseEntity<>(HttpStatus.OK);
		return result;
	}
}
package xbc.web;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import xbc.model.IdleMonitoring;
import xbc.service.IdleMonitoringService;

@RestController
@RequestMapping("secure/idle-monitoring")
public class IdleMonitoringController {
	
	@Autowired
	private IdleMonitoringService idleMonitoringService;
	
	@RequestMapping(value="/findAll", method=RequestMethod.GET)
	public ResponseEntity<Collection<IdleMonitoring>> findAll() {
		Collection<IdleMonitoring> list = idleMonitoringService.findAll();
		ResponseEntity<Collection<IdleMonitoring>> result = new ResponseEntity<>(list, HttpStatus.OK);
		return result;
	}
}
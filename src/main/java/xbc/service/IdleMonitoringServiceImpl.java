package xbc.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xbc.dao.IdleMonitoringDao;
import xbc.model.IdleMonitoring;
import xbc.model.IdleNews;

@Service
@Transactional
public class IdleMonitoringServiceImpl implements IdleMonitoringService{

	@Autowired
	private IdleMonitoringDao idleMonitoringDao;
	
	@Override
	public Collection<IdleMonitoring> findAll() {
		return idleMonitoringDao.findAll();
	}
}

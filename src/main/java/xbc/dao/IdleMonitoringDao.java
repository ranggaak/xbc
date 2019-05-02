package xbc.dao;

import java.util.Collection;

import xbc.model.IdleMonitoring;

public interface IdleMonitoringDao {

	public Collection<IdleMonitoring> findAll();
}

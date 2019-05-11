package xbc.web;

import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;

import xbc.model.Assignment;
import xbc.model.AuditLog;
import xbc.model.Biodata;
import xbc.model.BootcampTestType;
import xbc.model.Category;
import xbc.model.IdleMonitoring;
import xbc.model.IdleNews;
import xbc.model.Role;
import xbc.model.TestType;
import xbc.model.User;

public class IgnoranceInstropector extends JacksonAnnotationIntrospector {
	public boolean hasIgnoreMarker(AnnotatedMember m) {
		boolean result = false;
		
		if (m.getRawType() == AuditLog.class|| 
			m.getRawType() == Assignment.class ||
			m.getRawType() == Biodata.class ||
			m.getRawType() == BootcampTestType.class ||
			m.getRawType() == Category.class ||
			m.getRawType() == IdleMonitoring.class ||
			m.getRawType() == IdleNews.class ||
			m.getRawType() == Role.class ||
			m.getRawType() == TestType.class ||
			m.getRawType() == User.class) 
		{
		result = true;	
		}
	return result || super.hasIgnoreMarker(m);
	}
}

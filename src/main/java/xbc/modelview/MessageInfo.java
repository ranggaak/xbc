package xbc.modelview;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MessageInfo implements Serializable {

	private List<String> message = new ArrayList<>() ;

	
	public void addMessage(String message) {
		this.message.add(message);
	}
	
	public List<String> getMessage() {
		return message;
	}

	public void setMessage(List<String> message) {
		this.message = message;
	}
	
}
package org.saurabh.restexample.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.saurabh.restexample.messenger.database.DatabaseClass;
import org.saurabh.restexample.messenger.exception.DataNotFoundException;
import org.saurabh.restexample.messenger.model.Message;

public class MessageService {
	
	private Map<Long, Message> messages = DatabaseClass.getMessages();
	
	public MessageService() {
		messages.put(1L, new Message(1L, "Hello World !!!", "Saurabh"));
		messages.put(2L, new Message(2L, "Hello Jersey !!!", "Saurabh"));
	}
	
	public List<Message> getAllMessages() {
		return new ArrayList<Message>(messages.values());
	}
	
	// Year filter service
	public List<Message> getMessagesForYear(int year) {
		List<Message> messagesForYear = new ArrayList<Message>();
		Calendar cal = Calendar.getInstance();
		
		for (Message message : messages.values()) {
			cal.setTime(message.getCreated());
			if (cal.get(Calendar.YEAR) == year) {
				messagesForYear.add(message);
			}
		}
		
		return messagesForYear;
	}
	
	// Pagination service
	public List<Message> getMessagesPaginated(int start, int pageSize) {
		List<Message> paginatedMessages = new ArrayList<Message>(messages.values());
		if((start + pageSize) > paginatedMessages.size()) return new ArrayList<Message>();
		
		return paginatedMessages.subList(start, start + pageSize);
	}
	
	public Message getMessage(long id) {
		Message msg = messages.get(id);
		if (msg == null) {
			throw new DataNotFoundException("Message id " + id + " not found in messages..");
		}
		
		return msg;
	}
	
	public Message addMessage(Message message) {
		message.setId(messages.size() + 1);
		message.setCreated(null);
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message) {
		if (message.getId() <= 0) {
			return null;
		}
		
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message removeMessage(long id) {
		return messages.remove(id);
	}
}

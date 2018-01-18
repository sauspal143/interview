package org.saurabh.restexample.messenger.database;

import java.util.HashMap;
import java.util.Map;

import org.saurabh.restexample.messenger.model.Message;
import org.saurabh.restexample.messenger.model.Profile;

public class DatabaseClass {
	
	// This is not thread safe. Just for testing purpose
	private static Map<Long, Message> messages = new HashMap<Long, Message>();
	private static Map<String, Profile> profiles = new HashMap<String, Profile>();
	
	public static Map<Long, Message> getMessages() {
		return messages;
	}
	
	public static Map<String, Profile> getProfiles() {
		return profiles;
	}
}

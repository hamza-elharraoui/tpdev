package com.apiRestTPDEV.dao;

import java.io.IOException;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;

import com.apiRestTPDEV.model.User;

public class JsonUserDeserializer extends JsonDeserializer<User> {

	private UserDAO userDAO = new UserDAO();

	@Override
	public User deserialize(JsonParser parser, DeserializationContext context)
			throws IOException, JsonProcessingException {
		String idUser = parser.getText();

		return (User) userDAO.getUserById(Long.valueOf(idUser));
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

}

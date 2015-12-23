package com.apiRestTPDEV.dao;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

import com.apiRestTPDEV.model.User;

public class JsonUserSerializer extends JsonSerializer<User>{

	@Override
	public void serialize(User user, JsonGenerator gen, SerializerProvider provider)
			throws IOException, JsonProcessingException {

		Long idUser = user.getId();
		gen.writeString(idUser.toString());
	}

}

package com.apiRestTPDEV.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.apiRestTPDEV.dao.EventDAO;
import com.apiRestTPDEV.dao.MuseumDAO;
import com.apiRestTPDEV.dao.UserDAO;
import com.apiRestTPDEV.model.Event;
import com.sun.jersey.api.client.ClientResponse.Status;

@Path("/events")
public class Services {

	private EventDAO eventDAO = new EventDAO();
	private UserDAO userDAO = new UserDAO();
	private MuseumDAO museumDAO = new MuseumDAO();

	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,
			MediaType.APPLICATION_FORM_URLENCODED })
	@Produces(MediaType.APPLICATION_JSON)
	public Response addEvent(Event e) {
		eventDAO.addEvent(e);
		return Response.status(Status.CREATED).entity("The event is created")
				.build();
	}
	@Path("/subscribe/{id}")
	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,
			MediaType.APPLICATION_FORM_URLENCODED })
	@Produces(MediaType.APPLICATION_JSON)
	public Response subscribe(@PathParam("id")Long id) {
		Event e = eventDAO.getEventById(id);
		e.setParticipants(e.getParticipants()+1);
		eventDAO.updateEvent(e);
		return Response.status(Status.CREATED).entity("You have joined the event")
				.build();
	}

	@GET
	@Path("/{id}")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,
			MediaType.APPLICATION_FORM_URLENCODED })
	@Produces(MediaType.APPLICATION_JSON)
	public Response getEvent(@PathParam("id") Long id) {
		Event event = eventDAO.getEventById(id);
		return Response.status(Status.OK).entity(event).build();
	}

	@DELETE
	@Path("/{id}")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,
			MediaType.APPLICATION_FORM_URLENCODED })
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteEvent(@PathParam("id") Long id) {
		eventDAO.deleteEvent(id);
		return Response.status(Status.OK).entity("The event is deleted")
				.build();
	}

	@GET
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,
			MediaType.APPLICATION_FORM_URLENCODED })
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllEvents() {
		List<Event> events = eventDAO.getAllEvents();
		return Response.status(Status.OK).entity(events).build();
	}

	public EventDAO getEventDAO() {
		return eventDAO;
	}

	public void setEventDAO(EventDAO eventDAO) {
		this.eventDAO = eventDAO;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public MuseumDAO getMuseumDAO() {
		return museumDAO;
	}

	public void setMuseumDAO(MuseumDAO museumDAO) {
		this.museumDAO = museumDAO;
	}
}

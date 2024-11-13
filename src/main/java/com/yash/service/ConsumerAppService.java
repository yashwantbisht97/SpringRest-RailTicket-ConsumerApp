package com.yash.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.yash.binding.Passenger;
import com.yash.binding.Ticket;

@Service
public class ConsumerAppService {
public Ticket bookTicket(Passenger p) {
	String apiUrl="http:3.95.217.140:8080//ticket";
	RestTemplate rt=new RestTemplate();
	ResponseEntity<Ticket> forEntity=rt.postForEntity(apiUrl,p, Ticket.class);
	Ticket body=forEntity.getBody();
	return body;
	}

public List<Ticket> getAllTickets(){
	String apiUrl="http://3.95.217.140:8080//tickets";   //aws hosted url
	RestTemplate rt=new RestTemplate();
	ResponseEntity<Ticket[]> forEntity=rt.getForEntity(apiUrl, Ticket[].class);
	Ticket[] body=forEntity.getBody();
	List<Ticket> tickets=Arrays.asList(body);
	return tickets;
	}
}

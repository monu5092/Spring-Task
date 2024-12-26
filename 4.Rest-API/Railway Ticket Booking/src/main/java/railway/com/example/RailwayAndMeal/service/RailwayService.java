package railway.com.example.RailwayAndMeal.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PutMapping;
import railway.com.example.RailwayAndMeal.Entity.Ticket;
import railway.com.example.RailwayAndMeal.exceptions.TicketAlreadyExistsException;

@Service
public class RailwayService {

	public List<Ticket> list = new ArrayList<>();
	public Map<Long,Ticket> ticketMap = new HashMap<>();

	// This method retrieves a ticket based on its unique PNR from ticketmap.
	public Ticket getTicketByPnr(long pnr) {
		if(ObjectUtils.isEmpty(ticketMap.get(pnr))){
			throw new TicketAlreadyExistsException("No ticket found with pnr: "+pnr);
		}
		return ticketMap.get(pnr);
	}


	/** This function adds a ticket to a list and associates it with a PNR in a ticket map for
	 efficient retrieval. **/
	public void addTicket(Ticket ticket) {
		if(!ObjectUtils.isEmpty(ticketMap.get(ticket.getPnr()))){
			throw new TicketAlreadyExistsException("Ticket with id : "+ticket.getPnr()+" already exist");
		}
			list.add(ticket);
			ticketMap.put(ticket.getPnr(),ticket);
	}
	
	//This function returns a list of all tickets stored in the class.
	public List<Ticket> getAllTickets() {		
		return list;
	}


	public void deleteTicketByPnr(long pnr){
		Ticket ticket=this.getTicketByPnr(pnr);
		list.remove(ticket);
		ticketMap.remove(ticket.getPnr());
	}

	public void updateTicket(Ticket ticket){
       Ticket existing_Ticket = this.getTicketByPnr(ticket.getPnr());
	   list.remove(existing_Ticket.getPnr());

	   list.add(ticket);
	   ticketMap.put(ticket.getPnr(), ticket);
	}
}
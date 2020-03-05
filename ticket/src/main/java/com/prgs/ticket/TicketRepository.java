package com.prgs.ticket;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<ModelTicketDetails,Integer>{

}

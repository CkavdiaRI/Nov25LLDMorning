package Module3.ParkingLot.controllers;

import Module3.ParkingLot.dtos.IssueTicketRequestDTO;
import Module3.ParkingLot.dtos.IssueTicketResponseDTO;
import Module3.ParkingLot.dtos.ResponseStatus;
import Module3.ParkingLot.models.Ticket;
import Module3.ParkingLot.services.TicketService;

public class TicketController {
    private TicketService ticketService;

    public TicketController(TicketService ticketService){
        this.ticketService = ticketService;
    }

    public IssueTicketResponseDTO issueTicket(IssueTicketRequestDTO request){
        IssueTicketResponseDTO response = new IssueTicketResponseDTO();
        try{
            Ticket ticket = ticketService.issueTicket(
                request.getLicensePlate(),
                request.getVehicleType(),
                request.getOwnerName(),
                request.getGateId(),
                request.getParkingLotId()
                );

            response.setTicketId(ticket.getId());
            response.setFloorNumber(ticket.getParkingSlot().getParkingFloor().getNumber());
            response.setSlotNumber(ticket.getParkingSlot().getNumber());

            response.setStatus(ResponseStatus.SUCCESS);
            response.setMessage("Ticket issued successfully");

        }catch (Exception e){
            response.setStatus(ResponseStatus.FAILURE);
            response.setMessage(e.getMessage());
        }
        return response ;
    }
}

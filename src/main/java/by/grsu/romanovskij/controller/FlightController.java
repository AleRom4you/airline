package by.grsu.romanovskij.controller;

import by.grsu.romanovskij.DataTransferObject.FlightDto;
import by.grsu.romanovskij.model.Flight;
import by.grsu.romanovskij.model.FlightSearchForm;
import by.grsu.romanovskij.model.FlightWithFindedBrigade;
import by.grsu.romanovskij.model.Place;
import by.grsu.romanovskij.repository.BrigadeRepository;
import by.grsu.romanovskij.repository.FlightRepository;
import by.grsu.romanovskij.repository.PlaceRepository;
import by.grsu.romanovskij.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Controller
public class FlightController {

    @Autowired
    FlightRepository flightRepository;
    @Autowired
    FlightService flightService;
    @Autowired
    PlaceRepository placeRepository;
    @Autowired
    BrigadeRepository brigadeRepository;

    @RequestMapping(value = "/flight-list/{placeFrom}/{placeTo}", method = RequestMethod.GET)
    public String flightList(Model model,
                             @PathVariable("placeFrom") String fromPlace,
                             @PathVariable("placeTo") String toPlace) {

        Place placeFrom = placeRepository.findByPlaceAbbreviation(fromPlace.toUpperCase());
        Place placeTo = placeRepository.findByPlaceAbbreviation(toPlace.toUpperCase());

        model.addAttribute("title",
                placeFrom.getPlaceAbbreviation() + " - " +
                        placeTo.getPlaceAbbreviation() + " :: " +
                        "Flight list :: AirLine");

        model.addAttribute("places", placeRepository.findAll());
        model.addAttribute("from", placeFrom.getPlaceName());
        model.addAttribute("to", placeTo.getPlaceName());
        model.addAttribute("countFindedFlightsFromTo",
                flightRepository.countAllByPlaceFromIdAndPlaceToId(
                        placeFrom.getPlaceId(),
                        placeTo.getPlaceId()));
        model.addAttribute("countFindedFlightsToFrom",
                flightRepository.countAllByPlaceFromIdAndPlaceToId(
                        placeTo.getPlaceId(),
                        placeFrom.getPlaceId()));
        model.addAttribute("flightsFromTo",
                flightRepository.findAllByPlaceFromIdAndPlaceToId(
                        placeFrom.getPlaceId(),
                        placeTo.getPlaceId()));
        model.addAttribute("flightsToFrom",
                flightRepository.findAllByPlaceFromIdAndPlaceToId(
                        placeTo.getPlaceId(),
                        placeFrom.getPlaceId()));
        return "flight-list";
    }

    @RequestMapping(value = "/flight-list", method = RequestMethod.POST)
    public String flightList(Model model,
                             @ModelAttribute FlightSearchForm flightSearchForm) {

        String fromPlace = flightSearchForm.getFromPlace();
        String toPlace = flightSearchForm.getToPlace();

        Place placeFrom = placeRepository.findByPlaceAbbreviation(fromPlace);
        Place placeTo = placeRepository.findByPlaceAbbreviation(toPlace);

        model.addAttribute("title",
                placeFrom.getPlaceAbbreviation() + " - " +
                    placeTo.getPlaceAbbreviation() + " :: " +
                    "Flight list :: AirLine");

        model.addAttribute("places", placeRepository.findAll());
        model.addAttribute("from", placeFrom.getPlaceName());
        model.addAttribute("to", placeTo.getPlaceName());
        model.addAttribute("countFindedFlightsFromTo",
                flightRepository.countAllByPlaceFromIdAndPlaceToId(
                        placeFrom.getPlaceId(),
                        placeTo.getPlaceId()));
        model.addAttribute("countFindedFlightsToFrom",
                flightRepository.countAllByPlaceFromIdAndPlaceToId(
                        placeTo.getPlaceId(),
                        placeFrom.getPlaceId()));
        model.addAttribute("flightsFromTo",
                flightRepository.findAllByPlaceFromIdAndPlaceToId(
                        placeFrom.getPlaceId(),
                        placeTo.getPlaceId()));
        model.addAttribute("flightsToFrom",
                flightRepository.findAllByPlaceFromIdAndPlaceToId(
                        placeTo.getPlaceId(),
                        placeFrom.getPlaceId()));
        return "flight-list";
    }

    @RequestMapping(value = "/flight-list/manage")
    public String manageFlightList(Model model) {
        model.addAttribute("title","Manage :: Flight list :: AirLine");
        model.addAttribute("count", flightRepository.count());
        List<FlightWithFindedBrigade> flightsComplete = toFlightsComplete(flightRepository.findAll(), placeRepository);
        model.addAttribute("flights", flightsComplete);

        return "flight-list-manage";
    }

    @RequestMapping(value = "/flight-list/add")
    public String addFlight(Model model) {
        model.addAttribute("title","Add :: Flight :: AirLine");
        model.addAttribute("places", placeRepository.findAll());
        model.addAttribute("brigades", brigadeRepository.findAllByBrigadeNumberIsNot("Without Brigade"));
        return "flight-list-add";
    }

    @RequestMapping(value = "/flight-list/add", method = RequestMethod.POST)
    public String addFlight(Model model, @ModelAttribute("flight") @Valid FlightDto flightDto,
                            BindingResult result) {
        model.addAttribute("title","Add :: Flight :: AirLine");
        model.addAttribute("places", placeRepository.findAll());
        model.addAttribute("brigades", brigadeRepository.findAllByBrigadeNumberIsNot("Without Brigade"));

        if (result.hasErrors()) {
            model.addAttribute("error", "Oops, error!");
            return "flight-list-add";
        }
        flightService.save(toFlight(flightDto, brigadeRepository));
        model.addAttribute("success", "Flight successfully added!");
        return "flight-list-add";
    }

    @RequestMapping(value = "/flight-list/edit/{flightId}", method = RequestMethod.GET)
    public String editFlight(Model model, @PathVariable("flightId") Integer flightId) {
        model.addAttribute("title","Edit :: Flight :: AirLine");
        FlightWithFindedBrigade flight = toFlightComplete(
                flightRepository.findFlightByFlightId(flightId),
                placeRepository
        );
        model.addAttribute("flight", flight);
        model.addAttribute("places", placeRepository.findAll());
        model.addAttribute("brigades", brigadeRepository.findAllByBrigadeNumberIsNot("Without Brigade"));
        return "flight-list-edit";
    }

    @RequestMapping(value = "/flight-list/edit/{flightId}", method = RequestMethod.POST)
    public String editFlight(Model model, @PathVariable("flightId") Integer flightId,
                             @ModelAttribute("flight") @Valid FlightDto flightDto,
                             BindingResult result) {
        model.addAttribute("title","Edit :: Flight :: AirLine");

        if (result.hasErrors()) {
            model.addAttribute("error", "Oops, error!");
            return "flight-list-add";
        }
        flightService.save(toFlight(flightDto, brigadeRepository));
        model.addAttribute("success", "Flight successfully saved!");

        FlightWithFindedBrigade flight = toFlightComplete(
                flightRepository.findFlightByFlightId(flightId),
                placeRepository
        );
        model.addAttribute("flight", flight);
        model.addAttribute("places", placeRepository.findAll());
        model.addAttribute("brigades", brigadeRepository.findAllByBrigadeNumberIsNot("Without Brigade"));
        return "flight-list-edit";
    }

    @RequestMapping(value = "/flight-list/delete/{flightId}", method = RequestMethod.GET)
    public String deleteFlight(Model model, @PathVariable("flightId") Integer flightId) {
        flightRepository.delete(flightRepository.findFlightByFlightId(flightId));
        return "redirect:/flight-list/manage";
    }

    static List<FlightWithFindedBrigade> toFlightsComplete(List<Flight> flights, PlaceRepository placeRepository) {
        List<FlightWithFindedBrigade> flightsComplete = new ArrayList<>();

        for (Flight flight: flights) {
            FlightWithFindedBrigade flightWithFindedBrigade = new FlightWithFindedBrigade();
            flightWithFindedBrigade.setFlightId(flight.getFlightId());
            flightWithFindedBrigade.setAirplaneName(flight.getAirplaneName());
            flightWithFindedBrigade.setDatetimeFrom(flight.getDatetimeFrom());
            flightWithFindedBrigade.setDatetimeTo(flight.getDatetimeTo());
            flightWithFindedBrigade.setFlightCost(flight.getFlightCost());
            flightWithFindedBrigade.setBrigade(flight.getBrigade());
            flightWithFindedBrigade.setPlaceFrom(placeRepository.findByPlaceId(flight.getPlaceFromId()));
            flightWithFindedBrigade.setPlaceTo(placeRepository.findByPlaceId(flight.getPlaceToId()));
            flightsComplete.add(flightWithFindedBrigade);
        }

        return flightsComplete;
    }

    static FlightWithFindedBrigade toFlightComplete(Flight flight, PlaceRepository placeRepository) {
        FlightWithFindedBrigade flightComplete = new FlightWithFindedBrigade();

        flightComplete.setFlightId(flight.getFlightId());
        flightComplete.setAirplaneName(flight.getAirplaneName());
        flightComplete.setDatetimeFrom(flight.getDatetimeFrom());
        flightComplete.setDatetimeTo(flight.getDatetimeTo());
        flightComplete.setFlightCost(flight.getFlightCost());
        flightComplete.setBrigade(flight.getBrigade());
        flightComplete.setPlaceFrom(placeRepository.findByPlaceId(flight.getPlaceFromId()));
        flightComplete.setPlaceTo(placeRepository.findByPlaceId(flight.getPlaceToId()));

        return flightComplete;
    }

    static Flight toFlight(FlightDto flightDto, BrigadeRepository brigadeRepository){
        Flight flight = new Flight();

        if (flightDto.getFlightId() != null) {
            flight.setFlightId(flightDto.getFlightId());
        }
        flight.setAirplaneName(flightDto.getAirplaneName());
        flight.setDatetimeFrom(Timestamp.valueOf(flightDto.getDatetimeFrom()));
        flight.setDatetimeTo(Timestamp.valueOf(flightDto.getDatetimeTo()));
        flight.setFlightCost(Float.valueOf(flightDto.getFlightCost()));
        flight.setPlaceFromId(Integer.valueOf(flightDto.getPlaceFrom()));
        flight.setPlaceToId(Integer.valueOf(flightDto.getPlaceTo()));
        flight.setBrigade(brigadeRepository.findBrigadeByBrigadeId(Integer.valueOf(flightDto.getBrigadeId())));

        return flight;
    }
}

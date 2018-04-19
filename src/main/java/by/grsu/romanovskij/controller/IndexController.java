package by.grsu.romanovskij.controller;

import by.grsu.romanovskij.model.Flight;
import by.grsu.romanovskij.model.FlightWithFindedBrigade;
import by.grsu.romanovskij.model.Place;
import by.grsu.romanovskij.repository.FlightRepository;
import by.grsu.romanovskij.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/")
public class IndexController {

	@Autowired
	private PlaceRepository placeRepository;
	@Autowired
	private FlightRepository flightRepository;

	@RequestMapping(method = RequestMethod.GET)
	public String start(Model model) {
		List<Place> places = placeRepository.findAll();
		model.addAttribute("title", "AirLine");
		model.addAttribute("places", places);
		model.addAttribute("countFlight", flightRepository.count());
		List<Flight> flights = flightRepository.findAll();
		List<FlightWithFindedBrigade> flightsComplete = FlightController.toFlightsComplete(flightRepository.findAll(), placeRepository);
		model.addAttribute("flights", flightsComplete);
		return "index";
	}
}

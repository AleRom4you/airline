package by.grsu.romanovskij.service;

import by.grsu.romanovskij.DataTransferObject.FlightDto;
import by.grsu.romanovskij.model.Flight;
import by.grsu.romanovskij.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightServiceImpl implements FlightService {
    @Autowired
    FlightRepository flightRepository;

    @Override
    public Flight save(Flight flight) {
        return flightRepository.save(flight);
    }
}

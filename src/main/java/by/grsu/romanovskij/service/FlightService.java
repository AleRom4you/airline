package by.grsu.romanovskij.service;

import by.grsu.romanovskij.DataTransferObject.FlightDto;
import by.grsu.romanovskij.model.Flight;

public interface FlightService {
    Flight save(Flight flight);
}

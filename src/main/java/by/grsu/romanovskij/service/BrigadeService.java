package by.grsu.romanovskij.service;

import by.grsu.romanovskij.DataTransferObject.BrigadeDto;
import by.grsu.romanovskij.model.Brigade;

public interface BrigadeService {
    Brigade save(BrigadeDto brigade);

    Brigade update(BrigadeDto brigade);
}

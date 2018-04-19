package by.grsu.romanovskij.service;

import by.grsu.romanovskij.DataTransferObject.BrigadeDto;
import by.grsu.romanovskij.model.Brigade;
import by.grsu.romanovskij.repository.BrigadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrigadeServiceImpl implements BrigadeService {
    @Autowired
    private BrigadeRepository brigadeRepository;

    public Brigade save(BrigadeDto brigadeDto) {
        Brigade brigade = new Brigade();
        brigade.setBrigadeNumber(brigadeDto.getBrigadeNumber());
        return brigadeRepository.save(brigade);
    }

    public Brigade update(BrigadeDto brigadeDto) {
        Brigade brigade = brigadeRepository.findBrigadeByBrigadeId(brigadeDto.getBrigadeId());
        brigade.setBrigadeNumber(brigadeDto.getBrigadeNumber());
        return brigadeRepository.save(brigade);
    }
}

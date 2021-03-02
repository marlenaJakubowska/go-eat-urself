package com.marspc.goeaturself.service;

import com.marspc.goeaturself.domain.Fast;
import com.marspc.goeaturself.repository.IFastRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FastService {
    
    private final IFastRepository iFastRepository;

    @Autowired
    public FastService(IFastRepository iFastRepository) {
        this.iFastRepository = iFastRepository;
    }

    public List<Fast> getFasts() {
        return iFastRepository.findAll();
    }

    public void addNewFast(Fast fast) {
        iFastRepository.save(fast);
    }

    public void updateFast(Long fastId) {
        checkIfFastExist(fastId);


    }

    private void checkIfFastExist(Long fastId) {
        boolean isFastInDb = iFastRepository.existsById(fastId);
        if (!isFastInDb){
            throw new IllegalStateException("Fast does not exist in database");
        }
    }
}

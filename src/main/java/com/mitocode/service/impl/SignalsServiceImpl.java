package com.mitocode.service.impl;

import com.mitocode.dto.SignalDTO;
import com.mitocode.model.Signal;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.repo.ISignalRepo;
import com.mitocode.service.ISignalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class SignalsServiceImpl extends CRUDImpl<Signal,Integer> implements ISignalService {


    private final ISignalRepo repo;
    @Override
    protected IGenericRepo<Signal, Integer> getRepo() {
        return repo;
    }


}

package com.mitocode.service.impl;

import com.mitocode.model.Signal;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.repo.ISignalrepo;
import com.mitocode.service.ISignalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class SignalsServiceImpl extends CRUDImpl<Signal,Integer> implements ISignalService {


    private final ISignalrepo repo;
    @Override
    protected IGenericRepo<Signal, Integer> getRepo() {
        return repo;
    }
}

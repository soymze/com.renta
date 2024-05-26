package com.renta.renta.utilities.mapping;

import org.modelmapper.ModelMapper;
public interface ModelMapperService {

    ModelMapper forRequest();
    ModelMapper forResponse();
}

package com.renta.renta.business.abstracts;

import com.renta.renta.business.dtos.requests.message.MessageCreateRequest;
import com.renta.renta.business.dtos.requests.user.UserCreateRequest;
import com.renta.renta.utilities.results.Result;

public interface UserService {

    Result createUser(UserCreateRequest userCreateRequest);
}

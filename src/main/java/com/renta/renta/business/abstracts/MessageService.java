package com.renta.renta.business.abstracts;

import com.renta.renta.business.dtos.requests.message.MessageCreateRequest;
import com.renta.renta.utilities.results.Result;

public interface MessageService {

     Result createMessage(MessageCreateRequest messageCreateRequest);
}

package com.renta.renta.business.concretes;

import com.renta.renta.business.abstracts.MessageService;
import com.renta.renta.business.dtos.requests.message.MessageCreateRequest;
import com.renta.renta.dataAccess.MessageRepository;
import com.renta.renta.entities.Message;
import com.renta.renta.utilities.mapping.ModelMapperManager;
import com.renta.renta.utilities.results.Result;
import com.renta.renta.utilities.results.SuccessResult;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MessageManager implements MessageService {

    //@Autowired
    private MessageRepository messageRepository;

    private ModelMapperManager modelMapperManager;

    //@Override
    public Result createMessage(MessageCreateRequest messageCreateRequest) {
        Message message = modelMapperManager.forRequest().map(messageCreateRequest, Message.class);

        messageRepository.save(message);


        return new SuccessResult("successfully created");
    }
}

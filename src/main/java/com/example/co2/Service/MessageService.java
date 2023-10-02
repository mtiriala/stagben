package com.example.co2.Service;

import com.example.co2.Dao.MessageRepository;
import com.example.co2.Entite.Message;
import com.example.co2.Entite.Userco2;
import com.example.co2.Service.ServiceImpl.MessageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MessageService implements MessageServiceImpl {
    @Autowired
    MessageRepository messageRepository;
    @Autowired
    UserService userService;

    public Message addMessage(Message m1){
        Optional<Userco2> userco2=userService.getCurrentUser();
        if (userco2.isPresent()) {
            Message m=new Message();
            m.setUserco2(userco2.get());
           m.setMsg(m1.getMsg());
           messageRepository.save(m1);
            return m1;
        }
        else {
            return null;
        }
    }

    public List<Message> gettAllMessage(){
      return   messageRepository.findAll();
    }

    public List<Message> getMessageByUser(long id){
        return messageRepository.findAllByUserco2Id(id);
    }
}

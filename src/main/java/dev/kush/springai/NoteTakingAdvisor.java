package dev.kush.springai;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.client.advisor.api.AdvisedRequest;
import org.springframework.ai.chat.client.advisor.api.AdvisedResponse;
import org.springframework.ai.chat.client.advisor.api.CallAroundAdvisor;
import org.springframework.ai.chat.client.advisor.api.CallAroundAdvisorChain;
import org.springframework.ai.chat.messages.MessageType;
import org.springframework.ai.model.Content;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NoteTakingAdvisor implements CallAroundAdvisor {

    Logger log = LoggerFactory.getLogger(NoteTakingAdvisor.class);

    @Override
    public AdvisedResponse aroundCall(AdvisedRequest advisedRequest, CallAroundAdvisorChain chain) {
        String message = advisedRequest.userText(); // 1
        if (message.toLowerCase().contains("india")) { // 2
            log.info("Note Taking Advisor: Found keyword 'India' in message: {}", message); //2
        }
        return chain.nextAroundCall(advisedRequest);
    }

    @Override
    public String getName() {
        return "note-taking-advisor";  // 5
    }

    @Override
    public int getOrder() {
        return 0;  // 6
    }
}

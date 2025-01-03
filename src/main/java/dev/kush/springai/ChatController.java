package dev.kush.springai;

import org.apache.commons.lang3.StringUtils;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.SafeGuardAdvisor;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

import static org.springframework.ai.chat.client.advisor.AbstractChatMemoryAdvisor.CHAT_MEMORY_CONVERSATION_ID_KEY;

@RestController
public class ChatController {

    public record ChatRequest(String chatId, String question) {}

    public record ChatResponse(String chatId, String answer) {}

    private final ChatClient chatClient;

    public ChatController(ChatClient.Builder builder, ChatMemory chatMemory, NoteTakingAdvisor noteTakingAdvisor) {
        this.chatClient = builder
                .defaultAdvisors(
                        new SimpleLoggerAdvisor(),
                        new SafeGuardAdvisor(List.of("hate", "abuse", "violence")),
                        new MessageChatMemoryAdvisor(chatMemory),
                        noteTakingAdvisor
                )
                .build();
    }

    @GetMapping("/chat")
    public ChatResponse chat(@RequestBody ChatRequest chatRequest) {
        String chatId = StringUtils.defaultIfBlank(chatRequest.chatId(), UUID.randomUUID().toString());
        String answer = chatClient.prompt()
                .advisors(advisorSpec -> advisorSpec.param(CHAT_MEMORY_CONVERSATION_ID_KEY, chatId))
                .user(chatRequest.question())
                .call()
                .content();
        return new ChatResponse(chatId, answer);
    }
}

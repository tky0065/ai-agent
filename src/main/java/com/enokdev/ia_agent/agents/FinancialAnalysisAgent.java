package com.enokdev.ia_agent.agents;

import com.enokdev.ia_agent.annotations.AiAgent;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.hilla.BrowserCallable;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@AiAgent
@BrowserCallable
@AnonymousAllowed
public class FinancialAnalysisAgent {

    private ChatClient chatClient;

    String systemPrompt= """
            You will be asked to generate financial report about a given company using actual finacial data
            You report should include information about the company  (name, country,domain, founded year)
            You report should include a concise conclusion about the financial analysis
            """;

    private  String[] tools = new String[]{"countryIdentityInfo","financialDataTool","additionalFinancialInfo"};

    public FinancialAnalysisAgent(ChatClient.Builder chatClient) {
        this.chatClient = chatClient
                .defaultSystem(systemPrompt)
                .defaultFunctions(tools)
                .build();
    }

    public String financialAnalysisReport(String companyName){

        return chatClient.prompt()
                .user("Company Name : " + companyName)
                .call()
                .content();
    }
}

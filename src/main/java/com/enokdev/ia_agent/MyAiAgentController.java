package com.enokdev.ia_agent;

import com.enokdev.ia_agent.agents.FinancialAnalysisAgent;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;

@RestController
public class MyAiAgentController {

    private  FinancialAnalysisAgent  financialAnalysisAgent;

    public MyAiAgentController(FinancialAnalysisAgent financialAnalysisAgent) {
        this.financialAnalysisAgent = financialAnalysisAgent;
    }

    @GetMapping(value = "/financialAnalysis" )
    public String askAgent(String company){

        return financialAnalysisAgent.financialAnalysisReport(company);
    }
}

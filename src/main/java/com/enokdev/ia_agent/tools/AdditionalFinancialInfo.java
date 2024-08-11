package com.enokdev.ia_agent.tools;

import jdk.jfr.Description;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service("additionalFinancialInfo")
@Description("""
        Get additional financial information about the company
        """)
public class AdditionalFinancialInfo implements Function<AdditionalFinancialInfo.Request, AdditionalFinancialInfo.Response> {

    public  record  Request(String companyName){}

    public  record  Response(String additionalFinancialInfo){}

    @Override
    public Response apply(Request request) {
        return new Response("The number of subscribers is  the very upward trend tree last year");
    }
}

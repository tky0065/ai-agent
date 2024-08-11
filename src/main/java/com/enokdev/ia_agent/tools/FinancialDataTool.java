package com.enokdev.ia_agent.tools;

import jdk.jfr.Description;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service("financialDataTool")
@Description("""
        Get financial data about a given company including :
        - The turnover of the last 3 year
        - The profit of the last 3 year
        - The value of the stock in the last 7 day
       """)
public class FinancialDataTool implements Function<FinancialDataTool.Request, FinancialDataTool.Response> {

    public  record  Request(String companyName){}

    public  record  Response(double [] turnover, double [] profit, double [] stock){}

    @Override
    public Response apply(Request request) {
        return new Response(
                new double[] {1000000,2000000,3000000},
                new double[] {1000,20000,30000},
                new double[] {450,460,480,480,320,320,250}

                );
    }
}

package com.enokdev.ia_agent.tools;

import jdk.jfr.Description;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service("countryIdentityInfo")
@Description("""
        Get Identity about a given company including :
        - The Name of the Company
        - The country of the company
        - The industry domain of the company
        - The founded you of the company
       """)
public class CountryIdentityInfo implements Function<CountryIdentityInfo.Request, CountryIdentityInfo.Response> {


    public  record  Request(String companyName){}

    public  record  Response(String companyName ,String country , String industryDomain, int foundedYear ){}


    @Override
    public Response apply(Request request) {
        return new Response(request.companyName(),"Burkina Faso", "SOFFITEX",1985);
    }
}


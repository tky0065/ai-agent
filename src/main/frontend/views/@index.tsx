import "../styles.css"
import {Button, TextField} from "@vaadin/react-components";
import {useState} from "react";
import {FinancialAnalysisAgent} from "Frontend/generated/endpoints";
import Markdown from "react-markdown";

export default function Index(){

    const [company, setCompany] = useState<string>("")
    const [response, setResponse] = useState<string>("");

    async function askAgent(){
        FinancialAnalysisAgent.financialAnalysisReport(company).then((result)=>{
            setResponse(result)
        });
    }

    return(
        <div className="p-5">
         <TextField onChange={(e)=>setCompany(e.target.value)} value={company}></TextField>
            <Button onClick={askAgent} theme={"primary"}> Ask Agent</Button>

            <div>
                <Markdown>

                    {response}

                </Markdown>
            </div>
        </div>
    )
}
package neo4jrest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class Application {
	
	public static void main(String args[]) {
        RestTemplate restTemplate = new RestTemplate();
        //Sample result = restTemplate.getForObject("http://localhost:7474", Sample.class);
        //System.out.println("management=" + result.getManagement() + ", data=" + result.getData());
        
        CypherQuery cypherQuery = new CypherQuery();
        cypherQuery.setQuery("CREATE (prog:Program { programNumber: {programNumber}  }) RETURN prog");
        
        Params params = new Params();
        params.setProgramNumber("ABCDEF");
        cypherQuery.setParams(params);
        
        ResponseEntity<CypherQueryResult> result = restTemplate.postForEntity("http://localhost:7474/db/data/cypher", cypherQuery, CypherQueryResult.class);
        System.out.println(result);
	}

}

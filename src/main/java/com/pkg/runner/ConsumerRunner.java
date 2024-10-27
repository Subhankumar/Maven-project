package com.pkg.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ConsumerRunner implements CommandLineRunner {

	private Logger log = LoggerFactory.getLogger(ConsumerRunner.class);
	
	@Autowired
	private RestTemplate rt;
	
	@Value("${my.app.provider.ip}")
	private String ProviderIp;
	@Value("${my.app.provider.port}")
	private String ProviderPort;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		String url = new StringBuffer()
				.append("http://")
				.append(ProviderIp)
				.append(":")
				.append(ProviderPort)
				.append("/emply/show")
				.toString();
		
		ResponseEntity<String> rspns = rt.getForEntity(url, String.class);
		
		log.info("Status code {}", rspns.getStatusCode());
		log.info("Status value {}", rspns.getStatusCodeValue());
		
		System.exit(0);

	}

}

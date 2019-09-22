package com.cpe.backend;

import com.cpe.backend.entity.Rider;
import com.cpe.backend.repository.RiderRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BackendApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Bean
	ApplicationRunner init(RiderRepository rider) {
		return args -> {
			Rider test =new Rider();
			test.setName("เต๋าเอง");
			rider.save(test);

			
		};
	}

}

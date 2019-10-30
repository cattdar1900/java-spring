package com.cpe.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

import com.cpe.backend.entity.*;
import com.cpe.backend.repository.*;



@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Bean
	ApplicationRunner init(
			RiderRepository riderRepository,
			RestaurantRepository restaurantRepository,
			OptionRepository optionRepository,
			ServiceRepository serviceRepository
	) {
		return args -> {
			Stream.of("ลองดูเดะ", "กะเพราปั๊มหลังมอ", "ชาขุนพล").forEach(name -> {
				Restaurant res = new Restaurant(); // สร้าง Object Customer
				res.setName(name); // set ชื่อ (name) ให้ Object ชื่อ Customer
				restaurantRepository.save(res); // บันทึก Objcet ชื่อ Customer
			});

			Stream.of("ไข่ดาว", "ไข่เจียว").forEach(name -> {
				Option option = new Option(); // สร้าง Object Customer
				option.setName(name); // set ชื่อ (name) ให้ Object ชื่อ Customer
				optionRepository.save(option); // บันทึก Objcet ชื่อ Customer
			});

			Stream.of("ใจดี ใจกว้าง").forEach(name -> {
				Service service = new Service();
				service.setName(name);
				serviceRepository.save(service); // บันทึก Objcet ชื่อ Customer
			});



		};
	}

}

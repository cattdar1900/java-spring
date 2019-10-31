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
			ServiceRepository serviceRepository,
			MainCourseRepository mainCourseRepository,
			TypeFoodRepository typeFoodRepository,
			TypeMenuRepository typeMenuRepository,
			RawMaterialRepository rawMaterialRepository,
			MenuRepository	menuRepository,
			OrderRepository orderRepository,
			OnOptionRepository	onOptionRepository
	) {
		return args -> {
			Stream.of("นางสาวใจดี ใจกว้าง", "นายขวัญเอย ขวัญมา").forEach(name -> {
				Service service = new Service();
				service.setName(name);
				serviceRepository.save(service); // บันทึก Objcet ชื่อ Customer
			});

			Stream.of("นายโจ๊ก ปลาแดก", "นายฟลุ๊คฟลุ๊ค บาท").forEach(name -> {
				Rider rider = new Rider();
				rider.setName(name);
				riderRepository.save(rider); // บันทึก Objcet ชื่อ Customer
			});

			Stream.of("ร้านอาหารจานเเดียว", "ร้านเครื่องดื่ม").forEach(name -> {
				TypeFood typeFood = new TypeFood();
				typeFood.setName(name);
				typeFoodRepository.save(typeFood); // บันทึก Objcet ชื่อ Customer
			});

			Stream.of("ลองดูเดะ", "กะเพราปั๊มหลังมอ", "ชาขุนพล").forEach(name -> {
				Restaurant res = new Restaurant(); // สร้าง Object Customer
				res.setName(name); // set ชื่อ (name) ให้ Object ชื่อ Customer
				restaurantRepository.save(res); // บันทึก Objcet ชื่อ Customer
			});

			Stream.of("ข้าว", "ปั่น", "เย็น").forEach(name -> {
				MainCourse mainCourse = new MainCourse();
				mainCourse.setName(name);
				mainCourseRepository.save(mainCourse); // บันทึก Objcet ชื่อ Customer
			});

			Stream.of("ต้ม", "ผัด").forEach(name -> {
				TypeMenu typeMenu = new TypeMenu();
				typeMenu.setName(name);
				typeMenuRepository.save(typeMenu); // บันทึก Objcet ชื่อ Customer
			});

			Stream.of("หมู", "ไก่", "หมึก", "ปลา").forEach(name -> {
				RawMaterial rawMaterial = new RawMaterial();
				rawMaterial.setName(name);
				rawMaterialRepository.save(rawMaterial); // บันทึก Objcet ชื่อ Customer
			});

			Stream.of("ไข่ดาว", "ไข่เจียว").forEach(name -> {
				Option option = new Option(); // สร้าง Object Customer
				option.setName(name); // set ชื่อ (name) ให้ Object ชื่อ Customer
				optionRepository.save(option); // บันทึก Objcet ชื่อ Customer
			});

			Stream.of("ไข่ดาว", "ไข่เจียว").forEach(name -> {
				Menu menu = new Menu(); // สร้าง Object Customer
				menu.setName(name); // set ชื่อ (name) ให้ Object ชื่อ Customer
				menuRepository.save(menu); // บันทึก Objcet ชื่อ Customer
			});

			Stream.of("ลูกค้า1").forEach(name -> {
				Order order = new Order(); // สร้าง Object Customer
				order.setCusName(name); // set ชื่อ (name) ให้ Object ชื่อ Customer
				orderRepository.save(order); // บันทึก Objcet ชื่อ Customer
			});


//			OnOption onOption = new OnOption(); // สร้าง Object Customer
//			onOption.setAmoutMenu(30); // set ชื่อ (name) ให้ Object ชื่อ Customer
//			onOption.setAmoutOption(5);
//			onOption.setTotalPirceMenu(30);
//			onOption.setTotalPirceOp(5);
//			onOption.setMenu();
//			orderRepository.save(order); // บันทึก Objcet ชื่อ Customer
		};
	}

}

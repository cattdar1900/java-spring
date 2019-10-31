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
			OnMainCourseRepository onMainCourseRepository,
			OnOptionRepository	onOptionRepository
	) {
		return args -> {
//			Service
			Stream.of("นางสาวใจดี ใจกว้าง", "นายขวัญเอย ขวัญมา").forEach(name -> {
				Service service = new Service();
				service.setName(name);
				serviceRepository.save(service);
			});
//			Rider
			Stream.of("นายโจ๊ก ปลาแดก", "นายฟลุ๊คฟลุ๊ค บาท").forEach(name -> {
				Rider rider = new Rider();
				rider.setName(name);
				riderRepository.save(rider);
			});
//			TypeFood
			Stream.of("ร้านอาหารจานเเดียว", "ร้านเครื่องดื่ม").forEach(name -> {
				TypeFood typeFood = new TypeFood();
				typeFood.setName(name);
				typeFoodRepository.save(typeFood);
			});
//			Restaurant
			Stream.of("ลองดูเดะ", "ชาขุนพล").forEach(name -> {
				Restaurant res = new Restaurant();
				res.setName(name);
				restaurantRepository.save(res);
			});
//			MainCourse
			Stream.of("ข้าว", "ชาเขียว").forEach(name -> {
				MainCourse mainCourse = new MainCourse();
				mainCourse.setName(name);
				mainCourseRepository.save(mainCourse);
			});
//			TypeMenu
			Stream.of("ต้ม", "ผัด", "ปั่น", "เย็น").forEach(name -> {
				TypeMenu typeMenu = new TypeMenu();
				typeMenu.setName(name);
				typeMenuRepository.save(typeMenu);
			});
//			RawMaterial
			Stream.of("หมู", "ไก่", "หมึก", "ปลา").forEach(name -> {
				RawMaterial rawMaterial = new RawMaterial();
				rawMaterial.setName(name);
				rawMaterialRepository.save(rawMaterial);
			});
//			Option
			Stream.of("ไข่ดาว", "ไข่เจียว","ไข่มุก").forEach(name -> {
				Option option = new Option();
				option.setName(name);
				optionRepository.save(option);
			});

//			Menu
			Menu menu1 = new Menu();
			menu1.setName("1");
			menu1.setRestaurant(null);
			menu1.setMaincourse(null);
			menu1.setTypemenu(null);
			menuRepository.save(menu1);

			Menu menu2 = new Menu();
			menu2.setName("2");
			menu2.setRestaurant(null);
			menu2.setMaincourse(null);
			menu2.setTypemenu(null);
			menuRepository.save(menu2);

			Menu menu3 = new Menu();
			menu3.setName("3");
			menu3.setRestaurant(null);
			menu3.setMaincourse(null);
			menu3.setTypemenu(null);
			menuRepository.save(menu3);

//			Order
			Order order1 = new Order();
			order1.setCusName("ลูกค้า1");
			order1.setStatus("รอดำเนินการ");
			order1.setService(null);
			orderRepository.save(order1);

			Order order2 = new Order();
			order2.setCusName("ลูกค้า2");
			order2.setStatus("กำลังดำเนินการ");
			order2.setService(null);
			orderRepository.save(order2);

			Order order3 = new Order();
			order3.setCusName("ลูกค้า3");
			order3.setStatus("ดำเนินการเสร็จสิ้น");
			order3.setService(null);
			orderRepository.save(order3);


//			OnMainCourse
			OnMainCourse onMainCourse1 = new OnMainCourse();
			onMainCourse1.setName("1");
			onMainCourse1.setMaincourse(null);
			onMainCourse1.setOption(null);
			onMainCourseRepository.save(onMainCourse1);

			OnMainCourse onMainCourse2 = new OnMainCourse();
			onMainCourse2.setName("1");
			onMainCourse2.setMaincourse(null);
			onMainCourse2.setOption(null);
			onMainCourseRepository.save(onMainCourse2);


			OnMainCourse onMainCourse3 = new OnMainCourse();
			onMainCourse3.setName("1");
			onMainCourse3.setMaincourse(null);
			onMainCourse3.setOption(null);
			onMainCourseRepository.save(onMainCourse3);

			OnMainCourse onMainCourse4 = new OnMainCourse();
			onMainCourse4.setName("1");
			onMainCourse4.setMaincourse(null);
			onMainCourse4.setOption(null);
			onMainCourseRepository.save(onMainCourse4);


			OnMainCourse onMainCourse5 = new OnMainCourse();
			onMainCourse5.setName("1");
			onMainCourse5.setMaincourse(null);
			onMainCourse5.setOption(null);
			onMainCourseRepository.save(onMainCourse5);



		};
	}

}

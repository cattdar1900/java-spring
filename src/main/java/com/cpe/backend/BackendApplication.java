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
//		Service
			Service service1 = new Service();
			service1.setName("นางสาวใจดี ใจกว้าง");
			serviceRepository.save(service1);

			Service service2 = new Service();
			service2.setName("นายขวัญเอย ขวัญมา");
			serviceRepository.save(service2);

//		Rider
			Rider rider1 = new Rider();
			rider1.setName("นายโจ๊ก ปลาแดก");
			riderRepository.save(rider1);

			Rider rider2 = new Rider();
			rider2.setName("นายฟลุ๊คฟลุ๊ค บาท");
			riderRepository.save(rider2);

//		TypeFood
			TypeFood typeFood1 = new TypeFood();
			typeFood1.setName("ร้านอาหารจานเเดียว");
			typeFoodRepository.save(typeFood1);

			TypeFood typeFood2 = new TypeFood();
			typeFood2.setName("ร้านเครื่องดื่ม");
			typeFoodRepository.save(typeFood2);

//		Restaurant
			Restaurant res1 = new Restaurant();
			res1.setName("ลองดูเดะ");
			restaurantRepository.save(res1);

			Restaurant res2 = new Restaurant();
			res2.setName("ชาขุนพล");
			restaurantRepository.save(res2);

//		MainCourse
			MainCourse mainCourse1 = new MainCourse();
			mainCourse1.setName("ข้าว");
			mainCourseRepository.save(mainCourse1);

			MainCourse mainCourse2 = new MainCourse();
			mainCourse2.setName("ชาเขียว");
			mainCourseRepository.save(mainCourse2);

//		TypeMenu
			TypeMenu typeMenu1 = new TypeMenu();
			typeMenu1.setName("ผัด");
			typeMenu1.setTypefood(typeFood1);
			typeMenuRepository.save(typeMenu1);

			TypeMenu typeMenu2 = new TypeMenu();
			typeMenu2.setName("ปั่น");
			typeMenu2.setTypefood(typeFood2);
			typeMenuRepository.save(typeMenu2);

			TypeMenu typeMenu3 = new TypeMenu();
			typeMenu3.setName("เย็น");
			typeMenu3.setTypefood(typeFood2);
			typeMenuRepository.save(typeMenu3);

			TypeMenu typeMenu4 = new TypeMenu();
			typeMenu4.setName("เย็น");
			typeMenu4.setTypefood(typeFood2);
			typeMenuRepository.save(typeMenu4);

//		RawMaterial
			Stream.of("หมู", "ไก่", "หมึก", "ปลา").forEach(name -> {
				RawMaterial rawMaterial = new RawMaterial();
				rawMaterial.setName(name);
				rawMaterialRepository.save(rawMaterial);
			});
//		Option
			Option option1 = new Option();
			option1.setName("ไข่ดาว");
			option1.setPrice(5);
			option1.setRestaurant(res1);
			option1.setTypefood(typeFood1);
			optionRepository.save(option1);

			Option option2 = new Option();
			option2.setName("ไข่เจียว");
			option2.setPrice(10);
			option2.setRestaurant(res1);
			option2.setTypefood(typeFood1);
			optionRepository.save(option2);

			Option option3 = new Option();
			option3.setName("ไข่มุก");
			option3.setPrice(0);
			option3.setRestaurant(res2);
			option3.setTypefood(typeFood2);
			optionRepository.save(option3);


//			Menu
			Menu menu1 = new Menu();
			menu1.setName("1");
			menu1.setRestaurant(res1);
			menu1.setMaincourse(mainCourse1);
			menu1.setTypemenu(typeMenu1);
			menuRepository.save(menu1);

			Menu menu2 = new Menu();
			menu2.setName("2");
			menu2.setRestaurant(res2);
			menu2.setMaincourse(mainCourse2);
			menu2.setTypemenu(typeMenu2);
			menuRepository.save(menu2);

			Menu menu3 = new Menu();
			menu3.setName("3");
			menu3.setRestaurant(res2);
			menu3.setMaincourse(mainCourse2);
			menu3.setTypemenu(typeMenu3);
			menuRepository.save(menu3);

//			Order
			Order order1 = new Order();
			order1.setCusName("ลูกค้า1");
			order1.setStatus("รอดำเนินการ");
			order1.setService(service1);
			order1.setRider(null);
			orderRepository.save(order1);

			Order order2 = new Order();
			order2.setCusName("ลูกค้า2");
			order2.setStatus("รอดำเนินการ");
			order2.setService(service2);
			order2.setRider(null);
			orderRepository.save(order2);

			Order order3 = new Order();
			order3.setCusName("ลูกค้า3");
			order3.setStatus("กำลังดำเนินการ");
			order3.setService(service1);
			order3.setRider(rider1);
			orderRepository.save(order3);

			Order order4 = new Order();
			order4.setCusName("ลูกค้า4");
			order4.setStatus("กำลังดำเนินการ");
			order4.setService(service2);
			order4.setRider(rider2);
			orderRepository.save(order4);

			Order order5 = new Order();
			order5.setCusName("ลูกค้า5");
			order5.setStatus("ดำเนินการเสร็จสิ้น");
			order5.setService(service1);
			order5.setRider(rider1);
			orderRepository.save(order5);

			Order order6 = new Order();
			order6.setCusName("ลูกค้า6");
			order6.setStatus("ดำเนินการเสร็จสิ้น");
			order6.setService(service2);
			order6.setRider(rider2);
			orderRepository.save(order6);
//		onOption
//			OnOption onOption1 = new OnOption();
//			onOption1.setMenu(menu1);
//			onOption1.setAmountMenu(1);
//			onOption1.setAmountOption(1);
//			onOption1.setOption();
//			onOption1.setOrder();
//			onOption1.setTotalPrice(35);
//			onOption1.setTotalPriceMenu(30);
//			onOption1.setTotalPriceOp(5);

//		OnMainCourse
			OnMainCourse onMainCourse1 = new OnMainCourse();
			onMainCourse1.setName("1");
			onMainCourse1.setMaincourse(null);
			onMainCourse1.setOption(null);
			onMainCourseRepository.save(onMainCourse1);

			OnMainCourse onMainCourse2 = new OnMainCourse();
			onMainCourse2.setName("2");
			onMainCourse2.setMaincourse(null);
			onMainCourse2.setOption(null);
			onMainCourseRepository.save(onMainCourse2);


			OnMainCourse onMainCourse3 = new OnMainCourse();
			onMainCourse3.setName("3");
			onMainCourse3.setMaincourse(null);
			onMainCourse3.setOption(null);
			onMainCourseRepository.save(onMainCourse3);

			OnMainCourse onMainCourse4 = new OnMainCourse();
			onMainCourse4.setName("4");
			onMainCourse4.setMaincourse(null);
			onMainCourse4.setOption(null);
			onMainCourseRepository.save(onMainCourse4);


			OnMainCourse onMainCourse5 = new OnMainCourse();
			onMainCourse5.setName("5");
			onMainCourse5.setMaincourse(null);
			onMainCourse5.setOption(null);
			onMainCourseRepository.save(onMainCourse5);



		};
	}

}

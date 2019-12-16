package com.cpe.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;

import java.text.SimpleDateFormat;
import java.util.Date;
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
			OnOptionRepository	onOptionRepository,
			OnMainCourseRepository onMainCourseRepository,
			OnMainTypeRepository onMainTypeRepository,
			OnMatTypeRepository onMatTypeRepository,
			OnMatResRepository onMatResRepository,
			OnMenuRepository onMenuRepository,
			OnResMainRepository onResMainRepository,
			OnTypeFoodRepository onTypeFoodRepository
	) {
		return args -> {
//		Service
			Service service1 = new Service();
			service1.setId("asdasd");
			service1.setName("นางสาวใจดี ใจกว้าง");
			serviceRepository.save(service1);

			Service service2 = new Service();
			service2.setId("asdsdasasd");
			service2.setName("นายขวัญเอย ขวัญมา");
			serviceRepository.save(service2);

//		Rider
			Rider rider1 = new Rider();
			rider1.setId("AAA");
			rider1.setName("นายโจ๊ก ปลาแดก");
			rider1.setPassword("1234");
			riderRepository.save(rider1);

			Rider rider2 = new Rider();
			rider2.setId("BBB");
			rider2.setName("นายฟลุ๊คฟลุ๊ค บาท");
			rider2.setPassword("4321");
			riderRepository.save(rider2);

//		TypeFood
			TypeFood typeFood1 = new TypeFood();
			typeFood1.setNameTF("ร้านอาหารจานเเดียว");
			typeFoodRepository.save(typeFood1);

			TypeFood typeFood2 = new TypeFood();
			typeFood2.setNameTF("ร้านเครื่องดื่ม");
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
			typeMenu1.setNameT("ผัด");
			typeMenu1.setTypefood(typeFood1);
			typeMenuRepository.save(typeMenu1);

			TypeMenu typeMenu2 = new TypeMenu();
			typeMenu2.setNameT("ปั่น");
			typeMenu2.setTypefood(typeFood2);
			typeMenuRepository.save(typeMenu2);

			TypeMenu typeMenu3 = new TypeMenu();
			typeMenu3.setNameT("เย็น");
			typeMenu3.setTypefood(typeFood2);
			typeMenuRepository.save(typeMenu3);

			TypeMenu typeMenu4 = new TypeMenu();
			typeMenu4.setNameT("ร้อน");
			typeMenu4.setTypefood(typeFood2);
			typeMenuRepository.save(typeMenu4);

//		RawMaterial
			RawMaterial rawMaterial1 = new RawMaterial();
			rawMaterial1.setName("หมู");
			rawMaterialRepository.save(rawMaterial1);

			RawMaterial rawMaterial2 = new RawMaterial();
			rawMaterial2.setName("ไก่");
			rawMaterialRepository.save(rawMaterial2);

			RawMaterial rawMaterial3 = new RawMaterial();
			rawMaterial3.setName("หมึก");
			rawMaterialRepository.save(rawMaterial3);

			RawMaterial rawMaterial4 = new RawMaterial();
			rawMaterial4.setName("ปลา");
			rawMaterialRepository.save(rawMaterial4);

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
			option3.setPrice(5);
			option3.setRestaurant(res2);
			option3.setTypefood(typeFood2);
			optionRepository.save(option3);

			Option option4 = new Option();
			option4.setName("ปีโป้");
			option4.setPrice(5);
			option4.setRestaurant(res2);
			option4.setTypefood(typeFood2);
			optionRepository.save(option4);


//			Menu


			Menu menu2 = new Menu();
			menu2.setName("2");
			menu2.setPrice(30);
			menu2.setEx(true);
			menu2.setPriceEx(5);
			menu2.setRestaurant(res1);
			menu2.setMaincourse(mainCourse1);
			menu2.setTypemenu(typeMenu1);
			menuRepository.save(menu2);

			Menu menu3 = new Menu();
			menu3.setName("2");
			menu3.setPrice(40);
			menu3.setEx(false);
			menu3.setPriceEx(0);
			menu3.setRestaurant(res2);
			menu3.setMaincourse(mainCourse2);
			menu3.setTypemenu(typeMenu2);
			menuRepository.save(menu3);

			Menu menu4 = new Menu();
			menu4.setName("3");
			menu4.setPrice(40);
			menu4.setEx(true);
			menu4.setPriceEx(5);
			menu4.setRestaurant(res2);
			menu4.setMaincourse(mainCourse2);
			menu4.setTypemenu(typeMenu3);
			menuRepository.save(menu4);

//			Order
			//extra
			Order order1 = new Order();
			order1.setCusName("ลูกค้า1-extra");
			order1.setStatus("รอดำเนินการ");
			order1.setService(service1);
			order1.setTotalTransDistance(1.0);
			order1.setDeliveredOptionPrice(5);
			order1.setDeliveredPrice(30);
			order1.setTotalDeliveredPrice(35);
			order1.setTotalPriceFood(80);
			order1.setNetPrice(115);
			order1.setDeliveredDate(null);
			order1.setReceivedDate(null);
			order1.setRider(null);
			orderRepository.save(order1);

			Order order2 = new Order();
			order2.setCusName("ลูกค้า2");
			order2.setStatus("xxx");
			order2.setService(service2);
			order2.setRider(null);
			orderRepository.save(order2);
			//extra
			Order order3 = new Order();
			order3.setCusName("ลูกค้า3-extra");
			order3.setStatus("รอดำเนินการ");
			order3.setService(service1);
			order3.setTotalTransDistance(1.0);
			order3.setDeliveredOptionPrice(5);
			order3.setDeliveredPrice(30);
			order3.setTotalDeliveredPrice(35);
			order3.setTotalPriceFood(80);
			order3.setNetPrice(115);
			order3.setDeliveredDate(null);
			order3.setReceivedDate(null);
			order3.setRider(null);
			orderRepository.save(order3);

			Order order4 = new Order();
			order4.setCusName("ลูกค้า4");
			order4.setStatus("xxx");
			order4.setService(service2);
			order4.setRider(null);
			orderRepository.save(order4);
			//extra
			Order order5 = new Order();
			order5.setCusName("ลูกค้า5-extra");
			order5.setStatus("รอดำเนินการ");
			order5.setService(service1);
			order5.setTotalTransDistance(1.0);
			order5.setDeliveredOptionPrice(5);
			order5.setDeliveredPrice(30);
			order5.setTotalDeliveredPrice(35);
			order5.setTotalPriceFood(80);
			order5.setNetPrice(115);
			order5.setDeliveredDate(null);
			order5.setReceivedDate(null);
			order5.setRider(null);
			orderRepository.save(order5);

			Order order6 = new Order();
			order6.setCusName("ลูกค้า6");
			order6.setStatus("xxx");
			order6.setService(service2);
			order6.setRider(null);
			orderRepository.save(order6);

//		onOption
			//order1
			OnOption onOption1 = new OnOption();
			onOption1.setOrder(order1);
			onOption1.setMenu(menu2);
			onOption1.setOption(option2);
			onOption1.setAmountMenu(1);
			onOption1.setAmountOption(1);
			onOption1.setTotalPrice(45);
			onOption1.setTotalPriceMenu(40);
			onOption1.setTotalPriceOp(5);
			onOptionRepository.save(onOption1);

			OnOption onOption2 = new OnOption();
			onOption2.setOrder(order1);
			onOption2.setMenu(menu3);
			onOption2.setOption(option3);
			onOption2.setAmountMenu(1);
			onOption2.setAmountOption(1);
			onOption2.setTotalPrice(45);
			onOption2.setTotalPriceMenu(40);
			onOption2.setTotalPriceOp(5);
			onOptionRepository.save(onOption2);
			//order3
			OnOption onOption3 = new OnOption();
			onOption3.setOrder(order3);
			onOption3.setMenu(menu2);
			onOption3.setOption(option2);
			onOption3.setAmountMenu(1);
			onOption3.setAmountOption(1);
			onOption3.setTotalPrice(45);
			onOption3.setTotalPriceMenu(40);
			onOption3.setTotalPriceOp(5);
			onOptionRepository.save(onOption3);

			OnOption onOption4 = new OnOption();
			onOption4.setOrder(order3);
			onOption4.setMenu(menu3);
			onOption4.setOption(option3);
			onOption4.setAmountMenu(1);
			onOption4.setAmountOption(1);
			onOption4.setTotalPrice(45);
			onOption4.setTotalPriceMenu(40);
			onOption4.setTotalPriceOp(5);
			onOptionRepository.save(onOption4);
			//order5
			OnOption onOption5 = new OnOption();
			onOption5.setOrder(order5);
			onOption5.setMenu(menu2);
			onOption5.setOption(option2);
			onOption5.setAmountMenu(1);
			onOption5.setAmountOption(1);
			onOption5.setTotalPrice(45);
			onOption5.setTotalPriceMenu(40);
			onOption5.setTotalPriceOp(5);
			onOptionRepository.save(onOption5);

			OnOption onOption6 = new OnOption();
			onOption6.setOrder(order5);
			onOption6.setMenu(menu3);
			onOption6.setOption(option3);
			onOption6.setAmountMenu(1);
			onOption6.setAmountOption(1);
			onOption6.setTotalPrice(45);
			onOption6.setTotalPriceMenu(40);
			onOption6.setTotalPriceOp(5);
			onOptionRepository.save(onOption6);

			OnOption onOption7 = new OnOption();
			onOption7.setOrder(order5);
			onOption7.setMenu(menu3);
			onOption7.setOption(option3);
			onOption7.setAmountMenu(1);
			onOption7.setAmountOption(1);
			onOption7.setTotalPrice(45);
			onOption7.setTotalPriceMenu(40);
			onOption7.setTotalPriceOp(5);
			onOptionRepository.save(onOption7);

			OnOption onOption8 = new OnOption();
			onOption8.setOrder(order5);
			onOption8.setMenu(menu3);
			onOption8.setOption(option3);
			onOption8.setAmountMenu(1);
			onOption8.setAmountOption(1);
			onOption8.setTotalPrice(45);
			onOption8.setTotalPriceMenu(40);
			onOption8.setTotalPriceOp(5);
			onOptionRepository.save(onOption8);

//		OnMainCourse
			OnMainCourse onMainCourse1 = new OnMainCourse();
			onMainCourse1.setNameM("1");
			onMainCourse1.setMaincourse(mainCourse1);
			onMainCourse1.setOption(option1);
			onMainCourseRepository.save(onMainCourse1);

			OnMainCourse onMainCourse2 = new OnMainCourse();
			onMainCourse2.setNameM("2");
			onMainCourse2.setMaincourse(mainCourse1);
			onMainCourse2.setOption(option2);
			onMainCourseRepository.save(onMainCourse2);


			OnMainCourse onMainCourse3 = new OnMainCourse();
			onMainCourse3.setNameM("3");
			onMainCourse3.setMaincourse(mainCourse2);
			onMainCourse3.setOption(option3);
			onMainCourseRepository.save(onMainCourse3);

			OnMainCourse onMainCourse4 = new OnMainCourse();
			onMainCourse4.setNameM("4");
			onMainCourse4.setMaincourse(mainCourse2);
			onMainCourse4.setOption(option4);
			onMainCourseRepository.save(onMainCourse4);
//==================================================================
//		OnMainType
			OnMainType onMainType1 = new OnMainType();
			onMainType1.setNameMT("1");
			onMainType1.setMaincourse(mainCourse1);
			onMainType1.setTypefood(typeFood1);
			onMainTypeRepository.save(onMainType1);

			OnMainType onMainType2 = new OnMainType();
			onMainType2.setNameMT("2");
			onMainType2.setMaincourse(mainCourse2);
			onMainType2.setTypefood(typeFood2);
			onMainTypeRepository.save(onMainType2);

//		OnMatType
			OnMatType onMatType1 = new OnMatType();
			onMatType1.setRawMaterial(rawMaterial1);
			onMatType1.setTypeFood(typeFood1);
			onMatTypeRepository.save(onMatType1);

			OnMatType onMatType2 = new OnMatType();
			onMatType2.setRawMaterial(rawMaterial2);
			onMatType2.setTypeFood(typeFood1);
			onMatTypeRepository.save(onMatType2);

			OnMatType onMatType3 = new OnMatType();
			onMatType3.setRawMaterial(rawMaterial3);
			onMatType3.setTypeFood(typeFood1);
			onMatTypeRepository.save(onMatType3);

			OnMatType onMatType4 = new OnMatType();
			onMatType4.setRawMaterial(rawMaterial4);
			onMatType4.setTypeFood(typeFood1);
			onMatTypeRepository.save(onMatType4);

//		OnMatRes
			OnMatRes onMatRes1 = new OnMatRes();
			onMatRes1.setRawMaterial(rawMaterial1);
			onMatRes1.setRestaurant(res1);
			onMatResRepository.save(onMatRes1);

			OnMatRes onMatRes2 = new OnMatRes();
			onMatRes2.setRawMaterial(rawMaterial2);
			onMatRes2.setRestaurant(res1);
			onMatResRepository.save(onMatRes2);

			OnMatRes onMatRes3 = new OnMatRes();
			onMatRes3.setRawMaterial(rawMaterial3);
			onMatRes3.setRestaurant(res1);
			onMatResRepository.save(onMatRes3);

			OnMatRes onMatRes4 = new OnMatRes();
			onMatRes4.setRawMaterial(rawMaterial4);
			onMatRes4.setRestaurant(res1);
			onMatResRepository.save(onMatRes4);

//		OnMenu
			OnMenu onMenu5 = new OnMenu();
			onMenu5.setName("5");
			onMenu5.setRawmaterial(rawMaterial1);
			onMenuRepository.save(onMenu5);

			OnMenu onMenu6 = new OnMenu();
			onMenu6.setName("6");
			onMenu6.setRawmaterial(rawMaterial2);
			onMenuRepository.save(onMenu6);

			OnMenu onMenu7 = new OnMenu();
			onMenu7.setName("7");
			onMenu7.setRawmaterial(null);
			onMenuRepository.save(onMenu7);

			OnMenu onMenu8 = new OnMenu();
			onMenu8.setName("8");
			onMenu8.setRawmaterial(null);
			onMenuRepository.save(onMenu8);

//		OnResMain
			OnResMain onResMain1 = new OnResMain();
			onResMain1.setName("1");
			onResMain1.setMainCourse(mainCourse1);
			onResMain1.setRestaurant(res1);
			onResMainRepository.save(onResMain1);

			OnResMain onResMain2 = new OnResMain();
			onResMain2.setName("2");
			onResMain2.setMainCourse(mainCourse2);
			onResMain2.setRestaurant(res2);
			onResMainRepository.save(onResMain2);

//		OnTypeFood
			OnTypeFood onTypeFood1 = new OnTypeFood();
			onTypeFood1.setName("1");
			onTypeFood1.setRestaurant(res1);
			onTypeFood1.setTypemenu(typeMenu1);
			onTypeFoodRepository.save(onTypeFood1);

			OnTypeFood onTypeFood2 = new OnTypeFood();
			onTypeFood2.setName("1");
			onTypeFood2.setRestaurant(res2);
			onTypeFood2.setTypemenu(typeMenu2);
			onTypeFoodRepository.save(onTypeFood2);

		};
	}

}

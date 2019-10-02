package com.sa.team16.Dataloader;

import java.util.stream.Stream;

import com.sa.team16.Entity.*;
import com.sa.team16.Repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class IncomeDataloader implements ApplicationRunner {

	@Autowired
	private ExpentypeRepository expentypeRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private StatusRepository statusRepository;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Stream.of("รายรับ", "รายจ่าย").forEach(expentypes -> {
			Expentype expentype = new Expentype();
			expentype.setTypename(expentypes);
			expentypeRepository.save(expentype);
		});

		Stream.of("อาหาร", "วัสดุ", "เครื่องเสียง", "อปุกรณ์สำนักงาน", "งบประมาณ", "ค่าอื่นๆ").forEach(categorys -> {
			Category category = new Category();
			category.setCategoryname(categorys);
			categoryRepository.save(category);
		});

		Stream.of("เบิกจ่ายแล้ว", "ยังไม่เบิกจ่าย", "เบิกจ่ายมัดจำ", "เบิกงบประมาณโครงการแล้ว").forEach(Statuss -> {
			Status Status = new Status();
			Status.setStatusname(Statuss);
			statusRepository.save(Status);
		});

		expentypeRepository.findAll().forEach(System.out::println);
		categoryRepository.findAll().forEach(System.out::println);
		statusRepository.findAll().forEach(System.out::println);

	};
}

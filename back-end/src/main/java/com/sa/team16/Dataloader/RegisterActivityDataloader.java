package com.sa.team16.Dataloader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

import com.sa.team16.Entity.*;
import com.sa.team16.Repository.*;

@Component
public class RegisterActivityDataloader implements ApplicationRunner {

	@Autowired
	private CongenitalDiseaseRepository congenitalDiseaseRepository;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Stream.of("ไม่มี", "มี").forEach(congenitalDiseases -> {
			CongenitalDisease congenitalDisease = new CongenitalDisease();
			congenitalDisease.setCongenitalDisease(congenitalDiseases);
			congenitalDiseaseRepository.save(congenitalDisease);
		});
		congenitalDiseaseRepository.findAll().forEach(System.out::println);
	};
}
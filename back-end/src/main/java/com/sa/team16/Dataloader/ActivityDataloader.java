package com.sa.team16.Dataloader;

import java.util.stream.Stream;

import com.sa.team16.Entity.*;
import com.sa.team16.Repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ActivityDataloader implements ApplicationRunner {

	@Autowired
	private TermRepository termRepository;
	@Autowired
	private TypeRepository typeRepository;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		Stream.of("1/2562", "2/2562", "3/2562", "1/2563", "2/2563", "3/2563").forEach(Termname -> {
			Term term = new Term();
			term.setTermname(Termname);
			termRepository.save(term);
		});

		Stream.of("ค่ายอาสา/พัฒนาชนบท", "ค่ายอนุรักษ์", "การแข่งขัน/การประกวด", "ค่ายพัฒนาทักษะ").forEach(typename -> {
			Type type = new Type();
			type.setTypename(typename);
			typeRepository.save(type);
		});

		termRepository.findAll().forEach(System.out::println);
		typeRepository.findAll().forEach(System.out::println);

	};
}

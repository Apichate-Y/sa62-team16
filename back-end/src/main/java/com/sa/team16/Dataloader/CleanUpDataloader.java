package com.sa.team16.Dataloader;

import java.util.stream.Stream;

import com.sa.team16.Entity.*;
import com.sa.team16.Repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class CleanUpDataloader implements ApplicationRunner {

	@Autowired
	private DayOfWeekRepository dayOfWeekRepository;
	@Autowired
	private DurationRepository durationRepository;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Stream.of("จันทร์", "อังคาร", "พุธ", "พฤหัสบดี", "ศุกร์").forEach(days -> {
			DayOfWeek day = new DayOfWeek();
			day.setDay(days);
			dayOfWeekRepository.save(day);
		});

		Stream.of("เช้า", "บ่าย", "เย็น").forEach(durationtimes -> {
			Duration durationtime = new Duration();
			durationtime.setDurationtime(durationtimes);
			durationRepository.save(durationtime);
		});

		dayOfWeekRepository.findAll().forEach(System.out::println);
		durationRepository.findAll().forEach(System.out::println);
	};
}

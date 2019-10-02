package com.sa.team16.Dataloader;

import java.util.stream.Stream;

import com.sa.team16.Entity.*;
import com.sa.team16.Repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ClubMemberDataloader implements ApplicationRunner {

	@Autowired
	private PositionClubRepository positionClubRepository;
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Stream.of("ประธาน", "เลขา", "รองประธาน", "เหรัญญิก").forEach(positionclub_name -> {
			PositionClub positionclub = new PositionClub();
			positionclub.setPositionclub_name(positionclub_name);
			positionClubRepository.save(positionclub);
		});

		User User1 = new User();
		User1.setId_student("B6010256");
		User1.setName("Siriluk");
		userRepository.save(User1);

		User User2 = new User();
		User2.setId_student("B6005924");
		User2.setName("jirawan");
		userRepository.save(User2);

		User User3 = new User();
		User3.setId_student("B6005900");
		User3.setName("Kanokporn");
		userRepository.save(User3);

		userRepository.findAll().forEach(System.out::println);
		positionClubRepository.findAll().forEach(System.out::println);

	};
}

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
		Stream.of("ประธาน", "รองประธานคนที่ 1", "รองประธานคนที่ 2", "เลขา", "เหรัญญิก", "กรรมการ", "สมาชิกทั่วไป").forEach(positionclub_name -> {
			PositionClub positionclub = new PositionClub();
			positionclub.setPositionclub_name(positionclub_name);
			positionClubRepository.save(positionclub);
		});

		User User1 = new User();
		User1.setId_student("B5917099");
		User1.setName("Apichate");
		userRepository.save(User1);

		User User2 = new User();
		User2.setId_student("B5917440");
		User2.setName("Nopparat");
		userRepository.save(User2);

		User User3 = new User();
		User3.setId_student("B6001025");
		User3.setName("Wittawat");
		userRepository.save(User3);

		User User4 = new User();
		User4.setId_student("B6005900");
		User4.setName("Kanokporn");
		userRepository.save(User4);

		User User5 = new User();
		User5.setId_student("B6005924");
		User5.setName("Jirawan");
		userRepository.save(User5);

		User User6 = new User();
		User6.setId_student("B6010256");
		User6.setName("Siriluk");
		userRepository.save(User6);

		userRepository.findAll().forEach(System.out::println);
		positionClubRepository.findAll().forEach(System.out::println);

	};
}

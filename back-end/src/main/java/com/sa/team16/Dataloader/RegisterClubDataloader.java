package com.sa.team16.Dataloader;

import java.util.stream.Stream;

import com.sa.team16.Entity.*;
import com.sa.team16.Repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class RegisterClubDataloader implements ApplicationRunner {

	@Autowired
	private ClubTypeRepository clubTypeRepository;
	@Autowired
	private LocationRepository locationRepository;
	@Autowired
	private TeacherRepository teacherRepository;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Stream.of("วิชาการ", "ศิลปะดนตรี", "กีฬา").forEach(types -> {
			ClubType typebd = new ClubType();
			typebd.setClubTypeName(types);
			clubTypeRepository.save(typebd);
		});

		Stream.of("ห้อง A101", "ห้อง A102", "ห้อง A103", "ห้อง A104", "ห้อง A105", "ห้อง B201", "ห้อง B202",
				"ห้อง B203", "ห้อง B204", "ห้อง B205", "ห้อง C301", "ห้อง C302", "ห้อง C303", "ห้อง C304", "ห้อง C305",
				"ห้อง D401", "ห้อง D402", "ห้อง D403", "ห้อง D404", "ห้อง D405", "ห้อง E501", "ห้อง E502", "ห้อง E503",
				"ห้อง E504", "ห้อง E505", "ห้อง F601", "ห้อง F602", "ห้อง F603", "ห้อง F604", "ห้อง F605")
				.forEach(locations -> {
					Location locationbd = new Location();
					locationbd.setLocationName(locations);
					locationRepository.save(locationbd);
				});

		Stream.of("รศ.ร.อ.ดร.กนต์ธร ชำนิประศาสน์", "อ.ดร.สมศักดิ์ ศิวดำรงพงศ์", "รศ.ดร.พรศิริ จงกล",
				"รศ.ดร.กิตติศักดิ์ เกิดประสพ", "รศ.ดร.นิตยา เกิดประสพ", "ผศ.ดร.คะชา ชาญศิลป์", "ผศ.ดร.ชาญวิทย์ แก้วกสิ",
				"อ.ดร.ปริญญ์ ศรเลิศล้ำวาณิช", "อ.ดร.นันทวุฒิ คะอังกุ", "ผศ.ดร.ปรเมศวร์ ห่อแก้ว",
				"ผศ.ดร.พิชโยทัย มหัทธนาภิวัฒน์", "อ.วิชัย ศรีสุรักษ์", "อ.ดร.ศรัญญา กาญจนวัฒนา", "อ.สุภาพร บุญฤทธิ์")
				.forEach(teachers -> {
					Teacher teacherbd = new Teacher();
					teacherbd.setTeacherName(teachers);
					teacherRepository.save(teacherbd);
				});

		clubTypeRepository.findAll().forEach(System.out::println);
		locationRepository.findAll().forEach(System.out::println);
		teacherRepository.findAll().forEach(System.out::println);
	};
}

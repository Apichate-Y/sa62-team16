package com.sa.team16.Dataloader;

import com.sa.team16.Entity.*;
import com.sa.team16.Repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AdminDataloader implements ApplicationRunner {

	@Autowired
	private AdminRepository adminRepository;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		Admin Admin = new Admin();
		Admin.setAdminusername("Admin");
		Admin.setAdminpassword("Admin");
		adminRepository.save(Admin);

		adminRepository.findAll().forEach(System.out::println);

	};
}

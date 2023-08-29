package com.springBoot.BlogApplication.springbootblogApplication.Service.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBoot.BlogApplication.springbootblogApplication.Entity.Address;
import com.springBoot.BlogApplication.springbootblogApplication.Entity.Student;
import com.springBoot.BlogApplication.springbootblogApplication.Repository.StudentRespository;
import com.springBoot.BlogApplication.springbootblogApplication.Service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRespository studentRepo;
	
	@Override
	public String addStudent() {
		
		Student s=new Student();
		s.setName("Suraj");
		s.setAbout("Engineer");
		s.setSid(2);
		
//		Laptop l=new Laptop();
//		l.setLaptopModel("inspiron");
//		l.setLid(1);
//		l.setPrice(45000);
//		l.setStudent(s);
//		s.setLaptop(l);
		
		List<Address> addressList=new ArrayList<>();
		Address ad1=new Address();
		ad1.setAddressId(151);
		ad1.setStreet("E/4");
		ad1.setCity("gorakhpur");
		ad1.setCountry("India");
		ad1.setStudent(s);
		
		Address ad2=new Address();
		ad2.setAddressId(161);
		ad2.setStreet("E/5");
		ad2.setCity("gorakhpur");
		ad2.setCountry("India");
		ad2.setStudent(s);
		
		Address ad3=new Address();
		ad3.setAddressId(171);
		ad3.setStreet("E/5");
		ad3.setCity("gorakhpur");
		ad3.setCountry("India");
		ad3.setStudent(s);
		
		
		
		addressList.add(ad1);
		addressList.add(ad2);
		addressList.add(ad3);
		
		s.setAddress(addressList);
		
		 studentRepo.save(s);
		
		return "Stduent Added Successfully With Address and Laptop data";
	}
	

}

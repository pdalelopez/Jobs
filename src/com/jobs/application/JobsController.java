package com.jobs.application;

import java.util.List;

import com.jobs.domain.*;
import com.jobs.persistence.EmployeeRepository;

public class JobsController {

	private EmployeeRepository repository = new EmployeeRepository();
	
	public JobsController(){
		
	}
	
	public void createBossEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{		
		Employee boss = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateBoss());
		repository.addMember(boss);
	}
	
	public void createEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{		
		Employee employee = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateEmployee());
		repository.addMember(employee);
	}

	public void createManagerEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{
		Employee manager = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateManager());
		repository.addMember(manager);
	}
	
	public void createVolunteer(String name, String address, String phone) throws Exception {
		// TODO Auto-generated method stub
		Volunteer volunteer = new Volunteer(name, address, phone);
		repository.addMember(volunteer);
	}


	public void payAllEmployeers() {
		for (AbsStaffMember member: repository.getAllMembers())
		{
			member.pay();
		}
		
	
	}

	public String getAllEmployees() {
		// TODO Auto-generated method stub
		String allEmployees = repository.getAllMembers().toString();
		
		return allEmployees;
	}

	public EmployeeRepository getRepository()
	{
		return repository;
	}

	
	
	
	
}

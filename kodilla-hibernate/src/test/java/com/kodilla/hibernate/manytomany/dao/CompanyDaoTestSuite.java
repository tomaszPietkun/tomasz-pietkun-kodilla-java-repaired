package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyDaoTestSuite {
    @Autowired
    CompanyDao companyDao;
    @Autowired
    EmployeeDao employeeDao;

    @Test
    public void testSaveManyToMany() {
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");

        softwareMachine.getEmployees().add(johnSmith);
        dataMaesters.getEmployees().add(stephanieClarckson);
        dataMaesters.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaKovalsky);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        stephanieClarckson.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(greyMatter);

        //When
        companyDao.save(softwareMachine);
        int softwareMachineId = softwareMachine.getId();
        companyDao.save(dataMaesters);
        int dataMaestersId = dataMaesters.getId();
        companyDao.save(greyMatter);
        int greyMatterId = greyMatter.getId();

        //Then
        Assert.assertNotEquals(0 ,softwareMachineId);
        Assert.assertNotEquals(0, dataMaestersId);
        Assert.assertNotEquals(0 ,greyMatterId);

        //CleanUp
        try {
            companyDao.deleteById(softwareMachineId);
            companyDao.deleteById(dataMaestersId);
           companyDao.deleteById(greyMatterId);
        } catch (Exception e) {
            //do nothing
        }
    }

    @Test
    public void testRetrieveEmployeeWithLastName() {
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        employeeDao.save(johnSmith);
        int id1 = johnSmith.getId();
        employeeDao.save(stephanieClarckson);
        int id2 = stephanieClarckson.getId();
        employeeDao.save(lindaKovalsky);
        int id3 = lindaKovalsky.getId();

        //When
        List<Employee> employeesLastName = employeeDao.findByLastname("Kovalsky");

        //Then
        try {
            Assert.assertEquals(1, employeesLastName.size());
        }
        finally {
            employeeDao.deleteById(id1);
            employeeDao.deleteById(id2);
            employeeDao.deleteById(id3);
        }
    }

    @Test
    public void retrieveCompanyNameStartingWith() {
        //Given
        Company company1 = new Company("Company1");
        Company company2 = new Company("Company2");
        Company company3 = new Company("Sony");

        companyDao.save(company1);
        int id1 = company1.getId();
        companyDao.save(company2);
        int id2 = company2.getId();
        companyDao.save(company3);
        int id3 = company3.getId();

        //When
        List<Company>companiesStartingWith = companyDao.findByThreeCharsPrefix("Com%");

        //Then
        Assert.assertEquals(2, companiesStartingWith.size());

        //CleanUp
        try {
            companyDao.deleteById(id1);
            companyDao.deleteById(id2);
            companyDao.deleteById(id3);
        } catch (Exception e) {
            //Nothing
        }
    }
}

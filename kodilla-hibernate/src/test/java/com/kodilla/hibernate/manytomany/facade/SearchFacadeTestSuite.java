package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SearchFacadeTestSuite {
    @Autowired
    SearchFacade searchFacade;
    @Autowired
    CompanyDao companyDao;
    @Autowired
    EmployeeDao employeeDao;

    @Test
    public void testFindCompanies() {
        //given
        Company c1 = new Company("Company 1");
        Company c2 = new Company("Company 2");
        Company c3 = new Company("Sonyr");

        //when
        companyDao.save(c1);
        companyDao.save(c2);
        companyDao.save(c3);
        List<Company> companies = searchFacade.findCompanies("Com");

        //then
        Assert.assertEquals(2, companies.size());

        //cleanup
        try {
            companyDao.delete(c1);
            companyDao.delete(c2);
            companyDao.delete(c3);
        } catch (Exception e) {
            //do nothing
        }
    }

    @Test
    public void testFindEmployees() {
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        //when
        employeeDao.save(johnSmith);
        employeeDao.save(stephanieClarckson);
        employeeDao.save(lindaKovalsky);
        List<Employee> employees = searchFacade.findEmployees("Kov");

        //then
        Assert.assertEquals(1, employees.size());

        //cleanup
        try {
            employeeDao.delete(johnSmith);
            employeeDao.delete(stephanieClarckson);
            employeeDao.delete(lindaKovalsky);
        } catch (Exception e) {
            //do nothing
        }
    }
}
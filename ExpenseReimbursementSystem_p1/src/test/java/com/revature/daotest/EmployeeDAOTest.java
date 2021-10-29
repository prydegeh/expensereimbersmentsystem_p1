//package com.revature.daotest;
//
//import java.util.List;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
//
//import com.revature.dao.EmployeeDAO;
//import com.revature.model.Employee;
//
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//class EmployeeDAOTest
//{
//
//    private static EmployeeDAO edao =  new EmployeeDAO();
//    @Test
//    @Order(1)
//    void createEmployee()
//    {
//        Employee e = new Employee(0,
//                "name",
//                "hibernate@gmail.com",
//                "password123",
//                 7);
//
//        Assertions.assertNotEquals(0, e.getId());
//    }
//
//    @Test
//    @Order(2)
//    void getEmployeeById()
//    {
//        Employee employee = edao.findAll();
//        Employee updateMe = employee.get(employee.size());
//        Employee result = edao.findById(updateMe.getId());
//    }
//
//    @Test
//    @Order(3)
//    void getAllEmployees()
//    {
//        List<Employee> result = edao.findAll();
//
//        Assertions.assertNotEquals(0, result.size());
//    }
//
//    @Test
//    @Order(4)
//    void updateEmployee()
//    {
//        List<Employee> slaughter = edao.getAllEmployees();
//        Employee updateMe = slaughter.get(slaughter.size()-1);
//        updateMe.setEmail("MyNewEmail@email.com");
//        Employee result = edao.update();
//
//        Assertions.assertEquals("MyNewEmail@email.com",result.getEmail());
//    }
//
//    @Test
//    @Order(5)
//    void deleteEmployee()
//    {
//        List<Employee> slaughter = edao.getAllEmployees();
//        Employee deleteMe = slaughter.get(slaughter.size()-1);
//
//        boolean result = edao.delete();
//
//        Assertions.assertEquals(true, result);
//
//    }
//}
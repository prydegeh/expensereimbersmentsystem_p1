//package com.revature.daotest;
//
//
//import org.junit.jupiter.api.*;
//
//import com.revature.dao.EmployeeDAO;
//import com.revature.dao.EmployeeDAOImp;
//import com.revature.dao.ExpenseCategoryDAO;
//import com.revature.dao.ExpenseCategoryDAOImp;
//import com.revature.dao.ReimbursementDAO;
//import com.revature.dao.ReimbursementDAOImp;
//import com.revature.model.Reimbursement;
//
//import java.sql.Date;
//import java.util.List;
//
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//class ReimbursementDAOTest
//{
//    private static ReimbursementDAO rdao = ReimbursementDAO();
//    private static EmployeeDAO edao = EmployeeDAOImp.getEdao();
//
//    @Test
//    @Order(1)
//    void createReimbursement()
//    {
//        Reimbursement r;
//        r = new Reimbursement(0,
//                300,
//                "2011-10-9",
//                0,
//                "2000-01-01",
//                "Employee note",
//                "Manager Note",
//                2,
//                10
//                );
//
//        Reimbursement result = rdao.save(r);
//
//        Assertions.assertNotEquals(0, result.getRid());
//
//        System.out.println(result);
//    }
//
//    @Test
//    @Order(2)
//    void getReimbursementById()
//    {
//        List<Reimbursement> reimbursements = rdao.findAll();
//        Reimbursement result = rdao.findById(reimbursements.get(reimbursements.size()-1).getRid());
//        Assertions.assertEquals(300, result.getAmount());
//    }
//
//    @Test
//    @Order(4)
//    void getAllReimbursement()
//    {
//        List<Reimbursement> reimbursements = rdao.findAll();
//        Assertions.assertNotEquals(0, reimbursements.size());
//    }
//
//    @Test
//    @Order(5)
//    void updateReimbursement()
//    {
//        List<Reimbursement> reimbursements = rdao.findAll();
//        Reimbursement updateMe = rdao.findById(reimbursements.get(reimbursements.size()-1).getRid());
//        updateMe.setAmount(400);
//        Reimbursement result = rdao.update(updateMe);
//
//        Assertions.assertEquals(400, result.getAmount());
//    }
//
//    @Test
//    @Order(6)
//    void deleteReimbursement()
//    {
//        List<Reimbursement> reimbursements = rdao.findAll()();
//        Reimbursement deleteMe = rdao.findById(reimbursements.get(reimbursements.size()-1).getRid());
//
//        boolean result = rdao.delete(deleteMe);
//
//        Assertions.assertEquals(true, result);
//
//    }
//}
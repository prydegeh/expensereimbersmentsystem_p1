package com.revature.app;

import java.util.List;

import com.revature.dao.EmployeeDAO;
import com.revature.dao.ReimbursementDAO;
import com.revature.model.Employee;
import com.revature.model.Reimbursement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

public class App {

	public static void main(String[] args) {
		Javalin app = Javalin.create(config -> {
			config.enableCorsForAllOrigins();
			config.addStaticFiles("/public", Location.CLASSPATH);
		}).start(7000);

		Logger logger = LoggerFactory.getLogger(App.class);

		List<Employee> employees = EmployeeDAO.findAll();

		app.get("/employees", ctx -> ctx.jsonStream(employees));

		app.get("/employees/{id}", ctx -> {
			int id = Integer.parseInt(ctx.pathParam("id"));
			Employee emp = EmployeeDAO.findById(id);
			ctx.json(emp);
		});

		app.post("employees", ctx -> {
			Employee emp = ctx.bodyAsClass(Employee.class);
			logger.info("This the student object from postman :" + emp);
			EmployeeDAO.save(emp);
			ctx.status(201);
		});

		app.post("/employeeForm", ctx -> {

			String name = ctx.formParam("name");
			String email = ctx.formParam("email");
			String password = ctx.formParam("password");
			int m_id = Integer.parseInt(ctx.formParam("m_id"));
			Employee emp = new Employee(name, email, password, m_id);
			logger.info("This the student object from postman :" + emp);
			EmployeeDAO.save(emp);
			ctx.status(201);
		});

		app.put("employee/{id}", ctx -> {
			int id = Integer.parseInt(ctx.pathParam("id"));
			Employee emp = ctx.bodyAsClass(Employee.class);
			EmployeeDAO.update(id, emp);
			ctx.status(200);
		});

		app.delete("employee/{id}", ctx -> {
			int id = Integer.parseInt(ctx.pathParam("id"));
			EmployeeDAO.delete(id);
			ctx.status(200);
		});

		List<Reimbursement> reimbs = ReimbursementDAO.findAll();

		app.get("/reimbursement", ctx -> ctx.jsonStream(reimbs));

		app.get("/reimbursement/{id}", ctx -> {
			int id = Integer.parseInt(ctx.pathParam("id"));
			Reimbursement reimbursement = ReimbursementDAO.findById(id);
			ctx.json(reimbursement);
		});
		app.get("addReimbursements", ctx -> ctx.redirect("addReimbursements.html"));

		app.post("addReimbursements", ctx -> {
			Reimbursement reimbursement = ctx.bodyAsClass(Reimbursement.class);
			ReimbursementDAO.save(reimbursement);
			ctx.status(201);
			ctx.redirect("Reimbursements.html");
		});

		app.put("reimbursement/{id}", ctx -> {
			int id = Integer.parseInt(ctx.pathParam("id"));
			Reimbursement reimbursement = ctx.bodyAsClass(Reimbursement.class);
			ReimbursementDAO.update(id, reimbursement);
			ctx.status(200);
		});

		app.delete("reimbursement/{id}", ctx -> {
			int id = Integer.parseInt(ctx.pathParam("id"));
			ReimbursementDAO.delete(id);
			ctx.status(200);
		});

	}

}

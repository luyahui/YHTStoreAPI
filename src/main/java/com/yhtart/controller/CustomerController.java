package com.yhtart.controller;

import com.yhtart.annotation.PassToken;
import com.yhtart.model.Customer;
import com.yhtart.service.CustomerService;
import com.yhtart.service.EmailService;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.sql.Timestamp;

@RestController
@RequestMapping("customers")
public class CustomerController {

    @Autowired
    private EmailService emailService;

    @Autowired
    private CustomerService customerService;

    @PassToken
    @GetMapping("")
    public ResponseEntity getAllCustomers(@RequestParam(name = "pageNo", defaultValue = "0") int pageNo,
                                          @RequestParam(name = "pageSize", defaultValue = "10") int pageSize) {
        Page<Customer> customers = customerService.findAll(pageNo, pageSize);

        return customers.hasContent() ? new ResponseEntity(customers, HttpStatus.OK) : new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PassToken
    @GetMapping("/{id}")
    public ResponseEntity getCustomer(@PathVariable long id) {
        Customer customer = customerService.findByID(id);
        return customer == null ? new ResponseEntity(HttpStatus.NO_CONTENT) : ResponseEntity.ok(customer);
    }

    @GetMapping("/report")
    public ResponseEntity getReport(HttpServletResponse response) {
        XSSFWorkbook wb = customerService.getReport();

        String filename = "用户报表.xlsx";
        OutputStream out = null;
        try {
            filename = URLEncoder.encode(filename, "UTF-8");
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-disposition", "attachment;filename=" + filename);
            out = response.getOutputStream();
            wb.write(out);
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(null);
    }

    @PutMapping("/{id}")
    public ResponseEntity editCustomer(@PathVariable long id, @RequestBody Customer customer) {
        if (!customerService.exists(id))
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        try {
            customer.setId(id);
            customer.setTimestamp(new Timestamp(System.currentTimeMillis()));
            customer = customerService.save(customer);
            if (customer != null)
                return ResponseEntity.ok(customer);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @PassToken
    @PostMapping
    public ResponseEntity askForPrice(@RequestBody Customer customer) {
        if (customer.getName().equals("") || customer.getCellphone().equals("") || customer.getProductUrl().equals(""))
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        try {
            customer.setTimestamp(new Timestamp(System.currentTimeMillis()));
            customer = customerService.save(customer);
            if (emailService.sendMailByCustomer(customer))
                return new ResponseEntity(customer, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCustomer(@PathVariable long id) {
        if (!customerService.exists(id))
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        try {
            customerService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(null);
    }
}

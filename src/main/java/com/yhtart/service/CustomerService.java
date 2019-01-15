package com.yhtart.service;

import com.yhtart.model.Customer;
import com.yhtart.repository.CustomerRepository;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Iterator;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Page<Customer> findAll(int pageNo, int pageSize) {
        Page<Customer> customers = customerRepository.findAll(PageRequest.of(pageNo, pageSize));
        return customers;
    }

    public Customer findByID(long id) {
        return customerRepository.findById(id).orElse(null);
    }

    public boolean exists(long id) {
        return customerRepository.existsById(id);
    }

    @Transactional
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Transactional
    public void delete(long id) {
        customerRepository.deleteById(id);
    }

    public XSSFWorkbook getReport() {
        XSSFWorkbook wb = new XSSFWorkbook();
        Sheet sheet = wb.createSheet("Customer Report");

        // set title
        Row title = sheet.createRow(0);
        title.createCell(0).setCellValue("ID");
        title.createCell(1).setCellValue("代码");
        title.createCell(2).setCellValue("姓名");
        title.createCell(3).setCellValue("性别");
        title.createCell(4).setCellValue("生日");
        title.createCell(5).setCellValue("邮箱");
        title.createCell(6).setCellValue("QQ");
        title.createCell(7).setCellValue("旺旺");
        title.createCell(8).setCellValue("身份证");
        title.createCell(9).setCellValue("店铺级别");
        title.createCell(10).setCellValue("收货人");
        title.createCell(11).setCellValue("手机");
        title.createCell(12).setCellValue("电话");
        title.createCell(13).setCellValue("省市区");
        title.createCell(14).setCellValue("详细地址");
        title.createCell(15).setCellValue("邮编");

        // set data
        int rowNo = 1;
        Iterator<Customer> iterator = customerRepository.findAll().iterator();
        while (iterator.hasNext()){
            Customer customer = iterator.next();
            Row row = sheet.createRow(rowNo);
            row.createCell(0).setCellValue(customer.getId());
            row.createCell(1).setCellValue(customer.getDesignation());
            row.createCell(2).setCellValue(customer.getName());
            row.createCell(3).setCellValue(customer.getGender());
            row.createCell(4).setCellValue(customer.getBirthday());
            row.createCell(5).setCellValue(customer.getEmail());
            row.createCell(6).setCellValue(customer.getQq());
            row.createCell(7).setCellValue(customer.getWangwang());
            row.createCell(8).setCellValue(customer.getIdCard());
            row.createCell(9).setCellValue(customer.getStoreLevel());
            row.createCell(10).setCellValue(customer.getReceiptor());
            row.createCell(11).setCellValue(customer.getCellphone());
            row.createCell(12).setCellValue(customer.getTelephone());
            row.createCell(13).setCellValue(customer.getCity());
            row.createCell(14).setCellValue(customer.getAddress());
            row.createCell(15).setCellValue(customer.getZipCode());
            rowNo++;
        }

        return wb;
    }
}

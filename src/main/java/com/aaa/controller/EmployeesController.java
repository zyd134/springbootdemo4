package com.aaa.controller;

import com.aaa.entity.Employees;
import com.aaa.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("emp")
public class EmployeesController {
    @Autowired
    private EmployeesService employeesService;

    @RequestMapping("login")
    @ResponseBody
    public String login(Employees employees, HttpSession session){
        Employees emp=employeesService.login(employees);
        session.setAttribute("emp",emp);
        if (emp!=null){
            return "true";
        }else {
            return "false";
        }
    }

    @RequestMapping("register")
    @ResponseBody
    public String register(Employees employees) {
        int a = employeesService.register(employees);
        if (a > 0) {
            return "true";
        } else {
            return "false";
        }
    }

    @RequestMapping("selectEmp")
    @ResponseBody
    public List<Map> selectEmp() {
        return employeesService.selectEmp();
    }

    @RequestMapping("updateEmpById")
    @ResponseBody
    public String updateEmpById(Employees employees){
        System.out.println("++++++++++进入updateEmpById");
        System.out.println(employees.getName()+"  "+employees.getSex());
        int a=employeesService.updateEmpById(employees);
        System.out.println("-------------进入updateEmpById"+"***"+a);
        if (a > 0) {
            return "true";
        } else {
            return "false";
        }
    }

    @RequestMapping("selectEmpByRole")
    @ResponseBody
    public List<Map> selectEmpByRole(Integer role) {
        System.out.println("55555"+role);
//        System.out.println("进入selectEmpByRole");
        List<Map> list=employeesService.selectEmpByRole(role);
        for (Map m:list){
            System.out.println("+++"+m);
        }
        return list;
    }


}

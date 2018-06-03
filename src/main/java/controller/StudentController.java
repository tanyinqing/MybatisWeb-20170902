package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import service.StudentService;

@Controller
@RequestMapping("student")
public class StudentController extends BaseController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("queryAll")
    private String queryAll() {
        session.setAttribute("students", studentService.queryAll());
        return "redirect:/students.jsp";
    }


    @RequestMapping("studentCourses/{id}")
    private String studentCourses(@PathVariable int id) {
        session.setAttribute("student", studentService.queryOne("studentCourses", id));
        return "redirect:/student.jsp";
    }
}

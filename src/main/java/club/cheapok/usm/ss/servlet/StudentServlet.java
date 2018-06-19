package club.cheapok.usm.ss.servlet;

import club.cheapok.usm.ss.dao.StudentDao;
import club.cheapok.usm.ss.model.Student;
import org.springframework.context.ApplicationContext;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

@WebServlet("/students")
public class StudentServlet extends HttpServlet {

    private StudentDao studentDao;

    @Override
    public void init(final ServletConfig config) throws ServletException {
        super.init(config);

        final ApplicationContext springContext = (ApplicationContext) config.getServletContext()
                .getAttribute("springContext");
        this.studentDao = springContext.getBean(StudentDao.class);
    }

    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("students", studentDao.findAll());
        req.getRequestDispatcher("/students.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        final long id = new Random().nextLong();
        final String firstName = req.getParameter("firstName");
        final String lastName = req.getParameter("lastName");

        studentDao.save(new Student(id, firstName, lastName));

        this.doGet(req, resp);
    }
}

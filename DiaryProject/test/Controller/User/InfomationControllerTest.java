import Controller.User.InfomationController;
import Model.Account;
import Model.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class InfomationControllerTest {
    private InfomationController infomationController;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession session;
    private User user;
    private Account account;
    private RequestDispatcher requestDispatcher;

    @Before
    public void setUp() {
        infomationController = new InfomationController();
        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();
        session = new MockHttpSession();
        user = new User();
        account = new Account();
        requestDispatcher = new MockRequestDispatcher();

        request.setSession(session);
        session.setAttribute("user", user);
        user.setAccount(account);
        user.setId(1);
        request.setDispatcher(requestDispatcher);
    }

    @Test
    public void testDateConditionWithValidDate() {
        assertTrue(infomationController.datecondition("2000-01-01"));
    }

    @Test
    public void testDateConditionWithInvalidDate() {
        assertFalse(infomationController.datecondition("2010-01-01"));
    }

    @Test
    public void testDoPostWithValidData() throws Exception {
        // Arrange
        request.setParameter("name", "John");
        request.setParameter("gender", "Male");
        request.setParameter("dob", "2000-01-01");

        User updatedUser = new User();
        updatedUser.setId(1);
        updatedUser.setAccount(account);

        User newUser = new User();
        newUser.setUserbyAccount(account, updatedUser);

        user.setUserbyAccount(account, newUser);

        // Act
        infomationController.doPost(request, response);

        // Assert
        assertNotNull(request.getAttribute("mess"));
        assertEquals("You must be older than 16", request.getAttribute("mess"));
        assertNotNull(request.getDispatcher());
        assertEquals("Information.jsp", request.getDispatcher().getPath());
        assertNull(response.getRedirect());
    }

    @Test
    public void testDoPostWithInvalidData() throws Exception {
        // Arrange
        request.setParameter("name", "John");
        request.setParameter("gender", "Male");
        request.setParameter("dob", "2010-01-01");

        // Act
        infomationController.doPost(request, response);

        // Assert
        assertNull(request.getAttribute("mess"));
        assertNull(request.getDispatcher());
        assertNotNull(response.getRedirect());
        assertEquals("home", response.getRedirect());
    }

    @Test
    public void testDoGet() throws Exception {
        // Arrange
        user.setId(1);

        // Act
        infomationController.doGet(request, response);

        // Assert
        assertNotNull(request.getAttribute("data"));
        assertEquals(user, request.getAttribute("data"));
    }
}

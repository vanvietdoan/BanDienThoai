package Controller;

<<<<<<< HEAD
import Model.BEAN.UserBean;
=======
import Model.BEAN.CategoryBean;
import Model.BEAN.UserBean;
import Model.BO.CategoryBO;
>>>>>>> 10598cb (admin)
import Model.BO.UserBO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
<<<<<<< HEAD
=======
import javax.servlet.annotation.MultipartConfig;
>>>>>>> 10598cb (admin)
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@MultipartConfig
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

   	 // Retrieve user_id from the query parameter
       String userIdParam = request.getParameter("user_id");

       // Convert the user_id to an integer (you might want to handle potential exceptions)
       int userId = Integer.parseInt(userIdParam);

       UserBO userBO = new UserBO();

       UserBean user = userBO.getUserById(userId);

       request.setAttribute("user", user);

       RequestDispatcher dispatcher = request.getRequestDispatcher("userProfile.jsp");
       dispatcher.forward(request, response);
       

   }
  
        String action = request.getParameter("action");
        String stdDeleteUser = request.getParameter("stdDeleteUser");
        String stdUpdateUser = request.getParameter("stdUpdateUser");
        String stdResetPassWord = request.getParameter("stdResetPassWord");

        if (stdDeleteUser != null && !stdDeleteUser.isEmpty()) {
            int idUser = Integer.parseInt(request.getParameter("stdDeleteUser"));
            deleteUser(request, response, idUser);
        }
        if (stdUpdateUser != null && !stdUpdateUser.isEmpty()) {
            int stdUpdate = Integer.parseInt(request.getParameter("stdUpdateUser"));
            viewUpdateUser(request, response, stdUpdate);
        }
        if (stdResetPassWord != null && !stdResetPassWord.isEmpty()) {
            int stdResetPass = Integer.parseInt(request.getParameter("stdResetPassWord"));
            resetPassWord(request, response, stdResetPass);
        }
        if ("editUser".equals(action)) {
            viewEditUser(request, response);
        } else if ("InsertUser".equals(action)) {
            insertUser(request, response);
        } else if ("updateUser".equals(action)) {
        	System.out.println("updateUser");
            updateUser(request, response);
        }
    }

    private void viewUpdateUser(HttpServletRequest request, HttpServletResponse response, int stdUpdateParam) throws ServletException, IOException {
       

        UserBO userBO = new UserBO();
        UserBean user = userBO.getUserDetails(stdUpdateParam);

        request.setAttribute("user", user);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/viewUpdateUser.jsp");
        dispatcher.forward(request, response);
    }

    private void viewEditUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     

        UserBO userBO = new UserBO();
        List<UserBean> listUser = userBO.getAllUsers();
        request.setAttribute("listUser", listUser);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/editUser.jsp");
        dispatcher.forward(request, response);
    }

    private void resetPassWord(HttpServletRequest request, HttpServletResponse response, int ID) throws ServletException, IOException {
        

        UserBO userBO = new UserBO();
        userBO.resetPassWord(ID);

        List<UserBean> listUser = userBO.getAllUsers();
        request.setAttribute("listUser", listUser);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/editUser.jsp");
        dispatcher.forward(request, response);
    }
 private void deleteUser(HttpServletRequest request, HttpServletResponse response, int ID) throws ServletException, IOException {
        

	 UserBO userBO = new UserBO();
     System.out.println(ID);
     if (!userBO.resetPassWord(ID)) {
         response.getWriter().write("Reset error!");
     } else {
         viewEditUser(request, response);
     }
    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserBean newUser = getUserFromRequest(request);

        UserBO userBO = new UserBO();
        System.out.println(newUser.getUserId());
        boolean check = userBO.addUserBO(newUser);
        if (!check) {
            response.getWriter().write("Add error!");
        } else {
            viewEditUser(request, response);
        }
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserBean updatedUser = getUserFromRequest(request);

        UserBO userBO = new UserBO();
       
        if (!userBO.updateUserBO(updatedUser)) {
            response.getWriter().write("Update error!");
        } else {
            viewEditUser(request, response);
        }
    }

    private UserBean getUserFromRequest(HttpServletRequest request) {
        int userID = Integer.parseInt(request.getParameter("userID"));
        String username = request.getParameter("username");
       
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String address = request.getParameter("address");
        String phoneNumber = request.getParameter("phoneNumber");
        String role = request.getParameter("role");

        UserBean user = new UserBean();
        user.setUserId(userID);
        user.setUsername(username);       
        user.setEmail(email);
        user.setPassword(password);
        user.setAddress(address);
        user.setPhoneNumber(phoneNumber);
        user.setRole(role);
        return user;
    }

   
}

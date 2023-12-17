package Model.BO;

import java.util.ArrayList;
import java.util.List;

import Model.BEAN.UserBean;
import Model.DAO.UserDAO;

public class UserBO {
    private UserDAO userDAO;

    public UserBO() {
        userDAO = new UserDAO();
    }


    public boolean addUserBO(UserBean user) {
        
        return userDAO.addUser(user);
    }
public boolean updateUserBO(UserBean user) {
        
        return userDAO.updateUser(user);
    }
public boolean resetPassWord(int User_ID) {
    
    return userDAO.resetPasswordById(User_ID, "123");
}

    // Business logic for user login
    public String loginUser(String username, String password) {
        
        return userDAO.checkLogin(username, password);
    }
 public UserBean getUserById(int userId) {
        
        return userDAO.getUserById(userId);
    }

    public UserBean getUserDetails(int userId) {
        
        return userDAO.getUserById(userId);
    }
    public UserBean getUser(String userName, String pasWord) {
        
        return userDAO.getUser(userName, pasWord);
    }

   
    public List<UserBean> getAllUsers() {
    	  List<UserBean> users = new ArrayList<>();
        users =  userDAO.getAllUsers();
        return users;
    }

    
    public boolean deleteUser(int userId) {
       
        return userDAO.deleteUser(userId);
    }

   
    public boolean searchUserById(int userId) {
       
        return userDAO.searchUserById(userId);
    }
}

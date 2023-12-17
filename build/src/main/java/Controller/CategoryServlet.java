package Controller;

import Model.BEAN.CategoryBean;
import Model.BO.CategoryBO;

<<<<<<< HEAD
=======
import javax.servlet.RequestDispatcher;
>>>>>>> 10598cb (admin)
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/CategoryServlet")
public class CategoryServlet extends HttpServlet {

    private CategoryBO categoryBO;

    public void init() {
        categoryBO = new CategoryBO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        String stdDeleteCategoryParam = request.getParameter("stdDeleteCategory");

        if (stdDeleteCategoryParam != null && !stdDeleteCategoryParam.isEmpty()) {
            int stdDeleteCategory = Integer.parseInt(stdDeleteCategoryParam);
            deleteCategory(request, response,stdDeleteCategory);
        } 
        String stdUpdateCategoryParam = request.getParameter("stdUpdateCategory");

        if (stdUpdateCategoryParam != null && !stdUpdateCategoryParam.isEmpty()) {
            int stdUpdateCategory = Integer.parseInt(stdUpdateCategoryParam);
            viewUpdateCategories(request, response,stdUpdateCategory);
        } 

        if (action != null) {
            if (action.equals("viewCategories")) {
            	
                viewCategories(request, response);
                
            } else if (action.equals("InsertCategory")) {
            	
                addCategory(request, response);
                
            } else if(action.equals("editCategory")) {
            	
            	viewEditCategories(request,response);
            	
            }else if(action.equals("updateCategory")) {
            	
            	updateCategory(request,response);
            	
            }
            
            }
    }

    private void viewUpdateCategories(HttpServletRequest request, HttpServletResponse response, int ID) throws ServletException, IOException {
        
    	 CategoryBean category = new CategoryBean();
    	 category= categoryBO.getCategoryById(ID);   	 
    	  request.setAttribute("category", category);   	
         RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/viewUpdateCategory.jsp");
         dispatcher.forward(request, response);
    }

    private void viewCategories(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        List<CategoryBean> categories = categoryBO.getAllCategories();
        request.setAttribute("categories", categories);
        request.getRequestDispatcher("categories.jsp").forward(request, response);
    }
    private void viewEditCategories(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<CategoryBean> categories = categoryBO.getAllCategories();
        request.setAttribute("categories", categories);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/editCategory.jsp");
        dispatcher.forward(request, response);
        
    }
    private void updateCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       CategoryBean category = new CategoryBean();
       String categoryName = request.getParameter("Name");
       int categoryID = Integer.parseInt(request.getParameter("ID"));
       category.setName(categoryName);
       category.setCategoryId(categoryID);
       CategoryBO ctBO= new CategoryBO();
       boolean check=false;
       check = ctBO.updateCategory(category);
       if(check) {
    	   List<CategoryBean> categories = categoryBO.getAllCategories();
           request.setAttribute("categories", categories);
           System.out.println("update Category");
    	   RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/editCategory.jsp");
           dispatcher.forward(request, response);
       }else {
    	   response.getWriter().write("Update error!");
       }
       
    }


    private void addCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        int categoryId = Integer.parseInt(request.getParameter("categoryID"));
        String categoryName = request.getParameter("categoryName");
        CategoryBean category = new CategoryBean(categoryId, categoryName);

        boolean result = categoryBO.addCategory(category);

        if (result) {
        	List<CategoryBean> categories = categoryBO.getAllCategories();
            request.setAttribute("categories", categories);
     	   RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/editCategory.jsp");
            dispatcher.forward(request, response);
        } else {
        	response.getWriter().write("Add error!");
        }
    }

    private void deleteCategory(HttpServletRequest request, HttpServletResponse response, int categoryId) throws ServletException, IOException {
        
       
        boolean result = categoryBO.deleteCategory(categoryId);

        if (result) {

        	List<CategoryBean> categories = categoryBO.getAllCategories();
            request.setAttribute("categories", categories);
     	   RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/editCategory.jsp");
            dispatcher.forward(request, response);
        } else {
        	response.getWriter().write("Delete error!");
            
        }
    }
}
package Controller;

import Model.BEAN.CategoryBean;
import Model.BEAN.ProductBean;
<<<<<<< HEAD
import Model.BEAN.UserBean;
import Model.BO.CategoryBO;
import Model.BO.ProductBO;
import Model.BO.UserBO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
=======
import Model.BO.CategoryBO;
import Model.BO.ProductBO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
>>>>>>> 10598cb (admin)
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;

=======
import java.util.List;

@MultipartConfig
>>>>>>> 10598cb (admin)
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	if (request.getParameter("productId")!=null) {
    		int productId = Integer.parseInt(request.getParameter("productId"));
    		ProductBO productBO = new ProductBO();
    		ProductBean product = productBO.getProductById(productId);
    		request.setAttribute("product", product);
    		CategoryBO categoryBO= new CategoryBO();
        	List<CategoryBean> listCategory = new ArrayList();   	 
        	listCategory = categoryBO.getAllCategories();
       	 	request.setAttribute("listCategorys", listCategory);
       	 	
    	   	List<ProductBean> listProducts = new ArrayList();   	 
    	 	listProducts = productBO.getAllProducts();
    		request.setAttribute("listProducts", listProducts);
    		RequestDispatcher dispatcher = request.getRequestDispatcher("/product_detail.jsp");
			dispatcher.forward(request, response);
    	}

        String action = request.getParameter("action");
        String stdDeleteProduct = request.getParameter("stdDeleteProduct");
        String stdUpdateProduct = request.getParameter("stdUpdateProduct");
        
        if (stdDeleteProduct != null && !stdDeleteProduct.isEmpty()) {
        	System.out.println("delete Product	");
            int idProduct = Integer.parseInt(request.getParameter("stdDeleteProduct"));
            deleteProduct(request, response, idProduct);
        } 
        if (stdUpdateProduct != null && !stdUpdateProduct.isEmpty()) {
        	int stdUpdate = Integer.parseInt(request.getParameter("stdUpdateProduct"));
            viewUpdateProduct(request, response, stdUpdate);
        } 
        if ("editProduct".equals(action)) {
            viewEditProduct(request, response);
        } else if ("InsertProduct".equals(action)) {
            insertProduct(request, response);
        } else if ("updateProduct".equals(action)) {
            updateProduct(request, response);
        } 
    }

    private void viewUpdateProduct(HttpServletRequest request, HttpServletResponse response, int stdUpdateParam) throws ServletException, IOException {
        setCategoriesAttribute(request);

        ProductBO productBO = new ProductBO();
        ProductBean product = productBO.getProductByID(stdUpdateParam);

        request.setAttribute("product", product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/viewUpdateProduct.jsp");
        dispatcher.forward(request, response);
    }

    private void viewEditProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        setCategoriesAttribute(request);

        ProductBO productBO = new ProductBO();
        List<ProductBean> listProduct = productBO.getAllProducts();
        request.setAttribute("listProduct", listProduct);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/editProduct.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response, int ID) throws ServletException, IOException {
        setCategoriesAttribute(request);

        ProductBO productBO = new ProductBO();
        productBO.deleteProductDAO(ID);

        List<ProductBean> listProduct = productBO.getAllProducts();
        request.setAttribute("listProduct", listProduct);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/editProduct.jsp");
        dispatcher.forward(request, response);
    }

    private void insertProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductBean newProduct = getProductFromRequest(request);

        ProductBO productBO = new ProductBO();
        boolean check = productBO.insertProductBO(newProduct);
        if (!check) {
            response.getWriter().write("Add error!");
        } else {
            viewEditProduct(request, response);
        }
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductBean updatedProduct = getProductFromRequest(request);

        ProductBO productBO = new ProductBO();
        System.out.println("update");
        boolean check = productBO.updateProductBO(updatedProduct);
       
        if (!check) {
            response.getWriter().write("Update error!");
        } else {
            viewEditProduct(request, response);
        }
    }

    private ProductBean getProductFromRequest(HttpServletRequest request) {
        int productID = Integer.parseInt(request.getParameter("productID"));
        String productName = request.getParameter("productName");
        int categoryID = Integer.parseInt(request.getParameter("categoryID"));
        String description = request.getParameter("description");
        double price = Double.parseDouble(request.getParameter("price"));
        double discountPrice = Double.parseDouble(request.getParameter("discountPrice"));
        String manufacturer = request.getParameter("manufacturer");
        String imageURL = request.getParameter("imageURL");
        int topTrending = Integer.parseInt(request.getParameter("topTrending"));
        boolean hot = request.getParameter("hot") != null;
        boolean onSale = request.getParameter("onSale") != null;
        boolean bestSeller = request.getParameter("bestSeller") != null;
        boolean topViewed = request.getParameter("topViewed") != null;

        ProductBean product = new ProductBean();
        product.setProductId(productID);
        product.setName(productName);
        product.setCategoryId(categoryID);
        product.setDescription(description);
        product.setPriceOriginal(price);
        product.setPriceSale(discountPrice);
        product.setManufacturer(manufacturer);
        product.setImageUrl(imageURL);
        product.setToptrending(topTrending);
        product.setHot(hot);
        product.setOnSale(onSale);
        product.setBestSeller(bestSeller);
        product.setTopViewed(topViewed);
        return product;
    }

    private void setCategoriesAttribute(HttpServletRequest request) {
        CategoryBO categoryBO = new CategoryBO();
        List<CategoryBean> categories = categoryBO.getAllCategories();
        request.setAttribute("categories", categories);

    }
}

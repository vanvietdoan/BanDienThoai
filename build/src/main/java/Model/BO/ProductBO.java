package Model.BO;

import java.util.List;
import Model.BEAN.ProductBean;
import Model.DAO.ProductDAO;

public class ProductBO {
    private ProductDAO productDAO;

    public ProductBO() {
        productDAO = new ProductDAO(); 
    }
    
    public ProductBean getProductById(int productId) {
    	return productDAO.getProductById(productId);
    }

    public boolean addProduct(ProductBean product) {
        try {
            return productDAO.addProduct(product);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<ProductBean> getListProductByIDCategory(int categoryId) {
        try {
            return productDAO.getListProductByIDCategory(categoryId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<ProductBean> getAllProducts() {
        try {
            return productDAO.getAllProducts();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public List<ProductBean> getTopProducts() {
        try {
            return productDAO.getProductTopTrending();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ProductDAO getProductDAO() {
        return productDAO;
    }
    public boolean insertProductBO(ProductBean product) {
		return productDAO.insertProduct(product);
	}

    public boolean updateProductBO(ProductBean product) {
		return productDAO.updateProduct(product);
	}

    public void setProductDAO(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public void deleteProductDAO(int ID) {
        productDAO.deleteProductByID(ID);
    }
    public ProductBean getProductByID(int ID) {
        return productDAO.getProductById(ID);
    }
    
    
    
    public List<ProductBean> getProductListByPriceRange(String priceRange) {
        double minPrice = 0;
        double maxPrice = 0;

        switch (priceRange) {
            case "0-500":
                maxPrice = 500;
                break;
            case "500-700":
                minPrice = 500;
                maxPrice = 700;
                break;
            case "700-900":
                minPrice = 700;
                maxPrice = 900;
                break;
            case "900-1000":
                minPrice = 900;
                maxPrice = 1000;
                break;
           
        }

        return productDAO.getListProductByPriceRange(minPrice, maxPrice);
    }
}
package Model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.BEAN.ProductCategoryBean;

public class ProductCategoryDAO {
    private Connection connection;

    public ProductCategoryDAO(Connection connection) {
    	connection = DBConnect.getConnection();
    }

    // Get all product categories
    public List<ProductCategoryBean> getAllProductCategories() {
        List<ProductCategoryBean> productCategories = new ArrayList<>();
        String query = "SELECT * FROM product_category";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                ProductCategoryBean productCategory = new ProductCategoryBean();
                productCategory.setProductId(resultSet.getInt("product_id"));
                productCategory.setCategoryId(resultSet.getInt("category_id"));
                productCategories.add(productCategory);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle this exception properly in a real application
        }
        return productCategories;
    }

    // Add a new product category
    public boolean addProductCategory(ProductCategoryBean productCategory) {
        String query = "INSERT INTO product_category (product_id, category_id) VALUES (?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, productCategory.getProductId());
            preparedStatement.setInt(2, productCategory.getCategoryId());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace(); // Handle this exception properly in a real application
        }
        return false;
    }

    // Delete a product category
    public boolean deleteProductCategory(int productId, int categoryId) {
        String query = "DELETE FROM product_category WHERE product_id = ? AND category_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, productId);
            preparedStatement.setInt(2, categoryId);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace(); // Handle this exception properly in a real application
        }
        return false;
    }

    // Search for a product category
    public boolean searchProductCategory(int productId, int categoryId) {
        String query = "SELECT * FROM product_category WHERE product_id = ? AND category_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, productId);
            preparedStatement.setInt(2, categoryId);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace(); // Handle this exception properly in a real application
        }
        return false;
    }
}


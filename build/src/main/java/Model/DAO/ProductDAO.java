package Model.DAO;


import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Model.BEAN.ProductBean;

public class ProductDAO {
    private Connection connection;

    public ProductDAO() {
        connection = DBConnect.getConnection();
    }


    public ProductBean getProductById(int productId) {
        ProductBean product = null;
        String query = "SELECT p.product_id, p.name, p.description, p.priceOriginal, p.priceSale, " +
                "p.manufacturer, p.image_url, p.toptrending, p.isHot, p.isOnSale, " +
                "p.isBestSeller, p.isTopViewed, p.category_id, c.name AS category_name " +
                "FROM products p JOIN categories c ON p.category_id = c.category_id " +
                "WHERE p.product_id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, productId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    product = mapResultSetToProduct(resultSet);
                }
            }
        } catch (SQLException e) {
            handleSQLException(e);

        }
        return product;
    }


    public List<ProductBean> getAllProducts() {
        List<ProductBean> products = new ArrayList<>();
        String query = "SELECT p.product_id, p.name, p.description, p.priceOriginal, p.priceSale, " +
                "p.manufacturer, p.image_url, p.toptrending, p.isHot, p.isOnSale, " +
                "p.isBestSeller, p.isTopViewed, p.category_id, c.name AS category_name " +
                "FROM products p JOIN categories c ON p.category_id = c.category_id";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                ProductBean product = mapResultSetToProduct(resultSet);
                product.setCategoryName(resultSet.getString("category_name"));
                products.add(product);
            }
        } catch (SQLException e) {
            handleSQLException(e);
        }
        return products;
    }

    public List<ProductBean> getProductTopTrending() {
        List<ProductBean> products = new ArrayList<>();
        String query = "SELECT * FROM products WHERE toptrending < 11 ORDER BY toptrending ASC";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                ProductBean product = mapResultSetToProduct(resultSet);
                products.add(product);
            }
        } catch (SQLException e) {
            handleSQLException(e);
        }
        return products;
    }

    public boolean insertProduct(ProductBean product) {
        boolean success = false;
        String query = "INSERT INTO products (product_id, category_id, name, description, priceOriginal, priceSale, manufacturer, image_url, toptrending, isHot, isOnSale, " +
                "isBestSeller, isTopViewed) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            if (productExists(product.getProductId())) {
                System.out.println("Product with productId " + product.getProductId() + " already exists.");
                return false;
            }

            setProductParameters(preparedStatement, product);
            int rowsAffected = preparedStatement.executeUpdate();
            success = rowsAffected > 0;
        } catch (SQLException e) {
            handleSQLException(e);
        }

        return success;
    }

    public boolean updateProduct(ProductBean product) {
        String query = "UPDATE products SET category_id=?, name=?, description=?, " +
                "priceOriginal=?, priceSale=?, manufacturer=?, image_url=?, " +
                "toptrending=?, isHot=?, isOnSale=?, isBestSeller=?, isTopViewed=? " +
                "WHERE product_id=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            if (!productExists(product.getProductId())) {
                System.out.println("Product with productId " + product.getProductId() + " does not exist.");
                return false;
            }

            int parameterIndex = 1;
            
            preparedStatement.setInt(parameterIndex++, product.getCategoryId());
            preparedStatement.setString(parameterIndex++, product.getName());
            preparedStatement.setString(parameterIndex++, product.getDescription());
            preparedStatement.setBigDecimal(parameterIndex++, BigDecimal.valueOf(product.getPriceOriginal()));
            preparedStatement.setBigDecimal(parameterIndex++, BigDecimal.valueOf(product.getPriceSale()));
            preparedStatement.setString(parameterIndex++, product.getManufacturer());
            preparedStatement.setString(parameterIndex++, product.getImageUrl());
            preparedStatement.setInt(parameterIndex++, product.getToptrending());
            preparedStatement.setBoolean(parameterIndex++, product.isHot());
            preparedStatement.setBoolean(parameterIndex++, product.isOnSale());
            preparedStatement.setBoolean(parameterIndex++, product.isBestSeller());
            preparedStatement.setBoolean(parameterIndex++, product.isTopViewed());
            preparedStatement.setInt(parameterIndex++, product.getProductId());
            System.out.println(product.getProductId());

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Product updated successfully.");
                return true;
            } else {
                System.out.println("Failed to update product.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    private void setProductParameters(PreparedStatement preparedStatement, ProductBean product) throws SQLException {
        int parameterIndex = 1;
        preparedStatement.setInt(parameterIndex++, product.getProductId());
        preparedStatement.setInt(parameterIndex++, product.getCategoryId());
        preparedStatement.setString(parameterIndex++, product.getName());
        preparedStatement.setString(parameterIndex++, product.getDescription());
        preparedStatement.setBigDecimal(parameterIndex++, BigDecimal.valueOf(product.getPriceOriginal()));
        preparedStatement.setBigDecimal(parameterIndex++, BigDecimal.valueOf(product.getPriceSale()));
        preparedStatement.setString(parameterIndex++, product.getManufacturer());
        preparedStatement.setString(parameterIndex++, product.getImageUrl());
        preparedStatement.setInt(parameterIndex++, product.getToptrending());
        preparedStatement.setBoolean(parameterIndex++, product.isHot());
        preparedStatement.setBoolean(parameterIndex++, product.isOnSale());
        preparedStatement.setBoolean(parameterIndex++, product.isBestSeller());
        preparedStatement.setBoolean(parameterIndex++, product.isTopViewed());
       
    }

    private boolean productExists(int productId) {
        String query = "SELECT COUNT(*) FROM products WHERE product_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, productId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0;
                }
            }
        } catch (SQLException e) {
            handleSQLException(e);
        }
        return false;
    }

    private void handleSQLException(SQLException e) {
        // Handle or log the exception appropriately
        e.printStackTrace();
    }

    private ProductBean mapResultSetToProduct(ResultSet resultSet) throws SQLException {
        ProductBean product = new ProductBean();
        product.setProductId(resultSet.getInt("product_id"));
        product.setCategoryId(resultSet.getInt("category_id"));
        product.setName(resultSet.getString("name"));
        product.setDescription(resultSet.getString("description"));
        product.setPriceOriginal(resultSet.getDouble("priceOriginal"));
        product.setPriceSale(resultSet.getDouble("priceSale"));
        product.setManufacturer(resultSet.getString("manufacturer"));
        product.setImageUrl(resultSet.getString("image_url"));
        product.setToptrending(resultSet.getInt("toptrending"));
        product.setHot(resultSet.getBoolean("isHot"));
        product.setOnSale(resultSet.getBoolean("isOnSale"));
        product.setBestSeller(resultSet.getBoolean("isBestSeller"));
        product.setTopViewed(resultSet.getBoolean("isTopViewed"));
       
        return product;
    }

    public void deleteProductByID(int productID) {
        String query = "DELETE FROM products WHERE product_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            if (!productExists(productID)) {
                System.out.println("Product with productId " + productID + " does not exist.");
                return;
            }

            preparedStatement.setInt(1, productID);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Product with productId " + productID + " deleted successfully.");
            } else {
                System.out.println("Failed to delete product with productId " + productID + ".");
            }
        } catch (SQLException e) {
            handleSQLException(e);
        }
    }

    public List<ProductBean> getListProductByPriceRange(double minPrice, double maxPrice) {
        List<ProductBean> productList = new ArrayList<>();
        String query = "SELECT * FROM products WHERE priceSale BETWEEN ? AND ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setDouble(1, minPrice);
            preparedStatement.setDouble(2, maxPrice);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                ProductBean product = mapResultSetToProduct(resultSet);
                productList.add(product);
            }
        } catch (SQLException e) {
            handleSQLException(e);
>>>>>>> 10598cb (admin)
        }

        return productList;
    }
}
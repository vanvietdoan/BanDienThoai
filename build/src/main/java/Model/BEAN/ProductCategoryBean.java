package Model.BEAN;

public class ProductCategoryBean {
    private int productId;
    private int categoryId;

    public ProductCategoryBean() {}
    
    public ProductCategoryBean(int productId, int categoryId) {
    	this.productId = productId;
    	this.categoryId = categoryId;
    }
    
    // Getters and setters
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}


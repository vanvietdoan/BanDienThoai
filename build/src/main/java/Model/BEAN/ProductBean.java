package Model.BEAN;

public class ProductBean {
    private int productId;

    private int categoryId;

    private String name;
    private String description;
    private double priceOriginal;
    private double priceSale;
    private String manufacturer;
    private String imageUrl;
    private int toptrending;
    private boolean isHot;
    private boolean isOnSale;
    private boolean isBestSeller;
    private boolean isTopViewed;

    private String CategoryName;

    public ProductBean() {
    	
    }


    public ProductBean(int productId, int categoryId, String name, String description, double priceOriginal,
            double priceSale, String manufacturer, String imageUrl, int toptrending, boolean isHot, boolean isOnSale,
            boolean isBestSeller, boolean isTopViewed) {
        this.productId = productId;
        this.categoryId = categoryId;
        this.name = name;
        this.description = description;
        this.priceOriginal = priceOriginal;
        this.priceSale = priceSale;
        this.manufacturer = manufacturer;
        this.imageUrl = imageUrl;
        this.toptrending = toptrending;
        this.isHot = isHot;
        this.isOnSale = isOnSale;
        this.isBestSeller = isBestSeller;
        this.isTopViewed = isTopViewed;
    }
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
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }
    public void setToptrending(int Toptrending) {
        this.toptrending = Toptrending;
    }

    public int getToptrending() {
        return toptrending;
    }


    public void setDescription(String description) {
        this.description = description;
    }

    public double getPriceOriginal() {
        return priceOriginal;
    }

    public void setPriceOriginal(double priceOriginal) {
        this.priceOriginal = priceOriginal;
    }

    public double getPriceSale() {
        return priceSale;
    }

    public void setPriceSale(double priceSale) {
        this.priceSale = priceSale;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }


    public int getToptrending() {
        return toptrending;
    }

    public void setToptrending(int toptrending) {
        this.toptrending = toptrending;
    }

    public boolean isHot() {
        return isHot;
    }

    public void setHot(boolean hot) {
        isHot = hot;
    }

    public boolean isOnSale() {
        return isOnSale;
    }

    public void setOnSale(boolean onSale) {
        isOnSale = onSale;
    }

    public boolean isBestSeller() {
        return isBestSeller;
    }

    public void setBestSeller(boolean bestSeller) {
        isBestSeller = bestSeller;
    }

    public boolean isTopViewed() {
        return isTopViewed;
    }

    public void setTopViewed(boolean topViewed) {
        isTopViewed = topViewed;
    }

	public void setCategoryName(String categoryName) {
		CategoryName = categoryName;
		
	}
	public String getCategoryName() {
		return CategoryName;
		
	}
}

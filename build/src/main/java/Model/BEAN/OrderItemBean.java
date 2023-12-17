package Model.BEAN;

public class OrderItemBean {

    private int orderId;
    private ProductBean item;

    private int quantity;
    private double subtotal;

    public OrderItemBean() {}
    

    public OrderItemBean(int oderItemId, int orderId, int productId, int quantity, int subtotal) {
    	this.orderItemId = orderItemId;
    	this.orderId = orderId;
    	this.productId = productId;
    	this.quantity = quantity;
    	this.subtotal = subtotal;
    }
    
    // Getters and setters
    public int getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(int orderItemId) {
        this.orderItemId = orderItemId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }


    public ProductBean getItem() {
    	return item;
    }
    public void setItem(ProductBean item) {
    	this.item = item;
    }
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
}

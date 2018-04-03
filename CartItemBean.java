package sdsu;
import java.util.*;
/*
Sravani Kandarpa
jadrn015, Proj2
Usage : creating cart item.
*/

public class CartItemBean implements java.io.Serializable
{

    private String sku, category, vendor, vendorModel, description, features, image;
    private float cost, retail;
    private int quantity;
    private double dblTotalCost;

    public CartItemBean() {
    }

    public CartItemBean(String sku, String category, String vendor, String vendorModel, String description, String features, double dblTotalCost,float cost, float retail, int quantity,String image) {
        this.sku = sku;
        this.category = category;
        this.vendor = vendor;
        this.vendorModel = vendorModel;
        this.description = description;
        this.features = features;
        this.image = image;
        this.quantity = quantity;
        this.dblTotalCost = dblTotalCost;
        this.retail = retail;
        this.retail = cost;
    }

    public double getTotalCost() {
        return dblTotalCost;
    }
    public void setTotalCost(double dblTotalCost) {
        this.dblTotalCost = dblTotalCost;
    }
    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getVendorModel() {
        return vendorModel;
    }

    public void setVendorModel(String vendorModel) {
        this.vendorModel = vendorModel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public float getRetail() {
        return retail;
    }

    public void setRetail(float retail) {
        this.retail = retail;
    }
}

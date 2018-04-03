package sdsu;
import java.sql.*;
import java.util.*;
/*
Sravani Kandarpa
jadrn015, Proj2

Usage : Each row in the database will be encapsulated in Product bean and will be passed around the application.
*/

public class ProductBean implements java.io.Serializable
{
    //sku, catID,venID,vendorModel,description,features,cost,retail ,quantity,image
    private String sku, category, vendor, vendorModel, description, features, image,message;
    private float cost, retail;
    private int quantity;
    public ProductBean() {
    }

    public ProductBean(String sku, String category, String vendor, String vendorModel, String description, String features, float cost, float retail, int quantity,String image,String message) {
        this.sku = sku;
        this.category = category;
        this.vendor = vendor;
        this.vendorModel = vendorModel;
        this.description = description;
        this.features = features;
        this.image = image;
        this.quantity = quantity;
        this.cost = cost;
        this.retail = retail;
        this.message=message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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

    public String getvendorModel() {
        return vendorModel;
    }

    public void setvendorModel(String vendorModel) {
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

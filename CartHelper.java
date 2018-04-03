package sdsu;
import java.util.ArrayList;
/*
Sravani Kandarpa
jadrn015
proj2
I have referred this website :http://www.tech-freaks.com/jsp-servlets/shopping-cart/development.html
for the basic idea of creating a shopping cart
*/
public class CartHelper {


private  ArrayList cartProductsList = new ArrayList();
private int productCount;
private double dblOrderTotal ;

//getters and setters


 public ArrayList getCartProducts() {
  return cartProductsList;
 }

 public void setCartProducts(ArrayList cartProductsList) {
  this.cartProductsList = cartProductsList;
 }

  public int getProductCount() {
   return productCount;
  }

  public void setProductCount(int productCount) {
   this.productCount = productCount;
 }

  public double getOrderTotal() {
     return dblOrderTotal;
  }

  public void setOrderTotal(double dblOrderTotal) {
     this.dblOrderTotal = dblOrderTotal;
  }

// to get the cart size
 public int getCartSize()
{
  return cartProductsList.size();
}

// add to cart
public void addCartProduct(String sku, String category, String vendor, String vendorModel, String description, String features, float cost, float retail, int quantity,String image){
 CartItemBean cartProduct = new CartItemBean();
double totalcost=0;
    cartProduct.setSku(sku);
	cartProduct.setCategory(category);
	cartProduct.setVendor(vendor);
	cartProduct.setFeatures(features);
	cartProduct.setImage(image);
	cartProduct.setVendorModel(vendorModel);
    cartProduct.setDescription(description);
   cartProduct.setRetail(retail);
    cartProduct.setQuantity(quantity);
    cartProduct.setTotalCost(totalcost);
	//   calculateOrderTotal();
	calculateProductCount();
	cartProductsList.add(cartProduct);
	}

// add to cart
  public void addCartProduct(CartItemBean cartItem) {
    cartProductsList.add(cartItem);
 }

//get cart product
public CartItemBean getCartItem(int iItemIndex) {
     CartItemBean cartItem = null;
    if(cartProductsList.size()>iItemIndex) {
     cartItem = (CartItemBean) cartProductsList.get(iItemIndex);
    }
    return cartItem;
}



 /*protected void calculateOrderTotal() {
    double dblTotal = 0;
    for(int counter=0;counter<cartProductsList.size();counter++) {
     CartItemBean cartItem = (CartItemBean) cartProductsList.get(counter);
     dblTotal+=cartItem.getTotalCost();
  }
  setOrderTotal(dblTotal);
 }*/


 protected void calculateProductCount() {
  int itTotal = 0;

  for(int counter=0;counter<cartProductsList.size();counter++) {
  CartItemBean cartItem = (CartItemBean) cartProductsList.get(counter);
   itTotal+=cartItem.getQuantity();

  }

  setProductCount(itTotal);
 }



}

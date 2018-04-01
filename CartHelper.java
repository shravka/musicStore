package sdsu;
import java.util.ArrayList;
/*
Sravani Kandarpa
jadrn015
proj2
*/
public class CartHelper {


private  ArrayList<CartItemBean> CartProductsList = new ArrayList<CartItemBean>();

public int  getCartSize()
{
  return CartProductsList.size();
}

public void addCartProduct(String sku, String category, String vendor, String vendorModel, String description, String features, float cost, float retail, int quantity,String image){
 CartItemBean cartProduct = new CartItemBean();
 CartProductsList.add(cartProduct);

	}

}

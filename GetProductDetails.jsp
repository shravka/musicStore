<%@page import ="java.util.*"%>
<%@page import ="sdsu.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <c:forEach items="${beans}" var="item">
  <fieldset id="Detailtable">
   <legend><h3>Details</h3></legend>
   <table>
    
    <tr>
       <td>Brand : ${ item.vendor}</td>
    </tr>
    <tr>
           <td> Description : ${ item.description}</td>
    </tr>
    
    <tr>
           <td>Features: ${item.features}</td>
    </tr>
 
    <tr>
            <td>  <img id="bigImage" src="/~jadrn015/proj1/musicStore/${item.image}" width="500px" alt=""/></td>
    </tr>
  
     <button type="button"  class='add-to-cart' id='cart${item.sku}' name="${item.sku}" >Add To Cart</button>
     <span> Quantitiy </span>  <input type='text'  class='qty' id='qty${item.sku}' />
     <p id="status">  </p>  
             
    </table>
    </fieldset>       
</c:forEach>

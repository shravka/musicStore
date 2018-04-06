<%@page import ="java.util.*"%>
<%@page import ="sdsu.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <c:forEach items="${beans}" var="item">
<%--  <fieldset>
   <legend>Details</legend>
   <table id="Detailtable">
    <tr><td>vendor : ${ item.vendor}</td> </tr>
    <tr><td>category : ${ item.category}</td> </tr>
     <tr><td>category : ${ item.message}</td> </tr>
    <tr> <td> Description : ${ item.description}</td> </tr>
    <tr> <td>Features: ${item.features}</td></tr>
    <tr> <td>  </td></tr>


     <p id="status">  </p>

    </table>
  </fieldset>   --%>
<div id='intro' >     ${ item.vendor} ,  <span id='venintro'>${item.vendorModel} </span>  <span id='pintro'> only at</span> ${item.retail} $ </div>
<img id="bigImage" src="/~jadrn015/proj1/musicStore/${item.image}" width="500px" alt=""/>
<div>
  <div id='dintro'>   Description : ${ item.description}</div>
  <div id='fintro'>   Features: ${item.features}  </div>
</div>
<button type="button"  class='add-to-cart ui-button' id='cart${item.sku}' name="${item.sku}" >Add To Cart</button>
<div id=qintro> Quantitiy   <input type='text'  class='qty' id='qty${item.sku}' size='2'/></div>
</c:forEach>

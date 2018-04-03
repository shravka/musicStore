<%@page import ="java.util.*"%>
<%@page import ="sdsu.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

 <c:forEach items="${beans}" var="item">
    <div class="singleone" >
        <img class="instrumentImages" src="/~jadrn015/proj1/musicStore/${item.image}" width="300px" alt=""/>
         <div class="message">${item.message} </div>
          <div class="sku"> ${item.sku}</div>
          <div class="sku-cat">

                <p class="price">$ ${item.retail}</p>
        <%--  <input type='button' class='View-Details' id='view-${item.sku}' value='View' />--%>
      <%--  <button type="button"  class="addtobag">Add To Cart</button>  --%>
          <button type="button"  class='View-Details'id='${item.sku}' >View Details</button>
        </div>
     <%--        <div class="imgwrap" >    </div><div class='desclayer'>  <p class='longdesc'>  ${item.description}    </p>   </div>
      <p class='features'> ${item.features}  </p>
      <h3 class='retail'> ${item.retail}</h3>  --%>

   </div>
</c:forEach>

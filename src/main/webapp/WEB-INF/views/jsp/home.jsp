
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>
<head>
<title> Welcome to Subhash Store </title>
</head>
<body>


<div>
<h2> Product Details</h2>
<table>
<thead>
   <tr>
      <th>PRODUCT ID </th>
      <th>PRODUCT NAME </th>
      <th>PRODUCT_DESCRIPTION </th>
      <th>PRODUCT_COST </th>
       <th> COMPANY_BRAND</th>
       <th>Action</th>
   </tr>
</thead>

<tbody>

<c:forEach items= "${prodcutList}" var ="prodcut">

<tr>
<td> ${product.productId}</td>
<td> ${product.productName}</td>
<td> ${product.productDescription}</td>
<td> ${product.productCost}</td>
<td> ${product.companyBrand}</td>

<td>
<a href="/edit?productId=${product.productId}">Edit</a>
    &nbsp;&nbsp;
    <a href="/delete?productId=${product.productId}">Delete</a>
</td>
</tr>

</c:forEach>

</tbody>

</table>






</div>

</body>


</html>
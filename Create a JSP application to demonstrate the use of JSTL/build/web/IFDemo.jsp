<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<c:set var="x" value="${param.x}"/> 
<c:set var="y" value="${param.y}"/> 
<c:if test="${x>y}"> 
    <font color="blue"><h2>The Ans is:</h2></font> 
    <c:out value="${x} is greater than ${y}"/> 
</c:if>  
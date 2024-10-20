<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<c:set var="income" value="${4000*4}"/> 
Your Income is: <c:out value="${income}"/> 
<c:choose> 
    <c:when test="${income <=1000}">
         Income is not good 
    </c:when> 
        <c:when test="${income > 10000}"> 
        Income is Very Good 
    </c:when> 
    <c:otherwise> 
        Income is undetermined 
    </c:otherwise> 
</c:choose> 
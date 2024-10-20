<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<c:forEach begin="1" end="10" var="i"> 
  The Square of <c:out value=" ${i}=${i*i}"/><br> 
    </c:forEach> 
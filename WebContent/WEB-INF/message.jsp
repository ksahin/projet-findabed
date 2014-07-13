<c:if test="${!empty message}">
	   	<c:choose>
	 		<c:when test="${messageType == 'succes'}">
	    		<div class='alert alert-success'> ${message}</div>
			</c:when>
	  	  	<c:otherwise>
	   			<div class='alert alert-error'> ${message}</div>
	  		</c:otherwise>
		</c:choose>
	</c:if>
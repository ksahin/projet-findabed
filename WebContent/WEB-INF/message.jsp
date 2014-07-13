
	<div class="container">
		<div class="content">
			<c:if test="${!empty message}">
			   	<c:choose>
			 		<c:when test="${messageType == 'succes'}">
			 			
			    		<div class="alert alert-success alert-dismissable"> ${message}
			    		<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
			    		</div>
					</c:when>
			  	  	<c:otherwise>
			  	  		
			   			<div class="alert alert-danger alert-dismissable"> ${message}
			   			<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
			   			</div>
			  		</c:otherwise>
				</c:choose>
			</c:if>
		</div>
	</div>

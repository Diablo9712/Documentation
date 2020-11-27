
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="cc" %>


<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
  <h2>Modal Example</h2>
  <!-- Button to Open the Modal -->
  <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">
    Open modal
  </button>

  <!-- The Modal -->
  <div class="modal" id="myModal">
    <div class="modal-dialog">
      <div class="modal-content">
      
        <!-- Modal Header -->
        <div class="modal-header">
          <h4 class="modal-title">Modal Heading</h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        
        <!-- Modal body -->
        <div class="modal-body">
              <div class="card card-primary">
				<div class="row">
						<div class="card-body">
								<cc:if test="${document != null }">
									<form action="updateDoc" method="post" >
									
									</cc:if>
									<cc:if test="${document == null }">
									<form action="insertDoc" method="post" >
									
									</cc:if>
									<caption>
											<h2 class="ml16" style="color:red;margin-left:25%">
													<cc:if test="${document != null }">
													Edit Document
													</cc:if>
														<cc:if test="${document == null }">
													Add New Document
													</cc:if>
											
											</h2>
									</caption>
									
									<cc:if test="${document != null }">
											<input type="hidden" name="id" value="<cc:out value='${document.id }'/>"/>
									</cc:if>
									
									<fieldset class="form-group">
										<label>Name Document</label>
										<input  type="text" value="<cc:out value='${document.name }'/>" class="form-control" name="name" required="required">
									</fieldset>
									
									<button type="submit" class="btn btn-success" style="float:right">Save</button>
									</form>
						</div>
				</div>
	</div>
        </div>
        
       
        
      </div>
    </div>
  </div>
  
</div>

</body>
</html>
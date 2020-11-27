
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 

<style>
.dtHorizontalVerticalExampleWrapper {
max-width: auto;
margin: 0 auto;
}
#dtHorizontalVerticalExample th, td {
white-space: nowrap;
}
table.dataTable thead .sorting:after,
table.dataTable thead .sorting:before,
table.dataTable thead .sorting_asc:after,
table.dataTable thead .sorting_asc:before,
table.dataTable thead .sorting_asc_disabled:after,
table.dataTable thead .sorting_asc_disabled:before,
table.dataTable thead .sorting_desc:after,
table.dataTable thead .sorting_desc:before,
table.dataTable thead .sorting_desc_disabled:after,
table.dataTable thead .sorting_desc_disabled:before {
bottom: .5em;
}
</style>



 <%@ include file="header.jsp" %>

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
  

    <!-- Main content -->
    <section class="content">
      <!-- Info boxes -->
      <div class="row">
      
        <!-- /.col -->
      
        <!-- /.col -->

        <!-- fix for small devices only -->
        <div class="clearfix visible-sm-block"></div>

      
        <!-- /.col -->
  
        <!-- /.col -->
      </div>
      <!-- /.row -->


     
	<div class="row"style="overflow-x:auto;">
				<div class="container" >
					<h3 class="text-center">Gestion des Documents</h3>
					<hr>
					<div class="container text-left">
								<a href="newDoc" class="btn btn-success" style="float:right">Add New Document</a>
								 <button type="button" class="btn btn-success" data-toggle="modal"style="float:right" data-target="#myModal">
    Add New Document
  </button>
					</div>
					<br>
			
										<table id="dtHorizontalVerticalExample" class="table table-striped table-bordered table-sm " cellspacing="0" 
  width="100%">
  <thead>
    <tr>
   <th>ID</th>
								<th>Document Name</th>
							
								<th>Action</th>
    </tr>
  </thead>
  <tbody>
			<c:forEach var="doc" items="${listDoc}">
						
							<tr>
								<td><c:out value="${doc.id}" /></td>
								<td><c:out value="${doc.name}" /></td>
							<td><a href="editDoc?id=<c:out value='${doc.id}' />" class="btn btn-primary">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp;
								<a href="deleteDoc?id=<c:out value='${doc.id}' />" class="btn btn-danger">Delete</a>
								</td>
							</tr>
						
						</c:forEach>
   
  </tbody>
</table><style>
table {
  border-collapse: collapse;
  border-spacing: 0;
  width: 100%;
  border: 1px solid #ddd;
}

th, td {
  text-align: left;
  padding: 8px;
}

tr:nth-child(even){background-color: #f2f2f2}
</style>
				</div>
		</div>




      
      <!-- /.row -->
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->

	<div class="container">
  <!-- Button to Open the Modal -->
 

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
				<div class="row"style="margin-left:10%;margin-right:10%">
						<div class="card-body" style="margin-left:10%;margin-right:10%">
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
	
		<script>
		$(document).ready(function () {
			$('#dtHorizontalVerticalExample').DataTable({
			"scrollX": true,
			"scrollY": 200,
			});
			$('.dataTables_length').addClass('bs-select');
			});
		</script>
 <%@ include file="footer.jsp" %>
		
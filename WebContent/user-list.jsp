
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
					<h3 class="text-center">Gestion des Utilisateurs</h3>
					<hr>
					<div class="container text-left">
								<a href="<%=request.getContextPath() %>/new" class="btn btn-success" style="float:right">Add New User</a>
					</div>
					<br>
			
										<table id="dtHorizontalVerticalExample" class="table table-striped table-bordered table-sm " cellspacing="0" style="margin-left:-10%"
  width="100%">
  <thead>
    <tr>
   <th>ID</th>
								<th>First Name</th>
								<th>Last Name</th>
								<th>Gender</th>
								<th>CIN</th>
								<th>Date Birth</th>
								<th>Place Birth</th>
								<th>Address</th>
								<th>Email</th>
								<th>Phone</th>
								<th>Photo</th>
								<th>Action</th>
    </tr>
  </thead>
  <tbody>
			<c:forEach var="user" items="${listUser}">
						
							<tr>
								<td><c:out value="${user.id}" /></td>
								<td><c:out value="${user.first_name}" /></td>
								<td><c:out value="${user.last_name}" /></td>
								<td><c:out value="${user.gender}" /></td>
								<td><c:out value="${user.cin}" /></td>
								<td><c:out value="${user.date_birth}" /></td>
								<td><c:out value="${user.place_birth}" /></td>
								<td><c:out value="${user.address}" /></td>
								<td><c:out value="${user.email}" /></td>
								<td><c:out value="${user.phone}" /></td>
							
								<td><img  style='height:100px;width:100px; border-radius:50%;'  src="images/<c:out value='${user.photo}' /> "></td>
								<td><a href="edit?id=<c:out value='${user.id}' />" class="btn btn-primary">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp;
								<a href="delete?id=<c:out value='${user.id}' />" class="btn btn-danger">Delete</a>
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
		
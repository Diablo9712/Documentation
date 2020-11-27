
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 

<style>
.dtHorizontalVerticalExampleWrapper {
max-width: 600px;
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
h2f {
  width: 25%;
  height: 100%;
  color: red;
  animation-name: example;
  animation-duration: 180s;
  margin-left:20%;
}

@keyframes example {
  0%   {background-color: red;}
  25%  {background-color: yellow;}
  50%  {background-color: blue;}
  100% {background-color: green;}
}

</style>

<script src="https://cdnjs.cloudflare.com/ajax/libs/animejs/2.0.2/anime.min.js"></script>

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
    


     <div class="container" style="margin-left:20%; border:2px">
  <div class="row">
      
        
        		 <div class="col-md-8">
            <!-- general form elements -->
            <div class="card card-primary">
				<div class="row">
						<div class="card-body">
								<c:if test="${user != null }">
									<form action="update" method="post" >
									
									</c:if>
									<c:if test="${user == null }">
									<form action="insert" method="post" >
									
									</c:if>
									<caption>
											<h2 class="ml16" style="color:red;margin-left:25%">
													<c:if test="${user != null }">
													Edit User
													</c:if>
														<c:if test="${user == null }">
													Add New User
													</c:if>
											
											</h2>
									</caption>
									
									<c:if test="${user != null }">
											<input type="hidden" name="id" value="<c:out value='${user.id }'/>"/>
									</c:if>
									
									<fieldset class="form-group">
										<label>First Name</label>
										<input  type="text" value="<c:out value='${user.first_name }'/>" class="form-control" name="first_name" required="required">
									</fieldset>
									<fieldset class="form-group">
										<label>Last Name</label>
										<input type="text" value="<c:out value='${user.last_name }' />" class="form-control" name="last_name" required="required">
									</fieldset>
									<fieldset class="form-group">
										<label>Gender</label>
										
										<select class="form-control" name="gender" required="required" value="<c:out value='${user.gender }'/>" >
										<option value="Male">Male</option>
										<option value="Female">Female</option>
										
										</select>
									
									</fieldset>
										<fieldset class="form-group">
										<label>CIN</label>
										<input  type="text" value="<c:out value='${user.cin }'/>" class="form-control" name="cin" required="required">
									</fieldset>
									<fieldset class="form-group">
										<label>Date Of Birth</label>
										<input type="date" value="<c:out value='${user.date_birth }' />" min="1900-01-01" max="2020-06-30"class="form-control" name="date_birth" required="required">
									</fieldset>
				
									<fieldset class="form-group">
										<label>Place Of Birth</label>
										<input type="text" value="<c:out value='${user.place_birth }'/>" class="form-control" name="place_birth" required="required">
									</fieldset>
										<fieldset class="form-group">
										<label>Address</label>
										<input  type="text" value="<c:out value='${user.address }'/>" class="form-control" name="address" required="required">
									</fieldset>
									
									<fieldset class="form-group">
										<label>Phone</label>
										<input type="text" value="<c:out value='${user.phone }'/>" class="form-control" name="phone" required="required">
									</fieldset>
										<fieldset class="form-group">
										<label>Email</label>
										<input type="text" value="<c:out value='${user.email }' />" class="form-control" name="email" required="required">
									</fieldset>
									<fieldset class="form-group">
										<label>Password</label>
										<input type="password" value="<c:out value='${user.email }' />" class="form-control" name="pass" required="required">
									</fieldset>			
													<fieldset class="form-group">
										<label>Photo</label>
										<input type="file" value="<c:out value='${user.photo }'/>" class="form-control" name="photo" required="required">
									</fieldset>
									<fieldset class="form-group">
										<label>Permission</label>
									<select class="form-control" name="role" required="required"  >
										<option value="admin">Admin</option>
										<option value="professeur">Professeur</option>
										<option value="etudiant">Etudiant</option>
										
										</select>
									</fieldset>
									<button type="submit" class="btn btn-success" style="float:right">Save</button>
									</form>
						</div>
				</div>
	</div>
	</div>
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
		
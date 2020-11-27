
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="cc" %>
 

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
		
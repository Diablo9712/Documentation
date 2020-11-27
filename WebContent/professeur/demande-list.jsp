
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <%@page import="net.javaguides.usermanagement.web.DB" %>
    <%@page import="java.sql.ResultSet" %>
    <%@page import="java.sql.PreparedStatement" %>
    <%@page import="java.sql.Connection" %>

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
					<h3 class="text-center">Gestion de mes demandes</h3>
					<hr>
					<div class="container text-left">
								 <button type="button" class="btn btn-success" data-toggle="modal"style="float:right" data-target="#myModal">
    Add New Demande
  </button>
					</div>
					<br>
		
			
										<table id="dtHorizontalVerticalExample" class="table table-striped table-bordered table-sm " cellspacing="0" 
  width="100%">
  <thead>
    <tr>
   <th>ID</th>
								<th>Date Demande</th>
							<th>Etat Demande</th>

							<th>Utilisateur</th>
							<th>Document</th>
								<th>Action</th>
    </tr>
  </thead>
  <tbody>
		<%String nd=(String)session.getAttribute("id");  
               %>			
	<%	
	
	Connection cn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	cn = DB.getConnection();
		String sql = "select demande.id as id,demande.date_demande as date,demande.etat as etat,concat(users.first_name,' ',users.last_name) as fullname,document.name from users,document,account,demande where users.id = demande.user and account.permission = 'professeur' and demande.document = document.id and users.id =   "+nd;
		ps = cn.prepareStatement(sql);
		rs = ps.executeQuery();
		while(rs.next()){
		%>
						
							<tr>
								<td><%=rs.getInt(1) %></td>
								<td><%=rs.getString(2) %></td>
								<td><%=rs.getString(3) %></td>
								<td><%=rs.getString(4) %></td>
								<td><%=rs.getString(5) %></td>
							<td>
								<a href="deletedeprofesseur?id=<%=rs.getInt(1) %>" class="btn btn-danger">Delete</a>
								</td>
							</tr>
							<%} %>
						
   
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
          
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        
        <!-- Modal body -->
        <div class="modal-body">
              <div class="card card-primary">
				<div class="row">
				
						<div class="card-body" style="margin-left:10%;margin-right:10%">
								
									<c:if test="${documenttest == null }">
									<form action="insertdprofesseur" method="post" >
									
									</c:if>
									<caption>
											<h2 class="ml16" style="color:red;margin-left:25%">
													<c:if test="${documenttest != null }">
													Edit Document
													</c:if>
														<c:if test="${documenttest == null }">
													Add New Demande
													</c:if>
											
											</h2>
									</caption>
									
									<c:if test="${documenttest != null }">
											<input type="hidden" name="id" value="<c:out value='${documenttest.id }'/>"/>
									</c:if>
									<fieldset class="form-group">
										<label>Date Demande</label>
										<input  type="date" class="form-control" name="date" required="required">
									</fieldset>
									<fieldset class="form-group">
										
										<input  type="hidden" class="form-control" name="etat" value="attente">
									</fieldset>
									<fieldset class="form-group">
										<label>Document Name</label>
									<select class="form-control" name="document">
											<%	

	PreparedStatement pss = null;
	ResultSet rss = null;
	cn = DB.getConnection();
		String sqls = "SELECT * FROM `document`";
		pss = cn.prepareStatement(sqls);
		rss = pss.executeQuery();
		while(rss.next()){
		%>
		<option value="<%=rss.getInt(1) %>"><%=rss.getString(2) %></option>
		<%} %>
										</select>
									</fieldset><br>
									<fieldset class="form-group">
										
										<% String xcv = (String) session.getAttribute("id"); %>
										<input  type="hidden" class="form-control" name="user" value="<%=xcv%>">
									
									
										
									</fieldset><br>
									
									
									
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
		
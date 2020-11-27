
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <%@page import="net.javaguides.usermanagement.web.DB" %>
    <%@page import="java.sql.ResultSet" %>
    <%@page import="java.sql.PreparedStatement" %>
    <%@page import="java.sql.Connection" %>





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
					<h3 class="text-center">Gestion des mes Documents</h3>
					<hr>
					<div class="container text-left">

					</div>
					<br>
		
			
										<table id="dtHorizontalVerticalExample" class="table table-striped table-bordered table-sm " cellspacing="0" 
  width="100%">
  <thead>
    <tr>
   <th>ID</th>
								<th>Document Name</th>
							<th>User Name</th>

							<th>File Name</th>
							<th>Download</th>
    </tr>
  </thead>
  <tbody>
					
	<%
	String nd=(String)session.getAttribute("id");
	Connection cn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	cn = DB.getConnection();
		String sql = "SELECT concat(users.first_name,' ',users.last_name) as fullname, document.name,document_demander.fileName as filename,document_demander.id as id,document_demander.path as path FROM `document_demander`,`document`,`users` where users.id = document_demander.user_id AND document_demander.document_id = document.id and users.id = "+nd;
		ps = cn.prepareStatement(sql);
		rs = ps.executeQuery();
		while(rs.next()){
		%>
						
							<tr>
								<td><%=rs.getInt(4) %></td>
								<td><%=rs.getString(2) %></td>
								<td><%=rs.getString(1) %></td>
								<td><%=rs.getString(3) %></td>
								<td><a href="DownloadServlet?fileName=<%=rs.getString(3)%>" class="btn btn-success">Download</a></td>
							
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
								<c:if test="${documenttest != null }">
									<form action="updateDocDemander" method="post" enctype="multipart/form-data">
									
									</c:if>
									<c:if test="${documenttest == null }">
									<form action="UploadServlet" method="post" enctype="multipart/form-data">
									
									</c:if>
									<caption>
											<h2 class="ml16" style="color:red;margin-left:25%">
													<c:if test="${documenttest != null }">
													Edit Document
													</c:if>
														<c:if test="${documenttest == null }">
													Add New Document
													</c:if>
											
											</h2>
									</caption>
									
									<c:if test="${documenttest != null }">
											<input type="hidden" name="id" value="<c:out value='${documenttest.id }'/>"/>
									</c:if>
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
										<label>User Name</label>
										
									
									
										<select class="form-control" name="user">
											<%	

	PreparedStatement psst = null;
	ResultSet rsst = null;
	cn = DB.getConnection();
		String sqlst = "SELECT distinct users.* FROM `users`,`account` where account.permission !='admin'";
		psst = cn.prepareStatement(sqlst);
		rsst = psst.executeQuery();
		while(rsst.next()){
		%>
		<option value="<%=rsst.getInt(1) %>"><%=rsst.getString(2) %> <%=rsst.getString(3) %> </option>
		<%} %>
										</select>
									</fieldset><br>
									
									<fieldset class="form-group">
										<label>Fichier</label>
										<input  type="file" class="form-control" name="file" required="required">
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
		
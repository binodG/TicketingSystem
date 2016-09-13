<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="site_url" value="${pageContext.request.contextPath}"/>
    <body>
        <div class="pull-right">
            <p>
            </p>
        </div>
        <form class="form-horizontal" role="form" method="post" action="${site_url}/admin/searchmodal">

    <div class="form-group">
        <label class="control-label col-sm-2" for="searchkey">Search Key:</label>
        <div class="col-sm-6">
            <input type="text" name="searchkey" class="form-control col-sm-4" id="searchkey" placeholder="Enter Search Key"/>
        </div>
    </div>



    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-6">
            <button type="submit" class="btn btn-default">Search</button>
        </div>
    </div>


</form>

       
        <table class="table table-hover table-border">
            <tr>
            
             <td>ID</td>
             <td>Modal Title</td>
             <td>Course</td>
             <td>submittedBy</td>
             <td>actions</td>
             
             </tr>
             
              <c:forEach var="modal" items="${retListData}">
                <tr>
                   <td>${modal.modalId}</td>
                   <td>${modal.modalName}</td>
                   <td>${modal.course.courseName}</td>
                   <td>${modal.user.firstName}</td>
                   
              
                     <td><a href="${site_url}/admin/updatemodal/${modal.modalId}" class="btn btn-primary" > <span class="glyphicon glyphicon-pencil"/></a>
                         <a href="${site_url}/admin/deletemodal/${modal.modalId}" class="btn btn-danger"> <span class="glyphicon glyphicon-trash"/></a>
                   </td>
                <tr>
            </c:forEach>
            
            
            
            
        </table>
        
        
       
    </body>
</html>

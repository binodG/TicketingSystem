<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="site_url" value="${pageContext.request.contextPath}"/>
<html>
<head>
<title></title>
</head>

<body>
	
<div id="style_informations">
    
    <c:set var="faculty" value="${retObjData}"/>
<form class="form-horizontal" role="form" method="post" action="${site_url}/admin/editfaculty">
    <input type="hidden" id="hidden" name="hidden" value="${faculty.facultyId}">
    <div class="form-group">
        <label class="control-label col-sm-2" for="faculty">Faculty:</label>
        <div class="col-sm-6">
            <input type="text" name="faculty" class="form-control" id="faculty" value="${faculty.facultyName}" required="required"/>
        </div>
    </div>


    
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-6">
            <button type="submit" class="btn btn-default">Update</button>
        </div>
    </div>


</form>


</div><!-- end of style_informatios -->

</body>
</html>
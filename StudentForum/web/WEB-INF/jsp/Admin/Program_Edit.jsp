<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="site_url" value="${pageContext.request.contextPath}"/>

<html>
<head>
<title></title>
</head>

<body>
	
<div id="style_informations">
    
<c:set var="program" value="${retObjData}"/>

<form class="form-horizontal" role="form" method="post" action="${site_url}/admin/editprogramme">

    <div class="form-group">
        <label class="control-label col-sm-2" for="faculty">Faculty:</label>
        <div class="col-sm-6">
            <select name="faculty" class="form-control" id="faculty" required="required">
                <c:forEach var="option" items="${facultyList}">
                    <option value="${option.facultyId}" <c:if test="${program.faculty.facultyId==option.facultyId}">selected</c:if>>${option.facultyName}</option>
                </c:forEach>
            </select>
        </div>
    </div>

      <input type="hidden" id="hidden" name="hidden" value="${program.programmeId}">
    <div class="form-group">
        <label class="control-label col-sm-2" for="programme">Programme:</label>
        <div class="col-sm-6">
            <input type="text" name="programme" class="form-control" id="programme" placeholder="Enter Programme" value="${program.programmeName}" required="required"/>
        </div>
    </div>
        
      <div class="form-group">
                        <label class="control-label col-sm-2" for="type">Type:</label>
                        <div class="col-sm-10">
                            <label><input type="radio" name="type" class="form-control" value="Year" <c:if test="${program.programmeType=='Year'}">Checked</c:if> id="type"/>Year</label>
                            <label><input type="radio" name="type" class="form-control" value="Semester" <c:if test="${program.programmeType=='Semester'}">Checked</c:if> id="type"/>Semester</label>
                            
                        </div>
                    </div>
    <div class="form-group">
        <label class="control-label col-sm-2" for="num">number of year/semester:</label>
        <div class="col-sm-6">
            <input type="number" name="num" class="form-control" id="num" value="${program.num}" placeholder="Enter Programme" required="required"/>
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
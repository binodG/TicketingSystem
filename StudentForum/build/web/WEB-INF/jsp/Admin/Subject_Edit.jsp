
<html>
<head>
<title></title>
</head>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="site_url" value="${pageContext.request.contextPath}"/>

<body>
	
<div id="style_informations">
 
    
<c:set var="course" value="${objCourse}"/>
<form class="form-horizontal" role="form" method="post" action="${site_url}/admin/editsubject">

    <div class="form-group">
        <label class="control-label col-sm-2" for="programe">Program:</label>
        <div class="col-sm-6">
            <select name="programme" class="form-control" id="programme" >
                <c:forEach var="option" items="${programmeList}">
                    <option value="${option.programmeId}" <c:if test="${course.programme.programmeId==option.programmeId}">selected</c:if>>${option.programmeName}</option>
                </c:forEach>
            </select>
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-sm-2" for="semster">Semester/year:</label>
        <div class="col-sm-6">
            <select name="semester" class="form-control" id="semester" placeholder="Select Semester/Year">
                <c:set value="${1}" var="count" scope="page"/>
                <c:forEach  var="ys" items="${['First','Second','Third','Fourth','Fifth','Sixth','Seventh','Eight']}" >
                    <option value="${count}"><c:out value="${ys}"/></option>
                     <c:set value="${count+1}" var="count" scope="page"/>

                </c:forEach>
               
            </select>
        </div>
    </div>
    
<input type="hidden" id="hidden" name="hidden" value="${course.courseId}">
    
    <div class="form-group">
        <label class="control-label col-sm-2" for="course">course:</label>
        <div class="col-sm-6">
            <input type="text" name="course" class="form-control" id="course" value="${course.courseName}" placeholder="Enter Course" />
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
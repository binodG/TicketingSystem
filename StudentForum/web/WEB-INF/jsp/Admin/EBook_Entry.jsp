
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="<c:url value="/resources/js/jquery.min.js" />"></script>
<c:set var="site_url" value="${pageContext.request.contextPath}"/>

<html>
    <head>
        <title>Add Books</title>
    </head>
    <body>

        <c:if test="${param.q!=null}">
            <div class="alert alert-danger">
                <strong>!!!!</strong>Bookk Name exist, Try new one.
            </div>
        </c:if>
        <form class="form-horizontal" role="form" method="post" action="${site_url}/admin/addbooks" enctype="multipart/form-data">
            <div class="form-group">
                <label class="control-label col-sm-2" for="Type">Type:</label>
                <div class="col-sm-10">
                    <label><input type="radio" name="Type" class="form-control" value="book" checked="checked" id="Type"/>E-Book</label>
                    <label><input type="radio" name="Type" class="form-control" value="modalPaper" id="Type"/>Modal Paper</label>

                </div>
            </div>


            <div class="form-group">
                <label class="control-label col-sm-2" for="faculty">Faculty:</label>
                <div class="col-sm-10">
                    <select name="faculty" class="form-control" id="faculty" required="required" >
                        <c:forEach var="faculty" items="${facList}">        	
                            <option value="${faculty.facultyName}">${faculty.facultyName}</option>

                        </c:forEach>	
                    </select>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-sm-2" for="programme">Programme:</label>
                <div class="col-sm-10">
                    <select name="programme" class="form-control" id="programme" required="required">
                        <c:forEach var="program" items="${progList}">        	
                            <option value="${program.programmeName}">${program.programmeName}</option>
                        </c:forEach>	

                    </select>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-sm-2" for="course">Course</label>
                <div class="col-sm-10">
                    <select name="course" class="form-control" id="course" required="required">
                        <c:forEach var="course" items="${courseList}">        	
                            <option value="${course.courseId}">${course.courseName}</option>
                        </c:forEach>	

                    </select>
                </div>
            </div>


            <div class="form-group">
                <label class="control-label col-sm-2" for="title">Title:</label>
                <div class="col-sm-10">
                    <input type="text" name="title" class="form-control" id="title" required="required"/>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-sm-2" for="description">Description:</label>
                <div class="col-sm-10">
                    <textarea name="description" class="form-control" id="description" required="required" placeholder="Enter Description" rows="3" cols="30"></textarea>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-sm-2" for="file">File:</label>
                <div class="col-sm-10">
                    <input type="file" name="file" class="form-control" id="file" required="required"/>
                </div>
            </div>



            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-default">Upload</button>
                </div>
            </div>


        </form>
    </body>
</html>
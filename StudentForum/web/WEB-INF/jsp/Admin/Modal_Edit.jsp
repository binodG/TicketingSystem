
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="<c:url value="/resources/js/jquery.min.js" />"></script>
<c:set var="site_url" value="${pageContext.request.contextPath}"/>
 
<html>
    <head>
        <title>Add Books</title>
    </head>
    <body>
        
<form class="form-horizontal" role="form" method="post" action="${site_url}/admin/editmodal" enctype="multipart/form-data">
                   
    <input type="hidden" id="hidden" name="hidden" value="${objModal.modalId}"/>
                   <div class="form-group">
                        <label class="control-label col-sm-2" for="course">Course</label>
                        <div class="col-sm-10">
                            <select name="course" class="form-control" id="course" required="required">
                                <c:forEach var="course" items="${courseList}">        	
                                    <option value="${course.courseId}" <c:if test="${objModal.course.courseId==course.courseId}">selected</c:if>   >${course.courseName}</option>
                                </c:forEach>	
                        
                            </select>
                        </div>
                    </div>


                    <div class="form-group">
                        <label class="control-label col-sm-2" for="title">Title:</label>
                        <div class="col-sm-10">
                            <input type="text" name="title" class="form-control" id="title" value="${objModal.modalName}" required="required"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-sm-2" for="description">Description:</label>
                        <div class="col-sm-10">
                            <textarea name="description" class="form-control" id="description" value="${objModal.description}"placeholder="Enter Description" rows="3" cols="30" required="required"></textarea>
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
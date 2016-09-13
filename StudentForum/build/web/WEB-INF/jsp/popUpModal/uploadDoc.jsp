<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="site_url" value="${pageContext.request.contextPath}"/>
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">
    <span>Upload</span>
</button>
<!-- Modal -->
<div id="myModal" class="modal fade" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Upload File</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" role="form" method="post" action="${site_url}/fileupload" enctype="multipart/form-data">
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="Type">Type:</label>
                        <div class="col-sm-10">
                            <label><input type="radio" name="Type" class="form-control" value="book" id="Type" checked="checked"/>E-Book</label>
                            <label><input type="radio" name="Type" class="form-control" value="modalPaper" id="Type" required="required"/>Modal Paper</label>

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
                        <label class="control-label col-sm-2" for="programme">Program:</label>
                        <div class="col-sm-10">
                            <select name="programme" class="form-control" id="programme" >
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
                            <textarea name="description" class="form-control" id="description" placeholder="Enter Description" rows="3" cols="30" required="required"></textarea>
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
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>

    </div>
</div>



<html>
<head>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <c:set var="site_url" value="${pageContext.request.contextPath}"/>
    <script src="<c:url value="/resources/js/angular.min.js"/>"></script>
    <link href="<c:url value="/resources/css/core.css"/>" rel="stylesheet" />
    <script src="<c:url value="/resources/js/adminjs/course.js"/>"></script>
</head>

<body>
	
<div id="style_informations">
 
<c:if test="${param.q!=null}">
                <div class="alert alert-danger">
                    <strong>!!!!</strong>Course Name exist, Try new one.
                </div>
 </c:if>
<form class="form-horizontal" role="form" method="post" action="${site_url}/admin/insertsubject">

    <div class="form-group">
        <label class="control-label col-sm-2" for="programe">Program:</label>
        <div class="col-sm-6">
            <select name="programme" class="form-control" id="programme" >
                <c:forEach var="option" items="${programmeList}">
                  <option value="${option.programmeId}">${option.programmeName}</option>
                </c:forEach>
            </select>
        </div>
    </div>
<div class="form-group">
        <label class="control-label col-sm-2" for="semster">Semester/year:</label>
        <div class="col-sm-6">
            <select name="semester" class="form-control" id="semester" placeholder="Select Semester/Year">
               <option value="1">First</option>
               <option value="2">Second</option>
               <option value="3">Third</option>
               <option value="4">Fourth</option>
               <option value="5">Fifth</option>
               <option value="6">Sixth</option>
               <option value="7">Seventh</option>
               <option value="8">Eighth</option>
               
            </select>
        </div>
    </div>
    
    

    <div class="form-group">
        <label class="control-label col-sm-2" for="course">course:</label>
        <div class="col-sm-6">
            <input type="text" name="course" class="form-control" id="course" placeholder="Enter Course" />
        </div>
    </div>
    
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-6">
            <button type="submit" class="btn btn-default">Submit</button>
        </div>
    </div>
</form>
 <div  ng-app="courseApp" ng-controller="courseCtrl">
            <div ng-cloak>
            <select class="form-group" ng-model="limits">
            <option>5</option>
            <option>10</option>
            <option>15</option>
            <option>20</option>
            <option value="">All</option>
            
           </select>
           <table class="table table-border table-border">
                
                    <th ng-click="sort('id')">Course Id
                    <span class="glyphicon sort-icon" ng-show="sortKey==='id'" ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span>
                    </th>
                    <th ng-click="sort('courseName')">Course Name
                     <span class="glyphicon sort-icon" ng-show="sortKey==='courseName'" ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span>
                   </th>
                   <th>Year/semester
                   </th>
                    <th ng-click="sort('programeName')">Program Name
                     <span class="glyphicon sort-icon" ng-show="sortKey==='programName'" ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span>
                   </th>
                   <th ng-click="sort('facultyName')">Faculty Name
                     <span class="glyphicon sort-icon" ng-show="sortKey==='programName'" ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span>
                   </th>
                

                <tr ng-repeat="course in courses|orderBy:sortKey:reverse|limitTo:limits">
                    <td >{{course.courseId}}</td>
                    <td>{{course.courseName}}</td>
                                       <td >{{course.semester}}</td>
                                       <td >{{course.programme.programmeName}}</td>
 
                    <td>{{course.programme.faculty.facultyName}}</td>
                </tr>

            </table>
       </div>
        </div>



</div><!-- end of style_informatios -->

</body>
</html>
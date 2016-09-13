<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="site_url" value="${pageContext.request.contextPath}"/>
<html>
    <head>
        <script src="<c:url value="/resources/js/angular.min.js"/>"></script>
        <link href="<c:url value="/resources/css/core.css"/>" rel="stylesheet" />
        <script src="<c:url value="/resources/js/adminjs/course.js"/>"></script>
    </head>
    <body>
        <div class="pull-right">
            <p>
            </p>
        </div>

        <noscript>
        <form class="form-horizontal" role="form" method="post" action="${site_url}/admin/searchsubject">

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

                <td>SN</td>
                <td>Faculty</td>
                <td>programme</td>
                <td>Semester</td>
                <td>Course</td>
                <td>actions</td>
            </tr>

            <c:forEach var="course" items="${retListData}">

                <tr>
                    <td>${course.courseId}</td>
                    <td>${course.programme.faculty.facultyName}</td>
                    <td>${course.programme.programmeName}</td>
                    <td>${course.semester}</td>                   
                    <td>${course.courseName}</td>

                    <td><a href="${site_url}/admin/updatesubject/${course.courseId}" class="btn btn-primary" > <span class="glyphicon glyphicon-pencil"/></a>
                        <a href="${site_url}/admin/deletesubject/${course.courseId}" class="btn btn-danger"> <span class="glyphicon glyphicon-trash"/></a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        </noscript>
<div  ng-app="courseApp" ng-controller="courseCtrl">
            <div ng-cloak>
                <form class="form-horizontal" role="" method="" action="">
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="searchkey">Search Key:</label>
                        <div class="col-sm-6">
                            <input type="text" name="searchkey" class="form-control col-sm-4" id="searchkey" ng-model="search" placeholder="Search"/>
                        </div>
                    </div>

                </form>
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
                   
                    <th ng-click="sort('programeName')">Program Name
                     <span class="glyphicon sort-icon" ng-show="sortKey==='programName'" ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span>
                   </th>
                   <th>Year/semester
                   </th>
                 
                   
                   <th ng-click="sort('facultyName')">Faculty Name
                     <span class="glyphicon sort-icon" ng-show="sortKey==='programName'" ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span>
                   </th>
                  <th>action</th>

                <tr ng-repeat="course in courses|orderBy:sortKey:reverse|limitTo:limits|filter:search">
                    <td >{{course.courseId}}</td>
                    <td>{{course.courseName}}</td>
                    <td >{{course.programme.programmeName}}</td>
                    <td >{{course.semester}}</td>
                    <td>{{course.programme.faculty.facultyName}}</td>
                    <td><a href="${site_url}/admin/updatesubject/{{course.courseId}}" class="btn btn-primary" > <span class="glyphicon glyphicon-pencil"/></a>
                        <a href="${site_url}/admin/deletesubject/{{course.courseId}}" class="btn btn-danger"> <span class="glyphicon glyphicon-trash"/></a>
                    </td>
                </tr>

            </table>
       </div>
        </div>



    </body>
</html>

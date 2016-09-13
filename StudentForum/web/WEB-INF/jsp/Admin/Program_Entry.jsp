<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="site_url" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <script src="<c:url value="/resources/js/angular.min.js"/>"></script>
    <link href="<c:url value="/resources/css/core.css"/>" rel="stylesheet" />
    <script src="<c:url value="/resources/js/adminjs/program.js"/>"></script>
</head>

<body>
<c:if test="${param.q!=null}">
                <div class="alert alert-danger">
                    <strong>!!!!</strong>Program Name exist, Try new one.
                </div>
 </c:if>	
<div id="style_informations">
 <form class="form-horizontal" role="form" method="post" action="${site_url}/admin/insertprogramme">

    <div class="form-group">
        <label class="control-label col-sm-2" for="faculty">Faculty:</label>
        <div class="col-sm-6">
            <select name="faculty" class="form-control" id="faculty" required="required">
                <c:forEach var="option" items="${facultyList}">
                  <option value="${option.facultyId}">${option.facultyName}</option>
                </c:forEach>
            </select>
        </div>
    </div>


    <div class="form-group">
        <label class="control-label col-sm-2" for="programme">Programme:</label>
        <div class="col-sm-6">
            <input type="text" name="programme" class="form-control" id="programme" placeholder="Enter Programme" required="required"/>
        </div>
    </div>
    
     <div class="form-group">
                        <label class="control-label col-sm-2" for="type">Type:</label>
                        <div class="col-sm-10">
                            <label><input type="radio" name="type" class="form-control" value="Year" id="type" checked/>Year</label>
                            <label><input type="radio" name="type" class="form-control" value="Semester" id="type"/>Semester</label>
                            
                        </div>
                    </div>
    <div class="form-group">
        <label class="control-label col-sm-2" for="num">year/semester:</label>
        <div class="col-sm-6">
            <input type="number" name="num" class="form-control" id="num" required="required"/>
        </div>
    </div>

    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-6">
            <button type="submit" class="btn btn-default">Submit</button>
        </div>
    </div>
</form>

  <div  ng-app="programApp" ng-controller="programCtrl">
            <div ng-cloak>
            <select class="form-group" ng-model="limits">
            <option>5</option>
            <option>10</option>
            <option>15</option>
            <option>20</option>
            <option value="">All</option>
            
           </select>
           <table class="table table-border table-border">
                
                    <th ng-click="sort('id')">Program Id
                    <span class="glyphicon sort-icon" ng-show="sortKey==='id'" ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span>
                    </th>
                    <th ng-click="sort('programName')">Program Name
                     <span class="glyphicon sort-icon" ng-show="sortKey==='programName'" ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span>
                   </th>
                   <th>Year/semester
                   </th>
                    <th ng-click="sort('faculty')">Faculty Name
                     <span class="glyphicon sort-icon" ng-show="sortKey==='faculty'" ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span>
                   </th>
                

                <tr ng-repeat="program in programmes|orderBy:sortKey:reverse|limitTo:limits">
                    <td >{{program.programmeId}}</td>
                    <td>{{program.programmeName}}</td>
                    <td >{{program.num}}</td>
                    <td>{{program.faculty.facultyName}}</td>
                </tr>

            </table>
       </div>
        </div>


</div><!-- end of style_informatios -->

</body>
</html>
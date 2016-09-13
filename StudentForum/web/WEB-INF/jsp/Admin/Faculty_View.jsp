<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="site_url" value="${pageContext.request.contextPath}"/>
<html 
    <head>
        <title>Faculty</title>
        <script src="<c:url value="/resources/js/angular.min.js"/>"></script>
        <link href="<c:url value="/resources/css/core.css"/>" rel="stylesheet" />
        <script src="<c:url value="/resources/js/adminjs/faculty.js"/>"></script>
    </head>
    
    <body>
    <noscript>
    <form class="form-horizontal" role="form" method="post" action="${site_url}/admin/searchfaculty">
    <div class="form-group">
        <label class="control-label col-sm-2" for="searchkey">Search Key:</label>
        <div class="col-sm-6">
            <input type="text" name="searchkey" class="form-control col-sm-4" id="searchkey"  placeholder="Enter Search Key"/>
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
            <td>Faculty</td>
            <td>Action</td>
            </tr>
        
        <c:forEach var="fac" items="${retListData}">
            <tr>
            <td>${fac.facultyId}</td>
            <td>${fac.facultyName}</td>
            <td>
            <a href="${site_url}/admin/updatefaculty/${fac.facultyId}" class="btn btn-primary" > <span class="glyphicon glyphicon-pencil"/></a>
            <a href="${site_url}/admin/deletefaculty/${fac.facultyId}" class="btn btn-danger"> <span class="glyphicon glyphicon-trash"/></a>
            </td>
            <tr>
        </c:forEach >
    </table>
    </noscript>    
        
    
    <div  ng-app="facultyApp" ng-controller="facultyCtrl">
            <div ng-cloak>
    <form class="form-horizontal" role="form" method="post" action="${site_url}/admin/searchfaculty">
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
                
                    <th ng-click="sort('id')">Faculty ID
                    <span class="glyphicon sort-icon" ng-show="sortKey==='id'" ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span>
                    </th>
                    <th ng-click="sort('facultyName')">Faculty Name
                     <span class="glyphicon sort-icon" ng-show="sortKey==='facultyName'" ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span>
                   </th>
                

                <tr ng-repeat="faculty in faculties|orderBy:sortKey:reverse|limitTo:limits|filter:search">
                    <td >{{faculty.facultyId}}</td>
                    <td>{{faculty.facultyName}}</td>
                    <td>
            <a href="${site_url}/admin/updatefaculty/{{faculty.facultyId}}" class="btn btn-primary" > <span class="glyphicon glyphicon-pencil"/></a>
            <a href="${site_url}/admin/deletefaculty/{{faculty.facultyId}}" class="btn btn-danger"> <span class="glyphicon glyphicon-trash"/></a>
            </td>
                </tr>

            </table>
       </div>
        </div>

       
    </body>
</html>

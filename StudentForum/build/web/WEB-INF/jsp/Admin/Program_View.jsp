<html>
    <head>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <c:set var="site_url" value="${pageContext.request.contextPath}"/>
        <script src="<c:url value="/resources/js/angular.min.js"/>"></script>
        <link href="<c:url value="/resources/css/core.css"/>" rel="stylesheet" />
        <script src="<c:url value="/resources/js/adminjs/program.js"/>"></script>
    </head>        
    <body>
        <div class="pull-right">
            <p>
            </p>
        </div>

        <noscript>    
        <form class="form-horizontal" role="form" method="post" action="${site_url}/admin/searchprogramme">

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

                <td>ID</td>
                <td>Programme</td>
                <td>Year/Semester</td>
                <td>Faculty</td>
                <td>actions</td>
            </tr>

            <c:forEach var="prog" items="${retListData}">

                <tr>
                    <td>${prog.programmeId}</td>
                    <td>${prog.programmeName}</td>
                    <td>${prog.num}</td>
                    <td>${prog.faculty.facultyName}</td>


                    <td><a href="${site_url}/admin/updateprogramme/${prog.programmeId}" class="btn btn-primary" > <span class="glyphicon glyphicon-pencil"/></a>
                        <a href="${site_url}/admin/deleteprogramme/${prog.programmeId}" class="btn btn-danger"> <span class="glyphicon glyphicon-trash"/></a>
                    </td>
                <tr>
                </c:forEach>




        </table>
        </noscript>     

        <div  ng-app="programApp" ng-controller="programCtrl">
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

                    <th ng-click="sort('id')">Program Id
                        <span class="glyphicon sort-icon" ng-show="sortKey === 'id'" ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span>
                    </th>
                    <th ng-click="sort('programName')">Program Name
                        <span class="glyphicon sort-icon" ng-show="sortKey === 'programName'" ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span>
                    </th>
                    <th>Year/semester
                    </th>
                    <th ng-click="sort('faculty')">Faculty Name
                        <span class="glyphicon sort-icon" ng-show="sortKey === 'programName'" ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span>
                    </th>
                    <th>actions</th>

                    <tr ng-repeat="program in programmes|orderBy:sortKey:reverse|limitTo:limits|filter:search">
                        <td >{{program.programmeId}}</td>
                        <td>{{program.programmeName}}</td>
                        <td >{{program.num}}</td>
                        <td>{{program.faculty.facultyName}}</td>
                        <td><a href="${site_url}/admin/updateprogramme/{{program.programmeId}}" class="btn btn-primary" > <span class="glyphicon glyphicon-pencil"/></a>
                            <a href="${site_url}/admin/deleteprogramme/{{program.programmeId}}" class="btn btn-danger"> <span class="glyphicon glyphicon-trash"/></a>
                        </td>
                    </tr>

                </table>
            </div>
        </div>



    </body>
</html>

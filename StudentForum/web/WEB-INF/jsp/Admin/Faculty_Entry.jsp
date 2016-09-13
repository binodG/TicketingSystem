<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="site_url" value="${pageContext.request.contextPath}"/>
<html 
    <head>
        <title>Faculty</title>
        <script src="<c:url value="/resources/js/angular.min.js"/>"></script>
        <link href="<c:url value="/resources/css/core.css"/>" rel="stylesheet" />
        <script src="<c:url value="/resources/js/adminjs/faculty.js"/>"></script>
    </head>

    <body>	    
        <div id="style_informations">

            <c:if test="${param.q!=null}">
                <div class="alert alert-danger">
                    <strong>!!!!</strong>Faculty Name exist, Try new one.
                </div>
            </c:if>
            <div>
                <form class="form-horizontal" name="myForm" method="post" action="${site_url}/admin/insertFaculties">
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="faculty">Faculty:</label>
                        <div class="col-sm-6">
                            <input type="text" name="faculty" class="form-control" placeholder="Enter Faculty"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-6">
                            <button type="submit" class="btn btn-default">Add Faculty</button>
                        </div>
                    </div>
                </form>
            </div>
        </div><!-- end of style_informatios -->


        <div  ng-app="facultyApp" ng-controller="facultyCtrl">
            <div ng-cloak>
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
                

                <tr ng-repeat="faculty in faculties|orderBy:sortKey:reverse|limitTo:limits">
                    <td >{{faculty.facultyId}}</td>
                    <td>{{faculty.facultyName}}</td>
                </tr>

            </table>
       </div>
        </div>


              

    </body>
</html>
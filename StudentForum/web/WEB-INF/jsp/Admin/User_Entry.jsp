<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="site_url" value="${pageContext.request.contextPath}"/>


<html>
    <head>
        <title></title>
        <script src="<c:url value="/resources/js/angular.min.js"/>"></script>
        <script src="<c:url value="/resources/js/ValidationControl.js"/>"></script>

    </head>

    <body>

        <div id="style_informations">

            <c:if test="${param.q!=null}">
                <div class="alert alert-danger">
                    <strong>!!!!</strong>Username already exist, Try new one.
                </div>
            </c:if>
            <form class="form-horizontal" ng-app="myApp" ng-controller="validateCtrl" 
                  name="myForm" method="post" action="${site_url}/admin/adduser">
                <div class="form-group">
                    <label class="control-label col-sm-2" for="firstName">First Name:</label>
                    <div class="col-sm-6">
                        <input type="text" name="firstName" class="form-control" id="firstName" placeholder="Enter FirstName" required="required"/>
                    </div>
                </div>


                <div class="form-group">
                    <label class="control-label col-sm-2" for="lastName">Last Name:</label>
                    <div class="col-sm-6">
                        <input type="text" name="lastName" class="form-control" id="lastName" placeholder="Enter LastName" required="required"/>
                    </div>
                </div>


                <div class="form-group">
                    <label class="control-label col-sm-2" for="username">Username:</label>
                    <div class="col-sm-6">
                        <input type="text" name="username" class="form-control" id="username" placeholder="Enter Username" required="required"/>
                    </div>
                </div>


                <div class="form-group">
                    <label class="control-label col-sm-2" for="password">Password:</label>
                    <div class="col-sm-6">
                        <input type="password" name="password" class="form-control" id="password" placeholder="Enter password" required="required"/>
                    </div>
                </div>





                <div class="form-group">
                    <label class="control-label col-sm-2" for="email">Email:</label>
                    <div class="col-sm-6">
                        <input type="email" name="email" class="form-control" ng-model="email" id="email" placeholder="Enter Email"  required="required" />
                        <span style="color:red" ng-show="myForm.email.$dirty && myForm.email.$invalid">
                            <span ng-show="myForm.email.$error.email">Invalid email address.</span>
                        </span>
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-sm-2" for="role">Role:</label>
                    <div class="col-sm-6">
                        <Select name="role" class="form-control" id="role" placeholder="Select Role"  required="required" >
                            <option value="ADMIN">Admin</option>
                            <option value="USERS">Users</option>
                        </select>
                    </div>
                </div>


                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-6">
                        <button type="submit" class="btn btn-default">Add Account</button>
                    </div>
                </div>


            </form>


        </div><!-- end of style_informations -->

    </body>
</html>
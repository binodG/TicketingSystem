<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="site_url" value="${pageContext.request.contextPath}"/>
<link href="<c:url value="/resources/css/userLogin.css" />" rel="stylesheet">
        

<html>
    <head>
        <title>Create Account</title>
        <link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
        <script src="<c:url value="/resources/js/angular.min.js"/>"></script>
        <script src="<c:url value="/resources/js/ValidationControl.js"/>"></script>
    </head>

    <body>
        <section class="content">
            <div class="container">
                <c:if test="${param.q!=null}">
                    <div class="alert alert-danger">
                        <strong>!!!!</strong>Username exist, Try new one.
                    </div>
                </c:if>
                
         <div class="login-page">
            <div class="form">
                <form class="form-horizontal" ng-app="myApp" ng-controller="validateCtrl" 
                          name="myForm" method="post" action="${site_url}/login/signup" enctype="multipart/form-data">
                   
                    <input type="text" name="firstName" id="firstName" placeholder="First Name" required/>
                    <input type="text" name="lastName" id="lastName" placeholder="Last Name"  required="required"/>
                    <input type="text" name="username"  id="username"  placeholder="username" required="required"/>
                    <input type="password" name="password"  id="password"  placeholder="password" required="required"/>
                    <input type="email" name="email" ng-model="email" id="email" placeholder="Email"  required="required" />
                    <span style="color:red" ng-show="myForm.email.$dirty && myForm.email.$invalid">
                    <span ng-show="myForm.email.$error.email">Invalid email address.</span>
                    </span>
                    <button type="submit" class="btn btn-default" ng-disabled="myForm.email.$dirty && myForm.email.$invalid">Create Account</button>
                        

                          
                      </form>
            </div>
        </div>
       
                
            </div>
        </section>







    </body>
</html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="site_url" value="${pageContext.request.contextPath}"/>

<html>
<head>
<title></title>
</head>

<body>
	
<div id="style_informations">
    
    <c:set var="user" value="${retObjData}"/>
<form class="form-horizontal" role="form" method="post" action="${site_url}/admin/edituser">
 <input type="hidden" id="hidden" name="hidden" value="${user.userId}">
   
    <div class="form-group">
        <label class="control-label col-sm-2" for="firstName">First Name:</label>
        <div class="col-sm-6">
            <input type="text" name="firstName" class="form-control" id="firstName" value="${user.firstName}"placeholder="Enter FirstName" required="required"/>
        </div>
    </div>


    <div class="form-group">
        <label class="control-label col-sm-2" for="lastName">Last Name:</label>
        <div class="col-sm-6">
            <input type="text" name="lastName" class="form-control" id="lastName" placeholder="Enter LastName" value="${user.lastName}" required="required"/>
        </div>
    </div>


    <div class="form-group">
        <label class="control-label col-sm-2" for="username">Username:</label>
        <div class="col-sm-6">
            <input type="text" name="username" class="form-control" id="username" value="${user.username}" placeholder="Enter Username" required="required"/>
        </div>
    </div>


    <div class="form-group">
        <label class="control-label col-sm-2" for="password">Password:</label>
        <div class="col-sm-6">
            <input type="password" name="password" class="form-control" id="password" value="${user.password}" placeholder="Enter password" required="required"/>
        </div>
    </div>


    


    <div class="form-group">
        <label class="control-label col-sm-2" for="email">Email:</label>
        <div class="col-sm-6">
            <input type="text" name="email" class="form-control" id="email" placeholder="Enter Email" value="${user.email}" required="required" />
        </div>
    </div>

    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-6">
            <button type="submit" class="btn btn-default">Update Account</button>
        </div>
    </div>


</form>


</div><!-- end of style_informations -->

</body>
</html>
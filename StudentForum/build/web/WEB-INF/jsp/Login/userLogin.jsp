<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="site_url" value="${pageContext.request.contextPath}"/>
<html>
    <head>
        <title>Project</title>
        <!--Style sheet-->
        <link href="<c:url value="/resources/css/userLogin.css" />" rel="stylesheet">
        <title>Login</title>
    </head>
    <body>
        <div class="login-page">
            <div class="form">
                <form class="login-form"  method="post" action="${site_url}/loggedIn">
                    <input type="text" name="username" placeholder="username" required="required"/>
                    <input type="password" name="password"placeholder="password" required="required"/>
                    <button>login</button>
                    <p class="message">Not registered? <a href="${site_url}/signup">Create an account</a></p>
                </form>
            </div>
        </div>
        
        
    </body>
</html>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="site_url" value="${pageContext.request.contextPath}"/>


<html>
    <head>
        <title>Project</title>
        <!--Jquery-->
        <script src="<c:url value="/resources/js/jquery.min.js" />"></script>
        <script src="<c:url value="/resources/js/bootstrap.js" />"></script>

        <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


        <!--Style sheet-->
        <link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/css/core.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/css/responsive.css" />" rel="stylesheet">


    </head>

    <body>
        <!--Header Starts Here-->

        <header class="header">
            <div class="container">
                <div class="row">
                    <div class="col-xs-12 col-sm-3 col-md-4"><a id="logo" href="index.html"><img src="<c:url value="/resources/images/logo.jpg"/>" class="img-responsive" alt="" title="wordpress"></a> </div>
                    <div class="col-xs-12 col-sm-9 col-md-8">
                        <%@include file="../../shared/Header.jsp" %>
                    </div>
                </div>
            </div>
            <section class="banner">
                <img src="<c:url value="/resources/images/group1.jpg"/>" alt="" class="img-responsive">

                <div class="container">
                    <div class="bannerText">
                        <div class="row">
                            <div class="col-lg-12">
                                <h2>Discuss Group</h2>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-12">
                                <p></p>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <div class="col-md-8">
            </div>
            <div class="col-md-4">
                <div class="col-md-8"></div>
                <div class="col-md-4">
                    <a href="${site_url}/signup" class="btn btn-info" role="button">Register</a>
                </div>
            </div>
        </header>
        <!--Header  Ends Here--> 
        <!-- Content  Starts Here-->
        <section class="content">
            <div class="container">
                <div class="col-md-8">
                    <div class="panel panel-info">
                        <h1 class="label label-primary">Recent Questions</h1>
                        <div class="panel-body">

                            <div>
                                <c:forEach var="question" items="${questionList}" begin="0" end="10" step="1">

                                    <!--Main panel-->
                                    <div class="panel panel-info">
                                        <!--Sub Panel Title-->
                                        <div class="panel-heading">
                                            ${question.title}
                                            <a href="${site_url}/discuss/answer/${question.questionId}"><span class="badge">${question.noOFanswer}</span>
                                                <br> Reply
                                                <span class="glyphicon glyphicon-pencil"/> 
                                            </a>
                                        </div>
                                        <!--End of  sub panel title-->
                                        <!--sub panel Body-->
                                        <div class="panel-body">
                                            <!--user pic section-->
                                            <div class="col-sm-2">
                                                <c:if test="${not empty question.user.image}">
                                                    <img src="${site_url}/display?image=${question.user.image}" class="img-circle" alt="Cinque Terre" width="50" height="50"><br>
                                                </c:if>
                                                <c:if test="${empty question.user.image}">
                                                    <img src="<c:url var="/resources/images/user.jpg"/>" class="img-circle" alt="Cinque Terre" width="50" height="50"><br>
                                                </c:if>
                                                ${question.user.username}
                                            </div>
                                            <!--end of user pic section-->
                                            <!--Description section-->
                                            <div class="col-md-8">
                                                <div class="read-more">
                                                    <p>${fn:substring(question.question,0, 140)}.........
                                                        <a href="${site_url}/discuss/answer/${question.questionId}"> Read more
                                                            <span class="glyphicon glyphicon-pencil"/> 
                                                        </a>
                                                </div>
                                            </div>
                                            <!--End of Description section-->
                                            <!--submitted date--> 
                                            <div class="col-md-2">
                                                <span class="glyphicon glyphicon-time"></span><br>
                                                <fmt:formatDate pattern="yyyy-MM-dd" value="${question.submittedDate}" />

                                            </div>
                                            <!--End of submitted date-->

                                        </div>
                                        <!--End of sub panel body-->
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                </div>
                <!--Forum Statistic-->
                <div class="col-md-4">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">Forum Statistic</h3>
                        </div>
                        <div class="panel-body">
                            <h2><c:out value="${member}"/> <small>Members</small></h2> 
                            <h2><c:out value="${posts}"/> <small>Posts</small></h2> 
                        </div>
                    </div>
                </div>
                <!--End of Forum Statistic-->          
                <!--How to-->
                <div class="col-md-4">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">How to upload files</h3>
                        </div>
                        <div class="panel-body">
                            <div class="caption">
                                <h4></h4>
                                <p>-First login with your username and password. If you don't have create an account<br>
                                    -Go to your dashboard and click upload button<br>
                                    -now select file and Fill up the form and click upload </p>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-md-4">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">how to download files</h3>
                        </div>
                        <div class="panel-body">
                            <div class="caption">
                                <p>-Go to faculties<br>
                                    - Select faculties and it will redirect to gallery
                                    - Choose the file you wand to download and click download</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>





            <div class="row">
                <div class="col-lg-12">
                    <h2 class="heading"> </h2>
                </div>
            </div>



            <div class="row">



                <!-- Footer  Starts Here-->
                <%@include file="../../shared/footer.jsp" %>
                <!-- Footer  Ends Here-->
            </div>

        </section>

        <!--Content  Ends Here--> 


    </body>
</html>

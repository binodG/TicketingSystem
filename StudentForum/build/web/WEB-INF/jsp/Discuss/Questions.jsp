<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="site_url" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        <!--Jquery-->
        <script src="<c:url value="/resources/js/jquery.min.js" />"></script>
        <script src="<c:url value="/resources/js/bootstrap.js" />"></script>

        <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>


        <!--Style sheet-->
        <link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/css/core.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/css/responsive.css" />" rel="stylesheet">



        <title>Page</title>
    </head>
    <body>
        <!--Header Starts here-->
        <div class="container">
            <div class="row">
                <div class="container">
                    <div class="row">
                        <div class="col-xs-12 col-sm-3 col-md-4"><a id="logo" href="index.html"><img src="<c:url value="/resources/images/logo.jpg"/>" class="img-responsive" alt="" title="wordpress"></a> </div>
                        <div class="col-xs-12 col-sm-9 col-md-8">
                            <%@include file="../../shared/Header.jsp" %>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--Header Ends here-->

        <div class="container-fluid">

            <div class="row">
                <div class="col-lg-4 col-lg-offset-8">
                    <form  class="form-horizontal"   action="${site_url}/searchquestion" method='POST'>
                        <div class="col-md-8">
                            <input type="text" name="searchkey" class="form-control col-sm-4" placeholder="Search Question"/>
                        </div>
                        <div class="col-md-4">
                            <button type="submit" class="btn btn-default">Search</button>

                        </div>


                    </form>
                </div>
            </div>
            <div class="row">
                <c:forEach var="question" items="${attList}" >
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
        <!-- Footer  Starts Here-->
        <%@include file="../../shared/footer.jsp" %>
        <!-- Footer  Ends Here-->

    </body>
</html>

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
        </div> <!--Header  Ends Here--> 
        <!--Content-->
        <div class="row">



            <div class="col-md-6">

                <div class="panel panel-info">
                    <h1 class="label label-primary">Books</h1>
                    <div class="panel-body">
                        <c:forEach var="book" items="${bookList}">
                            <!--Main panel-->
                            <div class="panel panel-info">
                                <!--Sub Panel Title-->
                                <div class="panel-heading">
                                    ${book.ebookName}
                                </div>
                                <!--End of  sub panel title-->
                                <!--sub panel Body-->
                                <div class="panel-body">
                                    <!--user pic section-->
                                    <div class="col-sm-2">
                                        <c:if test="${not empty book.user.image}">
                                            <img src="${site_url}/display?image=${book.user.image}" class="img-circle" alt="Cinque Terre" width="50" height="50"><br>
                                        </c:if>
                                        <c:if test="${empty book.user.image}">
                                            <img src="<c:url var="/resources/images/user.jpg"/>" class="img-circle" alt="Cinque Terre" width="50" height="50"><br>
                                        </c:if>





                                        ${book.user.username}
                                    </div>
                                    <!--end of user pic section-->
                                    <!--Description section-->
                                    <div class="col-md-8">
                                        <div class="read-more">
                                            <p>${book.description}</p>
                                            <a href="${site_url}/download/${book.ebookId}" class="btn btn-primary readMore roundBtn" role="button" download="">download</a>
                                        </div>
                                    </div>
                                    <!--End of Description section-->
                                    <!--submitted date--> 
                                    <div class="col-md-2">
                                        <span class="glyphicon glyphicon-time"></span><br>
                                        <fmt:formatDate pattern="yyyy-MM-dd" value="${book.addedDate}" />

                                    </div>
                                    <!--End of submitted date-->

                                </div>
                                <!--End of sub panel body-->
                            </div>

                        </c:forEach>
                    </div>
                </div>
            </div>



            <div class="col-md-6">

                <div class="panel panel-info">
                    <h1 class="label label-primary">Modal Questions</h1>
                    <div class="panel-body">
                        <c:forEach var="modal" items="${modalList}">
                            <!--Main panel-->
                            <div class="panel panel-info">
                                <!--Sub Panel Title-->
                                <div class="panel-heading">
                                    ${modal.modalName}
                                </div>
                                <!--End of  sub panel title-->
                                <!--sub panel Body-->
                                <div class="panel-body">
                                    <!--user pic section-->
                                    <div class="col-sm-2">
                                        <c:if test="${not empty modal.user.image}">
                                            <img src="${site_url}/display?image=${modal.user.image}" class="img-circle" alt="Cinque Terre" width="50" height="50"><br>
                                        </c:if>
                                        <c:if test="${empty modal.user.image}">
                                            <img src="<c:url var="/resources/images/user.jpg"/>" class="img-circle" alt="Cinque Terre" width="50" height="50"><br>
                                        </c:if>
                                        ${modal.user.username}
                                    </div>
                                    <!--end of user pic section-->
                                    <!--Description section-->
                                    <div class="col-md-8">
                                        <div class="read-more">
                                            <p>${modal.description}</p>
                                            <a href="${site_url}/download/${modal.modalId}" class="btn btn-primary readMore roundBtn" role="button" download="">download</a>
                                        </div>
                                    </div>
                                    <!--End of Description section-->
                                    <!--submitted date--> 
                                    <div class="col-md-2">
                                        <span class="glyphicon glyphicon-time"></span><br>
                                        <fmt:formatDate pattern="yyyy-MM-dd" value="${modal.addedDate}" />

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
        <!--End of Content-->


        <!-- Footer  Starts Here-->
        <%@include file="../../shared/footer.jsp" %>
        <!-- Footer  Ends Here-->

    </body>
</html>

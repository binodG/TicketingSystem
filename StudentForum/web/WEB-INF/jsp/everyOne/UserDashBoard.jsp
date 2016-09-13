<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/css/core.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/css/switchTab.css" />" rel="stylesheet">
        <script src="<c:url value="/resources/js/switchTab.js"/>"></script>
        <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>

        <c:set var="site_url" value="${pageContext.request.contextPath}"/>
        <c:set var="user" value="${sessionScope.USER}"/>


        <title>Page</title>
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
        </div>


        <!--Header  Ends Here--> 
        <!--Contents Starts Here-->

        <section class="content">
            <div class="container">
                <div class="col-md-2">
                    <div class="row">
                        <!--Thumbnail-->
                        <img src="${site_url}/display?image=${user.image}" class="img-thumbnail" alt="" width="150" height="200">
                        <%@include file="../popUpModal/uploadImage.jsp"%>



                        <div class="panel panel-default">
                            <div class="panel-heading">About</div>
                            <div class="panel-body">
                                <h3><small>Name:</small></h3> ${user.firstName} ${user.lastName}<br>

                                <h3><small>Email:</small></h3>${user.email}<br>

                            </div>
                        </div>
                        <!--End of Thumbnail-->
                    </div>
                </div>
                <div class="col-md-8">
                    <ul class="tab">
                        <li role="presentation"><a href="#" class="tablinks" onclick="openTabs(event, 'RecentQuestion')">Recent Questions</a></li>
                        <li role="presentation"><a href="#" class="tablinks" onclick="openTabs(event, 'Books')">Your Books</a></li>
                        <li role="presentation"><a href="#" class="tablinks" onclick="openTabs(event, 'ModalQ')">Your Modal Question</a></li>
                    </ul>


                    <div id="Books" class="tabcontent">
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
                                    <!--Description section-->
                                    <div class="col-md-8">
                                        <div class="read-more">
                                            <p>${book.description}<br>
                                                <a href="${site_url}/download/${book.ebookId}" 
                                                   class="btn btn-primary readMore roundBtn" 
                                                   role="button" download="">download
                                                </a>
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
                    <div id="ModalQ" class="tabcontent">
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
                                    <!--Description section-->
                                    <div class="col-md-8">
                                        <div class="read-more">
                                            <p>${modal.description}<br>
                                                <a href="${site_url}/download/${modal.modalId}" 
                                                   class="btn btn-primary readMore roundBtn" 
                                                   role="button" download="">download
                                                </a>
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

                    <div id="RecentQuestion" class="tabcontent">
                        <c:forEach var="question" items="${questionList}">

                            <!--Main panel-->
                            <div class="panel panel-info">
                                <!--Sub Panel Title-->
                                <div class="panel-heading">
                                    ${question.title}
                                    <a href="${site_url}/discuss/answer/${question.questionId}"><span class="badge">${question.noOFanswer}</span>
                                        <br> view
                                        <span class="glyphicon glyphicon-pencil"/> 
                                    </a>
                                </div>
                                <!--End of  sub panel title-->
                                <!--sub panel Body-->
                                <div class="panel-body">
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

                <div class="col-md-2">
                    <div class="panel panel-success">
                        <div class="panel-heading">Wanna try some thing!!!</div>
                        <div class="panel-body">
                            <%@include file="../popUpModal/uploadDoc.jsp"%>
                            <br>
                            <a href="${site_url}/askquestion" 
                               class="btn btn-primary readMore roundBtn" 
                               role="button">Ask Question
                            </a>


                        </div>
                    </div>

                </div>

            </div>
        </section>

        <div class="row"><!-- Footer  Starts Here-->
            <%@include file="../../shared/footer.jsp" %>
            <!-- Footer  Ends Here-->
        </div>

    </section>






</body>
</html>

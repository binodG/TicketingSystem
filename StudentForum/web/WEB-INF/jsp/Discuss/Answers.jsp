<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="site_url" value="${pageContext.request.contextPath}"/>

<html>
    <head>
        <title>Project</title>
        <!--J query-->
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
        </div><!--Header  Ends Here--> 
        <!--Warning-->
        <div class="row"> 
            <c:set var="question" value="${qObject}"/>
            <c:set var="qid" value="${qObject.questionId}"/>
            <c:if test="${loginMsg!=null}">
                <div class="alert alert-danger">
                    <strong>!!!!</strong><c:out value="${loginMsg}"/>
                </div>
            </c:if>

        </div><!--End of warning-->

        <!--Content Starts Here-->
        <div class="row">
            <div class="panel panel-info">
                <!--Sub Panel Title-->
                <div class="panel-heading">
                    <div class="col-md-offset-2">
                        ${question.title}
                    </div>
                </div><!--End of  sub panel title-->

                <!--sub panel Body-->
                <div class="panel-body">
                    <!--user pic section-->
                    <div class="col-sm-2">
                        <c:choose>
                            <c:when test="${question.user.image!=null}">
                               
                                <img src="${site_url}/display?image=${question.user.image}" class="img-circle" alt="Cinque Terre" width="50" height="50"><br>
                            </c:when>
                            <c:otherwise>
                                
                                <img src="<c:url value="/resources/images/user.jpg"/>" class="img-circle" alt="Cinque Terre" width="50" height="50"><br>
                            </c:otherwise>
                        </c:choose>
                        ${question.user.username}
                    </div><!--end of user pic section-->

                    <!--Description section-->
                    <div class="col-md-8">
                        <p>${question.question}
                    </div><!--End of Description section-->

                    <!--submitted date--> 
                    <div class="col-md-2">
                        <span class="glyphicon glyphicon-time"></span><br>
                        <fmt:formatDate pattern="yyyy-MM-dd" value="${question.submittedDate}" />

                    </div><!--End of submitted date-->

                </div><!--End of sub panel body-->
            </div>
        </div><!--End of row-->



        <c:forEach var="ans" items="${aObjectList}" >
            <div class="row">
                <div class="panel panel-info">
                    <!--sub panel Body-->
                    <div class="panel-body">
                        <!--user pic section-->
                        <div class="col-sm-2">
                            
                               <c:if test="${not empty ans.user.image}">
                               <img src="${site_url}/display?image=${ans.user.image}" class="img-circle" alt="Cinque Terre" width="50" height="50"><br>
                               </c:if >
                               
                               <c:if test="${empty ans.user.image}">
                                   <img src="<c:url value="/resources/images/user.jpg"/>" class="img-circle" alt="Cinque Terre" width="50" height="50"><br>
                               </c:if>
                                
                            ${ans.user.username}
                        </div>
                        <!--end of user pic section-->

                        <!--Description section-->
                        <div class="col-md-8">
                            <p>${ans.answer}
                        </div>
                        <!--End of Description section-->

                        <!--submitted date--> 
                        <div class="col-md-2">
                            <span class="glyphicon glyphicon-time"></span><br>
                            <fmt:formatDate pattern="yyyy-MM-dd" value="${ans.submittedDate}" />

                        </div>
                        <!--End of submitted date-->

                    </div>
                    <!--End of sub panel body-->
                </div>
            </div><!--end of row-->
        </c:forEach>

        <div class="row">
            <form  class="form-horizontal" role="form"  action="${site_url}/discuss/postanswer" method="POST">
                <input type="hidden" name="hidden" value="${qid}">  
                <div class="form-group">
                    <label class="control-label col-sm-2 customFont" for="answer">Answer:</label>
                    <div class="col-sm-6">
                        <TEXTAREA  row="10" cols="50" class="form-control" id="answer"  placeholder="Comment" name="answer" required="required"></TEXTAREA>
                                    </div>
                                </div>
                                <div class="form-group">
                                  <div class="col-sm-offset-2 col-sm-6">
                                   <button type="submit" class="btn btn-default">Comment</button>
                                  </div>
                                </div>
                            </form>
        
        
        </div>
        <!--Contents End here-->

<!-- Footer  Starts Here-->
        <%@include file="../../shared/footer.jsp" %>
        <!-- Footer  Ends Here-->






    </body>
</html>

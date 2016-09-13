<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="site_url" value="${pageContext.request.contextPath}"/>
<html>
    <head>
        <title>Faculty</title>
        <!--Style sheet-->
        <link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/css/core.css" />" rel="stylesheet">
        <script src="<c:url value="/resources/js/jquery.min.js" />"></script>
        <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
        <script src="<c:url value="/resources/js/treeview.js" />"></script>
        <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
        



        <script type='text/javascript'>


        </script>

    </head>

    <body>
        <!--Header Starts Here-->
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
        <!--Header Ends Here-->
        <section class="content">
            <div class="container">
                <div class="row">

                    <h2>Faculty</h2>
                    <div class="well">
                        <div>
                            <ul class="nav nav-list">
                                <c:forEach var="faculty" items="${facList}">
                                    <li><label class="tree-toggle nav-header"><h2><small>${faculty.facultyName}</small></h2></label>
                                        <ul class="nav nav-list tree">
                                            <c:forEach var="programme" items="${progList}">
                                                <c:if test="${programme.faculty.facultyId==faculty.facultyId}">
                                                    <li><label class="tree-toggle "><h3><small>${programme.programmeName}</small></h3></label>
                                                        <ul class="nav nav-list tree">
                                                            <c:if test="${programme.programmeType=='Semester'}">    
                                                                <c:forEach var="counter" begin="${1}" end="${programme.num}"> 
                                                                    <li><a href="${site_url}/Gallery/${counter}">${counter} semester </a></li>
                                                                    </c:forEach>
                                                                </c:if>
                                                                <c:if test="${programme.programmeType=='Year'}">    
                                                                    <c:forEach var="counter" begin="${1}" end="${programme.num}"> 
                                                                    <li><a href="${site_url}/Gallery/${counter}">${counter} Year </a></li>
                                                                    </c:forEach>
                                                                </c:if>

                                                        </ul>
                                                    </li>
                                                </c:if>
                                            </c:forEach>
                                        </ul>
                                    </li>
                                </c:forEach>

                            </ul>

                        </div>
                    </div>






                </div>




            </div>
            <section class="testimonial">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12">
                            <h2 class="heading">word of wisdom</h2>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-12">
                            <p class="colon">The only wisdom is to know you know nothing</p>
                            <p>&ndash; John Doe</p>
                        </div>
                    </div>
                </div>
            </section>

        </section>

        <!--Content  Ends Here--> 

        <!-- Footer  Starts Here-->
        <%@include file="../../shared/footer.jsp" %>
        <!-- Footer  Ends Here-->


    </body>
</html>


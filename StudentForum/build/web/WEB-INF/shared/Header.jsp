<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="Bootstraplink.jsp"%>
<c:set var="site_url" value="${pageContext.request.contextPath}"/>
<nav class="navbar navbar-default">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="${site_url}/">Home</a>
              
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li><a href="${site_url}/faculties">Gallery</a></li>
                    <li><a href="${site_url}/discuss">Discuss</a></li>
                    
                    <c:choose>
                        <c:when test="${sessionScope.user!=null}">
                            <li><a href="${site_url}/user"><c:out value="${sessionScope.user}"/></a></li>
                            <li><a href="${site_url}/logout">Logout</a></li>
                        </c:when>
                        <c:otherwise>
                         <li><a href="${site_url}/userlogin">Login</a></li>
                        </c:otherwise>
                    </c:choose>
                   
                </ul>
            </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
    </nav>
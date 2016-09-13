<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="site_url" value="${pageContext.request.contextPath}"/>
<%@include file="../../shared/Bootstraplink.jsp"%>


<link href="<c:url value="/resources/css/sidebar.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/jquery.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<script src="<c:url value="/resources/js/logout.js" />"></script>
        
<nav class="navbar navbar-default sidebar" role="navigation">
    <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-sidebar-navbar-collapse-1">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>      
    </div>
    <div class="collapse navbar-collapse" id="bs-sidebar-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="active"><a href="${site_url}/admin">Home<span style="font-size:16px;" class="pull-right hidden-xs showopacity glyphicon glyphicon-home"></span></a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown">Faculty<span class="caret"></span><span style="font-size:16px;" class="pull-right hidden-xs showopacity glyphicon glyphicon-education"></span></a>
          <ul class="dropdown-menu forAnimate" role="menu">
            <li><a href="${site_url}/admin/faculty" >Add</a></li>
            <li><a href="${site_url}/admin/viewfaculty">View</a></li>
          </ul>
        </li>    
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown">Program<span class="caret"></span><span style="font-size:16px;" class="pull-right hidden-xs showopacity glyphicon glyphicon-list"></span></a>
          <ul class="dropdown-menu forAnimate" role="menu">
            <li><a href="${site_url}/admin/programme">Add</a></li>
            <li><a href="${site_url}/admin/viewprogramme">View</a></li>
          </ul>
        </li>  
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown">Subjects<span class="caret"></span><span style="font-size:16px;" class="pull-right hidden-xs showopacity glyphicon glyphicon-book"></span></a>
          <ul class="dropdown-menu forAnimate" role="menu">
            <li><a href="${site_url}/admin/subject">Add</a></li>
            <li><a href="${site_url}/admin/viewsubject">View</a></li>
          </ul>
        </li>  
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown">Users<span class="caret"></span><span style="font-size:16px;" class="pull-right hidden-xs showopacity glyphicon glyphicon-user"></span></a>
          <ul class="dropdown-menu forAnimate" role="menu">
            <li><a href="${site_url}/admin/user">add</a></li>
            <li><a href="${site_url}/admin/viewuser">View</a></li>
          </ul>
        </li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown">E-books<span class="caret"></span><span style="font-size:16px;" class="pull-right hidden-xs showopacity glyphicon glyphicon-book"></span></a>
          <ul class="dropdown-menu forAnimate" role="menu">
            <li><a href="${site_url}/admin/e-books">Upload</a></li>
            <li><a href="${site_url}/admin/viewbooks">View EBooks</a></li>
             <li><a href="${site_url}/admin/viewmodal">View Modal Papers</a></li>
          </ul>
        </li>
        <li class="active"><a href="${site_url}/logout">Logout<span style="font-size:16px;" class="pull-right hidden-xs showopacity glyphicon glyphicon-home"></span></a></li>
                 
        </ul>
    </div>
  </div>
</nav>
      
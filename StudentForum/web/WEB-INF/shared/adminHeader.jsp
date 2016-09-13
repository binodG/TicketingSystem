<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/jquery.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
        

 <c:set var="site_url" value="${pageContext.request.contextPath}"/>


<header class="header">
  <div class="container">
    <div class="row">
      <div class="col-xs-12 col-sm-3 col-md-4"><a id="logo" href="index.html"><img src="images/logo.jpg" class="img-responsive" alt="" title="wordpress"></a> </div>
      <div class="col-xs-12 col-sm-9 col-md-8">
        <div class="clearfix"></div>
        <nav class="navbar marginBottom">
          <div class="container-fluid">
            <div class="navbar-header">
              <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false"> <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
            </div>
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <nav>
              <ul class="nav navbar-nav mainNavigation">
                <li class=""><a href="${sit_url}index">Home </a></li>
                <li><a href="${site_url}/faculties"> Faculties </a></li>
                <li><a href="${site_url}/#"></a></li>
                <li><a href="${site_url}/#"></a></li>
                <li><a href="${site_url}/#"></a></li>
              </ul>
              </nav>
            </div>
          </div>
        </nav>
      </div>
    </div>
  </div>
  <section class="banner"><img src="images/banner_02.jpg" alt="" class="img-responsive">
    <div class="container">
      <div class="bannerText">
        <div class="row">
          <div class="col-lg-12">
            <h2>build an empire</h2>
          </div>
        </div>
        <div class="row">
          <div class="col-lg-12">
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit sed do eiusmod</p>
          </div>
        </div>
      </div>
    </div>
  </section>
</header>

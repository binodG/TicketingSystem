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
        
        <section class="content">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                    </div>
                </div>


                <section class="testimonial">
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-12">
                                <h2 class="cutomFont">Your Questions</h2>
                            </div>
                        </div>
                        <div>
                            <form  class="form-horizontal"  action="${site_url}/postquestion" method='POST'>
                                <div class="form-group">
                                    <label class="control-label col-sm-2 customFont" for="title">Title:</label>
                                    <div class="col-sm-6">
                                        <input type="text" name="title" class="form-control" id="title" placeholder="Enter Title" required="required"/>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="control-label col-sm-2 customFont" for="question">Questions:</label>
                                    <div class="col-sm-6">
                                        <TEXTAREA  row="100" cols="500" class="form-control" id="title"  name="question"></TEXTAREA>
                                       
                                    </div>
                                </div>
                                
                                
                                <div class="form-group">
                                    <label class="control-label col-sm-2 customFont" for="tags">Tags:</label>
                                    <div class="col-sm-6">
                                        <input type="text" name="tags" class="form-control" id="tags" placeholder="Enter Tags" required="required"/>
                                    </div>
                                </div>
                        
                                <div class="form-group">
                                  <div class="col-sm-offset-2 col-sm-6">
                                   <button type="submit" class="btn btn-default">Submit</button>
                                  </div>
                                </div>



                                

			
</form> 

                        </div>
                    </div>
                    
                    <div>
                        <!-- Footer  Starts Here-->
                        <%@include file="../../shared/footer.jsp" %>
                        <!-- Footer  Ends Here-->
                    </div>
                        
                </section>
            
            </div>
        </section>

    
    
    
</body>
</Html>
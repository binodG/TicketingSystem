<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="site_url" value="${pageContext.request.contextPath}"/>
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">
    <span>Change Picture</span>
</button>
<!-- Modal -->
<div id="myModal" class="modal fade" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Upload Image</h4>
            </div>
            <div class="modal-body">
            <form method="post" action="${site_url}/uploadimage" enctype="multipart/form-data">
                            <input type="file" name="file" required/>
                            <button type="submit" name="upload">upload</button>
            </form>   
            
            
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>

    </div>
</div>


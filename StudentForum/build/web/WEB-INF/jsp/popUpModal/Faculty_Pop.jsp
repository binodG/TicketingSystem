
    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">
                    <span class="glyphicon glyphicon-pencil"/>
    </button>
        
<!-- Modal -->
<div id="myModal" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Add Student</h4>
      </div>
      <div class="modal-body">
       <form class="form-horizontal" role="form" method="post" action="${site_url}/admin/insertFaculties">

    <div class="form-group">
        <label class="control-label col-sm-2" for="faculty">Faculty:</label>
        <div class="col-sm-6">
            <input type="text" name="faculty" class="form-control" id="faculty" placeholder="Enter Faculty" required="required"/>
        </div>
    </div>


    
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-6">
            <button type="submit" class="btn btn-default">Add Faculty</button>
        </div>
    </div>


</form>
         
          
          
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>

  </div>
</div>


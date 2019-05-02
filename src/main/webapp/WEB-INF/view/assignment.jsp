<!DOCTYPE html>
<html>
<head>
<title>XBC | Assignment</title>
</head>

<body>
	<!-- Main content -->
	<section class="content">

		<div class="row">
			<div class="col-xs-12">
				<div class="box">
					<div class="box-body">
						<div class="row">
							<div class="col-xs-4">
								<div class="input-group input-group-sm">
									<input type="date" id="searchByDate" class="form-control pull-left"
										placeholder="Search by Date">
									<div class="input-group-btn">
										<button type="button" class="btn btn-default"
											onclick="refreshTable()">
											<i class="fa fa-search"></i>
										</button>
									</div>
								</div>
							</div>
							<div class="col-xs-8">
								<button type="button" class="btn btn-default btn-sm pull-right" data-toggle="modal" data-target="#modal-default" onclick="loadForm()">
									<i class="fa fa-plus"></i>
								</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-xs-12">
				<div class="box">

					<div class="box-body">
						<table id="table-Assignment"
							class="table table-bordered table-striped">
							<thead>
								<tr>
									<th>Name</th>
									<th>Start Date</th>
									<th>End Date</th>
									<th>Action</th>
								</tr>
							</thead>
							<tbody>
								
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>


		<form id="form-Assignment">
			<div class="modal fade" id="modal-default">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<h4 class="modal-title">ASSIGNMENT</h4>
						</div>
						<div class="modal-body">
							<div class="form-group">
								<input type="hidden" class="form-control" name="id" id="id">
								
							</div>
							<div class="form-group">
								<label>Biodata Name</label>
								<select class="custom-select d-block w-100 form-control"
									name="biodataId" id="biodataId">
								</select>
							</div>
							<div class="form-group">
								<input type="text" class="form-control" name="title" id="title"
									placeholder="Title">
							</div>
							<div class="form-group">
								<div class="input-group date">
									<div class="input-group-addon">
										<i class="fa fa-calendar"></i>
									</div>
									<input type="text" class="form-control" name="startDate"
										id="startDate" placeholder="Start Date">
								</div>
							</div>
							<div class="form-group">
								<div class="input-group date">
									<div class="input-group-addon">
										<i class="fa fa-calendar"></i>
									</div>
									<input type="text" class="form-control" name="endDate"
										id="endDate" placeholder="End Date">
								</div>
							</div>
							<div class="form-group">
								<textarea class="form-control" rows="3" name="description" id="description"
									placeholder="Description"></textarea>
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default pull-left"
								data-dismiss="modal">Cancel</button>
							<button type="button" class="btn btn-primary"
								onclick="submitForm()">Save</button>
						</div>
					</div>
					<!-- /.modal-content -->
				</div>
				<!-- /.modal-dialog -->
			</div>
		</form>

		<form id="form-MarkAsDone">
			<div class="modal fade" id="modal-done">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<h4 class="modal-title">MARK AS DONE</h4>
						</div>
						<div class="modal-body">
							<div class="form-group">
								<input type="hidden" class="form-control" name="id" id="idMarkAsDone">
								<input type="hidden" class="form-control" name="startDate" id="startDateMarkAsDone">
							</div>
							<div class="form-group">
								<div class="input-group date">
									<div class="input-group-addon">
										<i class="fa fa-calendar"></i>
									</div>
									<input type="text" class="form-control" name="realizationDate"
										id="realizationDate" placeholder="Realization Date">
								</div>
							</div>
							<div class="form-group">
								<label>Notes</label>
								<textarea class="form-control" rows="3" name="notes" id="notes"
									placeholder="Enter ..."></textarea>
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default pull-left"
								data-dismiss="modal">Cancel</button>
							<button type="button" class="btn btn-primary"
								onclick="markasdone()">Save</button>
						</div>
					</div>
					<!-- /.modal-content -->
				</div>
				<!-- /.modal-dialog -->
			</div>
		</form>

		<div class="modal modal-warning fade" id="modal-delete">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title">DELETE</h4>
					</div>
					<div class="modal-body">
						<div class="form-group" align="center">
							<p>Are you sure to delete this data?</p>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default pull-left"
							data-dismiss="modal">NO</button>
						<button type="button" class="btn btn-danger" onclick="hapus()">YES</button>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>

		<div class="modal modal-default fade" id="modal-hold">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title">HOLD</h4>
					</div>
					<div class="modal-body">
						<div class="form-group" align="center">
							<p>Are you sure to hold this assignment?</p>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default pull-left"
							data-dismiss="modal">NO</button>
						<button type="button" class="btn btn-danger" onclick="hold()">YES</button>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>
	</section>

	<script>
		function showBiodata() {
			$
					.ajax({
						type : 'get',
						url : 'biodata/findAll/',
						success : function(d) {
							var s = '';
							$(d)
									.each(
											function(index, element) {
												s += '<option value="' + element.id + '">'
														+ element.name
														+ '</option>';
											});
							$('#biodataId').html(s);
						}
					});
		}

		function refreshTable() {
			var vStDate = $('#searchByDate').val().toString();

			$
					.ajax({
						type : 'get',
						url : 'assignment/searchByDate/',
						data : {
							strStartDate : vStDate
						},
						success : function(d) {
							tableNih.clear().draw();
							$(d)
									.each(
											function(index, element) {
												tableNih.row
														.add(
																[
																		element.biodata.name,
																		element.startDate,
																		element.endDate,
																		
																		'<div class="dropdown">'
																				+ '<button class="btn btn-primary btn-xs dropdown-toggle" type="button" data-toggle="dropdown"> <i class="fa fa-bars"></i> </button>'
																				+ '<ul class="dropdown-menu">'
																				+ '<li><a href="javascript:void(0)" onclick="loadForm('
																				+ element.id
																				+ ')">Edit</a></li>'
																				+ '<li><a href="javascript:void(0)" onclick="popup('
																				+ element.id
																				+ ', 1)">Delete</a></li>'
																				+ '<li><a href="javascript:void(0)" onclick="popup('
																				+ element.id
																				+ ', 2)">Hold</a></li>'
																				+ '<li><a href="javascript:void(0)" onclick="popup('
																				+ element.id
																				+ ', 3)">Mark as Done</a></li>'
																				+ '</ul>'
																				+ '</div>' ])
														.draw();
											})
						},
						error : function(d) {
							console.log('Error');
						}
					});
		}

		function loadForm(id) {
			if (id == null) {
				$('#form-Assignment').trigger("reset");
				$('#id').val('');
			} else {
				$.ajax({
					type : 'get',
					url : 'assignment/' + id,
					success : function(d) {
						$('#id').val(d.id);
						$('#biodataId').val(d.biodataId);
						$('#title').val(d.title);
						$('#startDate').val(d.startDate);
						$('#endDate').val(d.endDate);
						$('#description').val(d.description);
					},
					error : function(d) {
						console.log('Error');
					}
				});
				$('#modal-default').modal("show");
			}

		}

		function submitForm() {
			var unindexed_data = $('#form-Assignment').serializeArray();
			var data = {};
			$.map(unindexed_data, function(n, i) {
				data[n['name']] = n['value'];
			});

			var method;
			if (data.id == '') {
				method = 'POST';
			} else {
				method = 'PUT';
			}
			
			if($('#title').val().trim().length == 0)
			{
				$("#title").notify("Title Tidak Boleh Kosong",{position:"right",className:"error"})
			} 
			else if($('#startDate').val() == '')
			{
				$("#startDate").notify("Start Date Tidak Boleh Kosong",{position:"right",className:"error"})
			}
			else if($('#endDate').val() == '')
			{
				$("#endDate").notify("End Date Tidak Boleh Kosong",{position:"right",className:"error"})
			}
			else if($('#startDate').val() - 1 >= $('#endDate').val())
			{
				$("#startDate").notify("Start Date tidak boleh lebih besar dari End Date !",{position:"right",className:"error"})
			} 
			else {
			$.ajax({
				type : method,
				url : 'assignment/',
				data : JSON.stringify(data),
				contentType : 'application/json',
				success : function(d) {
					refreshTable();
					$('#modal-default').modal('hide');
					if (method == 'POST'){
						$.notify("Data successfully saved !", "success");
					} if (method == 'PUT') {
						$.notify("Data successfully updated !", "success");
					}
				},
				error : function(d) {
					console.log('Error');
				}
			});}
		}

		function popup(id, type) {
				if (type == 3){
					$('#idMarkAsDone').val(id);
					$.ajax({
						type : 'get',
						url : 'assignment/' + id,
						success : function(d) {
							$('#idMarkAsDone').val(d.id);
							$('#startDateMarkAsDone').val(d.startDate);
							$('#realizationDate').val(d.realizationDate);
							$('#notes').val(d.notes);
						},
						error : function(d) {
							console.log('Error');
						}
					});
				}else{
					$('#id').val(id);
				}
					
					if (type == 1){
						$('#modal-delete').modal('show');
					} else if (type == 2) {
						$('#modal-hold').modal('show');
					} else if (type == 3){
						$('#modal-done').modal('show');
					}
		}

		function hapus() {
			var id = $('#id').val();
			$('#modal-delete').modal('hide');
			$.notify("Data successfully deleted !", "success");
			$.ajax({
				type : 'delete',
				url : 'assignment/' + id,
				success : function(d) {
					refreshTable();
				},
				error : function(d) {
					console.log('Error');
				}
			});
		}

		function hold() {
			var id = $('#id').val();
			$('#modal-hold').modal('hide');
			$.notify("Data has been hold !", "success");
			$.ajax({
				type : 'put',
				url : 'assignment/hold/' + id,
				success : function(d) {
					refreshTable();
					
				},
				error : function(d) {
					console.log('Error');
				}
			});
		}
		
		function markasdone() {
			var id = $('#idMarkAsDone').val();
			var unindexed_data = $('#form-MarkAsDone').serializeArray();
			var data = {};
			$.map(unindexed_data, function(n, i) {
				data[n['name']] = n['value'];
			});
			if($('#realizationDate').val() == '')
			{
				$("#realizationDate").notify("Realization Date Tidak Boleh Kosong",{position:"right",className:"error"})
			} else if($('#realizationDate').val() <= $('#startDateMarkAsDone').val())
			{
				$("#realizationDate").notify("Realization Date Tidak Boleh Lebih Kecil Dari Start Date (" + $('#startDateMarkAsDone').val() + ")",{position:"bottom",className:"error"})
			} else {
			$.ajax({
				type : 'put',
				url : 'assignment/done/' + id,
				data : JSON.stringify(data),
				contentType : 'application/json',
				success : function(d) {
					refreshTable();
					$('#modal-done').modal('hide');
					$.notify("Data has been marked as done !", "success");
				},
				error : function(d) {
					console.log('Error');
				}
			});
		}
		}

		var tableNih;
		$(document).ready(function() {
			$('#startDate').datepicker({
				autoclose: true,
				format: 'yyyy-mm-dd'
			});
			$('#endDate').datepicker({
				autoclose: true,
				format: 'yyyy-mm-dd'
			});
			$('#realizationDate').datepicker({
				autoclose: true,
				format: 'yyyy-mm-dd'
			});
			tableNih = $('#table-Assignment').DataTable({
				'searching' : false,
				'lengthChange' : false,
				'lengthMenu' : [ 10 ]
			});
			refreshTable();
			showBiodata();
		});
	</script>

</body>
</html>
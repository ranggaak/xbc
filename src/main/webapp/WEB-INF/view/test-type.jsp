<!DOCTYPE html>
<html>
<head>
<title>XBC | Test Type</title>
<script>
	function refreshTable() {
		$
				.ajax({
					type : 'get',
					url : 'test-type/',
					data : {
						name : $('#search').val()
					},
					success : function(d) {
						tableNih.clear().draw();
						$(d)
								.each(
										function(index, element) {
											tableNih.row
													.add(
															[
																	element.name,
																	element.user.username,
																	'<div class="dropdown">'
																			+ '<button class="btn btn-primary btn-xs dropdown-toggle" type="button" data-toggle="dropdown"> <i class="fa fa-bars"></i> </button>'
																			+ '<ul class="dropdown-menu">'
																			+ '<li><a href="javascript:void(0)" onclick="loadForm('
																			+ element.id
																			+ ')">Edit</a></li>'
																			+ '<li><a href="javascript:void(0)" onclick="popup('
																			+ element.id
																			+ ')">Delete</a></li>'
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
			$('#form-TestType').trigger("reset");
			$('#id').val('');
		} else {
			$.ajax({
				type : 'get',
				url : 'test-type/' + id,
				success : function(d) {
					$('#id').val(d.id);
					$('#name').val(d.name);
					$('#notes').val(d.notes);
				},
				error : function(d) {
					console.log('Error');
				}
			});
		}
		$('#modal-default').modal("show");
	}

	function submitForm() {
		var unindexed_data = $('#form-TestType').serializeArray();
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
		
		if($('#name').val().trim().length == 0)
			{
			$("#name").notify("Nama Tidak Boleh Kosong",{position:"right",className:"error"})
			} else {
		$.ajax({
			type : method,
			url : 'test-type/',
			data : JSON.stringify(data),
			contentType : 'application/json',
			success : function(d) {
				refreshTable();
					$('#modal-default').modal('hide');
					if (method == 'POST'){
						$.notify("Data successfully saved !", "success");
					} else if (method == 'PUT') {
						$.notify("Data successfully updated !", "success");
					}
			},
			error : function(d) {
				$("#name").notify(d.responseText,{position:"right",className:"error"});
			}
		});
		}
	}

	function popup(id) {
		var empName;
		$.ajax({
			type : 'get',
			url : 'test-type/' + id,
			success : function(d) {
				$('#id').val(d.id);
				$('#popdel').html('Are you sure to delete ' + d.name + '?');
			},
			error : function(d) {
				console.log('Error');
			}
		});
		$('#modal-delete').modal("show");
	}

	function hapus() {
		var id = $('#id').val();
		$('#modal-delete').modal('hide');
		$.notify("Data successfully deleted !", "success");
		$.ajax({
			type : 'delete',
			url : 'test-type/' + id,
			success : function(d) {
				refreshTable();

			},
			error : function(d) {
				console.log('Error');
			}
		});
	}

	var tableNih;
	$(document).ready(function() {
		tableNih = $('#table-TestType').DataTable({
			'searching' : false,
			'lengthChange' : false,
			'lengthMenu' : [ 10 ]
		});
		refreshTable();
	});
</script>
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
									<input type="text" id="search" class="form-control pull-left"
										placeholder="Search">
									<div class="input-group-btn">
										<button type="button" class="btn btn-default"
											onclick="refreshTable()">
											<i class="fa fa-search"></i>
										</button>
									</div>
								</div>
							</div>
							<div class="col-xs-8">
								<button type="button" class="btn btn-default btn-sm pull-right"
									onclick="loadForm()">
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
						<table id="table-TestType"
							class="table table-bordered table-striped">
							<thead>
								<tr>
									<th>Name</th>
									<th>Created By</th>
									<th>Action</th>
								</tr>
							</thead>
							<tbody></tbody>
						</table>
					</div>
				</div>
			</div>
		</div>

		<form id="form-TestType">
			<div class="modal fade" id="modal-default">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<h4 class="modal-title">TEST TYPE</h4>
						</div>
						<div class="modal-body">
							<div class="form-group">
								<input type="hidden" class="form-control" name="id" id="id">
							</div>
							<div class="form-group">
								<label>Name</label> <input type="text" class="form-control"
									name="name" id="name" placeholder="Name ..." required>
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
								onclick="submitForm()">Save</button>
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
							<p id="popdel"></p>
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
	</section>


</body>
</html>
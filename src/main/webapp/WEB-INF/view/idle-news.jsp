<!DOCTYPE html>
<html>
<head>
<title>XBC | Idle News</title>
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
						<table id="table-IdleNews"
							class="table table-bordered table-striped">
							<thead>
								<tr>
									<th>Title</th>
									<th>Category</th>
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

		<form id="form-IdleNews">
			<div class="modal fade" id="modal-default">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<h4 class="modal-title">IDLE NEWS</h4>
						</div>
						<div class="modal-body">
							<div class="form-group">
								<input type="hidden" class="form-control" name="id" id="id">
							</div>
							<div class="form-group">
								<input type="text" class="form-control" name="title" id="title"
									placeholder="Title">
							</div>
							<div class="form-group">
							<label>Category</label>
								<select class="custom-select d-block w-100 form-control"
									name="categoryId" id="categoryId">
								</select>
							</div>
							<div class="form-group">
								<textarea class="form-control" rows="3" name="content"
									id="content" placeholder="Content"></textarea>
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

		<form id="form-ShareToEmail">
			<div class="modal fade" id="modal-sharetoemail">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<h4 class="modal-title">SHARE TO EMAIL</h4>
						</div>
						<div class="modal-body">
							<div class="form-group">
								<input type="hidden" class="form-control" name="id" id="id">
							</div>
							<div class="form-group">
								<input type="text" class="form-control" name="email" id="email"
									placeholder="Email">
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default pull-left"
								data-dismiss="modal" onclick="">Cancel</button>
							<button type="button" class="btn btn-primary" onclick="">Send</button>
						</div>
					</div>
					<!-- /.modal-content -->
				</div>
				<!-- /.modal-dialog -->
			</div>
		</form>

		<div class="modal modal-info fade" id="modal-publish">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title">PUBLISH</h4>
					</div>
					<div class="modal-body">
						<div class="form-group" align="center">
							<p>Are you sure to publish this news?</p>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default pull-left"
							data-dismiss="modal">NO</button>
						<button type="button" class="btn btn-danger" onclick="publish()">YES</button>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>

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
	</section>

	<script>
	function showCategory() {
		$
				.ajax({
					type : 'get',
					url : 'category/findAll/',
					success : function(d) {
						var s = '';
						$(d)
								.each(
										function(index, element) {
											s += '<option value="' + element.id + '">'
													+ element.name
													+ '</option>';
										});
						$('#categoryId').html(s);
					}
				});
	}

	function refreshTable() {
		$
				.ajax({
					type : 'get',
					url : 'idle-news/',
					data : {
						title : $('#search').val()
					},
					success : function(d) {
						tableNih.clear().draw();
						$(d)
								.each(
										function(index, element) {
											tableNih.row
													.add(
															[
																	element.title,
																	element.category.name,
																	
																	
																	'<div class="dropdown">'
																			+ '<button class="btn btn-primary btn-xs dropdown-toggle" type="button" data-toggle="dropdown"> <i class="fa fa-bars"></i> </button>'
																			+ '<ul class="dropdown-menu">'
																			+ '<li><a href="javascript:void(0)" onclick="loadForm('
																			+ element.id
																			+ ')">Edit</a></li>'
																			+ '<li><a href="javascript:void(0)" onclick="popup('
																			+ element.id
																			+ ', 1)">Publish</a></li>'
																			+ '<li><a href="javascript:void(0)" onclick="popup('
																			+ element.id
																			+ ', 2)">Share to Email</a></li>'
																			+ '<li><a href="javascript:void(0)" onclick="popup('
																			+ element.id
																			+ ', 3)">Delete</a></li>'
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
			$('#form-IdleNews').trigger("reset");
			$('#id').val('');
		} else {
			$.ajax({
				type : 'get',
				url : 'idle-news/' + id,
				success : function(d) {
					$('#id').val(d.id);
					$('#title').val(d.title);
					$('#categoryId').val(d.categoryId);
					$('#content').val(d.content);
				},
				error : function(d) {
					console.log('Error');
				}
			});
			$('#modal-default').modal("show");
		}

	}

	function submitForm() {
		var unindexed_data = $('#form-IdleNews').serializeArray();
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
		else {
		$.ajax({
			type : method,
			url : 'idle-news/',
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
		});
		}
	}

	function popup(id, type) {
		$('#id').val(id);
		if (type == 1){
			$('#modal-publish').modal('show');
		} else if (type == 2) {
			$('#modal-sharetoemail').modal('show');
		} else if (type == 3){
			$('#modal-delete').modal('show');
		}
	}

	function hapus() {
		var id = $('#id').val();
		$('#modal-delete').modal('hide');
		$.notify("Data successfully deleted !", "success");
		$.ajax({
			type : 'delete',
			url : 'idle-news/' + id,
			success : function(d) {
				refreshTable();
				
			},
			error : function(d) {
				console.log('Error');
			}
		});
	}

	function publish() {
		var id = $('#id').val();
		$('#modal-publish').modal('hide');
		$.notify("Data has been published !", "success");
		$.ajax({
			type : 'put',
			url : 'idle-news/publish/' + id,
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
		tableNih = $('#table-IdleNews').DataTable({
			'searching' : false,
			'lengthChange' : false,
			'lengthMenu' : [ 10 ]
		});
		refreshTable();
		showCategory();
	});
	</script>

</body>
</html>
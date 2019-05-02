<!doctype html>
<html lang="en">
<head>
<title>Biodata</title>
<script
	src="${pageContext.request.contextPath}/assets/js/jquery.serializejson.min.js"></script>
</head>
<body>
	<!-- Tampilan & input -->
	<section class="content">
		<!--  Search -->
		<div class="row">
			<div class="col-xs-12">
				<div class="box">
					<div class="box-body">
						<h3 class="box-title">Biodata</h3>
						<br> <br>
						<div class="row">
							<div class="box-tools">
								<div class="col-xs-5">
									<div class="input-group input-group-sm">
										<input type="text" id="search" class="form-control pull-left"
											placeholder="Search by Name or Majors">
										<div class="input-group-btn">
											<button type="button" class="btn btn-default" onclick="refreshTabel()">
												<i class="fa fa-search"></i>
											</button>
										</div>
									</div>
								</div>
								<div class="col-xs-6"></div>
								<div class="col-xs-1">
									<div class="input-group input-group-sm">
										<div class="input-group-btn pull-right">
											<button type="button" class="btn btn-primary btn-sm pull-right"
												data-toggle="modal" data-target="#modalBiodata" onclick="insert()">
												<i class="fa fa-plus"></i>
											</button>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="box-body">
						<table id="tabel-biodata" class="table table-bordered table-striped">
							<thead>
								<tr>
									<th>Name</th>
									<th>Majors</th>
									<th>GPA</th>
									<th>Action</th>
								</tr>
							</thead>
							<tbody></tbody>
						</table>
					</div>
				</div>
			</div>
		</div>

		<!-- Form Biodata -->
		<form id="form-biodata">
			<div class="modal fade" id="modalBiodata">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<h4 class="modal-title">Add Biodata</h4>
						</div>
						<div class="modal-body">
							<div class="row">
								<div class="col-xs-12">
									<div class="form-group">
										<input type="text" class="form-control" name="name" id="name"
											placeholder="Name">
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-12">
									<div class="form-group">
										<input type="text" class="form-control" name="lastEducation"
											id="lastEducation" placeholder="Last Education">
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-12">
									<div class="form-group">
										<input type="text" class="form-control" name="educationalLevel"
											id="educationalLevel" placeholder="Educational Level">
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-12">
									<div class="form-group">
										<input class="form-control" name="graduationYear"
											id="graduationYear" placeholder="Graduation Year">
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-12">
									<div class="form-group">
										<input type="text" class="form-control" name="majors"
											id="majors" placeholder="Majors">
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-12">
									<div class="form-group">
										<input type="text" class="form-control" name="gpa" id="gpa"
											placeholder="GPA">
									</div>
								</div>
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default pull-left"
								data-dismiss="modal">Cancel</button>
							<button type="button" onclick="simpan()" class="btn btn-primary">Save</button>
						</div>
					</div>
				</div>
			</div>
		</form>

		<form id="form-editBiodata">
			<div class="modal fade" id="modalEdit">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<h4 class="modal-title">Edit Biodata</h4>
						</div>
						<div class="modal-body">
							<div class="row">
								<div class="col-xs-12">
									<div class="form-group">
										<input type="hidden" class="form-control" name="id:number"
											id="idEdit">
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-4">
									<div class="form-group">
										<input type="text" class="form-control" name="name"
											id="nameEdit">
									</div>
								</div>
								<div class="col-xs-8">
									<div class="form-group">
										Gender&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
											<input type="radio" name="gender" value="M" class="gender" checked>
											<label for="M">&nbsp; M</label>
											 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                       						<input type="radio" name="gender" value="F" class="gender" checked>
											<label for="F">&nbsp; F</label>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-4">
									<div class="form-group">
										<input type="text" class="form-control" name="lastEducation"
											id="lastEducationEdit">
									</div>
								</div>
								<div class="col-xs-8">
									<div class="form-group">
										<select class="custom-select d-block w-100 form-control" name="bootcampTestType"
											id="bootcampTestType">
										</select>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-4">
									<div class="form-group">
										<input type="text" class="form-control"
											name="educationalLevel" id="educationalLevelEdit">
									</div>
								</div>
								<div class="col-xs-2">
									<div class="form-group">
										<input type="text" class="form-control" name="iq" id="iq" placeholder="IQ">
									</div>
								</div>
								<div class="col-xs-2">
									<div class="form-group">
										<input type="text" class="form-control" name="du" id="du" placeholder="DU">
									</div>
								</div>
								<div class="col-xs-2">
									<div class="form-group">
										<input type="text" class="form-control" name="nestedLogic" id="nestedLogic" placeholder="NL">
									</div>
								</div>
								<div class="col-xs-2">
									<div class="form-group">
										<input type="text" class="form-control" name="joinTable" id="joinTable" placeholder="JT">
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-4">
									<div class="form-group">
										<input type="text" class="form-control" name="graduationYear"
											id="graduationYearEdit">
									</div>
								</div>
								<div class="col-xs-8">
									<div class="form-group">
										<input type="text" class="form-control" name="arithmetic"
											id="arithmetic" placeholder="Arithmetic">
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-4">
									<div class="form-group">
										<input type="text" class="form-control" name="majors"
											id="majorsEdit">
									</div>
								</div>
								<div class="col-xs-8">
									<div class="form-group">
										<input type="text" class="form-control" name="tro"
											id="tro" placeholder="TRO">
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-4">
									<div class="form-group">
										<input type="text" class="form-control" name="gpa"
											id="gpaEdit">
									</div>
								</div>
								<div class="col-xs-8">
									<div class="form-group">
										<input type="text" class="form-control" name="interviewer"
											id="interviewer" placeholder="Interviewer">
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-12">
									<div class="form-group">
										<textarea class="form-control" rows="2" name="notes"
											id="notes" placeholder="Notes"></textarea>
									</div>
								</div>
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default pull-left"
								data-dismiss="modal">Cancel</button>
							<button type="button" class="btn btn-primary" onclick="simpan()">Save</button>
						</div>
					</div>
				</div>
			</div>
		</form>
		
		<!-- Pop up Delete -->
		<div class="modal modal-warning fade" id="modal-delete">
			<div class="modal-dialog">
				<div class="modal-content">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">Delete</h4>
				</div>
				<div class="modal-body">
					<div class="form-group" align="center">
						<p>Are you sure to delete this data?</p>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default pull-left"
						data-dismiss="modal">No</button>
					<button type="button" class="btn btn-danger">Yes</button>
				</div>
			</div>
		</div>

	</section>
	<!-- Proses -->
	<script>
	var modeSubmit = 'insert';
	
	function refreshTabel() {
		$.ajax({
			type: 'get',
			url: 'biodata/',
			data: {
				nameOrMajors: $('#search').val()
			},
			success: function(d) {
				tabelBiodata.clear().draw();
				$(d).each(function(index, element){
					tabelBiodata.row.add([
						element.name,
						element.majors,
						element.gpa,
						'<div class="input-group-btn">' +
						'<button type="button" class="btn btn-default btn-sm pull-left" data-toggle="dropdown">' +
						'<i class="fa fa-navicon"></i>' +
                        '</button>' +
                        '<ul class="dropdown-menu pull-left">' +
                        '<li><a href="javascript:void(0)" data-toggle="modal" data-target="#modalEdit" onclick="loadEdit(\'' + element.id + '\')">Edit</a></li>' +
                        '<li><a href="javascript:void(0)" onclick="hapus(\'' + element.id + '\')">Delete</a></li>' +
                        '</ul>' +
                        '</div>'
                    	//'<input class="btn btn-default btn-sm" type="button" value="Edit" data-toggle="modal" data-target="#modalEdit" onclick="loadEdit(\'' + element.id + '\')"> &nbsp;' +
    	 				//'<input class="btn btn-danger btn-sm" type="button" value="Hapus" data-toggle="modal" dataId ="'+element.id+'" onclick="hapus(\'' + element.id + '\')">'
					]).draw();
				})
				
			},
			error: function(d) {
				console.log('Error');
			}
		});
	}

	function simpan() {	
		var method;

		if(modeSubmit == 'insert') {
			var data = $('#form-biodata').serializeJSON();	
			$('#modalBiodata').modal('hide');
			method = 'post';
		} else {
			var data  = $('#form-editBiodata').serializeJSON();
			$('#modalEdit').modal('hide');
			method ='put';
		}
		$.ajax({
			type: method,
			url: 'biodata/',
			data: JSON.stringify(data),
			contentType: 'application/json',
			success:  function(d) {
				refreshTabel();
				modeSubmit = 'insert';
				$('#form-biodata').trigger("reset");
				$('#form-biodata input[type=hidden]').val('');	
				$('#form-editBiodata').trigger("reset");
				$('#form-editBiodata input[type=hidden]').val('');	
			},
			error: function(d) {
				console.log('Error')
			}
		});
	}

    function loadEdit(id) {
		$.ajax({
			type: 'get',
			url: 'biodata/' + id,
			success: function(d) {
				refreshTabel();
				$('#idEdit').val(d.id);
				$('#nameEdit').val(d.name);
				$('#lastEducationEdit').val(d.lastEducation);
				$('#graduationYearEdit').val(d.graduationYear);
				$('#educationalLevelEdit').val(d.educationalLevel);
				$('#majorsEdit').val(d.majors);
				$('#gpaEdit').val(d.gpa);
				$('.gender').val([d.gender]);
				$('#bootcampTestType').val(d.bootcampTestType);
				$('#iq').val(d.iq);
				$('#du').val(d.du);
				$('#nestedLogic').val(d.nestedLogic);
				$('#joinTable').val(d.joinTable);
				$('#arithmetic').val(d.arithmetic);
				$('#tro').val(d.tro);
				$('#interviewer').val(d.interviewer);
				$('#notes').val(d.notes);
				modeSubmit ='update';
			},
            error: function(d) {
				console.log('Error');
            }
		});
    }

	function insert() {
		modeSubmit = 'insert';
	}

	function hapus(id) {
		if (confirm("Are you sure to delete this data?")) {
			$.ajax({
				type : 'delete',
				url : 'biodata/' + id,
				success : function(d) {
					refreshTabel();
				},
				error : function(d) {
					console.log('Error');
				}
			});
		}
	}

	function loadBootcampTestType() {
        $.ajax({
            type: 'GET',
            url: 'bootcamp-test-type/findAll/',
            success: function(d) {
                showBootcampTestType(d);
            },
            error: function(d) {
				console.log('Error - loadBootcampTestType');
            }
        });
    }

	function showBootcampTestType(d) {
		var s = '<option value="" disabled selected> - Choose BootcampTestType -</option>';
		$(d).each(function(index, element) {
            s += '<option value="' + element.id 
                + '" data-nama="' + element.name + '">' 
                + element.id + ' - ' 
                + element.name
                + '</option>';
		});
        $('#bootcampTestType').html(s);
    }

	var tabelBiodata;
	$(document).ready(function() {
		tabelBiodata = $('#tabel-biodata').DataTable({
			'searching' : false,
			'lengthChange' : false,
			'lengthMenu' : [ 10 ]
		});
		refreshTabel();
		loadBootcampTestType();
	});
	</script>
</body>
</html>
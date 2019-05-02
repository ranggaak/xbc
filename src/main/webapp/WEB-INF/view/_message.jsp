<div id="message-info" class="alert alert-info"
	style="position: fixed; bottom: 0px; right: 20px; z-index: 1060; max-width: 400px; display: none;">
	<button class="close" type="button"
		onclick="$(this).parent().fadeOut()">&times;</button>
	<strong>INFO</strong>
	<p>Pesan</p>
</div>



<script>
	function messageInfo(d) {
		var messageBox = $('#message-info p');
		var message = '<ul>';
		$.each(d.responseJSON.message, function(i, e) {
			message += '<li>' + e + '</li>';
		});
		message += '</ul>';
		messageBox.html(message);
		messageBox.parent().fadeIn();
	}
</script>
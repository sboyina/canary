/*global window,$*/
$.ready = function(){
	$('#license_terms .btn-default').click(function(){
		$('#license_terms').hide();
	});
	$('#license_terms .btn-primary').click(function(){
		var url = $(this).attr('download-url');
		window.location.href = url;
		$('#license_terms').hide();
	});
	$('a.btn-download').click(function(event){
		event.preventDefault();
		var srcURL = $(this).attr('href');
		$('#license_terms .btn-primary').attr('download-url', srcURL);
		$('#license_terms').show();
	});
};
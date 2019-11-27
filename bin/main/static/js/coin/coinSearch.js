$(document).ready(function() {
	console.log("connection successs");
});

$('#coinBtn').on('click', function() {
	var coinQ = $('#coinValue').val();
	console.log('>>'+coinQ);
	$.ajax({
		type : 'GET',
		url : '/coin/result',
		dataType : 'JSON',
		data : {
			coinQ : coinQ
			},
		success : view,
		error : function(result) {
			console.log('ERROR');
		}
	});
});
var html = '';
function view(data) {
	$.each(data, function(idx, val) {
		html += '<div>';
	  	html += '<h3>' + val.title +'</h3>';
	  	html += '<h3>' + val.content + '</h3>';
	  	html += '</div>';
	});
	$('#ajaxReturn').html(html);
}

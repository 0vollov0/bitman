<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>코인검색</title>
<script type="text/javascript" src="/static/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="/static/js/coin/coinSearch.js"></script>
</head>
<body>
Coin :: 
<input type="text" id="coinValue" placeholder="코인 풀네임을 입력하세요."><input type="button" id="coinBtn" value="검색"><br>
<div id="ajaxReturn">ajaxReturnOutput</div>
<script>

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

</script>
</body>
</html>
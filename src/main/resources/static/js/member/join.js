$(document).ready(function() {
	pass_key();
	sec_pass_key();
});

var mailCode1 = "";
var mailCode2 = "";
$('#send_mail').on('click', function() {
	var mail = $('#mail').val();
	console.log(">>"+mail);
	$.ajax({
		type : 'POST',
		url : '/member/mailSend',
		dataType : "JSON",
		data : {
			mail : mail
		},
		success : function(result, data) {
			if(String(result.check) == "overlap") {
				alert('중복된 이메일입니다.');
			}else {
				var mailCode1 = String(result.check);
				console.log(">>인증번호" + mailCode1);
				$('#secretCode').val(mailCode1);
				alert('메일로 인증번호가 전송되었습니다.');	
			}
		},
		error : function(data) {
			console.log("error" + data);
		}
	});
});

$('#mailCodeBtn').on('click', function() {
	mailCode2 = $('#mailCode').val();
	mailCode1 = $('#secretCode').val();
 	if(mailCode1 != "" && mailCode1 == mailCode2) {
		alert("인증이 완료되었습니다.");
		$("#CodeCheck").prop("checked", true);
	}else {
		alert("인증번호를 다시 확인해주세요.");
	}
	
});

function pass_key() {
	$("#password2").keyup(function() {
		var pw1 = $('#password').val();
		var pw2 = $('#password2').val();
		if(pw1 == pw2) {
			$('#pin_check1').text('');
			$('#pin_check1').html("일치");
			document.getElementById("pin_check1").setAttribute("color", "blue");
		}else {
			$('#pin_check1').text('');
			$('#pin_check1').html("불일치");
			document.getElementById("pin_check1").setAttribute("color", "red");
		}
	});
}

function sec_pass_key() {
	$("#second_password2").keyup(function() {
		var pw1 = $('#second_password').val();
		var pw2 = $('#second_password2').val();
		if(pw1 == pw2) {
			$('#pin_check2').text('');
			$('#pin_check2').html("일치");
			document.getElementById("pin_check2").setAttribute("color", "blue");
		}else {
			$('#pin_check2').text('');
			$('#pin_check2').html("불일치");
			document.getElementById("pin_check2").setAttribute("color", "red");
		}
	});
}

$('#joinBtn').on('click', function() {
	var name = $('#name').val();
	var mail = $('#mail').val();
	var password = $('#password').val();
	var second_password = $('#second_password').val();
	var keep_KRW = $('#keep_KRW').val();
	if(!name) {
		alert("이름을 입력해주세요");
	}else if($("input:checkbox[id='CodeCheck']").is(":checked") == false) {
		alert("메일 인증을  완료해주세요.");
	}else if($('#pin_check1').text() != "일치"){
		console.log("conde"+$('#pin_check1').text());
		alert("비밀번호를 일치시켜주세요");
	}else if($('#pin_check2').text() != "일치"){
		alert("2차 비밀번호를 일치시켜주세요");
	}else if(!keep_KRW) {
		alert("투자해볼 금액을 정해주세요.");
	}else {
		console.log(">>"+name+">>"+mail+">>"+password+">>"+second_password+">>"+keep_KRW);
		$.ajax({
			type : 'POST',
			url : '/member/join',
			dataType : "JSON",
			data : {
				name : name,
				mail : mail,
				password : password,
				second_password : second_password,
				keep_KRW : keep_KRW
			},
			success : function(result, data) {
				console.log("success" + result.url);
				location.href="/";
			},
			error : function(data) {
				console.log("error");
			}
		});
	}
});

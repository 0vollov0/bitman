var form = document.form;

var mail_reg = new RegExp('^[0-9a-zA-Z]([-_\\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\\.]?[0-9a-zA-Z])*\\.[a-zA-Z]{2,3}$', 'i');
var password_reg = new RegExp('^(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&]{8,20}$');

var blank_reg = new RegExp('\\s');

/*
  mail_reg 영문 또는 영문/숫자 조합 6~15 자
  password_reg 영문,숫자,특수문자 각 최소 1자 이상 8~20 자
  blank_reg 공백 정규식
*/

// 공백 및 null 값 확인
function isNullOrBlank(object) {
  value = object.value;
  if (typeof value == "undefined" || value == null || value == "" || blank_reg.test(value)) {
    return true;
  } else {
    return false;
  }
}

// 같은 값인 지 확인
function isSameValue(object1,object2){
  if (object1.value == object2.value) {
    return true;
  } else {
    return false;
  }
}

function checkLogin(){
  var mail = form.mail;
  var password = form.password;

  if(isNullOrBlank(mail)){
	alert('이메일은 공백을 포함 할 수 없습니다.');
    mail.focus();
    return false;
  }

  if(!mail_reg.test(mail.value)){
	alert('이메일은 이메일 형식을 입력해주세요.');
    mail.focus();
    return false;
  }

  if(isNullOrBlank(password)){
    alert('비밀번호는 공백을 포함 할 수 없습니다.');
    password.focus();
    return false;
  }

  if(!password_reg.test(password.value)){
    alert('비밀번호는 영문,숫자,특수문자 각 최소 1자 이상 8~20 자 입니다.');
    password.focus();
    return false;
  }
  
  login();
}

function login() {
	$.ajax({
		url : './login',
		method : "POST",
		data : {
			mail : $("input[name=mail]").val(),
			password : $("input[name=password]").val()
		}
	}).done(function(resultData) {
		$("input[name=mail]").val("");
		$("input[name=password]").val("");
		switch (resultData.result) {
		case 0:
			console.log(resultData.result);
			break;
		case 1:
			console.log(resultData.result);
			break;
		default:
			break;
		}

	}).fail(function() {
	}).always(function() {
	});
}
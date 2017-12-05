/**
 * Functionality for ERS app
 */


window.onload = function() {
    loadLogin();
}

$(document).on('click', '#new-users', loadCA);
$(document).on('click', '#returning-users', loadLogin);
$(document).on('click', '#login', login);

$('#logoutModal').on('shown.bs.modal', function () {
	$('#logoutModal').trigger('focus');
	$('#modal-logout').on('click', function() {
		console.log("logout bruh");
		loadLogin();
	});
  });

function loadLogin() {
	console.log("at loadLogin()");
    var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
            document.getElementById('view').innerHTML = xhr.responseText;
            $('.message').hide();
		}
	}

	xhr.open("GET", "getLoginView", true);
	xhr.send();
}

function loadCA() {
	console.log("at loadCA()");
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4 && xhr.status == 200) {
            document.getElementById('view').innerHTML = xhr.responseText;
        }
    }

    xhr.open("GET", "getCAView", true);
    xhr.send();
}

function login() {
    var username = $('#username').val();
    var password = $('#password').val();

    var user = {
        userId: 0,
        username: username,
        password: password,
        firstName: null,
        lastName: null,
        email: null,
        roleId: 0
    }
    
    var text = JSON.stringify(user);

    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4 && xhr.status == 200) {
            var currUser = JSON.parse(xhr.responseText);
            if (currUser == null) {
                $('.message').show();
                $('#message').html("Invalid username or password");
				$('#password').val("");
            } else {
                console.log(currUser)
                // load the main page
            }
        }
    }

    if (user.username != "" && user.password != "") {
        xhr.open("POST", "login", true);
        xhr.send(text);
    }
}

function createAccount() {

}

function updateAccount() {

}

function sanitizeUsername(username) {

}
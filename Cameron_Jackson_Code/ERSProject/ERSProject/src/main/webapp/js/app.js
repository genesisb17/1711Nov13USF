/**
 * Functionality for ERS app
 */
window.onload = function () {
    console.log("onload");
    loadPage();
    
};

$(document).on('click', '#new-users', loadCA);
$(document).on('click', '#returning-users', loadLogin);
$(document).on('click', '#login', login);
$(document).on('click', '#create-account', createAccount);
$(document).on('shown.bs.modal', '#logoutModal', function () {
    $('#logoutModal').trigger('focus');
    $(document).on('click', '#modal-logout', function() {
        logout();
    });
});

$(document).ready(function () {
    $('#data-table').DataTable();
});

// check for navigation time API support
// window.onbeforeunload = function() {
//     console.log("onbeforeload");
//     loadPage();
// }



/**
 * This function will be a get request to check where the user is in the page
 * if this is first login, it will load the login page.
 * if user was on main page, it will load that view etc.
 */
function loadPage() {
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4 && xhr.status == 200) {
            if (xhr.responseText == "loadLoginPage")
                loadLoginPage();
            else if (xhr.responseText == "loadMainPage") {
                var currUser = getUser();
                loadMainPage(currUser);
            }
        }
    }
    xhr.open("GET", "loadPage", true);
    xhr.send();
}

function loadLoginPage() {
    
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4 && xhr.status == 200) {
            $('#appview').html(xhr.responseText);
            loadLogin();
        }
    }
    xhr.open("GET", "loginpage.view", true);
    xhr.send();
}

function loadMainPage(currUser) {
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4 && xhr.status == 200) {
            $('#appview').html(xhr.responseText);
            loadLogoutModal();
            loadReimb(currUser);
        }
    }
    xhr.open("GET", "mainpage.view", true);
    xhr.send();
}

function loadLogin() {
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4 && xhr.status == 200) {
            $('#view').html(xhr.responseText);
            $('.bad-login').hide();
        }
    }
    xhr.open("GET", "login.view", true);
    xhr.send();
}

function loadCA() {
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4 && xhr.status == 200) {
            $('#view').html(xhr.responseText);
            $('.bad-username').hide();
            $('.bad-password').hide();
        }
    }

    xhr.open("GET", "ca.view", true);
    xhr.send();
}

function loadReimb(currUser) {

    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4 && xhr.status == 200) {
            document.getElementById('view').innerHTML = xhr.responseText;
            document.getElementById('name').innerHTML =
                `${document.getElementById('name').innerHTML}, ${currUser.firstName} ${currUser.lastName}`;
        }
    }

    xhr.open("GET", "reimb.view", true);
    xhr.send();
}

// function loadMainNav() {
//     var xhr = new XMLHttpRequest();
//     xhr.onreadystatechange = function() {
//         if (xhr.readyState == 4 && xhr.status == 200) {
//             document.getElementById('navigation').innerHTML = xhr.responseText;
//             loadLogoutModal();
//         }
//     }
//     xhr.open("GET", "getNav", true);
//     xhr.send();
// }

function loadLogoutModal() {
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4 && xhr.status == 200) {
            $('body').prepend(xhr.responseText);
        }
    }
    xhr.open("GET", "logout-modal.view", true);
    xhr.send();
}

function login() {
    var user = {
        userId: 0,
        username: $('#username').val(),
        password: $('#password').val(),
        firstName: null,
        lastName: null,
        email: null,
        roleId: 0
    }

    var text = JSON.stringify(user);

    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4 && xhr.status == 200) {
            var currUser = JSON.parse(xhr.responseText);
            if (currUser == null) {
                $('.message').show();
                $('#message').html("Invalid username or password");
                $('#password').val("");
            } else {
                loadMainPage(currUser);
            }
        }
    }

    if (user.username != "" && user.password != "") {
        xhr.open("POST", "login", true);
        xhr.send(text);
    }
}

function logout() {
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4 && xhr.status == 200) {
            loadLoginPage();
        }
    }
    xhr.open("GET", "logout", true);
    xhr.send();
}

function createAccount() {
    $('.bad-username').hide();
    $('.bad-password').hide();
    var user = {
        userId: 0,
        username: $('#username').val(),
        password: $('#password').val(),
        firstName: $('#firstname').val(),
        lastName: $('#lastname').val(),
        email: $('#email').val(),
        roleId: 0
    }

    if ($('#manager-check').is(':checked')) {
        user.roleId = 2;
    } else {
        user.roleId = 1;
    }

    var userInfo = {
        user: user,
        message: ""
    }

    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4 && xhr.status == 200) {
            var ui = JSON.parse(xhr.responseText);
            var currUser = ui.user;
            var message = ui.message;
            if (currUser == null) {
                $('.bad-username').show();
                $('#bad-username').html(ui.message);
                $('#username').val("");
                $('#password').val("");
                $('#confirm-password').val("");
            } else {
                loadMainPage(currUser);
            }
        }
    }

    if (user.password != $('#confirm-password').val()) {
        $('.bad-password').show();
        $('#bad-password').html("Password and Confirm password do not match");
        $('#password').val("");
        $('#confirm-password').val("");
    } else {
        var userString = JSON.stringify(userInfo);
        xhr.open("POST", "createAccount", true);
        xhr.send(userString);
    }

}

function getUser() {
    var user = {};
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4 && xhr.status == 200) {
            user = JSON.parse(xhr.responseText);
            console.log(user);
        }
    }
    xhr.open("GET", "getuser", true);
    xhr.send();
    return user;
}

function updateAccount() {

}

function sanitizeUsername(username) {

}
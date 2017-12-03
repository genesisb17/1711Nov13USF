/**
 * Functionality for ERS app
 */

window.onload = function() {
    $('#ca-input').hide();
    $('#user-settings').hide();
    $('#tickets').hide();
    $('#up-account').hide();
    $('#new-users').on('click', function() {
        $('#login-input').hide();
        $('#ca-input').show();
    });
    $('#returning-users').on('click', function() {
        $('#login-input').show();
        $('#ca-input').hide();
    });
    $('#login').on('click', login);
    $('#create-account').on('click', createAccount);
    $('#manage-account').on('click', function() {
        $('#tickets').hide();
        $('#up-account').show();
        $('#up-configm-password').hide();
    });
}

function login() {
    var username = $('#username').val();
    username = username.toLowerCase();
    var password = $('#password').val();
    // console.log(username + ": " + password);
    
    // Add more to this function as needed
    if (true) {
        $('#login-input').hide();
        $('#tickets').show();
        $('#user-settings').show();
    }

    // Just in case empty the text fields
    $('#username').val("");
    $('#password').val("");
}

function createAccount() {
    var firstname = $('#firstname').val();
    var lastname = $('#lastname').val();
    var email = $('#email').val();
    var username = $('#ca-username').val();
    username = username.toLowerCase();
    var password = $('#ca-password').val();
    var confirmPassword = $('#ca-confirm-password').val();

    if (true) {
        $('#ca-input').hide();
    }

    // Just in case empty the text fields
    $('#firstname').val("");
    $('#lastname').val("");
    $('#email').val("");
    $('#ca-username').val("");
    $('#ca-password').val("");
    $('#ca-confirm-password').val("");
}

function updateAccount() {

}

function sanitizeUsername(username) {

}
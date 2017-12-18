/**
 * Functionality for ERS app
 */
window.onload = function () {
    loadPage();
};

var pendingFilter = [{ field: "status", type: "=", value: "PENDING" }];
var resolvedFilter = [{ field: "status", type: "!=", value: "PENDING" }];
var nameFilter = [{ field: "author", type: "like", value: "" }];

$(document).on('click', '#new-users', loadCA);
$(document).on('click', '#returning-users', loadLogin);
$(document).on('click', '#login', login);
$(document).on('click', '#create-account', createAccount);
$(document).on('click', '#manage-account', loadManageAccount);
$(document).on('click', '#return-tickets', loadReimb);
// $(document).on('click', '#create-ticket', loadCreateTicket);
// $(document).on('click', '#create', createTicket);
$(document).on('click', '#ma-cancel', loadReimb);
$(document).on('click', '#ma-submit', updateAccount);
$(document).on('blur', '#up-account input', function () {
    if ((($("#up-email")[0].validity.valueMissing == true) && !$("#up-email").is("[readonly]")) ||
        (($("#up-username")[0].validity.valueMissing == true) && !$("#up-username").is("[readonly]")) ||
        (($("#up-password")[0].validity.valueMissing == true) && !$("#up-password").is("[readonly]"))) {
        // Ignore this case
        // Equivalent to disabling submission if invalid info
        $('#ma-submit').attr('disabled', true);
    }
});
$(document).on('input', '.ma-password', function () {
    $('#ma-submit').attr('disabled', false);
});
$(document).on('click', '.up-btn', function () {
    $(this).html('Cancel');
    $(this).attr('class', 'btn btn-danger up-btn-cancel');
    $('#up-verify-password').show();
    if ($(this).attr('id') == "up-email-btn") {
        $('#up-email').attr('readonly', false);
    } else if ($(this).attr('id') == "up-username-btn") {
        $('#up-username').attr('readonly', false);
    }
    // This is for if the password change button gets pressed
    if ($(this).attr('id') == "up-password-btn") {
        $('#up-password').attr('readonly', false);
        $('#up-confirm-password').show();
        $('#up-password').val("");
        $('#up-verify-password input').focus();
    }
    $('#ma-submit').attr('disabled', false);
});
$(document).on('click', '.up-btn-cancel', function () {
    $(this).html('Change');
    $(this).attr('class', 'btn btn-warning up-btn');
    if ($(this).attr('id') == "up-email-btn") {
        $('#invalid-email').html("");
        $('#invalid-email').hide();
        $('#up-email').attr('readonly', true);
    } else if ($(this).attr('id') == "up-username-btn") {
        $('#invalid-username').html("");
        $('#invalid-username').hide();
        $('#up-username').attr('readonly', true);
    } else if ($(this).attr('id') == "up-password-btn") {
        $('#up-password').attr('readonly', true);
        $('#up-confirm-password').hide();
    }
    $('#up-verify-password').hide();
    // if any element is NOT readonly don't hide the password verifications
    if ($('.ma-input:not([readonly])').length) {
        if ($('#up-password').is('[readonly]')) {
            $('#up-confirm-password').hide();
            $('#up-verify-password').show();
        } else {
            $('#up-confirm-password').show();
            $('#up-verify-password').show();
        }
        $('#ma-submit').attr('disabled', false);
    } else {
        $('.ma-password').val("");
        $('#ma-submit').attr('disabled', true);
    }
});
$(document).on('click', '#show-user', function () {
    $("#all-reimbs").hide();
    $("#user-reimbs").show();
    $("#reimb-table").tabulator("setFilter", pendingFilter);
    $("#reimb-table").tabulator("clearSort");
    $("#reimb-table").tabulator("setSort", "submitted", "desc");
    // $("#reimb-table").tabulator("setData");
    // getEmployeeTicketInfo();
});
$(document).on('click', '#show-all', function () {
    $("#all-reimbs").show();
    $("#user-reimbs").hide();
    $("#reimb-table-manager").tabulator("setFilter", pendingFilter);
    $("#reimb-table-manager").tabulator("clearSort");
    $("#reimb-table-manager").tabulator("setSort", "submitted", "desc");
    // $("#reimb-table-manager").tabulator("setData");
    // getAllTicketInfo();
});
$(document).on('shown.bs.modal', '#create-ticket-modal', function () {
    $('#create-ticket-modal').trigger('focus');
    $(document).on('click', '#create', createTicket);
})
$(document).on('shown.bs.modal', '#logoutModal', function () {
    $('#logoutModal').trigger('focus');
    $(document).on('click', '#modal-logout', function () {
        logout();
    });
});
$(document).on('click', '#showall', function () {
    if ($("#all-reimbs").is(":visible")) {
        $("#reimb-table-manager").tabulator("clearFilter");
        nameFilter[0].value = $('#namefilter').val();
        $('#reimb-table-manager').tabulator('addFilter', nameFilter);
        $("#reimb-table-manager").tabulator("clearSort");
        $("#reimb-table-manager").tabulator("setSort", "reimbId", "asc");
        $("#all-reimbs #tablefilters .active").removeClass('active');
        $("#all-reimbs #showall").addClass('active');
    }
    else {
        $("#reimb-table").tabulator("clearFilter");
        $("#reimb-table").tabulator("clearSort");
        $("#reimb-table").tabulator("setSort", "reimbId", "asc");
        $("#user-reimbs #tablefilters .active").removeClass('active');
        $("#user-reimbs #showall").addClass('active');
    }
});
$(document).on('click', '#showpending', function () {
    if ($("#all-reimbs").is(":visible")) {
        $("#reimb-table-manager").tabulator("setFilter", pendingFilter);
        nameFilter[0].value = $('#namefilter').val();
        $('#reimb-table-manager').tabulator('addFilter', nameFilter);
        $("#reimb-table-manager").tabulator("clearSort");
        $("#reimb-table-manager").tabulator("setSort", "submitted", "desc");
        $("#all-reimbs #tablefilters .active").removeClass('active');
        $("#all-reimbs #showpending").addClass('active');
    } else {
        $("#reimb-table").tabulator("setFilter", pendingFilter);
        $("#reimb-table").tabulator("clearSort");
        $("#reimb-table").tabulator("setSort", "submitted", "desc");
        $("#user-reimbs #tablefilters .active").removeClass('active');
        $("#user-reimbs #showpending").addClass('active');
    }
});
$(document).on('click', '#showresolved', function () {
    if ($("#all-reimbs").is(":visible")) {
        $("#reimb-table-manager").tabulator("setFilter", resolvedFilter);
        $('#reimb-table-manager').tabulator('addFilter', nameFilter);
        $("#reimb-table-manager").tabulator("clearSort");
        $("#reimb-table-manager").tabulator("setSort", "resolved", "desc");
        $("#all-reimbs #tablefilters .active").removeClass('active');
        $("#all-reimbs #showresolved").addClass('active');
    } else {
        $("#reimb-table").tabulator("setFilter", resolvedFilter);
        $("#reimb-table").tabulator("clearSort");
        $("#reimb-table").tabulator("setSort", "resolved", "desc");
        $("#user-reimbs #tablefilters .active").removeClass('active');
        $("#user-reimbs #showresolved").addClass('active');
    }
});

function filterUpdater() {
    let input = document.getElementById('namefilter');
    let timeout = null;
    let prevFilter = {}

    let handleChange = function () {
        if (input.value != "")
            $('#reimb-table-manager').tabulator('removeFilter', prevFilter);
        prevFilter = nameFilter;
        nameFilter[0].value = input.value;

        $('#reimb-table-manager').tabulator('addFilter', nameFilter);
    }

    let eventHandler = function () {
        if (timeout) clearTimeout(timeout);
        timeout = setTimeout(handleChange, 50);
    }

    input.onkeydown = input.onkeyup = input.onclick = eventHandler;
}

/**
 * This function will be a get request to check where the user is in the page
 * if this is first login, it will load the login page.
 * if user was on main page, it will load that view etc.
 */
function loadPage() {
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4 && xhr.status == 200) {
            if (xhr.responseText == "login") {
                loadLoginPage();
            }
            else if (xhr.responseText == "createaccount") {
                loadLoginPageMini();
                loadCA();
            }
            else if (xhr.responseText == "tickets") {
                loadMainPage();
            }
            else if (xhr.responseText == "manageaccount") {
                loadMainPageMini();
                getUser();
                loadManageAccount();
            }
        }
    }
    xhr.open("GET", "loadPage", true);
    xhr.send();
}

function loadLoginPage() {
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4 && xhr.status == 200) {
            $('body').css('background-image', "url(\"images/fistbumpworkspace.jpg\")");
            $('#appview').html(xhr.responseText);
            loadLogin();
        }
    }
    xhr.open("GET", "loginpage.view", true);
    xhr.send();
}

function loadLoginPageMini() {
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4 && xhr.status == 200) {
            $('#appview').html(xhr.responseText);
        }
    }
    xhr.open("GET", "loginpage.view", true);
    xhr.send();
}

function loadMainPage() {
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4 && xhr.status == 200) {
            $('body').css('background-image', "none");
            $('body').css('background-color', "white");
            $('#appview').html(xhr.responseText);
            loadLogoutModal();
            loadCreateTicket();
            loadReimb();
        }
    }
    xhr.open("GET", "mainpage.view", true);
    xhr.send();
}

function loadMainPageMini() {
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4 && xhr.status == 200) {
            $('body').css('background-image', "none");
            $('body').css('background-color', "white");
            $('#appview').html(xhr.responseText);
            loadLogoutModal();
        }
    }
    xhr.open("GET", "mainpage.view", true);
    xhr.send();
}

function loadLogin() {
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
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

function loadReimb() {
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4 && xhr.status == 200) {
            document.getElementById('view').innerHTML = xhr.responseText;
            getUser();
            // getEmployeeTicketInfo();
        }
    }

    xhr.open("GET", "reimb.view", true);
    xhr.send();
}

function loadCreateTicket() {
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4 && xhr.status == 200) {
            $('body').prepend(xhr.responseText);
        }
    }
    xhr.open("GET", "create-ticket.view", true);
    xhr.send();
}

function loadLogoutModal() {
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4 && xhr.status == 200) {
            $('body').prepend(xhr.responseText);
        }
    }
    xhr.open("GET", "logout-modal.view", true);
    xhr.send();
}

function loadManageAccount() {
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4 && xhr.status == 200) {
            $('#view').html(xhr.responseText);
            $('#up-confirm-password').hide();
            $('#up-verify-password').hide();
            $('#invalid-email').hide();
            $('#invalid-username').hide();
            getAccountInfo();

        }
    }
    xhr.open("GET", "manage-account.view", true);
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
                // $('.message').show();
                $('#invalid-password').html("Invalid username or password");
                $('#password').val("");
            } else {
                loadMainPage();
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
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4 && xhr.status == 200) {
            loadLoginPage();
        }
    }
    xhr.open("GET", "logout", true);
    xhr.send();
}

function updateAccount() {
    var updatedUser = {
        userId: 0,
        username: null,
        password: null,
        firstName: null,
        lastName: null,
        email: null,
        roleId: 0
    }
    if (!$("#up-email").is("[readonly]"))
        updatedUser.email = $('#up-email').val();
    if (!$("#up-username").is("[readonly]"))
        updatedUser.username = $('#up-username').val();
    if (!$("#up-password").is("[readonly]"))
        updatedUser.password = $('#up-password').val();

    var xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4 && xhr.status == 200) {
            var ui = JSON.parse(xhr.responseText);
            var user = ui.user;
            var message = ui.message;
            if (user == null) {
                if (message[0] != null) {
                    $('#up-email').val("");
                    $('#up-email').val("");
                    $('#invalid-email').show();
                    $('#invalid-email').html(message[0]);
                }
                if (message[1] != null) {
                    $('#up-username').val("");
                    $('#invalid-username').show();
                    $('#invalid-username').html(message[1]);
                }
                if (message[2] != null) {
                    $('#invalid-verify-password').html(message[2]);
                }
                $('#up-verify-password input').val("");
            } else {
                loadManageAccount();
            }
        }
    }

    if (($('#up-confirm-password').is(':visible') &&
        ($('#up-confirm-password input').val() == $('#up-password').val())) ||
        !$('#up-confirm-password').is(':visible')) {
        var updatedUserInfo = {
            user: updatedUser,
            message: [$('#up-verify-password input').val()]
        }
        xhr.open("POST", "updateaccount", true);
        xhr.send(JSON.stringify(updatedUserInfo));
    } else {
        $('#up-confirm-password input').val("");
        $('#up-password').val("");
        $('#up-verify-password input').val("");
        $('#up-verify-password input').focus();
        $('#invalid-confirm-password').html("Passwords do not match");
    }
}

function createAccount() {
    $('.bad-username').hide(); // Refactor this 
    $('.bad-password').hide(); // * 
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

    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4 && xhr.status == 200) {
            var ui = JSON.parse(xhr.responseText);
            var currUser = ui.user;
            var message = ui.message;
            if (currUser == null) {
                if (message[0] != null) {
                    $('#username').val("");
                    $('#invalid-username').html(message[0])
                }
                if (message[1] != null) {
                    $('#email').val("");
                    $('#invalid-email').html(message[1]);
                }
                $('#password').val("");
                $('#confirm-password').val("");
            } else {
                loadMainPage();
            }
        }
    }

    if (user.username != "" && user.password != "" &&
        user.firstName != "" && user.lastName != "" &&
        user.email != "" && $('#confirm-password').val() != "" &&
        $('#confirm-password').val() == user.password) {
        var userString = JSON.stringify(user);
        xhr.open("POST", "createAccount", true);
        xhr.send(userString);
    } else if ($('#confirm-password').val() != user.password) {
        $('#password').val("");
        $('#confirm-password').val("");
        $('#invalid-confirm-password').html("Password and confirm password do not match.");
    }
}

function createTicket() {
    var ticket = {
        reimbId: 0,
        amount: $('#amount').val(),
        submitted: null,
        resolved: null,
        description: $('#description').val(),
        receipt: null,
        author: 0,
        resolver: 0,
        statusId: 0,
        typeId: $('#reimb-type').val()
    }

    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4 && xhr.status == 200) {
            // getEmployeeTicketInfo();
            var newRow = [];
            newRow[0] = JSON.parse(xhr.responseText);
            console.log(xhr.responseText);
            console.log(newRow);
            let submitted = moment(newRow[0].submitted);
            newRow[0].submitted = submitted.format("MM-DD-YY HH:mm");
            if (newRow[0].resolved != null) {
                let resolved = moment(newRow[0].resolved);
                newRow[0].resolved = resolved.format("MM-DD-YY HH:mm");
            }
            $("#reimb-table").tabulator("addData", newRow);
        }
    }

    var ticketString = JSON.stringify(ticket);
    xhr.open("POST", "createticket", true);
    xhr.send(ticketString);

    $('#amount').val("0");
    $('#description').val("");
    $('#reimb-type').val("");
}

function getUser() {
    var currUser = {};
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4 && xhr.status == 200) {
            currUser = JSON.parse(xhr.responseText);
            document.getElementById('navbarDropdown').innerHTML =
                `${currUser.firstName} ${currUser.lastName}`;
            if (currUser.roleId == 1) {
                getEmployeeTicketInfo();
            }
            else if (currUser.roleId == 2) {
                $("#all-reimbs").show();
                $("#user-reimbs").hide();
                getAllTicketInfo();
                getEmployeeTicketInfo();
            }
        }
    }
    xhr.open("GET", "getuser", true);
    xhr.send();
}

function getAccountInfo() {
    var currUser = {};
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4 && xhr.status == 200) {
            currUser = JSON.parse(xhr.responseText);
            $('#up-email').val(currUser.email);
            $('#up-username').val(currUser.username);
            $('#up-password').val(currUser.password);
            $('.ma-input').attr('readonly', true);
            $('#ma-submit').attr('disabled', true);
        }
    }
    xhr.open("GET", "getuser", true);
    xhr.send();
}

function getEmployeeTicketInfo() {
    $("#reimb-table").tabulator({
        height: 400,
        index: "reimbId",
        layout: 'fitColumns',
        pagination: "local",
        paginationSize: 8,
        selectable: 0,
        columns: [
            { title: "Ticket #:", field: "reimbId" },
            { title: "Status:", field: "status" },
            { title: "Type:", field: "type" },
            { title: "Amount:", field: "amount", formatter: "money" },
            { title: "Description:", field: "description" },
            { title: "Submitted:", field: "submitted", sorter: "date", sorterParams: { format: "MM-DD-YY" } },
            { title: "Resolved:", field: "resolved", sorter: "date", sorterParams: { format: "MM-DD-YY" } },
            { title: "Resolved by:", field: "resolver" }
        ],
        ajaxResponse: function (url, params, response) {
            for (x in response) {
                let submitted = moment(response[x].submitted);
                response[x].submitted = submitted.format("MM-DD-YY HH:mm");
                if (response[x].resolved != null) {
                    let resolved = moment(response[x].resolved);
                    response[x].resolved = resolved.format("MM-DD-YY HH:mm");
                }
            }
            return response; //return the tableData peroperty of a response json object
        }
    });
    // let filter = [{field:"status", type:"=", value:"PENDING"}];
    $("#reimb-table").tabulator("setData", '/ERSProject/getemployeetickets');
    $("#reimb-table").tabulator("setFilter", pendingFilter);
    $("#reimb-table").tabulator("clearSort");
    $("#reimb-table").tabulator("setSort", "submitted", "desc");
    // filterUpdater();
    // console.log("getEmployeeTickets");
}

function resolveTicket(id, status) {
    var data = [id, status];
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4 && xhr.status == 200) {
            let currentFilter = $("#reimb-table-manager").tabulator("getFilters");
            $("#reimb-table-manager").tabulator("setData", '/ERSProject/getalltickets');
            $("#reimb-table-manager").tabulator("setFilter", currentFilter);
        }
    }
    xhr.open("POST", "resolveticket", true);
    xhr.send(JSON.stringify(data));
}

function getAllTicketInfo() {
    var statusEditor = function (cell, onRendered, success, cancel) {
        var editor = $(`
        <select>
        <option value='PENDING'>PENDING</option>
        <option value='APPROVED'>APPROVED</option>
        <option value='DENIED'>DENIED</option>
        </select>
        `);

        editor.css({
            "padding": "3px",
            "width": "100%",
            "box-sizing": "border-box",
        });

        var currentVal = cell.getValue();
        editor.val(cell.getValue());
        onRendered(function () {
            editor.focus();
            editor.css("height", "100%");
        });

        var row = cell.getRow().getData();
        editor.on("change blur", function (e) {
            success(editor.val());
            if (currentVal != editor.val())
                resolveTicket(row.reimbId, editor.val());
        });
        return editor;
    };
    var statusCheck = function (cell) {
        if (cell.getValue() == 'PENDING') {
            return true;
        } else {
            return false;
        }
    };
    $("#reimb-table-manager").tabulator({
        height: 400,
        index: "reimbId",
        layout: 'fitColumns',
        pagination: "local",
        paginationSize: 8,
        selectable: 0,
        columns: [
            { title: "Ticket #:", field: "reimbId" },
            { title: "Author:", field: "author" },
            { title: "Status:", field: "status", editor: statusEditor, editable: statusCheck },
            { title: "Type:", field: "type" },
            { title: "Amount:", field: "amount", formatter: "money" },
            { title: "Description:", field: "description" },
            { title: "Submitted:", field: "submitted", sorter: "date", sorterParams: { format: "MM-DD-YY" } },
            { title: "Resolved:", field: "resolved", sorter: "date", sorterParams: { format: "MM-DD-YY" } },
            { title: "Resolved by:", field: "resolver" }
        ],
        ajaxResponse: function (url, params, response) {
            for (x in response) {
                let submitted = moment(response[x].submitted);
                response[x].submitted = submitted.format("MM-DD-YY HH:mm");
                if (response[x].resolved != null) {
                    let resolved = moment(response[x].resolved);
                    response[x].resolved = resolved.format("MM-DD-YY HH:mm");
                }
            }
            return response; //return the tableData peroperty of a response json object
        }
    });

    $("#reimb-table-manager").tabulator("setData", '/ERSProject/getalltickets');
    $("#reimb-table-manager").tabulator("setFilter", pendingFilter);
    $("#reimb-table-manager").tabulator("clearSort");
    $("#reimb-table-manager").tabulator("setSort", "submitted", "desc");
    filterUpdater();
    // $("#reimb-table").tabulator("setData", '/ERSProject/getemployeetickets');
}
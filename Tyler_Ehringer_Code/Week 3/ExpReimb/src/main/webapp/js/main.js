/**
 * 
 */
$(document).ready(() => {
    loadLandingPage();
    $("#homeButton").click(() => {
        loadLandingPage();
    });
    $("#loginAction").click(() => {
        loadLoginPage();
    });
})

function loadLandingPage() {
    $("#mainWindow").load("landing.view", () => {
        $("#loginButton").click(() => {
            $("#mainWindow").load("login.view", loadLoginPage);
        });
        $("#registerButton").click(() => {
            $("#mainWindow").load("register.view", loadRegisterPage)
        });
    });
}

function loadLoginPage() {
    $("#mainWindow").load("login.view", () => {

    });
}

function loadRegisterPage() {
    $("#mainWindow").load("register.view", () => {

    });
}
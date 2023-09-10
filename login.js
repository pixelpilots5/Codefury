// Validation for the login form
document.getElementById("login-form").addEventListener("submit", function (e) {
    const email = document.getElementById("email").value;
    const password = document.getElementById("password").value;
    const errorMessage = document.querySelector(".error-message");

    if (!email || !password) {
        errorMessage.textContent = "Please fill in all fields.";
        e.preventDefault(); // Prevent form submission
    }
});

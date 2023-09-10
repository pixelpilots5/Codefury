// Validation for the registration form
document.getElementById("register-form").addEventListener("submit", function (e) {
    const email = document.getElementById("email").value;
    const role = document.getElementById("role").value;
    const password = document.getElementById("password").value;
    const confirmPassword = document.getElementById("confirm-password").value;
    const errorMessage = document.querySelector(".error-message");

    if (!email || !role || !password || !confirmPassword) {
        errorMessage.textContent = "Please fill in all fields.";
        e.preventDefault(); // Prevent form submission
        return;
    }

    if (password !== confirmPassword) {
        errorMessage.textContent = "Passwords do not match.";
        e.preventDefault(); // Prevent form submission
    }
});
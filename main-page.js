document.addEventListener("DOMContentLoaded", function () {
    // Get references to form elements
    const loginForm = document.getElementById("login-form");
    const emailInput = document.getElementById("email");
    const passwordInput = document.getElementById("password");
    // Add a submit event listener to the form
    loginForm.addEventListener("submit", function (event) {
      event.preventDefault(); // Prevent the default form submission
      // Perform your login validation here (e.g., check credentials)
    const email = emailInput.value;
    const password = passwordInput.value;
      // Example validation (Replace this with your actual validation logic)
    if (email === "example@email.com" && password === "password123") {
        // Redirect to the main page (change the URL accordingly)
        window.location.href = "main-page.html";
    } else {
        alert("Invalid credentials. Please try again.");
    }
    });
});
// Validation for the import users form
document.getElementById("import-users-form").addEventListener("submit", function (e) {
    const userFile = document.getElementById("user-file").value;
    const errorMessage = document.querySelector(".error-message");

    if (!userFile) {
        errorMessage.textContent = "Please select a file to import.";
        e.preventDefault(); // Prevent form submission
    }
});
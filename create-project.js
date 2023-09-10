// JavaScript for the Create New Project page

// Function to validate the start date
function validateStartDate() {
    const startDateInput = document.getElementById("start-date");
    const startDate = new Date(startDateInput.value);
    const currentDate = new Date();

    // Calculate the date 2 days later than the current date
    const minStartDate = new Date(currentDate);
    minStartDate.setDate(currentDate.getDate() + 2);

    if (startDate < minStartDate) {
        alert("Start date should be at least 2 days later than the current date.");
        startDateInput.value = "";
        return false;
    }

    return true;
}

// Function to validate team member assignments
function validateTeamMembers() {
    const teamMembersSelect = document.getElementById("team-members");
    const selectedTeamMembers = Array.from(teamMembersSelect.selectedOptions);

    // Implement validation rules for team member assignments here
    // For example, check if developers can be assigned to only one project, etc.

    // Example: Check if testers can be assigned to a maximum of 2 projects
    const testerCount = selectedTeamMembers.filter(option => option.value.startsWith("tester")).length;
    if (testerCount > 2) {
        alert("Testers can be assigned to a maximum of 2 projects.");
        return false;
    }

    return true;
}

document.getElementById("create-project-form").addEventListener("submit", function (e) {
    e.preventDefault();

    // Validate the start date
    if (!validateStartDate()) {
        return;
    }

    // Validate team member assignments
    if (!validateTeamMembers()) {
        return;
    }

    // Generate a unique project ID (replace with your own logic)
    const projectId = generateUniqueId();

    // Set the project status to "In Progress"
    const projectStatus = "In Progress";

    // Collect form data
    const projectName = document.getElementById("project-name").value;
    const startDate = document.getElementById("start-date").value;
    const description = document.getElementById("description").value;
    const teamMembersSelect = document.getElementById("team-members");
    const selectedTeamMembers = Array.from(teamMembersSelect.selectedOptions).map(option => option.value);

    // Create a project object with the collected data
    const project = {
        id: projectId,
        name: projectName,
        startDate: startDate,
        description: description,
        status: projectStatus,
        teamMembers: selectedTeamMembers,
    };

    // Send the project data to the server for storage (replace with your server-side logic)

    // Clear the form
    document.getElementById("create-project-form").reset();

    alert("Project created successfully!");
});

// Function to generate a unique ID (dummy implementation)
function generateUniqueId() {
    return Date.now().toString(36) + Math.random().toString(36).substr(2);
}
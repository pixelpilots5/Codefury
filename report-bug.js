// Simulated user data (replace with actual user data)
const currentUser = {
    username: "tester",
    assignedProjects: ["Project 1", "Project 2"], // Projects the tester is assigned to
};

// Function to check if the user can report a bug for a given project
function canReportBug(projectName) {
    // Check if the user is a tester
    if (currentUser.username !== "tester") {
        return false;
    }

    // Check if the user is assigned to the project
    if (!currentUser.assignedProjects.includes(projectName)) {
        return false;
    }

    // Check if the project status is "in-progress" (replace with actual project status check)
    const projectStatus = "in-progress";
    if (projectStatus !== "in-progress") {
        return false;
    }

    return true;
}

document.getElementById("report-bug-form").addEventListener("submit", function (e) {
    e.preventDefault();

    const projectName = document.getElementById("project-name").value;
    const bugTitle = document.getElementById("bug-title").value;
    const bugDescription = document.getElementById("bug-description").value;
    const severityLevel = document.getElementById("severity-level").value;

    // Check if the user can report a bug for the selected project
    if (!canReportBug(projectName)) {
        alert("You cannot report a bug for this project.");
        return;
    }

    // Generate a unique ID (you can implement your own logic for this)
    const bugId = generateUniqueId();

    // Get the current date and time
    const createdOn = new Date().toLocaleString();

    // Create a bug object
    const bug = {
        id: bugId,
        projectName: projectName,
        title: bugTitle,
        description: bugDescription,
        severity: severityLevel,
        createdBy: currentUser.username,
        createdOn: createdOn,
    };

    // Send the bug data to the server for storage (replace with actual server communication)

    // Clear the form
    document.getElementById("report-bug-form").reset();

    alert("Bug reported successfully!");
});

// Function to generate a unique ID (dummy implementation)
function generateUniqueId() {
    return Date.now().toString(36) + Math.random().toString(36).substr(2);
}
// JavaScript for loading and displaying the bug list

// Simulated bug data (replace with actual bug data)
const bugData = [
    {
        id: 1,
        title: "Bug 1",
        description: "Description of Bug 1",
        status: "Open",
        assignedTo: "John Doe",
    },
    {
        id: 2,
        title: "Bug 2",
        description: "Description of Bug 2",
        status: "In Progress",
        assignedTo: "Jane Smith",
    },
    // Add more bug data as needed
];

// Function to display the bug list
function displayBugList() {
    const bugListContainer = document.getElementById("bug-list");

    // Create a table for displaying the bug list
    const table = document.createElement("table");
    table.classList.add("bug-table");

    // Create table headers
    const thead = document.createElement("thead");
    const headerRow = document.createElement("tr");
    const headers = ["Bug ID", "Title", "Description", "Status", "Assigned To", "Actions"];
    
    headers.forEach(headerText => {
        const th = document.createElement("th");
        th.textContent = headerText;
        headerRow.appendChild(th);
    });

    thead.appendChild(headerRow);
    table.appendChild(thead);

    // Create table body with bug data
    const tbody = document.createElement("tbody");
    
    bugData.forEach(bug => {
        const row = document.createElement("tr");

        // Create table cells for bug properties
        const cells = ["id", "title", "description", "status", "assignedTo"];

        cells.forEach(cellName => {
            const cell = document.createElement("td");
            cell.textContent = bug[cellName];
            row.appendChild(cell);
        });

        // Create action buttons (e.g., assign and close)
        const actionCell = document.createElement("td");
        const assignButton = document.createElement("button");
        assignButton.textContent = "Assign";
        const closeButton = document.createElement("button");
        closeButton.textContent = "Close";

        // Add click event listeners for assign and close buttons (implement your logic here)
        assignButton.addEventListener("click", () => {
            // Logic to assign the bug to a developer
        });

        closeButton.addEventListener("click", () => {
            // Logic to close the bug
        });

        actionCell.appendChild(assignButton);
        actionCell.appendChild(closeButton);
        row.appendChild(actionCell);

        tbody.appendChild(row);
    });

    table.appendChild(tbody);
    bugListContainer.appendChild(table);
}

// Call the function to display the bug list when the page loads
displayBugList();
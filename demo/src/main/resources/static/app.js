// Simulate database using an array
let events = [];

document.getElementById('eventForm').addEventListener('submit', function(e) {
    e.preventDefault();

    // Get form values
    const date = document.getElementById('date').value;
    const time = document.getElementById('time').value;
    const venueID = document.getElementById('venueID').value;
    const coordinatorID = document.getElementById('coordinatorID').value;
    
    // Check if updating existing event or adding a new one
    const eventId = document.getElementById('eventId').value;
    if (eventId) {
        // Update existing event
        const event = events.find(event => event.id === parseInt(eventId));
        event.date = date;
        event.time = time;
        event.venueID = venueID;
        event.coordinatorID = coordinatorID;
    } else {
        // Add new event
        const newEvent = {
            id: events.length + 1,
            date,
            time,
            venueID,
            coordinatorID
        };
        events.push(newEvent);
    }
    
    // Reset form and update table
    this.reset();
    document.getElementById('eventId').value = '';
    updateEventTable();
});

function updateEventTable() {
    const tbody = document.querySelector('#eventTable tbody');
    tbody.innerHTML = '';

    events.forEach(event => {
        const tr = document.createElement('tr');
        tr.innerHTML = `
            <td>${event.date}</td>
            <td>${event.time}</td>
            <td>${event.venueID}</td>
            <td>${event.coordinatorID}</td>
            <td class="actions">
                <button onclick="editEvent(${event.id})">Edit</button>
                <button onclick="deleteEvent(${event.id})">Delete</button>
            </td>
        `;
        tbody.appendChild(tr);
    });
}

function editEvent(id) {
    const event = events.find(event => event.id === id);
    document.getElementById('date').value = event.date;
    document.getElementById('time').value = event.time;
    document.getElementById('venueID').value = event.venueID;
    document.getElementById('coordinatorID').value = event.coordinatorID;
    document.getElementById('eventId').value = event.id;
}

function deleteEvent(id) {
    events = events.filter(event => event.id !== id);
    updateEventTable();
}

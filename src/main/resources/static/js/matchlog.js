// Wait until the DOM is fully loaded before attaching event listeners
document.addEventListener('DOMContentLoaded', () => {
    // Select the form by its ID (make sure your form has id="match-form")
    const form = document.getElementById('match-form');

    // Attach a submit event listener to the form
    form.addEventListener('submit', async (event) => {
        // Prevent the default form submission which reloads the page
        event.preventDefault();

        // Create a FormData object from the form to easily extract input values
        const formData = new FormData(form);

        // Convert FormData entries into a plain object to send as JSON
        const data = {};
        formData.forEach((value, key) => {
            data[key] = value;
        });

        try {
            // Send the form data to the server using fetch with POST method
            const response = await fetch('/submit', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',  // Tell server we're sending JSON
                },
                body: JSON.stringify(data),  // Convert the data object to a JSON string
            });

            // Parse the response text from the server
            const message = await response.text();

            if (response.ok) {
                // Show a confirmation alert with the message from the server
                alert(message);

                // Optionally reset the form after successful submission
                form.reset();
            } else {
                // Handle HTTP errors by showing the status and message
                alert(`Error ${response.status}: ${message}`);
            }
        } catch (error) {
            // Catch network or other errors and display a user-friendly message
            alert(`Submission failed: ${error.message}`);
        }
    });
});

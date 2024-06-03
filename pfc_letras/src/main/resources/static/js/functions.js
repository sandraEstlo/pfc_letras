document.addEventListener('DOMContentLoaded', () => {
    const button = document.getElementById("dropdown-button");
    const dropdownMenu = document.getElementById('dropdown-menu3')

    button.onclick = () => {
       var _= dropdownMenu.style.visibility === "visible" ? dropdownMenu.style.visibility = "hidden"
                                                                 : dropdownMenu.style.visibility = "visible";
    }
});

document.addEventListener('DOMContentLoaded', (event) => {
    const currentUrl = window.location.pathname;
    const urlparam = new URLSearchParams(window.location.search);

    if (urlparam.has('error')) {
        switch(currentUrl){
            case '/login'    : createAlert('Error al iniciar sesión.','warning'); break;
            case '/register' : const message = document.getElementById('message-error').getAttribute('data-error');
                               if (message != null)
                                   createAlert(message, 'warning');
                               break;
        }
    }

    // Add event listener for notification delete buttons
    (document.querySelectorAll('.notification .delete') || []).forEach(($delete) => {
        const $notification = $delete.parentNode;
        $delete.addEventListener('click', () => {
            $notification.parentNode.removeChild($notification);
        });
    });
});


function createAlert(message, type) {
    const alertPlaceholder = document.getElementById('liveAlertPlaceholder');
    var color = '';

    const appendAlert = (message, type) => {
        const wrapper = document.createElement('div');
        wrapper.className = `notification is-${type} is-light`;
        wrapper.setAttribute('role', 'alert');

        const icon = document.createElement('span');
        icon.className = 'mdi';
        switch (type) {
            case 'warning':
                color = '#EBAC75';
                icon.classList.add('mdi-alert');
                icon.style.color = color;
                break;
            default:
                icon.className = '';
        }

        const messageDiv = document.createElement('div');
        messageDiv.appendChild(icon);
        messageDiv.appendChild(document.createTextNode(` ${message}`));
        messageDiv.style.color = color;
        wrapper.appendChild(messageDiv);

        const closeButton = document.createElement('button');
        closeButton.type = 'button';
        closeButton.className = 'delete';
        closeButton.style.background = color;
        closeButton.setAttribute('data-bs-dismiss', 'alert');
        closeButton.setAttribute('aria-label', 'Close');
        wrapper.appendChild(closeButton);

        alertPlaceholder.appendChild(wrapper);
    };

    appendAlert(message, type);
}


function createLoan() {
    const bookId = document.getElementById('book-id').getAttribute('data-bookId');
    const userId = document.getElementById('user-id').getAttribute('data-userId');
    alert('book id: '+ bookId + ' || user name: ' + userId);
}
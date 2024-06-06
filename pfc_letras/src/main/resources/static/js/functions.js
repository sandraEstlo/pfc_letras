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
});


function createAlert(message, type) {
    const alertPlaceholder = document.getElementById('liveAlertPlaceholder');
    var color = '';

    const appendAlert = (message, type) => {
        const wrapper = document.createElement('div');
        wrapper.className = `notification is-${type} is-light`;
        wrapper.setAttribute('role', 'alert');
        wrapper.style.position = 'fixed';
        wrapper.style.right = '10px';
        wrapper.style.padding = '10px';
        wrapper.style.width = 'auto';
        wrapper.style.height = 'auto';
        wrapper.style.zIndex = '999';

        const icon = document.createElement('span');
        icon.className = 'mdi';
        switch (type) {
            case 'warning':
                color = '#EBAC75';
                icon.classList.add('mdi-alert');
                icon.style.color = color;
                break;
            case 'success':
                color = '#95B26D';
                icon.classList.add('mdi-check-circle');
                icon.style.color = color;
                break;
            default:

        }

        const messageDiv = document.createElement('div');
        messageDiv.appendChild(icon);
        messageDiv.appendChild(document.createTextNode(` ${message}`));
        messageDiv.style.color = color;
        messageDiv.style.margin = '10px 40px 10px 10px'
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

    (document.querySelectorAll('.notification .delete') || []).forEach(($delete) => {
        const $notification = $delete.parentNode;
        $delete.addEventListener('click', () => {
            $notification.parentNode.removeChild($notification);
        });
    });
}


function createLoan(bookId) {

    // const bookId = document.getElementById('book-id').getAttribute('data-bookId');
    // const userId = document.getElementById('user-id').getAttribute('data-userId');
    // alert('book id: '+ bookId + ' || user name: ' + userId);

    const data = {
        userId: document.getElementById('user-id').getAttribute('data-userId'),
        bookIds: [bookId],
        operation: 'PRESTAR'
    };

    const options = {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data) // Aquí se convierte el objeto en JSON
    };

    fetch("/new", options)
        .then(response => {
            switch (response.status){
                case 201:
                    createAlert('La reserva se ha creado correctamente.','success')
                    break;
                case 403:
                    return response.json().then(data => {
                        createAlert(data.message, 'warning');
                        throw new Error(data.message);
                    });
                default:
                    createAlert('Ha ocurrido un error inesperado.','warning')
            }
            return response.json();
        })
        .then(data => {
            // Manejar la respuesta del servidor si es necesario
            console.log('Respuesta del servidor:', data);
        })
        .catch(error => {
            console.error('Error en la solicitud:', error);
        });

}
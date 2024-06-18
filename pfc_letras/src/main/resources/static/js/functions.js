
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
    const data = {
        userId: document.getElementById('user-id').getAttribute('data-userId'),
        bookIds: [bookId],
        operation: 'RESERVAR'
    };

    const options = {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    };

    fetch("/letras/new", options)
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
                    createAlert('Ha ocurrido un error al intentar renovar el prestamo.','warning')
            }
            return response.json();
        })
        .then(data => {
            console.log('Respuesta del servidor:', data);
        })
        .catch(error => {
            console.error('Error en la solicitud:', error);
        });
}

function updateLoan(button) {
    const data = {
        loanId: button.getAttribute('data-loan-id'),
        userId: button.getAttribute('data-user-id'),
        bookIds: [button.getAttribute('data-book-id')],
        operation: 'RENOVAR'
    };

    const options = {
        method: 'PUT',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(data)
    }

    fetch("/letras/renovate", options)
        .then(response => {
            switch (response.status){
                case 200:
                    createAlert('La reserva se ha actualizado correctamente.','success')
                    break;
                case 403:
                    return response.json().then(data => {
                        createAlert(data.message, 'warning');
                        throw new Error(data.message);
                    });
                default:
                    createAlert('Ha ocurrido un error inesperado.','warning')
            }
        })
        .then(data => {
            console.log('Respuesta del servidor:', data);
        })
        .catch(error => {
            console.error('Error en la solicitud:', error);
        });
}
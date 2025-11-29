function showMessage(message, type) {
    const popup = document.getElementById('PopupMessage');
    const icon = document.getElementById('PopupIcon');
    const text = document.getElementById('PopupText');

    // Limpia todas las clases específicas previas
    popup.className = 'PopupMessage';

    // Define el contenido del ícono y agrega la clase según el tipo
    let iconContent = '';
    switch (type) {
        case 1: // Success
            iconContent = '✅';
            popup.classList.add('success');
            break;
        case 2: // Info
            iconContent = 'ℹ️';
            popup.classList.add('info');
            break;
        case 3: // Warning
            iconContent = '⚠️';
            popup.classList.add('warning');
            break;
        case 4: // Error
            iconContent = '❌';
            popup.classList.add('error');
            break;
        default:
            console.error('Tipo de popup desconocido: ' + type);
            return; // No muestra el popup si el tipo es inválido
    }

    // Actualiza el ícono y el texto
    icon.innerText = iconContent;
    text.innerText = message;

    // Muestra el popup
    popup.style.display = 'block';

    // Oculta automáticamente después de 2 segundos
    setTimeout(() => {
        popup.style.display = 'none';
    }, 1000);
}

/*

function showConfirm(message) {
    return new Promise((resolve) => {
        const popup = document.getElementById('ConfirmationPopup');
        const overlay = document.getElementById('Overlay');
        const text = document.getElementById('PopupTextComfir');
        const confirmButton = document.getElementById('PopupConfirmButton');
        const cancelButton = document.getElementById('PopupCancelButton');

        // Configura el texto del popup
        text.innerText = message;

        // Muestra el popup y el overlay
        overlay.style.display = 'block';
        popup.style.display = 'block';

        // Maneja la opción de "Aceptar"
        confirmButton.onclick = () => {
            popup.style.display = 'none';
            overlay.style.display = 'none';
            resolve(true); // Devuelve true si se selecciona "Aceptar"
        };

        // Maneja la opción de "Cancelar"
        cancelButton.onclick = () => {
            popup.style.display = 'none';
            overlay.style.display = 'none';
            resolve(false); // Devuelve false si se selecciona "Cancelar"
        };
    });
}

*/

function showConfirm(titulo,message) {
    return new Promise((resolve) => {
        const popup = document.getElementById('ConfirmationPopup');
		const overlay = document.getElementById('Overlay');
        const text = document.getElementById('PopupTextComfir');
		const tittle = document.getElementById('PopupTextTittle');
		
        const confirmButton = document.getElementById('PopupConfirmButton');
        const cancelButton = document.getElementById('PopupCancelButton');

        // Limpia clases previas y configura el tipo de popup
        popup.className = 'PopupMessage';
        popup.classList.add('default');
		text.innerText = message;
		tittle.innerText = titulo;
		
        // Muestra el popup
		overlay.style.display = 'block';
		popup.style.display = 'block';

				// Maneja la opción de "Aceptar"
		confirmButton.onclick = () => {
			popup.style.display = 'none';
		 	overlay.style.display = 'none';
			resolve(true); // Devuelve true si se selecciona "Aceptar"
		};

		// Maneja la opción de "Cancelar"
		cancelButton.onclick = () => {
			popup.style.display = 'none';
			overlay.style.display = 'none';
			resolve(false); // Devuelve false si se selecciona "Cancelar"
		};
		
    });
}




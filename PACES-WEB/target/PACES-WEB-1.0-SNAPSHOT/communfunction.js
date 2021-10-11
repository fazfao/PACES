/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 function deconnexion() { // Fonction appelée lors du clic sur le bouton
    console.log("clic sur le bouton deconnexion"); // LOG dans Console Javascript
    //
    // Appel AJAX
    $.ajax({
            url: './ActionServlet',
            method: 'POST',
            data: {
                todo: 'deconnecter'
            }
        })
        .done(function(response) { // Fonction appelée en cas d'appel AJAX réussi
            alert("Disconnecting...");
            console.log('Response', response.succes); // LOG dans Console Javascript
            window.location.href = "./login.html";
        })
        .fail(function(error) { // Fonction appelée en cas d'erreur lors de l'appel AJAX
            console.log('Error', error); // LOG dans Console Javascript
            alert("Erreur lors de l'appel AJAX");
        })
        .always(function() { // Fonction toujours appelée
        });
}


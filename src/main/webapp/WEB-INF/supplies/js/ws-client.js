// Script to utilise the WebSocket
var webSocket;
var chatBox = document.getElementById("chat_box");

function openSocket() {
    // Ensures only one connection is open at a time
    if (webSocket !== undefined && webSocket.readyState !== WebSocket.CLOSED) {
        writeResponse("WebSocket is already opened : " + webSocket.sessionId);
        return;
    }

    // Create a new instance of the websocket
    webSocket = new WebSocket("ws://localhost:8080/chatter_war_exploded/chatter/begin");
    webSocket.onopen = function(event) {
        // For reasons I can't determine, onopen gets called twice
        // and the first time event.data is undefined.
        if (event.data === undefined)
            return;

        writeResponse(event.data);
    };

    webSocket.onmessage = function(event) {
        writeResponse(event.data);
    };

    webSocket.onclose = function(event) {
        writeResponse("Connection closed : " + event.data);
    };

    webSocket.onerror = function(event) {
        writeResponse("Connection error : " + event.data);
    };
}

/**
 * Sends the value of the text input to the server
 */
function send() {
    var text = document.getElementById("message_input").value;
    webSocket.send(text);
}
function closeSocket() {
    webSocket.close();
}
function writeResponse(text) {
    chatBox.innerHTML += "<br/>" + text;
}
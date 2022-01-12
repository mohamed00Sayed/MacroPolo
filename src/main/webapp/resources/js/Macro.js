/**
 * this file was created by Mohammad Sayed
 */
var url = 'http://' + window.location.host + '/MacroPolo/macro';
var sock = new SockJS(url);
sock.onopen = function() {
	console.log('Opening');
	sayMarco();
};

sock.onmessage = function(e) {
	console.log('Received message: ', e.data);
	setTimeout(function(){sayMarco()}, 2000);
};

sock.onclose = function() {
	console.log('Closing');
};

function sayMarco() {
	console.log('Sending Marco!');
	sock.send("Macro!");
}

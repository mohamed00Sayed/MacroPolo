/**
 *this file was created by Mohammad Sayed.
 */
var url = 'http://' + window.location.host + '/MacroPolo/macropolo';
var sock = new SockJS(url);
var stomp = Stomp.over(sock);
var payload = JSON.stringify({ 'message': 'Macro!' });
stomp.connect('guest', 'guest', function(frame) {
	stomp.subscribe("/topic/shout")
	stomp.subscribe("/app/macro")
	stomp.send("/app/macro", {}, payload);
});
stomp.onmessage = function(e) {
	console.log('Received message: ', e.data);
	setTimeout(function(){sayMarco()}, 2000);
};

function sayMarco() {
	console.log('Sending Marco!');
	stomp.send("/app/macro", {}, payload);
}

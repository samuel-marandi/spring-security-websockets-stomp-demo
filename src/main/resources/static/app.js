var stompClient = null;

const subscriptionHeader = {
  id: Math.random().toString(36).substring(5),
};

function setConnected(connected) {
  $("#connect").prop("disabled", connected);
  $("#disconnect").prop("disabled", !connected);
  if (connected) {
    $("#conversation").show();
  }
  else {
    $("#conversation").hide();
  }
  $("#greetings").html("");
}

function subscription_call_back(response) {
  showGreeting(JSON.parse(response.body).content);
}

function connect_call_back(frame, socket) {
  // setConnected(true);
  console.log('Connected: ' + frame);
  console.log("Session Id", socket._transport.url);
  
  /**
   *  Subscribe takes 3 parameters
   *  1. the subscription endpoint url
   *  2. Callback for the response
   *  3. Headers for the subscription event
   */
  stompClient.subscribe('/topic/greetings', subscription_call_back, subscriptionHeader);
}

function connect() {
  const socket = new SockJS('/gs-guide-websocket');
  stompClient = Stomp.over(socket);
  stompClient.connect({}, (frame) => connect_call_back(frame, socket));
}

function disconnect() {
  if (stompClient !== null) {
    stompClient.disconnect();
  }
  setConnected(false);
  console.log("Disconnected");
}

function sendName() {
  stompClient.send("/app/hello", {}, JSON.stringify({'name': $("#name").val()}));
}

function showGreeting(message) {
  $("#greetings").append("<tr><td>" + message + "</td></tr>");
}

$(function () {
  $("form").on('submit', function (e) {
    e.preventDefault();
  });
  $( "#connect" ).click(function() { connect(); });
  $( "#disconnect" ).click(function() { disconnect(); });
  $( "#send" ).click(function() { sendName(); });
});

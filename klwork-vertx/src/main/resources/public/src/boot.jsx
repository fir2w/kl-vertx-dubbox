import ReactDOM from 'react-dom';
import MyRoutes from './routes';

var getEventBus = () =>
{
  const EventBus = require('vertx3-eventbus-client');
  return (new EventBus('http://localhost:18080/eventbus'));
};


var eb = getEventBus();

const send = () =>
{
  eb.publish("chat.to.server", "who are you!");
};

eb.onopen = () =>
{
  eb.registerHandler("chat.to.client", function (err, msg) {
    console.log("chat.to.client" + msg);
  });
  console.log("EVENT BUS OPEN");

  window.setInterval(
    send,
    10000
  );
};

eb.onclose = () =>
{
  console.log("EVENT BUS onclose");
};

eb.onerror = (err) =>
{
  console.error("EVENT BUS ERROR: " + JSON.stringify(err));
};

ReactDOM.render(MyRoutes, document.getElementById('main-container'));
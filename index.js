const express = require('express');
const    http = require('http');
const morgan = require('morgan');
const bodyParser = require('body-parser');
const dishRouter = require('./routes/dishRouter');


const hostname = 'localhost';
const port = 3000;

const app = express();
app.use(morgan('dev'));
app.use(bodyParser.json());

app.use('/dishes',dishRouter);

/*
app.get('/dishes/:dishId',(req, res, next) => {
    res.end('Enviandote el pedido ' + req.params.dishId);
});

app.post('/dishes/:dishId',(req, res, next) => {
    res.statusCode=403;
    res.end('Operacion no soportada ' + req.params.dishId);
});

app.put('/dishes/:dishId',(req, res, next) => {
    res.write('Actualizando el pedido ' + req.params.dishId + '\n');
    res.end('Actualizando el pedido ' + req.body.name +
    ' con la siguiente descripcion '+ req.body.description);
});

app.delete('/dishes/:dishId',(req, res, next) => {
    res.end('Eliminando el pedido ' + req.params.dishId);
});

*/
app.use(express.static(__dirname + '/public'));

app.use((req, res, next) => {
  console.log(req.headers);
  res.statusCode = 200;
  res.setHeader('Content-Type', 'text/html');
  res.end('<html><body><h1>This is an Express Server</h1></body></html>');

});

const server = http.createServer(app);

server.listen(port, hostname, () => {
  console.log(`Server running at http://${hostname}:${port}/`);
});
// server.js


var express = require('express');
var app = express();

app.set('port', 9000);

app.use(express.static(__dirname + '/public'));

// views is directory for all template files
app.set('views', __dirname + '/development/views');
app.set('view engine', 'ejs');

app.get('/', function (request, response) {
    response.render('login');
});

app.get('/login', function (request, response) {
    response.render('login');
});

app.get('/signup', function (request, response) {
    response.render('signup');
});
app.get('/home', function (request, response) {
    response.render('sparkhome');
});

app.listen(app.get('port'), function () {
    console.log('Node app is running on port', app.get('port'));
});

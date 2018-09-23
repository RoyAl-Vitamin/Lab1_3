// FROM https://buddy.works/guides/how-dockerize-node-application
// FROM https://medium.com/devschacht/node-hero-chapter-4-c2ebcd12565c
// Создан для сравнения с Java + Spring MVC

// Load express module with `require` directive
var express = require('express')
var app = express()
const port = 8081
var volatileVar = 0

//Define request response in root URL (/)
app.get('/round-robin', function (req, res) {
  volatileVar++
  res.statusCode = 200;
  res.setHeader('Content-Type', 'text/plain');
  res.send('Глобальный счётчик увеличен на 1')
})

app.get('/round-robin/stat', function (req, res) {
  res.statusCode = 200;
  res.setHeader('Content-Type', 'text/plain');
  res.send(volatileVar.toString())
})

app.get('/hash', function (req, res) {
  volatileVar++
  res.statusCode = 200;
  res.setHeader('Content-Type', 'text/plain');
  res.send('Глобальный счётчик увеличен на 1')
})

app.get('/hash/stat', function (req, res) {
  res.statusCode = 200;
  res.setHeader('Content-Type', 'text/plain');
  res.send(volatileVar.toString())
})

//Launch listening server on port 8081
app.listen(port, function () {
  console.log('app listening on port ' + port + '!')
})



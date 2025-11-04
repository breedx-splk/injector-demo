

const express = require('express')
const app = express()
const port = 3000

const YEAR_MIN = 1955
const YEAR_MAX = 2023 // Fast X

app.get('/car', (req, res) => {
  const year = randomYear()
  const make = randomMake(year)
  const model = randomModel(year, make)
  const car = { 
    year: year,
    make: make,
    model: model
  }
  res.send(JSON.stringify(car, undefined, 2))
})

app.listen(port, () => {
  console.log(`Cars microservice listening on ${port}`)
})

function randomYear(){
    return Math.floor(Math.random() * (YEAR_MAX - YEAR_MIN) + YEAR_MIN)
}

function randomMake(year){
    return "Toyota"
}

function randomModel(year, make){
    return "Camry"
}


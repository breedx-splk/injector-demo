

import express from 'express'
const app = express()
const port = 3000
import cars from './cars.json' with { type: "json"}

const YEAR_MIN = 1955
const YEAR_MAX = 2023 // Fast X

app.get('/car', (req, res) => {

  const i = Math.floor(Math.random() * cars.length)
  const rawCar = cars[i]
  const car = {
    year: rawCar.year,
    make: rawCar.make,
    model: rawCar.model,
    color: rawCar.color,
    url: `/static/${rawCar.file}`
  }
  res.send(JSON.stringify(car, undefined, 2))
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

app.use('/static', express.static('static'))
app.listen(port, () => {
  console.log(`Cars microservice listening on ${port}`)
})
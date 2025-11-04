

import express from 'express'
const app = express()
const port = 3001
import drivers from './drivers.json' with { type: "json"}

const MIN_AGE = 16;
const MAX_AGE = 50;

app.get('/driver', (req, res) => {
  const i = Math.floor(Math.random() * drivers.length)
  const rawDriver = drivers[i]
  const age = Math.floor(Math.random() * (MAX_AGE-MIN_AGE) + MIN_AGE)
  const driver = {
    firstName: rawDriver.firstName,
    lastName: rawDriver.lastName,
    age: age,
    url: `/static/${rawDriver.file}`
  }
  setTimeout(() => res.send(JSON.stringify(driver, undefined, 2)), 100)
})

app.use('/static', express.static('static'))
app.listen(port, () => {
  console.log(`Drivers microservice listening on ${port}`)
})
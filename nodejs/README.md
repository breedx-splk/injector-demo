
# nodejs

There are two microservices here, one for generating
cars and one for generating drivers.

<!--Car make/model data courtesy of https://github.com/abhionlyone/us-car-models-data.-->

## cars

```
npm install
npm app.js
```

Runs on port 3000.

`GET /car`

returns a json blob like this:

```json
{
  "year": 1989,
  "make": "Toyota",
  "model": "Camry",
  "color": "Black"
}
```

## drivers

Runs on port 3001.

`GET /driver` 

returns a json blob like this:

```json
tbd
```
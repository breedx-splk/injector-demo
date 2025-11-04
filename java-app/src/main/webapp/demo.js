
console.log('fast also furious')

window.onload = async () => {
  await randomBuildKit()
}

async function againClicked(){
  document.getElementById('againbtn').classList.remove('btn-danger')
  document.getElementById('againbtn').classList.add('btn-secondary')
  await randomBuildKit()
  document.getElementById('againbtn').classList.remove('btn-secondary')
  document.getElementById('againbtn').classList.add('btn-danger')
}

async function randomBuildKit(){
  console.log("Fetching random build kit...")
  const resp = await fetch("kit")
  const kit = await resp.json()
  console.log(kit)
  updateCarUi(kit);
  updateDriverUi(kit);
  document.getElementById('maincontent').classList.remove('invisible')
  document.getElementById('maincontent').classList.add('visible')
}

function updateCarUi(kit) {
  update('car-year', kit['car']['year'])
  update('car-make', kit['car']['make'])
  update('car-model', kit['car']['model'])
  update('car-color', kit['car']['color'])
  const carImgPath = kit['car']['url']; // we live with our poor choices
  const carImgUrl = `http://localhost:3000${carImgPath}`;
  document.getElementById('car-img').setAttribute('src', carImgUrl)
}

function updateDriverUi(kit) {
  const firstName = kit['driver']['firstName']
  const lastName = kit['driver']['lastName']
  const name = `${firstName} ${lastName}`
  const info = `${name} (${kit['driver']['age']})`
  update('driver-info', info)
  const driverImgPath = kit['driver']['url']; // we live with our poor choices
  const driverImgUrl = `http://localhost:3001${driverImgPath}`;
  document.getElementById('driver-img').setAttribute('src', driverImgUrl)
}

function update(id, content){
  const elem = document.getElementById(id);
  elem.innerHTML = content;
}
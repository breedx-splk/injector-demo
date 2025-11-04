
console.log('fast also furious')

window.onload = async () => {
  await randomBuildKit()
}

async function randomBuildKit(){
  console.log("Fetching random build kit...")
  const resp = await fetch("kit")
  const kit = await resp.json()
  console.log(kit)
  update('car-year', kit['car']['year'])
  update('car-make', kit['car']['make'])
  update('car-model', kit['car']['model'])
  update('car-color', kit['car']['color'])
  const imgPath = kit['car']['url']; // we live with our poor choices
  const imageUrl = `http://localhost:3000${imgPath}`;
  document.getElementById('car-img').setAttribute('src', imageUrl)
  document.getElementById('maincontent').classList.remove('invisible')
  document.getElementById('maincontent').classList.add('visible')
}

function update(id, content){
  const elem = document.getElementById(id);
  elem.innerHTML = content;

}
const showData = document.getElementById("show-data");
const button1 = document.getElementById("button1");
const button2 = document.getElementById("button2");
const button3 = document.getElementById("button3");

const nameDigimon = document.getElementById("nome");
const levelDigimon = document.getElementById("level");


const url = 'https://digimon-api.vercel.app/api/digimon';

button1.addEventListener("click", () => {
    getDigimonsData(url);
})

button2.addEventListener("click", () => {
    getDigimonsData(url + "/name/" + nameDigimon.value);

})

button3.addEventListener("click", () => {
    getDigimonsData(url + "/level/" + levelDigimon.value);
})


async function getDigimonsData(url){
    fetch(url, {
        method: "GET",
        mode: "cors",
        cache: "no-cache",
        credentials: "same-origin",
        headers: {
        "Content-Type": "application/json",
        },
    })
        .then((response) => {
        console.log("Resposta do server: ", response);
        return response.json();
        })
        .then(data => {
            // Extrair os nomes dos Digimons
            const digimonNames = data.map(digimon => digimon.name);
            const digimonImages = data.map(digimon => digimon.img);
            const tamanhoDaLista = digimonNames.length;

            showData.innerHTML = "";

            // Exibir os nomes em uma div
            const namesList = document.createElement('ul');
            digimonNames.forEach(name => {
                const listItem = document.createElement('li');
                listItem.textContent = name;
                namesList.appendChild(listItem);
            });

            showData.appendChild(namesList);

            if(tamanhoDaLista == 1){
                digimonImages.forEach(img => {

                    const imgElement = document.createElement('img');
                    imgElement.src = img;
                    imgElement.classList.add('centered-image');
    
                    showData.appendChild(imgElement);
                });

      
            }
        })
        .catch((error) => {
        console.error(error);
    });
}
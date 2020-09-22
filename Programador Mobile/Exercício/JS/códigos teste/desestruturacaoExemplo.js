const pessoas = [{
    nome: "Yuri",
    sobrenome: "Weilemann",
    idade: 26,
    empresa: "T2M - Test to Market",
    pokemon_favorito: "Umbreon",
    cpf: "14563464364",
    endereco: {
        rua: "São Sebastião",
        numero: 108,
        casa: "B"
    }
},
{
    nome: "Marcelo",
    sobrenome: "Collares",
    idade: 30,
    empresa: "NekIT",
    pokemon_favorito: "Pikachu",
    cpf: "56445412353",
    endereco: {
        rua: "Valhalla",
        numero: 85,
        casa: "F"
    }
}];

function mostrarNomeEmpresa(users) {
    users.map((batata) => {
        const {nome, empresa} = batata;
        const {rua} = batata.endereco;
        console.log(`${nome} é da empresa ${empresa} e mora na rua ${rua}`)
    })
}

mostrarNomeEmpresa(pessoas);
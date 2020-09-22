import React, { useState } from 'react'
 
function App() {
  const [Contador, setContador] = useState(0)
  
  const [Pessoas, setPessoas] = useState (
      {
          nome: 'Pedro',
          idade: 25
      }
  )
    
  return (
     
    <div>
        <div>
            Você clicou {Contador} vezes !<br></br> 
            <button onClick={() => setContador(Contador + 1)}>
            Mais um!
            </button>
        </div>
        <br/>
        <div>
           Seu nome é {Pessoas.nome} e você tem {Pessoas.idade} anos de idade ! <br></br>
           <button onClick={() => setPessoas({nome: 'Joao', idade: 29})}> outro </button>
        </div>
    </div>
   )
}

export default App;
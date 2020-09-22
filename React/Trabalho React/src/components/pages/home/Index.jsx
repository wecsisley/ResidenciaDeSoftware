import '../../../../src/App.css'
import React from 'react'
import Card from '../../../components/layout/Card'
import foto from '../../../assets/image/eletrodomesticos.jpg'

const Home = (props) => {

        const home = {
            descricao: 'Eletrodoméstico',
            imagem: foto
        }

    return (
        <Card titulo={home.descricao} color="#982395">
            <img src={home.imagem}></img>
            <div className='botoesCards'>
                <button>Info</button> &nbsp;&nbsp;&nbsp;
                <button>Atualizar</button> &nbsp;&nbsp;&nbsp;
                <button>Excluir</button>
            </div>
        </Card>
    )
}

export default Home;
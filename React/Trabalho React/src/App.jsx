import './App.css'
import React from 'react'
import Card from './components/layout/Card'
import Index from './components/pages/home/Index'

export default () => (
    <div className="App">
        <div className="teste">
            <Card>
             <h1>Menu de navegação</h1>
            </Card>
            <Card className="cardBarraPesquisa">
                <h2>Barra de pesquisa</h2>
            </Card>
        </div>
        <div className="Cards">
            <Card titulo="Nova Categoria" color="#982395">
                <img src={require('./assets/image/adicionar.png')}></img>
                <div className='botoesCards'>
                    <button>Incluir</button>
                </div>
            </Card>
            <Index></Index>
            <Card titulo="Imóveis" color="#982395">
                <img src={require('./assets/image/imoveis.jpg')}></img>
                <div className='botoesCards'>
                    <button>Info</button> &nbsp;&nbsp;&nbsp;
                    <button>Atualizar</button> &nbsp;&nbsp;&nbsp;
                    <button>Excluir</button>
                </div>
            </Card>
            <Card titulo="Veículos" color="#982395">
                <img src={require('./assets/image/veiculos.jpg')}></img>
                <div className='botoesCards'>
                    <button>Info</button> &nbsp;&nbsp;&nbsp;
                    <button>Atualizar</button> &nbsp;&nbsp;&nbsp;
                    <button>Excluir</button>
                </div>
            </Card>
            <Card titulo="Eletrônicos" color="#982395">
                <img src={require('./assets/image/eletronicos.jpg')}></img>
                <div className='botoesCards'>
                    <button>Info</button> &nbsp;&nbsp;&nbsp;
                    <button>Atualizar</button> &nbsp;&nbsp;&nbsp;
                    <button>Excluir</button>
                </div>
            </Card>
            <Card titulo="Alimentício" color="#982395">
                <img src={require('./assets/image/alimenticio.jpg')}></img>
                <div className='botoesCards'>
                    <button>Info</button> &nbsp;&nbsp;&nbsp;
                    <button>Atualizar</button> &nbsp;&nbsp;&nbsp;
                    <button>Excluir</button>
                </div>
            </Card>
            <Card titulo="Esporte e Lazer" color="#982395">
                <img src={require('./assets/image/esporteelazer.jpg')}></img>
                <div className='botoesCards'>
                    <button>Info</button> &nbsp;&nbsp;&nbsp;
                    <button>Atualizar</button> &nbsp;&nbsp;&nbsp;
                    <button>Excluir</button>
                </div>
            </Card>
            <Card titulo="Moda" color="#982395">
                <img src={require('./assets/image/moda.jpg')}></img>
                <div className='botoesCards'>
                    <button>Info</button> &nbsp;&nbsp;&nbsp;
                    <button>Atualizar</button> &nbsp;&nbsp;&nbsp;
                    <button>Excluir</button>
                </div>
            </Card>
            <Card titulo="Viagens" color="#982395">
                <img src={require('./assets/image/viagens.jpg')}></img>
                <div className='botoesCards'>
                    <button>Info</button> &nbsp;&nbsp;&nbsp;
                    <button>Atualizar</button> &nbsp;&nbsp;&nbsp;
                    <button>Excluir</button>
                </div>
            </Card>
        </div>
    </div>
)

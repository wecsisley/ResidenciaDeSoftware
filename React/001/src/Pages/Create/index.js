import React, { useState, useEffect, Component } from 'react';
import { Link, useRouteMatch } from 'react-router-dom'
import axios from 'axios'

import {
  Nav,
  All,
  Main,
  CardAll,
  TituloCategoria,
  ImagemCategoria,
  DescricaoCategoria,
  List,
  menuLink,
} from '../styled'

import api from '../../Services/api'


class Create extends Component {

  constructor(props) {
    super(props)

    this.state = {
      "descricao": "",
      "nome": ""
    }
  }

  changeHandler = (e) => {
    this.setState({ [e.target.name]: e.target.value })
  }

  submitHandler = (e) => {
    e.preventDefault()
    console.log(this.state)
    axios.post('http://residencia-ecommerce.us-east-1.elasticbeanstalk.com/categoria', this.state).then(response => { console.log(response) })
      .catch(error => { console.log(error) })
  }


  render() {

    const { nome, descricao } = this.state;

    return (
      <>
        <Nav>
          <div className='menuNav'>
            <ul >
              <Link class='menuLink' to="/create">
                <List>Cadastrar</List>
              </Link>

              <Link class='menuLink' to="/update">
                <List>Atualizar</List>
              </Link>

              <Link class='menuLink' to="/delete">
                <List>Excluir</List>
              </Link>
            </ul>
          </div>
        </Nav>

        <body>
          <Main>
            <div className='menuNavegacao'>
              <input type='text' placeholder='Sua pesquisa aqui!' className='inputType' />
              <button className='botaoPesquisa'>Pesquisar</button>
            </div>
          </Main>

          <div>
            <form onSubmit={this.submitHandler}>
              <span>Formulário cadastro de categorias</span>
              <input type="text" placeholder="Nome da categoria." name="nome" value={nome} onChange={this.changeHandler} />
              <input type="text" placeholder="Descricao da categoria." name="descricao" value={descricao} onChange={this.changeHandler} />
              <button type='submit'>Cadastrar</button>
            </form>

          </div>
        </body>
      </>
    );
  }
};

export default Create;
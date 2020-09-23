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

class Delete extends Component {

  constructor(props) {
    super(props)

    this.state = {
      "id": "",
    }
  }

  submitHandler = (e) => {
    e.preventDefault()
    console.log(this.state)
    var capturando = document.getElementById("valor").value;
    const id = capturando;
    axios.delete(`http://residencia-ecommerce.us-east-1.elasticbeanstalk.com/categoria/${id}`, this.state).then(response => { console.log(response) })
      .catch(error => { console.log(error) })
  }

  render() {

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
              <input type="text" placeholder="Insira o ID da categoria a ser deletada." id="valor" />
              <input type="submit" onClick="getID()" value="Excluir categoria" />
            </form>
          </div>
        </body>
      </>
    );
  }
};

export default Delete;
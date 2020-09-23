import React, { useState, useEffect } from 'react';
import { Link, useRouteMatch } from 'react-router-dom'
import Card from '../../layout/Card'

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

const Home = () => {

  const [category, setCategory] = useState([])
  const { params } = useRouteMatch();

  useEffect(() => {
    const loadData = () => {
      api.get(`/categoria`).then(response => {
        setCategory(response.data)
      });
    }

    loadData();
  }, [params.category])

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

      <Main>
        <div className='menuNavegacao'>
          <input type='text' placeholder='Sua pesquisa aqui!' className='inputType' />
          <button className='botaoPesquisa'>Pesquisar</button>
        </div>
      </Main>
      <>
        {category.map(item => (
          <All>
              <CardAll>
                <TituloCategoria>{item.nome}</TituloCategoria>
                <DescricaoCategoria>{item.descricao}</DescricaoCategoria>
                <ImagemCategoria></ImagemCategoria>
              </CardAll>
              <div class='buttons'>
                <button>Info</button>
                <button>Update</button>
                <button>Delete</button>
              </div>
          </All>
        )
        )}
      </>
    </>
  );
};

export default Home;

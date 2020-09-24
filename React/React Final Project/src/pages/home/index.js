import React ,{useState,useEffect} from 'react';
import { Link, useRouteMatch} from 'react-router-dom'
import Copyright from '../../components/copyright';
import api from '../../Services/api';
import {FiRefreshCcw,FiTrash2} from 'react-icons/fi'

import {
  Container,
  Nav,
  Card,
  CardAll,
  ImagemCategoria,
  DescricaoCategoria,
  TituloCategoria,
  SearchBar,
  Content,
  List,
  Footer,
} from './style'

const Home = () => {

  const [category, setCategory] = useState([])
  console.log(category)
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
    <Container>
      <Nav>
        <div className='titulo'>
          <h1>Categorias</h1>
        </div>
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
      <SearchBar>
        <div className='menuNavegacao'>
          <input type='text' placeholder='Sua pesquisa aqui!' className='inputType' />
          <button className='botaoPesquisa'>Pesquisar</button>
        </div>
      </SearchBar>
      <Content>
         {category.map(item => (
            <Card>
              <CardAll>
                <TituloCategoria>{item.nome}</TituloCategoria>
                <DescricaoCategoria>{item.descricao}</DescricaoCategoria>
                <ImagemCategoria></ImagemCategoria>
              </CardAll>
                 <div className='button-card' >
                     <Link to='/update' className='refresh'>
                         <FiRefreshCcw size={22} title="Atualizar" />
                     </Link>
                     <Link to='/delete' className='delete'>                                          
                         <FiTrash2 size={22} title="Excluir"/>                            
                     </Link>   
                 </div>         
              </Card>
              )
          )
      }
      </Content>
      </body>
      <Footer >
        <div className='footer-containt'>
          <Copyright />
        </div>
      </Footer>
    </Container>

  );
};

export default Home;

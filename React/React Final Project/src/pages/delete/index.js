import React ,{Component} from 'react';
import { Link} from 'react-router-dom'
import axios from 'axios'
import Copyright from '../../components/copyright';

import {
  Container,
  Nav,
  SearchBar, 
  List,
  Footer,
  } from '../home/style'

  import {Form} from '../delete/style';

class Delete extends Component {

  constructor(props) {
    super(props)

    this.state = {
      id: "",
    }
  }

  submitHandler = (e) => {
    e.preventDefault()
    console.log(this.state)
    var capturando = document.getElementById("valor").value;
    const id = capturando;
    axios.delete(`http://residencia-ecommerce.us-east-1.elasticbeanstalk.com/categoria/${id}`, this.state).then(response => { console.log(response) },alert("Categoria excluida com sucesso!"))
      .catch(error => { console.log(error) })
  }

  render() {

    return (
      <Container>
        <Nav>
        <div className='titulo'>
          <h1>Categorias</h1>
        </div>
          <div className='menuNav'>
            <ul >
              <Link class='menuLink' to="/">
                <List>Home</List>
              </Link>
              <Link class='menuLink' to="/update">
                <List>Atualizar</List>
              </Link>
              <Link class='menuLink' to="/create">
                <List>Cadastrar</List>
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
        <Form>
          <form onSubmit={this.submitHandler}> 
          <div className='header'>
              <span>Formulário exclusão de categorias</span>
           </div>  
           <div className='content'>       
              <input type="text" placeholder="Insira o ID da categoria a ser deletada" id="valor" className='input'/>
              <br></br>
              <button type="submit" className='button-style'>Excluir</button>
            </div>
          </form>
        </Form>
        </body>
        <Footer>
        <div className='footer-containt'>
           <Copyright/>
        </div>
      </Footer>
    </Container>      
    );
  }
};

export default Delete;
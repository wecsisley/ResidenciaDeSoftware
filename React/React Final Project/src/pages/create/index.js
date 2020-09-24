import React, {Component} from 'react';
import { Link} from 'react-router-dom'
import axios from 'axios'
import Copyright from '../../components/copyright'

import {
  Container,
  Nav,  
  SearchBar, 
  List,  
  Footer,
} from '../home/style'

import {Form} from './style';

class Create extends Component {

  constructor(props) {
    super(props)

    this.state = {
      descricao: "",
      nome: ""
    }
  }

  changeHandler = (e) => {
    this.setState({ [e.target.name]: e.target.value })
  }

  submitHandler = (e) => {
    e.preventDefault()
    console.log(this.state)
    axios.post('http://residencia-ecommerce.us-east-1.elasticbeanstalk.com/categoria', this.state).then(response => { console.log(response)},alert("Categoria riada com sucesso"))
      .catch(error => { console.log(error) })
  }


  render() {

    const { nome, descricao } = this.state;

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
              <Link class='menuLink' to="/delete">
                <List>Excluir</List>
              </Link>
            </ul>
          </div>
        </Nav>        
          <SearchBar>
            <div className='menuNavegacao'>
              <input type='text' placeholder='Sua pesquisa aqui!' className='inputType' />
              <button className='botaoPesquisa'>Pesquisar</button>
            </div>
          </SearchBar>
        <Form>
          
            <form onSubmit={this.submitHandler}>
              <div className='header'>
                 <span>Formulário cadastro de categorias</span>
              </div>
              <div className='content'>
                 <input type="text" placeholder="Nome da categoria" name="nome" value={nome} onChange={this.changeHandler} className='input' />
                 <br></br>
                 <input type="text" placeholder="Descrição da categoria" name="descricao" value={descricao} onChange={this.changeHandler} className='input' />
                 <br></br>
                <button type='submit' className='button-style'>Cadastrar</button>
              </div>
            </form>
           
          </Form>   
        <Footer>
        <div className='footer-containt'>
           <Copyright/>
        </div>
      </Footer>
    </Container>        
    );
  }
};

export default Create;
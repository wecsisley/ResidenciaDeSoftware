import React,{Component} from 'react';
import {Link} from 'react-router-dom';
import Copyright from '../../components/copyright';
import axios from 'axios';

import {
  Container,
  Nav,
  SearchBar, 
  List,
  Footer,
  } from '../home/style'

  import {Form} from '../PageUpdate/style'

  class getCategoriaToUpdt extends Component {

    constructor(props) {
      super(props)
  
      this.state = {
        descricao: "",
        id: null,
        nome: ""
      }
    }
  
    changeHandler = (e) => {
      this.setState({ [e.target.name]: e.target.value })
    }
  
    submitHandler = (e) => {
      e.preventDefault()
  
      var capturando = document.getElementById("valor").value;
      const id = capturando;
      axios.put(`http://residencia-ecommerce.us-east-1.elasticbeanstalk.com/categoria/${id}`, this.state).then(response => {console.log(response)},alert("Categoria atualizada com sucesso!"))
      .catch(error =>{console.log(error)})
    }
  
  
    render() {
  
      const { id, nome, descricao} = this.setState

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

            <Link class='menuLink' to="/create">
              <List>Cadastrar</List>
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
              <span>Formulário atualização de categorias</span>
           </div>
           <div className='content'>
              <input type="text" placeholder="Insira o ID da categoria a ser atualizada" id="valor" className='input' />
              <br></br>
              <input type="text" placeholder="Nome da categoria" name="nome" value={nome} onChange={this.changeHandler} className='input' />
              <br></br>
              <input type="text" placeholder="Descrição da categoria" name="descricao" value={descricao} onChange={this.changeHandler} className='input' />
              <br></br>
              <button  type='submit' className='button-style'>Atualizar</button>
           </div>
        </form>              
      </Form>    
      <Footer>
        <div className='footer-containt'>
           <Copyright/>
        </div>
      </Footer>
    </Container>  

    ) 
    }  
}

export default getCategoriaToUpdt;
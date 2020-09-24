import React,{Component} from 'react';
import {FiTrash2,FiRefreshCcw} from 'react-icons/fi';
import {Link} from 'react-router-dom';
import {
    Card,
} from '../Pages/Home/style';

import api from '../Services/api'

class Cards extends Component {
    state = {
        categoria: [],
      }
      async componentDidMount() {
        const response = await api.get('http://residencia-ecommerce.us-east-1.elasticbeanstalk.com/categoria');
        this.setState({ categoria: response.data });
      }
    
      render() {
       const { categoria } = this.state;
       /* const mapaCategoriaId = categoria.map(cat => (
          <div key={cat.id}>
            {cat.id}
          </div>
        ))*/
        const mapaCategoriaNome = categoria.map(cat => (
          <div key={cat.id}>
            {cat.nome}
          </div>
        ))
        const mapaCategoriaDescricao = categoria.map(cat => (
          <div key={cat.id}>
            {cat.descricao}
          </div>
        ))
        return (
            <Card>              
                <div className='header'>                                    
                    {mapaCategoriaNome[1]}
                </div>
                <img src='https://ideiasradicais.com.br/wp-content/uploads/2019/07/maskarad.jpg' alt='minha foto' className='img' />
                   <div className='description'>
                        {mapaCategoriaDescricao[1]}
                    </div>
                    <div className='button-card' >
                     <Link to='/update' className='refresh'>
                         <FiRefreshCcw size={22} />
                     </Link>
                     <Link to='/delete' className='delete'>                                          
                         <FiTrash2 size={22} />                            
                     </Link>   
                     </div>                     
             </Card>
             
        )
        // {mapaCategoriaId[1]}     
    }
}

export default Cards;
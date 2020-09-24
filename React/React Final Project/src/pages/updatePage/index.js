import React from 'react';
import Copyright from '../../components/copyright';
import Toolbar from '@material-ui/core/Toolbar';
import AppBar from '@material-ui/core/AppBar';
import Typography from '@material-ui/core/Typography';
import {Link} from 'react-router-dom';

import {
    Menu,
    MainContainer,
    Header,
    Footer,
} from '../../pages/home/styles';


const Update = () => {
    return(
<MainContainer>
  <Header>    
      <Menu> 
      <AppBar position="relative">
        <Toolbar>          
          <Typography variant="h6" color="inherit" noWrap>
            Categorias
          </Typography> 
          <div className='link-button'>
              <ul>
                  <li>
                      <Link to='/create' className='link'>Criar</Link>
                  </li>
                  <li>
                      <Link to='/update' className='link'>Atualizar</Link>
                  </li>
                  <li>
                      <Link to='/delete' className='link'>Excluir</Link>
                  </li>
              </ul>
              </div>         
        </Toolbar>
    </AppBar>
    </Menu>
   </Header> 
  <Footer>  
    <Typography variant="subtitle1" align="center" color="textSecondary" component="p" >
        Colocar links ou outras coisas aqui!
    </Typography>
        <Copyright />
  </Footer> 
</MainContainer>
   
     )
};

export default Update;
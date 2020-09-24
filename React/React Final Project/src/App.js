import React from 'react';
import { BrowserRouter, Switch, Route } from 'react-router-dom'
import Home from './pages/home/index'
import Delete from './pages/delete/index'
import Create from './pages/create/index'
import Update from './pages/PageUpdate/index'


const App = () => {
  return (
    <>
      <BrowserRouter>
        <Switch>
          <Route path="/" exact component={Home} />
                  
          <Route path="/delete" component={Delete} />
          
          <Route path="/create" component={Create} />

          <Route path="/update" component={Update} />
        </Switch>
      </BrowserRouter>
    </>
  );
}

export default App;
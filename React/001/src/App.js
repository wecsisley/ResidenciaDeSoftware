import React from 'react';
import reactdom from 'react-dom'
import { BrowserRouter, Switch, Route } from 'react-router-dom'
import Home from './Pages/Home'
import Delete from './Pages/Delete/index'
import Create from './Pages/Create/index'
import Update from './Pages/PageUpdate'
import Card from './layout/Card'

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

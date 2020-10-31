import React from 'react';
import './App.css';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import DisplayPaintings from './components/DisplayPaintings';
import Header from './components/Header';

function App() {
  return (
    <div className="App">
      <Router>
        <Header />
        <div className="container">
          <Switch>
            <Route path="/paintings" component={DisplayPaintings}></Route>
            <DisplayPaintings />
          </Switch>
        </div>
      </Router>
    </div>
  );
}

export default App;

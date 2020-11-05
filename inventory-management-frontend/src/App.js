import React from 'react';
import './App.css';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import DisplayPaintings from './components/DisplayPaintings';
import Header from './components/Header';
import AddPaintingForm from './components/AddPaintingForm';

function App() {
  return (
    <div className="App">
      <Router>
        <Header />
        <div className="container">
          <Switch>
            <Route path="/paintings" component={DisplayPaintings}></Route>
            <Route path="/add-single-painting" component={AddPaintingForm}></Route>
          </Switch>
        </div>
      </Router>
    </div>
  );
}

export default App;

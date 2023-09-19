import React from 'react';
import './App.css';
import { HomePage } from './layouts/HomePage/HomePage';
import { Footer } from './layouts/NavbarAndFooter/Footer';
import { Navbar } from './layouts/NavbarAndFooter/Navbar';
import { SearchBooksPage } from './layouts/SearchBooksPage/SearchBooksPage';
import { Redirect, Route, Switch } from 'react-router-dom';




export const App = () => {

 return (
  <div>
  <Navbar/>
  <Switch>

      <Route path="/"exact>
        <Redirect to="/home"/>
      </Route>

      <Route path="/home">
        <HomePage/>
      </Route>

      <Route path="/search">
        <SearchBooksPage/>
      </Route>  

  </Switch>
  <Footer/>
  </div>

 )
}

import React from 'react';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import { createBrowserHistory } from 'history';

import HomePage from './pages/HomePage';
import RecommendedPage from './pages/RecommendedPage';
import PageNotFound from './pages/PageNotFound';
import Login from './pages/Login';
import { StateProvider } from './StateProvider';
import PrivateRoute from './components/PrivateRoute/PrivateRoute';

import './App.scss';


const history = createBrowserHistory()

function App() {
  return (
    <StateProvider>
      <div className="App">
        <Router>
          <Switch>
              <Route history={history} path="/login" component={Login} />
              <PrivateRoute history={history} path="/recommended" exact component={RecommendedPage} />
              <PrivateRoute history={history} path="/" component={HomePage} />
              <Route key="404" status={404} component={PageNotFound} />
          </Switch>
        </Router>
      </div>
    </StateProvider>
  );
}

export default App;

import React from 'react';
// import LoginForm from '../components/LoginForm/LoginForm';
import { useStateValue, AuthData } from '../StateProvider';
import { withRouter } from "react-router";
// import { getItem } from '../utils/localStorage';


const Login = withRouter(({ history }) => {
  const dispatch = useStateValue()[1];

  const setAuthState = (payload: AuthData) => {
    dispatch({
      type: 'AUTH',
      payload, 
    })
  }

  const changeLocation = () => {
    const { location } = history;
    if (location.state && location.state.nextPathname) {
      history.push(location.state.nextPathname)
    } else {
      history.push('/')
    }
  };
 
  return (
    <div className="">
      <h1>Hello, stranger</h1>
      {/* <LoginForm changeLocation={changeLocation} setAuthState={setAuthState} /> */}
    </div>
  );  
});

export default Login;
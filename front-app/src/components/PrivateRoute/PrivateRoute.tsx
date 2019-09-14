import React from 'react'
import {
  Route,
  Redirect,
} from 'react-router-dom'
// import { History } from 'history';

import { withRouter, RouteComponentProps } from 'react-router';
// import { useStateValue } from '../../StateProvider';
import { getItem } from '../../utils/localStorage';

interface Props extends RouteComponentProps {
// interface Props extends RouterProps {
  component: any;
  path: string,
  history: any,
}


type PropsType = RouteComponentProps & {
  component: any;
  path: string,
  history: any,
}

const PrivateRoute = withRouter<any, any>(({ history, component, ...rest }:Props) => {
  // const stateValue:any = useStateValue();
  // const [{ auth }] = useStateValue();
  const Component = component;

  const location = {
    pathname: '/login',
    state: { nextPathname: history.location.pathname }
  }

  const authData = getItem('auth');

  return (<Route exact {...rest} render={(props) => (
    authData && authData.userId
    // auth.isAuthorized === true
        ? <Component {...props} />
        : <Redirect to={location} />
    )}
  />)
});

export default PrivateRoute;
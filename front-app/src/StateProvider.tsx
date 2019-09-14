import React, {createContext, useContext, useReducer} from 'react';

export interface AuthData {
    [key: string]: any,
    isAuthorized: boolean,
    authToken?: string,
    userName: string,
    userId: string,
    email: string,
}

interface State {
  auth: AuthData,
}

interface Action {
  type: string,
  payload: any,
  // payload: {
  //   [key: string]: any,
  // }
}
type Reducer = (state:State, action:Action) => State;

const initState = {
  auth: {
    isAuthorized: false,
    authToken: '',
    userName: '',
    userId: '',
    email: '',
  }
}

export const reducer:Reducer = (state:State, action:Action):State => {
  switch (action.type) {
    case 'AUTH':
      return {
        ...state,
        auth: action.payload
      };

    default:
      return state;
  }
};

export const StateContext = createContext({});

export const StateProvider = ({ initialState = initState, children } : {
  // reducer: Reducer,
  initialState?: State,
  children?: any,
}) =>(
  <StateContext.Provider value={useReducer(reducer, initialState)}>
    {children}
  </StateContext.Provider>
);

export const useStateValue = ():any => useContext(StateContext);
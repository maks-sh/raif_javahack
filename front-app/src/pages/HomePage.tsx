import React from 'react';
import { Button, Colors } from 'storybook-directual';

import { withRouter } from "react-router";


const HomePage = withRouter(({ history }) => {
  const startNewSplit = (): void => {
    history.push('/newSplit');
  };

  return (
    <div className="content-wrapper main">
        <h1 className="Header_32-40_Black">Главная страница</h1>
        <Button>sdsd</Button>
    </div>
  );
});

export default HomePage;
import React from 'react';
// import { Button, Colors, AccentButton, Modal } from 'storybook-directual';

import { withRouter } from "react-router";
import PageHeader from '../components/PageHeader/PageHeader';
// import HomePageContent from '../components/HomePageContent/HomePageContent';


const HomePage = withRouter(({ history }) => {
  return (
    <div className="content-wrapper main">
        <PageHeader history={history} headerText="Мои рекомендации"/>
        {/* <HomePageContent /> */}
    </div>
  );
});

export default HomePage;
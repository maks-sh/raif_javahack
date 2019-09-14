import React from 'react';

import { withRouter } from "react-router";
import PageHeader from '../components/PageHeader/PageHeader';
import HomePageContent from '../components/HomePageContent/HomePageContent';


const HomePage = withRouter(({ history }) => {
  return (
    <div className="content-wrapper main">
        <PageHeader history={history} headerText="Личный кабинет"/>
        <HomePageContent />
    </div>
  );
});

export default HomePage;
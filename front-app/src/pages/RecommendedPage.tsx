import React from 'react';
import { withRouter } from "react-router";
import PageHeader from '../components/PageHeader/PageHeader';
import RecommendedPageContent from '../components/RecommendedPageContent';


const HomePage = withRouter(({ history }) => {
  return (
    <div className="content-wrapper main">
        <PageHeader history={history} isRecommendation headerText="Мои рекомендации"/>
        <RecommendedPageContent />
    </div>
  );
});

export default HomePage;
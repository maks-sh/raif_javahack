import React from 'react';
import { Button, Colors, AccentButton, Modal } from 'storybook-directual';

import ModalComponent from '../components/Modal/Modal';
import CreditCards from '../components/CreditCards/CreditCards';
import { withRouter } from "react-router";
import PageHeader from '../components/PageHeader/PageHeader';


const HomePage = withRouter(({ history }) => {
  return (
    <div className="content-wrapper main">
        <PageHeader headerText="Главная страница"/>
        <div className="first-row">
          <CreditCards />
          <div className="user-info">
            <div className="Subheader_14-24_Black">
              Евгений Жучковский
            </div>
            <div  className="">Индивидуальный предприниматель</div>
            <AccentButton className="yellow-btn">Мои реккомендации</AccentButton>
          </div>
        </div>
        <ModalComponent />
    </div>
  );
});

export default HomePage;
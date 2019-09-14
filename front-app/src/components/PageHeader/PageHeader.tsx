import React, { Component } from 'react';
import { Modal as ModalComponent, AccentButton, Button, Badge } from 'storybook-directual';

import './PageHeader.scss';
import raifLogo from './logo-raif.svg';
// import javaHack from './java-hack.jpg';


type Props = {
  history: any;
  headerText: string;
  showNavigation?: boolean;
};

class PageHeader extends Component<Props> {
  static defaultProps: Props;

  navigate = (route: string) => () => {
    this.props.history.push(route);
  }

  render() {
    return (
      <header className="page-header">
        <div className="logos">
          <img className="header-logo raif" src={raifLogo} alt="Райффайзен банк"/>
          {/* <img className="header-logo" src={javaHack} alt="JAVA HACK" /> */}
        </div>
        
        <h1 className="header-text Header_32-40_Black">{this.props.headerText}</h1>

        <div className="navbar">
          <Button className="navbutton" onClick={this.navigate('/')}>Личный кабинет</Button>

          <Badge count={8} className="navbutton">
            <AccentButton onClick={this.navigate('/recommended')} className="yellow-btn">Мои рекомендации</AccentButton>
          </Badge>
        </div>
      
        {/* NAV */}
      </header>
    )
  }
}

export default PageHeader;

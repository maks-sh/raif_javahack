import React, { Component } from 'react';
import { Modal as ModalComponent, AccentButton, Button } from 'storybook-directual';

import './PageHeader.scss';
import raifLogo from './logo-raif.svg';
import javaHack from './java-hack.jpg';


type NavItem = { icon: string, key: string, onAction: () => void }

type Props = {
  headerText: string;
  showNavigation?: boolean;
};

class PageHeader extends Component<Props> {
  static defaultProps: Props;

  render() {
    return (
      <header className="page-header">
        <h1 className="header-text Header_32-40_Black">{this.props.headerText}</h1>
        <div className="logos">
          <img className="header-logo raif" src={raifLogo} alt="Райффайзен банк"/>
          <img className="header-logo" src={javaHack} alt="JAVA HACK" />
        </div>

        {/* NAV */}
      </header>
    )
  }
}

export default PageHeader;

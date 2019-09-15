import React, { Component } from 'react';
import { Modal as ModalComponent, AccentButton, Button } from 'storybook-directual';


type NavItem = { icon: string, key: string, onAction: () => void }

type Props = {
  onClick?: () => void;
  activeTab?: string;
  navList?: Array<NavItem>;
  showNavigation?: boolean;
};

class Modal extends Component<Props> {
  static defaultProps: Props;

  state = {
    show: false,
  }

  showModal = (): void => {
    this.setState({
      show: true,
    });
  };

  hideModal = (): void => {
    this.setState({
      show: false,
    });
  };

  render() {
    return (
      <div>
        <Button onClick={this.showModal}>открыть модалку</Button>

        <ModalComponent
          show={this.state.show}
          header="Hello"
          buttons={[
            <AccentButton key="1111">Create</AccentButton>,
            <Button key="2222" onClick={this.hideModal}>Cancel</Button>,
          ]}
          // onClick={() => {}}
          columnsNumber={1}
          column1={(<p>[Verse 1]</p>)}
          // column2={(<p>[Verse 1]</p>)}
        />
      </div>
    )
  }
}

export default Modal;

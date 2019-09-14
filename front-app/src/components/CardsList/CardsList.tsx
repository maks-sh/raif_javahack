import React, { Component, SyntheticEvent } from 'react';
import { Modal, CardImaged, Button, AccentButton, Tag, IconButton } from 'storybook-directual';

import get from 'lodash/get';

import './index.scss';
import { getDogs } from '../../utils/http';

type Props = {
  recommended: any;
};

class CardsList extends Component<Props> {
  state = {
    message: [],
    showModal: false,
    activeRecomendation: null,
  }

  componentDidMount() {
    getDogs().then((response) => {
      this.setState({
        message: response.message,
      })
      console.log(response)
    })

    this.forceUpdate();
  }

  showModal = (recomendation: any) => (): void => {
    this.setState({
      showModal: true,
      activeRecomendation: recomendation,
    });
  };

  hideModal = (): void => {
    this.setState({
      showModal: false,
      activeRecomendation: null,
    });
  };

  static defaultProps: Props;

  removeRecomendation = (recId:string) => {
    // event.stopPropagation();

    console.log('recId', recId)
  }

  renderMenu = (recId: string) => {
    return (
      <div className="card-controls" onClick={e => {
        e.stopPropagation();
        this.removeRecomendation(recId)
      }}>
        <IconButton onClick={() => {}}
        icon="delete"/>
        {/* <Button>Не интересно</Button> */}
        {/* <AccentButton>Интересно</AccentButton> */}
      </div>
    )
  }

  render() {
    return (
      <div className="recommended-list-wrapper">
        <div className="recommended-list">
          {this.props.recommended.map((rec: any) => (
            <div onClick={this.showModal(rec)}>
              <CardImaged
                image={rec.image}
                header={rec.header}
                headerComment={(
                <div>
                  {rec.headerComment}
                  <div className="card-tags">
                    {rec.tags && rec.tags.map((tag:any) => (
                      <Tag colorGroup={tag.type === 'advert' ? '1-5' : '2-2'}>{tag.text}</Tag>
                    ))}
                  </div>
                </div>)}
                menu={this.renderMenu(rec.id)}
              />
            </div>
          ))}
        </div>

        <Modal
          show={this.state.showModal}
          header={get(this.state,'activeRecomendation.header', '')}
          buttons={[
            <AccentButton className="yellow-btn" key="1111">Сотрудничать</AccentButton>,
            <Button key="2222" onClick={this.hideModal}>Закрыть</Button>,
          ]}
          // onClick={() => {}}
          columnsNumber={1}
          column1={(
            <div>
              <div className="Header_32-40_Black">
                {get(this.state,'activeRecomendation.headerComment', '')}
              </div>
              <div className="card-tags">
                {get(this.state,'activeRecomendation.tags', []).map((tag:any) => (
                  <Tag colorGroup={tag.type === 'advert' ? '1-5' : '2-2'}>{tag.text}</Tag>
                ))}
              </div>
              <p
                style={{
                  marginTop: 25,
                }}
              >
              {get(this.state,'activeRecomendation.fullDescription', '')}</p>
            </div>
          )}
        />
      </div>
    )
  }
}

export default CardsList;

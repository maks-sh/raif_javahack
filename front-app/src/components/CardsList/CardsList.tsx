import React, { Component } from 'react';
import { CardImaged, Button, AccentButton, Tag, IconButton } from 'storybook-directual';
// import ModalComponent from '../Modal/Modal';
import './index.scss';
import { getDogs } from '../../utils/http';

import Aziza from '../HomePageContent/business-woman.jpg'
type Props = {
  recommended: any;
};

class CardsList extends Component<Props> {
  state = {
    message: [],
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

  static defaultProps: Props;
  renderMenu = () => {
    return (
      <div className="card-controls">
        <IconButton onClick={() => console.log('BOT NFR')} icon="delete"/>
        {/* <Button>Не интересно</Button> */}
        {/* <AccentButton>Интересно</AccentButton> */}
      </div>
    )
  }
  // Click = (cardId: string) => () => {
  //   this.setState({
  //     activeCard: cardId, 
  //   })
  // }
  render() {
    console.log('this.state.message', this.state.message);
    console.log('this.props.recommended', this.props.recommended);

    return (
      <div className="recommended-list-wrapper">
        <div className="recommended-list">
          {this.props.recommended.map((rec: any) => (
            <CardImaged
              image={rec.image}
              header={rec.header}
              onClick={() => {console.log('lflflfl')}}
              headerComment={(
              <div>
                {rec.headerComment}
                <div className="card-tags">
                  {rec.tags && rec.tags.map((tag:any) => (
                    <Tag colorGroup={tag.type === 'advert' ? '1-5' : '2-2'}>{tag.text}</Tag>
                  ))}
                </div>
              </div>)}
              menu={this.renderMenu()}
            />
          ))}
        </ div>
      </div>
    )
  }
}

export default CardsList;

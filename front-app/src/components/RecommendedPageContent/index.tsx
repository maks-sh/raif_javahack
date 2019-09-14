import React, { Component } from 'react';
import { AccentButton, Tag, Badge, Tabs, TabPane } from 'storybook-directual';
// import ModalComponent from '../Modal/Modal';
import CreditCards from '../CreditCards/CreditCards';
import './index.scss';
import CardsList from '../CardsList/CardsList';

type Props = {
  headerText: string;
  showNavigation?: boolean;
};


class RecommendedPageContent extends Component<Props> {
  static defaultProps: Props;

  state = {
    recommended: [
      {
        id: '1',
        image: {
          url: 'https://images.dog.ceo/breeds/clumber/n02101556_3333.jpg',
        },
        header: "ИП Мопс Анна Николаевна",
        headerComment: "поставщик шоколада",
        fullDescription: 'текст',
        tags: [
          {text: 'Это реклама', type: 'advert'},
          {text: 'Котики'},
          {text: 'Собачки'},
        ]
      },
      {
        id: '2',
        // image: {
        //   // url: '',
        // },
        header: "ИП Мопс Анна Николаевна",
        headerComment: "поставщик шоколада",
        fullDescription: 'текст',
        tags: [
          {text: 'Котики'},
          {text: 'Собачки'},
        ]
      },
    ]
  }

  onCardClick = (cardId: string) => () => {
    this.setState({
      activeCard: cardId, 
    })
  }

  render() {
    return (
      <div className="recommended-content">
        <Tabs defaultActiveKey="1">
          {/* <TabPane tab={<Badge count={8}>Новые рекомендации</Badge>} tabKey="1"> */}
          <TabPane tab="Новые рекомендации" tabKey="1">
          
            <div className="Header_32-40_Black">Возможные поставщики <Badge count={8}></Badge></div>
            <CardsList recommended={this.state.recommended} />


            {/* <div className="Header_32-40_Black">Возможные покупатели</div>
            <CardsList /> */}
          </TabPane>
          <TabPane tab="Активные рекомендации" tabKey="2">
            <div className="Header_32-40_Black">Активные рекомендации</div>
          </TabPane>
        </Tabs>
      </ div>
    )
  }
}

export default RecommendedPageContent;

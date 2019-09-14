import React, { Component } from 'react';
import { AccentButton, Tag, Badge, Tabs, TabPane } from 'storybook-directual';
// import ModalComponent from '../Modal/Modal';
import CreditCards from '../CreditCards/CreditCards';
import './index.scss';
import CardsList from '../CardsList/CardsList';
import Chat from '../Chat/Chat';
import Table from '../Table/Table';

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
          { text: 'Котики' },
          { text: 'Собачки' },
        ]
      },
    ],
    chats: [
      {
        id: '11',
        user: {
          title: "ИП Мопс Анна Николаевна",
          desc: "поставщик шоколада",
          image: {
            url: 'https://images.dog.ceo/breeds/clumber/n02101556_3333.jpg',
          }
        },
        messages: [
          {
            id: new Date().getTime(),
            timestamp: 1568482760101,
            text: 'Здравствуйте!',
            type: 0,
          },
          {
            id: new Date().getTime(),
            timestamp: 1568482760102,
            text: 'И вам привет от Елены!',
            type: 1
          },
        ]
      },
      {
        id: '22',
        user: {
          title: "ИП Виталик",
          desc: "поставщик муки",
        },
        messages: [
          {
            id: new Date().getTime(),
            timestamp: 1568482760101,
            text: 'Это Елена!',
            type: 1,
          },
          {
            id: new Date().getTime(),
            timestamp: 1568482760102,
            text: 'И вам привет!',
            type: 0,
          },
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
          </TabPane>
          <TabPane tab="Заявки" tabKey="2">
            <div className="Header_32-40_Black">Заявки <Badge count={8}></Badge></div>
            <Table dataSource={[]} columns={[]} />
            {/* <CardsList recommended={this.state.recommended} /> */}
          </TabPane>
          <TabPane tab="Активные сотрудничества" tabKey="3">
            <Chat chats={this.state.chats} />
          </TabPane>
        </Tabs>
      </ div>
    )
  }
}

export default RecommendedPageContent;

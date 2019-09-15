import React, { Component } from 'react';
import { IconButton, Badge, Tabs, TabPane, Tooltip } from 'storybook-directual';
// import ModalComponent from '../Modal/Modal';
import get from 'lodash/get';
import './index.scss';
import CardsList from '../CardsList/CardsList';
import Chat from '../Chat/Chat';
import Table from '../Table/Table';
import { getRecommendations, getCollaborationRequests, changeCollabStatus } from '../../utils/http';


type Props = {
  headerText: string;
  showNavigation?: boolean;
};

// date: "2019-09-15"
// fromUserId: "e2ea2580-c446-4f04-bd76-d7ddedbd4ed9"
// id: "d907d63b-d7ef-416a-a37b-afc57a12ce4b"
// message: ""sadasd""
// status: "PENDING"
// toUserId: "743f885c-d740-11e9-8a34-2a2ae2dbcce4"
// type: "OUT"


class RecommendedPageContent extends Component<Props> {
  static defaultProps: Props;

  collabColumns = [
    // {
    //   title: 'id',
    //   key: 'id',
    //   width: 200,
    //   sortable: false,
    // },
    {
      title: 'Дата',
      key: 'date',
      width: 200,
      sortable: true,
    },
    {
      title: 'От',
      key: 'userFromName',
      width: 200,
      sortable: true,
    },
    {
      title: 'Кому',
      key: 'userToName',
      width: 200,
      sortable: true,
    },
    {
      title: 'Сообщение',
      key: 'message',
      render: (row: any) => (
        <Tooltip message={row.message} placement="bottomLeft">
          <IconButton icon="bubble" />
        </Tooltip>),
      width: 200,
      sortable: true,
    },
  
    {
      title: 'Статус',
      key: 'status',
      width: 200,
      sortable: true,
    },
    {
      title: 'Среднее время ответа',
      key: 'respTime',
      // render: (row: any) => <IconButton icon="close" />,
      width: 200,
      sortable: true,
    },
    {
      title: '',
      key: 'action',
      render: (row: any) => (
        row.type !== 'OUT'
        && <div style={{ display: 'flex' }}>
          <IconButton onClick={this.changeColabStatus('ACCEPTED', row)} icon="done" />
          <IconButton onClick={this.changeColabStatus('REJECTED', row)} icon="close" />
        </div>),
      width: 200,
      sortable: true,
    },
  ]

  state = {
    user: {
      id: '743f885c-d740-11e9-8a34-2a2ae2dbcce4',
    },
    activeKey: '1',
    recommended: [],
    collabRequests: [],
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

  getCollaboraions = () => {
    getCollaborationRequests(this.state.user.id).then(
      res => {
        this.setState({
          collabRequests: res,
        })
      }
    );
  }

  changeColabStatus = (status: string, colab: any) => () => {
    const { fromUserId, toUserId, id } = colab;

    changeCollabStatus(fromUserId, toUserId, id, status).then(res => {
      this.getCollaboraions();
    });
  }

  changeTab = (key: string) => {
    this.setState({
      activeKey: key,
    });

    if (key === '2') {
      this.getCollaboraions();
    }
  }

  componentDidMount() {
    getRecommendations(this.state.user.id).then(res => {
      this.setState({
        recommended: res ? res.map((rec: any, index: number) => ({
          id: rec.id,
          image: {
            url: rec.recommendedUserUrl,
          },
          header: rec.recommendedUserName,
          userId: rec.userId,
          headerComment: rec.description,
          fullDescription: 'текст',
          tags: rec.tags.map((tag: any) => ({text: tag, type: tag === 'Реклама' && 'advert'})),
        }))
        : [],
      });
    });

    this.getCollaboraions();
  }

  onCardClick = (cardId: string) => () => {
    this.setState({
      activeCard: cardId, 
    })
  }

  mapCollabRequest = (req: any) => {
    let reqStatus = 'Ожидание';

    if (req.status === 'ACCEPTED') {
      reqStatus = 'Подтверждена';
    }

    if (req.status === 'REJECTED') {
      reqStatus = 'Отклонена';
    }

    return ({
      ...req,
      status: reqStatus,
      respTime: `${Math.floor(Math.random() * Math.floor(5))} ч.`
    })
  }

  render() {
    const collabReqs = get(this.state,'collabRequests', []);

    const incomingCollabReqs = collabReqs
      .filter((req:any) => req.type !== 'OUT')
      .map(this.mapCollabRequest);
    const outgoingCollabReqs = collabReqs
      .filter((req:any) => req.type === 'OUT')
      .map(this.mapCollabRequest);

    return (
      <div className="recommended-content">
        <Tabs 
          activeKey={this.state.activeKey}
          onChange={this.changeTab}
        >
          <TabPane tab="Новые рекомендации" tabKey="1">
            <div className="Header_32-40_Black">
              Возможные поставщики&nbsp;&nbsp;
              <Badge count={this.state.recommended && this.state.recommended.length} />
            </div>
            <CardsList recommended={this.state.recommended} enrollCb={this.changeTab} />
          </TabPane>

          <TabPane tab="Заявки" tabKey="2" onClick={this.getCollaboraions}>
            {
              !!outgoingCollabReqs.length
              && <>
                <div className="Header_32-40_Black">
                  Заявки, отправленные вами&nbsp;&nbsp;
                  <Badge count={outgoingCollabReqs.length} />
                </div>
          
                <Table dataSource={outgoingCollabReqs} columns={this.collabColumns} />
              </>
            }
            
            {
              !!incomingCollabReqs.length
              && <>
                <div className="Header_32-40_Black">
                  Заявки от других предпринимателей&nbsp;&nbsp;
                  <Badge count={incomingCollabReqs.length} />
                </div>
              
                <Table dataSource={incomingCollabReqs} columns={this.collabColumns.filter(col => col.key !== 'respTime')} />
              </>
            }
           
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

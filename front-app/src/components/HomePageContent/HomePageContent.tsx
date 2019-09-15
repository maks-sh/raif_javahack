import React, { Component } from 'react';
import { Tag, Spinner, Dates } from 'storybook-directual';
// import ModalComponent from '../Modal/Modal';
import CreditCards from '../CreditCards/CreditCards';
import get from 'lodash/get';
import moment from 'moment';

import './index.scss';
import Table from '../Table/Table';
import { getUserCards, getCardTransactions } from '../../utils/http';

type Props = {
  headerText: string;
  showNavigation?: boolean;
};
// amount: 200
// bankMessage: "nice"
// cardId: "aee85a4a-403b-4769-9090-cb0c1273966f"
// changed: "2019-09-15T02:13:59.006"
// date: "2019-09-15"
// id: "2c89e2a0-d745-11e9-8080-808080808080"
// paymentPurpose: "for food2"
// receiverId: "fd6b2d77-6d38-4265-9ca2-56c93c165c8b"
// receiverName: "Vasilij P."
// status: "IN_PROGRESS"

const columns = [
  // {
  //   title: 'id',
  //   key: 'id',
  //   width: 200,
  //   sortable: false,
  // },
  {
    title: 'Дата',
    key: 'changed',
    width: 200,
    sortable: true,
  },
  {
    title: 'Сумма',
    key: 'amount',
    width: 100,
    sortable: true,
  },
  {
    title: 'Назначение платежа',
    key: 'paymentPurpose',
    width: 400,
    sortable: true,
  },
  {
    title: 'Получатель',
    key: 'receiverName',
    width: 200,
    sortable: true,
  },
  {
    title: 'Статус',
    key: 'status',
    width: 200,
    sortable: true,
  },
]

const tags = [
  'Малый бизнес',
  'Торговля',
  'Кондитер',
]

class HomePageContent extends Component<Props> {
  static defaultProps: Props;
  Dates: any;

  constructor(props: Props) {
    super(props);

    // moment.locale('ru');
    Dates.locale = 'ru';
  }

  state = {
    user: {
      id: '743f885c-d740-11e9-8a34-2a2ae2dbcce4',
    },
    activeCard: '',
    cards: [],
    transactions: {},
  }

  componentDidMount() {
    getUserCards(this.state.user.id).then(res => {
      const cardId = get(res, '[0].id', '');

      this.setState({
        cards: res,
      });

      this.onCardClick(cardId)();
    })
  }

  onCardClick = (cardId: string) => () => {
    getCardTransactions(cardId).then(resp => {
      this.setState({
        activeCard: cardId,
        transactions: {
          [cardId]: resp,
        }
      })
    })
  }

  render() {
    const activeCardTransactions: any = 
      get(this.state,`transactions[${this.state.activeCard}]`, [])
      .map((t:any) => (
        {
          ...t,
          status: t.status === 'FINISHED' ? 'Успешно' : 'Обработка',
          changed: moment(t.changed).format('DD/MM/YYYY HH:mm:ss'),
          dateTime: moment(t.changed).unix(),
          amount: `${t.amount} \u20BD`,
        }
      ))
      .sort((t1:any, t2:any) => {
        return (t2.dateTime - t1.dateTime);
      });

    return (
      <>
        <div className="first-row">
          <CreditCards
            activeCard={this.state.activeCard}
            cards={this.state.cards}
            onCardClick={this.onCardClick}
          />

          <div className="user-info">

            <div className="user-photo"/>
            <div className="info-item Subheader_14-24_Black">
              Елена Жуковская
            </div>
            <div className="info-item info-item-sub Subheader_14">Индивидуальный предприниматель</div>

            <div className="user-tags">
              {
                tags.map(tag => (<Tag style={{ color:'#fff' }} colorGroup="2-4">{tag}</Tag>))
              }
            </div>
            {/* <Badge count={8}>
              <AccentButton className="yellow-btn">Мои рекомендации</AccentButton>
            </Badge> */}
          </div>
        </div>

        {
          this.state.activeCard
          && <div className="second-row">
            <div
            style={{ marginBottom: 20, textAlign: 'left' }}
            className="Additional-Header_28-40_Black">
              История операций
            </div>
            {
              !activeCardTransactions
              ? <Spinner size="big" />
              : <Table
                dataSource={activeCardTransactions}
                columns={columns}
              />
            }
          </div>
        }
      </>
    )
  }
}

export default HomePageContent;

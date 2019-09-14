import React, { Component } from 'react';
import { AccentButton, Tag, Badge } from 'storybook-directual';
// import ModalComponent from '../Modal/Modal';
import CreditCards from '../CreditCards/CreditCards';
import './index.scss';

type Props = {
  headerText: string;
  showNavigation?: boolean;
};


const columns= [
  {
    title: 'id',
    key: 'id',
    width: 200,
    sortable: false,
  },
  {
    title: 'name',
    key: 'name',
    width: 200,
    sortable: true,
  },
]

const dataSource:any = {
  '1': [
    {
      id: '1',
      name: '55555',
    },
    {
      id: '2',
      name: '6666',
    },
  ],
  '2': [
    {
      id: '5',
      name: ' 7777777',
    },
    {
      id: '6',
      name: '8888888',
    },
  ],
}

const tags = [
  'Малый бизнес',
  'Торговля',
  'Кондитер',
]

class HomePageContent extends Component<Props> {
  static defaultProps: Props;

  state = {
    activeCard: '1',
    cards: [
      {
        id: '1',
        number: '1234 **** **** 1121',
        name: 'MR. PUPA',
        expiry: '123',
        focused: false,
        cvc: '',
        funds: '58 300 руб.'
        // issuer: 'visa',
      },
      {
        id: '2',
        number: '1234 **** **** 1121',
        name: 'MR. LUPA',
        expiry: '123',
        focused: false,
        cvc: '',
        funds: '124 138 руб.'
        // issuer: 'visa',
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
            <div className="info-item Subheader_14">Индивидуальный предприниматель</div>

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

            <table style={{
              borderSpacing: '0 5px',
            }}>
              <thead style={{
                color:'#8E8E8E',
                fontSize: '18px',
              }}>
                <tr>
                  {columns.map((col) => (
                  <td
                    id={col.key}
                    style={{
                      width: col.width,
                    }}
                    // className="Subheader_14-24_Black"
                  >
                    {col.title}
                  </td>))}
                </tr>
              </thead>

              <tbody>
                {dataSource[this.state.activeCard].map((row: any) => {
                  return (
                    <tr
                      style={{
                        fontSize: '16px',
                      }}
                    >
                     {columns.map((col: any) => (
                      <td
                        id={col.key}
                        style={{
                          width: col.width,
                        }}
                        // className="Subheader_14-24_Black"
                      >
                        {row[col.key]}
                      </td>))}
                    </tr>
                  )
                })}
              </tbody>
            </table>
          </div>
        }
      </>
    )
  }
}

export default HomePageContent;

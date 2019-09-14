import React, { Component } from 'react';

import Cards from 'react-credit-cards';
import './CreditCards.scss';


type Props = {
  // ?: string;
  showNavigation?: boolean;
};

interface Card {
  number: string,
  name: string,
  expiry: string,
  focused: boolean,
  cvc: string,
  color?: string,
}

const colors = [
  'peachyPink', 
  'warmPurple',
  'lightGold',
  'silver',
];

class CreditCards extends Component<Props> {
  static defaultProps: Props;
  state = {
    cards: [
      {
        number: '1234 5678 9101 1121',
        name: 'MR. PUPA',
        expiry: '123',
        focused: false,
        cvc: '',
        // issuer: 'visa',
      },
      {
        number: '1234 5678 9101 1121',
        name: 'MR. LUPA',
        expiry: '123',
        focused: false,
        cvc: '',
        // issuer: 'visa',
      },
    ]
  }
  render() {
    return (
      <div className="cards-container">
        {this.state.cards.map((card: Card, index: number) =>(
          <div className={`color-${colors[index]}`}>
            <Cards  {...card} />
          </div>))}
      </div>
    )
  }
}

export default CreditCards;

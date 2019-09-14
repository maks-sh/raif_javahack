import React, { Component } from 'react';

import Cards from 'react-credit-cards';
import './CreditCards.scss';
import { throwStatement } from '@babel/types';


type Props = {
  // ?: string;
  cards: Card[],
  activeCard: string,
  onCardClick: (id: string) => any,
  showNavigation?: boolean;
};

interface Card {
  id: string,
  number?: string,
  name?: string,
  expiry?: string,
  focused?: boolean,
  cvc?: string,
  color?: string,
  funds?: string,
}

const colors = [
  'peachyPink', 
  'warmPurple',
  'lightGold',
  'silver',
];

class CreditCards extends Component<Props> {
  static defaultProps: Props;

  render() {
    return (
      <div className="cards-container">
        {this.props.cards.map((card: Card, index: number) =>(
          <div
            className={`color-${colors[index]} ${this.props.activeCard === card.id ? 'active-card' : ''}`}
            onClick={this.props.onCardClick(card.id)}
          >
            <Cards  {...card} name={card.funds} />
          </div>))}
      </div>
    )
  }
}

export default CreditCards;

import React, { Component } from 'react';
import { Spinner } from 'storybook-directual';

import get from 'lodash/get';
import Cards from 'react-credit-cards';
import './CreditCards.scss';


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
    const cards = get(this.props, 'cards', []);

    return (
      <div className="cards-container">
        {!cards.length && <Spinner size="big" />}
        {this.props.cards && this.props.cards.map((card: Card, index: number) =>(
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
